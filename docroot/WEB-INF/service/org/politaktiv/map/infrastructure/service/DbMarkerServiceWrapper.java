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

import org.politaktiv.map.infrastructure.model.DbMarker;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DbMarkerService}.
 * </p>
 *
 * @author    eichi
 * @see       DbMarkerService
 * @generated
 */
public class DbMarkerServiceWrapper implements DbMarkerService,
	ServiceWrapper<DbMarkerService> {
	public DbMarkerServiceWrapper(DbMarkerService dbMarkerService) {
		_dbMarkerService = dbMarkerService;
	}

	public DbMarker addDbMarker(
		DbMarker dbMarker, long groupId)
		throws SystemException,
			PrincipalException {
		return _dbMarkerService.addDbMarker(dbMarker, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbMarkerService getWrappedDbMarkerService() {
		return _dbMarkerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbMarkerService(DbMarkerService dbMarkerService) {
		_dbMarkerService = dbMarkerService;
	}

	public DbMarkerService getWrappedService() {
		return _dbMarkerService;
	}

	public void setWrappedService(DbMarkerService dbMarkerService) {
		_dbMarkerService = dbMarkerService;
	}

	private DbMarkerService _dbMarkerService;
}