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

import java.util.List;
import java.io.Serializable;

import org.politaktiv.map.infrastructure.model.DbPicture;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.model.PersistedModel;

/**
 * The utility for the db picture local service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbPictureLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see DbPictureLocalService
 * @see org.politaktiv.map.infrastructure.service.base.DbPictureLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbPictureLocalServiceImpl
 * @generated
 */
public class DbPictureLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbPictureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the db picture to the database. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @return the db picture that was added
	* @throws SystemException if a system exception occurred
	*/
	public static DbPicture addDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		return getService().addDbPicture(dbPicture);
	}

	/**
	* Creates a new db picture with the primary key. Does not add the db picture to the database.
	*
	* @param pictureId the primary key for the new db picture
	* @return the new db picture
	*/
	public static DbPicture createDbPicture(
		long pictureId) {
		return getService().createDbPicture(pictureId);
	}

	/**
	* Deletes the db picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the db picture
	* @throws PortalException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbPicture(long pictureId)
		throws PortalException,
			SystemException {
		getService().deleteDbPicture(pictureId);
	}

	/**
	* Deletes the db picture from the database. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		getService().deleteDbPicture(dbPicture);
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

	public static DbPicture fetchDbPicture(
		long pictureId)
		throws SystemException {
		return getService().fetchDbPicture(pictureId);
	}

	/**
	* Returns the db picture with the primary key.
	*
	* @param pictureId the primary key of the db picture
	* @return the db picture
	* @throws PortalException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPicture getDbPicture(
		long pictureId)
		throws PortalException,
			SystemException {
		return getService().getDbPicture(pictureId);
	}

	public static PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static List<DbPicture> getDbPictures(
		int start, int end)
		throws SystemException {
		return getService().getDbPictures(start, end);
	}

	/**
	* Returns the number of db pictures.
	*
	* @return the number of db pictures
	* @throws SystemException if a system exception occurred
	*/
	public static int getDbPicturesCount()
		throws SystemException {
		return getService().getDbPicturesCount();
	}

	/**
	* Updates the db picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @return the db picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbPicture updateDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		return getService().updateDbPicture(dbPicture);
	}

	/**
	* Updates the db picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dbPicture the db picture
	* @param merge whether to merge the db picture with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the db picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static DbPicture updateDbPicture(
		DbPicture dbPicture,
		boolean merge)
		throws SystemException {
		return getService().updateDbPicture(dbPicture, merge);
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

	public static DbPictureLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbPictureLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbPictureLocalService.class.getName(), portletClassLoader);

			_service = new DbPictureLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbPictureLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DbPictureLocalService.class);
		}

		return _service;
	}

	public void setService(DbPictureLocalService service) {
		MethodCache.remove(DbPictureLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbPictureLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DbPictureLocalService.class);
	}

	private static DbPictureLocalService _service;
}