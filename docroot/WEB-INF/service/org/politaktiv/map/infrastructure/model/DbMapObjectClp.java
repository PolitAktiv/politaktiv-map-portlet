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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.politaktiv.map.infrastructure.service.DbMapObjectLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author eichi
 */
public class DbMapObjectClp extends BaseModelImpl<DbMapObject>
	implements DbMapObject {
	public DbMapObjectClp() {
	}

	public Class<?> getModelClass() {
		return DbMapObject.class;
	}

	public String getModelClassName() {
		return DbMapObject.class.getName();
	}

	public long getPrimaryKey() {
		return _mapObjectId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMapObjectId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mapObjectId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			DbMapObjectLocalServiceUtil.addDbMapObject(this);
		}
		else {
			DbMapObjectLocalServiceUtil.updateDbMapObject(this);
		}
	}

	@Override
	public DbMapObject toEscapedModel() {
		return (DbMapObject)Proxy.newProxyInstance(DbMapObject.class.getClassLoader(),
			new Class[] { DbMapObject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DbMapObjectClp clone = new DbMapObjectClp();

		clone.setMapObjectId(getMapObjectId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setReferenceUrl(getReferenceUrl());
		clone.setOccupancy(getOccupancy());
		clone.setMapId(getMapId());
		clone.setType(getType());
		clone.setGraphicObjectId(getGraphicObjectId());

		return clone;
	}

	public int compareTo(DbMapObject dbMapObject) {
		long primaryKey = dbMapObject.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DbMapObjectClp dbMapObject = null;

		try {
			dbMapObject = (DbMapObjectClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dbMapObject.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mapObjectId=");
		sb.append(getMapObjectId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", referenceUrl=");
		sb.append(getReferenceUrl());
		sb.append(", occupancy=");
		sb.append(getOccupancy());
		sb.append(", mapId=");
		sb.append(getMapId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", graphicObjectId=");
		sb.append(getGraphicObjectId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.DbMapObject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mapObjectId</column-name><column-value><![CDATA[");
		sb.append(getMapObjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceUrl</column-name><column-value><![CDATA[");
		sb.append(getReferenceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>occupancy</column-name><column-value><![CDATA[");
		sb.append(getOccupancy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapId</column-name><column-value><![CDATA[");
		sb.append(getMapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graphicObjectId</column-name><column-value><![CDATA[");
		sb.append(getGraphicObjectId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mapObjectId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _occupancy;
	private long _mapId;
	private String _type;
	private long _graphicObjectId;
}