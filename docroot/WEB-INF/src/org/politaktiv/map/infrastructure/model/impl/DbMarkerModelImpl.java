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

package org.politaktiv.map.infrastructure.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.politaktiv.map.infrastructure.model.DbMarker;
import org.politaktiv.map.infrastructure.model.DbMarkerModel;
import org.politaktiv.map.infrastructure.model.DbMarkerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the DbMarker service. Represents a row in the &quot;politaktivmap_DbMarker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.DbMarkerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DbMarkerImpl}.
 * </p>
 *
 * @author eichi
 * @see DbMarkerImpl
 * @see org.politaktiv.map.infrastructure.model.DbMarker
 * @see org.politaktiv.map.infrastructure.model.DbMarkerModel
 * @generated
 */
@JSON(strict = true)
public class DbMarkerModelImpl extends BaseModelImpl<DbMarker>
	implements DbMarkerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a db marker model instance should use the {@link org.politaktiv.map.infrastructure.model.DbMarker} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_DbMarker";
	public static final Object[][] TABLE_COLUMNS = {
			{ "markerId", Types.BIGINT },
			{ "markerImageName", Types.VARCHAR },
			{ "pointId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_DbMarker (markerId LONG not null primary key,markerImageName VARCHAR(75) null,pointId LONG)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_DbMarker";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.DbMarker"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.DbMarker"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.DbMarker"),
			true);
	public static long MARKERID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DbMarker toModel(DbMarkerSoap soapModel) {
		DbMarker model = new DbMarkerImpl();

		model.setMarkerId(soapModel.getMarkerId());
		model.setMarkerImageName(soapModel.getMarkerImageName());
		model.setPointId(soapModel.getPointId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DbMarker> toModels(DbMarkerSoap[] soapModels) {
		List<DbMarker> models = new ArrayList<DbMarker>(soapModels.length);

		for (DbMarkerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.DbMarker"));

	public DbMarkerModelImpl() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMarkerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_markerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DbMarker.class;
	}

	public String getModelClassName() {
		return DbMarker.class.getName();
	}

	@JSON
	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_columnBitmask |= MARKERID_COLUMN_BITMASK;

		if (!_setOriginalMarkerId) {
			_setOriginalMarkerId = true;

			_originalMarkerId = _markerId;
		}

		_markerId = markerId;
	}

	public long getOriginalMarkerId() {
		return _originalMarkerId;
	}

	@JSON
	public String getMarkerImageName() {
		if (_markerImageName == null) {
			return StringPool.BLANK;
		}
		else {
			return _markerImageName;
		}
	}

	public void setMarkerImageName(String markerImageName) {
		_markerImageName = markerImageName;
	}

	@JSON
	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DbMarker toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DbMarker)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DbMarker.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DbMarkerImpl dbMarkerImpl = new DbMarkerImpl();

		dbMarkerImpl.setMarkerId(getMarkerId());
		dbMarkerImpl.setMarkerImageName(getMarkerImageName());
		dbMarkerImpl.setPointId(getPointId());

		dbMarkerImpl.resetOriginalValues();

		return dbMarkerImpl;
	}

	public int compareTo(DbMarker dbMarker) {
		long primaryKey = dbMarker.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DbMarker dbMarker = null;

		try {
			dbMarker = (DbMarker)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dbMarker.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DbMarkerModelImpl dbMarkerModelImpl = this;

		dbMarkerModelImpl._originalMarkerId = dbMarkerModelImpl._markerId;

		dbMarkerModelImpl._setOriginalMarkerId = false;

		dbMarkerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DbMarker> toCacheModel() {
		DbMarkerCacheModel dbMarkerCacheModel = new DbMarkerCacheModel();

		dbMarkerCacheModel.markerId = getMarkerId();

		dbMarkerCacheModel.markerImageName = getMarkerImageName();

		String markerImageName = dbMarkerCacheModel.markerImageName;

		if ((markerImageName != null) && (markerImageName.length() == 0)) {
			dbMarkerCacheModel.markerImageName = null;
		}

		dbMarkerCacheModel.pointId = getPointId();

		return dbMarkerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{markerId=");
		sb.append(getMarkerId());
		sb.append(", markerImageName=");
		sb.append(getMarkerImageName());
		sb.append(", pointId=");
		sb.append(getPointId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.DbMarker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>markerId</column-name><column-value><![CDATA[");
		sb.append(getMarkerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerImageName</column-name><column-value><![CDATA[");
		sb.append(getMarkerImageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointId</column-name><column-value><![CDATA[");
		sb.append(getPointId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DbMarker.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DbMarker.class
		};
	private long _markerId;
	private long _originalMarkerId;
	private boolean _setOriginalMarkerId;
	private String _markerImageName;
	private long _pointId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DbMarker _escapedModelProxy;
}