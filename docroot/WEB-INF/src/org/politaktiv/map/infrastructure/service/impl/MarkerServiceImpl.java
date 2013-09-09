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
package org.politaktiv.map.infrastructure.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ValidatorException;

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.base.MarkerServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the marker remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.MarkerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.MarkerServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.MarkerServiceUtil
 */
public class MarkerServiceImpl extends MarkerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.MarkerServiceUtil} to access the marker remote service.
	 */
	private static Log _log = LogFactoryUtil.getLog(org.politaktiv.map.infrastructure.service.MarkerServiceUtil.class);
	
	public Marker addMarker(Marker marker, long groupId) throws SystemException, PrincipalException, ValidatorException{
		
		if(!getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Marker", groupId, "ADD")){
			_log.error("user has no permission to add marker");
			throw new PrincipalException();
		}
		
		marker.validate();
		
		return MarkerLocalServiceUtil.addMarker(marker);
	}
	
	public List<Marker> findMarkerByBackgroundId(long backgroundId) throws SystemException{
		
			return MarkerLocalServiceUtil.findMarkerByBackgroundId(backgroundId);

	}
	
	public void deleteMarker(long markerId, long userId, long groupId, String portletId) throws SystemException, ValidatorException, PortalException{
		
		if(!((MarkerLocalServiceUtil.getMarker(markerId).getUserId() == userId) //is owner
				|| getPermissionChecker().hasPermission(groupId, portletId, groupId, "CONFIGURATION")) // is admin oder moderator
					|| !getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Marker", groupId, "DELETE")){
			_log.error("user has no permission to delete marker");
			throw new PrincipalException();
		}
		
		MarkerLocalServiceUtil.deleteMarker(markerId);
	}
}