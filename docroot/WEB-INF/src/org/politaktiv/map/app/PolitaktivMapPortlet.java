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

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.xml.bind.ValidationException;

import org.politaktiv.infrastructure.liferay.PAParamUtil;
import org.politaktiv.map.domain.MapViewPreferences;
import org.politaktiv.map.domain.PolitaktivMapFactory;
import org.politaktiv.map.domain.PolitaktivMapRepository;
import org.politaktiv.map.domain.UserAction;
import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.Picture;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
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

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException{
		
		String uploadFolderName = getInitParameter("uploadFolder");
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentGroupId(renderRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
// TODO:		verschieben oder eigene methode
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		long currentCompanyId = this.getCurrentCompanyId(renderRequest);
		long currentGroupId = this.getCurrentGroupId(renderRequest);
		long backgroundId = Long.parseLong(renderRequest.getPreferences().getValue("background_id", "0"));
		

	
		Folder pictureFolder;
		
		try {
			
			//if no background is set (initial) create a default map background
			//TODO: doInit() anschauen
			if(backgroundId == 0){
				Background initBackground = repository.createInitialBackground(currentCompanyId,currentGroupId);
				MapViewPreferences mapViewPrefs =  factory.generateMapViewPreferences(0,			//initial values
																						0,
																						1,
																						initBackground.getBackgroundId());
				mapViewPrefs.valide();

				PortletPreferences prefs = renderRequest.getPreferences();
				repository.storeMapViewPreferences(mapViewPrefs, prefs);
				backgroundId = initBackground.getBackgroundId();
			}
			
			//background
			//TODO: in DoView genutzt?
			List<Background> backgroundList = repository.findBackgroundsFromCompanyAndGroupId(currentCompanyId,currentGroupId);
			renderRequest.setAttribute("backgroundList", backgroundList);
		
			//Marker
			List<Marker> backgroundMarkerList = repository.findMarkerByBackgroundId(backgroundId);
			renderRequest.setAttribute("backgroundMarkerList",backgroundMarkerList);
			
			//Picture
			//TODO: in DoView genutzt?
			List<Picture> backgroundPictureList = repository.findPicureByBackgroundId(backgroundId);
			renderRequest.setAttribute("backgroundPictureList",backgroundPictureList);
			
			//picture folder
			createFolderIfItDoesNotExistWithName(uploadFolderName,serviceContext, repositoryId);
			pictureFolder = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
			List<FileEntry> portletFolderFiles = DLAppServiceUtil.getFileEntries(repositoryId, pictureFolder.getFolderId());
			renderRequest.setAttribute("portletFolderFiles", portletFolderFiles);
			renderRequest.setAttribute("pictureFolderId", pictureFolder.getFolderId());
			
			
			//first picture in folder
			String firstFolderFileUuid;
			if(portletFolderFiles.size() >= 1){
				firstFolderFileUuid = portletFolderFiles.get(0).getUuid();
			} else {
				firstFolderFileUuid = "0"; //if no picture exists
			}
			renderRequest.setAttribute("firstFolderFileUuid", firstFolderFileUuid);
		
			super.doView(renderRequest, renderResponse);
		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException{

		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		
		String uploadFolderName = getInitParameter("uploadFolder");
		long currentCompanyId = this.getCurrentCompanyId(renderRequest);
		long currentGroupId = this.getCurrentGroupId(renderRequest);
		
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentGroupId(renderRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		Folder pictureFolder;
		try {
			
			//background
			List<Background> backgroundList = repository.findBackgroundsFromCompanyAndGroupId(currentCompanyId,currentGroupId);
			renderRequest.setAttribute("backgroundList", backgroundList);
			
			//picture folder
			createFolderIfItDoesNotExistWithName(uploadFolderName,serviceContext, repositoryId);
			pictureFolder = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
			List<FileEntry> portletFolderFiles = DLAppServiceUtil.getFileEntries(repositoryId, pictureFolder.getFolderId());
			renderRequest.setAttribute("portletFolderFiles", portletFolderFiles);
			renderRequest.setAttribute("pictureFolderId", pictureFolder.getFolderId());

			include(editTemplate, renderRequest, renderResponse);

		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		
	}
	
	public void createNewBackground(ActionRequest request, ActionResponse response) throws SystemException, ValidationException, PrincipalException{
		try {
			String backgroundImageUuid = PaParamUtil.getNotEmptyString(request, "background_uuid");
			String backgroundName = PaParamUtil.getNotEmptyString(request,"background_name");
			
			long currentCompanyId = this.getCurrentCompanyId(request);
			long currentGroupId = this.getCurrentGroupId(request);
			long currentUserId = this.getCurrentUserId(request);
			
			//TODO nothing? hm..was was the todo for
			Background newBackground = factory.generateBackground(backgroundImageUuid ,backgroundName, currentCompanyId, currentGroupId, currentUserId);
			repository.storeBackground(newBackground, this.getCurrentGroupId(request));
		
		} catch (ValidatorException e) {
			//TODO reaction
			_log.error(e);
		} 
	}
	
	/**
	 * saves a new center in map in edit mode
	 * @throws ValidatorException 
	 * @throws IOException 
	 * @throws PortletException 
	 * @throws SystemException 
	 */
			

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException,PortletException {
	
		//clear response
		response.resetBuffer();
		
		try{
			
			//////////////////////VALIDATION ACTION
			//DATATYPES
			String action = PaParamUtil.getNotEmptyString(request, "action");
			//MODEL: UserAction
			UserAction userAction = factory.generateUserAction(action);
			userAction.validate();
			////////////////////////END VALIDATION
		
			//get current scope information
			long currentUserId = this.getCurrentUserId(request);
			long currentCompanyId = this.getCurrentCompanyId(request);
			long currentGroupId = this.getCurrentGroupId(request);
			
			
			if(userAction.isAddMarker()){
				long currentBackgroundId = Long.parseLong(request.getPreferences().getValue("background_id", ""));
				long markerId = this.addMarker(request, currentUserId, currentCompanyId, currentGroupId, currentBackgroundId);
				response.getWriter().print(markerId);
				
			} else if(userAction.isDeleteMarker()){
				long deleteMarkerId = PaParamUtil.getLong(request, "markerId");
				_log.info("try to delete marker withId" + deleteMarkerId);
				repository.deleteMarker(deleteMarkerId,currentUserId, currentGroupId,this.getCurrentPortletId(request));
				response.getWriter().print("success");
			
			} else if(userAction.isAddBackground()){
				this.addBackground(request, currentUserId, currentCompanyId,currentGroupId);
				
			} else if(userAction.isDeleteBackground()){
				long deleteBackgroundId = PaParamUtil.getLong(request, "background_id_delete");
				repository.deleteBackground(currentGroupId, deleteBackgroundId);
				
			} else if(userAction.isSaveCenterAndZoom()){
				 this.saveCenterAndZoom(request);
	
			} else if(userAction.isAddPicture()){
				long currentBackgroundId = Long.parseLong(request.getPreferences().getValue("background_id", ""));
				this.addPicture(request, currentUserId, currentCompanyId, currentGroupId, currentBackgroundId);
			
			} else if(userAction.isDeletePicture()){
				long deletePictureId = PaParamUtil.getLong(request, "remove_picture_id");
				repository.deletePicture(currentGroupId, currentUserId,deletePictureId,this.getCurrentPortletId(request));
			}
			
			} catch (ValidatorException e){
				_log.error("Validator Exception: " + e.getMessage());
				response.getWriter().print(e.getMessage());
			} catch (SystemException e) {
			} catch (PrincipalException e) {
				_log.error("Principal Exception: " + e.getMessage());
				response.getWriter().print(e.getMessage());
			} catch (PortalException e) {
		} catch (ValidationException e) {
			_log.error("Validation Exception: " + e.getMessage());
				e.printStackTrace();
			}
	}

	private void addPicture(ResourceRequest request, long currentUserId,
			long currentCompanyId, long currentGroupId, long backgroundId)
			throws ValidatorException, SystemException, PrincipalException {
		Double pictureWidth = PaParamUtil.getDouble(request, "map_picture_width");
		Double pictureHeight = PaParamUtil.getDouble(request, "map_picture_height");
		Double pictureXPos = PaParamUtil.getDouble(request, "map_picture_xpos");
		Double pictureyPos = PaParamUtil.getDouble(request, "map_picture_ypos");
		long pictureRotation = PaParamUtil.getLong(request, "map_picture_rotation");
		Double pictureResolution = PaParamUtil.getDouble(request, "map_picture_resolution");
		Double pictureOpacity = PaParamUtil.getDouble(request, "map_picture_opacity");
		String picturefileUuid = PaParamUtil.getNotEmptyString(request, "map_picture_fileuuid");
		String pictureName = PaParamUtil.getNotEmptyString(request, "map_picture_name");
		String pictureDesciption = PaParamUtil.getNotEmptyString(request, "map_picture_description");
		String pictureLink = PaParamUtil.getNotEmptyString(request, "map_picture_link");
		
		Picture newPicture = factory.generatePicture(currentCompanyId, currentGroupId, currentUserId, pictureWidth, pictureHeight, pictureXPos, pictureyPos,pictureResolution, pictureRotation, pictureOpacity,
				picturefileUuid, pictureName, pictureDesciption, pictureLink,backgroundId);
		
		repository.storePicture(newPicture, currentGroupId);
	}

	private void saveCenterAndZoom(ResourceRequest request) throws ValidatorException, SystemException, ReadOnlyException,	IOException {
		 double lon_center = PaParamUtil.getDouble(request,"lon_center");
		 double lat_center = PaParamUtil.getDouble(request,"lat_center");
		 int zoom_center = ParamUtil.getInteger(request, "zoom_center"); //TODO: use PaParamUtil
		 long backround_id = PaParamUtil.getLong(request, "background_id");
		 
		 System.out.println("saveCenterAndZoom: " + lon_center + lat_center + zoom_center + backround_id);
		 
		 MapViewPreferences mapViewPrefs =  factory.generateMapViewPreferences(lon_center,
				 																lat_center,
				 																zoom_center,
				 																backround_id);

		 mapViewPrefs.valide();
		 
		 PortletPreferences prefs = request.getPreferences();
		 repository.storeMapViewPreferences(mapViewPrefs, prefs);
	}

	private void addBackground(ResourceRequest request, long currentUserId,
			long currentCompanyId, long currentGroupId)
			throws ValidatorException, SystemException, ValidationException,
			PrincipalException {
		String background_uuid = PaParamUtil.getNotEmptyString(request, "background_uuid");
		String background_name = PaParamUtil.getNotEmptyString(request, "background_name");
		Background newBackground = factory.generateBackground(background_uuid, background_name, currentCompanyId, currentGroupId, currentUserId);
		repository.storeBackground(newBackground, currentGroupId);
	}

	
	private long addMarker(ResourceRequest request, long currentUserId, long currentCompanyId, long currentGroupId, long backgroundId) throws ValidatorException, SystemException,
			PortalException, PrincipalException {
		//////////////////////VALIDATION MAP OBJECT INPUT
		//DATATYPES
		String name = PaParamUtil.getNotEmptyString(request, "name");
		String description = PaParamUtil.getNotEmptyString(request, "description");
		String link = PaParamUtil.getNotEmptyString(request, "link");
		////////////////////////END VALIDATION
		//MODEL validation in Repository	
		double lon = PaParamUtil.getDouble(request, "lon");
		double lat = PaParamUtil.getDouble(request, "lat");
		Marker marker = factory.generateMarker(currentGroupId,currentCompanyId, currentUserId, backgroundId, lon, lat, name, description, link);
		repository.storeMarker(marker, this.getCurrentGroupId(request));
		return marker.getMarkerId();
	
	}

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
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(this.getCurrentGroupId(actionRequest), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		FileInputStream fis = new FileInputStream(theFile);
			
		createFolderIfItDoesNotExistWithName(uploadFolderName,serviceContext, repositoryId);
		
		//get folder
		Folder uploadFolder = DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName);
		long folderId = uploadFolder.getFolderId();
		
		//add entry
		
		//TODO validation inside this object?
		DLAppServiceUtil.addFileEntry(repositoryId,
				folderId,
				fileName,
				new MimetypesFileTypeMap().getContentType(theFile), //TODO: better lib? does not work
				fileName,
				description,
				changeLog,
				fis,
				fileSize,
				serviceContext);		
	}

	private void createFolderIfItDoesNotExistWithName(String uploadFolderName,ServiceContext serviceContext, long repositoryId) throws SystemException, PortalException {
	
		//TODO: there should be a more elegant way to check if a folder does not exist
		try {
			//try to get folder
			DLAppServiceUtil.getFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,uploadFolderName);
		} catch (PortalException e) {
			//create it if does not exist
			DLAppServiceUtil.addFolder(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, uploadFolderName, "politaktiv map", serviceContext);
		}			
	}
	
	private long getCurrentCompanyId(PortletRequest portletRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getCompanyGroupId();
	}

	private long getCurrentUserId(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getUserId();
	}
	
	private long getCurrentGroupId(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY); 
		
		return themeDisplay.getScopeGroupId();
	}
	
	 private String getCurrentPortletId(PortletRequest portletRequest) {
		 ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
		 .getAttribute(WebKeys.THEME_DISPLAY);
		 return themeDisplay.getPortletDisplay().getId();
	} 
}
