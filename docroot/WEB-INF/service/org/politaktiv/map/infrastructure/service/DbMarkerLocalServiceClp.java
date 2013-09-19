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

import java.io.Serializable;
import java.util.List;

import org.politaktiv.map.infrastructure.model.DbMarker;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author eichi
 */
public class DbMarkerLocalServiceClp implements DbMarkerLocalService {
	public DbMarkerLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDbMarkerMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDbMarker",
				DbMarker.class);

		_createDbMarkerMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDbMarker", long.class);

		_deleteDbMarkerMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbMarker", long.class);

		_deleteDbMarkerMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbMarker",
				DbMarker.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				DynamicQuery.class,
				int.class, int.class,
				OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				DynamicQuery.class);

		_fetchDbMarkerMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDbMarker", long.class);

		_getDbMarkerMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMarker", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", Serializable.class);

		_getDbMarkersMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMarkers", int.class, int.class);

		_getDbMarkersCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMarkersCount");

		_updateDbMarkerMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbMarker",
				DbMarker.class);

		_updateDbMarkerMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbMarker",
				DbMarker.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", String.class);
	}

	public DbMarker addDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDbMarkerMethodKey0,
				ClpSerializer.translateInput(dbMarker));

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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public DbMarker createDbMarker(
		long markerId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDbMarkerMethodKey1,
				markerId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

	public void deleteDbMarker(long markerId)
		throws PortalException,
			SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbMarkerMethodKey2,
				markerId);

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

	public void deleteDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbMarkerMethodKey3,
				ClpSerializer.translateInput(dbMarker));

		try {
			_classLoaderProxy.invoke(methodHandler);
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
	}

	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

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

		return (List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

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

		return (List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public List dynamicQuery(
		DynamicQuery dynamicQuery, int start,
		int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

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

		return (List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		DynamicQuery dynamicQuery)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

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

		return ((Long)returnObj).longValue();
	}

	public DbMarker fetchDbMarker(
		long markerId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDbMarkerMethodKey8,
				markerId);

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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public DbMarker getDbMarker(
		long markerId)
		throws PortalException,
			SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMarkerMethodKey9,
				markerId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public PersistedModel getPersistedModel(
		Serializable primaryKeyObj)
		throws PortalException,
			SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
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

		return (PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public List<DbMarker> getDbMarkers(
		int start, int end)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMarkersMethodKey11,
				start, end);

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

		return (List<DbMarker>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDbMarkersCount()
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMarkersCountMethodKey12);

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

		return ((Integer)returnObj).intValue();
	}

	public DbMarker updateDbMarker(
		DbMarker dbMarker)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbMarkerMethodKey13,
				ClpSerializer.translateInput(dbMarker));

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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public DbMarker updateDbMarker(
		DbMarker dbMarker, boolean merge)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbMarkerMethodKey14,
				ClpSerializer.translateInput(dbMarker), merge);

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

		return (DbMarker)ClpSerializer.translateOutput(returnObj);
	}

	public String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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
	private MethodKey _addDbMarkerMethodKey0;
	private MethodKey _createDbMarkerMethodKey1;
	private MethodKey _deleteDbMarkerMethodKey2;
	private MethodKey _deleteDbMarkerMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDbMarkerMethodKey8;
	private MethodKey _getDbMarkerMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDbMarkersMethodKey11;
	private MethodKey _getDbMarkersCountMethodKey12;
	private MethodKey _updateDbMarkerMethodKey13;
	private MethodKey _updateDbMarkerMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
}