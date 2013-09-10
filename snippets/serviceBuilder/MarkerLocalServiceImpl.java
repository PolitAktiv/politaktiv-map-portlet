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

package com.politaktiv.map.infrastructure.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.politaktiv.map.infrastructure.model.Marker;
import com.politaktiv.map.infrastructure.service.base.MarkerLocalServiceBaseImpl;
import com.politaktiv.map.infrastructure.service.persistence.MarkerUtil;

/**
 * The implementation of the marker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.politaktiv.map.infrastructure.service.MarkerLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil} to access the marker local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see com.politaktiv.map.infrastructure.service.base.MarkerLocalServiceBaseImpl
 * @see com.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil
 */
public class MarkerLocalServiceImpl extends MarkerLocalServiceBaseImpl {

	public List<Marker> findMarkersByGroupId(long groupId) throws SystemException{
		return MarkerUtil.findBygroupId(groupId);
	}
}