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

package org.politaktiv.map.infrastructure.service;

import org.politaktiv.map.infrastructure.model.DbMarker;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The utility for the db marker remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbMarkerServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see DbMarkerService
 * @see org.politaktiv.map.infrastructure.service.base.DbMarkerServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbMarkerServiceImpl
 * @generated
 */
public class DbMarkerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbMarkerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static DbMarker addDbMarker(
		DbMarker dbMarker, long groupId)
		throws SystemException,
			PrincipalException {
		return getService().addDbMarker(dbMarker, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DbMarkerService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMarkerService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbMarkerService.class.getName(), portletClassLoader);

			_service = new DbMarkerServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbMarkerServiceUtil.class,
				"_service");
			MethodCache.remove(DbMarkerService.class);
		}

		return _service;
	}

	public void setService(DbMarkerService service) {
		MethodCache.remove(DbMarkerService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbMarkerServiceUtil.class,
			"_service");
		MethodCache.remove(DbMarkerService.class);
	}

	private static DbMarkerService _service;
}