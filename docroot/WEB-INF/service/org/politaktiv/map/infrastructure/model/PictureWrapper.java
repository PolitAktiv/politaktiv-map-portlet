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
 * This class is a wrapper for {@link Picture}.
 * </p>
 *
 * @author eichi
 * @see Picture
 * @generated
 */
public class PictureWrapper implements Picture, ModelWrapper<Picture> {
	public PictureWrapper(Picture picture) {
		_picture = picture;
	}

	@Override
	public Class<?> getModelClass() {
		return Picture.class;
	}

	@Override
	public String getModelClassName() {
		return Picture.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pictureId", getPictureId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("referenceUrl", getReferenceUrl());
		attributes.put("backgroundId", getBackgroundId());
		attributes.put("rotation", getRotation());
		attributes.put("width", getWidth());
		attributes.put("height", getHeight());
		attributes.put("resolution", getResolution());
		attributes.put("ocupacy", getOcupacy());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());
		attributes.put("fileEntryUuid", getFileEntryUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pictureId = (Long)attributes.get("pictureId");

		if (pictureId != null) {
			setPictureId(pictureId);
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

		Long rotation = (Long)attributes.get("rotation");

		if (rotation != null) {
			setRotation(rotation);
		}

		Double width = (Double)attributes.get("width");

		if (width != null) {
			setWidth(width);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double resolution = (Double)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		Double ocupacy = (Double)attributes.get("ocupacy");

		if (ocupacy != null) {
			setOcupacy(ocupacy);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String fileEntryUuid = (String)attributes.get("fileEntryUuid");

		if (fileEntryUuid != null) {
			setFileEntryUuid(fileEntryUuid);
		}
	}

	/**
	* Returns the primary key of this picture.
	*
	* @return the primary key of this picture
	*/
	@Override
	public long getPrimaryKey() {
		return _picture.getPrimaryKey();
	}

	/**
	* Sets the primary key of this picture.
	*
	* @param primaryKey the primary key of this picture
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_picture.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the picture ID of this picture.
	*
	* @return the picture ID of this picture
	*/
	@Override
	public long getPictureId() {
		return _picture.getPictureId();
	}

	/**
	* Sets the picture ID of this picture.
	*
	* @param pictureId the picture ID of this picture
	*/
	@Override
	public void setPictureId(long pictureId) {
		_picture.setPictureId(pictureId);
	}

	/**
	* Returns the company ID of this picture.
	*
	* @return the company ID of this picture
	*/
	@Override
	public long getCompanyId() {
		return _picture.getCompanyId();
	}

	/**
	* Sets the company ID of this picture.
	*
	* @param companyId the company ID of this picture
	*/
	@Override
	public void setCompanyId(long companyId) {
		_picture.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this picture.
	*
	* @return the group ID of this picture
	*/
	@Override
	public long getGroupId() {
		return _picture.getGroupId();
	}

	/**
	* Sets the group ID of this picture.
	*
	* @param groupId the group ID of this picture
	*/
	@Override
	public void setGroupId(long groupId) {
		_picture.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this picture.
	*
	* @return the user ID of this picture
	*/
	@Override
	public long getUserId() {
		return _picture.getUserId();
	}

	/**
	* Sets the user ID of this picture.
	*
	* @param userId the user ID of this picture
	*/
	@Override
	public void setUserId(long userId) {
		_picture.setUserId(userId);
	}

	/**
	* Returns the user uuid of this picture.
	*
	* @return the user uuid of this picture
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _picture.getUserUuid();
	}

	/**
	* Sets the user uuid of this picture.
	*
	* @param userUuid the user uuid of this picture
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_picture.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this picture.
	*
	* @return the name of this picture
	*/
	@Override
	public java.lang.String getName() {
		return _picture.getName();
	}

	/**
	* Sets the name of this picture.
	*
	* @param name the name of this picture
	*/
	@Override
	public void setName(java.lang.String name) {
		_picture.setName(name);
	}

	/**
	* Returns the description of this picture.
	*
	* @return the description of this picture
	*/
	@Override
	public java.lang.String getDescription() {
		return _picture.getDescription();
	}

	/**
	* Sets the description of this picture.
	*
	* @param description the description of this picture
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_picture.setDescription(description);
	}

	/**
	* Returns the reference url of this picture.
	*
	* @return the reference url of this picture
	*/
	@Override
	public java.lang.String getReferenceUrl() {
		return _picture.getReferenceUrl();
	}

	/**
	* Sets the reference url of this picture.
	*
	* @param referenceUrl the reference url of this picture
	*/
	@Override
	public void setReferenceUrl(java.lang.String referenceUrl) {
		_picture.setReferenceUrl(referenceUrl);
	}

	/**
	* Returns the background ID of this picture.
	*
	* @return the background ID of this picture
	*/
	@Override
	public long getBackgroundId() {
		return _picture.getBackgroundId();
	}

	/**
	* Sets the background ID of this picture.
	*
	* @param backgroundId the background ID of this picture
	*/
	@Override
	public void setBackgroundId(long backgroundId) {
		_picture.setBackgroundId(backgroundId);
	}

	/**
	* Returns the rotation of this picture.
	*
	* @return the rotation of this picture
	*/
	@Override
	public long getRotation() {
		return _picture.getRotation();
	}

	/**
	* Sets the rotation of this picture.
	*
	* @param rotation the rotation of this picture
	*/
	@Override
	public void setRotation(long rotation) {
		_picture.setRotation(rotation);
	}

	/**
	* Returns the width of this picture.
	*
	* @return the width of this picture
	*/
	@Override
	public double getWidth() {
		return _picture.getWidth();
	}

	/**
	* Sets the width of this picture.
	*
	* @param width the width of this picture
	*/
	@Override
	public void setWidth(double width) {
		_picture.setWidth(width);
	}

	/**
	* Returns the height of this picture.
	*
	* @return the height of this picture
	*/
	@Override
	public double getHeight() {
		return _picture.getHeight();
	}

	/**
	* Sets the height of this picture.
	*
	* @param height the height of this picture
	*/
	@Override
	public void setHeight(double height) {
		_picture.setHeight(height);
	}

	/**
	* Returns the resolution of this picture.
	*
	* @return the resolution of this picture
	*/
	@Override
	public double getResolution() {
		return _picture.getResolution();
	}

	/**
	* Sets the resolution of this picture.
	*
	* @param resolution the resolution of this picture
	*/
	@Override
	public void setResolution(double resolution) {
		_picture.setResolution(resolution);
	}

	/**
	* Returns the ocupacy of this picture.
	*
	* @return the ocupacy of this picture
	*/
	@Override
	public double getOcupacy() {
		return _picture.getOcupacy();
	}

	/**
	* Sets the ocupacy of this picture.
	*
	* @param ocupacy the ocupacy of this picture
	*/
	@Override
	public void setOcupacy(double ocupacy) {
		_picture.setOcupacy(ocupacy);
	}

	/**
	* Returns the longitude of this picture.
	*
	* @return the longitude of this picture
	*/
	@Override
	public double getLongitude() {
		return _picture.getLongitude();
	}

	/**
	* Sets the longitude of this picture.
	*
	* @param longitude the longitude of this picture
	*/
	@Override
	public void setLongitude(double longitude) {
		_picture.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this picture.
	*
	* @return the latitude of this picture
	*/
	@Override
	public double getLatitude() {
		return _picture.getLatitude();
	}

	/**
	* Sets the latitude of this picture.
	*
	* @param latitude the latitude of this picture
	*/
	@Override
	public void setLatitude(double latitude) {
		_picture.setLatitude(latitude);
	}

	/**
	* Returns the file entry uuid of this picture.
	*
	* @return the file entry uuid of this picture
	*/
	@Override
	public java.lang.String getFileEntryUuid() {
		return _picture.getFileEntryUuid();
	}

	/**
	* Sets the file entry uuid of this picture.
	*
	* @param fileEntryUuid the file entry uuid of this picture
	*/
	@Override
	public void setFileEntryUuid(java.lang.String fileEntryUuid) {
		_picture.setFileEntryUuid(fileEntryUuid);
	}

	@Override
	public boolean isNew() {
		return _picture.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_picture.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _picture.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_picture.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _picture.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _picture.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_picture.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _picture.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_picture.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_picture.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_picture.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PictureWrapper((Picture)_picture.clone());
	}

	@Override
	public int compareTo(
		org.politaktiv.map.infrastructure.model.Picture picture) {
		return _picture.compareTo(picture);
	}

	@Override
	public int hashCode() {
		return _picture.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.infrastructure.model.Picture> toCacheModel() {
		return _picture.toCacheModel();
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Picture toEscapedModel() {
		return new PictureWrapper(_picture.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.infrastructure.model.Picture toUnescapedModel() {
		return new PictureWrapper(_picture.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _picture.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _picture.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_picture.persist();
	}

	@Override
	public java.lang.String getPictureUrl() {
		return _picture.getPictureUrl();
	}

	@Override
	public void validate()
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_picture.validate();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PictureWrapper)) {
			return false;
		}

		PictureWrapper pictureWrapper = (PictureWrapper)obj;

		if (Validator.equals(_picture, pictureWrapper._picture)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Picture getWrappedPicture() {
		return _picture;
	}

	@Override
	public Picture getWrappedModel() {
		return _picture;
	}

	@Override
	public void resetOriginalValues() {
		_picture.resetOriginalValues();
	}

	private Picture _picture;
}