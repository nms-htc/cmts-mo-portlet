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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomerMacMapping}.
 * </p>
 *
 * @author richard
 * @see CustomerMacMapping
 * @generated
 */
public class CustomerMacMappingWrapper implements CustomerMacMapping,
	ModelWrapper<CustomerMacMapping> {
	public CustomerMacMappingWrapper(CustomerMacMapping customerMacMapping) {
		_customerMacMapping = customerMacMapping;
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

	/**
	* Returns the primary key of this customer mac mapping.
	*
	* @return the primary key of this customer mac mapping
	*/
	@Override
	public long getPrimaryKey() {
		return _customerMacMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this customer mac mapping.
	*
	* @param primaryKey the primary key of this customer mac mapping
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customerMacMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the customer mac ID of this customer mac mapping.
	*
	* @return the customer mac ID of this customer mac mapping
	*/
	@Override
	public long getCustomerMacId() {
		return _customerMacMapping.getCustomerMacId();
	}

	/**
	* Sets the customer mac ID of this customer mac mapping.
	*
	* @param customerMacId the customer mac ID of this customer mac mapping
	*/
	@Override
	public void setCustomerMacId(long customerMacId) {
		_customerMacMapping.setCustomerMacId(customerMacId);
	}

	/**
	* Returns the group ID of this customer mac mapping.
	*
	* @return the group ID of this customer mac mapping
	*/
	@Override
	public long getGroupId() {
		return _customerMacMapping.getGroupId();
	}

	/**
	* Sets the group ID of this customer mac mapping.
	*
	* @param groupId the group ID of this customer mac mapping
	*/
	@Override
	public void setGroupId(long groupId) {
		_customerMacMapping.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this customer mac mapping.
	*
	* @return the company ID of this customer mac mapping
	*/
	@Override
	public long getCompanyId() {
		return _customerMacMapping.getCompanyId();
	}

	/**
	* Sets the company ID of this customer mac mapping.
	*
	* @param companyId the company ID of this customer mac mapping
	*/
	@Override
	public void setCompanyId(long companyId) {
		_customerMacMapping.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this customer mac mapping.
	*
	* @return the user ID of this customer mac mapping
	*/
	@Override
	public long getUserId() {
		return _customerMacMapping.getUserId();
	}

	/**
	* Sets the user ID of this customer mac mapping.
	*
	* @param userId the user ID of this customer mac mapping
	*/
	@Override
	public void setUserId(long userId) {
		_customerMacMapping.setUserId(userId);
	}

	/**
	* Returns the user uuid of this customer mac mapping.
	*
	* @return the user uuid of this customer mac mapping
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMapping.getUserUuid();
	}

	/**
	* Sets the user uuid of this customer mac mapping.
	*
	* @param userUuid the user uuid of this customer mac mapping
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_customerMacMapping.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this customer mac mapping.
	*
	* @return the create date of this customer mac mapping
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _customerMacMapping.getCreateDate();
	}

	/**
	* Sets the create date of this customer mac mapping.
	*
	* @param createDate the create date of this customer mac mapping
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_customerMacMapping.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this customer mac mapping.
	*
	* @return the modified date of this customer mac mapping
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _customerMacMapping.getModifiedDate();
	}

	/**
	* Sets the modified date of this customer mac mapping.
	*
	* @param modifiedDate the modified date of this customer mac mapping
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_customerMacMapping.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this customer mac mapping.
	*
	* @return the title of this customer mac mapping
	*/
	@Override
	public java.lang.String getTitle() {
		return _customerMacMapping.getTitle();
	}

	/**
	* Sets the title of this customer mac mapping.
	*
	* @param title the title of this customer mac mapping
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_customerMacMapping.setTitle(title);
	}

	/**
	* Returns the mac address of this customer mac mapping.
	*
	* @return the mac address of this customer mac mapping
	*/
	@Override
	public java.lang.String getMacAddress() {
		return _customerMacMapping.getMacAddress();
	}

	/**
	* Sets the mac address of this customer mac mapping.
	*
	* @param macAddress the mac address of this customer mac mapping
	*/
	@Override
	public void setMacAddress(java.lang.String macAddress) {
		_customerMacMapping.setMacAddress(macAddress);
	}

	@Override
	public boolean isNew() {
		return _customerMacMapping.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_customerMacMapping.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _customerMacMapping.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customerMacMapping.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _customerMacMapping.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _customerMacMapping.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_customerMacMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _customerMacMapping.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_customerMacMapping.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_customerMacMapping.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_customerMacMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CustomerMacMappingWrapper((CustomerMacMapping)_customerMacMapping.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping) {
		return _customerMacMapping.compareTo(customerMacMapping);
	}

	@Override
	public int hashCode() {
		return _customerMacMapping.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.CustomerMacMapping> toCacheModel() {
		return _customerMacMapping.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping toEscapedModel() {
		return new CustomerMacMappingWrapper(_customerMacMapping.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping toUnescapedModel() {
		return new CustomerMacMappingWrapper(_customerMacMapping.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _customerMacMapping.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customerMacMapping.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_customerMacMapping.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomerMacMappingWrapper)) {
			return false;
		}

		CustomerMacMappingWrapper customerMacMappingWrapper = (CustomerMacMappingWrapper)obj;

		if (Validator.equals(_customerMacMapping,
					customerMacMappingWrapper._customerMacMapping)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CustomerMacMapping getWrappedCustomerMacMapping() {
		return _customerMacMapping;
	}

	@Override
	public CustomerMacMapping getWrappedModel() {
		return _customerMacMapping;
	}

	@Override
	public void resetOriginalValues() {
		_customerMacMapping.resetOriginalValues();
	}

	private CustomerMacMapping _customerMacMapping;
}