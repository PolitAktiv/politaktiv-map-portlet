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

import org.politaktiv.map.infrastructure.NoSuchBackgroundException;
import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.service.ClpSerializer;

import java.util.List;

/**
 * The persistence utility for the background service. This utility wraps {@link BackgroundPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see BackgroundPersistence
 * @see BackgroundPersistenceImpl
 * @generated
 */
public class BackgroundUtil {
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
	public static void clearCache(Background background) {
		getPersistence().clearCache(background);
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
	public static List<Background> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Background> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Background> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Background update(Background background, boolean merge)
		throws SystemException {
		return getPersistence().update(background, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Background update(Background background, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(background, merge, serviceContext);
	}

	/**
	* Caches the background in the entity cache if it is enabled.
	*
	* @param background the background
	*/
	public static void cacheResult(
		Background background) {
		getPersistence().cacheResult(background);
	}

	/**
	* Caches the backgrounds in the entity cache if it is enabled.
	*
	* @param backgrounds the backgrounds
	*/
	public static void cacheResult(
		List<Background> backgrounds) {
		getPersistence().cacheResult(backgrounds);
	}

	/**
	* Creates a new background with the primary key. Does not add the background to the database.
	*
	* @param backgroundId the primary key for the new background
	* @return the new background
	*/
	public static Background create(
		long backgroundId) {
		return getPersistence().create(backgroundId);
	}

	/**
	* Removes the background with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param backgroundId the primary key of the background
	* @return the background that was removed
	* @throws NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background remove(
		long backgroundId)
		throws SystemException,
			NoSuchBackgroundException {
		return getPersistence().remove(backgroundId);
	}

	public static Background updateImpl(
		Background background,
		boolean merge)
		throws SystemException {
		return getPersistence().updateImpl(background, merge);
	}

	/**
	* Returns the background with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchBackgroundException} if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background
	* @throws NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background findByPrimaryKey(
		long backgroundId)
		throws SystemException,
			NoSuchBackgroundException {
		return getPersistence().findByPrimaryKey(backgroundId);
	}

	/**
	* Returns the background with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background, or <code>null</code> if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background fetchByPrimaryKey(
		long backgroundId)
		throws SystemException {
		return getPersistence().fetchByPrimaryKey(backgroundId);
	}

	/**
	* Returns all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		return getPersistence().findBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Returns a range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @return the range of matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end)
		throws SystemException {
		return getPersistence()
				   .findBycompanyIdAndGroupId(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findBycompanyIdAndGroupId(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching background
	* @throws NoSuchBackgroundException if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background findBycompanyIdAndGroupId_First(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching background
	* @throws NoSuchBackgroundException if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background findBycompanyIdAndGroupId_Last(
		long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the backgrounds before and after the current background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param backgroundId the primary key of the current background
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next background
	* @throws NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static Background[] findBycompanyIdAndGroupId_PrevAndNext(
		long backgroundId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws SystemException,
			NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_PrevAndNext(backgroundId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Returns all the backgrounds.
	*
	* @return the backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findAll()
		throws SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the backgrounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @return the range of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findAll(
		int start, int end)
		throws SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the backgrounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static List<Background> findAll(
		int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the backgrounds where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycompanyIdAndGroupId(long companyId, long groupId)
		throws SystemException {
		getPersistence().removeBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Removes all the backgrounds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws SystemException {
		return getPersistence().countBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Returns the number of backgrounds.
	*
	* @return the number of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws SystemException {
		return getPersistence().countAll();
	}

	public static BackgroundPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BackgroundPersistence)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BackgroundPersistence.class.getName());

			ReferenceRegistry.registerReference(BackgroundUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BackgroundPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BackgroundUtil.class, "_persistence");
	}

	private static BackgroundPersistence _persistence;
}