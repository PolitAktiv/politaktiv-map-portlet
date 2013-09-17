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
 * This class is a wrapper for {@link DbMarkerLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       DbMarkerLocalService
 * @generated
 */
public class DbMarkerLocalServiceWrapper implements DbMarkerLocalService,
	ServiceWrapper<DbMarkerLocalService> {
	public DbMarkerLocalServiceWrapper(
		DbMarkerLocalService dbMarkerLocalService) {
		_dbMarkerLocalService = dbMarkerLocalService;
	}

	/**
	* Adds the db marker to the database. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @return the db marker that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbMarker addDbMarker(
		org.politaktiv.map.infrastructure.model.DbMarker dbMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.addDbMarker(dbMarker);
	}

	/**
	* Creates a new db marker with the primary key. Does not add the db marker to the database.
	*
	* @param markerId the primary key for the new db marker
	* @return the new db marker
	*/
	public org.politaktiv.map.infrastructure.model.DbMarker createDbMarker(
		long markerId) {
		return _dbMarkerLocalService.createDbMarker(markerId);
	}

	/**
	* Deletes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the db marker
	* @throws PortalException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbMarker(long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dbMarkerLocalService.deleteDbMarker(markerId);
	}

	/**
	* Deletes the db marker from the database. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbMarker(
		org.politaktiv.map.infrastructure.model.DbMarker dbMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dbMarkerLocalService.deleteDbMarker(dbMarker);
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
		return _dbMarkerLocalService.dynamicQuery(dynamicQuery);
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
		return _dbMarkerLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _dbMarkerLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dbMarkerLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.politaktiv.map.infrastructure.model.DbMarker fetchDbMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.fetchDbMarker(markerId);
	}

	/**
	* Returns the db marker with the primary key.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker
	* @throws PortalException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbMarker getDbMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.getDbMarker(markerId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the db markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db markers
	* @param end the upper bound of the range of db markers (not inclusive)
	* @return the range of db markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.DbMarker> getDbMarkers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.getDbMarkers(start, end);
	}

	/**
	* Returns the number of db markers.
	*
	* @return the number of db markers
	* @throws SystemException if a system exception occurred
	*/
	public int getDbMarkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.getDbMarkersCount();
	}

	/**
	* Updates the db marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @return the db marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbMarker updateDbMarker(
		org.politaktiv.map.infrastructure.model.DbMarker dbMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.updateDbMarker(dbMarker);
	}

	/**
	* Updates the db marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @param merge whether to merge the db marker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbMarker updateDbMarker(
		org.politaktiv.map.infrastructure.model.DbMarker dbMarker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMarkerLocalService.updateDbMarker(dbMarker, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dbMarkerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dbMarkerLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbMarkerLocalService getWrappedDbMarkerLocalService() {
		return _dbMarkerLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbMarkerLocalService(
		DbMarkerLocalService dbMarkerLocalService) {
		_dbMarkerLocalService = dbMarkerLocalService;
	}

	public DbMarkerLocalService getWrappedService() {
		return _dbMarkerLocalService;
	}

	public void setWrappedService(DbMarkerLocalService dbMarkerLocalService) {
		_dbMarkerLocalService = dbMarkerLocalService;
	}

	private DbMarkerLocalService _dbMarkerLocalService;
}