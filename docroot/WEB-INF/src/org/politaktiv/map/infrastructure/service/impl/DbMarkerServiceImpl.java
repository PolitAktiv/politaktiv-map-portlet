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

package org.politaktiv.map.infrastructure.service.impl;

import org.politaktiv.map.infrastructure.model.DbMarker;
import org.politaktiv.map.infrastructure.service.DbMarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.base.DbMarkerServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the db marker remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.DbMarkerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.DbMarkerServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.DbMarkerServiceUtil
 */
public class DbMarkerServiceImpl extends DbMarkerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.DbMarkerServiceUtil} to access the db marker remote service.
	 */
	public DbMarker addDbMarker(DbMarker dbMarker,long groupId) throws PrincipalException, SystemException{
		 
		 if(!getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.DbMarker", groupId, "ADD")){
			 throw new PrincipalException("not allowed", null);
		 }
		 return DbMarkerLocalServiceUtil.addDbMarker(dbMarker);
	} 
}