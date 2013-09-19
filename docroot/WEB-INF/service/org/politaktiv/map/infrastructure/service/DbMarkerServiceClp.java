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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * @author eichi
 */
public class DbMarkerServiceClp implements DbMarkerService {
	public DbMarkerServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDbMarkerMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDbMarker",
				DbMarker.class,
				long.class);
	}

	public DbMarker addDbMarker(
		DbMarker dbMarker, long groupId)
		throws SystemException,
			PrincipalException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDbMarkerMethodKey0,
				ClpSerializer.translateInput(dbMarker), groupId);

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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDbMarkerMethodKey0;
}