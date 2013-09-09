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

import javax.portlet.ValidatorException;

import org.politaktiv.map.infrastructure.model.DbPicture;
import org.politaktiv.map.infrastructure.service.DbPictureLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Picture implements GraphicObject{

	private static Log _log = LogFactoryUtil.getLog(Picture.class);
	private DbPicture dbPicture;
	
	public Picture(DbPicture dbPicture){
		this.dbPicture = dbPicture;
	}
	
	public Picture() throws SystemException{
		this.dbPicture = DbPictureLocalServiceUtil.createDbPicture(CounterLocalServiceUtil.increment());
	}
	
	
/////////// VALIDATION ////////////////////////////////
	
	public void validate() throws ValidatorException{
		
		this.validateRotation();
		this.validateWidth();
		this.validateHeight();
		this.validateResolution();
	}
	
	private void validateResolution() {
		// TODO Auto-generated method stub
		
	}

	private void validateHeight() throws ValidatorException {
		
		if(!(this.dbPicture.getHeight() > 1 )){
			this.handleValidatorError("illegal-picture-height");
		}
		
	}

	private void validateWidth() throws ValidatorException {
		if(!(this.dbPicture.getWidth() > 1 )){
			this.handleValidatorError("illegal-picture-width");
		}
		
	}

	private void validateRotation() throws ValidatorException {
		if(!(this.dbPicture.getResolution() >= 0 &&
				this.dbPicture.getResolution() <= 360)){
			this.handleValidatorError("illegal-picture-resolution");
		}
		
	}

	private void handleValidatorError(String errorMessage) throws ValidatorException{
		_log.info("validation:" + errorMessage);
		throw new ValidatorException(errorMessage,null);
	}

	public DbPicture getDbPicture() {
		return dbPicture;
	}
	
	public long getId(){
		return this.dbPicture.getPictureId();
	}
	
	public long getPointId(){
		//TODO
//		return this.point.
		return 0;
	}

}
