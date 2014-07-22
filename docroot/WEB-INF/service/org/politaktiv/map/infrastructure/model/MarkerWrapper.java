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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Marker}.
 * </p>
 *
 * @author eichi
 * @see Marker
 * @generated
 */
public class MarkerWrapper implements Marker, ModelWrapper<Marker> {
	public MarkerWrapper(Marker marker) {
		_marker = marker;
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

	/**
	* Returns the primary key of this marker.
	*
	* @return the primary key of this marker
	*/
	@Override
	public long getPrimaryKey() {
		return _marker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marker.
	*
	* @param primaryKey the primary key of this marker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker ID of this marker.
	*
	* @return the marker ID of this marker
	*/
	@Override
	public long getMarkerId() {
		return _marker.getMarkerId();
	}

	/**
	* Sets the marker ID of this marker.
	*
	* @param markerId the marker ID of this marker
	*/
	@Override
	public void setMarkerId(long markerId) {
		_marker.setMarkerId(markerId);
	}

	/**
	* Returns the company ID of this marker.
	*
	* @return the company ID of this marker
	*/
	@Override
	public long getCompanyId() {
		return _marker.getCompanyId();
	}

	/**
	* Sets the company ID of this marker.
	*
	* @param companyId the company ID of this marker
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marker.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this marker.
	*
	* @return the group ID of this marker
	*/
	@Override
	public long getGroupId() {
		return _marker.getGroupId();
	}

	/**
	* Sets the group ID of this marker.
	*
	* @param groupId the group ID of this marker
	*/
	@Override
	public void setGroupId(long groupId) {
		_marker.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this marker.
	*
	* @return the user ID of this marker
	*/
	@Override
	public long getUserId() {
		return _marker.getUserId();
	}

	/**
	* Sets the user ID of this marker.
	*
	* @param userId the user ID of this marker
	*/
	@Override
	public void setUserId(long userId) {
		_marker.setUserId(userId);
	}

	/**
	* Returns the user uuid of this marker.
	*
	* @return the user uuid of this marker
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marker.getUserUuid();
	}

	/**
	* Sets the user uuid of this marker.
	*
	* @param userUuid the user uuid of this marker
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marker.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this marker.
	*
	* @return the name of this marker
	*/
	@Override
	public java.lang.String getName() {
		return _marker.getName();
	}

	/**
	* Sets the name of this marker.
	*
	* @param name the name of this marker
	*/
	@Override
	public void setName(java.lang.String name) {
		_marker.setName(name);
	}

	/**
	* Returns the description of this marker.
	*
	* @return the description of this marker
	*/
	@Override
	public java.lang.String getDescription() {
		return _marker.getDescription();
	}

	/**
	* Sets the description of this marker.
	*
	* @param description the description of this marker
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marker.setDescription(description);
	}

	/**
	* Returns the reference url of this marker.
	*
	* @return the reference url of this marker
	*/
	@Override
	public java.lang.String getReferenceUrl() {
		return _marker.getReferenceUrl();
	}

	/**
	* Sets the reference url of this marker.
	*
	* @param referenceUrl the reference url of this marker
	*/
	@Override
	public void setReferenceUrl(java.lang.String referenceUrl) {
		_marker.setReferenceUrl(referenceUrl);
	}

	/**
	* Returns the background ID of this marker.
	*
	* @return the background ID of this marker
	*/
	@Override
	public long getBackgroundId() {
		return _marker.getBackgroundId();
	}

	/**
	* Sets the background ID of this marker.
	*
	* @param backgroundId the background ID of this marker
	*/
	@Override
	public void setBackgroundId(long backgroundId) {
		_marker.setBackgroundId(backgroundId);
	}

	/**
	* Returns the longitude of this marker.
	*
	* @return the longitude of this marker
	*/
	@Override
	public double getLongitude() {
		return _marker.getLongitude();
	}

	/**
	* Sets the longitude of this marker.
	*
	* @param longitude the longitude of this marker
	*/
	@Override
	public void setLongitude(double longitude) {
		_marker.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this marker.
	*
	* @return the latitude of this marker
	*/
	@Override
	public double getLatitude() {
		return _marker.getLatitude();
	}

	/**
	* Sets the latitude of this marker.
	*
	* @param latitude the latitude of this marker
	*/
	@Override
	public void setLatitude(double latitude) {
		_marker.setLatitude(latitude);
	}

	@Override
	public boolean isNew() {
		return _marker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarkerWrapper((Marker)_marker.clone());
	}

	@Override
	public int compareTo(org.politaktiv.map.infrastructure.model.Marker marker) {
		return _marker.compareTo(marker);
	}

	@Override
	public int hashCode() {
		return _marker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.infrastructure.model.Marker> toCacheModel() {
		return _marker.toCacheModel();
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Marker toEscapedModel() {
		return new MarkerWrapper(_marker.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Marker toUnescapedModel() {
		return new MarkerWrapper(_marker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marker.persist();
	}

	@Override
	public void validate() throws javax.portlet.ValidatorException {
		_marker.validate();
	}

	@Override
	public java.lang.String toHTMLFormatedString()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marker.toHTMLFormatedString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarkerWrapper)) {
			return false;
		}

		MarkerWrapper markerWrapper = (MarkerWrapper)obj;

		if (Validator.equals(_marker, markerWrapper._marker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Marker getWrappedMarker() {
		return _marker;
	}

	@Override
	public Marker getWrappedModel() {
		return _marker;
	}

	@Override
	public void resetOriginalValues() {
		_marker.resetOriginalValues();
	}

	private Marker _marker;
}