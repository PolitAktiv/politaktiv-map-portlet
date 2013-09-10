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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Picture}.
 * </p>
 *
 * @author    eichi
 * @see       Picture
 * @generated
 */
public class PictureWrapper implements Picture, ModelWrapper<Picture> {
	public PictureWrapper(Picture picture) {
		_picture = picture;
	}

	public Class<?> getModelClass() {
		return Picture.class;
	}

	public String getModelClassName() {
		return Picture.class.getName();
	}

	/**
	* Returns the primary key of this picture.
	*
	* @return the primary key of this picture
	*/
	public long getPrimaryKey() {
		return _picture.getPrimaryKey();
	}

	/**
	* Sets the primary key of this picture.
	*
	* @param primaryKey the primary key of this picture
	*/
	public void setPrimaryKey(long primaryKey) {
		_picture.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the picture ID of this picture.
	*
	* @return the picture ID of this picture
	*/
	public long getPictureId() {
		return _picture.getPictureId();
	}

	/**
	* Sets the picture ID of this picture.
	*
	* @param pictureId the picture ID of this picture
	*/
	public void setPictureId(long pictureId) {
		_picture.setPictureId(pictureId);
	}

	/**
	* Returns the company ID of this picture.
	*
	* @return the company ID of this picture
	*/
	public long getCompanyId() {
		return _picture.getCompanyId();
	}

	/**
	* Sets the company ID of this picture.
	*
	* @param companyId the company ID of this picture
	*/
	public void setCompanyId(long companyId) {
		_picture.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this picture.
	*
	* @return the group ID of this picture
	*/
	public long getGroupId() {
		return _picture.getGroupId();
	}

	/**
	* Sets the group ID of this picture.
	*
	* @param groupId the group ID of this picture
	*/
	public void setGroupId(long groupId) {
		_picture.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this picture.
	*
	* @return the user ID of this picture
	*/
	public long getUserId() {
		return _picture.getUserId();
	}

	/**
	* Sets the user ID of this picture.
	*
	* @param userId the user ID of this picture
	*/
	public void setUserId(long userId) {
		_picture.setUserId(userId);
	}

	/**
	* Returns the user uuid of this picture.
	*
	* @return the user uuid of this picture
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _picture.getUserUuid();
	}

	/**
	* Sets the user uuid of this picture.
	*
	* @param userUuid the user uuid of this picture
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_picture.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this picture.
	*
	* @return the name of this picture
	*/
	public java.lang.String getName() {
		return _picture.getName();
	}

	/**
	* Sets the name of this picture.
	*
	* @param name the name of this picture
	*/
	public void setName(java.lang.String name) {
		_picture.setName(name);
	}

	/**
	* Returns the description of this picture.
	*
	* @return the description of this picture
	*/
	public java.lang.String getDescription() {
		return _picture.getDescription();
	}

	/**
	* Sets the description of this picture.
	*
	* @param description the description of this picture
	*/
	public void setDescription(java.lang.String description) {
		_picture.setDescription(description);
	}

	/**
	* Returns the reference url of this picture.
	*
	* @return the reference url of this picture
	*/
	public java.lang.String getReferenceUrl() {
		return _picture.getReferenceUrl();
	}

	/**
	* Sets the reference url of this picture.
	*
	* @param referenceUrl the reference url of this picture
	*/
	public void setReferenceUrl(java.lang.String referenceUrl) {
		_picture.setReferenceUrl(referenceUrl);
	}

	/**
	* Returns the background ID of this picture.
	*
	* @return the background ID of this picture
	*/
	public long getBackgroundId() {
		return _picture.getBackgroundId();
	}

	/**
	* Sets the background ID of this picture.
	*
	* @param backgroundId the background ID of this picture
	*/
	public void setBackgroundId(long backgroundId) {
		_picture.setBackgroundId(backgroundId);
	}

	/**
	* Returns the rotation of this picture.
	*
	* @return the rotation of this picture
	*/
	public long getRotation() {
		return _picture.getRotation();
	}

	/**
	* Sets the rotation of this picture.
	*
	* @param rotation the rotation of this picture
	*/
	public void setRotation(long rotation) {
		_picture.setRotation(rotation);
	}

	/**
	* Returns the width of this picture.
	*
	* @return the width of this picture
	*/
	public double getWidth() {
		return _picture.getWidth();
	}

	/**
	* Sets the width of this picture.
	*
	* @param width the width of this picture
	*/
	public void setWidth(double width) {
		_picture.setWidth(width);
	}

	/**
	* Returns the height of this picture.
	*
	* @return the height of this picture
	*/
	public double getHeight() {
		return _picture.getHeight();
	}

	/**
	* Sets the height of this picture.
	*
	* @param height the height of this picture
	*/
	public void setHeight(double height) {
		_picture.setHeight(height);
	}

	/**
	* Returns the resolution of this picture.
	*
	* @return the resolution of this picture
	*/
	public double getResolution() {
		return _picture.getResolution();
	}

	/**
	* Sets the resolution of this picture.
	*
	* @param resolution the resolution of this picture
	*/
	public void setResolution(double resolution) {
		_picture.setResolution(resolution);
	}

	/**
	* Returns the ocupacy of this picture.
	*
	* @return the ocupacy of this picture
	*/
	public double getOcupacy() {
		return _picture.getOcupacy();
	}

	/**
	* Sets the ocupacy of this picture.
	*
	* @param ocupacy the ocupacy of this picture
	*/
	public void setOcupacy(double ocupacy) {
		_picture.setOcupacy(ocupacy);
	}

	/**
	* Returns the longitude of this picture.
	*
	* @return the longitude of this picture
	*/
	public double getLongitude() {
		return _picture.getLongitude();
	}

	/**
	* Sets the longitude of this picture.
	*
	* @param longitude the longitude of this picture
	*/
	public void setLongitude(double longitude) {
		_picture.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this picture.
	*
	* @return the latitude of this picture
	*/
	public double getLatitude() {
		return _picture.getLatitude();
	}

	/**
	* Sets the latitude of this picture.
	*
	* @param latitude the latitude of this picture
	*/
	public void setLatitude(double latitude) {
		_picture.setLatitude(latitude);
	}

	/**
	* Returns the file entry uuid of this picture.
	*
	* @return the file entry uuid of this picture
	*/
	public java.lang.String getFileEntryUuid() {
		return _picture.getFileEntryUuid();
	}

	/**
	* Sets the file entry uuid of this picture.
	*
	* @param fileEntryUuid the file entry uuid of this picture
	*/
	public void setFileEntryUuid(java.lang.String fileEntryUuid) {
		_picture.setFileEntryUuid(fileEntryUuid);
	}

	public boolean isNew() {
		return _picture.isNew();
	}

	public void setNew(boolean n) {
		_picture.setNew(n);
	}

	public boolean isCachedModel() {
		return _picture.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_picture.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _picture.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _picture.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_picture.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _picture.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_picture.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PictureWrapper((Picture)_picture.clone());
	}

	public int compareTo(
		org.politaktiv.map.infrastructure.model.Picture picture) {
		return _picture.compareTo(picture);
	}

	@Override
	public int hashCode() {
		return _picture.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.politaktiv.map.infrastructure.model.Picture> toCacheModel() {
		return _picture.toCacheModel();
	}

	public org.politaktiv.map.infrastructure.model.Picture toEscapedModel() {
		return new PictureWrapper(_picture.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _picture.toString();
	}

	public java.lang.String toXmlString() {
		return _picture.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_picture.persist();
	}

	public java.lang.String getPictureUrl() {
		return _picture.getPictureUrl();
	}

	public void validate()
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_picture.validate();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Picture getWrappedPicture() {
		return _picture;
	}

	public Picture getWrappedModel() {
		return _picture;
	}

	public void resetOriginalValues() {
		_picture.resetOriginalValues();
	}

	private Picture _picture;
}