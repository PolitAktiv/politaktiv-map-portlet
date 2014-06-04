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
import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eichi
 */
public class PictureClp extends BaseModelImpl<Picture> implements Picture {
	public PictureClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Picture.class;
	}

	@Override
	public String getModelClassName() {
		return Picture.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _pictureId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPictureId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pictureId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pictureId", getPictureId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("referenceUrl", getReferenceUrl());
		attributes.put("backgroundId", getBackgroundId());
		attributes.put("rotation", getRotation());
		attributes.put("width", getWidth());
		attributes.put("height", getHeight());
		attributes.put("resolution", getResolution());
		attributes.put("ocupacy", getOcupacy());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());
		attributes.put("fileEntryUuid", getFileEntryUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pictureId = (Long)attributes.get("pictureId");

		if (pictureId != null) {
			setPictureId(pictureId);
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

		Long rotation = (Long)attributes.get("rotation");

		if (rotation != null) {
			setRotation(rotation);
		}

		Double width = (Double)attributes.get("width");

		if (width != null) {
			setWidth(width);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double resolution = (Double)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		Double ocupacy = (Double)attributes.get("ocupacy");

		if (ocupacy != null) {
			setOcupacy(ocupacy);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String fileEntryUuid = (String)attributes.get("fileEntryUuid");

		if (fileEntryUuid != null) {
			setFileEntryUuid(fileEntryUuid);
		}
	}

	@Override
	public long getPictureId() {
		return _pictureId;
	}

	@Override
	public void setPictureId(long pictureId) {
		_pictureId = pictureId;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setPictureId", long.class);

				method.invoke(_pictureRemoteModel, pictureId);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_pictureRemoteModel, companyId);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_pictureRemoteModel, groupId);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_pictureRemoteModel, userId);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_pictureRemoteModel, name);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_pictureRemoteModel, description);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setReferenceUrl", String.class);

				method.invoke(_pictureRemoteModel, referenceUrl);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundId", long.class);

				method.invoke(_pictureRemoteModel, backgroundId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRotation() {
		return _rotation;
	}

	@Override
	public void setRotation(long rotation) {
		_rotation = rotation;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setRotation", long.class);

				method.invoke(_pictureRemoteModel, rotation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getWidth() {
		return _width;
	}

	@Override
	public void setWidth(double width) {
		_width = width;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setWidth", double.class);

				method.invoke(_pictureRemoteModel, width);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getHeight() {
		return _height;
	}

	@Override
	public void setHeight(double height) {
		_height = height;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setHeight", double.class);

				method.invoke(_pictureRemoteModel, height);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getResolution() {
		return _resolution;
	}

	@Override
	public void setResolution(double resolution) {
		_resolution = resolution;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setResolution", double.class);

				method.invoke(_pictureRemoteModel, resolution);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getOcupacy() {
		return _ocupacy;
	}

	@Override
	public void setOcupacy(double ocupacy) {
		_ocupacy = ocupacy;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setOcupacy", double.class);

				method.invoke(_pictureRemoteModel, ocupacy);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_pictureRemoteModel, longitude);
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

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_pictureRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileEntryUuid() {
		return _fileEntryUuid;
	}

	@Override
	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;

		if (_pictureRemoteModel != null) {
			try {
				Class<?> clazz = _pictureRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryUuid", String.class);

				method.invoke(_pictureRemoteModel, fileEntryUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getPictureUrl() {
		try {
			String methodName = "getPictureUrl";

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

	public BaseModel<?> getPictureRemoteModel() {
		return _pictureRemoteModel;
	}

	public void setPictureRemoteModel(BaseModel<?> pictureRemoteModel) {
		_pictureRemoteModel = pictureRemoteModel;
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

		Class<?> remoteModelClass = _pictureRemoteModel.getClass();

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

		Object returnValue = method.invoke(_pictureRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PictureLocalServiceUtil.addPicture(this);
		}
		else {
			PictureLocalServiceUtil.updatePicture(this);
		}
	}

	@Override
	public Picture toEscapedModel() {
		return (Picture)ProxyUtil.newProxyInstance(Picture.class.getClassLoader(),
			new Class[] { Picture.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PictureClp clone = new PictureClp();

		clone.setPictureId(getPictureId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setReferenceUrl(getReferenceUrl());
		clone.setBackgroundId(getBackgroundId());
		clone.setRotation(getRotation());
		clone.setWidth(getWidth());
		clone.setHeight(getHeight());
		clone.setResolution(getResolution());
		clone.setOcupacy(getOcupacy());
		clone.setLongitude(getLongitude());
		clone.setLatitude(getLatitude());
		clone.setFileEntryUuid(getFileEntryUuid());

		return clone;
	}

	@Override
	public int compareTo(Picture picture) {
		long primaryKey = picture.getPrimaryKey();

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

		if (!(obj instanceof PictureClp)) {
			return false;
		}

		PictureClp picture = (PictureClp)obj;

		long primaryKey = picture.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{pictureId=");
		sb.append(getPictureId());
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
		sb.append(", rotation=");
		sb.append(getRotation());
		sb.append(", width=");
		sb.append(getWidth());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", ocupacy=");
		sb.append(getOcupacy());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", fileEntryUuid=");
		sb.append(getFileEntryUuid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Picture");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pictureId</column-name><column-value><![CDATA[");
		sb.append(getPictureId());
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
			"<column><column-name>ocupacy</column-name><column-value><![CDATA[");
		sb.append(getOcupacy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryUuid</column-name><column-value><![CDATA[");
		sb.append(getFileEntryUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pictureId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private long _rotation;
	private double _width;
	private double _height;
	private double _resolution;
	private double _ocupacy;
	private double _longitude;
	private double _latitude;
	private String _fileEntryUuid;
	private BaseModel<?> _pictureRemoteModel;
}