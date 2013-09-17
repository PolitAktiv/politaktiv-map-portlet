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

import org.politaktiv.map.infrastructure.service.DbMarkerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class DbMarkerClp extends BaseModelImpl<DbMarker> implements DbMarker {
	public DbMarkerClp() {
	}

	public Class<?> getModelClass() {
		return DbMarker.class;
	}

	public String getModelClassName() {
		return DbMarker.class.getName();
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

	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
	}

	public String getMarkerImageName() {
		return _markerImageName;
	}

	public void setMarkerImageName(String markerImageName) {
		_markerImageName = markerImageName;
	}

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DbMarkerLocalServiceUtil.addDbMarker(this);
		}
		else {
			DbMarkerLocalServiceUtil.updateDbMarker(this);
		}
	}

	@Override
	public DbMarker toEscapedModel() {
		return (DbMarker)Proxy.newProxyInstance(DbMarker.class.getClassLoader(),
			new Class[] { DbMarker.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DbMarkerClp clone = new DbMarkerClp();

		clone.setMarkerId(getMarkerId());
		clone.setMarkerImageName(getMarkerImageName());
		clone.setPointId(getPointId());

		return clone;
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

		DbMarkerClp dbMarker = null;

		try {
			dbMarker = (DbMarkerClp)obj;
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

	private long _markerId;
	private String _markerImageName;
	private long _pointId;
}