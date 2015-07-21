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
 * This class is a wrapper for {@link MerchantScope}.
 * </p>
 *
 * @author richard
 * @see MerchantScope
 * @generated
 */
public class MerchantScopeWrapper implements MerchantScope,
	ModelWrapper<MerchantScope> {
	public MerchantScopeWrapper(MerchantScope merchantScope) {
		_merchantScope = merchantScope;
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

	/**
	* Returns the primary key of this merchant scope.
	*
	* @return the primary key of this merchant scope
	*/
	@Override
	public long getPrimaryKey() {
		return _merchantScope.getPrimaryKey();
	}

	/**
	* Sets the primary key of this merchant scope.
	*
	* @param primaryKey the primary key of this merchant scope
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_merchantScope.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the merchant scope ID of this merchant scope.
	*
	* @return the merchant scope ID of this merchant scope
	*/
	@Override
	public long getMerchantScopeId() {
		return _merchantScope.getMerchantScopeId();
	}

	/**
	* Sets the merchant scope ID of this merchant scope.
	*
	* @param merchantScopeId the merchant scope ID of this merchant scope
	*/
	@Override
	public void setMerchantScopeId(long merchantScopeId) {
		_merchantScope.setMerchantScopeId(merchantScopeId);
	}

	/**
	* Returns the group ID of this merchant scope.
	*
	* @return the group ID of this merchant scope
	*/
	@Override
	public long getGroupId() {
		return _merchantScope.getGroupId();
	}

	/**
	* Sets the group ID of this merchant scope.
	*
	* @param groupId the group ID of this merchant scope
	*/
	@Override
	public void setGroupId(long groupId) {
		_merchantScope.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this merchant scope.
	*
	* @return the company ID of this merchant scope
	*/
	@Override
	public long getCompanyId() {
		return _merchantScope.getCompanyId();
	}

	/**
	* Sets the company ID of this merchant scope.
	*
	* @param companyId the company ID of this merchant scope
	*/
	@Override
	public void setCompanyId(long companyId) {
		_merchantScope.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this merchant scope.
	*
	* @return the user ID of this merchant scope
	*/
	@Override
	public long getUserId() {
		return _merchantScope.getUserId();
	}

	/**
	* Sets the user ID of this merchant scope.
	*
	* @param userId the user ID of this merchant scope
	*/
	@Override
	public void setUserId(long userId) {
		_merchantScope.setUserId(userId);
	}

	/**
	* Returns the user uuid of this merchant scope.
	*
	* @return the user uuid of this merchant scope
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScope.getUserUuid();
	}

	/**
	* Sets the user uuid of this merchant scope.
	*
	* @param userUuid the user uuid of this merchant scope
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_merchantScope.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this merchant scope.
	*
	* @return the user name of this merchant scope
	*/
	@Override
	public java.lang.String getUserName() {
		return _merchantScope.getUserName();
	}

	/**
	* Sets the user name of this merchant scope.
	*
	* @param userName the user name of this merchant scope
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_merchantScope.setUserName(userName);
	}

	/**
	* Returns the create date of this merchant scope.
	*
	* @return the create date of this merchant scope
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _merchantScope.getCreateDate();
	}

	/**
	* Sets the create date of this merchant scope.
	*
	* @param createDate the create date of this merchant scope
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_merchantScope.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this merchant scope.
	*
	* @return the modified date of this merchant scope
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _merchantScope.getModifiedDate();
	}

	/**
	* Sets the modified date of this merchant scope.
	*
	* @param modifiedDate the modified date of this merchant scope
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_merchantScope.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the cmts ID of this merchant scope.
	*
	* @return the cmts ID of this merchant scope
	*/
	@Override
	public long getCmtsId() {
		return _merchantScope.getCmtsId();
	}

	/**
	* Sets the cmts ID of this merchant scope.
	*
	* @param cmtsId the cmts ID of this merchant scope
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_merchantScope.setCmtsId(cmtsId);
	}

	/**
	* Returns the if index of this merchant scope.
	*
	* @return the if index of this merchant scope
	*/
	@Override
	public int getIfIndex() {
		return _merchantScope.getIfIndex();
	}

	/**
	* Sets the if index of this merchant scope.
	*
	* @param ifIndex the if index of this merchant scope
	*/
	@Override
	public void setIfIndex(int ifIndex) {
		_merchantScope.setIfIndex(ifIndex);
	}

	/**
	* Returns the merchant code of this merchant scope.
	*
	* @return the merchant code of this merchant scope
	*/
	@Override
	public java.lang.String getMerchantCode() {
		return _merchantScope.getMerchantCode();
	}

	/**
	* Sets the merchant code of this merchant scope.
	*
	* @param merchantCode the merchant code of this merchant scope
	*/
	@Override
	public void setMerchantCode(java.lang.String merchantCode) {
		_merchantScope.setMerchantCode(merchantCode);
	}

	@Override
	public boolean isNew() {
		return _merchantScope.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_merchantScope.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _merchantScope.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_merchantScope.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _merchantScope.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _merchantScope.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_merchantScope.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _merchantScope.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_merchantScope.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_merchantScope.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_merchantScope.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MerchantScopeWrapper((MerchantScope)_merchantScope.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope) {
		return _merchantScope.compareTo(merchantScope);
	}

	@Override
	public int hashCode() {
		return _merchantScope.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.MerchantScope> toCacheModel() {
		return _merchantScope.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.MerchantScope toEscapedModel() {
		return new MerchantScopeWrapper(_merchantScope.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.MerchantScope toUnescapedModel() {
		return new MerchantScopeWrapper(_merchantScope.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _merchantScope.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _merchantScope.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_merchantScope.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MerchantScopeWrapper)) {
			return false;
		}

		MerchantScopeWrapper merchantScopeWrapper = (MerchantScopeWrapper)obj;

		if (Validator.equals(_merchantScope, merchantScopeWrapper._merchantScope)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MerchantScope getWrappedMerchantScope() {
		return _merchantScope;
	}

	@Override
	public MerchantScope getWrappedModel() {
		return _merchantScope;
	}

	@Override
	public void resetOriginalValues() {
		_merchantScope.resetOriginalValues();
	}

	private MerchantScope _merchantScope;
}