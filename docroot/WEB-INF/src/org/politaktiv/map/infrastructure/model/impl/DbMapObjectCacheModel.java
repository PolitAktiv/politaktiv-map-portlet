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

import org.politaktiv.map.infrastructure.model.DbMapObject;

import java.io.Serializable;

/**
 * The cache model class for representing DbMapObject in entity cache.
 *
 * @author eichi
 * @see DbMapObject
 * @generated
 */
public class DbMapObjectCacheModel implements CacheModel<DbMapObject>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mapObjectId=");
		sb.append(mapObjectId);
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
		sb.append(", occupancy=");
		sb.append(occupancy);
		sb.append(", mapId=");
		sb.append(mapId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", graphicObjectId=");
		sb.append(graphicObjectId);
		sb.append("}");

		return sb.toString();
	}

	public DbMapObject toEntityModel() {
		DbMapObjectImpl dbMapObjectImpl = new DbMapObjectImpl();

		dbMapObjectImpl.setMapObjectId(mapObjectId);
		dbMapObjectImpl.setCompanyId(companyId);
		dbMapObjectImpl.setGroupId(groupId);
		dbMapObjectImpl.setUserId(userId);

		if (name == null) {
			dbMapObjectImpl.setName(StringPool.BLANK);
		}
		else {
			dbMapObjectImpl.setName(name);
		}

		if (description == null) {
			dbMapObjectImpl.setDescription(StringPool.BLANK);
		}
		else {
			dbMapObjectImpl.setDescription(description);
		}

		if (referenceUrl == null) {
			dbMapObjectImpl.setReferenceUrl(StringPool.BLANK);
		}
		else {
			dbMapObjectImpl.setReferenceUrl(referenceUrl);
		}

		dbMapObjectImpl.setOccupancy(occupancy);
		dbMapObjectImpl.setMapId(mapId);

		if (type == null) {
			dbMapObjectImpl.setType(StringPool.BLANK);
		}
		else {
			dbMapObjectImpl.setType(type);
		}

		dbMapObjectImpl.setGraphicObjectId(graphicObjectId);

		dbMapObjectImpl.resetOriginalValues();

		return dbMapObjectImpl;
	}

	public long mapObjectId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String description;
	public String referenceUrl;
	public long occupancy;
	public long mapId;
	public String type;
	public long graphicObjectId;
}