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
	String onObjectType;
	
	public UserAction(String action, String onObjectType){
		
		this.action = action;
		this.onObjectType = onObjectType;
	}
	
	public void validate() throws ValidatorException{
		
		if(!(this.isAddAction()
				|| this.isUpdateAction()
				|| this.isDeleteAction())
			||
			(! this.isOnMarker()
					|| this.isOnPicture())){
			_log.info("user action invalide");
			throw new ValidatorException("illegalMarkerAction",null);
		}
	}
	
	public boolean isAddAction(){
		return this.action.equals("add");
	}
	
	public boolean isUpdateAction(){
		return this.action.equals("update");
	}
	
	public boolean isDeleteAction(){
		return this.action.equals("delete");
	}
	
	public boolean isOnMarker(){
		return this.onObjectType.equals("marker");
	}
	
	public boolean isOnPicture(){
		return this.onObjectType.equals("picture");
	}
}
