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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.DbPointServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.DbPointServiceSoap
 * @generated
 */
public class DbPointSoap implements Serializable {
	public static DbPointSoap toSoapModel(DbPoint model) {
		DbPointSoap soapModel = new DbPointSoap();

		soapModel.setPointId(model.getPointId());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());

		return soapModel;
	}

	public static DbPointSoap[] toSoapModels(DbPoint[] models) {
		DbPointSoap[] soapModels = new DbPointSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DbPointSoap[][] toSoapModels(DbPoint[][] models) {
		DbPointSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DbPointSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DbPointSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DbPointSoap[] toSoapModels(List<DbPoint> models) {
		List<DbPointSoap> soapModels = new ArrayList<DbPointSoap>(models.size());

		for (DbPoint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DbPointSoap[soapModels.size()]);
	}

	public DbPointSoap() {
	}

	public long getPrimaryKey() {
		return _pointId;
	}

	public void setPrimaryKey(long pk) {
		setPointId(pk);
	}

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
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

	private long _pointId;
	private double _longitude;
	private double _latitude;
}