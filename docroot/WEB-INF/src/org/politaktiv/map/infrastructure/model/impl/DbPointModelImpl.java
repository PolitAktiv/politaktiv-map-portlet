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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.politaktiv.map.infrastructure.model.DbPoint;
import org.politaktiv.map.infrastructure.model.DbPointModel;
import org.politaktiv.map.infrastructure.model.DbPointSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the DbPoint service. Represents a row in the &quot;politaktivmap_DbPoint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.DbPointModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DbPointImpl}.
 * </p>
 *
 * @author eichi
 * @see DbPointImpl
 * @see org.politaktiv.map.infrastructure.model.DbPoint
 * @see org.politaktiv.map.infrastructure.model.DbPointModel
 * @generated
 */
@JSON(strict = true)
public class DbPointModelImpl extends BaseModelImpl<DbPoint>
	implements DbPointModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a db point model instance should use the {@link org.politaktiv.map.infrastructure.model.DbPoint} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_DbPoint";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pointId", Types.BIGINT },
			{ "longitude", Types.DOUBLE },
			{ "latitude", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_DbPoint (pointId LONG not null primary key,longitude DOUBLE,latitude DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_DbPoint";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.DbPoint"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.DbPoint"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.DbPoint"),
			true);
	public static long POINTID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DbPoint toModel(DbPointSoap soapModel) {
		DbPoint model = new DbPointImpl();

		model.setPointId(soapModel.getPointId());
		model.setLongitude(soapModel.getLongitude());
		model.setLatitude(soapModel.getLatitude());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DbPoint> toModels(DbPointSoap[] soapModels) {
		List<DbPoint> models = new ArrayList<DbPoint>(soapModels.length);

		for (DbPointSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.DbPoint"));

	public DbPointModelImpl() {
	}

	public long getPrimaryKey() {
		return _pointId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPointId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pointId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DbPoint.class;
	}

	public String getModelClassName() {
		return DbPoint.class.getName();
	}

	@JSON
	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_columnBitmask |= POINTID_COLUMN_BITMASK;

		if (!_setOriginalPointId) {
			_setOriginalPointId = true;

			_originalPointId = _pointId;
		}

		_pointId = pointId;
	}

	public long getOriginalPointId() {
		return _originalPointId;
	}

	@JSON
	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	@JSON
	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DbPoint toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DbPoint)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DbPoint.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DbPointImpl dbPointImpl = new DbPointImpl();

		dbPointImpl.setPointId(getPointId());
		dbPointImpl.setLongitude(getLongitude());
		dbPointImpl.setLatitude(getLatitude());

		dbPointImpl.resetOriginalValues();

		return dbPointImpl;
	}

	public int compareTo(DbPoint dbPoint) {
		long primaryKey = dbPoint.getPrimaryKey();

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

		DbPoint dbPoint = null;

		try {
			dbPoint = (DbPoint)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dbPoint.getPrimaryKey();

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
		DbPointModelImpl dbPointModelImpl = this;

		dbPointModelImpl._originalPointId = dbPointModelImpl._pointId;

		dbPointModelImpl._setOriginalPointId = false;

		dbPointModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DbPoint> toCacheModel() {
		DbPointCacheModel dbPointCacheModel = new DbPointCacheModel();

		dbPointCacheModel.pointId = getPointId();

		dbPointCacheModel.longitude = getLongitude();

		dbPointCacheModel.latitude = getLatitude();

		return dbPointCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{pointId=");
		sb.append(getPointId());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.DbPoint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pointId</column-name><column-value><![CDATA[");
		sb.append(getPointId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DbPoint.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DbPoint.class
		};
	private long _pointId;
	private long _originalPointId;
	private boolean _setOriginalPointId;
	private double _longitude;
	private double _latitude;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DbPoint _escapedModelProxy;
}