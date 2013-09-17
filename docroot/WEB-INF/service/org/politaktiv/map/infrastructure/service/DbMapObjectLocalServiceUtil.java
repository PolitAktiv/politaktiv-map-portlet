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
 * The utility for the db map object local service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbMapObjectLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see DbMapObjectLocalService
 * @see org.politaktiv.map.infrastructure.service.base.DbMapObjectLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbMapObjectLocalServiceImpl
 * @generated
 */
public class DbMapObjectLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbMapObjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the db map object to the database. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @return the db map object that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.DbMapObject addDbMapObject(
		org.politaktiv.map.infrastructure.model.DbMapObject dbMapObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDbMapObject(dbMapObject);
	}

	/**
	* Creates a new db map object with the primary key. Does not add the db map object to the database.
	*
	* @param mapObjectId the primary key for the new db map object
	* @return the new db map object
	*/
	public static org.politaktiv.map.infrastructure.model.DbMapObject createDbMapObject(
		long mapObjectId) {
		return getService().createDbMapObject(mapObjectId);
	}

	/**
	* Deletes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapObjectId the primary key of the db map object
	* @throws PortalException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbMapObject(long mapObjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDbMapObject(mapObjectId);
	}

	/**
	* Deletes the db map object from the database. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbMapObject(
		org.politaktiv.map.infrastructure.model.DbMapObject dbMapObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDbMapObject(dbMapObject);
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

	public static org.politaktiv.map.infrastructure.model.DbMapObject fetchDbMapObject(
		long mapObjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDbMapObject(mapObjectId);
	}

	/**
	* Returns the db map object with the primary key.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object
	* @throws PortalException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.DbMapObject getDbMapObject(
		long mapObjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDbMapObject(mapObjectId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.politaktiv.map.infrastructure.model.DbMapObject> getDbMapObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDbMapObjects(start, end);
	}

	/**
	* Returns the number of db map objects.
	*
	* @return the number of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static int getDbMapObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDbMapObjectsCount();
	}

	/**
	* Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @return the db map object that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.DbMapObject updateDbMapObject(
		org.politaktiv.map.infrastructure.model.DbMapObject dbMapObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDbMapObject(dbMapObject);
	}

	/**
	* Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMapObject the db map object
	* @param merge whether to merge the db map object with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db map object that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.DbMapObject updateDbMapObject(
		org.politaktiv.map.infrastructure.model.DbMapObject dbMapObject,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDbMapObject(dbMapObject, merge);
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

	public static java.util.List<org.politaktiv.map.infrastructure.model.DbMapObject> getAllDbMapObjectsFromCompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAllDbMapObjectsFromCompanyIdAndGroupId(companyId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DbMapObjectLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMapObjectLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbMapObjectLocalService.class.getName(), portletClassLoader);

			_service = new DbMapObjectLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbMapObjectLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DbMapObjectLocalService.class);
		}

		return _service;
	}

	public void setService(DbMapObjectLocalService service) {
		MethodCache.remove(DbMapObjectLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbMapObjectLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DbMapObjectLocalService.class);
	}

	private static DbMapObjectLocalService _service;
}