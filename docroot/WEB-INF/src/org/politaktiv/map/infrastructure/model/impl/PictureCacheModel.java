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

package org.politaktiv.map.infrastructure.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.politaktiv.map.infrastructure.model.Picture;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Picture in entity cache.
 *
 * @author eichi
 * @see Picture
 * @generated
 */
public class PictureCacheModel implements CacheModel<Picture>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{pictureId=");
		sb.append(pictureId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", referenceUrl=");
		sb.append(referenceUrl);
		sb.append(", backgroundId=");
		sb.append(backgroundId);
		sb.append(", rotation=");
		sb.append(rotation);
		sb.append(", width=");
		sb.append(width);
		sb.append(", height=");
		sb.append(height);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", ocupacy=");
		sb.append(ocupacy);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", fileEntryUuid=");
		sb.append(fileEntryUuid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Picture toEntityModel() {
		PictureImpl pictureImpl = new PictureImpl();

		pictureImpl.setPictureId(pictureId);
		pictureImpl.setCompanyId(companyId);
		pictureImpl.setGroupId(groupId);
		pictureImpl.setUserId(userId);

		if (name == null) {
			pictureImpl.setName(StringPool.BLANK);
		}
		else {
			pictureImpl.setName(name);
		}

		if (description == null) {
			pictureImpl.setDescription(StringPool.BLANK);
		}
		else {
			pictureImpl.setDescription(description);
		}

		if (referenceUrl == null) {
			pictureImpl.setReferenceUrl(StringPool.BLANK);
		}
		else {
			pictureImpl.setReferenceUrl(referenceUrl);
		}

		pictureImpl.setBackgroundId(backgroundId);
		pictureImpl.setRotation(rotation);
		pictureImpl.setWidth(width);
		pictureImpl.setHeight(height);
		pictureImpl.setResolution(resolution);
		pictureImpl.setOcupacy(ocupacy);
		pictureImpl.setLongitude(longitude);
		pictureImpl.setLatitude(latitude);

		if (fileEntryUuid == null) {
			pictureImpl.setFileEntryUuid(StringPool.BLANK);
		}
		else {
			pictureImpl.setFileEntryUuid(fileEntryUuid);
		}

		pictureImpl.resetOriginalValues();

		return pictureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pictureId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		referenceUrl = objectInput.readUTF();
		backgroundId = objectInput.readLong();
		rotation = objectInput.readLong();
		width = objectInput.readDouble();
		height = objectInput.readDouble();
		resolution = objectInput.readDouble();
		ocupacy = objectInput.readDouble();
		longitude = objectInput.readDouble();
		latitude = objectInput.readDouble();
		fileEntryUuid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(pictureId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (referenceUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(referenceUrl);
		}

		objectOutput.writeLong(backgroundId);
		objectOutput.writeLong(rotation);
		objectOutput.writeDouble(width);
		objectOutput.writeDouble(height);
		objectOutput.writeDouble(resolution);
		objectOutput.writeDouble(ocupacy);
		objectOutput.writeDouble(longitude);
		objectOutput.writeDouble(latitude);

		if (fileEntryUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryUuid);
		}
	}

	public long pictureId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String description;
	public String referenceUrl;
	public long backgroundId;
	public long rotation;
	public double width;
	public double height;
	public double resolution;
	public double ocupacy;
	public double longitude;
	public double latitude;
	public String fileEntryUuid;
}