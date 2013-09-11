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

package com.politaktiv.map.infrastructure.model.impl;

import java.util.Collection;

import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.util.Validator;
import com.politaktiv.map.infrastructure.model.Marker;

/**
 * The model implementation for the Marker service. Represents a row in the &quot;politaktivmap_Marker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.politaktiv.map.infrastructure.model.Marker} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a marker model instance should use the {@link Marker} interface instead.
 * </p>
 */
public class MarkerImpl extends MarkerModelImpl implements Marker {
	public MarkerImpl() {
	}
	
	public void validateAll() throws ValidatorException(){
		
		this.validateLon();
		this.validateLat();
		
	}
	
	
	private void validateLat() throws ValidatorException(){
		
		if(!(this.getLat() >= -20027726 &&
				this.getLat() <= 20033103)
				|| Validator.isNull(this.getLat())){
			throw new ValidatorException("illegalMarkerLatitude", null);
		}
	}
	
	private void validateLon() throws ValidatorException(){
		
		if(!(this.lon >= -20014392.722699 &&
				this.lon <= 19904080.923394)
				|| Validator.isNull(this.getLon())){
			throw new ValidatorException("illegalMarkerLongitude", null);
		}
	}
}