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

package org.politaktiv.map.infrastructure.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.politaktiv.map.infrastructure.NoSuchDbMarkerException;
import org.politaktiv.map.infrastructure.model.DbMarker;
import org.politaktiv.map.infrastructure.service.ClpSerializer;

import java.util.List;

/**
 * The persistence utility for the db marker service. This utility wraps {@link DbMarkerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMarkerPersistence
 * @see DbMarkerPersistenceImpl
 * @generated
 */
public class DbMarkerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DbMarker dbMarker) {
		getPersistence().clearCache(dbMarker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DbMarker> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DbMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DbMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DbMarker update(DbMarker dbMarker, boolean merge)
		throws SystemException {
		return getPersistence().update(dbMarker, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DbMarker update(DbMarker dbMarker, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dbMarker, merge, serviceContext);
	}

	/**
	* Caches the db marker in the entity cache if it is enabled.
	*
	* @param dbMarker the db marker
	*/
	public static void cacheResult(
		DbMarker dbMarker) {
		getPersistence().cacheResult(dbMarker);
	}

	/**
	* Caches the db markers in the entity cache if it is enabled.
	*
	* @param dbMarkers the db markers
	*/
	public static void cacheResult(
		List<DbMarker> dbMarkers) {
		getPersistence().cacheResult(dbMarkers);
	}

	/**
	* Creates a new db marker with the primary key. Does not add the db marker to the database.
	*
	* @param markerId the primary key for the new db marker
	* @return the new db marker
	*/
	public static DbMarker create(
		long markerId) {
		return getPersistence().create(markerId);
	}

	/**
	* Removes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker remove(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException {
		return getPersistence().remove(markerId);
	}

	public static DbMarker updateImpl(
		DbMarker dbMarker, boolean merge)
		throws SystemException {
		return getPersistence().updateImpl(dbMarker, merge);
	}

	/**
	* Returns the db marker with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker
	* @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker findByPrimaryKey(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException {
		return getPersistence().findByPrimaryKey(markerId);
	}

	/**
	* Returns the db marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker, or <code>null</code> if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker fetchByPrimaryKey(
		long markerId)
		throws SystemException {
		return getPersistence().fetchByPrimaryKey(markerId);
	}

	/**
	* Returns the db marker where markerId = &#63; or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbMarkerException} if it could not be found.
	*
	* @param markerId the marker ID
	* @return the matching db marker
	* @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker findBymarkerId(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException {
		return getPersistence().findBymarkerId(markerId);
	}

	/**
	* Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param markerId the marker ID
	* @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker fetchBymarkerId(
		long markerId)
		throws SystemException {
		return getPersistence().fetchBymarkerId(markerId);
	}

	/**
	* Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param markerId the marker ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMarker fetchBymarkerId(
		long markerId, boolean retrieveFromCache)
		throws SystemException {
		return getPersistence().fetchBymarkerId(markerId, retrieveFromCache);
	}

	/**
	* Returns all the db markers.
	*
	* @return the db markers
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMarker> findAll()
		throws SystemException {
		return getPersistence().findAll();
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
	public static List<DbMarker> findAll(
		int start, int end)
		throws SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the db markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db markers
	* @param end the upper bound of the range of db markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of db markers
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMarker> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the db marker where markerId = &#63; from the database.
	*
	* @param markerId the marker ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymarkerId(long markerId)
		throws SystemException,
			NoSuchDbMarkerException {
		getPersistence().removeBymarkerId(markerId);
	}

	/**
	* Removes all the db markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of db markers where markerId = &#63;.
	*
	* @param markerId the marker ID
	* @return the number of matching db markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymarkerId(long markerId)
		throws SystemException {
		return getPersistence().countBymarkerId(markerId);
	}

	/**
	* Returns the number of db markers.
	*
	* @return the number of db markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws SystemException {
		return getPersistence().countAll();
	}

	public static DbMarkerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DbMarkerPersistence)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMarkerPersistence.class.getName());

			ReferenceRegistry.registerReference(DbMarkerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DbMarkerPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DbMarkerUtil.class, "_persistence");
	}

	private static DbMarkerPersistence _persistence;
}