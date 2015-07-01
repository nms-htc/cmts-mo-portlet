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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Cmts service. Represents a row in the &quot;CMTS_Cmts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cmcti.cmts.domain.model.impl.CmtsImpl}.
 * </p>
 *
 * @author richard
 * @see Cmts
 * @see com.cmcti.cmts.domain.model.impl.CmtsImpl
 * @see com.cmcti.cmts.domain.model.impl.CmtsModelImpl
 * @generated
 */
public interface CmtsModel extends BaseModel<Cmts>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cmts model instance should use the {@link Cmts} interface instead.
	 */

	/**
	 * Returns the primary key of this cmts.
	 *
	 * @return the primary key of this cmts
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cmts.
	 *
	 * @param primaryKey the primary key of this cmts
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cmts ID of this cmts.
	 *
	 * @return the cmts ID of this cmts
	 */
	public long getCmtsId();

	/**
	 * Sets the cmts ID of this cmts.
	 *
	 * @param cmtsId the cmts ID of this cmts
	 */
	public void setCmtsId(long cmtsId);

	/**
	 * Returns the group ID of this cmts.
	 *
	 * @return the group ID of this cmts
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cmts.
	 *
	 * @param groupId the group ID of this cmts
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cmts.
	 *
	 * @return the company ID of this cmts
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cmts.
	 *
	 * @param companyId the company ID of this cmts
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cmts.
	 *
	 * @return the user ID of this cmts
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cmts.
	 *
	 * @param userId the user ID of this cmts
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cmts.
	 *
	 * @return the user uuid of this cmts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this cmts.
	 *
	 * @param userUuid the user uuid of this cmts
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cmts.
	 *
	 * @return the user name of this cmts
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cmts.
	 *
	 * @param userName the user name of this cmts
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cmts.
	 *
	 * @return the create date of this cmts
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cmts.
	 *
	 * @param createDate the create date of this cmts
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cmts.
	 *
	 * @return the modified date of this cmts
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cmts.
	 *
	 * @param modifiedDate the modified date of this cmts
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this cmts.
	 *
	 * @return the title of this cmts
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this cmts.
	 *
	 * @param title the title of this cmts
	 */
	public void setTitle(String title);

	/**
	 * Returns the host of this cmts.
	 *
	 * @return the host of this cmts
	 */
	@AutoEscape
	public String getHost();

	/**
	 * Sets the host of this cmts.
	 *
	 * @param host the host of this cmts
	 */
	public void setHost(String host);

	/**
	 * Returns the community of this cmts.
	 *
	 * @return the community of this cmts
	 */
	@AutoEscape
	public String getCommunity();

	/**
	 * Sets the community of this cmts.
	 *
	 * @param community the community of this cmts
	 */
	public void setCommunity(String community);

	/**
	 * Returns the description of this cmts.
	 *
	 * @return the description of this cmts
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this cmts.
	 *
	 * @param description the description of this cmts
	 */
	public void setDescription(String description);

	/**
	 * Returns the enable of this cmts.
	 *
	 * @return the enable of this cmts
	 */
	public boolean getEnable();

	/**
	 * Returns <code>true</code> if this cmts is enable.
	 *
	 * @return <code>true</code> if this cmts is enable; <code>false</code> otherwise
	 */
	public boolean isEnable();

	/**
	 * Sets whether this cmts is enable.
	 *
	 * @param enable the enable of this cmts
	 */
	public void setEnable(boolean enable);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Cmts cmts);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Cmts> toCacheModel();

	@Override
	public Cmts toEscapedModel();

	@Override
	public Cmts toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}