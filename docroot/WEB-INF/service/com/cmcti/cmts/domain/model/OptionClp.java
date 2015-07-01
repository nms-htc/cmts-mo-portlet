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
import com.cmcti.cmts.domain.service.OptionLocalServiceUtil;

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
public class OptionClp extends BaseModelImpl<Option> implements Option {
	public OptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Option.class;
	}

	@Override
	public String getModelClassName() {
		return Option.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _optionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _optionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("optionId", getOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("optionType", getOptionType());
		attributes.put("optionKey", getOptionKey());
		attributes.put("optionValue", getOptionValue());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long optionId = (Long)attributes.get("optionId");

		if (optionId != null) {
			setOptionId(optionId);
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

		String optionType = (String)attributes.get("optionType");

		if (optionType != null) {
			setOptionType(optionType);
		}

		String optionKey = (String)attributes.get("optionKey");

		if (optionKey != null) {
			setOptionKey(optionKey);
		}

		String optionValue = (String)attributes.get("optionValue");

		if (optionValue != null) {
			setOptionValue(optionValue);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getOptionId() {
		return _optionId;
	}

	@Override
	public void setOptionId(long optionId) {
		_optionId = optionId;

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionId", long.class);

				method.invoke(_optionRemoteModel, optionId);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_optionRemoteModel, groupId);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_optionRemoteModel, companyId);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_optionRemoteModel, userId);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_optionRemoteModel, userName);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_optionRemoteModel, createDate);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_optionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionType() {
		return _optionType;
	}

	@Override
	public void setOptionType(String optionType) {
		_optionType = optionType;

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionType", String.class);

				method.invoke(_optionRemoteModel, optionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionKey() {
		return _optionKey;
	}

	@Override
	public void setOptionKey(String optionKey) {
		_optionKey = optionKey;

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionKey", String.class);

				method.invoke(_optionRemoteModel, optionKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionValue() {
		return _optionValue;
	}

	@Override
	public void setOptionValue(String optionValue) {
		_optionValue = optionValue;

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionValue", String.class);

				method.invoke(_optionRemoteModel, optionValue);
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

		if (_optionRemoteModel != null) {
			try {
				Class<?> clazz = _optionRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_optionRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOptionRemoteModel() {
		return _optionRemoteModel;
	}

	public void setOptionRemoteModel(BaseModel<?> optionRemoteModel) {
		_optionRemoteModel = optionRemoteModel;
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

		Class<?> remoteModelClass = _optionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_optionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OptionLocalServiceUtil.addOption(this);
		}
		else {
			OptionLocalServiceUtil.updateOption(this);
		}
	}

	@Override
	public Option toEscapedModel() {
		return (Option)ProxyUtil.newProxyInstance(Option.class.getClassLoader(),
			new Class[] { Option.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OptionClp clone = new OptionClp();

		clone.setOptionId(getOptionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOptionType(getOptionType());
		clone.setOptionKey(getOptionKey());
		clone.setOptionValue(getOptionValue());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(Option option) {
		long primaryKey = option.getPrimaryKey();

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

		if (!(obj instanceof OptionClp)) {
			return false;
		}

		OptionClp option = (OptionClp)obj;

		long primaryKey = option.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{optionId=");
		sb.append(getOptionId());
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
		sb.append(", optionType=");
		sb.append(getOptionType());
		sb.append(", optionKey=");
		sb.append(getOptionKey());
		sb.append(", optionValue=");
		sb.append(getOptionValue());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.Option");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>optionId</column-name><column-value><![CDATA[");
		sb.append(getOptionId());
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
			"<column><column-name>optionType</column-name><column-value><![CDATA[");
		sb.append(getOptionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionKey</column-name><column-value><![CDATA[");
		sb.append(getOptionKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionValue</column-name><column-value><![CDATA[");
		sb.append(getOptionValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _optionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _optionType;
	private String _optionKey;
	private String _optionValue;
	private String _description;
	private BaseModel<?> _optionRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}