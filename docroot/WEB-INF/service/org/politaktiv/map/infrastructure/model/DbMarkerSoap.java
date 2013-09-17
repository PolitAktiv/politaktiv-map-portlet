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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.DbMarkerServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.DbMarkerServiceSoap
 * @generated
 */
public class DbMarkerSoap implements Serializable {
	public static DbMarkerSoap toSoapModel(DbMarker model) {
		DbMarkerSoap soapModel = new DbMarkerSoap();

		soapModel.setMarkerId(model.getMarkerId());
		soapModel.setMarkerImageName(model.getMarkerImageName());
		soapModel.setPointId(model.getPointId());

		return soapModel;
	}

	public static DbMarkerSoap[] toSoapModels(DbMarker[] models) {
		DbMarkerSoap[] soapModels = new DbMarkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DbMarkerSoap[][] toSoapModels(DbMarker[][] models) {
		DbMarkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DbMarkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DbMarkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DbMarkerSoap[] toSoapModels(List<DbMarker> models) {
		List<DbMarkerSoap> soapModels = new ArrayList<DbMarkerSoap>(models.size());

		for (DbMarker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DbMarkerSoap[soapModels.size()]);
	}

	public DbMarkerSoap() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long pk) {
		setMarkerId(pk);
	}

	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
	}

	public String getMarkerImageName() {
		return _markerImageName;
	}

	public void setMarkerImageName(String markerImageName) {
		_markerImageName = markerImageName;
	}

	public long getPointId() {
		return _pointId;
	}

	public void setPointId(long pointId) {
		_pointId = pointId;
	}

	private long _markerId;
	private String _markerImageName;
	private long _pointId;
}