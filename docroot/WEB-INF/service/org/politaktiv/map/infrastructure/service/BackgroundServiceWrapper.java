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
 * Provides a wrapper for {@link BackgroundService}.
 *
 * @author eichi
 * @see BackgroundService
 * @generated
 */
public class BackgroundServiceWrapper implements BackgroundService,
	ServiceWrapper<BackgroundService> {
	public BackgroundServiceWrapper(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _backgroundService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_backgroundService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _backgroundService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _backgroundService.findBycompanyIdAndGroupId(companyId, groupId);
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Background addBackground(
		org.politaktiv.map.infrastructure.model.Background background,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _backgroundService.addBackground(background, groupId);
	}

	@Override
	public void deleteBackground(long backgroundId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_backgroundService.deleteBackground(backgroundId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BackgroundService getWrappedBackgroundService() {
		return _backgroundService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBackgroundService(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	@Override
	public BackgroundService getWrappedService() {
		return _backgroundService;
	}

	@Override
	public void setWrappedService(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	private BackgroundService _backgroundService;
}