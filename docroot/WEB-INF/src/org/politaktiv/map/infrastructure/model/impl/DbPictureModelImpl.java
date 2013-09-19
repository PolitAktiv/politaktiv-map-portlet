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

import org.politaktiv.map.infrastructure.model.DbPicture;
import org.politaktiv.map.infrastructure.model.DbPictureModel;
import org.politaktiv.map.infrastructure.model.DbPictureSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the DbPicture service. Represents a row in the &quot;politaktivmap_DbPicture&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.DbPictureModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DbPictureImpl}.
 * </p>
 *
 * @author eichi
 * @see DbPictureImpl
 * @see org.politaktiv.map.infrastructure.model.DbPicture
 * @see org.politaktiv.map.infrastructure.model.DbPictureModel
 * @generated
 */
@JSON(strict = true)
public class DbPictureModelImpl extends BaseModelImpl<DbPicture>
	implements DbPictureModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a db picture model instance should use the {@link org.politaktiv.map.infrastructure.model.DbPicture} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_DbPicture";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pictureId", Types.BIGINT },
			{ "rotation", Types.BIGINT },
			{ "width", Types.BIGINT },
			{ "height", Types.BIGINT },
			{ "resolution", Types.DOUBLE },
			{ "pointId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_DbPicture (pictureId LONG not null primary key,rotation LONG,width LONG,height LONG,resolution DOUBLE,pointId LONG)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_DbPicture";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.DbPicture"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.DbPicture"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.DbPicture"),
			true);
	public static long PICTUREID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DbPicture toModel(DbPictureSoap soapModel) {
		DbPicture model = new DbPictureImpl();

		model.setPictureId(soapModel.getPictureId());
		model.setRotation(soapModel.getRotation());
		model.setWidth(soapModel.getWidth());
		model.setHeight(soapModel.getHeight());
		model.setResolution(soapModel.getResolution());
		model.setPointId(soapModel.getPointId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DbPicture> toModels(DbPictureSoap[] soapModels) {
		List<DbPicture> models = new ArrayList<DbPicture>(soapModels.length);

		for (DbPictureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.DbPicture"));

	public DbPictureModelImpl() {
	}

	public long getPrimaryKey() {
		return _pictureId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPictureId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pictureId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DbPicture.class;
	}

	public String getModelClassName() {
		return DbPicture.class.getName();
	}

	@JSON
	public long getPictureId() {
		return _pictureId;
	}

	public void setPictureId(long pictureId) {
		_columnBitmask |= PICTUREID_COLUMN_BITMASK;

		if (!_setOriginalPictureId) {
			_setOriginalPictureId = true;

			_originalPictureId = _pictureId;
		}

		_pictureId = pictureId;
	}

	public long getOriginalPictureId() {
		return _originalPictureId;
	}

	@JSON
	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	@JSON
	public long getWidth() {
		return _width;
	}

	public void setWidth(long width) {
		_width = width;
	}

	@JSON
	public long getHeight() {
		return _height;
	}

	public void setHeight(long height) {
		_height = height;
	}

	@JSON
	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
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
	public DbPicture toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DbPicture)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DbPicture.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DbPictureImpl dbPictureImpl = new DbPictureImpl();

		dbPictureImpl.setPictureId(getPictureId());
		dbPictureImpl.setRotation(getRotation());
		dbPictureImpl.setWidth(getWidth());
		dbPictureImpl.setHeight(getHeight());
		dbPictureImpl.setResolution(getResolution());
		dbPictureImpl.setPointId(getPointId());

		dbPictureImpl.resetOriginalValues();

		return dbPictureImpl;
	}

	public int compareTo(DbPicture dbPicture) {
		long primaryKey = dbPicture.getPrimaryKey();

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

		DbPicture dbPicture = null;

		try {
			dbPicture = (DbPicture)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dbPicture.getPrimaryKey();

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
		DbPictureModelImpl dbPictureModelImpl = this;

		dbPictureModelImpl._originalPictureId = dbPictureModelImpl._pictureId;

		dbPictureModelImpl._setOriginalPictureId = false;

		dbPictureModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DbPicture> toCacheModel() {
		DbPictureCacheModel dbPictureCacheModel = new DbPictureCacheModel();

		dbPictureCacheModel.pictureId = getPictureId();

		dbPictureCacheModel.rotation = getRotation();

		dbPictureCacheModel.width = getWidth();

		dbPictureCacheModel.height = getHeight();

		dbPictureCacheModel.resolution = getResolution();

		dbPictureCacheModel.pointId = getPointId();

		return dbPictureCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{pictureId=");
		sb.append(getPictureId());
		sb.append(", rotation=");
		sb.append(getRotation());
		sb.append(", width=");
		sb.append(getWidth());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", pointId=");
		sb.append(getPointId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.DbPicture");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pictureId</column-name><column-value><![CDATA[");
		sb.append(getPictureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rotation</column-name><column-value><![CDATA[");
		sb.append(getRotation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>width</column-name><column-value><![CDATA[");
		sb.append(getWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>height</column-name><column-value><![CDATA[");
		sb.append(getHeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolution</column-name><column-value><![CDATA[");
		sb.append(getResolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointId</column-name><column-value><![CDATA[");
		sb.append(getPointId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DbPicture.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DbPicture.class
		};
	private long _pictureId;
	private long _originalPictureId;
	private boolean _setOriginalPictureId;
	private long _rotation;
	private long _width;
	private long _height;
	private double _resolution;
	private long _pointId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DbPicture _escapedModelProxy;
}