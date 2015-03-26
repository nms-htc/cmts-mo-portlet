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

import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UpstreamChannelHistory service. Represents a row in the &quot;CMTS_MONITOR_UpstreamChannelHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryImpl}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannelHistory
 * @see com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryImpl
 * @see com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl
 * @generated
 */
public interface UpstreamChannelHistoryModel extends BaseModel<UpstreamChannelHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a upstream channel history model instance should use the {@link UpstreamChannelHistory} interface instead.
	 */

	/**
	 * Returns the primary key of this upstream channel history.
	 *
	 * @return the primary key of this upstream channel history
	 */
	public UpstreamChannelHistoryPK getPrimaryKey();

	/**
	 * Sets the primary key of this upstream channel history.
	 *
	 * @param primaryKey the primary key of this upstream channel history
	 */
	public void setPrimaryKey(UpstreamChannelHistoryPK primaryKey);

	/**
	 * Returns the cmts ID of this upstream channel history.
	 *
	 * @return the cmts ID of this upstream channel history
	 */
	public long getCmtsId();

	/**
	 * Sets the cmts ID of this upstream channel history.
	 *
	 * @param cmtsId the cmts ID of this upstream channel history
	 */
	public void setCmtsId(long cmtsId);

	/**
	 * Returns the if index of this upstream channel history.
	 *
	 * @return the if index of this upstream channel history
	 */
	public int getIfIndex();

	/**
	 * Sets the if index of this upstream channel history.
	 *
	 * @param ifIndex the if index of this upstream channel history
	 */
	public void setIfIndex(int ifIndex);

	/**
	 * Returns the create date of this upstream channel history.
	 *
	 * @return the create date of this upstream channel history
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this upstream channel history.
	 *
	 * @param createDate the create date of this upstream channel history
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the qam of this upstream channel history.
	 *
	 * @return the qam of this upstream channel history
	 */
	@AutoEscape
	public String getQam();

	/**
	 * Sets the qam of this upstream channel history.
	 *
	 * @param qam the qam of this upstream channel history
	 */
	public void setQam(String qam);

	/**
	 * Returns the avg online cm ds power of this upstream channel history.
	 *
	 * @return the avg online cm ds power of this upstream channel history
	 */
	public double getAvgOnlineCmDsPower();

	/**
	 * Sets the avg online cm ds power of this upstream channel history.
	 *
	 * @param avgOnlineCmDsPower the avg online cm ds power of this upstream channel history
	 */
	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower);

	/**
	 * Returns the avg online cm us power of this upstream channel history.
	 *
	 * @return the avg online cm us power of this upstream channel history
	 */
	public double getAvgOnlineCmUsPower();

	/**
	 * Sets the avg online cm us power of this upstream channel history.
	 *
	 * @param avgOnlineCmUsPower the avg online cm us power of this upstream channel history
	 */
	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower);

	/**
	 * Returns the avg online cm mic ref of this upstream channel history.
	 *
	 * @return the avg online cm mic ref of this upstream channel history
	 */
	public double getAvgOnlineCmMicRef();

	/**
	 * Sets the avg online cm mic ref of this upstream channel history.
	 *
	 * @param avgOnlineCmMicRef the avg online cm mic ref of this upstream channel history
	 */
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef);

	/**
	 * Returns the avg online cm ds s n r of this upstream channel history.
	 *
	 * @return the avg online cm ds s n r of this upstream channel history
	 */
	public double getAvgOnlineCmDsSNR();

	/**
	 * Sets the avg online cm ds s n r of this upstream channel history.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r of this upstream channel history
	 */
	public void setAvgOnlineCmDsSNR(double avgOnlineCmDsSNR);

	/**
	 * Returns the avg online cm tx power of this upstream channel history.
	 *
	 * @return the avg online cm tx power of this upstream channel history
	 */
	public double getAvgOnlineCmTxPower();

	/**
	 * Sets the avg online cm tx power of this upstream channel history.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power of this upstream channel history
	 */
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower);

	/**
	 * Returns the avg online cm rx power of this upstream channel history.
	 *
	 * @return the avg online cm rx power of this upstream channel history
	 */
	public double getAvgOnlineCmRxPower();

	/**
	 * Sets the avg online cm rx power of this upstream channel history.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power of this upstream channel history
	 */
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower);

	/**
	 * Returns the fec uncorrectable of this upstream channel history.
	 *
	 * @return the fec uncorrectable of this upstream channel history
	 */
	public double getFecUncorrectable();

	/**
	 * Sets the fec uncorrectable of this upstream channel history.
	 *
	 * @param fecUncorrectable the fec uncorrectable of this upstream channel history
	 */
	public void setFecUncorrectable(double fecUncorrectable);

	/**
	 * Returns the fec corrected of this upstream channel history.
	 *
	 * @return the fec corrected of this upstream channel history
	 */
	public double getFecCorrected();

	/**
	 * Sets the fec corrected of this upstream channel history.
	 *
	 * @param fecCorrected the fec corrected of this upstream channel history
	 */
	public void setFecCorrected(double fecCorrected);

	/**
	 * Returns the up channel cm total of this upstream channel history.
	 *
	 * @return the up channel cm total of this upstream channel history
	 */
	public int getUpChannelCmTotal();

	/**
	 * Sets the up channel cm total of this upstream channel history.
	 *
	 * @param upChannelCmTotal the up channel cm total of this upstream channel history
	 */
	public void setUpChannelCmTotal(int upChannelCmTotal);

	/**
	 * Returns the up channel cm registered of this upstream channel history.
	 *
	 * @return the up channel cm registered of this upstream channel history
	 */
	public int getUpChannelCmRegistered();

	/**
	 * Sets the up channel cm registered of this upstream channel history.
	 *
	 * @param upChannelCmRegistered the up channel cm registered of this upstream channel history
	 */
	public void setUpChannelCmRegistered(int upChannelCmRegistered);

	/**
	 * Returns the up channel cm active of this upstream channel history.
	 *
	 * @return the up channel cm active of this upstream channel history
	 */
	public int getUpChannelCmActive();

	/**
	 * Sets the up channel cm active of this upstream channel history.
	 *
	 * @param upChannelCmActive the up channel cm active of this upstream channel history
	 */
	public void setUpChannelCmActive(int upChannelCmActive);

	/**
	 * Returns the up channel mod profile of this upstream channel history.
	 *
	 * @return the up channel mod profile of this upstream channel history
	 */
	public int getUpChannelModProfile();

	/**
	 * Sets the up channel mod profile of this upstream channel history.
	 *
	 * @param upChannelModProfile the up channel mod profile of this upstream channel history
	 */
	public void setUpChannelModProfile(int upChannelModProfile);

	/**
	 * Returns the up channel width of this upstream channel history.
	 *
	 * @return the up channel width of this upstream channel history
	 */
	public long getUpChannelWidth();

	/**
	 * Sets the up channel width of this upstream channel history.
	 *
	 * @param upChannelWidth the up channel width of this upstream channel history
	 */
	public void setUpChannelWidth(long upChannelWidth);

	/**
	 * Returns the up channel frequency of this upstream channel history.
	 *
	 * @return the up channel frequency of this upstream channel history
	 */
	public long getUpChannelFrequency();

	/**
	 * Sets the up channel frequency of this upstream channel history.
	 *
	 * @param upChannelFrequency the up channel frequency of this upstream channel history
	 */
	public void setUpChannelFrequency(long upChannelFrequency);

	/**
	 * Returns the if sig q uncorrectables of this upstream channel history.
	 *
	 * @return the if sig q uncorrectables of this upstream channel history
	 */
	public long getIfSigQUncorrectables();

	/**
	 * Sets the if sig q uncorrectables of this upstream channel history.
	 *
	 * @param ifSigQUncorrectables the if sig q uncorrectables of this upstream channel history
	 */
	public void setIfSigQUncorrectables(long ifSigQUncorrectables);

	/**
	 * Returns the if sig q correcteds of this upstream channel history.
	 *
	 * @return the if sig q correcteds of this upstream channel history
	 */
	public long getIfSigQCorrecteds();

	/**
	 * Sets the if sig q correcteds of this upstream channel history.
	 *
	 * @param ifSigQCorrecteds the if sig q correcteds of this upstream channel history
	 */
	public void setIfSigQCorrecteds(long ifSigQCorrecteds);

	/**
	 * Returns the if sig q unerroreds of this upstream channel history.
	 *
	 * @return the if sig q unerroreds of this upstream channel history
	 */
	public long getIfSigQUnerroreds();

	/**
	 * Sets the if sig q unerroreds of this upstream channel history.
	 *
	 * @param ifSigQUnerroreds the if sig q unerroreds of this upstream channel history
	 */
	public void setIfSigQUnerroreds(long ifSigQUnerroreds);

	/**
	 * Returns the if sig q s n r of this upstream channel history.
	 *
	 * @return the if sig q s n r of this upstream channel history
	 */
	public double getIfSigQSNR();

	/**
	 * Sets the if sig q s n r of this upstream channel history.
	 *
	 * @param ifSigQSNR the if sig q s n r of this upstream channel history
	 */
	public void setIfSigQSNR(double ifSigQSNR);

	/**
	 * Returns the if alias of this upstream channel history.
	 *
	 * @return the if alias of this upstream channel history
	 */
	@AutoEscape
	public String getIfAlias();

	/**
	 * Sets the if alias of this upstream channel history.
	 *
	 * @param ifAlias the if alias of this upstream channel history
	 */
	public void setIfAlias(String ifAlias);

	/**
	 * Returns the if desc of this upstream channel history.
	 *
	 * @return the if desc of this upstream channel history
	 */
	@AutoEscape
	public String getIfDesc();

	/**
	 * Sets the if desc of this upstream channel history.
	 *
	 * @param ifDesc the if desc of this upstream channel history
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
	public int compareTo(UpstreamChannelHistory upstreamChannelHistory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UpstreamChannelHistory> toCacheModel();

	@Override
	public UpstreamChannelHistory toEscapedModel();

	@Override
	public UpstreamChannelHistory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}