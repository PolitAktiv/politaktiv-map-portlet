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

import org.politaktiv.map.infrastructure.model.Marker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Marker in entity cache.
 *
 * @author eichi
 * @see Marker
 * @generated
 */
public class MarkerCacheModel implements CacheModel<Marker>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{markerId=");
		sb.append(markerId);
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
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Marker toEntityModel() {
		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setMarkerId(markerId);
		markerImpl.setCompanyId(companyId);
		markerImpl.setGroupId(groupId);
		markerImpl.setUserId(userId);

		if (name == null) {
			markerImpl.setName(StringPool.BLANK);
		}
		else {
			markerImpl.setName(name);
		}

		if (description == null) {
			markerImpl.setDescription(StringPool.BLANK);
		}
		else {
			markerImpl.setDescription(description);
		}

		if (referenceUrl == null) {
			markerImpl.setReferenceUrl(StringPool.BLANK);
		}
		else {
			markerImpl.setReferenceUrl(referenceUrl);
		}

		markerImpl.setBackgroundId(backgroundId);
		markerImpl.setLongitude(longitude);
		markerImpl.setLatitude(latitude);

		markerImpl.resetOriginalValues();

		return markerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		markerId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		referenceUrl = objectInput.readUTF();
		backgroundId = objectInput.readLong();
		longitude = objectInput.readDouble();
		latitude = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(markerId);
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
		objectOutput.writeDouble(longitude);
		objectOutput.writeDouble(latitude);
	}

	public long markerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String description;
	public String referenceUrl;
	public long backgroundId;
	public double longitude;
	public double latitude;
}