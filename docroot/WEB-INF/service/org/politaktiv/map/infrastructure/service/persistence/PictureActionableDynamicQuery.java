/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.politaktiv.map.infrastructure.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;

/**
 * @author eichi
 * @generated
 */
public abstract class PictureActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PictureActionableDynamicQuery() throws SystemException {
		setBaseLocalService(PictureLocalServiceUtil.getService());
		setClass(Picture.class);

		setClassLoader(org.politaktiv.map.infrastructure.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("pictureId");
	}
}