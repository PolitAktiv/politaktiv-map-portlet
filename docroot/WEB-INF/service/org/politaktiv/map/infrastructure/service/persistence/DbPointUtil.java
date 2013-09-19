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

import org.politaktiv.map.infrastructure.NoSuchDbPointException;
import org.politaktiv.map.infrastructure.model.DbPoint;
import org.politaktiv.map.infrastructure.service.ClpSerializer;

import java.util.List;

/**
 * The persistence utility for the db point service. This utility wraps {@link DbPointPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbPointPersistence
 * @see DbPointPersistenceImpl
 * @generated
 */
public class DbPointUtil {
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
	public static void clearCache(DbPoint dbPoint) {
		getPersistence().clearCache(dbPoint);
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
	public static List<DbPoint> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DbPoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DbPoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DbPoint update(DbPoint dbPoint, boolean merge)
		throws SystemException {
		return getPersistence().update(dbPoint, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DbPoint update(DbPoint dbPoint, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dbPoint, merge, serviceContext);
	}

	/**
	* Caches the db point in the entity cache if it is enabled.
	*
	* @param dbPoint the db point
	*/
	public static void cacheResult(
		DbPoint dbPoint) {
		getPersistence().cacheResult(dbPoint);
	}

	/**
	* Caches the db points in the entity cache if it is enabled.
	*
	* @param dbPoints the db points
	*/
	public static void cacheResult(
		List<DbPoint> dbPoints) {
		getPersistence().cacheResult(dbPoints);
	}

	/**
	* Creates a new db point with the primary key. Does not add the db point to the database.
	*
	* @param pointId the primary key for the new db point
	* @return the new db point
	*/
	public static DbPoint create(
		long pointId) {
		return getPersistence().create(pointId);
	}

	/**
	* Removes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pointId the primary key of the db point
	* @return the db point that was removed
	* @throws NoSuchDbPointException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint remove(
		long pointId)
		throws SystemException,
			NoSuchDbPointException {
		return getPersistence().remove(pointId);
	}

	public static DbPoint updateImpl(
		DbPoint dbPoint, boolean merge)
		throws SystemException {
		return getPersistence().updateImpl(dbPoint, merge);
	}

	/**
	* Returns the db point with the primary key or throws a {@link NoSuchDbPointException} if it could not be found.
	*
	* @param pointId the primary key of the db point
	* @return the db point
	* @throws NoSuchDbPointException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint findByPrimaryKey(
		long pointId)
		throws SystemException,
			NoSuchDbPointException {
		return getPersistence().findByPrimaryKey(pointId);
	}

	/**
	* Returns the db point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pointId the primary key of the db point
	* @return the db point, or <code>null</code> if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint fetchByPrimaryKey(
		long pointId)
		throws SystemException {
		return getPersistence().fetchByPrimaryKey(pointId);
	}

	/**
	* Returns the db point where pointId = &#63; or throws a {@link NoSuchDbPointException} if it could not be found.
	*
	* @param pointId the point ID
	* @return the matching db point
	* @throws NoSuchDbPointException if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint findBypointId(
		long pointId)
		throws SystemException,
			NoSuchDbPointException {
		return getPersistence().findBypointId(pointId);
	}

	/**
	* Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pointId the point ID
	* @return the matching db point, or <code>null</code> if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint fetchBypointId(
		long pointId)
		throws SystemException {
		return getPersistence().fetchBypointId(pointId);
	}

	/**
	* Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pointId the point ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching db point, or <code>null</code> if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbPoint fetchBypointId(
		long pointId, boolean retrieveFromCache)
		throws SystemException {
		return getPersistence().fetchBypointId(pointId, retrieveFromCache);
	}

	/**
	* Returns all the db points.
	*
	* @return the db points
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbPoint> findAll()
		throws SystemException {
		return getPersistence().findAll();
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
	public static List<DbPoint> findAll(
		int start, int end)
		throws SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the db points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db points
	* @param end the upper bound of the range of db points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of db points
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbPoint> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the db point where pointId = &#63; from the database.
	*
	* @param pointId the point ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypointId(long pointId)
		throws SystemException,
			NoSuchDbPointException {
		getPersistence().removeBypointId(pointId);
	}

	/**
	* Removes all the db points from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of db points where pointId = &#63;.
	*
	* @param pointId the point ID
	* @return the number of matching db points
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypointId(long pointId)
		throws SystemException {
		return getPersistence().countBypointId(pointId);
	}

	/**
	* Returns the number of db points.
	*
	* @return the number of db points
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws SystemException {
		return getPersistence().countAll();
	}

	public static DbPointPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DbPointPersistence)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbPointPersistence.class.getName());

			ReferenceRegistry.registerReference(DbPointUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DbPointPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DbPointUtil.class, "_persistence");
	}

	private static DbPointPersistence _persistence;
}