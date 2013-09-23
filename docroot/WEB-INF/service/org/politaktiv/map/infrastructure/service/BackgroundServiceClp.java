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

import org.politaktiv.map.infrastructure.model.Background;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * @author eichi
 */
public class BackgroundServiceClp implements BackgroundService {
	public BackgroundServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_findBycompanyIdAndGroupIdMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBycompanyIdAndGroupId", long.class, long.class);

		_addBackgroundMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addBackground",
				Background.class,
				long.class);

		_deleteBackgroundMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteBackground", long.class, long.class);
	}

	public List<Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBycompanyIdAndGroupIdMethodKey0,
				companyId, groupId);

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

		return (List<Background>)ClpSerializer.translateOutput(returnObj);
	}

	public Background addBackground(
		Background background,
		long groupId)
		throws SystemException,
			PrincipalException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addBackgroundMethodKey1,
				ClpSerializer.translateInput(background), groupId);

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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (Background)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteBackground(long backgroundId, long groupId)
		throws PortalException,
			SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteBackgroundMethodKey2,
				backgroundId, groupId);

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
	private MethodKey _findBycompanyIdAndGroupIdMethodKey0;
	private MethodKey _addBackgroundMethodKey1;
	private MethodKey _deleteBackgroundMethodKey2;
}