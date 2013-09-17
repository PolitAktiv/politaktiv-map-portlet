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
 * This class is a wrapper for {@link DbPointLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       DbPointLocalService
 * @generated
 */
public class DbPointLocalServiceWrapper implements DbPointLocalService,
	ServiceWrapper<DbPointLocalService> {
	public DbPointLocalServiceWrapper(DbPointLocalService dbPointLocalService) {
		_dbPointLocalService = dbPointLocalService;
	}

	/**
	* Adds the db point to the database. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @return the db point that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPoint addDbPoint(
		org.politaktiv.map.infrastructure.model.DbPoint dbPoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.addDbPoint(dbPoint);
	}

	/**
	* Creates a new db point with the primary key. Does not add the db point to the database.
	*
	* @param pointId the primary key for the new db point
	* @return the new db point
	*/
	public org.politaktiv.map.infrastructure.model.DbPoint createDbPoint(
		long pointId) {
		return _dbPointLocalService.createDbPoint(pointId);
	}

	/**
	* Deletes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pointId the primary key of the db point
	* @throws PortalException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbPoint(long pointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dbPointLocalService.deleteDbPoint(pointId);
	}

	/**
	* Deletes the db point from the database. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbPoint(
		org.politaktiv.map.infrastructure.model.DbPoint dbPoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dbPointLocalService.deleteDbPoint(dbPoint);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.dynamicQuery(dynamicQuery, start, end,
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.politaktiv.map.infrastructure.model.DbPoint fetchDbPoint(
		long pointId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.fetchDbPoint(pointId);
	}

	/**
	* Returns the db point with the primary key.
	*
	* @param pointId the primary key of the db point
	* @return the db point
	* @throws PortalException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPoint getDbPoint(
		long pointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.getDbPoint(pointId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the db points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db points
	* @param end the upper bound of the range of db points (not inclusive)
	* @return the range of db points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.DbPoint> getDbPoints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.getDbPoints(start, end);
	}

	/**
	* Returns the number of db points.
	*
	* @return the number of db points
	* @throws SystemException if a system exception occurred
	*/
	public int getDbPointsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.getDbPointsCount();
	}

	/**
	* Updates the db point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @return the db point that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPoint updateDbPoint(
		org.politaktiv.map.infrastructure.model.DbPoint dbPoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.updateDbPoint(dbPoint);
	}

	/**
	* Updates the db point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @param merge whether to merge the db point with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db point that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPoint updateDbPoint(
		org.politaktiv.map.infrastructure.model.DbPoint dbPoint, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbPointLocalService.updateDbPoint(dbPoint, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dbPointLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dbPointLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbPointLocalService getWrappedDbPointLocalService() {
		return _dbPointLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbPointLocalService(
		DbPointLocalService dbPointLocalService) {
		_dbPointLocalService = dbPointLocalService;
	}

	public DbPointLocalService getWrappedService() {
		return _dbPointLocalService;
	}

	public void setWrappedService(DbPointLocalService dbPointLocalService) {
		_dbPointLocalService = dbPointLocalService;
	}

	private DbPointLocalService _dbPointLocalService;
}