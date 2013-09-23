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

import org.politaktiv.map.infrastructure.model.Picture;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The utility for the picture remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.PictureServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see PictureService
 * @see org.politaktiv.map.infrastructure.service.base.PictureServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.PictureServiceImpl
 * @generated
 */
public class PictureServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.PictureServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static Picture addPicture(
		Picture picture, long groupId)
		throws SystemException,
			PrincipalException,
			javax.portlet.ValidatorException {
		return getService().addPicture(picture, groupId);
	}

	public static List<Picture> findByBackgroundId(
		long backgroundId)
		throws SystemException {
		return getService().findByBackgroundId(backgroundId);
	}

	public static void deletePicture(long deletePictureId, long userId,
		long groupId, String portletId)
		throws PortalException,
			SystemException {
		getService().deletePicture(deletePictureId, userId, groupId, portletId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PictureService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PictureService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					PictureService.class.getName(), portletClassLoader);

			_service = new PictureServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(PictureServiceUtil.class,
				"_service");
			MethodCache.remove(PictureService.class);
		}

		return _service;
	}

	public void setService(PictureService service) {
		MethodCache.remove(PictureService.class);

		_service = service;

		ReferenceRegistry.registerReference(PictureServiceUtil.class, "_service");
		MethodCache.remove(PictureService.class);
	}

	private static PictureService _service;
}