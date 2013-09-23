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

package org.politaktiv.map.infrastructure.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.MarkerSoap;
import org.politaktiv.map.infrastructure.service.MarkerServiceUtil;

import java.rmi.RemoteException;
import java.util.List;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link org.politaktiv.map.infrastructure.service.MarkerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.politaktiv.map.infrastructure.model.MarkerSoap}.
 * If the method in the service utility returns a
 * {@link org.politaktiv.map.infrastructure.model.Marker}, that is translated to a
 * {@link org.politaktiv.map.infrastructure.model.MarkerSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    eichi
 * @see       MarkerServiceHttp
 * @see       org.politaktiv.map.infrastructure.model.MarkerSoap
 * @see       org.politaktiv.map.infrastructure.service.MarkerServiceUtil
 * @generated
 */
public class MarkerServiceSoap {
	public static MarkerSoap addMarker(
		Marker marker, long groupId)
		throws RemoteException {
		try {
			Marker returnValue = MarkerServiceUtil.addMarker(marker,
					groupId);

			return MarkerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Marker[] findMarkerByBackgroundId(
		long backgroundId) throws RemoteException {
		try {
			List<Marker> returnValue =
				MarkerServiceUtil.findMarkerByBackgroundId(backgroundId);

			return returnValue.toArray(new Marker[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMarker(long markerId, long userId, long groupId,
		String portletId) throws RemoteException {
		try {
			MarkerServiceUtil.deleteMarker(markerId, userId, groupId, portletId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MarkerServiceSoap.class);
}