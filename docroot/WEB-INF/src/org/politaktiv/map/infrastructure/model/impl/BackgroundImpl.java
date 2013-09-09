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

package org.politaktiv.map.infrastructure.model.impl;

import org.politaktiv.map.domain.ObjectWithPictureUrl;

import com.liferay.portal.kernel.bean.AutoEscape;


/**
 * The extended model implementation for the Background service. Represents a row in the &quot;politaktivmap_Background&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.model.Background} interface.
 * </p>
 *
 * @author eichi
 */
public class BackgroundImpl extends BackgroundBaseImpl implements ObjectWithPictureUrl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a background model instance should use the {@link org.politaktiv.map.infrastructure.model.Background} interface instead.
	 */
	public BackgroundImpl() {
	}


	@Override
	public String getPictureUrl() {
		
		if(this.getFileEntryUuid().equals("map")){
			return "map";
		}
		
		String url = "";
		url += "/c/document_library/get_file?uuid=";
		url += this.getFileEntryUuid();
		url += "&groupId=";
		url += this.getGroupId();
		
		return url;
	}

	@Override
	public boolean isMap() {
		return this.getFileEntryUuid().equals("map");
	}
}