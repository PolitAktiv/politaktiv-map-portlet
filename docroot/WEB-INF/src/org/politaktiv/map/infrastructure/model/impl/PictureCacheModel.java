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

import org.politaktiv.map.infrastructure.model.Picture;

import java.io.Serializable;

/**
 * The cache model class for representing Picture in entity cache.
 *
 * @author eichi
 * @see Picture
 * @generated
 */
public class PictureCacheModel implements CacheModel<Picture>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{pictureId=");
		sb.append(pictureId);
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
		sb.append(", rotation=");
		sb.append(rotation);
		sb.append(", width=");
		sb.append(width);
		sb.append(", height=");
		sb.append(height);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", ocupacy=");
		sb.append(ocupacy);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", fileEntryUuid=");
		sb.append(fileEntryUuid);
		sb.append("}");

		return sb.toString();
	}

	public Picture toEntityModel() {
		PictureImpl pictureImpl = new PictureImpl();

		pictureImpl.setPictureId(pictureId);
		pictureImpl.setCompanyId(companyId);
		pictureImpl.setGroupId(groupId);
		pictureImpl.setUserId(userId);

		if (name == null) {
			pictureImpl.setName(StringPool.BLANK);
		}
		else {
			pictureImpl.setName(name);
		}

		if (description == null) {
			pictureImpl.setDescription(StringPool.BLANK);
		}
		else {
			pictureImpl.setDescription(description);
		}

		if (referenceUrl == null) {
			pictureImpl.setReferenceUrl(StringPool.BLANK);
		}
		else {
			pictureImpl.setReferenceUrl(referenceUrl);
		}

		pictureImpl.setBackgroundId(backgroundId);
		pictureImpl.setRotation(rotation);
		pictureImpl.setWidth(width);
		pictureImpl.setHeight(height);
		pictureImpl.setResolution(resolution);
		pictureImpl.setOcupacy(ocupacy);
		pictureImpl.setLongitude(longitude);
		pictureImpl.setLatitude(latitude);

		if (fileEntryUuid == null) {
			pictureImpl.setFileEntryUuid(StringPool.BLANK);
		}
		else {
			pictureImpl.setFileEntryUuid(fileEntryUuid);
		}

		pictureImpl.resetOriginalValues();

		return pictureImpl;
	}

	public long pictureId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String description;
	public String referenceUrl;
	public long backgroundId;
	public long rotation;
	public double width;
	public double height;
	public double resolution;
	public double ocupacy;
	public double longitude;
	public double latitude;
	public String fileEntryUuid;
}