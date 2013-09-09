/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
/**
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.politaktiv.map.infrastructure.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the marker remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.MarkerServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see MarkerService
 * @see org.politaktiv.map.infrastructure.service.base.MarkerServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.MarkerServiceImpl
 * @generated
 */
public class MarkerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.MarkerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static org.politaktiv.map.infrastructure.model.Marker addMarker(
		org.politaktiv.map.infrastructure.model.Marker marker, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			javax.portlet.ValidatorException {
		return getService().addMarker(marker, groupId);
	}

	public static java.util.List<org.politaktiv.map.infrastructure.model.Marker> findMarkerByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findMarkerByBackgroundId(backgroundId);
	}

	public static void deleteMarker(long markerId, long userId, long groupId,
		java.lang.String portletId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		getService().deleteMarker(markerId, userId, groupId, portletId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MarkerService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MarkerService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					MarkerService.class.getName(), portletClassLoader);

			_service = new MarkerServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(MarkerServiceUtil.class,
				"_service");
			MethodCache.remove(MarkerService.class);
		}

		return _service;
	}

	public void setService(MarkerService service) {
		MethodCache.remove(MarkerService.class);

		_service = service;

		ReferenceRegistry.registerReference(MarkerServiceUtil.class, "_service");
		MethodCache.remove(MarkerService.class);
	}

	private static MarkerService _service;
}