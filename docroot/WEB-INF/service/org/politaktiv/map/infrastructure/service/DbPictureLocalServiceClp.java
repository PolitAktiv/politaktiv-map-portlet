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

import org.politaktiv.map.infrastructure.model.DbPicture;

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
public class DbPictureLocalServiceClp implements DbPictureLocalService {
	public DbPictureLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDbPictureMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDbPicture",
				DbPicture.class);

		_createDbPictureMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDbPicture", long.class);

		_deleteDbPictureMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbPicture", long.class);

		_deleteDbPictureMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDbPicture",
				DbPicture.class);

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

		_fetchDbPictureMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDbPicture", long.class);

		_getDbPictureMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbPicture", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", Serializable.class);

		_getDbPicturesMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbPictures", int.class, int.class);

		_getDbPicturesCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDbPicturesCount");

		_updateDbPictureMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbPicture",
				DbPicture.class);

		_updateDbPictureMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDbPicture",
				DbPicture.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", String.class);
	}

	public DbPicture addDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDbPictureMethodKey0,
				ClpSerializer.translateInput(dbPicture));

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
	}

	public DbPicture createDbPicture(
		long pictureId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDbPictureMethodKey1,
				pictureId);

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDbPicture(long pictureId)
		throws PortalException,
			SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbPictureMethodKey2,
				pictureId);

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

	public void deleteDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDbPictureMethodKey3,
				ClpSerializer.translateInput(dbPicture));

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

	public DbPicture fetchDbPicture(
		long pictureId)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDbPictureMethodKey8,
				pictureId);

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
	}

	public DbPicture getDbPicture(
		long pictureId)
		throws PortalException,
			SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbPictureMethodKey9,
				pictureId);

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
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

	public List<DbPicture> getDbPictures(
		int start, int end)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbPicturesMethodKey11,
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

		return (List<DbPicture>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDbPicturesCount()
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDbPicturesCountMethodKey12);

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

	public DbPicture updateDbPicture(
		DbPicture dbPicture)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbPictureMethodKey13,
				ClpSerializer.translateInput(dbPicture));

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
	}

	public DbPicture updateDbPicture(
		DbPicture dbPicture,
		boolean merge)
		throws SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDbPictureMethodKey14,
				ClpSerializer.translateInput(dbPicture), merge);

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

		return (DbPicture)ClpSerializer.translateOutput(returnObj);
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
	private MethodKey _addDbPictureMethodKey0;
	private MethodKey _createDbPictureMethodKey1;
	private MethodKey _deleteDbPictureMethodKey2;
	private MethodKey _deleteDbPictureMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDbPictureMethodKey8;
	private MethodKey _getDbPictureMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDbPicturesMethodKey11;
	private MethodKey _getDbPicturesCountMethodKey12;
	private MethodKey _updateDbPictureMethodKey13;
	private MethodKey _updateDbPictureMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
}