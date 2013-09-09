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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Marker}.
 * </p>
 *
 * @author    eichi
 * @see       Marker
 * @generated
 */
public class MarkerWrapper implements Marker, ModelWrapper<Marker> {
	public MarkerWrapper(Marker marker) {
		_marker = marker;
	}

	public Class<?> getModelClass() {
		return Marker.class;
	}

	public String getModelClassName() {
		return Marker.class.getName();
	}

	/**
	* Returns the primary key of this marker.
	*
	* @return the primary key of this marker
	*/
	public long getPrimaryKey() {
		return _marker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marker.
	*
	* @param primaryKey the primary key of this marker
	*/
	public void setPrimaryKey(long primaryKey) {
		_marker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker ID of this marker.
	*
	* @return the marker ID of this marker
	*/
	public long getMarkerId() {
		return _marker.getMarkerId();
	}

	/**
	* Sets the marker ID of this marker.
	*
	* @param markerId the marker ID of this marker
	*/
	public void setMarkerId(long markerId) {
		_marker.setMarkerId(markerId);
	}

	/**
	* Returns the company ID of this marker.
	*
	* @return the company ID of this marker
	*/
	public long getCompanyId() {
		return _marker.getCompanyId();
	}

	/**
	* Sets the company ID of this marker.
	*
	* @param companyId the company ID of this marker
	*/
	public void setCompanyId(long companyId) {
		_marker.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this marker.
	*
	* @return the group ID of this marker
	*/
	public long getGroupId() {
		return _marker.getGroupId();
	}

	/**
	* Sets the group ID of this marker.
	*
	* @param groupId the group ID of this marker
	*/
	public void setGroupId(long groupId) {
		_marker.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this marker.
	*
	* @return the user ID of this marker
	*/
	public long getUserId() {
		return _marker.getUserId();
	}

	/**
	* Sets the user ID of this marker.
	*
	* @param userId the user ID of this marker
	*/
	public void setUserId(long userId) {
		_marker.setUserId(userId);
	}

	/**
	* Returns the user uuid of this marker.
	*
	* @return the user uuid of this marker
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marker.getUserUuid();
	}

	/**
	* Sets the user uuid of this marker.
	*
	* @param userUuid the user uuid of this marker
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_marker.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this marker.
	*
	* @return the name of this marker
	*/
	public java.lang.String getName() {
		return _marker.getName();
	}

	/**
	* Sets the name of this marker.
	*
	* @param name the name of this marker
	*/
	public void setName(java.lang.String name) {
		_marker.setName(name);
	}

	/**
	* Returns the description of this marker.
	*
	* @return the description of this marker
	*/
	public java.lang.String getDescription() {
		return _marker.getDescription();
	}

	/**
	* Sets the description of this marker.
	*
	* @param description the description of this marker
	*/
	public void setDescription(java.lang.String description) {
		_marker.setDescription(description);
	}

	/**
	* Returns the reference url of this marker.
	*
	* @return the reference url of this marker
	*/
	public java.lang.String getReferenceUrl() {
		return _marker.getReferenceUrl();
	}

	/**
	* Sets the reference url of this marker.
	*
	* @param referenceUrl the reference url of this marker
	*/
	public void setReferenceUrl(java.lang.String referenceUrl) {
		_marker.setReferenceUrl(referenceUrl);
	}

	/**
	* Returns the background ID of this marker.
	*
	* @return the background ID of this marker
	*/
	public long getBackgroundId() {
		return _marker.getBackgroundId();
	}

	/**
	* Sets the background ID of this marker.
	*
	* @param backgroundId the background ID of this marker
	*/
	public void setBackgroundId(long backgroundId) {
		_marker.setBackgroundId(backgroundId);
	}

	/**
	* Returns the longitude of this marker.
	*
	* @return the longitude of this marker
	*/
	public double getLongitude() {
		return _marker.getLongitude();
	}

	/**
	* Sets the longitude of this marker.
	*
	* @param longitude the longitude of this marker
	*/
	public void setLongitude(double longitude) {
		_marker.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this marker.
	*
	* @return the latitude of this marker
	*/
	public double getLatitude() {
		return _marker.getLatitude();
	}

	/**
	* Sets the latitude of this marker.
	*
	* @param latitude the latitude of this marker
	*/
	public void setLatitude(double latitude) {
		_marker.setLatitude(latitude);
	}

	public boolean isNew() {
		return _marker.isNew();
	}

	public void setNew(boolean n) {
		_marker.setNew(n);
	}

	public boolean isCachedModel() {
		return _marker.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_marker.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _marker.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _marker.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marker.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarkerWrapper((Marker)_marker.clone());
	}

	public int compareTo(org.politaktiv.map.infrastructure.model.Marker marker) {
		return _marker.compareTo(marker);
	}

	@Override
	public int hashCode() {
		return _marker.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.politaktiv.map.infrastructure.model.Marker> toCacheModel() {
		return _marker.toCacheModel();
	}

	public org.politaktiv.map.infrastructure.model.Marker toEscapedModel() {
		return new MarkerWrapper(_marker.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marker.toString();
	}

	public java.lang.String toXmlString() {
		return _marker.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marker.persist();
	}

	public void validate() throws javax.portlet.ValidatorException {
		_marker.validate();
	}

	public java.lang.String toHTMLFormatedString()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marker.toHTMLFormatedString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Marker getWrappedMarker() {
		return _marker;
	}

	public Marker getWrappedModel() {
		return _marker;
	}

	public void resetOriginalValues() {
		_marker.resetOriginalValues();
	}

	private Marker _marker;
}