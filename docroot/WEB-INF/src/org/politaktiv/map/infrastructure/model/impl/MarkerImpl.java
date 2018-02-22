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

import org.politaktiv.map.infrastructure.model.Marker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;


/**
 * The extended model implementation for the Marker service. Represents a row in the &quot;politaktivmap_Marker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.model.Marker} interface.
 * </p>
 *
 * @author eichi, nott
 */
public class MarkerImpl extends MarkerBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a marker model instance should use the {@link org.politaktiv.map.infrastructure.model.Marker} interface instead.
	 */
	private static Log _log = LogFactoryUtil.getLog(Marker.class);
	public MarkerImpl() {
	}
	
	public void validate() throws ValidatorException{
		this.validateLon();
		this.validateLat();
		this.validateName();
		this.validateDescription();
		this.validateReferenceUrl();
	}
	
private void validateReferenceUrl() throws ValidatorException{
		
		if(! Validator.isUrl(this.getReferenceUrl())){
			_log.info("marker reference url invalide");
			throw new ValidatorException("reference url", null);
		}
	}
	
private void validateDescription() throws ValidatorException{
		
		if( this.getDescription().trim() == "" ){
			_log.info("marker description invalide");
			throw new ValidatorException("description",null);
		}
	}
	
	private void validateName() throws ValidatorException{
		
		if( this.getName().trim() == "" ){
			_log.info("marker title invalide");
			throw new ValidatorException("title",null);
		}
	}
	
	private void validateLat() throws ValidatorException{
		
		if(!(this.getLatitude() >= -20027726 &&
				this.getLatitude() <= 20033103)
				|| Validator.isNull(this.getLatitude())){
			_log.info("marker latitude invalide");
			throw new ValidatorException("latitude", null);
		}
	}
	
	private void validateLon() throws ValidatorException{
		
		if(!(this.getLongitude() >= -20014392.722699 &&
				this.getLongitude() <= 19904080.923394)
				|| Validator.isNull(this.getLongitude())){
			_log.info("marker longitude invalide");
			throw new ValidatorException("longitude", null);
		}
	}
	
	public String toHTMLFormatedString() throws PortalException, SystemException{
		
		//TODO: internationalize
		String html= "";
		html += "Von " + HtmlUtil.escape(UserLocalServiceUtil.getUserById(this.getUserId()).getFullName()) + "<br />";
		html += "<h2>" + HtmlUtil.escape(this.getName()) + "</h2>";
		html +=		HtmlUtil.escape( this.getDescription()) + "<br />";
		
		//only if a link is set, otherwise don't show
		if(this.getReferenceUrl() != "http://" &&
				this.getReferenceUrl() != ""){
			html += "<a href=\"" + this.getReferenceUrl() + "\"  target=\"_blank\"> Link </a>";
		}
		
		return html;
	}
}