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

import org.politaktiv.map.infrastructure.model.DbMarker;

import java.io.Serializable;

/**
 * The cache model class for representing DbMarker in entity cache.
 *
 * @author eichi
 * @see DbMarker
 * @generated
 */
public class DbMarkerCacheModel implements CacheModel<DbMarker>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{markerId=");
		sb.append(markerId);
		sb.append(", markerImageName=");
		sb.append(markerImageName);
		sb.append(", pointId=");
		sb.append(pointId);
		sb.append("}");

		return sb.toString();
	}

	public DbMarker toEntityModel() {
		DbMarkerImpl dbMarkerImpl = new DbMarkerImpl();

		dbMarkerImpl.setMarkerId(markerId);

		if (markerImageName == null) {
			dbMarkerImpl.setMarkerImageName(StringPool.BLANK);
		}
		else {
			dbMarkerImpl.setMarkerImageName(markerImageName);
		}

		dbMarkerImpl.setPointId(pointId);

		dbMarkerImpl.resetOriginalValues();

		return dbMarkerImpl;
	}

	public long markerId;
	public String markerImageName;
	public long pointId;
}