/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cmcti.cmts.domain.model;

import com.cmcti.cmts.domain.service.ClpSerializer;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author richard
 */
public class CmtsClp extends BaseModelImpl<Cmts> implements Cmts {
	public CmtsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cmts.class;
	}

	@Override
	public String getModelClassName() {
		return Cmts.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cmtsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCmtsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cmtsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cmtsId", getCmtsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("enable", getEnable());
		attributes.put("title", getTitle());
		attributes.put("host", getHost());
		attributes.put("community", getCommunity());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean enable = (Boolean)attributes.get("enable");

		if (enable != null) {
			setEnable(enable);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String host = (String)attributes.get("host");

		if (host != null) {
			setHost(host);
		}

		String community = (String)attributes.get("community");

		if (community != null) {
			setCommunity(community);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setCmtsId", long.class);

				method.invoke(_cmtsRemoteModel, cmtsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_cmtsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_cmtsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_cmtsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_cmtsRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cmtsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_cmtsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnable() {
		return _enable;
	}

	@Override
	public boolean isEnable() {
		return _enable;
	}

	@Override
	public void setEnable(boolean enable) {
		_enable = enable;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setEnable", boolean.class);

				method.invoke(_cmtsRemoteModel, enable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_cmtsRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHost() {
		return _host;
	}

	@Override
	public void setHost(String host) {
		_host = host;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setHost", String.class);

				method.invoke(_cmtsRemoteModel, host);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCommunity() {
		return _community;
	}

	@Override
	public void setCommunity(String community) {
		_community = community;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setCommunity", String.class);

				method.invoke(_cmtsRemoteModel, community);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_cmtsRemoteModel != null) {
			try {
				Class<?> clazz = _cmtsRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_cmtsRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCmtsRemoteModel() {
		return _cmtsRemoteModel;
	}

	public void setCmtsRemoteModel(BaseModel<?> cmtsRemoteModel) {
		_cmtsRemoteModel = cmtsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cmtsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cmtsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CmtsLocalServiceUtil.addCmts(this);
		}
		else {
			CmtsLocalServiceUtil.updateCmts(this);
		}
	}

	@Override
	public Cmts toEscapedModel() {
		return (Cmts)ProxyUtil.newProxyInstance(Cmts.class.getClassLoader(),
			new Class[] { Cmts.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CmtsClp clone = new CmtsClp();

		clone.setCmtsId(getCmtsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEnable(getEnable());
		clone.setTitle(getTitle());
		clone.setHost(getHost());
		clone.setCommunity(getCommunity());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(Cmts cmts) {
		long primaryKey = cmts.getPrimaryKey();

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
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CmtsClp)) {
			return false;
		}

		CmtsClp cmts = (CmtsClp)obj;

		long primaryKey = cmts.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{cmtsId=");
		sb.append(getCmtsId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", enable=");
		sb.append(getEnable());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", host=");
		sb.append(getHost());
		sb.append(", community=");
		sb.append(getCommunity());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.Cmts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enable</column-name><column-value><![CDATA[");
		sb.append(getEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>host</column-name><column-value><![CDATA[");
		sb.append(getHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>community</column-name><column-value><![CDATA[");
		sb.append(getCommunity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cmtsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _enable;
	private String _title;
	private String _host;
	private String _community;
	private String _description;
	private BaseModel<?> _cmtsRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}