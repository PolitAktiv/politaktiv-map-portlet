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
 * This class is a wrapper for {@link DbMapObject}.
 * </p>
 *
 * @author    eichi
 * @see       DbMapObject
 * @generated
 */
public class DbMapObjectWrapper implements DbMapObject,
	ModelWrapper<DbMapObject> {
	public DbMapObjectWrapper(DbMapObject dbMapObject) {
		_dbMapObject = dbMapObject;
	}

	public Class<?> getModelClass() {
		return DbMapObject.class;
	}

	public String getModelClassName() {
		return DbMapObject.class.getName();
	}

	/**
	* Returns the primary key of this db map object.
	*
	* @return the primary key of this db map object
	*/
	public long getPrimaryKey() {
		return _dbMapObject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this db map object.
	*
	* @param primaryKey the primary key of this db map object
	*/
	public void setPrimaryKey(long primaryKey) {
		_dbMapObject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the map object ID of this db map object.
	*
	* @return the map object ID of this db map object
	*/
	public long getMapObjectId() {
		return _dbMapObject.getMapObjectId();
	}

	/**
	* Sets the map object ID of this db map object.
	*
	* @param mapObjectId the map object ID of this db map object
	*/
	public void setMapObjectId(long mapObjectId) {
		_dbMapObject.setMapObjectId(mapObjectId);
	}

	/**
	* Returns the company ID of this db map object.
	*
	* @return the company ID of this db map object
	*/
	public long getCompanyId() {
		return _dbMapObject.getCompanyId();
	}

	/**
	* Sets the company ID of this db map object.
	*
	* @param companyId the company ID of this db map object
	*/
	public void setCompanyId(long companyId) {
		_dbMapObject.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this db map object.
	*
	* @return the group ID of this db map object
	*/
	public long getGroupId() {
		return _dbMapObject.getGroupId();
	}

	/**
	* Sets the group ID of this db map object.
	*
	* @param groupId the group ID of this db map object
	*/
	public void setGroupId(long groupId) {
		_dbMapObject.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this db map object.
	*
	* @return the user ID of this db map object
	*/
	public long getUserId() {
		return _dbMapObject.getUserId();
	}

	/**
	* Sets the user ID of this db map object.
	*
	* @param userId the user ID of this db map object
	*/
	public void setUserId(long userId) {
		_dbMapObject.setUserId(userId);
	}

	/**
	* Returns the user uuid of this db map object.
	*
	* @return the user uuid of this db map object
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dbMapObject.getUserUuid();
	}

	/**
	* Sets the user uuid of this db map object.
	*
	* @param userUuid the user uuid of this db map object
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_dbMapObject.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this db map object.
	*
	* @return the name of this db map object
	*/
	public java.lang.String getName() {
		return _dbMapObject.getName();
	}

	/**
	* Sets the name of this db map object.
	*
	* @param name the name of this db map object
	*/
	public void setName(java.lang.String name) {
		_dbMapObject.setName(name);
	}

	/**
	* Returns the description of this db map object.
	*
	* @return the description of this db map object
	*/
	public java.lang.String getDescription() {
		return _dbMapObject.getDescription();
	}

	/**
	* Sets the description of this db map object.
	*
	* @param description the description of this db map object
	*/
	public void setDescription(java.lang.String description) {
		_dbMapObject.setDescription(description);
	}

	/**
	* Returns the reference url of this db map object.
	*
	* @return the reference url of this db map object
	*/
	public java.lang.String getReferenceUrl() {
		return _dbMapObject.getReferenceUrl();
	}

	/**
	* Sets the reference url of this db map object.
	*
	* @param referenceUrl the reference url of this db map object
	*/
	public void setReferenceUrl(java.lang.String referenceUrl) {
		_dbMapObject.setReferenceUrl(referenceUrl);
	}

	/**
	* Returns the occupancy of this db map object.
	*
	* @return the occupancy of this db map object
	*/
	public long getOccupancy() {
		return _dbMapObject.getOccupancy();
	}

	/**
	* Sets the occupancy of this db map object.
	*
	* @param occupancy the occupancy of this db map object
	*/
	public void setOccupancy(long occupancy) {
		_dbMapObject.setOccupancy(occupancy);
	}

	/**
	* Returns the map ID of this db map object.
	*
	* @return the map ID of this db map object
	*/
	public long getMapId() {
		return _dbMapObject.getMapId();
	}

	/**
	* Sets the map ID of this db map object.
	*
	* @param mapId the map ID of this db map object
	*/
	public void setMapId(long mapId) {
		_dbMapObject.setMapId(mapId);
	}

	/**
	* Returns the type of this db map object.
	*
	* @return the type of this db map object
	*/
	public java.lang.String getType() {
		return _dbMapObject.getType();
	}

	/**
	* Sets the type of this db map object.
	*
	* @param type the type of this db map object
	*/
	public void setType(java.lang.String type) {
		_dbMapObject.setType(type);
	}

	/**
	* Returns the graphic object ID of this db map object.
	*
	* @return the graphic object ID of this db map object
	*/
	public long getGraphicObjectId() {
		return _dbMapObject.getGraphicObjectId();
	}

	/**
	* Sets the graphic object ID of this db map object.
	*
	* @param graphicObjectId the graphic object ID of this db map object
	*/
	public void setGraphicObjectId(long graphicObjectId) {
		_dbMapObject.setGraphicObjectId(graphicObjectId);
	}

	public boolean isNew() {
		return _dbMapObject.isNew();
	}

	public void setNew(boolean n) {
		_dbMapObject.setNew(n);
	}

	public boolean isCachedModel() {
		return _dbMapObject.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dbMapObject.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dbMapObject.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dbMapObject.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dbMapObject.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dbMapObject.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dbMapObject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DbMapObjectWrapper((DbMapObject)_dbMapObject.clone());
	}

	public int compareTo(DbMapObject dbMapObject) {
		return _dbMapObject.compareTo(dbMapObject);
	}

	@Override
	public int hashCode() {
		return _dbMapObject.hashCode();
	}

	public com.liferay.portal.model.CacheModel<DbMapObject> toCacheModel() {
		return _dbMapObject.toCacheModel();
	}

	public DbMapObject toEscapedModel() {
		return new DbMapObjectWrapper(_dbMapObject.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dbMapObject.toString();
	}

	public java.lang.String toXmlString() {
		return _dbMapObject.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dbMapObject.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DbMapObject getWrappedDbMapObject() {
		return _dbMapObject;
	}

	public DbMapObject getWrappedModel() {
		return _dbMapObject;
	}

	public void resetOriginalValues() {
		_dbMapObject.resetOriginalValues();
	}

	private DbMapObject _dbMapObject;
}