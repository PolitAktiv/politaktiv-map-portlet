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

package org.politaktiv.map.infrastructure.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.politaktiv.map.infrastructure.service.DbPictureLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class DbPictureClp extends BaseModelImpl<DbPicture> implements DbPicture {
	public DbPictureClp() {
	}

	public Class<?> getModelClass() {
		return DbPicture.class;
	}

	public String getModelClassName() {
		return DbPicture.class.getName();
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

	public long getPictureId() {
		return _pictureId;
	}

	public void setPictureId(long pictureId) {
		_pictureId = pictureId;
	}

	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	public long getWidth() {
		return _width;
	}

	public void setWidth(long width) {
		_width = width;
	}

	public long getHeight() {
		return _height;
	}

	public void setHeight(long height) {
		_height = height;
	}

	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
	}

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DbPictureLocalServiceUtil.addDbPicture(this);
		}
		else {
			DbPictureLocalServiceUtil.updateDbPicture(this);
		}
	}

	@Override
	public DbPicture toEscapedModel() {
		return (DbPicture)Proxy.newProxyInstance(DbPicture.class.getClassLoader(),
			new Class[] { DbPicture.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DbPictureClp clone = new DbPictureClp();

		clone.setPictureId(getPictureId());
		clone.setRotation(getRotation());
		clone.setWidth(getWidth());
		clone.setHeight(getHeight());
		clone.setResolution(getResolution());
		clone.setPointId(getPointId());

		return clone;
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

		DbPictureClp dbPicture = null;

		try {
			dbPicture = (DbPictureClp)obj;
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

	private long _pictureId;
	private long _rotation;
	private long _width;
	private long _height;
	private double _resolution;
	private long _pointId;
}