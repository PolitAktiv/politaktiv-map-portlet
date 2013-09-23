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

import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelWrapper;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

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
	public String getUserUuid()
		throws SystemException {
		return _marker.getUserUuid();
	}

	/**
	* Sets the user uuid of this marker.
	*
	* @param userUuid the user uuid of this marker
	*/
	public void setUserUuid(String userUuid) {
		_marker.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this marker.
	*
	* @return the name of this marker
	*/
	public String getName() {
		return _marker.getName();
	}

	/**
	* Sets the name of this marker.
	*
	* @param name the name of this marker
	*/
	public void setName(String name) {
		_marker.setName(name);
	}

	/**
	* Returns the description of this marker.
	*
	* @return the description of this marker
	*/
	public String getDescription() {
		return _marker.getDescription();
	}

	/**
	* Sets the description of this marker.
	*
	* @param description the description of this marker
	*/
	public void setDescription(String description) {
		_marker.setDescription(description);
	}

	/**
	* Returns the reference url of this marker.
	*
	* @return the reference url of this marker
	*/
	public String getReferenceUrl() {
		return _marker.getReferenceUrl();
	}

	/**
	* Sets the reference url of this marker.
	*
	* @param referenceUrl the reference url of this marker
	*/
	public void setReferenceUrl(String referenceUrl) {
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

	public Serializable getPrimaryKeyObj() {
		return _marker.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_marker.setPrimaryKeyObj(primaryKeyObj);
	}

	public ExpandoBridge getExpandoBridge() {
		return _marker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		ServiceContext serviceContext) {
		_marker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		return new MarkerWrapper((Marker)_marker.clone());
	}

	public int compareTo(Marker marker) {
		return _marker.compareTo(marker);
	}

	@Override
	public int hashCode() {
		return _marker.hashCode();
	}

	public CacheModel<Marker> toCacheModel() {
		return _marker.toCacheModel();
	}

	public Marker toEscapedModel() {
		return new MarkerWrapper(_marker.toEscapedModel());
	}

	@Override
	public String toString() {
		return _marker.toString();
	}

	public String toXmlString() {
		return _marker.toXmlString();
	}

	public void persist()
		throws SystemException {
		_marker.persist();
	}

	public void validate() throws ValidatorException {
		_marker.validate();
	}

	public String toHTMLFormatedString()
		throws PortalException,
			SystemException {
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