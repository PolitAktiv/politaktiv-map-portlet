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

package org.politaktiv.map.infrastructure.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.politaktiv.map.infrastructure.model.Marker;

import java.io.Serializable;


/**
 * The cache model class for representing Marker in entity cache.
 *
 * @author eichi
 * @see Marker
 * @generated
 */
public class MarkerCacheModel implements CacheModel<Marker>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{markerId=");
		sb.append(markerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", referenceUrl=");
		sb.append(referenceUrl);
		sb.append(", backgroundId=");
		sb.append(backgroundId);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	public Marker toEntityModel() {
		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setMarkerId(markerId);
		markerImpl.setCompanyId(companyId);
		markerImpl.setGroupId(groupId);
		markerImpl.setUserId(userId);

		if (name == null) {
			markerImpl.setName(StringPool.BLANK);
		}
		else {
			markerImpl.setName(name);
		}

		if (description == null) {
			markerImpl.setDescription(StringPool.BLANK);
		}
		else {
			markerImpl.setDescription(description);
		}

		if (referenceUrl == null) {
			markerImpl.setReferenceUrl(StringPool.BLANK);
		}
		else {
			markerImpl.setReferenceUrl(referenceUrl);
		}

		markerImpl.setBackgroundId(backgroundId);
		markerImpl.setLongitude(longitude);
		markerImpl.setLatitude(latitude);

		markerImpl.resetOriginalValues();

		return markerImpl;
	}

	public long markerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String description;
	public String referenceUrl;
	public long backgroundId;
	public double longitude;
	public double latitude;
}