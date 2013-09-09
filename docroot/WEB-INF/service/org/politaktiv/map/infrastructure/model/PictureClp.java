/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class PictureClp extends BaseModelImpl<Picture> implements Picture {
	public PictureClp() {
	}

	public Class<?> getModelClass() {
		return Picture.class;
	}

	public String getModelClassName() {
		return Picture.class.getName();
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

	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	public double getWidth() {
		return _width;
	}

	public void setWidth(double width) {
		_width = width;
	}

	public double getHeight() {
		return _height;
	}

	public void setHeight(double height) {
		_height = height;
	}

	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
	}

	public double getOcupacy() {
		return _ocupacy;
	}

	public void setOcupacy(double ocupacy) {
		_ocupacy = ocupacy;
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

	public String getFileEntryUuid() {
		return _fileEntryUuid;
	}

	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;
	}

	public java.lang.String getPictureUrl() {
		throw new UnsupportedOperationException();
	}

	public void validate() {
		throw new UnsupportedOperationException();
	}

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
		return (Picture)Proxy.newProxyInstance(Picture.class.getClassLoader(),
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
		if (obj == null) {
			return false;
		}

		PictureClp picture = null;

		try {
			picture = (PictureClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

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
}