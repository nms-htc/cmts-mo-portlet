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
 * This class is a wrapper for {@link Merchant}.
 * </p>
 *
 * @author richard
 * @see Merchant
 * @generated
 */
public class MerchantWrapper implements Merchant, ModelWrapper<Merchant> {
	public MerchantWrapper(Merchant merchant) {
		_merchant = merchant;
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

	/**
	* Returns the primary key of this merchant.
	*
	* @return the primary key of this merchant
	*/
	@Override
	public long getPrimaryKey() {
		return _merchant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this merchant.
	*
	* @param primaryKey the primary key of this merchant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_merchant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the merchant ID of this merchant.
	*
	* @return the merchant ID of this merchant
	*/
	@Override
	public long getMerchantId() {
		return _merchant.getMerchantId();
	}

	/**
	* Sets the merchant ID of this merchant.
	*
	* @param merchantId the merchant ID of this merchant
	*/
	@Override
	public void setMerchantId(long merchantId) {
		_merchant.setMerchantId(merchantId);
	}

	/**
	* Returns the group ID of this merchant.
	*
	* @return the group ID of this merchant
	*/
	@Override
	public long getGroupId() {
		return _merchant.getGroupId();
	}

	/**
	* Sets the group ID of this merchant.
	*
	* @param groupId the group ID of this merchant
	*/
	@Override
	public void setGroupId(long groupId) {
		_merchant.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this merchant.
	*
	* @return the company ID of this merchant
	*/
	@Override
	public long getCompanyId() {
		return _merchant.getCompanyId();
	}

	/**
	* Sets the company ID of this merchant.
	*
	* @param companyId the company ID of this merchant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_merchant.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this merchant.
	*
	* @return the user ID of this merchant
	*/
	@Override
	public long getUserId() {
		return _merchant.getUserId();
	}

	/**
	* Sets the user ID of this merchant.
	*
	* @param userId the user ID of this merchant
	*/
	@Override
	public void setUserId(long userId) {
		_merchant.setUserId(userId);
	}

	/**
	* Returns the user uuid of this merchant.
	*
	* @return the user uuid of this merchant
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchant.getUserUuid();
	}

	/**
	* Sets the user uuid of this merchant.
	*
	* @param userUuid the user uuid of this merchant
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_merchant.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this merchant.
	*
	* @return the user name of this merchant
	*/
	@Override
	public java.lang.String getUserName() {
		return _merchant.getUserName();
	}

	/**
	* Sets the user name of this merchant.
	*
	* @param userName the user name of this merchant
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_merchant.setUserName(userName);
	}

	/**
	* Returns the create date of this merchant.
	*
	* @return the create date of this merchant
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _merchant.getCreateDate();
	}

	/**
	* Sets the create date of this merchant.
	*
	* @param createDate the create date of this merchant
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_merchant.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this merchant.
	*
	* @return the modified date of this merchant
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _merchant.getModifiedDate();
	}

	/**
	* Sets the modified date of this merchant.
	*
	* @param modifiedDate the modified date of this merchant
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_merchant.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this merchant.
	*
	* @return the title of this merchant
	*/
	@Override
	public java.lang.String getTitle() {
		return _merchant.getTitle();
	}

	/**
	* Sets the title of this merchant.
	*
	* @param title the title of this merchant
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_merchant.setTitle(title);
	}

	/**
	* Returns the code of this merchant.
	*
	* @return the code of this merchant
	*/
	@Override
	public java.lang.String getCode() {
		return _merchant.getCode();
	}

	/**
	* Sets the code of this merchant.
	*
	* @param code the code of this merchant
	*/
	@Override
	public void setCode(java.lang.String code) {
		_merchant.setCode(code);
	}

	/**
	* Returns the parent ID of this merchant.
	*
	* @return the parent ID of this merchant
	*/
	@Override
	public long getParentId() {
		return _merchant.getParentId();
	}

	/**
	* Sets the parent ID of this merchant.
	*
	* @param parentId the parent ID of this merchant
	*/
	@Override
	public void setParentId(long parentId) {
		_merchant.setParentId(parentId);
	}

	/**
	* Returns the parent code of this merchant.
	*
	* @return the parent code of this merchant
	*/
	@Override
	public java.lang.String getParentCode() {
		return _merchant.getParentCode();
	}

	/**
	* Sets the parent code of this merchant.
	*
	* @param parentCode the parent code of this merchant
	*/
	@Override
	public void setParentCode(java.lang.String parentCode) {
		_merchant.setParentCode(parentCode);
	}

	/**
	* Returns the description of this merchant.
	*
	* @return the description of this merchant
	*/
	@Override
	public java.lang.String getDescription() {
		return _merchant.getDescription();
	}

	/**
	* Sets the description of this merchant.
	*
	* @param description the description of this merchant
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_merchant.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _merchant.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_merchant.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _merchant.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_merchant.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _merchant.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _merchant.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_merchant.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _merchant.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_merchant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_merchant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_merchant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MerchantWrapper((Merchant)_merchant.clone());
	}

	@Override
	public int compareTo(com.cmcti.cmts.domain.model.Merchant merchant) {
		return _merchant.compareTo(merchant);
	}

	@Override
	public int hashCode() {
		return _merchant.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.Merchant> toCacheModel() {
		return _merchant.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.Merchant toEscapedModel() {
		return new MerchantWrapper(_merchant.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.Merchant toUnescapedModel() {
		return new MerchantWrapper(_merchant.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _merchant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _merchant.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_merchant.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MerchantWrapper)) {
			return false;
		}

		MerchantWrapper merchantWrapper = (MerchantWrapper)obj;

		if (Validator.equals(_merchant, merchantWrapper._merchant)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Merchant getWrappedMerchant() {
		return _merchant;
	}

	@Override
	public Merchant getWrappedModel() {
		return _merchant;
	}

	@Override
	public void resetOriginalValues() {
		_merchant.resetOriginalValues();
	}

	private Merchant _merchant;
}