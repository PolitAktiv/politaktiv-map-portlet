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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.BasePersistence;

import org.politaktiv.map.infrastructure.NoSuchDbMapObjectException;
import org.politaktiv.map.infrastructure.model.DbMapObject;

/**
 * The persistence interface for the db map object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMapObjectPersistenceImpl
 * @see DbMapObjectUtil
 * @generated
 */
public interface DbMapObjectPersistence extends BasePersistence<DbMapObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DbMapObjectUtil} to access the db map object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the db map object in the entity cache if it is enabled.
	*
	* @param dbMapObject the db map object
	*/
	public void cacheResult(
		DbMapObject dbMapObject);

	/**
	* Caches the db map objects in the entity cache if it is enabled.
	*
	* @param dbMapObjects the db map objects
	*/
	public void cacheResult(
		List<DbMapObject> dbMapObjects);

	/**
	* Creates a new db map object with the primary key. Does not add the db map object to the database.
	*
	* @param mapObjectId the primary key for the new db map object
	* @return the new db map object
	*/
	public DbMapObject create(
		long mapObjectId);

	/**
	* Removes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object that was removed
	* @throws NoSuchDbMapObjectException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject remove(
		long mapObjectId)
		throws SystemException,
			NoSuchDbMapObjectException;

	public DbMapObject updateImpl(
		DbMapObject dbMapObject,
		boolean merge)
		throws SystemException;

	/**
	* Returns the db map object with the primary key or throws a {@link NoSuchDbMapObjectException} if it could not be found.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object
	* @throws NoSuchDbMapObjectException if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject findByPrimaryKey(
		long mapObjectId)
		throws SystemException,
			NoSuchDbMapObjectException;

	/**
	* Returns the db map object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapObjectId the primary key of the db map object
	* @return the db map object, or <code>null</code> if a db map object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMapObject fetchByPrimaryKey(
		long mapObjectId)
		throws SystemException;

	/**
	* Returns all the db map objects where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId)
		throws SystemException;

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
	public List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId, int start, int end)
		throws SystemException;

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
	public List<DbMapObject> findBycompanyIdAndgroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

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
	public DbMapObject findBycompanyIdAndgroupId_First(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException;

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
	public DbMapObject findBycompanyIdAndgroupId_Last(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException;

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
	public DbMapObject[] findBycompanyIdAndgroupId_PrevAndNext(
		long mapObjectId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchDbMapObjectException;

	/**
	* Returns all the db map objects.
	*
	* @return the db map objects
	* @throws SystemException if a system exception occurred
	*/
	public List<DbMapObject> findAll()
		throws SystemException;

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
	public List<DbMapObject> findAll(
		int start, int end)
		throws SystemException;

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
	public List<DbMapObject> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

	/**
	* Removes all the db map objects where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException;

	/**
	* Removes all the db map objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws SystemException;

	/**
	* Returns the number of db map objects where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching db map objects
	* @throws SystemException if a system exception occurred
	*/
	public int countBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException;

	/**
	* Returns the number of db map objects.
	*
	* @return the number of db map objects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws SystemException;
}