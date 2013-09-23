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

package org.politaktiv.map.infrastructure.service;

import java.util.List;

import org.politaktiv.map.infrastructure.model.Marker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The interface for the marker remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see MarkerServiceUtil
 * @see org.politaktiv.map.infrastructure.service.base.MarkerServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.MarkerServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MarkerService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarkerServiceUtil} to access the marker remote service. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.MarkerServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Marker addMarker(
		Marker marker, long groupId)
		throws SystemException,
			PrincipalException,
			javax.portlet.ValidatorException;

	public List<Marker> findMarkerByBackgroundId(
		long backgroundId)
		throws SystemException;

	public void deleteMarker(long markerId, long userId, long groupId,
		String portletId)
		throws PortalException,
			SystemException,
			javax.portlet.ValidatorException;
}