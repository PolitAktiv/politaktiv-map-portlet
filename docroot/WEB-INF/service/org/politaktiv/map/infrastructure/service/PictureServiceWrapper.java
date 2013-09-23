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

package org.politaktiv.map.infrastructure.service;

import java.util.List;

import org.politaktiv.map.infrastructure.model.Picture;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PictureService}.
 * </p>
 *
 * @author    eichi
 * @see       PictureService
 * @generated
 */
public class PictureServiceWrapper implements PictureService,
	ServiceWrapper<PictureService> {
	public PictureServiceWrapper(PictureService pictureService) {
		_pictureService = pictureService;
	}

	public Picture addPicture(
		Picture picture, long groupId)
		throws SystemException,
			PrincipalException,
			javax.portlet.ValidatorException {
		return _pictureService.addPicture(picture, groupId);
	}

	public List<Picture> findByBackgroundId(
		long backgroundId)
		throws SystemException {
		return _pictureService.findByBackgroundId(backgroundId);
	}

	public void deletePicture(long deletePictureId, long userId, long groupId,
		String portletId)
		throws PortalException,
			SystemException {
		_pictureService.deletePicture(deletePictureId, userId, groupId,
			portletId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PictureService getWrappedPictureService() {
		return _pictureService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPictureService(PictureService pictureService) {
		_pictureService = pictureService;
	}

	public PictureService getWrappedService() {
		return _pictureService;
	}

	public void setWrappedService(PictureService pictureService) {
		_pictureService = pictureService;
	}

	private PictureService _pictureService;
}