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

import org.politaktiv.map.infrastructure.model.DbPicture;

import java.io.Serializable;

/**
 * The cache model class for representing DbPicture in entity cache.
 *
 * @author eichi
 * @see DbPicture
 * @generated
 */
public class DbPictureCacheModel implements CacheModel<DbPicture>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{pictureId=");
		sb.append(pictureId);
		sb.append(", rotation=");
		sb.append(rotation);
		sb.append(", width=");
		sb.append(width);
		sb.append(", height=");
		sb.append(height);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", pointId=");
		sb.append(pointId);
		sb.append("}");

		return sb.toString();
	}

	public DbPicture toEntityModel() {
		DbPictureImpl dbPictureImpl = new DbPictureImpl();

		dbPictureImpl.setPictureId(pictureId);
		dbPictureImpl.setRotation(rotation);
		dbPictureImpl.setWidth(width);
		dbPictureImpl.setHeight(height);
		dbPictureImpl.setResolution(resolution);
		dbPictureImpl.setPointId(pointId);

		dbPictureImpl.resetOriginalValues();

		return dbPictureImpl;
	}

	public long pictureId;
	public long rotation;
	public long width;
	public long height;
	public double resolution;
	public long pointId;
}