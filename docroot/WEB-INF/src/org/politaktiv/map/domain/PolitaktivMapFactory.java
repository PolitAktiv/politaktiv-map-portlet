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

package org.politaktiv.map.domain;

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


public class PolitaktivMapFactory {

	public PolitaktivMapFactory(){		
	}
	
	public MapViewPreferences generateMapViewPreferences(double lon, double lat, int zoom, long mapId){
		return new MapViewPreferences(lon, lat, zoom, mapId);
	}

	public UserAction generateUserAction(String markerAction) {
	
		return new UserAction(markerAction);
	}
		
	public Marker generateMarker(long companyId, long groupId, long userId, long backgroundId, double lon, double lat, String name,
											String description, String referenceUrl)
													throws SystemException, PortalException {
		
		Marker marker = MarkerLocalServiceUtil.createMarker(CounterLocalServiceUtil.increment());
		
		marker.setCompanyId(companyId);
		marker.setGroupId(groupId);
		marker.setUserId(userId);
		
		marker.setName(name);
		marker.setDescription(description);
		marker.setReferenceUrl(referenceUrl);
		
		marker.setBackgroundId(backgroundId);
		marker.setLongitude(lon);
		marker.setLatitude(lat);
		


		
		
		return marker;
	}

	public Background generateBackground(String backgroundImageUuid,
			String backgroundName, long companyId, long groupId, long userId) throws SystemException {
		Background background = BackgroundLocalServiceUtil.createBackground(CounterLocalServiceUtil.increment());
		background.setFileEntryUuid(backgroundImageUuid);
		background.setName(backgroundName);
		background.setCompanyId(companyId);
		background.setGroupId(groupId);
		background.setUserId(userId);
		
		return background;
	}

	public Picture generatePicture(long currentCompanyId, long currentGroupId, long currentUserId, Double pictureWidth, Double pictureHeight,
			Double pictureXPos, Double pictureyPos, Double pictureResolution, long pictureRotation, Double pictureOpacity, String picturefileUuid, String pictureName,
			String pictureDesciption, String pictureLink,long backgroundId) throws SystemException {
		
		Picture picture = PictureLocalServiceUtil.createPicture(CounterLocalServiceUtil.increment());
		picture.setCompanyId(currentCompanyId);
		picture.setGroupId(currentGroupId);
		picture.setUserId(currentUserId);
		picture.setWidth(pictureWidth);
		picture.setHeight(pictureHeight);
		picture.setLatitude(pictureXPos);
		picture.setLongitude(pictureyPos);
		picture.setResolution(pictureResolution);
		picture.setRotation(pictureRotation);
		picture.setOcupacy(pictureOpacity);
		picture.setFileEntryUuid(picturefileUuid);
		picture.setName(pictureName);
		picture.setDescription(pictureDesciption);
		picture.setReferenceUrl(pictureLink);
		picture.setBackgroundId(backgroundId);
		
		return picture;
	}
	
	
}
