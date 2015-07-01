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
import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;

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
public class MerchantClp extends BaseModelImpl<Merchant> implements Merchant {
	public MerchantClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Merchant.class;
	}

	@Override
	public String getModelClassName() {
		return Merchant.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _merchantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMerchantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _merchantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("merchantId", getMerchantId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("code", getCode());
		attributes.put("parentId", getParentId());
		attributes.put("parentCode", getParentCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long merchantId = (Long)attributes.get("merchantId");

		if (merchantId != null) {
			setMerchantId(merchantId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentCode = (String)attributes.get("parentCode");

		if (parentCode != null) {
			setParentCode(parentCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getMerchantId() {
		return _merchantId;
	}

	@Override
	public void setMerchantId(long merchantId) {
		_merchantId = merchantId;

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setMerchantId", long.class);

				method.invoke(_merchantRemoteModel, merchantId);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_merchantRemoteModel, groupId);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_merchantRemoteModel, companyId);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_merchantRemoteModel, userId);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_merchantRemoteModel, userName);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_merchantRemoteModel, createDate);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_merchantRemoteModel, modifiedDate);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_merchantRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_merchantRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_merchantRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParentCode() {
		return _parentCode;
	}

	@Override
	public void setParentCode(String parentCode) {
		_parentCode = parentCode;

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setParentCode", String.class);

				method.invoke(_merchantRemoteModel, parentCode);
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

		if (_merchantRemoteModel != null) {
			try {
				Class<?> clazz = _merchantRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_merchantRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMerchantRemoteModel() {
		return _merchantRemoteModel;
	}

	public void setMerchantRemoteModel(BaseModel<?> merchantRemoteModel) {
		_merchantRemoteModel = merchantRemoteModel;
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

		Class<?> remoteModelClass = _merchantRemoteModel.getClass();

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

		Object returnValue = method.invoke(_merchantRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MerchantLocalServiceUtil.addMerchant(this);
		}
		else {
			MerchantLocalServiceUtil.updateMerchant(this);
		}
	}

	@Override
	public Merchant toEscapedModel() {
		return (Merchant)ProxyUtil.newProxyInstance(Merchant.class.getClassLoader(),
			new Class[] { Merchant.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MerchantClp clone = new MerchantClp();

		clone.setMerchantId(getMerchantId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setCode(getCode());
		clone.setParentId(getParentId());
		clone.setParentCode(getParentCode());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(Merchant merchant) {
		long primaryKey = merchant.getPrimaryKey();

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

		if (!(obj instanceof MerchantClp)) {
			return false;
		}

		MerchantClp merchant = (MerchantClp)obj;

		long primaryKey = merchant.getPrimaryKey();

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

		sb.append("{merchantId=");
		sb.append(getMerchantId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", parentCode=");
		sb.append(getParentCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.Merchant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>merchantId</column-name><column-value><![CDATA[");
		sb.append(getMerchantId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCode</column-name><column-value><![CDATA[");
		sb.append(getParentCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _merchantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _code;
	private long _parentId;
	private String _parentCode;
	private String _description;
	private BaseModel<?> _merchantRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}