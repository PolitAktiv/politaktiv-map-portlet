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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * @author eichi
 */
public class DbPictureServiceClp implements DbPictureService {
	public DbPictureServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDbPictureMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDbPicture",
				DbPicture.class,
				long.class);
	}

	public DbPicture addDbPicture(
		DbPicture dbPicture,
		long groupId)
		throws SystemException,
			PrincipalException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDbPictureMethodKey0,
				ClpSerializer.translateInput(dbPicture), groupId);

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDbPictureMethodKey0;
}