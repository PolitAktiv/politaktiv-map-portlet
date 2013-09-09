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

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.service.base.MarkerLocalServiceBaseImpl;
import org.politaktiv.map.infrastructure.service.persistence.MarkerUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the marker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.MarkerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.MarkerLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil
 */
public class MarkerLocalServiceImpl extends MarkerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil} to access the marker local service.
	 */
	
	public List<Marker> findMarkerByBackgroundId(long backgroundId) throws SystemException{
		
		return MarkerUtil.findBybackgroundId(backgroundId);
	}
}