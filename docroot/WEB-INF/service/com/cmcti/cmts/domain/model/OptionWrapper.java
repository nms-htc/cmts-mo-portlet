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
 * This class is a wrapper for {@link Option}.
 * </p>
 *
 * @author richard
 * @see Option
 * @generated
 */
public class OptionWrapper implements Option, ModelWrapper<Option> {
	public OptionWrapper(Option option) {
		_option = option;
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

	/**
	* Returns the primary key of this option.
	*
	* @return the primary key of this option
	*/
	@Override
	public long getPrimaryKey() {
		return _option.getPrimaryKey();
	}

	/**
	* Sets the primary key of this option.
	*
	* @param primaryKey the primary key of this option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_option.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the option ID of this option.
	*
	* @return the option ID of this option
	*/
	@Override
	public long getOptionId() {
		return _option.getOptionId();
	}

	/**
	* Sets the option ID of this option.
	*
	* @param optionId the option ID of this option
	*/
	@Override
	public void setOptionId(long optionId) {
		_option.setOptionId(optionId);
	}

	/**
	* Returns the group ID of this option.
	*
	* @return the group ID of this option
	*/
	@Override
	public long getGroupId() {
		return _option.getGroupId();
	}

	/**
	* Sets the group ID of this option.
	*
	* @param groupId the group ID of this option
	*/
	@Override
	public void setGroupId(long groupId) {
		_option.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this option.
	*
	* @return the company ID of this option
	*/
	@Override
	public long getCompanyId() {
		return _option.getCompanyId();
	}

	/**
	* Sets the company ID of this option.
	*
	* @param companyId the company ID of this option
	*/
	@Override
	public void setCompanyId(long companyId) {
		_option.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this option.
	*
	* @return the user ID of this option
	*/
	@Override
	public long getUserId() {
		return _option.getUserId();
	}

	/**
	* Sets the user ID of this option.
	*
	* @param userId the user ID of this option
	*/
	@Override
	public void setUserId(long userId) {
		_option.setUserId(userId);
	}

	/**
	* Returns the user uuid of this option.
	*
	* @return the user uuid of this option
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _option.getUserUuid();
	}

	/**
	* Sets the user uuid of this option.
	*
	* @param userUuid the user uuid of this option
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_option.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this option.
	*
	* @return the user name of this option
	*/
	@Override
	public java.lang.String getUserName() {
		return _option.getUserName();
	}

	/**
	* Sets the user name of this option.
	*
	* @param userName the user name of this option
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_option.setUserName(userName);
	}

	/**
	* Returns the create date of this option.
	*
	* @return the create date of this option
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _option.getCreateDate();
	}

	/**
	* Sets the create date of this option.
	*
	* @param createDate the create date of this option
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_option.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this option.
	*
	* @return the modified date of this option
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _option.getModifiedDate();
	}

	/**
	* Sets the modified date of this option.
	*
	* @param modifiedDate the modified date of this option
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_option.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the option type of this option.
	*
	* @return the option type of this option
	*/
	@Override
	public java.lang.String getOptionType() {
		return _option.getOptionType();
	}

	/**
	* Sets the option type of this option.
	*
	* @param optionType the option type of this option
	*/
	@Override
	public void setOptionType(java.lang.String optionType) {
		_option.setOptionType(optionType);
	}

	/**
	* Returns the option key of this option.
	*
	* @return the option key of this option
	*/
	@Override
	public java.lang.String getOptionKey() {
		return _option.getOptionKey();
	}

	/**
	* Sets the option key of this option.
	*
	* @param optionKey the option key of this option
	*/
	@Override
	public void setOptionKey(java.lang.String optionKey) {
		_option.setOptionKey(optionKey);
	}

	/**
	* Returns the option value of this option.
	*
	* @return the option value of this option
	*/
	@Override
	public java.lang.String getOptionValue() {
		return _option.getOptionValue();
	}

	/**
	* Sets the option value of this option.
	*
	* @param optionValue the option value of this option
	*/
	@Override
	public void setOptionValue(java.lang.String optionValue) {
		_option.setOptionValue(optionValue);
	}

	/**
	* Returns the description of this option.
	*
	* @return the description of this option
	*/
	@Override
	public java.lang.String getDescription() {
		return _option.getDescription();
	}

	/**
	* Sets the description of this option.
	*
	* @param description the description of this option
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_option.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _option.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_option.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _option.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_option.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _option.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _option.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_option.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _option.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_option.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_option.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_option.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OptionWrapper((Option)_option.clone());
	}

	@Override
	public int compareTo(com.cmcti.cmts.domain.model.Option option) {
		return _option.compareTo(option);
	}

	@Override
	public int hashCode() {
		return _option.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.Option> toCacheModel() {
		return _option.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.Option toEscapedModel() {
		return new OptionWrapper(_option.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.Option toUnescapedModel() {
		return new OptionWrapper(_option.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _option.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _option.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_option.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OptionWrapper)) {
			return false;
		}

		OptionWrapper optionWrapper = (OptionWrapper)obj;

		if (Validator.equals(_option, optionWrapper._option)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Option getWrappedOption() {
		return _option;
	}

	@Override
	public Option getWrappedModel() {
		return _option;
	}

	@Override
	public void resetOriginalValues() {
		_option.resetOriginalValues();
	}

	private Option _option;
}