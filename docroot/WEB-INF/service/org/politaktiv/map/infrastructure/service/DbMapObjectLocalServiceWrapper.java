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

import java.io.Serializable;
import java.util.List;

import org.politaktiv.map.infrastructure.model.DbMapObject;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DbMapObjectLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       DbMapObjectLocalService
 * @generated
 */
public class DbMapObjectLocalServiceWrapper implements DbMapObjectLocalService,
	ServiceWrapper<DbMapObjectLocalService> {
	public DbMapObjectLocalServiceWrapper(
		DbMapObjectLocalService dbMapObjectLocalService) {
		_dbMapObjectLocalService = dbMapObjectLocalService;
	}

	/**
	* Adds the db map object to the database. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @return the db map object that was added
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject addDbMapObject(
		DbMapObject dbMapObject)
		throws SystemException {
		return _dbMapObjectLocalService.addDbMapObject(dbMapObject);
	}

	/**
	* Creates a new db map object with the primary key. Does not add the db map object to the database.
	*
	* @param mapObjectId the primary key for the new db map object
	* @return the new db map object
	*/
	public DbMapObject createDbMapObject(
		long mapObjectId) {
		return _dbMapObjectLocalService.createDbMapObject(mapObjectId);
	}

	/**
	* Deletes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapObjectId the primary key of the db map object
	* @throws PortalException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbMapObject(long mapObjectId)
		throws PortalException,
			SystemException {
		_dbMapObjectLocalService.deleteDbMapObject(mapObjectId);
	}

	/**
	* Deletes the db map object from the database. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbMapObject(
		DbMapObject dbMapObject)
		throws SystemException {
		_dbMapObjectLocalService.deleteDbMapObject(dbMapObject);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery)
		throws SystemException {
		return _dbMapObjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return _dbMapObjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return _dbMapObjectLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery)
		throws SystemException {
		return _dbMapObjectLocalService.dynamicQueryCount(dynamicQuery);
	}

	public DbMapObject fetchDbMapObject(
		long mapObjectId)
		throws SystemException {
		return _dbMapObjectLocalService.fetchDbMapObject(mapObjectId);
	}

	/**
	* Returns the db map object with the primary key.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object
	* @throws PortalException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject getDbMapObject(
		long mapObjectId)
		throws PortalException,
			SystemException {
		return _dbMapObjectLocalService.getDbMapObject(mapObjectId);
	}

	public PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return _dbMapObjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the db map objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db map objects
	* @param end the upper bound of the range of db map objects (not inclusive)
	* @return the range of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public List<DbMapObject> getDbMapObjects(
		int start, int end)
		throws SystemException {
		return _dbMapObjectLocalService.getDbMapObjects(start, end);
	}

	/**
	* Returns the number of db map objects.
	*
	* @return the number of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public int getDbMapObjectsCount()
		throws SystemException {
		return _dbMapObjectLocalService.getDbMapObjectsCount();
	}

	/**
	* Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @return the db map object that was updated
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject updateDbMapObject(
		DbMapObject dbMapObject)
		throws SystemException {
		return _dbMapObjectLocalService.updateDbMapObject(dbMapObject);
	}

	/**
	* Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @param merge whether to merge the db map object with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db map object that was updated
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject updateDbMapObject(
		DbMapObject dbMapObject,
		boolean merge)
		throws SystemException {
		return _dbMapObjectLocalService.updateDbMapObject(dbMapObject, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public String getBeanIdentifier() {
		return _dbMapObjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(String beanIdentifier) {
		_dbMapObjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	public List<DbMapObject> getAllDbMapObjectsFromCompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		return _dbMapObjectLocalService.getAllDbMapObjectsFromCompanyIdAndGroupId(companyId,
			groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbMapObjectLocalService getWrappedDbMapObjectLocalService() {
		return _dbMapObjectLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbMapObjectLocalService(
		DbMapObjectLocalService dbMapObjectLocalService) {
		_dbMapObjectLocalService = dbMapObjectLocalService;
	}

	public DbMapObjectLocalService getWrappedService() {
		return _dbMapObjectLocalService;
	}

	public void setWrappedService(
		DbMapObjectLocalService dbMapObjectLocalService) {
		_dbMapObjectLocalService = dbMapObjectLocalService;
	}

	private DbMapObjectLocalService _dbMapObjectLocalService;
}