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

import org.politaktiv.map.infrastructure.NoSuchDbMarkerException;
import org.politaktiv.map.infrastructure.model.DbMarker;

/**
 * The persistence interface for the db marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMarkerPersistenceImpl
 * @see DbMarkerUtil
 * @generated
 */
public interface DbMarkerPersistence extends BasePersistence<DbMarker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DbMarkerUtil} to access the db marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the db marker in the entity cache if it is enabled.
	*
	* @param dbMarker the db marker
	*/
	public void cacheResult(
		DbMarker dbMarker);

	/**
	* Caches the db markers in the entity cache if it is enabled.
	*
	* @param dbMarkers the db markers
	*/
	public void cacheResult(
		List<DbMarker> dbMarkers);

	/**
	* Creates a new db marker with the primary key. Does not add the db marker to the database.
	*
	* @param markerId the primary key for the new db marker
	* @return the new db marker
	*/
	public DbMarker create(
		long markerId);

	/**
	* Removes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker that was removed
	* @throws NoSuchDbMarkerException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker remove(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException;

	public DbMarker updateImpl(
		DbMarker dbMarker, boolean merge)
		throws SystemException;

	/**
	* Returns the db marker with the primary key or throws a {@link NoSuchDbMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker
	* @throws NoSuchDbMarkerException if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker findByPrimaryKey(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException;

	/**
	* Returns the db marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the db marker
	* @return the db marker, or <code>null</code> if a db marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker fetchByPrimaryKey(
		long markerId)
		throws SystemException;

	/**
	* Returns the db marker where markerId = &#63; or throws a {@link NoSuchDbMarkerException} if it could not be found.
	*
	* @param markerId the marker ID
	* @return the matching db marker
	* @throws NoSuchDbMarkerException if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker findBymarkerId(
		long markerId)
		throws SystemException,
			NoSuchDbMarkerException;

	/**
	* Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param markerId the marker ID
	* @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker fetchBymarkerId(
		long markerId)
		throws SystemException;

	/**
	* Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param markerId the marker ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public DbMarker fetchBymarkerId(
		long markerId, boolean retrieveFromCache)
		throws SystemException;

	/**
	* Returns all the db markers.
	*
	* @return the db markers
	* @throws SystemException if a system exception occurred
	*/
	public List<DbMarker> findAll()
		throws SystemException;

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
	public List<DbMarker> findAll(
		int start, int end)
		throws SystemException;

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
	public List<DbMarker> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

	/**
	* Removes the db marker where markerId = &#63; from the database.
	*
	* @param markerId the marker ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymarkerId(long markerId)
		throws SystemException,
			NoSuchDbMarkerException;

	/**
	* Removes all the db markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws SystemException;

	/**
	* Returns the number of db markers where markerId = &#63;.
	*
	* @param markerId the marker ID
	* @return the number of matching db markers
	* @throws SystemException if a system exception occurred
	*/
	public int countBymarkerId(long markerId)
		throws SystemException;

	/**
	* Returns the number of db markers.
	*
	* @return the number of db markers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws SystemException;
}