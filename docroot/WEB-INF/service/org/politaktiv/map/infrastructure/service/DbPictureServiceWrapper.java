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
 * This class is a wrapper for {@link DbPictureService}.
 * </p>
 *
 * @author    eichi
 * @see       DbPictureService
 * @generated
 */
public class DbPictureServiceWrapper implements DbPictureService,
	ServiceWrapper<DbPictureService> {
	public DbPictureServiceWrapper(DbPictureService dbPictureService) {
		_dbPictureService = dbPictureService;
	}

	public org.politaktiv.map.infrastructure.model.DbPicture addDbPicture(
		org.politaktiv.map.infrastructure.model.DbPicture dbPicture,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _dbPictureService.addDbPicture(dbPicture, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbPictureService getWrappedDbPictureService() {
		return _dbPictureService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbPictureService(DbPictureService dbPictureService) {
		_dbPictureService = dbPictureService;
	}

	public DbPictureService getWrappedService() {
		return _dbPictureService;
	}

	public void setWrappedService(DbPictureService dbPictureService) {
		_dbPictureService = dbPictureService;
	}

	private DbPictureService _dbPictureService;
}