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

import org.politaktiv.map.infrastructure.NoSuchMarkerException;
import org.politaktiv.map.infrastructure.model.Marker;

/**
 * The persistence interface for the marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see MarkerPersistenceImpl
 * @see MarkerUtil
 * @generated
 */
public interface MarkerPersistence extends BasePersistence<Marker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarkerUtil} to access the marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the marker in the entity cache if it is enabled.
	*
	* @param marker the marker
	*/
	public void cacheResult(
		Marker marker);

	/**
	* Caches the markers in the entity cache if it is enabled.
	*
	* @param markers the markers
	*/
	public void cacheResult(
		List<Marker> markers);

	/**
	* Creates a new marker with the primary key. Does not add the marker to the database.
	*
	* @param markerId the primary key for the new marker
	* @return the new marker
	*/
	public Marker create(long markerId);

	/**
	* Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the marker
	* @return the marker that was removed
	* @throws NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker remove(long markerId)
		throws SystemException,
			NoSuchMarkerException;

	public Marker updateImpl(
		Marker marker, boolean merge)
		throws SystemException;

	/**
	* Returns the marker with the primary key or throws a {@link NoSuchMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker
	* @throws NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker findByPrimaryKey(
		long markerId)
		throws SystemException,
			NoSuchMarkerException;

	/**
	* Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker, or <code>null</code> if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker fetchByPrimaryKey(
		long markerId)
		throws SystemException;

	/**
	* Returns all the markers where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the matching markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findBybackgroundId(
		long backgroundId)
		throws SystemException;

	/**
	* Returns a range of all the markers where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param backgroundId the background ID
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @return the range of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findBybackgroundId(
		long backgroundId, int start, int end)
		throws SystemException;

	/**
	* Returns an ordered range of all the markers where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param backgroundId the background ID
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findBybackgroundId(
		long backgroundId, int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

	/**
	* Returns the first marker in the ordered set where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marker
	* @throws NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker findBybackgroundId_First(
		long backgroundId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchMarkerException;

	/**
	* Returns the last marker in the ordered set where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marker
	* @throws NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker findBybackgroundId_Last(
		long backgroundId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchMarkerException;

	/**
	* Returns the markers before and after the current marker in the ordered set where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param markerId the primary key of the current marker
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marker
	* @throws NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public Marker[] findBybackgroundId_PrevAndNext(
		long markerId, long backgroundId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchMarkerException;

	/**
	* Returns all the markers.
	*
	* @return the markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findAll()
		throws SystemException;

	/**
	* Returns a range of all the markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @return the range of markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findAll(
		int start, int end)
		throws SystemException;

	/**
	* Returns an ordered range of all the markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of markers
	* @throws SystemException if a system exception occurred
	*/
	public List<Marker> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException;

	/**
	* Removes all the markers where backgroundId = &#63; from the database.
	*
	* @param backgroundId the background ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybackgroundId(long backgroundId)
		throws SystemException;

	/**
	* Removes all the markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws SystemException;

	/**
	* Returns the number of markers where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the number of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public int countBybackgroundId(long backgroundId)
		throws SystemException;

	/**
	* Returns the number of markers.
	*
	* @return the number of markers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws SystemException;
}