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
import com.liferay.portal.util.PortalUtil;

import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class MarkerClp extends BaseModelImpl<Marker> implements Marker {
	public MarkerClp() {
	}

	public Class<?> getModelClass() {
		return Marker.class;
	}

	public String getModelClassName() {
		return Marker.class.getName();
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getReferenceUrl() {
		return _referenceUrl;
	}

	public void setReferenceUrl(String referenceUrl) {
		_referenceUrl = referenceUrl;
	}

	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;
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

	public void validate() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String toHTMLFormatedString() {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MarkerLocalServiceUtil.addMarker(this);
		}
		else {
			MarkerLocalServiceUtil.updateMarker(this);
		}
	}

	@Override
	public Marker toEscapedModel() {
		return (Marker)Proxy.newProxyInstance(Marker.class.getClassLoader(),
			new Class[] { Marker.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarkerClp clone = new MarkerClp();

		clone.setMarkerId(getMarkerId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setReferenceUrl(getReferenceUrl());
		clone.setBackgroundId(getBackgroundId());
		clone.setLongitude(getLongitude());
		clone.setLatitude(getLatitude());

		return clone;
	}

	public int compareTo(Marker marker) {
		long primaryKey = marker.getPrimaryKey();

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

		MarkerClp marker = null;

		try {
			marker = (MarkerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = marker.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{markerId=");
		sb.append(getMarkerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", referenceUrl=");
		sb.append(getReferenceUrl());
		sb.append(", backgroundId=");
		sb.append(getBackgroundId());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Marker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>markerId</column-name><column-value><![CDATA[");
		sb.append(getMarkerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceUrl</column-name><column-value><![CDATA[");
		sb.append(getReferenceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundId</column-name><column-value><![CDATA[");
		sb.append(getBackgroundId());
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

	private long _markerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private double _longitude;
	private double _latitude;
}