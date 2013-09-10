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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.infrastructure.service.http.BackgroundServiceSoap}.
 *
 * @author    eichi
 * @see       org.politaktiv.map.infrastructure.service.http.BackgroundServiceSoap
 * @generated
 */
public class BackgroundSoap implements Serializable {
	public static BackgroundSoap toSoapModel(Background model) {
		BackgroundSoap soapModel = new BackgroundSoap();

		soapModel.setBackgroundId(model.getBackgroundId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setFileEntryUuid(model.getFileEntryUuid());

		return soapModel;
	}

	public static BackgroundSoap[] toSoapModels(Background[] models) {
		BackgroundSoap[] soapModels = new BackgroundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BackgroundSoap[][] toSoapModels(Background[][] models) {
		BackgroundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BackgroundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BackgroundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BackgroundSoap[] toSoapModels(List<Background> models) {
		List<BackgroundSoap> soapModels = new ArrayList<BackgroundSoap>(models.size());

		for (Background model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BackgroundSoap[soapModels.size()]);
	}

	public BackgroundSoap() {
	}

	public long getPrimaryKey() {
		return _backgroundId;
	}

	public void setPrimaryKey(long pk) {
		setBackgroundId(pk);
	}

	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;
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

	public String getFileEntryUuid() {
		return _fileEntryUuid;
	}

	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;
	}

	private long _backgroundId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _name;
	private String _fileEntryUuid;
}