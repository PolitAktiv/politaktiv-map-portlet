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

package org.politaktiv.map.infrastructure.model.impl;

import javax.portlet.ValidatorException;

import org.politaktiv.map.domain.ObjectWithPictureUrl;
import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.persistence.PictureUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the Picture service. Represents a row in the &quot;politaktivmap_Picture&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.model.Picture} interface.
 * </p>
 *
 * @author eichi
 */
public class PictureImpl extends PictureBaseImpl implements ObjectWithPictureUrl{
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a picture model instance should use the {@link org.politaktiv.map.infrastructure.model.Picture} interface instead.
	 */
	private static Log _log = LogFactoryUtil.getLog(Picture.class);
	public PictureImpl() {
	}

	@Override
	public String getPictureUrl() {
		
	
		String url = "";
		url += "/c/document_library/get_file?uuid=";
		url += this.getFileEntryUuid();
		url += "&groupId=";
		url += this.getGroupId();
		
		return url;
	}
	
	public void validate() throws ValidatorException, SystemException{
		this.validateLon();
		this.validateLat();
		this.validateName();
		this.validateDescription();
		this.validateReferenceUrl();
	}
	
private void validateReferenceUrl() throws ValidatorException{
		
		if(! Validator.isUrl(this.getReferenceUrl())){
			_log.info("picture reference url invalide");
			throw new ValidatorException("reference url", null);
		}
	}
	
private void validateDescription() throws ValidatorException{
		
		if(!this.getDescription().matches("[a-zA-Z0-9\u00E4\u00F6\u00FC\u00C4\u00D6\u00DC\u00DF ]+")){
			_log.info("picture description invalide");
			throw new ValidatorException("description",null);
		}
	}
	
	private void validateName() throws ValidatorException, SystemException{
		
		if(!this.getName().matches("[a-zA-Z0-9\u00E4\u00F6\u00FC\u00C4\u00D6\u00DC\u00DF ]+")){
			_log.info("picture title invalide");
			throw new ValidatorException("title",null);
		}
		
		if((PictureUtil.findByname(this.getName()).size() >= 1)){
			_log.info("picture title invalide");
			throw new ValidatorException("title-exists",null);
		}
	}
	
	private void validateLat() throws ValidatorException{
		
		if(!(this.getLatitude() >= -20027726 &&
				this.getLatitude() <= 20033103)
				|| Validator.isNull(this.getLatitude())){
			_log.info("picture latitude invalide");
			throw new ValidatorException("latitude", null);
		}
	}
	
	private void validateLon() throws ValidatorException{
		
		if(!(this.getLongitude() >= -20014392.722699 &&
				this.getLongitude() <= 19904080.923394)
				|| Validator.isNull(this.getLongitude())){
			_log.info("picture longitude invalide");
			throw new ValidatorException("longitude", null);
		}
	}
	
	
}