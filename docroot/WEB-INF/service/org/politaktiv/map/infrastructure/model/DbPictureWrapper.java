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
 * This class is a wrapper for {@link DbPicture}.
 * </p>
 *
 * @author    eichi
 * @see       DbPicture
 * @generated
 */
public class DbPictureWrapper implements DbPicture, ModelWrapper<DbPicture> {
	public DbPictureWrapper(DbPicture dbPicture) {
		_dbPicture = dbPicture;
	}

	public Class<?> getModelClass() {
		return DbPicture.class;
	}

	public String getModelClassName() {
		return DbPicture.class.getName();
	}

	/**
	* Returns the primary key of this db picture.
	*
	* @return the primary key of this db picture
	*/
	public long getPrimaryKey() {
		return _dbPicture.getPrimaryKey();
	}

	/**
	* Sets the primary key of this db picture.
	*
	* @param primaryKey the primary key of this db picture
	*/
	public void setPrimaryKey(long primaryKey) {
		_dbPicture.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the picture ID of this db picture.
	*
	* @return the picture ID of this db picture
	*/
	public long getPictureId() {
		return _dbPicture.getPictureId();
	}

	/**
	* Sets the picture ID of this db picture.
	*
	* @param pictureId the picture ID of this db picture
	*/
	public void setPictureId(long pictureId) {
		_dbPicture.setPictureId(pictureId);
	}

	/**
	* Returns the rotation of this db picture.
	*
	* @return the rotation of this db picture
	*/
	public long getRotation() {
		return _dbPicture.getRotation();
	}

	/**
	* Sets the rotation of this db picture.
	*
	* @param rotation the rotation of this db picture
	*/
	public void setRotation(long rotation) {
		_dbPicture.setRotation(rotation);
	}

	/**
	* Returns the width of this db picture.
	*
	* @return the width of this db picture
	*/
	public long getWidth() {
		return _dbPicture.getWidth();
	}

	/**
	* Sets the width of this db picture.
	*
	* @param width the width of this db picture
	*/
	public void setWidth(long width) {
		_dbPicture.setWidth(width);
	}

	/**
	* Returns the height of this db picture.
	*
	* @return the height of this db picture
	*/
	public long getHeight() {
		return _dbPicture.getHeight();
	}

	/**
	* Sets the height of this db picture.
	*
	* @param height the height of this db picture
	*/
	public void setHeight(long height) {
		_dbPicture.setHeight(height);
	}

	/**
	* Returns the resolution of this db picture.
	*
	* @return the resolution of this db picture
	*/
	public double getResolution() {
		return _dbPicture.getResolution();
	}

	/**
	* Sets the resolution of this db picture.
	*
	* @param resolution the resolution of this db picture
	*/
	public void setResolution(double resolution) {
		_dbPicture.setResolution(resolution);
	}

	/**
	* Returns the point ID of this db picture.
	*
	* @return the point ID of this db picture
	*/
	public long getPointId() {
		return _dbPicture.getPointId();
	}

	/**
	* Sets the point ID of this db picture.
	*
	* @param pointId the point ID of this db picture
	*/
	public void setPointId(long pointId) {
		_dbPicture.setPointId(pointId);
	}

	public boolean isNew() {
		return _dbPicture.isNew();
	}

	public void setNew(boolean n) {
		_dbPicture.setNew(n);
	}

	public boolean isCachedModel() {
		return _dbPicture.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dbPicture.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dbPicture.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dbPicture.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dbPicture.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dbPicture.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dbPicture.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DbPictureWrapper((DbPicture)_dbPicture.clone());
	}

	public int compareTo(DbPicture dbPicture) {
		return _dbPicture.compareTo(dbPicture);
	}

	@Override
	public int hashCode() {
		return _dbPicture.hashCode();
	}

	public com.liferay.portal.model.CacheModel<DbPicture> toCacheModel() {
		return _dbPicture.toCacheModel();
	}

	public DbPicture toEscapedModel() {
		return new DbPictureWrapper(_dbPicture.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dbPicture.toString();
	}

	public java.lang.String toXmlString() {
		return _dbPicture.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dbPicture.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DbPicture getWrappedDbPicture() {
		return _dbPicture;
	}

	public DbPicture getWrappedModel() {
		return _dbPicture;
	}

	public void resetOriginalValues() {
		_dbPicture.resetOriginalValues();
	}

	private DbPicture _dbPicture;
}