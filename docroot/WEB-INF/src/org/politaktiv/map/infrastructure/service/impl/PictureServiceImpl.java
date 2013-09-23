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

package org.politaktiv.map.infrastructure.service.impl;

import java.util.List;

import javax.portlet.ValidatorException;

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil;
import org.politaktiv.map.infrastructure.service.PictureServiceUtil;
import org.politaktiv.map.infrastructure.service.base.PictureServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the picture remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.PictureService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.PictureServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.PictureServiceUtil
 */
public class PictureServiceImpl extends PictureServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.PictureServiceUtil} to access the picture remote service.
	 */
	private static Log _log = LogFactoryUtil.getLog(PictureServiceUtil.class);
	
	public Picture addPicture(Picture picture, long groupId) throws PrincipalException, SystemException, ValidatorException{
		
		if(!getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Picture", groupId, "ADD")){
			_log.error("user has no permission to add marker");
			throw new PrincipalException();
		}
		
		
		picture.validate();
		
		return PictureLocalServiceUtil.addPicture(picture);
	}
	
	
	public List<Picture> findByBackgroundId(long backgroundId) throws SystemException{
		
		return PictureLocalServiceUtil.findByBackgroundId(backgroundId);

	}
	
	public void deletePicture(long deletePictureId, long userId, long groupId, String portletId) throws PortalException, SystemException{
		
		if(!((PictureLocalServiceUtil.getPicture(deletePictureId).getUserId() == userId) //is owner
				|| getPermissionChecker().hasPermission(groupId, portletId, groupId, "CONFIGURATION")) // is admin oder moderator
					|| !getPermissionChecker().hasPermission(groupId, "org.politaktiv.map.infrastructure.model.Picture", groupId, "DELETE")){
			_log.error("user has no permission to delete picture");
			throw new PrincipalException();
		}
		PictureLocalServiceUtil.deletePicture(deletePictureId);
	}
}