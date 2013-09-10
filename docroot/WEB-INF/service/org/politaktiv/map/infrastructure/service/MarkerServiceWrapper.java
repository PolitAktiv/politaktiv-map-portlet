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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MarkerService}.
 * </p>
 *
 * @author    eichi
 * @see       MarkerService
 * @generated
 */
public class MarkerServiceWrapper implements MarkerService,
	ServiceWrapper<MarkerService> {
	public MarkerServiceWrapper(MarkerService markerService) {
		_markerService = markerService;
	}

	public org.politaktiv.map.infrastructure.model.Marker addMarker(
		org.politaktiv.map.infrastructure.model.Marker marker, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			javax.portlet.ValidatorException {
		return _markerService.addMarker(marker, groupId);
	}

	public java.util.List<org.politaktiv.map.infrastructure.model.Marker> findMarkerByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerService.findMarkerByBackgroundId(backgroundId);
	}

	public void deleteMarker(long markerId, long userId, long groupId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_markerService.deleteMarker(markerId, userId, groupId, portletId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MarkerService getWrappedMarkerService() {
		return _markerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMarkerService(MarkerService markerService) {
		_markerService = markerService;
	}

	public MarkerService getWrappedService() {
		return _markerService;
	}

	public void setWrappedService(MarkerService markerService) {
		_markerService = markerService;
	}

	private MarkerService _markerService;
}