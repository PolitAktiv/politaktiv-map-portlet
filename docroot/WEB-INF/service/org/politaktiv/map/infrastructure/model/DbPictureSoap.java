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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.DbPictureServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.DbPictureServiceSoap
 * @generated
 */
public class DbPictureSoap implements Serializable {
	public static DbPictureSoap toSoapModel(DbPicture model) {
		DbPictureSoap soapModel = new DbPictureSoap();

		soapModel.setPictureId(model.getPictureId());
		soapModel.setRotation(model.getRotation());
		soapModel.setWidth(model.getWidth());
		soapModel.setHeight(model.getHeight());
		soapModel.setResolution(model.getResolution());
		soapModel.setPointId(model.getPointId());

		return soapModel;
	}

	public static DbPictureSoap[] toSoapModels(DbPicture[] models) {
		DbPictureSoap[] soapModels = new DbPictureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DbPictureSoap[][] toSoapModels(DbPicture[][] models) {
		DbPictureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DbPictureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DbPictureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DbPictureSoap[] toSoapModels(List<DbPicture> models) {
		List<DbPictureSoap> soapModels = new ArrayList<DbPictureSoap>(models.size());

		for (DbPicture model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DbPictureSoap[soapModels.size()]);
	}

	public DbPictureSoap() {
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

	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	public long getWidth() {
		return _width;
	}

	public void setWidth(long width) {
		_width = width;
	}

	public long getHeight() {
		return _height;
	}

	public void setHeight(long height) {
		_height = height;
	}

	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
	}

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	private long _pictureId;
	private long _rotation;
	private long _width;
	private long _height;
	private double _resolution;
	private long _pointId;
}