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

import org.politaktiv.map.infrastructure.model.Background;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BackgroundLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       BackgroundLocalService
 * @generated
 */
public class BackgroundLocalServiceWrapper implements BackgroundLocalService,
	ServiceWrapper<BackgroundLocalService> {
	public BackgroundLocalServiceWrapper(
		BackgroundLocalService backgroundLocalService) {
		_backgroundLocalService = backgroundLocalService;
	}

	/**
	* Adds the background to the database. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @return the background that was added
	* @throws SystemException if a system exception occurred
	*/
	public Background addBackground(
		Background background)
		throws SystemException {
		return _backgroundLocalService.addBackground(background);
	}

	/**
	* Creates a new background with the primary key. Does not add the background to the database.
	*
	* @param backgroundId the primary key for the new background
	* @return the new background
	*/
	public Background createBackground(
		long backgroundId) {
		return _backgroundLocalService.createBackground(backgroundId);
	}

	/**
	* Deletes the background with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param backgroundId the primary key of the background
	* @throws PortalException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBackground(long backgroundId)
		throws PortalException,
			SystemException {
		_backgroundLocalService.deleteBackground(backgroundId);
	}

	/**
	* Deletes the background from the database. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBackground(
		Background background)
		throws SystemException {
		_backgroundLocalService.deleteBackground(background);
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
		return _backgroundLocalService.dynamicQuery(dynamicQuery);
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
		return _backgroundLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _backgroundLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _backgroundLocalService.dynamicQueryCount(dynamicQuery);
	}

	public Background fetchBackground(
		long backgroundId)
		throws SystemException {
		return _backgroundLocalService.fetchBackground(backgroundId);
	}

	/**
	* Returns the background with the primary key.
	*
	* @param backgroundId the primary key of the background
	* @return the background
	* @throws PortalException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Background getBackground(
		long backgroundId)
		throws PortalException,
			SystemException {
		return _backgroundLocalService.getBackground(backgroundId);
	}

	public PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return _backgroundLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the backgrounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @return the range of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public List<Background> getBackgrounds(
		int start, int end)
		throws SystemException {
		return _backgroundLocalService.getBackgrounds(start, end);
	}

	/**
	* Returns the number of backgrounds.
	*
	* @return the number of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public int getBackgroundsCount()
		throws SystemException {
		return _backgroundLocalService.getBackgroundsCount();
	}

	/**
	* Updates the background in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @return the background that was updated
	* @throws SystemException if a system exception occurred
	*/
	public Background updateBackground(
		Background background)
		throws SystemException {
		return _backgroundLocalService.updateBackground(background);
	}

	/**
	* Updates the background in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @param merge whether to merge the background with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the background that was updated
	* @throws SystemException if a system exception occurred
	*/
	public Background updateBackground(
		Background background,
		boolean merge)
		throws SystemException {
		return _backgroundLocalService.updateBackground(background, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public String getBeanIdentifier() {
		return _backgroundLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(String beanIdentifier) {
		_backgroundLocalService.setBeanIdentifier(beanIdentifier);
	}

	public List<Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		return _backgroundLocalService.findBycompanyIdAndGroupId(companyId,
			groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BackgroundLocalService getWrappedBackgroundLocalService() {
		return _backgroundLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBackgroundLocalService(
		BackgroundLocalService backgroundLocalService) {
		_backgroundLocalService = backgroundLocalService;
	}

	public BackgroundLocalService getWrappedService() {
		return _backgroundLocalService;
	}

	public void setWrappedService(BackgroundLocalService backgroundLocalService) {
		_backgroundLocalService = backgroundLocalService;
	}

	private BackgroundLocalService _backgroundLocalService;
}