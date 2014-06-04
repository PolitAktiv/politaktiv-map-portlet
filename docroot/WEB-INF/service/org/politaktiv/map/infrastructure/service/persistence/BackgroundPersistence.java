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

import com.liferay.portal.service.persistence.BasePersistence;

import org.politaktiv.map.infrastructure.model.Background;

/**
 * The persistence interface for the background service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see BackgroundPersistenceImpl
 * @see BackgroundUtil
 * @generated
 */
public interface BackgroundPersistence extends BasePersistence<Background> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BackgroundUtil} to access the background persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.infrastructure.model.Background findBycompanyIdAndGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException;

	/**
	* Returns the first background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching background, or <code>null</code> if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Background fetchBycompanyIdAndGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.infrastructure.model.Background findBycompanyIdAndGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException;

	/**
	* Returns the last background in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching background, or <code>null</code> if a matching background could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Background fetchBycompanyIdAndGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.infrastructure.model.Background[] findBycompanyIdAndGroupId_PrevAndNext(
		long backgroundId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException;

	/**
	* Removes all the backgrounds where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of backgrounds where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the background in the entity cache if it is enabled.
	*
	* @param background the background
	*/
	public void cacheResult(
		org.politaktiv.map.infrastructure.model.Background background);

	/**
	* Caches the backgrounds in the entity cache if it is enabled.
	*
	* @param backgrounds the backgrounds
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.Background> backgrounds);

	/**
	* Creates a new background with the primary key. Does not add the background to the database.
	*
	* @param backgroundId the primary key for the new background
	* @return the new background
	*/
	public org.politaktiv.map.infrastructure.model.Background create(
		long backgroundId);

	/**
	* Removes the background with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param backgroundId the primary key of the background
	* @return the background that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Background remove(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException;

	public org.politaktiv.map.infrastructure.model.Background updateImpl(
		org.politaktiv.map.infrastructure.model.Background background)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the background with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchBackgroundException} if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background
	* @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Background findByPrimaryKey(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchBackgroundException;

	/**
	* Returns the background with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param backgroundId the primary key of the background
	* @return the background, or <code>null</code> if a background with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Background fetchByPrimaryKey(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the backgrounds.
	*
	* @return the backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the backgrounds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of backgrounds.
	*
	* @return the number of backgrounds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}