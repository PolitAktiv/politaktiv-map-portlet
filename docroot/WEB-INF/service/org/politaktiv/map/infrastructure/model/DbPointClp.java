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

import org.politaktiv.map.infrastructure.service.DbPointLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class DbPointClp extends BaseModelImpl<DbPoint> implements DbPoint {
	public DbPointClp() {
	}

	public Class<?> getModelClass() {
		return DbPoint.class;
	}

	public String getModelClassName() {
		return DbPoint.class.getName();
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

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DbPointLocalServiceUtil.addDbPoint(this);
		}
		else {
			DbPointLocalServiceUtil.updateDbPoint(this);
		}
	}

	@Override
	public DbPoint toEscapedModel() {
		return (DbPoint)Proxy.newProxyInstance(DbPoint.class.getClassLoader(),
			new Class[] { DbPoint.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DbPointClp clone = new DbPointClp();

		clone.setPointId(getPointId());
		clone.setLongitude(getLongitude());
		clone.setLatitude(getLatitude());

		return clone;
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

		DbPointClp dbPoint = null;

		try {
			dbPoint = (DbPointClp)obj;
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

	private long _pointId;
	private double _longitude;
	private double _latitude;
}