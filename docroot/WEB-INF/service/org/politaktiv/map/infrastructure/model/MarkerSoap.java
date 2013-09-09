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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.MarkerServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.MarkerServiceSoap
 * @generated
 */
public class MarkerSoap implements Serializable {
	public static MarkerSoap toSoapModel(Marker model) {
		MarkerSoap soapModel = new MarkerSoap();

		soapModel.setMarkerId(model.getMarkerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setReferenceUrl(model.getReferenceUrl());
		soapModel.setBackgroundId(model.getBackgroundId());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());

		return soapModel;
	}

	public static MarkerSoap[] toSoapModels(Marker[] models) {
		MarkerSoap[] soapModels = new MarkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarkerSoap[][] toSoapModels(Marker[][] models) {
		MarkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarkerSoap[] toSoapModels(List<Marker> models) {
		List<MarkerSoap> soapModels = new ArrayList<MarkerSoap>(models.size());

		for (Marker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarkerSoap[soapModels.size()]);
	}

	public MarkerSoap() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long pk) {
		setMarkerId(pk);
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

	private long _markerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private double _longitude;
	private double _latitude;
}