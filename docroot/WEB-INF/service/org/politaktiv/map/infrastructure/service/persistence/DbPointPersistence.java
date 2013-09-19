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

import org.politaktiv.map.infrastructure.NoSuchDbPointException;
import org.politaktiv.map.infrastructure.model.DbPoint;

/**
 * The persistence interface for the db point service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbPointPersistenceImpl
 * @see DbPointUtil
 * @generated
 */
public interface DbPointPersistence extends BasePersistence<DbPoint> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DbPointUtil} to access the db point persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the db point in the entity cache if it is enabled.
	*
	* @param dbPoint the db point
	*/
	public void cacheResult(
		DbPoint dbPoint);

	/**
	* Caches the db points in the entity cache if it is enabled.
	*
	* @param dbPoints the db points
	*/
	public void cacheResult(
		List<DbPoint> dbPoints);

	/**
	* Creates a new db point with the primary key. Does not add the db point to the database.
	*
	* @param pointId the primary key for the new db point
	* @return the new db point
	*/
	public DbPoint create(long pointId);

	/**
	* Removes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pointId the primary key of the db point
	* @return the db point that was removed
	* @throws NoSuchDbPointException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint remove(long pointId)
		throws SystemException,
			NoSuchDbPointException;

	public DbPoint updateImpl(
		DbPoint dbPoint, boolean merge)
		throws SystemException;

	/**
	* Returns the db point with the primary key or throws a {@link NoSuchDbPointException} if it could not be found.
	*
	* @param pointId the primary key of the db point
	* @return the db point
	* @throws NoSuchDbPointException if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint findByPrimaryKey(
		long pointId)
		throws SystemException,
			NoSuchDbPointException;

	/**
	* Returns the db point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pointId the primary key of the db point
	* @return the db point, or <code>null</code> if a db point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint fetchByPrimaryKey(
		long pointId)
		throws SystemException;

	/**
	* Returns the db point where pointId = &#63; or throws a {@link NoSuchDbPointException} if it could not be found.
	*
	* @param pointId the point ID
	* @return the matching db point
	* @throws NoSuchDbPointException if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint findBypointId(
		long pointId)
		throws SystemException,
			NoSuchDbPointException;

	/**
	* Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pointId the point ID
	* @return the matching db point, or <code>null</code> if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint fetchBypointId(
		long pointId)
		throws SystemException;

	/**
	* Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pointId the point ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching db point, or <code>null</code> if a matching db point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbPoint fetchBypointId(
		long pointId, boolean retrieveFromCache)
		throws SystemException;

	/**
	* Returns all the db points.
	*
	* @return the db points
	* @throws SystemException if a system exception occurred
	*/
	public List<DbPoint> findAll()
		throws SystemException;

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
	public List<DbPoint> findAll(
		int start, int end)
		throws SystemException;

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
	public List<DbPoint> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

	/**
	* Removes the db point where pointId = &#63; from the database.
	*
	* @param pointId the point ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypointId(long pointId)
		throws SystemException,
			NoSuchDbPointException;

	/**
	* Removes all the db points from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws SystemException;

	/**
	* Returns the number of db points where pointId = &#63;.
	*
	* @param pointId the point ID
	* @return the number of matching db points
	* @throws SystemException if a system exception occurred
	*/
	public int countBypointId(long pointId)
		throws SystemException;

	/**
	* Returns the number of db points.
	*
	* @return the number of db points
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws SystemException;
}