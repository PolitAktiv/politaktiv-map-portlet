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

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.service.base.BackgroundLocalServiceBaseImpl;
import org.politaktiv.map.infrastructure.service.persistence.BackgroundUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the background local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.infrastructure.service.BackgroundLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.base.BackgroundLocalServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil
 */
public class BackgroundLocalServiceImpl extends BackgroundLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.infrastructure.service.BackgroundLocalServiceUtil} to access the background local service.
	 */
	public List<Background> findBycompanyIdAndGroupId(long companyId, long groupId) throws SystemException{
		return BackgroundUtil.findBycompanyIdAndGroupId(companyId, groupId);
		
	}
}