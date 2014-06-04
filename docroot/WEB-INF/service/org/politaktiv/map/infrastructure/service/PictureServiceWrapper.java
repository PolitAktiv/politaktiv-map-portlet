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
 * Provides a wrapper for {@link PictureService}.
 *
 * @author eichi
 * @see PictureService
 * @generated
 */
public class PictureServiceWrapper implements PictureService,
	ServiceWrapper<PictureService> {
	public PictureServiceWrapper(PictureService pictureService) {
		_pictureService = pictureService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _pictureService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pictureService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _pictureService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Picture addPicture(
		org.politaktiv.map.infrastructure.model.Picture picture, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			javax.portlet.ValidatorException {
		return _pictureService.addPicture(picture, groupId);
	}

	@Override
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureService.findByBackgroundId(backgroundId);
	}

	@Override
	public void deletePicture(long deletePictureId, long userId, long groupId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pictureService.deletePicture(deletePictureId, userId, groupId,
			portletId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PictureService getWrappedPictureService() {
		return _pictureService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPictureService(PictureService pictureService) {
		_pictureService = pictureService;
	}

	@Override
	public PictureService getWrappedService() {
		return _pictureService;
	}

	@Override
	public void setWrappedService(PictureService pictureService) {
		_pictureService = pictureService;
	}

	private PictureService _pictureService;
}