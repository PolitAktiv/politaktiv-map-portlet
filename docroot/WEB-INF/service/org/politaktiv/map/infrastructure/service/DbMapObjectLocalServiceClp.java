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

import org.politaktiv.map.infrastructure.model.DbMapObject;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;

/**
 * @author eichi
 */
public class DbMapObjectLocalServiceClp implements DbMapObjectLocalService {
	public DbMapObjectLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDbMapObjectMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDbMapObject",
				DbMapObject.class);

		_createDbMapObjectMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDbMapObject", long.class);

		_deleteDbMapObjectMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbMapObject", long.class);

		_deleteDbMapObjectMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbMapObject",
				DbMapObject.class);

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

		_fetchDbMapObjectMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDbMapObject", long.class);

		_getDbMapObjectMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMapObject", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", Serializable.class);

		_getDbMapObjectsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMapObjects", int.class, int.class);

		_getDbMapObjectsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbMapObjectsCount");

		_updateDbMapObjectMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbMapObject",
				DbMapObject.class);

		_updateDbMapObjectMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbMapObject",
				DbMapObject.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", String.class);

		_getAllDbMapObjectsFromCompanyIdAndGroupIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllDbMapObjectsFromCompanyIdAndGroupId", long.class,
				long.class);
	}

	public DbMapObject addDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDbMapObjectMethodKey0,
				ClpSerializer.translateInput(dbMapObject));

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
	}

	public DbMapObject createDbMapObject(long mapObjectId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDbMapObjectMethodKey1,
				mapObjectId);

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDbMapObject(long mapObjectId)
		throws PortalException,
			SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbMapObjectMethodKey2,
				mapObjectId);

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

	public void deleteDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbMapObjectMethodKey3,
				ClpSerializer.translateInput(dbMapObject));

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
	public List dynamicQuery(DynamicQuery dynamicQuery)
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start,
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

	public long dynamicQueryCount(DynamicQuery dynamicQuery)
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

	public DbMapObject fetchDbMapObject(long mapObjectId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDbMapObjectMethodKey8,
				mapObjectId);

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
	}

	public DbMapObject getDbMapObject(
		long mapObjectId)
		throws PortalException,
			SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMapObjectMethodKey9,
				mapObjectId);

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
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

	public List<DbMapObject> getDbMapObjects(
		int start, int end)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMapObjectsMethodKey11,
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

		return (List<DbMapObject>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDbMapObjectsCount()
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbMapObjectsCountMethodKey12);

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

	public DbMapObject updateDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbMapObjectMethodKey13,
				ClpSerializer.translateInput(dbMapObject));

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
	}

	public DbMapObject updateDbMapObject(
		DbMapObject dbMapObject,
		boolean merge)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbMapObjectMethodKey14,
				ClpSerializer.translateInput(dbMapObject), merge);

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

		return (DbMapObject)ClpSerializer.translateOutput(returnObj);
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

	public List<DbMapObject> getAllDbMapObjectsFromCompanyIdAndGroupId(
		long companyId, long groupId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllDbMapObjectsFromCompanyIdAndGroupIdMethodKey17,
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

		return (List<DbMapObject>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDbMapObjectMethodKey0;
	private MethodKey _createDbMapObjectMethodKey1;
	private MethodKey _deleteDbMapObjectMethodKey2;
	private MethodKey _deleteDbMapObjectMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDbMapObjectMethodKey8;
	private MethodKey _getDbMapObjectMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDbMapObjectsMethodKey11;
	private MethodKey _getDbMapObjectsCountMethodKey12;
	private MethodKey _updateDbMapObjectMethodKey13;
	private MethodKey _updateDbMapObjectMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getAllDbMapObjectsFromCompanyIdAndGroupIdMethodKey17;
}