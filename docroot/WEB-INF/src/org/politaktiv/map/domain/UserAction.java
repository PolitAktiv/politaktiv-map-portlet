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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * @author politaktiv
 *
 * A user action on a marker
 */
public class UserAction {

	private static Log _log = LogFactoryUtil.getLog(UserAction.class);
	String action;
	
	public UserAction(String action){
		
		this.action = action;
	}
	
	public void validate() throws ValidatorException{
		
		if(!(this.isAddMarker()
				|| this.isUpdateMarker()
				|| this.isDeleteMarker()
				|| this.isAddPicture()
				|| this.isUpdatePicture()
				|| this.isDeletePicture()
				|| this.isAddBackground()
				|| this.isDeleteBackground()
				|| this.isSaveCenterAndZoom())){
			_log.info("user action invalide");
			throw new ValidatorException("illegalMarkerAction",null);
		}
	}
	
	public boolean isAddMarker(){
		return this.action.equals("addMarker");
	}
	
	public boolean isUpdateMarker(){
		return this.action.equals("updateMarker");
	}
	
	public boolean isDeleteMarker(){
		return this.action.equals("deleteMarker");
	}
	
	public boolean isAddPicture(){
		return this.action.equals("addPicture");
	}
	
	public boolean isUpdatePicture(){
		return this.action.equals("updatePicture");
	}
	
	public boolean isDeletePicture(){
		return this.action.equals("deletePicture");
	}
	
	public boolean isAddBackground(){
		return this.action.equals("addBackground");
	}
	
	public boolean isDeleteBackground(){
		return this.action.equals("deleteBackground");
	}
	
	public boolean isSaveCenterAndZoom(){
		return this.action.equals("saveCenterAndZoom");
	}
}
