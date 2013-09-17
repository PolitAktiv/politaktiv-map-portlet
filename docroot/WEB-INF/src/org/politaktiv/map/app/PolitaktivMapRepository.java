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

import java.io.IOException;
import java.util.ArrayList;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

import org.politaktiv.map.domain.GraphicObject;
import org.politaktiv.map.domain.MapObject;
import org.politaktiv.map.domain.MapViewPreferences;
import org.politaktiv.map.domain.Marker;
import org.politaktiv.map.domain.Picture;
import org.politaktiv.map.infrastructure.model.DbMapObject;
import org.politaktiv.map.infrastructure.service.DbMapObjectLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.DbMapObjectServiceUtil;
import org.politaktiv.map.infrastructure.service.DbMarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.DbMarkerServiceUtil;
import org.politaktiv.map.infrastructure.service.DbPictureLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.DbPointLocalServiceUtil;

public class PolitaktivMapRepository {

//	public List<Marker> findMarkersByGroupId(long currentGroupId) throws SystemException {
//		
//		return MarkerLocalServiceUtil.findMarkersByGroupId(currentGroupId);
//	}
	
	public ArrayList<MapObject> getAllMapObjectFromCompanyIdAndGroupId(long companyId,
															long groupId) throws SystemException, PortalException{
		ArrayList<DbMapObject> dbmapObjectListWithoutGraphicObjects =
				new ArrayList<DbMapObject>(DbMapObjectServiceUtil.getAllDbMapObjectsFromCompanyIdAndGroupId(companyId,groupId));
		
		ArrayList<MapObject> mapObjectListWithoutGraphicObjects = PolitaktivMapFactory.convertDbObjectListToObjectList(dbmapObjectListWithoutGraphicObjects);
		return this.fillMapObjectWithGraphObjects(mapObjectListWithoutGraphicObjects);
		
	}




	private ArrayList<MapObject> fillMapObjectWithGraphObjects(
			ArrayList<MapObject> mapObjectList) throws PortalException, SystemException {
		GraphicObject graphicObject;
		
		for(MapObject mobject: mapObjectList){
			if(mobject.getType().equals("picture")){
				graphicObject = new Picture(DbPictureLocalServiceUtil.getDbPicture(mobject.getGraphicObjectId()));
				mobject.setGraphicObject(graphicObject);
			} else if(mobject.getType().equals("marker")){
				graphicObject = new Marker(mobject.getGraphicObjectId());
				mobject.setGraphicObject(graphicObject);
			}
		}
		return mapObjectList;
	}
	
	
	public void storeMapViewPreferences(MapViewPreferences mapViewPrefs,
			PortletPreferences prefs) throws ValidatorException, IOException, ReadOnlyException {
		
		 mapViewPrefs.valide();
		
		 prefs.setValue("lon_center", Double.toString(mapViewPrefs.getLon()));
	     prefs.setValue("lat_center", Double.toString(mapViewPrefs.getLat()));
	     prefs.setValue("zoom_center", Double.toString(mapViewPrefs.getZoom()));
	     prefs.setValue("background_url", mapViewPrefs.getBackground());
	     prefs.store();
		
	}

	public long saveMapObject(MapObject mapObject)
			throws ValidatorException, SystemException, PrincipalException {
		System.out.println("saveMapObject()");
		mapObject.validate();
		
		if(mapObject.getType() == "marker"){
			System.out.println("graphicObjectId: " + mapObject.getGraphicObjectId()); //TODO: remove
			Marker marker = (Marker)mapObject.getGraphicObject();
			
			// FIXME dirty hack, but marker.dbMarker loses markerId on casting (Marker)mapObject.getGraphicObject()
			// means: set mapId new with mapObject.getGraphicObjectId()
			marker.getDbMarker().setMarkerId(mapObject.getGraphicObjectId());
			DbMarkerServiceUtil.addDbMarker(marker.getDbMarker(),mapObject.getGroupId());
			DbPointLocalServiceUtil.addDbPoint(marker.getPoint().getDbPoint());
			DbMapObjectLocalServiceUtil.addDbMapObject(mapObject.getDbMapObject());
			return mapObject.getMapObjectId(); 
			
		}else if(mapObject.getType() == "picture"){
			//TODO: implement point save routine
		}
		
		//this will only happen when hell freezes over (UserAction Model does validation already!)
		throw new ValidatorException("type not exists",null);

		
	}




	public void deleteMapObjectWithId(long mapObjectId, long currentCommunityId, long currentCompanyId, String currentPortletId, long currentUserId) throws SystemException, PortalException{
			
		MapObject delMapObject = new MapObject(mapObjectId); 
		String type = delMapObject.getType();
		
		if(type.equals("marker")){
			//TODO: use *ServiceUtil for permission checks
			//first try to remove dbMarker because permission hangs on action DELETE org.politaktiv.map.infrastructure.model.DbMarker
			DbMarkerLocalServiceUtil.deleteDbMarker(delMapObject.getGraphicObjectId());
			DbPointLocalServiceUtil.deleteDbPoint(delMapObject.getGraphicObject().getPointId());
			DbMapObjectLocalServiceUtil.deleteDbMapObject(delMapObject.getDbMapObject());
			
		} else if(type.equals("picture")){
			//TODO: do like type marker
		}
	}

}
