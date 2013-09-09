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

package org.politaktiv.map.infrastructure.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Picture service. Represents a row in the &quot;politaktivmap_Picture&quot; database table, with each column mapped to a property of this class.
 *
 * @author eichi
 * @see PictureModel
 * @see org.politaktiv.map.infrastructure.model.impl.PictureImpl
 * @see org.politaktiv.map.infrastructure.model.impl.PictureModelImpl
 * @generated
 */
public interface Picture extends PictureModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.politaktiv.map.infrastructure.model.impl.PictureImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getPictureUrl();

	public void validate()
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException;
}