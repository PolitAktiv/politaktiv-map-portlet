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

import org.politaktiv.map.infrastructure.model.Picture;

import java.util.List;

/**
 * The persistence utility for the picture service. This utility wraps {@link PicturePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see PicturePersistence
 * @see PicturePersistenceImpl
 * @generated
 */
public class PictureUtil {
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
	public static void clearCache(Picture picture) {
		getPersistence().clearCache(picture);
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
	public static List<Picture> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Picture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Picture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Picture update(Picture picture) throws SystemException {
		return getPersistence().update(picture);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Picture update(Picture picture, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(picture, serviceContext);
	}

	/**
	* Returns all the pictures where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybackgroundId(backgroundId);
	}

	/**
	* Returns a range of all the pictures where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param backgroundId the background ID
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @return the range of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybackgroundId(backgroundId, start, end);
	}

	/**
	* Returns an ordered range of all the pictures where backgroundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param backgroundId the background ID
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybackgroundId(backgroundId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first picture in the ordered set where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture findBybackgroundId_First(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence()
				   .findBybackgroundId_First(backgroundId, orderByComparator);
	}

	/**
	* Returns the first picture in the ordered set where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching picture, or <code>null</code> if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture fetchBybackgroundId_First(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybackgroundId_First(backgroundId, orderByComparator);
	}

	/**
	* Returns the last picture in the ordered set where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture findBybackgroundId_Last(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence()
				   .findBybackgroundId_Last(backgroundId, orderByComparator);
	}

	/**
	* Returns the last picture in the ordered set where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching picture, or <code>null</code> if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture fetchBybackgroundId_Last(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybackgroundId_Last(backgroundId, orderByComparator);
	}

	/**
	* Returns the pictures before and after the current picture in the ordered set where backgroundId = &#63;.
	*
	* @param pictureId the primary key of the current picture
	* @param backgroundId the background ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture[] findBybackgroundId_PrevAndNext(
		long pictureId, long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence()
				   .findBybackgroundId_PrevAndNext(pictureId, backgroundId,
			orderByComparator);
	}

	/**
	* Removes all the pictures where backgroundId = &#63; from the database.
	*
	* @param backgroundId the background ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybackgroundId(backgroundId);
	}

	/**
	* Returns the number of pictures where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the number of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybackgroundId(backgroundId);
	}

	/**
	* Returns all the pictures where name = &#63;.
	*
	* @param name the name
	* @return the matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns a range of all the pictures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @return the range of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	/**
	* Returns an ordered range of all the pictures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

	/**
	* Returns the first picture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

	/**
	* Returns the first picture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching picture, or <code>null</code> if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture fetchByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname_First(name, orderByComparator);
	}

	/**
	* Returns the last picture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

	/**
	* Returns the last picture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching picture, or <code>null</code> if a matching picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture fetchByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByname_Last(name, orderByComparator);
	}

	/**
	* Returns the pictures before and after the current picture in the ordered set where name = &#63;.
	*
	* @param pictureId the primary key of the current picture
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture[] findByname_PrevAndNext(
		long pictureId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence()
				   .findByname_PrevAndNext(pictureId, name, orderByComparator);
	}

	/**
	* Removes all the pictures where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByname(name);
	}

	/**
	* Returns the number of pictures where name = &#63;.
	*
	* @param name the name
	* @return the number of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the picture in the entity cache if it is enabled.
	*
	* @param picture the picture
	*/
	public static void cacheResult(
		org.politaktiv.map.infrastructure.model.Picture picture) {
		getPersistence().cacheResult(picture);
	}

	/**
	* Caches the pictures in the entity cache if it is enabled.
	*
	* @param pictures the pictures
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.Picture> pictures) {
		getPersistence().cacheResult(pictures);
	}

	/**
	* Creates a new picture with the primary key. Does not add the picture to the database.
	*
	* @param pictureId the primary key for the new picture
	* @return the new picture
	*/
	public static org.politaktiv.map.infrastructure.model.Picture create(
		long pictureId) {
		return getPersistence().create(pictureId);
	}

	/**
	* Removes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the picture
	* @return the picture that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture remove(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence().remove(pictureId);
	}

	public static org.politaktiv.map.infrastructure.model.Picture updateImpl(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(picture);
	}

	/**
	* Returns the picture with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchPictureException} if it could not be found.
	*
	* @param pictureId the primary key of the picture
	* @return the picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture findByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException {
		return getPersistence().findByPrimaryKey(pictureId);
	}

	/**
	* Returns the picture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pictureId the primary key of the picture
	* @return the picture, or <code>null</code> if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.infrastructure.model.Picture fetchByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(pictureId);
	}

	/**
	* Returns all the pictures.
	*
	* @return the pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @return the range of pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pictures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the pictures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pictures.
	*
	* @return the number of pictures
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PicturePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PicturePersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.infrastructure.service.ClpSerializer.getServletContextName(),
					PicturePersistence.class.getName());

			ReferenceRegistry.registerReference(PictureUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PicturePersistence persistence) {
	}

	private static PicturePersistence _persistence;
}