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

import org.politaktiv.map.infrastructure.model.Background;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Background in entity cache.
 *
 * @author eichi
 * @see Background
 * @generated
 */
public class BackgroundCacheModel implements CacheModel<Background>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{backgroundId=");
		sb.append(backgroundId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", fileEntryUuid=");
		sb.append(fileEntryUuid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Background toEntityModel() {
		BackgroundImpl backgroundImpl = new BackgroundImpl();

		backgroundImpl.setBackgroundId(backgroundId);
		backgroundImpl.setCompanyId(companyId);
		backgroundImpl.setGroupId(groupId);
		backgroundImpl.setUserId(userId);

		if (name == null) {
			backgroundImpl.setName(StringPool.BLANK);
		}
		else {
			backgroundImpl.setName(name);
		}

		if (fileEntryUuid == null) {
			backgroundImpl.setFileEntryUuid(StringPool.BLANK);
		}
		else {
			backgroundImpl.setFileEntryUuid(fileEntryUuid);
		}

		backgroundImpl.resetOriginalValues();

		return backgroundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		backgroundId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		fileEntryUuid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(backgroundId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (fileEntryUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryUuid);
		}
	}

	public long backgroundId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String fileEntryUuid;
}