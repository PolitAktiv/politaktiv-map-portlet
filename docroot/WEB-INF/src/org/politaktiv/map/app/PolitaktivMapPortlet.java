/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.politaktiv.map.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.politaktiv.infrastructure.liferay.PAParamUtil;

import org.politaktiv.map.domain.MapObject;
import org.politaktiv.map.domain.MapViewPreferences;
import org.politaktiv.map.domain.UserAction;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class PolitaktivMapPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(PolitaktivMapPortlet.class);
	PolitaktivMapRepository repository = new PolitaktivMapRepository();
	PolitaktivMapFactory factory = new PolitaktivMapFactory();
	PAParamUtil PaParamUtil = new PAParamUtil();

	public void fileUpload(ActionRequest actionRequest, ActionResponse actionResponse) throws FileNotFoundException, SystemException, PortalException{
		
		String uploadFolderName = getInitParameter("uploadFolder");
     
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File theFile = uploadRequest.getFile("form_file");
		
		String fileName = uploadRequest.getFileName("form_file");
		long fileSize = uploadRequest.getSize("form_file");
		
		String description = StringPool.BLANK;
		String changeLog = StringPool.BLANK;
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		
		
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentCommunityId(actionRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		FileInputStream fis = new FileInputStream(theFile);
			
		createFolderIfItDoesNotExistWithName(uploadFolderName,serviceContext, repositoryId);
		
		//get folder
		Folder uploadFolder = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
		long folderId = uploadFolder.getFolderId();
		
		//add entry
		DLAppServiceUtil.addFileEntry(repositoryId,
				folderId,
				fileName,
				"mimeType",
				fileName,
				description,
				changeLog,
				fis,
				fileSize,
				serviceContext);		
	}

	private void createFolderIfItDoesNotExistWithName(String uploadFolderName,ServiceContext serviceContext, long repositoryId) throws SystemException, PortalException {

		try {
			//try to get folder
			DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,uploadFolderName);
		} catch (PortalException e) {
			//create it if does not exist
			DLAppServiceUtil.addFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName, "politaktiv map", serviceContext);
		}			
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException{
//		
		String uploadFolderName = getInitParameter("uploadFolder");
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentCommunityId(renderRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		try{
			Folder pictureFolder = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
			List<FileEntry> portletFolderFiles = DLAppServiceUtil.getFileEntries(repositoryId, pictureFolder.getFolderId());
			
			renderRequest.setAttribute("portletFolderFiles", portletFolderFiles);
		
			include(editTemplate, renderRequest, renderResponse);
		
		
		} catch (PortalException e) {
			throw new PortletException();
		} catch (SystemException e) {
			throw new PortletException();
		} catch (IOException e) {
			throw new PortletException();
		} catch (PortletException e) {
			throw new PortletException();
		}
	}
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException{
		
		String uploadFolderName = getInitParameter("uploadFolder");
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentCommunityId(renderRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		long currentGroupId = themeDisplay.getLayout().getGroupId();
		long currentCompanyId = themeDisplay.getLayout().getCompanyId();	

		try {
			createFolderIfItDoesNotExistWithName(uploadFolderName,serviceContext, repositoryId);
		
			List<MapObject> communityMapObjectList = repository.getAllMapObjectFromCompanyIdAndGroupId(currentCompanyId, currentGroupId);
			System.out.println("communityMapObjectList size: " + communityMapObjectList.size()); //TODO: remove
			renderRequest.setAttribute("mapObjectListFromCommunityOnly",communityMapObjectList);
			
			//get pictures from upload folder
			Folder pictureUploadFolderFiles = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
			List<FileEntry> portletUploadFolderFiles = DLAppServiceUtil.getFileEntries(repositoryId, pictureUploadFolderFiles.getFolderId());
		
			_log.debug(portletUploadFolderFiles.toArray().toString());
			renderRequest.setAttribute("portletUploadFolderFiles", portletUploadFolderFiles);
	
			super.doView(renderRequest, renderResponse);
		} catch (SystemException e) {
			e.printStackTrace(); //TODO: remove
		} catch (PortalException e) {
			e.printStackTrace(); //TODO: remove
		}
	}
	
	/**
	 * saves a new center in of map in edit mode (for administrator only)
	 * @throws ValidatorException 
	 * @throws IOException 
	 * @throws PortletException 
	 */
			
public void saveCenterAndBackground(ActionRequest request, ActionResponse response) throws IOException, PortletException {

		try {//save new center to preferences
			
			 PortletPreferences prefs = request.getPreferences();
			 double lon_center = PaParamUtil.getDouble(request,"lon_center");
			 double lat_center = PaParamUtil.getDouble(request,"lat_center");
		     int zoom_center = PaParamUtil.getInt(request,"zoom_center");
		     System.out.println("backgroundSelect is " + ParamUtil.getString(request, "backgroundSelect")); // TODO: remove
		     String background = ParamUtil.getString(request, "background_url");
		     System.out.println("background is: " + background);
		     
		     MapViewPreferences mapViewPrefs =  factory.generateMapViewPreferences(lon_center,
		    		 																lat_center,
		    		 																zoom_center,
		    		 																background);
		     //TO DO: use mapViewPrefs directly to save
		     mapViewPrefs.valide();
		     
		     prefs.setValue("lon_center", Double.toString(mapViewPrefs.getLon()));
		     prefs.setValue("lat_center", Double.toString(mapViewPrefs.getLat()));
		     prefs.setValue("zoom_center", Integer.toString(mapViewPrefs.getZoom()));
		     System.out.println("mapViewPrefs.getBackground() is" +mapViewPrefs.getBackground());
		     prefs.setValue("background_url", mapViewPrefs.getBackground()); 
		     prefs.store();
		
		
		} catch (ValidatorException e) {
			SessionErrors.add(request, e.getMessage());
		}


		//after saving go to view mode again (the default view, not the preferences view)
		response.setPortletMode(PortletMode.VIEW);
			
		}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException,PortletException {
	
		//clear response
		response.resetBuffer();
		try{
			
			//////////////////////VALIDATION
			//DATATYPES
			String action = PaParamUtil.getNotEmptyString(request, "action");
			String onType = PaParamUtil.getNotEmptyString(request, "type");
			//MODEL: UserAction
			UserAction userAction = factory.generateUserAction(action,onType);
			userAction.validate();
			////////////////////////END VALIDATION
		
			//get current scope information
			long currentUserId = this.getCurrentUserId(request);
			long currentCompanyId = this.getCurrentCompanyId(request);
			long currentCommunityId = this.getCurrentCommunityId(request);
			
			if(userAction.isAddAction()){
				
				//////////////////////VALIDATION
				//DATATYPES
				String name = PaParamUtil.getNotEmptyString(request, "name");
				String description = PaParamUtil.getNotEmptyString(request, "description");
				String link = PaParamUtil.getNotEmptyString(request, "link");
				double lon = PaParamUtil.getDouble(request, "lon");
				double lat = PaParamUtil.getDouble(request, "lat");
				////////////////////////END VALIDATION
				//MODEL validation in Repository
				
				long mapObjectId = this.addMapObject(currentCommunityId,currentCompanyId, currentUserId, onType, lon, lat, name, description, link);
				response.getWriter().print(mapObjectId);
				
				//TODO: mapobject, means: more individual actions (addMarker, addPicture...)
			} else if(userAction.isDeleteAction()){
			
				long mapObjectId = PaParamUtil.getLong(request, "mapObjectId");
				
				System.out.println("Ich entferne jetzt mapObject mit id: " + mapObjectId); //TODO: remove
				this.deleteMapObject(currentCommunityId,currentCompanyId,this.getCurrentPortletId(request), currentUserId,mapObjectId);
				 response.getWriter().print("success");
		}
			
			
		} catch (ValidatorException e){
			_log.error("Validator Exception: " + e.getMessage());
			response.getWriter().print(e.getMessage());
		} catch (SystemException e) {
		} catch (PrincipalException e) {
			_log.error("Principal Exception: " + e.getMessage());
			response.getWriter().print(e.getMessage());
		} catch (PortalException e) {
		}
		
		
		
		
	
	}


	private void deleteMapObject(long currentCommunityId, long currentCompanyId, String currentPortletId,
			long currentUserId, long markerId) throws SystemException, ValidatorException, PortalException {
		
		repository.deleteMapObjectWithId(markerId, currentCommunityId, currentCompanyId, currentPortletId, currentUserId);
		
	}

	private long addMapObject(long groupId, long companyId, long userId, String onType, double lon, double lat, String title, String description, String link) throws SystemException, PortalException, ValidatorException{
		MapObject mapObject = factory.generateNewMapObject(companyId,groupId, userId, onType, lon, lat, title, description, link);
		
		return repository.saveMapObject(mapObject);
		
	}
	
	private long getCurrentUserId(ResourceRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getUserId();
	}
	
	private long getCurrentCommunityId(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getLayout().getGroupId();
	}
	
	private long getCurrentCommunityId(ResourceRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getLayout().getGroupId();
	}
	
private long getCurrentCommunityId(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getLayout().getGroupId();
	}
	
	private long getCurrentCompanyId(ResourceRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getLayout().getCompanyId();
	}
	
	private String getCurrentPortletId(ResourceRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getPortletDisplay().getId();
	}
}
