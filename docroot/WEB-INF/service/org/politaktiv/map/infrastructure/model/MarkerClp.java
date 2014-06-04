/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.politaktiv.map.infrastructure.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.politaktiv.map.infrastructure.service.ClpSerializer;
import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eichi
 */
public class MarkerClp extends BaseModelImpl<Marker> implements Marker {
	public MarkerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Marker.class;
	}

	@Override
	public String getModelClassName() {
		return Marker.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _markerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarkerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _markerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("markerId", getMarkerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("referenceUrl", getReferenceUrl());
		attributes.put("backgroundId", getBackgroundId());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long markerId = (Long)attributes.get("markerId");

		if (markerId != null) {
			setMarkerId(markerId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String referenceUrl = (String)attributes.get("referenceUrl");

		if (referenceUrl != null) {
			setReferenceUrl(referenceUrl);
		}

		Long backgroundId = (Long)attributes.get("backgroundId");

		if (backgroundId != null) {
			setBackgroundId(backgroundId);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}
	}

	@Override
	public long getMarkerId() {
		return _markerId;
	}

	@Override
	public void setMarkerId(long markerId) {
		_markerId = markerId;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setMarkerId", long.class);

				method.invoke(_markerRemoteModel, markerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_markerRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_markerRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_markerRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_markerRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_markerRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReferenceUrl() {
		return _referenceUrl;
	}

	@Override
	public void setReferenceUrl(String referenceUrl) {
		_referenceUrl = referenceUrl;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setReferenceUrl", String.class);

				method.invoke(_markerRemoteModel, referenceUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBackgroundId() {
		return _backgroundId;
	}

	@Override
	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundId", long.class);

				method.invoke(_markerRemoteModel, backgroundId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_longitude = longitude;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_markerRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_latitude = latitude;

		if (_markerRemoteModel != null) {
			try {
				Class<?> clazz = _markerRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_markerRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String toHTMLFormatedString() {
		try {
			String methodName = "toHTMLFormatedString";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void validate() {
		try {
			String methodName = "validate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getMarkerRemoteModel() {
		return _markerRemoteModel;
	}

	public void setMarkerRemoteModel(BaseModel<?> markerRemoteModel) {
		_markerRemoteModel = markerRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _markerRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_markerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
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
		return (Marker)ProxyUtil.newProxyInstance(Marker.class.getClassLoader(),
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

	@Override
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
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarkerClp)) {
			return false;
		}

		MarkerClp marker = (MarkerClp)obj;

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

	@Override
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
	private BaseModel<?> _markerRemoteModel;
}