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
 * This class is a wrapper for {@link DbMapObjectService}.
 * </p>
 *
 * @author    eichi
 * @see       DbMapObjectService
 * @generated
 */
public class DbMapObjectServiceWrapper implements DbMapObjectService,
	ServiceWrapper<DbMapObjectService> {
	public DbMapObjectServiceWrapper(DbMapObjectService dbMapObjectService) {
		_dbMapObjectService = dbMapObjectService;
	}

	public java.util.List<org.politaktiv.map.infrastructure.model.DbMapObject> getAllDbMapObjectsFromCompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMapObjectService.getAllDbMapObjectsFromCompanyIdAndGroupId(companyId,
			groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbMapObjectService getWrappedDbMapObjectService() {
		return _dbMapObjectService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbMapObjectService(
		DbMapObjectService dbMapObjectService) {
		_dbMapObjectService = dbMapObjectService;
	}

	public DbMapObjectService getWrappedService() {
		return _dbMapObjectService;
	}

	public void setWrappedService(DbMapObjectService dbMapObjectService) {
		_dbMapObjectService = dbMapObjectService;
	}

	private DbMapObjectService _dbMapObjectService;
}