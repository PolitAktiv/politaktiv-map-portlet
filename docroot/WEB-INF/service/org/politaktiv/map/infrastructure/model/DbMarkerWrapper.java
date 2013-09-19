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
 * This class is a wrapper for {@link DbMarker}.
 * </p>
 *
 * @author    eichi
 * @see       DbMarker
 * @generated
 */
public class DbMarkerWrapper implements DbMarker, ModelWrapper<DbMarker> {
	public DbMarkerWrapper(DbMarker dbMarker) {
		_dbMarker = dbMarker;
	}

	public Class<?> getModelClass() {
		return DbMarker.class;
	}

	public String getModelClassName() {
		return DbMarker.class.getName();
	}

	/**
	* Returns the primary key of this db marker.
	*
	* @return the primary key of this db marker
	*/
	public long getPrimaryKey() {
		return _dbMarker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this db marker.
	*
	* @param primaryKey the primary key of this db marker
	*/
	public void setPrimaryKey(long primaryKey) {
		_dbMarker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker ID of this db marker.
	*
	* @return the marker ID of this db marker
	*/
	public long getMarkerId() {
		return _dbMarker.getMarkerId();
	}

	/**
	* Sets the marker ID of this db marker.
	*
	* @param markerId the marker ID of this db marker
	*/
	public void setMarkerId(long markerId) {
		_dbMarker.setMarkerId(markerId);
	}

	/**
	* Returns the marker image name of this db marker.
	*
	* @return the marker image name of this db marker
	*/
	public String getMarkerImageName() {
		return _dbMarker.getMarkerImageName();
	}

	/**
	* Sets the marker image name of this db marker.
	*
	* @param markerImageName the marker image name of this db marker
	*/
	public void setMarkerImageName(String markerImageName) {
		_dbMarker.setMarkerImageName(markerImageName);
	}

	/**
	* Returns the point ID of this db marker.
	*
	* @return the point ID of this db marker
	*/
	public long getPointId() {
		return _dbMarker.getPointId();
	}

	/**
	* Sets the point ID of this db marker.
	*
	* @param pointId the point ID of this db marker
	*/
	public void setPointId(long pointId) {
		_dbMarker.setPointId(pointId);
	}

	public boolean isNew() {
		return _dbMarker.isNew();
	}

	public void setNew(boolean n) {
		_dbMarker.setNew(n);
	}

	public boolean isCachedModel() {
		return _dbMarker.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dbMarker.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dbMarker.isEscapedModel();
	}

	public Serializable getPrimaryKeyObj() {
		return _dbMarker.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dbMarker.setPrimaryKeyObj(primaryKeyObj);
	}

	public ExpandoBridge getExpandoBridge() {
		return _dbMarker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		ServiceContext serviceContext) {
		_dbMarker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		return new DbMarkerWrapper((DbMarker)_dbMarker.clone());
	}

	public int compareTo(DbMarker dbMarker) {
		return _dbMarker.compareTo(dbMarker);
	}

	@Override
	public int hashCode() {
		return _dbMarker.hashCode();
	}

	public CacheModel<DbMarker> toCacheModel() {
		return _dbMarker.toCacheModel();
	}

	public DbMarker toEscapedModel() {
		return new DbMarkerWrapper(_dbMarker.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dbMarker.toString();
	}

	public String toXmlString() {
		return _dbMarker.toXmlString();
	}

	public void persist()
		throws SystemException {
		_dbMarker.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DbMarker getWrappedDbMarker() {
		return _dbMarker;
	}

	public DbMarker getWrappedModel() {
		return _dbMarker;
	}

	public void resetOriginalValues() {
		_dbMarker.resetOriginalValues();
	}

	private DbMarker _dbMarker;
}