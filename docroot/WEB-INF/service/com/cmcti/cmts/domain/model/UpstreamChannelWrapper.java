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
 * This class is a wrapper for {@link UpstreamChannel}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannel
 * @generated
 */
public class UpstreamChannelWrapper implements UpstreamChannel,
	ModelWrapper<UpstreamChannel> {
	public UpstreamChannelWrapper(UpstreamChannel upstreamChannel) {
		_upstreamChannel = upstreamChannel;
	}

	@Override
	public Class<?> getModelClass() {
		return UpstreamChannel.class;
	}

	@Override
	public String getModelClassName() {
		return UpstreamChannel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ifIndex", getIfIndex());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("qam", getQam());
		attributes.put("avgOnlineCmMicRef", getAvgOnlineCmMicRef());
		attributes.put("avgOnlineCmTxPower", getAvgOnlineCmTxPower());
		attributes.put("avgOnlineCmRxPower", getAvgOnlineCmRxPower());
		attributes.put("fecUncorrectable", getFecUncorrectable());
		attributes.put("fecCorrected", getFecCorrected());
		attributes.put("upChannelCmTotal", getUpChannelCmTotal());
		attributes.put("upChannelCmRegistered", getUpChannelCmRegistered());
		attributes.put("upChannelCmActive", getUpChannelCmActive());
		attributes.put("upChannelModProfile", getUpChannelModProfile());
		attributes.put("upChannelWidth", getUpChannelWidth());
		attributes.put("upChannelFrequency", getUpChannelFrequency());
		attributes.put("ifSigQUncorrectables", getIfSigQUncorrectables());
		attributes.put("ifSigQCorrecteds", getIfSigQCorrecteds());
		attributes.put("ifSigQUnerroreds", getIfSigQUnerroreds());
		attributes.put("ifSigQSNR", getIfSigQSNR());
		attributes.put("ifAlias", getIfAlias());
		attributes.put("ifDesc", getIfDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String qam = (String)attributes.get("qam");

		if (qam != null) {
			setQam(qam);
		}

		Double avgOnlineCmMicRef = (Double)attributes.get("avgOnlineCmMicRef");

		if (avgOnlineCmMicRef != null) {
			setAvgOnlineCmMicRef(avgOnlineCmMicRef);
		}

		Double avgOnlineCmTxPower = (Double)attributes.get("avgOnlineCmTxPower");

		if (avgOnlineCmTxPower != null) {
			setAvgOnlineCmTxPower(avgOnlineCmTxPower);
		}

		Double avgOnlineCmRxPower = (Double)attributes.get("avgOnlineCmRxPower");

		if (avgOnlineCmRxPower != null) {
			setAvgOnlineCmRxPower(avgOnlineCmRxPower);
		}

		Double fecUncorrectable = (Double)attributes.get("fecUncorrectable");

		if (fecUncorrectable != null) {
			setFecUncorrectable(fecUncorrectable);
		}

		Double fecCorrected = (Double)attributes.get("fecCorrected");

		if (fecCorrected != null) {
			setFecCorrected(fecCorrected);
		}

		Integer upChannelCmTotal = (Integer)attributes.get("upChannelCmTotal");

		if (upChannelCmTotal != null) {
			setUpChannelCmTotal(upChannelCmTotal);
		}

		Integer upChannelCmRegistered = (Integer)attributes.get(
				"upChannelCmRegistered");

		if (upChannelCmRegistered != null) {
			setUpChannelCmRegistered(upChannelCmRegistered);
		}

		Integer upChannelCmActive = (Integer)attributes.get("upChannelCmActive");

		if (upChannelCmActive != null) {
			setUpChannelCmActive(upChannelCmActive);
		}

		Integer upChannelModProfile = (Integer)attributes.get(
				"upChannelModProfile");

		if (upChannelModProfile != null) {
			setUpChannelModProfile(upChannelModProfile);
		}

		Long upChannelWidth = (Long)attributes.get("upChannelWidth");

		if (upChannelWidth != null) {
			setUpChannelWidth(upChannelWidth);
		}

		Long upChannelFrequency = (Long)attributes.get("upChannelFrequency");

		if (upChannelFrequency != null) {
			setUpChannelFrequency(upChannelFrequency);
		}

		Long ifSigQUncorrectables = (Long)attributes.get("ifSigQUncorrectables");

		if (ifSigQUncorrectables != null) {
			setIfSigQUncorrectables(ifSigQUncorrectables);
		}

		Long ifSigQCorrecteds = (Long)attributes.get("ifSigQCorrecteds");

		if (ifSigQCorrecteds != null) {
			setIfSigQCorrecteds(ifSigQCorrecteds);
		}

		Long ifSigQUnerroreds = (Long)attributes.get("ifSigQUnerroreds");

		if (ifSigQUnerroreds != null) {
			setIfSigQUnerroreds(ifSigQUnerroreds);
		}

		Double ifSigQSNR = (Double)attributes.get("ifSigQSNR");

		if (ifSigQSNR != null) {
			setIfSigQSNR(ifSigQSNR);
		}

		String ifAlias = (String)attributes.get("ifAlias");

		if (ifAlias != null) {
			setIfAlias(ifAlias);
		}

		String ifDesc = (String)attributes.get("ifDesc");

		if (ifDesc != null) {
			setIfDesc(ifDesc);
		}
	}

	/**
	* Returns the primary key of this upstream channel.
	*
	* @return the primary key of this upstream channel
	*/
	@Override
	public com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK getPrimaryKey() {
		return _upstreamChannel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this upstream channel.
	*
	* @param primaryKey the primary key of this upstream channel
	*/
	@Override
	public void setPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK primaryKey) {
		_upstreamChannel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the if index of this upstream channel.
	*
	* @return the if index of this upstream channel
	*/
	@Override
	public int getIfIndex() {
		return _upstreamChannel.getIfIndex();
	}

	/**
	* Sets the if index of this upstream channel.
	*
	* @param ifIndex the if index of this upstream channel
	*/
	@Override
	public void setIfIndex(int ifIndex) {
		_upstreamChannel.setIfIndex(ifIndex);
	}

	/**
	* Returns the cmts ID of this upstream channel.
	*
	* @return the cmts ID of this upstream channel
	*/
	@Override
	public long getCmtsId() {
		return _upstreamChannel.getCmtsId();
	}

	/**
	* Sets the cmts ID of this upstream channel.
	*
	* @param cmtsId the cmts ID of this upstream channel
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_upstreamChannel.setCmtsId(cmtsId);
	}

	/**
	* Returns the create date of this upstream channel.
	*
	* @return the create date of this upstream channel
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _upstreamChannel.getCreateDate();
	}

	/**
	* Sets the create date of this upstream channel.
	*
	* @param createDate the create date of this upstream channel
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_upstreamChannel.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this upstream channel.
	*
	* @return the modified date of this upstream channel
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _upstreamChannel.getModifiedDate();
	}

	/**
	* Sets the modified date of this upstream channel.
	*
	* @param modifiedDate the modified date of this upstream channel
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_upstreamChannel.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the qam of this upstream channel.
	*
	* @return the qam of this upstream channel
	*/
	@Override
	public java.lang.String getQam() {
		return _upstreamChannel.getQam();
	}

	/**
	* Sets the qam of this upstream channel.
	*
	* @param qam the qam of this upstream channel
	*/
	@Override
	public void setQam(java.lang.String qam) {
		_upstreamChannel.setQam(qam);
	}

	/**
	* Returns the avg online cm mic ref of this upstream channel.
	*
	* @return the avg online cm mic ref of this upstream channel
	*/
	@Override
	public double getAvgOnlineCmMicRef() {
		return _upstreamChannel.getAvgOnlineCmMicRef();
	}

	/**
	* Sets the avg online cm mic ref of this upstream channel.
	*
	* @param avgOnlineCmMicRef the avg online cm mic ref of this upstream channel
	*/
	@Override
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef) {
		_upstreamChannel.setAvgOnlineCmMicRef(avgOnlineCmMicRef);
	}

	/**
	* Returns the avg online cm tx power of this upstream channel.
	*
	* @return the avg online cm tx power of this upstream channel
	*/
	@Override
	public double getAvgOnlineCmTxPower() {
		return _upstreamChannel.getAvgOnlineCmTxPower();
	}

	/**
	* Sets the avg online cm tx power of this upstream channel.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power of this upstream channel
	*/
	@Override
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_upstreamChannel.setAvgOnlineCmTxPower(avgOnlineCmTxPower);
	}

	/**
	* Returns the avg online cm rx power of this upstream channel.
	*
	* @return the avg online cm rx power of this upstream channel
	*/
	@Override
	public double getAvgOnlineCmRxPower() {
		return _upstreamChannel.getAvgOnlineCmRxPower();
	}

	/**
	* Sets the avg online cm rx power of this upstream channel.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power of this upstream channel
	*/
	@Override
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_upstreamChannel.setAvgOnlineCmRxPower(avgOnlineCmRxPower);
	}

	/**
	* Returns the fec uncorrectable of this upstream channel.
	*
	* @return the fec uncorrectable of this upstream channel
	*/
	@Override
	public double getFecUncorrectable() {
		return _upstreamChannel.getFecUncorrectable();
	}

	/**
	* Sets the fec uncorrectable of this upstream channel.
	*
	* @param fecUncorrectable the fec uncorrectable of this upstream channel
	*/
	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_upstreamChannel.setFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the fec corrected of this upstream channel.
	*
	* @return the fec corrected of this upstream channel
	*/
	@Override
	public double getFecCorrected() {
		return _upstreamChannel.getFecCorrected();
	}

	/**
	* Sets the fec corrected of this upstream channel.
	*
	* @param fecCorrected the fec corrected of this upstream channel
	*/
	@Override
	public void setFecCorrected(double fecCorrected) {
		_upstreamChannel.setFecCorrected(fecCorrected);
	}

	/**
	* Returns the up channel cm total of this upstream channel.
	*
	* @return the up channel cm total of this upstream channel
	*/
	@Override
	public int getUpChannelCmTotal() {
		return _upstreamChannel.getUpChannelCmTotal();
	}

	/**
	* Sets the up channel cm total of this upstream channel.
	*
	* @param upChannelCmTotal the up channel cm total of this upstream channel
	*/
	@Override
	public void setUpChannelCmTotal(int upChannelCmTotal) {
		_upstreamChannel.setUpChannelCmTotal(upChannelCmTotal);
	}

	/**
	* Returns the up channel cm registered of this upstream channel.
	*
	* @return the up channel cm registered of this upstream channel
	*/
	@Override
	public int getUpChannelCmRegistered() {
		return _upstreamChannel.getUpChannelCmRegistered();
	}

	/**
	* Sets the up channel cm registered of this upstream channel.
	*
	* @param upChannelCmRegistered the up channel cm registered of this upstream channel
	*/
	@Override
	public void setUpChannelCmRegistered(int upChannelCmRegistered) {
		_upstreamChannel.setUpChannelCmRegistered(upChannelCmRegistered);
	}

	/**
	* Returns the up channel cm active of this upstream channel.
	*
	* @return the up channel cm active of this upstream channel
	*/
	@Override
	public int getUpChannelCmActive() {
		return _upstreamChannel.getUpChannelCmActive();
	}

	/**
	* Sets the up channel cm active of this upstream channel.
	*
	* @param upChannelCmActive the up channel cm active of this upstream channel
	*/
	@Override
	public void setUpChannelCmActive(int upChannelCmActive) {
		_upstreamChannel.setUpChannelCmActive(upChannelCmActive);
	}

	/**
	* Returns the up channel mod profile of this upstream channel.
	*
	* @return the up channel mod profile of this upstream channel
	*/
	@Override
	public int getUpChannelModProfile() {
		return _upstreamChannel.getUpChannelModProfile();
	}

	/**
	* Sets the up channel mod profile of this upstream channel.
	*
	* @param upChannelModProfile the up channel mod profile of this upstream channel
	*/
	@Override
	public void setUpChannelModProfile(int upChannelModProfile) {
		_upstreamChannel.setUpChannelModProfile(upChannelModProfile);
	}

	/**
	* Returns the up channel width of this upstream channel.
	*
	* @return the up channel width of this upstream channel
	*/
	@Override
	public long getUpChannelWidth() {
		return _upstreamChannel.getUpChannelWidth();
	}

	/**
	* Sets the up channel width of this upstream channel.
	*
	* @param upChannelWidth the up channel width of this upstream channel
	*/
	@Override
	public void setUpChannelWidth(long upChannelWidth) {
		_upstreamChannel.setUpChannelWidth(upChannelWidth);
	}

	/**
	* Returns the up channel frequency of this upstream channel.
	*
	* @return the up channel frequency of this upstream channel
	*/
	@Override
	public long getUpChannelFrequency() {
		return _upstreamChannel.getUpChannelFrequency();
	}

	/**
	* Sets the up channel frequency of this upstream channel.
	*
	* @param upChannelFrequency the up channel frequency of this upstream channel
	*/
	@Override
	public void setUpChannelFrequency(long upChannelFrequency) {
		_upstreamChannel.setUpChannelFrequency(upChannelFrequency);
	}

	/**
	* Returns the if sig q uncorrectables of this upstream channel.
	*
	* @return the if sig q uncorrectables of this upstream channel
	*/
	@Override
	public long getIfSigQUncorrectables() {
		return _upstreamChannel.getIfSigQUncorrectables();
	}

	/**
	* Sets the if sig q uncorrectables of this upstream channel.
	*
	* @param ifSigQUncorrectables the if sig q uncorrectables of this upstream channel
	*/
	@Override
	public void setIfSigQUncorrectables(long ifSigQUncorrectables) {
		_upstreamChannel.setIfSigQUncorrectables(ifSigQUncorrectables);
	}

	/**
	* Returns the if sig q correcteds of this upstream channel.
	*
	* @return the if sig q correcteds of this upstream channel
	*/
	@Override
	public long getIfSigQCorrecteds() {
		return _upstreamChannel.getIfSigQCorrecteds();
	}

	/**
	* Sets the if sig q correcteds of this upstream channel.
	*
	* @param ifSigQCorrecteds the if sig q correcteds of this upstream channel
	*/
	@Override
	public void setIfSigQCorrecteds(long ifSigQCorrecteds) {
		_upstreamChannel.setIfSigQCorrecteds(ifSigQCorrecteds);
	}

	/**
	* Returns the if sig q unerroreds of this upstream channel.
	*
	* @return the if sig q unerroreds of this upstream channel
	*/
	@Override
	public long getIfSigQUnerroreds() {
		return _upstreamChannel.getIfSigQUnerroreds();
	}

	/**
	* Sets the if sig q unerroreds of this upstream channel.
	*
	* @param ifSigQUnerroreds the if sig q unerroreds of this upstream channel
	*/
	@Override
	public void setIfSigQUnerroreds(long ifSigQUnerroreds) {
		_upstreamChannel.setIfSigQUnerroreds(ifSigQUnerroreds);
	}

	/**
	* Returns the if sig q s n r of this upstream channel.
	*
	* @return the if sig q s n r of this upstream channel
	*/
	@Override
	public double getIfSigQSNR() {
		return _upstreamChannel.getIfSigQSNR();
	}

	/**
	* Sets the if sig q s n r of this upstream channel.
	*
	* @param ifSigQSNR the if sig q s n r of this upstream channel
	*/
	@Override
	public void setIfSigQSNR(double ifSigQSNR) {
		_upstreamChannel.setIfSigQSNR(ifSigQSNR);
	}

	/**
	* Returns the if alias of this upstream channel.
	*
	* @return the if alias of this upstream channel
	*/
	@Override
	public java.lang.String getIfAlias() {
		return _upstreamChannel.getIfAlias();
	}

	/**
	* Sets the if alias of this upstream channel.
	*
	* @param ifAlias the if alias of this upstream channel
	*/
	@Override
	public void setIfAlias(java.lang.String ifAlias) {
		_upstreamChannel.setIfAlias(ifAlias);
	}

	/**
	* Returns the if desc of this upstream channel.
	*
	* @return the if desc of this upstream channel
	*/
	@Override
	public java.lang.String getIfDesc() {
		return _upstreamChannel.getIfDesc();
	}

	/**
	* Sets the if desc of this upstream channel.
	*
	* @param ifDesc the if desc of this upstream channel
	*/
	@Override
	public void setIfDesc(java.lang.String ifDesc) {
		_upstreamChannel.setIfDesc(ifDesc);
	}

	@Override
	public boolean isNew() {
		return _upstreamChannel.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_upstreamChannel.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _upstreamChannel.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_upstreamChannel.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _upstreamChannel.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _upstreamChannel.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_upstreamChannel.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _upstreamChannel.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_upstreamChannel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_upstreamChannel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_upstreamChannel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UpstreamChannelWrapper((UpstreamChannel)_upstreamChannel.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel) {
		return _upstreamChannel.compareTo(upstreamChannel);
	}

	@Override
	public int hashCode() {
		return _upstreamChannel.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.UpstreamChannel> toCacheModel() {
		return _upstreamChannel.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.UpstreamChannel toEscapedModel() {
		return new UpstreamChannelWrapper(_upstreamChannel.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.UpstreamChannel toUnescapedModel() {
		return new UpstreamChannelWrapper(_upstreamChannel.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _upstreamChannel.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _upstreamChannel.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_upstreamChannel.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpstreamChannelWrapper)) {
			return false;
		}

		UpstreamChannelWrapper upstreamChannelWrapper = (UpstreamChannelWrapper)obj;

		if (Validator.equals(_upstreamChannel,
					upstreamChannelWrapper._upstreamChannel)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UpstreamChannel getWrappedUpstreamChannel() {
		return _upstreamChannel;
	}

	@Override
	public UpstreamChannel getWrappedModel() {
		return _upstreamChannel;
	}

	@Override
	public void resetOriginalValues() {
		_upstreamChannel.resetOriginalValues();
	}

	private UpstreamChannel _upstreamChannel;
}