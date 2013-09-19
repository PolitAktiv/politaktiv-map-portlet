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

import org.politaktiv.map.infrastructure.model.DbPicture;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DbPictureLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       DbPictureLocalService
 * @generated
 */
public class DbPictureLocalServiceWrapper implements DbPictureLocalService,
	ServiceWrapper<DbPictureLocalService> {
	public DbPictureLocalServiceWrapper(
		DbPictureLocalService dbPictureLocalService) {
		_dbPictureLocalService = dbPictureLocalService;
	}

	/**
	* Adds the db picture to the database. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @return the db picture that was added
	* @throws SystemException if a system exception occurred
	*/
	public DbPicture addDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		return _dbPictureLocalService.addDbPicture(dbPicture);
	}

	/**
	* Creates a new db picture with the primary key. Does not add the db picture to the database.
	*
	* @param pictureId the primary key for the new db picture
	* @return the new db picture
	*/
	public DbPicture createDbPicture(
		long pictureId) {
		return _dbPictureLocalService.createDbPicture(pictureId);
	}

	/**
	* Deletes the db picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the db picture
	* @throws PortalException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbPicture(long pictureId)
		throws PortalException,
			SystemException {
		_dbPictureLocalService.deleteDbPicture(pictureId);
	}

	/**
	* Deletes the db picture from the database. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		_dbPictureLocalService.deleteDbPicture(dbPicture);
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
		return _dbPictureLocalService.dynamicQuery(dynamicQuery);
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
		return _dbPictureLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _dbPictureLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dbPictureLocalService.dynamicQueryCount(dynamicQuery);
	}

	public DbPicture fetchDbPicture(
		long pictureId)
		throws SystemException {
		return _dbPictureLocalService.fetchDbPicture(pictureId);
	}

	/**
	* Returns the db picture with the primary key.
	*
	* @param pictureId the primary key of the db picture
	* @return the db picture
	* @throws PortalException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPicture getDbPicture(
		long pictureId)
		throws PortalException,
			SystemException {
		return _dbPictureLocalService.getDbPicture(pictureId);
	}

	public PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return _dbPictureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the db pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db pictures
	* @param end the upper bound of the range of db pictures (not inclusive)
	* @return the range of db pictures
	* @throws SystemException if a system exception occurred
	*/
	public List<DbPicture> getDbPictures(
		int start, int end)
		throws SystemException {
		return _dbPictureLocalService.getDbPictures(start, end);
	}

	/**
	* Returns the number of db pictures.
	*
	* @return the number of db pictures
	* @throws SystemException if a system exception occurred
	*/
	public int getDbPicturesCount()
		throws SystemException {
		return _dbPictureLocalService.getDbPicturesCount();
	}

	/**
	* Updates the db picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @return the db picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public DbPicture updateDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		return _dbPictureLocalService.updateDbPicture(dbPicture);
	}

	/**
	* Updates the db picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @param merge whether to merge the db picture with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public DbPicture updateDbPicture(
		DbPicture dbPicture,
		boolean merge)
		throws SystemException {
		return _dbPictureLocalService.updateDbPicture(dbPicture, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public String getBeanIdentifier() {
		return _dbPictureLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(String beanIdentifier) {
		_dbPictureLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DbPictureLocalService getWrappedDbPictureLocalService() {
		return _dbPictureLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDbPictureLocalService(
		DbPictureLocalService dbPictureLocalService) {
		_dbPictureLocalService = dbPictureLocalService;
	}

	public DbPictureLocalService getWrappedService() {
		return _dbPictureLocalService;
	}

	public void setWrappedService(DbPictureLocalService dbPictureLocalService) {
		_dbPictureLocalService = dbPictureLocalService;
	}

	private DbPictureLocalService _dbPictureLocalService;
}