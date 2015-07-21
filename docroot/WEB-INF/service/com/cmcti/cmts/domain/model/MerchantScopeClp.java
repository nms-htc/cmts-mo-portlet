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
import com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil;

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
public class MerchantScopeClp extends BaseModelImpl<MerchantScope>
	implements MerchantScope {
	public MerchantScopeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MerchantScope.class;
	}

	@Override
	public String getModelClassName() {
		return MerchantScope.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _merchantScopeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMerchantScopeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _merchantScopeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("merchantScopeId", getMerchantScopeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("ifIndex", getIfIndex());
		attributes.put("merchantCode", getMerchantCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long merchantScopeId = (Long)attributes.get("merchantScopeId");

		if (merchantScopeId != null) {
			setMerchantScopeId(merchantScopeId);
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

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		String merchantCode = (String)attributes.get("merchantCode");

		if (merchantCode != null) {
			setMerchantCode(merchantCode);
		}
	}

	@Override
	public long getMerchantScopeId() {
		return _merchantScopeId;
	}

	@Override
	public void setMerchantScopeId(long merchantScopeId) {
		_merchantScopeId = merchantScopeId;

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setMerchantScopeId", long.class);

				method.invoke(_merchantScopeRemoteModel, merchantScopeId);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_merchantScopeRemoteModel, groupId);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_merchantScopeRemoteModel, companyId);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_merchantScopeRemoteModel, userId);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_merchantScopeRemoteModel, userName);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_merchantScopeRemoteModel, createDate);
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

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_merchantScopeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setCmtsId", long.class);

				method.invoke(_merchantScopeRemoteModel, cmtsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIfIndex() {
		return _ifIndex;
	}

	@Override
	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setIfIndex", int.class);

				method.invoke(_merchantScopeRemoteModel, ifIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMerchantCode() {
		return _merchantCode;
	}

	@Override
	public void setMerchantCode(String merchantCode) {
		_merchantCode = merchantCode;

		if (_merchantScopeRemoteModel != null) {
			try {
				Class<?> clazz = _merchantScopeRemoteModel.getClass();

				Method method = clazz.getMethod("setMerchantCode", String.class);

				method.invoke(_merchantScopeRemoteModel, merchantCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMerchantScopeRemoteModel() {
		return _merchantScopeRemoteModel;
	}

	public void setMerchantScopeRemoteModel(
		BaseModel<?> merchantScopeRemoteModel) {
		_merchantScopeRemoteModel = merchantScopeRemoteModel;
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

		Class<?> remoteModelClass = _merchantScopeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_merchantScopeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MerchantScopeLocalServiceUtil.addMerchantScope(this);
		}
		else {
			MerchantScopeLocalServiceUtil.updateMerchantScope(this);
		}
	}

	@Override
	public MerchantScope toEscapedModel() {
		return (MerchantScope)ProxyUtil.newProxyInstance(MerchantScope.class.getClassLoader(),
			new Class[] { MerchantScope.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MerchantScopeClp clone = new MerchantScopeClp();

		clone.setMerchantScopeId(getMerchantScopeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCmtsId(getCmtsId());
		clone.setIfIndex(getIfIndex());
		clone.setMerchantCode(getMerchantCode());

		return clone;
	}

	@Override
	public int compareTo(MerchantScope merchantScope) {
		long primaryKey = merchantScope.getPrimaryKey();

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

		if (!(obj instanceof MerchantScopeClp)) {
			return false;
		}

		MerchantScopeClp merchantScope = (MerchantScopeClp)obj;

		long primaryKey = merchantScope.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{merchantScopeId=");
		sb.append(getMerchantScopeId());
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
		sb.append(", cmtsId=");
		sb.append(getCmtsId());
		sb.append(", ifIndex=");
		sb.append(getIfIndex());
		sb.append(", merchantCode=");
		sb.append(getMerchantCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.MerchantScope");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>merchantScopeId</column-name><column-value><![CDATA[");
		sb.append(getMerchantScopeId());
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
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifIndex</column-name><column-value><![CDATA[");
		sb.append(getIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>merchantCode</column-name><column-value><![CDATA[");
		sb.append(getMerchantCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _merchantScopeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cmtsId;
	private int _ifIndex;
	private String _merchantCode;
	private BaseModel<?> _merchantScopeRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}