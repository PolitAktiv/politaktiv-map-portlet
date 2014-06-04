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

package org.politaktiv.map.infrastructure.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PictureLocalService}.
 *
 * @author eichi
 * @see PictureLocalService
 * @generated
 */
public class PictureLocalServiceWrapper implements PictureLocalService,
	ServiceWrapper<PictureLocalService> {
	public PictureLocalServiceWrapper(PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	/**
	* Adds the picture to the database. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @return the picture that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture addPicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.addPicture(picture);
	}

	/**
	* Creates a new picture with the primary key. Does not add the picture to the database.
	*
	* @param pictureId the primary key for the new picture
	* @return the new picture
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture createPicture(
		long pictureId) {
		return _pictureLocalService.createPicture(pictureId);
	}

	/**
	* Deletes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the picture
	* @return the picture that was removed
	* @throws PortalException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture deletePicture(
		long pictureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.deletePicture(pictureId);
	}

	/**
	* Deletes the picture from the database. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @return the picture that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture deletePicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.deletePicture(picture);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pictureLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.PictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Picture fetchPicture(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.fetchPicture(pictureId);
	}

	/**
	* Returns the picture with the primary key.
	*
	* @param pictureId the primary key of the picture
	* @return the picture
	* @throws PortalException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture getPicture(
		long pictureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPicture(pictureId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> getPictures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPictures(start, end);
	}

	/**
	* Returns the number of pictures.
	*
	* @return the number of pictures
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPicturesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPicturesCount();
	}

	/**
	* Updates the picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @return the picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.infrastructure.model.Picture updatePicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.updatePicture(picture);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _pictureLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pictureLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _pictureLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.findByBackgroundId(backgroundId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PictureLocalService getWrappedPictureLocalService() {
		return _pictureLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPictureLocalService(
		PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	@Override
	public PictureLocalService getWrappedService() {
		return _pictureLocalService;
	}

	@Override
	public void setWrappedService(PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	private PictureLocalService _pictureLocalService;
}