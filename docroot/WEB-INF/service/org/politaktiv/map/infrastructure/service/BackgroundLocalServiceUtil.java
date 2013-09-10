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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the background local service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.BackgroundLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see BackgroundLocalService
 * @see org.politaktiv.map.infrastructure.service.base.BackgroundLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.BackgroundLocalServiceImpl
 * @generated
 */
public class BackgroundLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.BackgroundLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the background to the database. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @return the background that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background addBackground(
		org.politaktiv.map.infrastructure.model.Background background)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBackground(background);
	}

	/**
	* Creates a new background with the primary key. Does not add the background to the database.
	*
	* @param backgroundId the primary key for the new background
	* @return the new background
	*/
	public static org.politaktiv.map.infrastructure.model.Background createBackground(
		long backgroundId) {
		return getService().createBackground(backgroundId);
	}

	/**
	* Deletes the background with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param backgroundId the primary key of the background
	* @throws PortalException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBackground(long backgroundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBackground(backgroundId);
	}

	/**
	* Deletes the background from the database. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBackground(
		org.politaktiv.map.infrastructure.model.Background background)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBackground(background);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.politaktiv.map.infrastructure.model.Background fetchBackground(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBackground(backgroundId);
	}

	/**
	* Returns the background with the primary key.
	*
	* @param backgroundId the primary key of the background
	* @return the background
	* @throws PortalException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background getBackground(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBackground(backgroundId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> getBackgrounds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBackgrounds(start, end);
	}

	/**
	* Returns the number of backgrounds.
	*
	* @return the number of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static int getBackgroundsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBackgroundsCount();
	}

	/**
	* Updates the background in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @return the background that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background updateBackground(
		org.politaktiv.map.infrastructure.model.Background background)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBackground(background);
	}

	/**
	* Updates the background in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param background the background
	* @param merge whether to merge the background with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the background that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background updateBackground(
		org.politaktiv.map.infrastructure.model.Background background,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBackground(background, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBycompanyIdAndGroupId(companyId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BackgroundLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BackgroundLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					BackgroundLocalService.class.getName(), portletClassLoader);

			_service = new BackgroundLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(BackgroundLocalServiceUtil.class,
				"_service");
			MethodCache.remove(BackgroundLocalService.class);
		}

		return _service;
	}

	public void setService(BackgroundLocalService service) {
		MethodCache.remove(BackgroundLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(BackgroundLocalServiceUtil.class,
			"_service");
		MethodCache.remove(BackgroundLocalService.class);
	}

	private static BackgroundLocalService _service;
}