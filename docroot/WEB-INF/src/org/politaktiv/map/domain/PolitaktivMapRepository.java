/**
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.politaktiv.map.domain;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;
import javax.xml.bind.ValidationException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.BackgroundServiceUtil;
import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.MarkerServiceUtil;
import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.PictureServiceUtil;


public class PolitaktivMapRepository {
	
	public void storeMapViewPreferences(MapViewPreferences mapViewPrefs,
			PortletPreferences prefs) throws ValidatorException, IOException, ReadOnlyException, SystemException {
		
		 mapViewPrefs.valide();
		
		 prefs.setValue("lon_center", Double.toString(mapViewPrefs.getLon()));
	     prefs.setValue("lat_center", Double.toString(mapViewPrefs.getLat()));
	     prefs.setValue("zoom_center", Double.toString(mapViewPrefs.getZoom()));
	     prefs.setValue("background_id", Long.toString(mapViewPrefs.getBackgroundId()));
	     prefs.store();
		
	}
	
	public List<Background> findBackgroundsFromCompanyAndGroupId(
			long currentCompanyId, long currentGroupId) throws SystemException {
		
		return BackgroundServiceUtil.findBycompanyIdAndGroupId(currentCompanyId, currentGroupId);

	}



	public Background storeBackground(Background newBackground, long groupId) throws ValidationException, SystemException, PrincipalException {
		
		return BackgroundServiceUtil.addBackground(newBackground, groupId);
	}




	public Marker storeMarker(Marker marker, long groupId) throws PrincipalException, SystemException, ValidatorException {
		
		return MarkerServiceUtil.addMarker(marker, groupId);
		
	}

	public List<Marker> findMarkerByBackgroundId(long backgroundId) throws SystemException{
		
		return MarkerServiceUtil.findMarkerByBackgroundId(backgroundId);
	}

	public void storePicture(Picture picture, long groupId) throws PrincipalException, SystemException, ValidatorException {
		PictureServiceUtil.addPicture(picture, groupId);
		
	}

	public List<Picture> findPicureByBackgroundId(long backgroundId) throws SystemException {
		return PictureServiceUtil.findByBackgroundId(backgroundId);
	}

	public void deleteBackground(long currentGroupId, long deleteBackgroundId) throws PortalException, SystemException {
		BackgroundServiceUtil.deleteBackground(deleteBackgroundId,currentGroupId);
		List<Picture> deletePicturesList = PictureLocalServiceUtil.findByBackgroundId(deleteBackgroundId);
		
		for(Picture picture:deletePicturesList){
			PictureLocalServiceUtil.deletePicture(picture);
		}
		List<Marker> deleteMarkerList = MarkerLocalServiceUtil.findMarkerByBackgroundId(deleteBackgroundId);
		
		for(Marker marker:deleteMarkerList){
			MarkerLocalServiceUtil.deleteMarker(marker);
		}
		
	}

	public void deletePicture(long currentGroupId, long userId, long deletePictureId, String portletId) throws PortalException, SystemException {
		PictureServiceUtil.deletePicture(deletePictureId, userId, currentGroupId, portletId);
		
	}

	public Background createInitialBackground(long currentCompanyId, long currentGroupId) throws SystemException {
		Background background = BackgroundLocalServiceUtil.createBackground(CounterLocalServiceUtil.increment());
		background.setCompanyId(currentCompanyId);
		background.setGroupId(currentGroupId);
		background.setName("Standardkarte");
		background.setUserId(0);
		background.setFileEntryUuid("map");
		
		return BackgroundLocalServiceUtil.addBackground(background);
	}

	public void deleteMarker(long deleteMarkerId, long userId, long groupId, String portletId) throws PortalException, SystemException, ValidatorException {
		MarkerServiceUtil.deleteMarker(deleteMarkerId,userId, groupId, portletId);
		
	}
}
