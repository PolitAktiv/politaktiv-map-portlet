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

import org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.BackgroundServiceUtil;
import org.politaktiv.map.infrastructure.service.persistence.BackgroundUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


public class MapViewPreferences {

	double lon;
	double lat;
	int zoom;
	long backgroundId;
	
	public MapViewPreferences(double lon, double lat, int zoom, long backgroundId){
		
		this.lon = lon;
		this.lat = lat;
		this.zoom = zoom;
		this.backgroundId = backgroundId;
		
	}
	
	public void valide() throws ValidatorException, SystemException {
		this.validateLat();
		this.valideLon();
		this.validateZoom();
		this.validateBackgroundId();
	}
	
	private void validateBackgroundId() throws ValidatorException {
		
		try {
			BackgroundLocalServiceUtil.fetchBackground(this.backgroundId);
		} catch (SystemException e) {
			throw new ValidatorException("background-does-not-exist", null);
		}
	}
	
	private void valideLon() throws ValidatorException {
	
		if(! (this.lon >= -20014392.722699 &&
				this.lon <= 19904080.923394)){
			
			throw new ValidatorException("wrongLongitude", null);
			
		}
	}
	
	private void validateLat() throws ValidatorException {
		
		if(!(this.lat >= -20027726 &&
				this.lat <= 20033103)){
			throw new ValidatorException("wrongLatitude", null);
		}
	
	}
	
	
	private void validateZoom() throws ValidatorException{
		
		//if its not 0 <= x <= 15
		if(!(this.zoom >= 0 &&
				this.zoom <= 18)){
			throw new ValidatorException("wrongZoomLevel", null);
		}
		
	}

	public double getLon() {
		return this.lon;
	}

	public double getLat() {
		return this.lat;
	}

	public int getZoom() {
		return this.zoom;
	}
	public long getBackgroundId(){
		return this.backgroundId;
	}
	
	
}

