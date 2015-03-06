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
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;

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
public class CustomerMacMappingClp extends BaseModelImpl<CustomerMacMapping>
	implements CustomerMacMapping {
	public CustomerMacMappingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CustomerMacMapping.class;
	}

	@Override
	public String getModelClassName() {
		return CustomerMacMapping.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _customerMacId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomerMacId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customerMacId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerMacId", getCustomerMacId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("macAddress", getMacAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerMacId = (Long)attributes.get("customerMacId");

		if (customerMacId != null) {
			setCustomerMacId(customerMacId);
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

		String macAddress = (String)attributes.get("macAddress");

		if (macAddress != null) {
			setMacAddress(macAddress);
		}
	}

	@Override
	public long getCustomerMacId() {
		return _customerMacId;
	}

	@Override
	public void setCustomerMacId(long customerMacId) {
		_customerMacId = customerMacId;

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerMacId", long.class);

				method.invoke(_customerMacMappingRemoteModel, customerMacId);
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

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_customerMacMappingRemoteModel, groupId);
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

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_customerMacMappingRemoteModel, companyId);
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

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_customerMacMappingRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_customerMacMappingRemoteModel, createDate);
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

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_customerMacMappingRemoteModel, modifiedDate);
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

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_customerMacMappingRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMacAddress() {
		return _macAddress;
	}

	@Override
	public void setMacAddress(String macAddress) {
		_macAddress = macAddress;

		if (_customerMacMappingRemoteModel != null) {
			try {
				Class<?> clazz = _customerMacMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setMacAddress", String.class);

				method.invoke(_customerMacMappingRemoteModel, macAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCustomerMacMappingRemoteModel() {
		return _customerMacMappingRemoteModel;
	}

	public void setCustomerMacMappingRemoteModel(
		BaseModel<?> customerMacMappingRemoteModel) {
		_customerMacMappingRemoteModel = customerMacMappingRemoteModel;
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

		Class<?> remoteModelClass = _customerMacMappingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_customerMacMappingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CustomerMacMappingLocalServiceUtil.addCustomerMacMapping(this);
		}
		else {
			CustomerMacMappingLocalServiceUtil.updateCustomerMacMapping(this);
		}
	}

	@Override
	public CustomerMacMapping toEscapedModel() {
		return (CustomerMacMapping)ProxyUtil.newProxyInstance(CustomerMacMapping.class.getClassLoader(),
			new Class[] { CustomerMacMapping.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CustomerMacMappingClp clone = new CustomerMacMappingClp();

		clone.setCustomerMacId(getCustomerMacId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setMacAddress(getMacAddress());

		return clone;
	}

	@Override
	public int compareTo(CustomerMacMapping customerMacMapping) {
		int value = 0;

		value = getTitle().compareTo(customerMacMapping.getTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomerMacMappingClp)) {
			return false;
		}

		CustomerMacMappingClp customerMacMapping = (CustomerMacMappingClp)obj;

		long primaryKey = customerMacMapping.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{customerMacId=");
		sb.append(getCustomerMacId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", macAddress=");
		sb.append(getMacAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.CustomerMacMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>customerMacId</column-name><column-value><![CDATA[");
		sb.append(getCustomerMacId());
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
			"<column><column-name>macAddress</column-name><column-value><![CDATA[");
		sb.append(getMacAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _customerMacId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _macAddress;
	private BaseModel<?> _customerMacMappingRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}