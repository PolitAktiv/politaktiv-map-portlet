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

import org.politaktiv.map.infrastructure.NoSuchDbMapObjectException;
import org.politaktiv.map.infrastructure.model.DbMapObject;
import org.politaktiv.map.infrastructure.service.ClpSerializer;

import java.util.List;

/**
 * The persistence utility for the db map object service. This utility wraps {@link DbMapObjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMapObjectPersistence
 * @see DbMapObjectPersistenceImpl
 * @generated
 */
public class DbMapObjectUtil {
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
	public static void clearCache(DbMapObject dbMapObject) {
		getPersistence().clearCache(dbMapObject);
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
	public static List<DbMapObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DbMapObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DbMapObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DbMapObject update(DbMapObject dbMapObject, boolean merge)
		throws SystemException {
		return getPersistence().update(dbMapObject, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DbMapObject update(DbMapObject dbMapObject, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dbMapObject, merge, serviceContext);
	}

	/**
	* Caches the db map object in the entity cache if it is enabled.
	*
	* @param dbMapObject the db map object
	*/
	public static void cacheResult(
		DbMapObject dbMapObject) {
		getPersistence().cacheResult(dbMapObject);
	}

	/**
	* Caches the db map objects in the entity cache if it is enabled.
	*
	* @param dbMapObjects the db map objects
	*/
	public static void cacheResult(
		List<DbMapObject> dbMapObjects) {
		getPersistence().cacheResult(dbMapObjects);
	}

	/**
	* Creates a new db map object with the primary key. Does not add the db map object to the database.
	*
	* @param mapObjectId the primary key for the new db map object
	* @return the new db map object
	*/
	public static DbMapObject create(
		long mapObjectId) {
		return getPersistence().create(mapObjectId);
	}

	/**
	* Removes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object that was removed
	* @throws NoSuchDbMapObjectException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject remove(
		long mapObjectId)
		throws SystemException,
			NoSuchDbMapObjectException {
		return getPersistence().remove(mapObjectId);
	}

	public static DbMapObject updateImpl(
		DbMapObject dbMapObject,
		boolean merge)
		throws SystemException {
		return getPersistence().updateImpl(dbMapObject, merge);
	}

	/**
	* Returns the db map object with the primary key or throws a {@link NoSuchDbMapObjectException} if it could not be found.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object
	* @throws NoSuchDbMapObjectException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject findByPrimaryKey(
		long mapObjectId)
		throws SystemException,
			NoSuchDbMapObjectException {
		return getPersistence().findByPrimaryKey(mapObjectId);
	}

	/**
	* Returns the db map object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object, or <code>null</code> if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject fetchByPrimaryKey(
		long mapObjectId)
		throws SystemException {
		return getPersistence().fetchByPrimaryKey(mapObjectId);
	}

	/**
	* Returns all the db map objects where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId)
		throws SystemException {
		return getPersistence().findBycompanyIdAndgroupId(companyId, groupId);
	}

	/**
	* Returns a range of all the db map objects where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of db map objects
	* @param end the upper bound of the range of db map objects (not inclusive)
	* @return the range of matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId, int start, int end)
		throws SystemException {
		return getPersistence()
				   .findBycompanyIdAndgroupId(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the db map objects where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of db map objects
	* @param end the upper bound of the range of db map objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findBycompanyIdAndgroupId(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching db map object
	* @throws NoSuchDbMapObjectException if a matching db map object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject findBycompanyIdAndgroupId_First(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException {
		return getPersistence()
				   .findBycompanyIdAndgroupId_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching db map object
	* @throws NoSuchDbMapObjectException if a matching db map object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject findBycompanyIdAndgroupId_Last(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException {
		return getPersistence()
				   .findBycompanyIdAndgroupId_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the db map objects before and after the current db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mapObjectId the primary key of the current db map object
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next db map object
	* @throws NoSuchDbMapObjectException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static DbMapObject[] findBycompanyIdAndgroupId_PrevAndNext(
		long mapObjectId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException {
		return getPersistence()
				   .findBycompanyIdAndgroupId_PrevAndNext(mapObjectId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Returns all the db map objects.
	*
	* @return the db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMapObject> findAll()
		throws SystemException {
		return getPersistence().findAll();
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
	public static List<DbMapObject> findAll(
		int start, int end)
		throws SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the db map objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of db map objects
	* @param end the upper bound of the range of db map objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static List<DbMapObject> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the db map objects where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException {
		getPersistence().removeBycompanyIdAndgroupId(companyId, groupId);
	}

	/**
	* Removes all the db map objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of db map objects where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException {
		return getPersistence().countBycompanyIdAndgroupId(companyId, groupId);
	}

	/**
	* Returns the number of db map objects.
	*
	* @return the number of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws SystemException {
		return getPersistence().countAll();
	}

	public static DbMapObjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DbMapObjectPersistence)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMapObjectPersistence.class.getName());

			ReferenceRegistry.registerReference(DbMapObjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DbMapObjectPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DbMapObjectUtil.class,
			"_persistence");
	}

	private static DbMapObjectPersistence _persistence;
}