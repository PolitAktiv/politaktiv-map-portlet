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
 * This class is a wrapper for {@link DbPointService}.
 * </p>
 *
 * @author    eichi
 * @see       DbPointService
 * @generated
 */
public class DbPointServiceWrapper implements DbPointService,
	ServiceWrapper<DbPointService> {
	public DbPointServiceWrapper(DbPointService dbPointService) {
		_dbPointService = dbPointService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbPointService getWrappedDbPointService() {
		return _dbPointService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbPointService(DbPointService dbPointService) {
		_dbPointService = dbPointService;
	}

	public DbPointService getWrappedService() {
		return _dbPointService;
	}

	public void setWrappedService(DbPointService dbPointService) {
		_dbPointService = dbPointService;
	}

	private DbPointService _dbPointService;
}