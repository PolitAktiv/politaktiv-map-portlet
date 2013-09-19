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

import java.util.List;

import org.politaktiv.map.infrastructure.model.DbMapObject;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the db map object remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbMapObjectServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see DbMapObjectService
 * @see org.politaktiv.map.infrastructure.service.base.DbMapObjectServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbMapObjectServiceImpl
 * @generated
 */
public class DbMapObjectServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbMapObjectServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<DbMapObject> getAllDbMapObjectsFromCompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		return getService()
				   .getAllDbMapObjectsFromCompanyIdAndGroupId(companyId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DbMapObjectService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbMapObjectService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbMapObjectService.class.getName(), portletClassLoader);

			_service = new DbMapObjectServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbMapObjectServiceUtil.class,
				"_service");
			MethodCache.remove(DbMapObjectService.class);
		}

		return _service;
	}

	public void setService(DbMapObjectService service) {
		MethodCache.remove(DbMapObjectService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbMapObjectServiceUtil.class,
			"_service");
		MethodCache.remove(DbMapObjectService.class);
	}

	private static DbMapObjectService _service;
}