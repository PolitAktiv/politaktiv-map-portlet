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

import javax.portlet.ValidatorException;

import org.politaktiv.map.infrastructure.model.DbMarker;
import org.politaktiv.map.infrastructure.service.DbMarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.DbPointLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Marker implements GraphicObject{

	private static Log _log = LogFactoryUtil.getLog(Marker.class);
	private DbMarker dbMarker;
	private Point point;
	
	public Marker(long markerId) throws PortalException, SystemException{
		this.dbMarker = DbMarkerLocalServiceUtil.getDbMarker(markerId);
		this.point = new Point(DbPointLocalServiceUtil.getDbPoint(this.dbMarker.getPointId()));
	}
	
	public Marker() throws SystemException{
		
		//wrapped object
		this.dbMarker = DbMarkerLocalServiceUtil.createDbMarker(CounterLocalServiceUtil.increment());
		System.out.println("Marker() sais, this.dbMarker.markerId is:" + this.dbMarker.getMarkerId());
		
		//child object and pointers to it
		this.point = new Point();
		this.dbMarker.setPointId(point.dbPoint.getPointId());
	}
	
	
///////////// VALIDATION ////////////////////////////////////////////	
	public void validate() throws ValidatorException{
		this.validateMarkerImageName();
		this.validatePoint();
	} 
	
	private void validatePoint() throws ValidatorException {
		this.point.validate();
	}
	
	
	private void validateMarkerImageName() throws ValidatorException {
		
		//whitelist of all image names for markers
		if(!this.dbMarker.getMarkerImageName().matches("marker_yellow")){
			_log.info("marker image name invalide");
			this.handleValidatorError("illegal-marker-image-name");
		}
		
	}
	
	private void handleValidatorError(String errorMessage) throws ValidatorException{
		_log.info("validation:" + errorMessage);
		throw new ValidatorException(errorMessage,null);
	}
	
/////////// GETTER AND SETTER ///////////////////
	
	public void setMarkerImageName(String markerImageName){
		this.dbMarker.setMarkerImageName(markerImageName);
	}
	
	public String getMarkerImageName(){
		return this.dbMarker.getMarkerImageName();
	}
	public DbMarker getDbMarker(){
		return this.dbMarker;
	}
	
	public long getMarkerId(){
		return this.dbMarker.getMarkerId();
	}
	
	public void setLongitude(double lon){
		this.point.setLongitude(lon);
	}
	
	public void setMapId(long mapId){
		this.dbMarker.setMarkerId(mapId);
	}
	public void setLatitude(double lat){
		this.point.setLatitude(lat);
	}
	
	public double getLongitude(){
		return this.point.getLongitude();
	}
	
	public double getLatitude(){
		return this.point.getLatitude();
	}
	
	public Point getPoint(){
		return this.point;
	}
	
	public long getId(){
		return this.dbMarker.getMarkerId();
	}
	
	public long getPointId(){
		return this.point.getPointId();
	}
	
	
}
