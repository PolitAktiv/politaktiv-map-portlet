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
/**
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.politaktiv.map.infrastructure.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.politaktiv.map.infrastructure.model.Background;

import java.io.Serializable;


/**
 * The cache model class for representing Background in entity cache.
 *
 * @author eichi
 * @see Background
 * @generated
 */
public class BackgroundCacheModel implements CacheModel<Background>,
	Serializable {
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

	public long backgroundId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String fileEntryUuid;
}