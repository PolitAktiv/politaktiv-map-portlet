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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * @author eichi
 */
public class PictureServiceClp implements PictureService {
	public PictureServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addPictureMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addPicture",
				Picture.class,
				long.class);

		_findByBackgroundIdMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByBackgroundId", long.class);

		_deletePictureMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deletePicture", long.class, long.class, long.class,
				String.class);
	}

	public Picture addPicture(
		Picture picture, long groupId)
		throws SystemException,
			PrincipalException,
			javax.portlet.ValidatorException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addPictureMethodKey0,
				ClpSerializer.translateInput(picture), groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof SystemException) {
				throw (SystemException)t;
			}

			if (t instanceof PrincipalException) {
				throw (PrincipalException)t;
			}

			if (t instanceof javax.portlet.ValidatorException) {
				throw (javax.portlet.ValidatorException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (Picture)ClpSerializer.translateOutput(returnObj);
	}

	public List<Picture> findByBackgroundId(
		long backgroundId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByBackgroundIdMethodKey1,
				backgroundId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof SystemException) {
				throw (SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (List<Picture>)ClpSerializer.translateOutput(returnObj);
	}

	public void deletePicture(long deletePictureId, long userId, long groupId,
		String portletId)
		throws PortalException,
			SystemException {
		MethodHandler methodHandler = new MethodHandler(_deletePictureMethodKey2,
				deletePictureId, userId, groupId,
				ClpSerializer.translateInput(portletId));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof PortalException) {
				throw (PortalException)t;
			}

			if (t instanceof SystemException) {
				throw (SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addPictureMethodKey0;
	private MethodKey _findByBackgroundIdMethodKey1;
	private MethodKey _deletePictureMethodKey2;
}