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

import org.politaktiv.map.infrastructure.model.DbMarker;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.model.PersistedModel;

/**
 * The utility for the db marker local service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbMarkerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see DbMarkerLocalService
 * @see org.politaktiv.map.infrastructure.service.base.DbMarkerLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbMarkerLocalServiceImpl
 * @generated
 */
public class DbMarkerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbMarkerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the db marker to the database. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @return the db marker that was added
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker addDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		return getService().addDbMarker(dbMarker);
	}

	/**
	* Creates a new db marker with the primary key. Does not add the db marker to the database.
	*
	* @param markerId the primary key for the new db marker
	* @return the new db marker
	*/
	public static DbMarker createDbMarker(
		long markerId) {
		return getService().createDbMarker(markerId);
	}

	/**
	* Deletes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the db marker
	* @throws PortalException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbMarker(long markerId)
		throws PortalException,
			SystemException {
		getService().deleteDbMarker(markerId);
	}

	/**
	* Deletes the db marker from the database. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		getService().deleteDbMarker(dbMarker);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static List dynamicQuery(
		DynamicQuery dynamicQuery)
		throws SystemException {
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
	public static List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
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
	public static List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end,
		OrderByComparator orderByComparator)
		throws SystemException {
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
		DynamicQuery dynamicQuery)
		throws SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static DbMarker fetchDbMarker(
		long markerId)
		throws SystemException {
		return getService().fetchDbMarker(markerId);
	}

	/**
	* Returns the db marker with the primary key.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker
	* @throws PortalException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker getDbMarker(
		long markerId)
		throws PortalException,
			SystemException {
		return getService().getDbMarker(markerId);
	}

	public static PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static List<DbMarker> getDbMarkers(
		int start, int end)
		throws SystemException {
		return getService().getDbMarkers(start, end);
	}

	/**
	* Returns the number of db markers.
	*
	* @return the number of db markers
	* @throws SystemException if a system exception occurred
	*/
	public static int getDbMarkersCount()
		throws SystemException {
		return getService().getDbMarkersCount();
	}

	/**
	* Updates the db marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @return the db marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker updateDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		return getService().updateDbMarker(dbMarker);
	}

	/**
	* Updates the db marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbMarker the db marker
	* @param merge whether to merge the db marker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker updateDbMarker(
		DbMarker dbMarker, boolean merge)
		throws SystemException {
		return getService().updateDbMarker(dbMarker, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static DbMarkerLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMarkerLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbMarkerLocalService.class.getName(), portletClassLoader);

			_service = new DbMarkerLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbMarkerLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DbMarkerLocalService.class);
		}

		return _service;
	}

	public void setService(DbMarkerLocalService service) {
		MethodCache.remove(DbMarkerLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbMarkerLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DbMarkerLocalService.class);
	}

	private static DbMarkerLocalService _service;
}