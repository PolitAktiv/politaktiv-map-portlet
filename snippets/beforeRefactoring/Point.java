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

import org.politaktiv.map.infrastructure.model.DbPoint;
import org.politaktiv.map.infrastructure.service.DbPointLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class Point {

	private static Log _log = LogFactoryUtil.getLog(Point.class);
	DbPoint dbPoint;
	
	public Point(DbPoint dbPoint){
		this.dbPoint = dbPoint;
	}
	
	
	public Point() throws SystemException{
		this.dbPoint = DbPointLocalServiceUtil.createDbPoint(CounterLocalServiceUtil.increment());
	}
	
	
	////////////////// VALIDATOR /////////////
	public void validate() throws ValidatorException{
		this.validateLon();
		this.validateLat();
	}
	
	private void validateLat() throws ValidatorException{
		
		if(!(this.dbPoint.getLatitude() >= -20027726 &&
				this.dbPoint.getLatitude() <= 20033103)
				|| Validator.isNull(this.dbPoint.getLatitude())){
			this.handleValidatorError("illegal-marker-latitude");
		}
	}
	
	private void validateLon() throws ValidatorException{
		
		if(!(this.dbPoint.getLongitude() >= -20014392.722699 &&
				this.dbPoint.getLongitude() <= 19904080.923394)
				|| Validator.isNull(this.dbPoint.getLongitude())){
			this.handleValidatorError("illegal-marker-longitude");
		}
	}
	
	private void handleValidatorError(String errorMessage) throws ValidatorException{
		_log.info("validation:" + errorMessage);
		throw new ValidatorException(errorMessage,null);
	}
	
	//////// GETTER AND SETTER ////////////////////
	public void setLongitude(double lon){
		this.dbPoint.setLongitude(lon);
	}
	
	public void setLatitude(double lat){
		this.dbPoint.setLatitude(lat);
	}
	
	public double getLongitude(){
		return this.dbPoint.getLongitude();
	}
	
	public double getLatitude(){
		return this.dbPoint.getLatitude();
	}
	
	public DbPoint getDbPoint(){
		return this.dbPoint;
	}
	
	public long getPointId(){
		return this.dbPoint.getPointId();
	}
}
