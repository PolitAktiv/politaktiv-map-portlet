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

import com.liferay.portal.kernel.util.Validator;

public class MapViewPreferences {

	double lon;
	double lat;
	int zoom;
	String background;
	
	public MapViewPreferences(double lon, double lat, int zoom, String background){
		
		this.lon = lon;
		this.lat = lat;
		this.zoom = zoom;
		this.background = background;
		
	}
	
	public void valide() throws ValidatorException {
		this.validateLat();
		this.valideLon();
		this.validateZoom();
		this.validateBackground();
	}
	
	private void validateBackground() throws ValidatorException {
		
		if(!(this.background == "map" ||
				Validator.isUrl(this.background))){
			throw new ValidatorException("wrongBackground", null);
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
	public String getBackground(){
		return this.background;
	}
	
	
}

