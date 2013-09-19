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
 * This class is a wrapper for {@link DbPoint}.
 * </p>
 *
 * @author    eichi
 * @see       DbPoint
 * @generated
 */
public class DbPointWrapper implements DbPoint, ModelWrapper<DbPoint> {
	public DbPointWrapper(DbPoint dbPoint) {
		_dbPoint = dbPoint;
	}

	public Class<?> getModelClass() {
		return DbPoint.class;
	}

	public String getModelClassName() {
		return DbPoint.class.getName();
	}

	/**
	* Returns the primary key of this db point.
	*
	* @return the primary key of this db point
	*/
	public long getPrimaryKey() {
		return _dbPoint.getPrimaryKey();
	}

	/**
	* Sets the primary key of this db point.
	*
	* @param primaryKey the primary key of this db point
	*/
	public void setPrimaryKey(long primaryKey) {
		_dbPoint.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the point ID of this db point.
	*
	* @return the point ID of this db point
	*/
	public long getPointId() {
		return _dbPoint.getPointId();
	}

	/**
	* Sets the point ID of this db point.
	*
	* @param pointId the point ID of this db point
	*/
	public void setPointId(long pointId) {
		_dbPoint.setPointId(pointId);
	}

	/**
	* Returns the longitude of this db point.
	*
	* @return the longitude of this db point
	*/
	public double getLongitude() {
		return _dbPoint.getLongitude();
	}

	/**
	* Sets the longitude of this db point.
	*
	* @param longitude the longitude of this db point
	*/
	public void setLongitude(double longitude) {
		_dbPoint.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this db point.
	*
	* @return the latitude of this db point
	*/
	public double getLatitude() {
		return _dbPoint.getLatitude();
	}

	/**
	* Sets the latitude of this db point.
	*
	* @param latitude the latitude of this db point
	*/
	public void setLatitude(double latitude) {
		_dbPoint.setLatitude(latitude);
	}

	public boolean isNew() {
		return _dbPoint.isNew();
	}

	public void setNew(boolean n) {
		_dbPoint.setNew(n);
	}

	public boolean isCachedModel() {
		return _dbPoint.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dbPoint.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dbPoint.isEscapedModel();
	}

	public Serializable getPrimaryKeyObj() {
		return _dbPoint.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dbPoint.setPrimaryKeyObj(primaryKeyObj);
	}

	public ExpandoBridge getExpandoBridge() {
		return _dbPoint.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		ServiceContext serviceContext) {
		_dbPoint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		return new DbPointWrapper((DbPoint)_dbPoint.clone());
	}

	public int compareTo(DbPoint dbPoint) {
		return _dbPoint.compareTo(dbPoint);
	}

	@Override
	public int hashCode() {
		return _dbPoint.hashCode();
	}

	public CacheModel<DbPoint> toCacheModel() {
		return _dbPoint.toCacheModel();
	}

	public DbPoint toEscapedModel() {
		return new DbPointWrapper(_dbPoint.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dbPoint.toString();
	}

	public String toXmlString() {
		return _dbPoint.toXmlString();
	}

	public void persist()
		throws SystemException {
		_dbPoint.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DbPoint getWrappedDbPoint() {
		return _dbPoint;
	}

	public DbPoint getWrappedModel() {
		return _dbPoint;
	}

	public void resetOriginalValues() {
		_dbPoint.resetOriginalValues();
	}

	private DbPoint _dbPoint;
}