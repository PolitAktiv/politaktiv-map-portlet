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

import java.util.ArrayList;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.politaktiv.map.domain.MapObject;
import org.politaktiv.map.domain.MapViewPreferences;
import org.politaktiv.map.domain.Marker;
import org.politaktiv.map.domain.UserAction;
import org.politaktiv.map.infrastructure.model.DbMapObject;

public class PolitaktivMapFactory {

	public PolitaktivMapFactory(){
		
	}
	
	public MapViewPreferences generateMapViewPreferences(double lon, double lat, int zoom, String background){
		return new MapViewPreferences(lon, lat, zoom, background);
	}

	public UserAction generateUserAction(String markerAction, String onType) {
	
		return new UserAction(markerAction, onType);
	}
		
	public MapObject generateNewMapObject(long companyId, long groupId, long userId,
											String onType, double lon, double lat, String name,
											String description, String referenceUrl)
													throws SystemException, PortalException {
		
		MapObject mapObject = new MapObject(onType);
		
		if(onType.equals("marker")){
			mapObject.setType("marker");
			mapObject.setName(name);
			mapObject.setDescription(description);
			mapObject.setOccupancy(1); //full visible will be default - maybe some day we implement transparent marker?
			Marker marker = (Marker) mapObject.getGraphicObject();
			//TODO: different colors
			marker.setMarkerImageName("marker_yellow");
			//TODO: implement mapId
			marker.setMapId(0);
			marker.setLatitude(lat);
			marker.setLongitude(lon);
			System.out.println("MapFactory generateNEwMapObject() sais graphicObjectId is: " + mapObject.getGraphicObjectId());
			
			
		} else if(onType.equals("picture")){
			//TODO
		}
		
		mapObject.setCompanyId(companyId);
		mapObject.setGroupId(groupId);
		mapObject.setUserId(userId);
		mapObject.setReferenceUrl(referenceUrl);
		
		
		return mapObject;
	}
	
	static ArrayList<MapObject> convertDbObjectListToObjectList(
			ArrayList<DbMapObject> dbmapObjectListWithoutGraphicObjects) throws SystemException, PortalException {
		
		ArrayList<MapObject> mapObjectList = new ArrayList<MapObject>(); 
		for(DbMapObject dbMapObject: dbmapObjectListWithoutGraphicObjects){
			mapObjectList.add(new MapObject(dbMapObject.getMapObjectId()));
		}
		
		return mapObjectList;
	}
}
