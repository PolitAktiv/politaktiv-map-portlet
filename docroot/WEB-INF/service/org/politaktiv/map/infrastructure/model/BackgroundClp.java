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

import org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eichi
 */
public class BackgroundClp extends BaseModelImpl<Background>
	implements Background {
	public BackgroundClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Background.class;
	}

	@Override
	public String getModelClassName() {
		return Background.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _backgroundId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBackgroundId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _backgroundId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("backgroundId", getBackgroundId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("fileEntryUuid", getFileEntryUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long backgroundId = (Long)attributes.get("backgroundId");

		if (backgroundId != null) {
			setBackgroundId(backgroundId);
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

		String fileEntryUuid = (String)attributes.get("fileEntryUuid");

		if (fileEntryUuid != null) {
			setFileEntryUuid(fileEntryUuid);
		}
	}

	@Override
	public long getBackgroundId() {
		return _backgroundId;
	}

	@Override
	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundId", long.class);

				method.invoke(_backgroundRemoteModel, backgroundId);
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

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_backgroundRemoteModel, companyId);
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

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_backgroundRemoteModel, groupId);
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

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_backgroundRemoteModel, userId);
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

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_backgroundRemoteModel, name);
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

		if (_backgroundRemoteModel != null) {
			try {
				Class<?> clazz = _backgroundRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryUuid", String.class);

				method.invoke(_backgroundRemoteModel, fileEntryUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isMap() {
		try {
			String methodName = "isMap";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
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

	public BaseModel<?> getBackgroundRemoteModel() {
		return _backgroundRemoteModel;
	}

	public void setBackgroundRemoteModel(BaseModel<?> backgroundRemoteModel) {
		_backgroundRemoteModel = backgroundRemoteModel;
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

		Class<?> remoteModelClass = _backgroundRemoteModel.getClass();

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

		Object returnValue = method.invoke(_backgroundRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BackgroundLocalServiceUtil.addBackground(this);
		}
		else {
			BackgroundLocalServiceUtil.updateBackground(this);
		}
	}

	@Override
	public Background toEscapedModel() {
		return (Background)ProxyUtil.newProxyInstance(Background.class.getClassLoader(),
			new Class[] { Background.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BackgroundClp clone = new BackgroundClp();

		clone.setBackgroundId(getBackgroundId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setFileEntryUuid(getFileEntryUuid());

		return clone;
	}

	@Override
	public int compareTo(Background background) {
		long primaryKey = background.getPrimaryKey();

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

		if (!(obj instanceof BackgroundClp)) {
			return false;
		}

		BackgroundClp background = (BackgroundClp)obj;

		long primaryKey = background.getPrimaryKey();

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

		sb.append("{backgroundId=");
		sb.append(getBackgroundId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", fileEntryUuid=");
		sb.append(getFileEntryUuid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Background");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>backgroundId</column-name><column-value><![CDATA[");
		sb.append(getBackgroundId());
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
			"<column><column-name>fileEntryUuid</column-name><column-value><![CDATA[");
		sb.append(getFileEntryUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _backgroundId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _fileEntryUuid;
	private BaseModel<?> _backgroundRemoteModel;
}