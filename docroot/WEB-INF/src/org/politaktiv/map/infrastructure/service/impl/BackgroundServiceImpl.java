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

import java.util.List;

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.base.BackgroundServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the background remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.BackgroundService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.BackgroundServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.BackgroundServiceUtil
 */
public class BackgroundServiceImpl extends BackgroundServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.BackgroundServiceUtil} to access the background remote service.
	 */
	private static Log _log = LogFactoryUtil.getLog(org.politaktiv.map.infrastructure.service.BackgroundServiceUtil.class);
	
	public List<Background> findBycompanyIdAndGroupId(long companyId, long groupId) throws SystemException {
		return BackgroundLocalServiceUtil.findBycompanyIdAndGroupId(companyId, groupId);
	}
	
	public Background addBackground(Background background, long groupId) throws SystemException, PrincipalException{
		
		//TODO remove false
		if(false && !getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Background", background.getBackgroundId(), "ADD")){
			_log.error("user has no permission to add background with id " + background.getBackgroundId());
			throw new PrincipalException();
		}
		return BackgroundLocalServiceUtil.addBackground(background);
	}
	
	public void deleteBackground(long backgroundId, long groupId) throws SystemException, PortalException{
		if(!getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Background", backgroundId, "DELETE")){
			_log.error("user has no permission to remove background with id " + backgroundId);
			throw new PrincipalException();
		}
		
		BackgroundLocalServiceUtil.deleteBackground(backgroundId);
	}
}