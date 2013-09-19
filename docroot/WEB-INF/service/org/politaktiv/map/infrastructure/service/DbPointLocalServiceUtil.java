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

import org.politaktiv.map.infrastructure.model.DbPoint;

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
 * The utility for the db point local service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbPointLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see DbPointLocalService
 * @see org.politaktiv.map.infrastructure.service.base.DbPointLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbPointLocalServiceImpl
 * @generated
 */
public class DbPointLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbPointLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the db point to the database. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @return the db point that was added
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint addDbPoint(
		DbPoint dbPoint)
		throws SystemException {
		return getService().addDbPoint(dbPoint);
	}

	/**
	* Creates a new db point with the primary key. Does not add the db point to the database.
	*
	* @param pointId the primary key for the new db point
	* @return the new db point
	*/
	public static DbPoint createDbPoint(
		long pointId) {
		return getService().createDbPoint(pointId);
	}

	/**
	* Deletes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pointId the primary key of the db point
	* @throws PortalException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbPoint(long pointId)
		throws PortalException,
			SystemException {
		getService().deleteDbPoint(pointId);
	}

	/**
	* Deletes the db point from the database. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbPoint(
		DbPoint dbPoint)
		throws SystemException {
		getService().deleteDbPoint(dbPoint);
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

	public static DbPoint fetchDbPoint(
		long pointId)
		throws SystemException {
		return getService().fetchDbPoint(pointId);
	}

	/**
	* Returns the db point with the primary key.
	*
	* @param pointId the primary key of the db point
	* @return the db point
	* @throws PortalException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint getDbPoint(
		long pointId)
		throws PortalException,
			SystemException {
		return getService().getDbPoint(pointId);
	}

	public static PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static List<DbPoint> getDbPoints(
		int start, int end)
		throws SystemException {
		return getService().getDbPoints(start, end);
	}

	/**
	* Returns the number of db points.
	*
	* @return the number of db points
	* @throws SystemException if a system exception occurred
	*/
	public static int getDbPointsCount()
		throws SystemException {
		return getService().getDbPointsCount();
	}

	/**
	* Updates the db point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @return the db point that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint updateDbPoint(
		DbPoint dbPoint)
		throws SystemException {
		return getService().updateDbPoint(dbPoint);
	}

	/**
	* Updates the db point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPoint the db point
	* @param merge whether to merge the db point with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db point that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint updateDbPoint(
		DbPoint dbPoint, boolean merge)
		throws SystemException {
		return getService().updateDbPoint(dbPoint, merge);
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

	public static DbPointLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbPointLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbPointLocalService.class.getName(), portletClassLoader);

			_service = new DbPointLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbPointLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DbPointLocalService.class);
		}

		return _service;
	}

	public void setService(DbPointLocalService service) {
		MethodCache.remove(DbPointLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbPointLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DbPointLocalService.class);
	}

	private static DbPointLocalService _service;
}