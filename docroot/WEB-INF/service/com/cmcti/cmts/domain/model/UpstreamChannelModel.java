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

import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UpstreamChannel service. Represents a row in the &quot;CMTS_MONITOR_UpstreamChannel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelImpl}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannel
 * @see com.cmcti.cmts.domain.model.impl.UpstreamChannelImpl
 * @see com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl
 * @generated
 */
public interface UpstreamChannelModel extends BaseModel<UpstreamChannel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a upstream channel model instance should use the {@link UpstreamChannel} interface instead.
	 */

	/**
	 * Returns the primary key of this upstream channel.
	 *
	 * @return the primary key of this upstream channel
	 */
	public UpstreamChannelPK getPrimaryKey();

	/**
	 * Sets the primary key of this upstream channel.
	 *
	 * @param primaryKey the primary key of this upstream channel
	 */
	public void setPrimaryKey(UpstreamChannelPK primaryKey);

	/**
	 * Returns the if index of this upstream channel.
	 *
	 * @return the if index of this upstream channel
	 */
	public int getIfIndex();

	/**
	 * Sets the if index of this upstream channel.
	 *
	 * @param ifIndex the if index of this upstream channel
	 */
	public void setIfIndex(int ifIndex);

	/**
	 * Returns the cmts ID of this upstream channel.
	 *
	 * @return the cmts ID of this upstream channel
	 */
	public long getCmtsId();

	/**
	 * Sets the cmts ID of this upstream channel.
	 *
	 * @param cmtsId the cmts ID of this upstream channel
	 */
	public void setCmtsId(long cmtsId);

	/**
	 * Returns the create date of this upstream channel.
	 *
	 * @return the create date of this upstream channel
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this upstream channel.
	 *
	 * @param createDate the create date of this upstream channel
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this upstream channel.
	 *
	 * @return the modified date of this upstream channel
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this upstream channel.
	 *
	 * @param modifiedDate the modified date of this upstream channel
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the qam of this upstream channel.
	 *
	 * @return the qam of this upstream channel
	 */
	@AutoEscape
	public String getQam();

	/**
	 * Sets the qam of this upstream channel.
	 *
	 * @param qam the qam of this upstream channel
	 */
	public void setQam(String qam);

	/**
	 * Returns the avg online cm ds power of this upstream channel.
	 *
	 * @return the avg online cm ds power of this upstream channel
	 */
	public double getAvgOnlineCmDsPower();

	/**
	 * Sets the avg online cm ds power of this upstream channel.
	 *
	 * @param avgOnlineCmDsPower the avg online cm ds power of this upstream channel
	 */
	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower);

	/**
	 * Returns the avg online cm us power of this upstream channel.
	 *
	 * @return the avg online cm us power of this upstream channel
	 */
	public double getAvgOnlineCmUsPower();

	/**
	 * Sets the avg online cm us power of this upstream channel.
	 *
	 * @param avgOnlineCmUsPower the avg online cm us power of this upstream channel
	 */
	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower);

	/**
	 * Returns the avg online cm mic ref of this upstream channel.
	 *
	 * @return the avg online cm mic ref of this upstream channel
	 */
	public double getAvgOnlineCmMicRef();

	/**
	 * Sets the avg online cm mic ref of this upstream channel.
	 *
	 * @param avgOnlineCmMicRef the avg online cm mic ref of this upstream channel
	 */
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef);

	/**
	 * Returns the avg online cm ds s n r of this upstream channel.
	 *
	 * @return the avg online cm ds s n r of this upstream channel
	 */
	public double getAvgOnlineCmDsSNR();

	/**
	 * Sets the avg online cm ds s n r of this upstream channel.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r of this upstream channel
	 */
	public void setAvgOnlineCmDsSNR(double avgOnlineCmDsSNR);

	/**
	 * Returns the avg online cm tx power of this upstream channel.
	 *
	 * @return the avg online cm tx power of this upstream channel
	 */
	public double getAvgOnlineCmTxPower();

	/**
	 * Sets the avg online cm tx power of this upstream channel.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power of this upstream channel
	 */
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower);

	/**
	 * Returns the avg online cm rx power of this upstream channel.
	 *
	 * @return the avg online cm rx power of this upstream channel
	 */
	public double getAvgOnlineCmRxPower();

	/**
	 * Sets the avg online cm rx power of this upstream channel.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power of this upstream channel
	 */
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower);

	/**
	 * Returns the fec uncorrectable of this upstream channel.
	 *
	 * @return the fec uncorrectable of this upstream channel
	 */
	public double getFecUncorrectable();

	/**
	 * Sets the fec uncorrectable of this upstream channel.
	 *
	 * @param fecUncorrectable the fec uncorrectable of this upstream channel
	 */
	public void setFecUncorrectable(double fecUncorrectable);

	/**
	 * Returns the fec corrected of this upstream channel.
	 *
	 * @return the fec corrected of this upstream channel
	 */
	public double getFecCorrected();

	/**
	 * Sets the fec corrected of this upstream channel.
	 *
	 * @param fecCorrected the fec corrected of this upstream channel
	 */
	public void setFecCorrected(double fecCorrected);

	/**
	 * Returns the up channel cm total of this upstream channel.
	 *
	 * @return the up channel cm total of this upstream channel
	 */
	public int getUpChannelCmTotal();

	/**
	 * Sets the up channel cm total of this upstream channel.
	 *
	 * @param upChannelCmTotal the up channel cm total of this upstream channel
	 */
	public void setUpChannelCmTotal(int upChannelCmTotal);

	/**
	 * Returns the up channel cm registered of this upstream channel.
	 *
	 * @return the up channel cm registered of this upstream channel
	 */
	public int getUpChannelCmRegistered();

	/**
	 * Sets the up channel cm registered of this upstream channel.
	 *
	 * @param upChannelCmRegistered the up channel cm registered of this upstream channel
	 */
	public void setUpChannelCmRegistered(int upChannelCmRegistered);

	/**
	 * Returns the up channel cm active of this upstream channel.
	 *
	 * @return the up channel cm active of this upstream channel
	 */
	public int getUpChannelCmActive();

	/**
	 * Sets the up channel cm active of this upstream channel.
	 *
	 * @param upChannelCmActive the up channel cm active of this upstream channel
	 */
	public void setUpChannelCmActive(int upChannelCmActive);

	/**
	 * Returns the up channel mod profile of this upstream channel.
	 *
	 * @return the up channel mod profile of this upstream channel
	 */
	public int getUpChannelModProfile();

	/**
	 * Sets the up channel mod profile of this upstream channel.
	 *
	 * @param upChannelModProfile the up channel mod profile of this upstream channel
	 */
	public void setUpChannelModProfile(int upChannelModProfile);

	/**
	 * Returns the up channel width of this upstream channel.
	 *
	 * @return the up channel width of this upstream channel
	 */
	public long getUpChannelWidth();

	/**
	 * Sets the up channel width of this upstream channel.
	 *
	 * @param upChannelWidth the up channel width of this upstream channel
	 */
	public void setUpChannelWidth(long upChannelWidth);

	/**
	 * Returns the up channel frequency of this upstream channel.
	 *
	 * @return the up channel frequency of this upstream channel
	 */
	public long getUpChannelFrequency();

	/**
	 * Sets the up channel frequency of this upstream channel.
	 *
	 * @param upChannelFrequency the up channel frequency of this upstream channel
	 */
	public void setUpChannelFrequency(long upChannelFrequency);

	/**
	 * Returns the if sig q uncorrectables of this upstream channel.
	 *
	 * @return the if sig q uncorrectables of this upstream channel
	 */
	public long getIfSigQUncorrectables();

	/**
	 * Sets the if sig q uncorrectables of this upstream channel.
	 *
	 * @param ifSigQUncorrectables the if sig q uncorrectables of this upstream channel
	 */
	public void setIfSigQUncorrectables(long ifSigQUncorrectables);

	/**
	 * Returns the if sig q correcteds of this upstream channel.
	 *
	 * @return the if sig q correcteds of this upstream channel
	 */
	public long getIfSigQCorrecteds();

	/**
	 * Sets the if sig q correcteds of this upstream channel.
	 *
	 * @param ifSigQCorrecteds the if sig q correcteds of this upstream channel
	 */
	public void setIfSigQCorrecteds(long ifSigQCorrecteds);

	/**
	 * Returns the if sig q unerroreds of this upstream channel.
	 *
	 * @return the if sig q unerroreds of this upstream channel
	 */
	public long getIfSigQUnerroreds();

	/**
	 * Sets the if sig q unerroreds of this upstream channel.
	 *
	 * @param ifSigQUnerroreds the if sig q unerroreds of this upstream channel
	 */
	public void setIfSigQUnerroreds(long ifSigQUnerroreds);

	/**
	 * Returns the if sig q s n r of this upstream channel.
	 *
	 * @return the if sig q s n r of this upstream channel
	 */
	public double getIfSigQSNR();

	/**
	 * Sets the if sig q s n r of this upstream channel.
	 *
	 * @param ifSigQSNR the if sig q s n r of this upstream channel
	 */
	public void setIfSigQSNR(double ifSigQSNR);

	/**
	 * Returns the if alias of this upstream channel.
	 *
	 * @return the if alias of this upstream channel
	 */
	@AutoEscape
	public String getIfAlias();

	/**
	 * Sets the if alias of this upstream channel.
	 *
	 * @param ifAlias the if alias of this upstream channel
	 */
	public void setIfAlias(String ifAlias);

	/**
	 * Returns the if desc of this upstream channel.
	 *
	 * @return the if desc of this upstream channel
	 */
	@AutoEscape
	public String getIfDesc();

	/**
	 * Sets the if desc of this upstream channel.
	 *
	 * @param ifDesc the if desc of this upstream channel
	 */
	public void setIfDesc(String ifDesc);

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
	public int compareTo(UpstreamChannel upstreamChannel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UpstreamChannel> toCacheModel();

	@Override
	public UpstreamChannel toEscapedModel();

	@Override
	public UpstreamChannel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}