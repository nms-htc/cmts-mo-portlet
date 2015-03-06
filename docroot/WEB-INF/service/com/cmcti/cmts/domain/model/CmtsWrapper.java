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
 * This class is a wrapper for {@link Cmts}.
 * </p>
 *
 * @author richard
 * @see Cmts
 * @generated
 */
public class CmtsWrapper implements Cmts, ModelWrapper<Cmts> {
	public CmtsWrapper(Cmts cmts) {
		_cmts = cmts;
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

	/**
	* Returns the primary key of this cmts.
	*
	* @return the primary key of this cmts
	*/
	@Override
	public long getPrimaryKey() {
		return _cmts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cmts.
	*
	* @param primaryKey the primary key of this cmts
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cmts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cmts ID of this cmts.
	*
	* @return the cmts ID of this cmts
	*/
	@Override
	public long getCmtsId() {
		return _cmts.getCmtsId();
	}

	/**
	* Sets the cmts ID of this cmts.
	*
	* @param cmtsId the cmts ID of this cmts
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_cmts.setCmtsId(cmtsId);
	}

	/**
	* Returns the group ID of this cmts.
	*
	* @return the group ID of this cmts
	*/
	@Override
	public long getGroupId() {
		return _cmts.getGroupId();
	}

	/**
	* Sets the group ID of this cmts.
	*
	* @param groupId the group ID of this cmts
	*/
	@Override
	public void setGroupId(long groupId) {
		_cmts.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this cmts.
	*
	* @return the company ID of this cmts
	*/
	@Override
	public long getCompanyId() {
		return _cmts.getCompanyId();
	}

	/**
	* Sets the company ID of this cmts.
	*
	* @param companyId the company ID of this cmts
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cmts.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this cmts.
	*
	* @return the user ID of this cmts
	*/
	@Override
	public long getUserId() {
		return _cmts.getUserId();
	}

	/**
	* Sets the user ID of this cmts.
	*
	* @param userId the user ID of this cmts
	*/
	@Override
	public void setUserId(long userId) {
		_cmts.setUserId(userId);
	}

	/**
	* Returns the user uuid of this cmts.
	*
	* @return the user uuid of this cmts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmts.getUserUuid();
	}

	/**
	* Sets the user uuid of this cmts.
	*
	* @param userUuid the user uuid of this cmts
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_cmts.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this cmts.
	*
	* @return the user name of this cmts
	*/
	@Override
	public java.lang.String getUserName() {
		return _cmts.getUserName();
	}

	/**
	* Sets the user name of this cmts.
	*
	* @param userName the user name of this cmts
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_cmts.setUserName(userName);
	}

	/**
	* Returns the create date of this cmts.
	*
	* @return the create date of this cmts
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cmts.getCreateDate();
	}

	/**
	* Sets the create date of this cmts.
	*
	* @param createDate the create date of this cmts
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cmts.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this cmts.
	*
	* @return the modified date of this cmts
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cmts.getModifiedDate();
	}

	/**
	* Sets the modified date of this cmts.
	*
	* @param modifiedDate the modified date of this cmts
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cmts.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the enable of this cmts.
	*
	* @return the enable of this cmts
	*/
	@Override
	public boolean getEnable() {
		return _cmts.getEnable();
	}

	/**
	* Returns <code>true</code> if this cmts is enable.
	*
	* @return <code>true</code> if this cmts is enable; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnable() {
		return _cmts.isEnable();
	}

	/**
	* Sets whether this cmts is enable.
	*
	* @param enable the enable of this cmts
	*/
	@Override
	public void setEnable(boolean enable) {
		_cmts.setEnable(enable);
	}

	/**
	* Returns the title of this cmts.
	*
	* @return the title of this cmts
	*/
	@Override
	public java.lang.String getTitle() {
		return _cmts.getTitle();
	}

	/**
	* Sets the title of this cmts.
	*
	* @param title the title of this cmts
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_cmts.setTitle(title);
	}

	/**
	* Returns the host of this cmts.
	*
	* @return the host of this cmts
	*/
	@Override
	public java.lang.String getHost() {
		return _cmts.getHost();
	}

	/**
	* Sets the host of this cmts.
	*
	* @param host the host of this cmts
	*/
	@Override
	public void setHost(java.lang.String host) {
		_cmts.setHost(host);
	}

	/**
	* Returns the community of this cmts.
	*
	* @return the community of this cmts
	*/
	@Override
	public java.lang.String getCommunity() {
		return _cmts.getCommunity();
	}

	/**
	* Sets the community of this cmts.
	*
	* @param community the community of this cmts
	*/
	@Override
	public void setCommunity(java.lang.String community) {
		_cmts.setCommunity(community);
	}

	/**
	* Returns the description of this cmts.
	*
	* @return the description of this cmts
	*/
	@Override
	public java.lang.String getDescription() {
		return _cmts.getDescription();
	}

	/**
	* Sets the description of this cmts.
	*
	* @param description the description of this cmts
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_cmts.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _cmts.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cmts.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cmts.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cmts.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cmts.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cmts.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cmts.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cmts.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cmts.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cmts.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cmts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CmtsWrapper((Cmts)_cmts.clone());
	}

	@Override
	public int compareTo(com.cmcti.cmts.domain.model.Cmts cmts) {
		return _cmts.compareTo(cmts);
	}

	@Override
	public int hashCode() {
		return _cmts.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.Cmts> toCacheModel() {
		return _cmts.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.Cmts toEscapedModel() {
		return new CmtsWrapper(_cmts.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.Cmts toUnescapedModel() {
		return new CmtsWrapper(_cmts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cmts.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cmts.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cmts.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CmtsWrapper)) {
			return false;
		}

		CmtsWrapper cmtsWrapper = (CmtsWrapper)obj;

		if (Validator.equals(_cmts, cmtsWrapper._cmts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cmts getWrappedCmts() {
		return _cmts;
	}

	@Override
	public Cmts getWrappedModel() {
		return _cmts;
	}

	@Override
	public void resetOriginalValues() {
		_cmts.resetOriginalValues();
	}

	private Cmts _cmts;
}