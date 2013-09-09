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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.BackgroundServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.BackgroundServiceSoap
 * @generated
 */
public class BackgroundSoap implements Serializable {
	public static BackgroundSoap toSoapModel(Background model) {
		BackgroundSoap soapModel = new BackgroundSoap();

		soapModel.setBackgroundId(model.getBackgroundId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setFileEntryUuid(model.getFileEntryUuid());

		return soapModel;
	}

	public static BackgroundSoap[] toSoapModels(Background[] models) {
		BackgroundSoap[] soapModels = new BackgroundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BackgroundSoap[][] toSoapModels(Background[][] models) {
		BackgroundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BackgroundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BackgroundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BackgroundSoap[] toSoapModels(List<Background> models) {
		List<BackgroundSoap> soapModels = new ArrayList<BackgroundSoap>(models.size());

		for (Background model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BackgroundSoap[soapModels.size()]);
	}

	public BackgroundSoap() {
	}

	public long getPrimaryKey() {
		return _backgroundId;
	}

	public void setPrimaryKey(long pk) {
		setBackgroundId(pk);
	}

	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getFileEntryUuid() {
		return _fileEntryUuid;
	}

	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;
	}

	private long _backgroundId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _fileEntryUuid;
}