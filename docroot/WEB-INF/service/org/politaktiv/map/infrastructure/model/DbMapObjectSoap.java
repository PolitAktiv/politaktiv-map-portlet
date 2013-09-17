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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.DbMapObjectServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.DbMapObjectServiceSoap
 * @generated
 */
public class DbMapObjectSoap implements Serializable {
	public static DbMapObjectSoap toSoapModel(DbMapObject model) {
		DbMapObjectSoap soapModel = new DbMapObjectSoap();

		soapModel.setMapObjectId(model.getMapObjectId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setReferenceUrl(model.getReferenceUrl());
		soapModel.setOccupancy(model.getOccupancy());
		soapModel.setMapId(model.getMapId());
		soapModel.setType(model.getType());
		soapModel.setGraphicObjectId(model.getGraphicObjectId());

		return soapModel;
	}

	public static DbMapObjectSoap[] toSoapModels(DbMapObject[] models) {
		DbMapObjectSoap[] soapModels = new DbMapObjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DbMapObjectSoap[][] toSoapModels(DbMapObject[][] models) {
		DbMapObjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DbMapObjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DbMapObjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DbMapObjectSoap[] toSoapModels(List<DbMapObject> models) {
		List<DbMapObjectSoap> soapModels = new ArrayList<DbMapObjectSoap>(models.size());

		for (DbMapObject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DbMapObjectSoap[soapModels.size()]);
	}

	public DbMapObjectSoap() {
	}

	public long getPrimaryKey() {
		return _mapObjectId;
	}

	public void setPrimaryKey(long pk) {
		setMapObjectId(pk);
	}

	public long getMapObjectId() {
		return _mapObjectId;
	}

	public void setMapObjectId(long mapObjectId) {
		_mapObjectId = mapObjectId;
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

	public long getOccupancy() {
		return _occupancy;
	}

	public void setOccupancy(long occupancy) {
		_occupancy = occupancy;
	}

	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getGraphicObjectId() {
		return _graphicObjectId;
	}

	public void setGraphicObjectId(long graphicObjectId) {
		_graphicObjectId = graphicObjectId;
	}

	private long _mapObjectId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _occupancy;
	private long _mapId;
	private String _type;
	private long _graphicObjectId;
}