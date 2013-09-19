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

import org.politaktiv.map.infrastructure.model.DbPicture;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The utility for the db picture remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.DbPictureServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see DbPictureService
 * @see org.politaktiv.map.infrastructure.service.base.DbPictureServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.DbPictureServiceImpl
 * @generated
 */
public class DbPictureServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.DbPictureServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static DbPicture addDbPicture(
		DbPicture dbPicture,
		long groupId)
		throws SystemException,
			PrincipalException {
		return getService().addDbPicture(dbPicture, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DbPictureService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DbPictureService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DbPictureService.class.getName(), portletClassLoader);

			_service = new DbPictureServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DbPictureServiceUtil.class,
				"_service");
			MethodCache.remove(DbPictureService.class);
		}

		return _service;
	}

	public void setService(DbPictureService service) {
		MethodCache.remove(DbPictureService.class);

		_service = service;

		ReferenceRegistry.registerReference(DbPictureServiceUtil.class,
			"_service");
		MethodCache.remove(DbPictureService.class);
	}

	private static DbPictureService _service;
}