/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.politaktiv.map.infrastructure.model;

import java.io.Serializable;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelWrapper;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * <p>
 * This class is a wrapper for {@link Background}.
 * </p>
 *
 * @author    eichi
 * @see       Background
 * @generated
 */
public class BackgroundWrapper implements Background, ModelWrapper<Background> {
	public BackgroundWrapper(Background background) {
		_background = background;
	}

	public Class<?> getModelClass() {
		return Background.class;
	}

	public String getModelClassName() {
		return Background.class.getName();
	}

	/**
	* Returns the primary key of this background.
	*
	* @return the primary key of this background
	*/
	public long getPrimaryKey() {
		return _background.getPrimaryKey();
	}

	/**
	* Sets the primary key of this background.
	*
	* @param primaryKey the primary key of this background
	*/
	public void setPrimaryKey(long primaryKey) {
		_background.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the background ID of this background.
	*
	* @return the background ID of this background
	*/
	public long getBackgroundId() {
		return _background.getBackgroundId();
	}

	/**
	* Sets the background ID of this background.
	*
	* @param backgroundId the background ID of this background
	*/
	public void setBackgroundId(long backgroundId) {
		_background.setBackgroundId(backgroundId);
	}

	/**
	* Returns the company ID of this background.
	*
	* @return the company ID of this background
	*/
	public long getCompanyId() {
		return _background.getCompanyId();
	}

	/**
	* Sets the company ID of this background.
	*
	* @param companyId the company ID of this background
	*/
	public void setCompanyId(long companyId) {
		_background.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this background.
	*
	* @return the group ID of this background
	*/
	public long getGroupId() {
		return _background.getGroupId();
	}

	/**
	* Sets the group ID of this background.
	*
	* @param groupId the group ID of this background
	*/
	public void setGroupId(long groupId) {
		_background.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this background.
	*
	* @return the user ID of this background
	*/
	public long getUserId() {
		return _background.getUserId();
	}

	/**
	* Sets the user ID of this background.
	*
	* @param userId the user ID of this background
	*/
	public void setUserId(long userId) {
		_background.setUserId(userId);
	}

	/**
	* Returns the user uuid of this background.
	*
	* @return the user uuid of this background
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws SystemException {
		return _background.getUserUuid();
	}

	/**
	* Sets the user uuid of this background.
	*
	* @param userUuid the user uuid of this background
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_background.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this background.
	*
	* @return the name of this background
	*/
	public String getName() {
		return _background.getName();
	}

	/**
	* Sets the name of this background.
	*
	* @param name the name of this background
	*/
	public void setName(String name) {
		_background.setName(name);
	}

	/**
	* Returns the file entry uuid of this background.
	*
	* @return the file entry uuid of this background
	*/
	public String getFileEntryUuid() {
		return _background.getFileEntryUuid();
	}

	/**
	* Sets the file entry uuid of this background.
	*
	* @param fileEntryUuid the file entry uuid of this background
	*/
	public void setFileEntryUuid(String fileEntryUuid) {
		_background.setFileEntryUuid(fileEntryUuid);
	}

	public boolean isNew() {
		return _background.isNew();
	}

	public void setNew(boolean n) {
		_background.setNew(n);
	}

	public boolean isCachedModel() {
		return _background.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_background.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _background.isEscapedModel();
	}

	public Serializable getPrimaryKeyObj() {
		return _background.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_background.setPrimaryKeyObj(primaryKeyObj);
	}

	public ExpandoBridge getExpandoBridge() {
		return _background.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		ServiceContext serviceContext) {
		_background.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BackgroundWrapper((Background)_background.clone());
	}

	public int compareTo(Background background) {
		return _background.compareTo(background);
	}

	@Override
	public int hashCode() {
		return _background.hashCode();
	}

	public CacheModel<Background> toCacheModel() {
		return _background.toCacheModel();
	}

	public Background toEscapedModel() {
		return new BackgroundWrapper(_background.toEscapedModel());
	}

	@Override
	public String toString() {
		return _background.toString();
	}

	public String toXmlString() {
		return _background.toXmlString();
	}

	public void persist()
		throws SystemException {
		_background.persist();
	}

	public String getPictureUrl() {
		return _background.getPictureUrl();
	}

	public boolean isMap() {
		return _background.isMap();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Background getWrappedBackground() {
		return _background;
	}

	public Background getWrappedModel() {
		return _background;
	}

	public void resetOriginalValues() {
		_background.resetOriginalValues();
	}

	private Background _background;
}