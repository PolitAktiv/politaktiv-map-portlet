/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.politaktiv.map.infrastructure.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.politaktiv.map.infrastructure.model.Background;

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
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
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
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Background update(Background background)
		throws SystemException {
		return getPersistence().update(background);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Background update(Background background,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(background, serviceContext);
	}

	/**
	* Returns all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Returns a range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @return the range of matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycompanyIdAndGroupId(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycompanyIdAndGroupId(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching background
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background findBycompanyIdAndGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching background, or <code>null</code> if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background fetchBycompanyIdAndGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycompanyIdAndGroupId_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching background
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background findBycompanyIdAndGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching background, or <code>null</code> if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background fetchBycompanyIdAndGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycompanyIdAndGroupId_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the backgrounds before and after the current background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param backgroundId the primary key of the current background
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next background
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background[] findBycompanyIdAndGroupId_PrevAndNext(
		long backgroundId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException {
		return getPersistence()
				   .findBycompanyIdAndGroupId_PrevAndNext(backgroundId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Removes all the backgrounds where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycompanyIdAndGroupId(companyId, groupId);
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
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycompanyIdAndGroupId(companyId, groupId);
	}

	/**
	* Caches the background in the entity cache if it is enabled.
	*
	* @param background the background
	*/
	public static void cacheResult(
		org.politaktiv.map.infrastructure.model.Background background) {
		getPersistence().cacheResult(background);
	}

	/**
	* Caches the backgrounds in the entity cache if it is enabled.
	*
	* @param backgrounds the backgrounds
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.Background> backgrounds) {
		getPersistence().cacheResult(backgrounds);
	}

	/**
	* Creates a new background with the primary key. Does not add the background to the database.
	*
	* @param backgroundId the primary key for the new background
	* @return the new background
	*/
	public static org.politaktiv.map.infrastructure.model.Background create(
		long backgroundId) {
		return getPersistence().create(backgroundId);
	}

	/**
	* Removes the background with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param backgroundId the primary key of the background
	* @return the background that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background remove(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException {
		return getPersistence().remove(backgroundId);
	}

	public static org.politaktiv.map.infrastructure.model.Background updateImpl(
		org.politaktiv.map.infrastructure.model.Background background)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(background);
	}

	/**
	* Returns the background with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchBackgroundException} if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background findByPrimaryKey(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException {
		return getPersistence().findByPrimaryKey(backgroundId);
	}

	/**
	* Returns the background with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background, or <code>null</code> if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Background fetchByPrimaryKey(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(backgroundId);
	}

	/**
	* Returns all the backgrounds.
	*
	* @return the backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the backgrounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @return the range of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the backgrounds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of backgrounds
	* @param end the upper bound of the range of backgrounds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the backgrounds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of backgrounds.
	*
	* @return the number of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BackgroundPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BackgroundPersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.infrastructure.service.ClpSerializer.getServletContextName(),
					BackgroundPersistence.class.getName());

			ReferenceRegistry.registerReference(BackgroundUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BackgroundPersistence persistence) {
	}

	private static BackgroundPersistence _persistence;
}