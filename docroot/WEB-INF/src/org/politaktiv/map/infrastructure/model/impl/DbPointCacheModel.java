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
import com.liferay.portal.model.CacheModel;

import org.politaktiv.map.infrastructure.model.DbPoint;

import java.io.Serializable;

/**
 * The cache model class for representing DbPoint in entity cache.
 *
 * @author eichi
 * @see DbPoint
 * @generated
 */
public class DbPointCacheModel implements CacheModel<DbPoint>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{pointId=");
		sb.append(pointId);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	public DbPoint toEntityModel() {
		DbPointImpl dbPointImpl = new DbPointImpl();

		dbPointImpl.setPointId(pointId);
		dbPointImpl.setLongitude(longitude);
		dbPointImpl.setLatitude(latitude);

		dbPointImpl.resetOriginalValues();

		return dbPointImpl;
	}

	public long pointId;
	public double longitude;
	public double latitude;
}