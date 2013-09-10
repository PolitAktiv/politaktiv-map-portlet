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

import org.politaktiv.map.infrastructure.model.Marker;

import java.util.List;

/**
 * The persistence utility for the marker service. This utility wraps {@link MarkerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see MarkerPersistence
 * @see MarkerPersistenceImpl
 * @generated
 */
public class MarkerUtil {
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
	public static void clearCache(Marker marker) {
		getPersistence().clearCache(marker);
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
	public static List<Marker> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Marker> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Marker> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Marker update(Marker marker, boolean merge)
		throws SystemException {
		return getPersistence().update(marker, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Marker update(Marker marker, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(marker, merge, serviceContext);
	}

	/**
	* Caches the marker in the entity cache if it is enabled.
	*
	* @param marker the marker
	*/
	public static void cacheResult(
		org.politaktiv.map.infrastructure.model.Marker marker) {
		getPersistence().cacheResult(marker);
	}

	/**
	* Caches the markers in the entity cache if it is enabled.
	*
	* @param markers the markers
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.Marker> markers) {
		getPersistence().cacheResult(markers);
	}

	/**
	* Creates a new marker with the primary key. Does not add the marker to the database.
	*
	* @param markerId the primary key for the new marker
	* @return the new marker
	*/
	public static org.politaktiv.map.infrastructure.model.Marker create(
		long markerId) {
		return getPersistence().create(markerId);
	}

	/**
	* Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the marker
	* @return the marker that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker remove(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchMarkerException {
		return getPersistence().remove(markerId);
	}

	public static org.politaktiv.map.infrastructure.model.Marker updateImpl(
		org.politaktiv.map.infrastructure.model.Marker marker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(marker, merge);
	}

	/**
	* Returns the marker with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker
	* @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker findByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchMarkerException {
		return getPersistence().findByPrimaryKey(markerId);
	}

	/**
	* Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker, or <code>null</code> if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker fetchByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(markerId);
	}

	/**
	* Returns all the markers where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the matching markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findBybackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybackgroundId(backgroundId);
	}

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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findBybackgroundId(
		long backgroundId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybackgroundId(backgroundId, start, end);
	}

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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findBybackgroundId(
		long backgroundId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybackgroundId(backgroundId, start, end,
			orderByComparator);
	}

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
	* @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker findBybackgroundId_First(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchMarkerException {
		return getPersistence()
				   .findBybackgroundId_First(backgroundId, orderByComparator);
	}

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
	* @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker findBybackgroundId_Last(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchMarkerException {
		return getPersistence()
				   .findBybackgroundId_Last(backgroundId, orderByComparator);
	}

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
	* @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Marker[] findBybackgroundId_PrevAndNext(
		long markerId, long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchMarkerException {
		return getPersistence()
				   .findBybackgroundId_PrevAndNext(markerId, backgroundId,
			orderByComparator);
	}

	/**
	* Returns all the markers.
	*
	* @return the markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the markers where backgroundId = &#63; from the database.
	*
	* @param backgroundId the background ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybackgroundId(backgroundId);
	}

	/**
	* Removes all the markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of markers where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the number of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybackgroundId(backgroundId);
	}

	/**
	* Returns the number of markers.
	*
	* @return the number of markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MarkerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MarkerPersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.infrastructure.service.ClpSerializer.getServletContextName(),
					MarkerPersistence.class.getName());

			ReferenceRegistry.registerReference(MarkerUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(MarkerPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(MarkerUtil.class, "_persistence");
	}

	private static MarkerPersistence _persistence;
}