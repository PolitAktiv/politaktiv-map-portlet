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
/**
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.politaktiv.map.infrastructure.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MarkerLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       MarkerLocalService
 * @generated
 */
public class MarkerLocalServiceWrapper implements MarkerLocalService,
	ServiceWrapper<MarkerLocalService> {
	public MarkerLocalServiceWrapper(MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	/**
	* Adds the marker to the database. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @return the marker that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Marker addMarker(
		org.politaktiv.map.infrastructure.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.addMarker(marker);
	}

	/**
	* Creates a new marker with the primary key. Does not add the marker to the database.
	*
	* @param markerId the primary key for the new marker
	* @return the new marker
	*/
	public org.politaktiv.map.infrastructure.model.Marker createMarker(
		long markerId) {
		return _markerLocalService.createMarker(markerId);
	}

	/**
	* Deletes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the marker
	* @throws PortalException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMarker(long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_markerLocalService.deleteMarker(markerId);
	}

	/**
	* Deletes the marker from the database. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMarker(
		org.politaktiv.map.infrastructure.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		_markerLocalService.deleteMarker(marker);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.politaktiv.map.infrastructure.model.Marker fetchMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.fetchMarker(markerId);
	}

	/**
	* Returns the marker with the primary key.
	*
	* @param markerId the primary key of the marker
	* @return the marker
	* @throws PortalException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Marker getMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarker(markerId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @return the range of markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Marker> getMarkers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarkers(start, end);
	}

	/**
	* Returns the number of markers.
	*
	* @return the number of markers
	* @throws SystemException if a system exception occurred
	*/
	public int getMarkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarkersCount();
	}

	/**
	* Updates the marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @return the marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Marker updateMarker(
		org.politaktiv.map.infrastructure.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.updateMarker(marker);
	}

	/**
	* Updates the marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @param merge whether to merge the marker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Marker updateMarker(
		org.politaktiv.map.infrastructure.model.Marker marker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.updateMarker(marker, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _markerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_markerLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<org.politaktiv.map.infrastructure.model.Marker> findMarkerByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.findMarkerByBackgroundId(backgroundId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MarkerLocalService getWrappedMarkerLocalService() {
		return _markerLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMarkerLocalService(
		MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	public MarkerLocalService getWrappedService() {
		return _markerLocalService;
	}

	public void setWrappedService(MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	private MarkerLocalService _markerLocalService;
}