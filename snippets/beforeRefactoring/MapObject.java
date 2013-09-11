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

import org.politaktiv.map.infrastructure.model.DbMapObject;
import org.politaktiv.map.infrastructure.service.DbMapObjectLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;

public abstract class MapObject {

	private static Log _log = LogFactoryUtil.getLog(MapObject.class);
	private DbMapObject dbMapObject;
		
///////////// VALIDATION ////////////////////////////////////////////
	public void validate() throws ValidatorException{
		this.validateName();
		this.validateDescription();
		this.validateReferenceUrl();
		this.validateType();
		this.validateOccupancy();
	}

	private void validateOccupancy() throws ValidatorException{
		if(!(this.dbMapObject.getOccupancy() >= 0
				&& this.dbMapObject.getOccupancy() <= 1)){
			this.handleValidatorError("illegal-occupancy");
		}
		
	}

	private void validateType() throws ValidatorException{
		if(! (this.getType().equals("marker")
				|| this.getType().equals("picture"))){
			this.handleValidatorError("illegal-type");
		}
		
	}

	private void validateReferenceUrl() throws ValidatorException{
		
		if(! Validator.isUrl(this.dbMapObject.getReferenceUrl())){
			this.handleValidatorError("illegal-reference-Url");
		}
	}

	private void validateDescription() throws ValidatorException{
		
		if(!this.dbMapObject.getDescription().matches("[a-zA-Z0-9\u00E4\u00F6\u00FC\u00C4\u00D6\u00DC\u00DF ]+")){
			this.handleValidatorError("illegal-description-characters");
		}
		
		if(!(this.dbMapObject.getDescription().length() <= 75)){
			this.handleValidatorError("illegal-description-length");
		}
	}

	private void validateName() throws ValidatorException{
		if(!this.dbMapObject.getName().matches("[a-zA-Z0-9\u00E4\u00F6\u00FC\u00C4\u00D6\u00DC\u00DF ]+")){
			this.handleValidatorError("illegal-name-characters");
		}
		
		if(!(this.dbMapObject.getName().length() <= 20)){
			this.handleValidatorError("illegal-name-length");
		}
	}
	
	private void handleValidatorError(String errorMessage) throws ValidatorException{
		_log.info("validation:" + errorMessage);
		throw new ValidatorException(errorMessage,null);
	}


//////////// GETTER AND SETTER ///////////////////////////
	
	public long getUserId(){
		return this.dbMapObject.getUserId();
	}
	
	public long getGroupId(){
		return this.dbMapObject.getGroupId();
	}
	
	public DbMapObject getDbMapObject(){
		return this.dbMapObject;
	}
	
	public long getGraphicObjectId(){
		return this.dbMapObject.getGraphicObjectId();
	}
	
	public String getType(){
		return this.dbMapObject.getType();
	}
	
	public void setType(String type){
		this.dbMapObject.setType(type);
	}
	
	public void setName(String name){
		this.dbMapObject.setName(name);
	}
	
	public String getName(){
		return this.dbMapObject.getName();
	}
	
	public void setDescription(String description){
		this.dbMapObject.setDescription(description);
	}
	
	public void setCompanyId(long companyId){
		this.dbMapObject.setCompanyId(companyId);
	}
	
	public String getDescription(){
		return this.dbMapObject.getDescription();
	}
	
	public void setGroupId(long groupId){
		this.dbMapObject.setGroupId(groupId);
	}
	
	public void setUserId(long userId){
		this.dbMapObject.setUserId(userId);
	}
	

	public void setBackgroundId(long backgroundId) {
		this.dbMapObject.setBackgroundId(backgroundId);	
	}
	public void setGraphicObjectId(long graphicObjectId){
		this.dbMapObject.setGraphicObjectId(graphicObjectId);
	}
	public void setOccupancy(int occupancy){
		this.dbMapObject.setOccupancy(occupancy);
	}
	public void setReferenceUrl(String referenceUrl){
		this.dbMapObject.setReferenceUrl(referenceUrl);
	}
	
	public String getReferenceUrl(){
		return this.dbMapObject.getReferenceUrl();
	}
	
	public long getMapObjectId(){
		return this.dbMapObject.getMapObjectId();
	}
	
	public String getPopupInformationInHTMLFormat() throws PortalException, SystemException{
		String html = "";
		
		html += "Von " + UserLocalServiceUtil.getUser(this.getUserId()).getFullName() + "<br />";
		html += "<h2>" + this.getName() + "</h2>";
		html += this.getDescription() + "<br />";
		
		//only insert link if it is set
		if(!this.getReferenceUrl().equals("http://")
				&& !this.getReferenceUrl().equals("")){
			
			html += "<a href=\"" + this.getReferenceUrl() + "\" target=\"_blank\"> Link</a>";
		}
		
		return html;
		
	}
}
