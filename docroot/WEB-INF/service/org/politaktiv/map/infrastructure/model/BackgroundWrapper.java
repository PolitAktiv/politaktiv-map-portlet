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
 * This class is a wrapper for {@link Background}.
 * </p>
 *
 * @author eichi
 * @see Background
 * @generated
 */
public class BackgroundWrapper implements Background, ModelWrapper<Background> {
	public BackgroundWrapper(Background background) {
		_background = background;
	}

	@Override
	public Class<?> getModelClass() {
		return Background.class;
	}

	@Override
	public String getModelClassName() {
		return Background.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("backgroundId", getBackgroundId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("fileEntryUuid", getFileEntryUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long backgroundId = (Long)attributes.get("backgroundId");

		if (backgroundId != null) {
			setBackgroundId(backgroundId);
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

		String fileEntryUuid = (String)attributes.get("fileEntryUuid");

		if (fileEntryUuid != null) {
			setFileEntryUuid(fileEntryUuid);
		}
	}

	/**
	* Returns the primary key of this background.
	*
	* @return the primary key of this background
	*/
	@Override
	public long getPrimaryKey() {
		return _background.getPrimaryKey();
	}

	/**
	* Sets the primary key of this background.
	*
	* @param primaryKey the primary key of this background
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_background.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the background ID of this background.
	*
	* @return the background ID of this background
	*/
	@Override
	public long getBackgroundId() {
		return _background.getBackgroundId();
	}

	/**
	* Sets the background ID of this background.
	*
	* @param backgroundId the background ID of this background
	*/
	@Override
	public void setBackgroundId(long backgroundId) {
		_background.setBackgroundId(backgroundId);
	}

	/**
	* Returns the company ID of this background.
	*
	* @return the company ID of this background
	*/
	@Override
	public long getCompanyId() {
		return _background.getCompanyId();
	}

	/**
	* Sets the company ID of this background.
	*
	* @param companyId the company ID of this background
	*/
	@Override
	public void setCompanyId(long companyId) {
		_background.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this background.
	*
	* @return the group ID of this background
	*/
	@Override
	public long getGroupId() {
		return _background.getGroupId();
	}

	/**
	* Sets the group ID of this background.
	*
	* @param groupId the group ID of this background
	*/
	@Override
	public void setGroupId(long groupId) {
		_background.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this background.
	*
	* @return the user ID of this background
	*/
	@Override
	public long getUserId() {
		return _background.getUserId();
	}

	/**
	* Sets the user ID of this background.
	*
	* @param userId the user ID of this background
	*/
	@Override
	public void setUserId(long userId) {
		_background.setUserId(userId);
	}

	/**
	* Returns the user uuid of this background.
	*
	* @return the user uuid of this background
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _background.getUserUuid();
	}

	/**
	* Sets the user uuid of this background.
	*
	* @param userUuid the user uuid of this background
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_background.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this background.
	*
	* @return the name of this background
	*/
	@Override
	public java.lang.String getName() {
		return _background.getName();
	}

	/**
	* Sets the name of this background.
	*
	* @param name the name of this background
	*/
	@Override
	public void setName(java.lang.String name) {
		_background.setName(name);
	}

	/**
	* Returns the file entry uuid of this background.
	*
	* @return the file entry uuid of this background
	*/
	@Override
	public java.lang.String getFileEntryUuid() {
		return _background.getFileEntryUuid();
	}

	/**
	* Sets the file entry uuid of this background.
	*
	* @param fileEntryUuid the file entry uuid of this background
	*/
	@Override
	public void setFileEntryUuid(java.lang.String fileEntryUuid) {
		_background.setFileEntryUuid(fileEntryUuid);
	}

	@Override
	public boolean isNew() {
		return _background.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_background.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _background.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_background.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _background.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _background.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_background.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _background.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_background.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_background.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_background.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BackgroundWrapper((Background)_background.clone());
	}

	@Override
	public int compareTo(Background background) {
		return _background.compareTo(background);
	}

	@Override
	public int hashCode() {
		return _background.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Background> toCacheModel() {
		return _background.toCacheModel();
	}

	@Override
	public Background toEscapedModel() {
		return new BackgroundWrapper(_background.toEscapedModel());
	}

	@Override
	public Background toUnescapedModel() {
		return new BackgroundWrapper(_background.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _background.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _background.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_background.persist();
	}

	@Override
	public java.lang.String getPictureUrl() {
		return _background.getPictureUrl();
	}

	@Override
	public boolean isMap() {
		return _background.isMap();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BackgroundWrapper)) {
			return false;
		}

		BackgroundWrapper backgroundWrapper = (BackgroundWrapper)obj;

		if (Validator.equals(_background, backgroundWrapper._background)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Background getWrappedBackground() {
		return _background;
	}

	@Override
	public Background getWrappedModel() {
		return _background;
	}

	@Override
	public void resetOriginalValues() {
		_background.resetOriginalValues();
	}

	private Background _background;
}