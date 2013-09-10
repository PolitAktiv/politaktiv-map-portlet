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

package org.politaktiv.map.infrastructure.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.PictureServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.PictureServiceSoap
 * @generated
 */
public class PictureSoap implements Serializable {
	public static PictureSoap toSoapModel(Picture model) {
		PictureSoap soapModel = new PictureSoap();

		soapModel.setPictureId(model.getPictureId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setReferenceUrl(model.getReferenceUrl());
		soapModel.setBackgroundId(model.getBackgroundId());
		soapModel.setRotation(model.getRotation());
		soapModel.setWidth(model.getWidth());
		soapModel.setHeight(model.getHeight());
		soapModel.setResolution(model.getResolution());
		soapModel.setOcupacy(model.getOcupacy());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setFileEntryUuid(model.getFileEntryUuid());

		return soapModel;
	}

	public static PictureSoap[] toSoapModels(Picture[] models) {
		PictureSoap[] soapModels = new PictureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PictureSoap[][] toSoapModels(Picture[][] models) {
		PictureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PictureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PictureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PictureSoap[] toSoapModels(List<Picture> models) {
		List<PictureSoap> soapModels = new ArrayList<PictureSoap>(models.size());

		for (Picture model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PictureSoap[soapModels.size()]);
	}

	public PictureSoap() {
	}

	public long getPrimaryKey() {
		return _pictureId;
	}

	public void setPrimaryKey(long pk) {
		setPictureId(pk);
	}

	public long getPictureId() {
		return _pictureId;
	}

	public void setPictureId(long pictureId) {
		_pictureId = pictureId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getReferenceUrl() {
		return _referenceUrl;
	}

	public void setReferenceUrl(String referenceUrl) {
		_referenceUrl = referenceUrl;
	}

	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;
	}

	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	public double getWidth() {
		return _width;
	}

	public void setWidth(double width) {
		_width = width;
	}

	public double getHeight() {
		return _height;
	}

	public void setHeight(double height) {
		_height = height;
	}

	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
	}

	public double getOcupacy() {
		return _ocupacy;
	}

	public void setOcupacy(double ocupacy) {
		_ocupacy = ocupacy;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public String getFileEntryUuid() {
		return _fileEntryUuid;
	}

	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;
	}

	private long _pictureId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private long _rotation;
	private double _width;
	private double _height;
	private double _resolution;
	private double _ocupacy;
	private double _longitude;
	private double _latitude;
	private String _fileEntryUuid;
}