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
 * This class is a wrapper for {@link UpstreamChannelHistory}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannelHistory
 * @generated
 */
public class UpstreamChannelHistoryWrapper implements UpstreamChannelHistory,
	ModelWrapper<UpstreamChannelHistory> {
	public UpstreamChannelHistoryWrapper(
		UpstreamChannelHistory upstreamChannelHistory) {
		_upstreamChannelHistory = upstreamChannelHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return UpstreamChannelHistory.class;
	}

	@Override
	public String getModelClassName() {
		return UpstreamChannelHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cmtsId", getCmtsId());
		attributes.put("ifIndex", getIfIndex());
		attributes.put("createDate", getCreateDate());
		attributes.put("qam", getQam());
		attributes.put("avgOnlineCmDsPower", getAvgOnlineCmDsPower());
		attributes.put("avgOnlineCmUsPower", getAvgOnlineCmUsPower());
		attributes.put("avgOnlineCmMicRef", getAvgOnlineCmMicRef());
		attributes.put("avgOnlineCmDsSNR", getAvgOnlineCmDsSNR());
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
		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String qam = (String)attributes.get("qam");

		if (qam != null) {
			setQam(qam);
		}

		Double avgOnlineCmDsPower = (Double)attributes.get("avgOnlineCmDsPower");

		if (avgOnlineCmDsPower != null) {
			setAvgOnlineCmDsPower(avgOnlineCmDsPower);
		}

		Double avgOnlineCmUsPower = (Double)attributes.get("avgOnlineCmUsPower");

		if (avgOnlineCmUsPower != null) {
			setAvgOnlineCmUsPower(avgOnlineCmUsPower);
		}

		Double avgOnlineCmMicRef = (Double)attributes.get("avgOnlineCmMicRef");

		if (avgOnlineCmMicRef != null) {
			setAvgOnlineCmMicRef(avgOnlineCmMicRef);
		}

		Double avgOnlineCmDsSNR = (Double)attributes.get("avgOnlineCmDsSNR");

		if (avgOnlineCmDsSNR != null) {
			setAvgOnlineCmDsSNR(avgOnlineCmDsSNR);
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
	* Returns the primary key of this upstream channel history.
	*
	* @return the primary key of this upstream channel history
	*/
	@Override
	public com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPK getPrimaryKey() {
		return _upstreamChannelHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this upstream channel history.
	*
	* @param primaryKey the primary key of this upstream channel history
	*/
	@Override
	public void setPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPK primaryKey) {
		_upstreamChannelHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cmts ID of this upstream channel history.
	*
	* @return the cmts ID of this upstream channel history
	*/
	@Override
	public long getCmtsId() {
		return _upstreamChannelHistory.getCmtsId();
	}

	/**
	* Sets the cmts ID of this upstream channel history.
	*
	* @param cmtsId the cmts ID of this upstream channel history
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_upstreamChannelHistory.setCmtsId(cmtsId);
	}

	/**
	* Returns the if index of this upstream channel history.
	*
	* @return the if index of this upstream channel history
	*/
	@Override
	public int getIfIndex() {
		return _upstreamChannelHistory.getIfIndex();
	}

	/**
	* Sets the if index of this upstream channel history.
	*
	* @param ifIndex the if index of this upstream channel history
	*/
	@Override
	public void setIfIndex(int ifIndex) {
		_upstreamChannelHistory.setIfIndex(ifIndex);
	}

	/**
	* Returns the create date of this upstream channel history.
	*
	* @return the create date of this upstream channel history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _upstreamChannelHistory.getCreateDate();
	}

	/**
	* Sets the create date of this upstream channel history.
	*
	* @param createDate the create date of this upstream channel history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_upstreamChannelHistory.setCreateDate(createDate);
	}

	/**
	* Returns the qam of this upstream channel history.
	*
	* @return the qam of this upstream channel history
	*/
	@Override
	public java.lang.String getQam() {
		return _upstreamChannelHistory.getQam();
	}

	/**
	* Sets the qam of this upstream channel history.
	*
	* @param qam the qam of this upstream channel history
	*/
	@Override
	public void setQam(java.lang.String qam) {
		_upstreamChannelHistory.setQam(qam);
	}

	/**
	* Returns the avg online cm ds power of this upstream channel history.
	*
	* @return the avg online cm ds power of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmDsPower() {
		return _upstreamChannelHistory.getAvgOnlineCmDsPower();
	}

	/**
	* Sets the avg online cm ds power of this upstream channel history.
	*
	* @param avgOnlineCmDsPower the avg online cm ds power of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower) {
		_upstreamChannelHistory.setAvgOnlineCmDsPower(avgOnlineCmDsPower);
	}

	/**
	* Returns the avg online cm us power of this upstream channel history.
	*
	* @return the avg online cm us power of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmUsPower() {
		return _upstreamChannelHistory.getAvgOnlineCmUsPower();
	}

	/**
	* Sets the avg online cm us power of this upstream channel history.
	*
	* @param avgOnlineCmUsPower the avg online cm us power of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower) {
		_upstreamChannelHistory.setAvgOnlineCmUsPower(avgOnlineCmUsPower);
	}

	/**
	* Returns the avg online cm mic ref of this upstream channel history.
	*
	* @return the avg online cm mic ref of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmMicRef() {
		return _upstreamChannelHistory.getAvgOnlineCmMicRef();
	}

	/**
	* Sets the avg online cm mic ref of this upstream channel history.
	*
	* @param avgOnlineCmMicRef the avg online cm mic ref of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef) {
		_upstreamChannelHistory.setAvgOnlineCmMicRef(avgOnlineCmMicRef);
	}

	/**
	* Returns the avg online cm ds s n r of this upstream channel history.
	*
	* @return the avg online cm ds s n r of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmDsSNR() {
		return _upstreamChannelHistory.getAvgOnlineCmDsSNR();
	}

	/**
	* Sets the avg online cm ds s n r of this upstream channel history.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmDsSNR(double avgOnlineCmDsSNR) {
		_upstreamChannelHistory.setAvgOnlineCmDsSNR(avgOnlineCmDsSNR);
	}

	/**
	* Returns the avg online cm tx power of this upstream channel history.
	*
	* @return the avg online cm tx power of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmTxPower() {
		return _upstreamChannelHistory.getAvgOnlineCmTxPower();
	}

	/**
	* Sets the avg online cm tx power of this upstream channel history.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_upstreamChannelHistory.setAvgOnlineCmTxPower(avgOnlineCmTxPower);
	}

	/**
	* Returns the avg online cm rx power of this upstream channel history.
	*
	* @return the avg online cm rx power of this upstream channel history
	*/
	@Override
	public double getAvgOnlineCmRxPower() {
		return _upstreamChannelHistory.getAvgOnlineCmRxPower();
	}

	/**
	* Sets the avg online cm rx power of this upstream channel history.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power of this upstream channel history
	*/
	@Override
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_upstreamChannelHistory.setAvgOnlineCmRxPower(avgOnlineCmRxPower);
	}

	/**
	* Returns the fec uncorrectable of this upstream channel history.
	*
	* @return the fec uncorrectable of this upstream channel history
	*/
	@Override
	public double getFecUncorrectable() {
		return _upstreamChannelHistory.getFecUncorrectable();
	}

	/**
	* Sets the fec uncorrectable of this upstream channel history.
	*
	* @param fecUncorrectable the fec uncorrectable of this upstream channel history
	*/
	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_upstreamChannelHistory.setFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the fec corrected of this upstream channel history.
	*
	* @return the fec corrected of this upstream channel history
	*/
	@Override
	public double getFecCorrected() {
		return _upstreamChannelHistory.getFecCorrected();
	}

	/**
	* Sets the fec corrected of this upstream channel history.
	*
	* @param fecCorrected the fec corrected of this upstream channel history
	*/
	@Override
	public void setFecCorrected(double fecCorrected) {
		_upstreamChannelHistory.setFecCorrected(fecCorrected);
	}

	/**
	* Returns the up channel cm total of this upstream channel history.
	*
	* @return the up channel cm total of this upstream channel history
	*/
	@Override
	public int getUpChannelCmTotal() {
		return _upstreamChannelHistory.getUpChannelCmTotal();
	}

	/**
	* Sets the up channel cm total of this upstream channel history.
	*
	* @param upChannelCmTotal the up channel cm total of this upstream channel history
	*/
	@Override
	public void setUpChannelCmTotal(int upChannelCmTotal) {
		_upstreamChannelHistory.setUpChannelCmTotal(upChannelCmTotal);
	}

	/**
	* Returns the up channel cm registered of this upstream channel history.
	*
	* @return the up channel cm registered of this upstream channel history
	*/
	@Override
	public int getUpChannelCmRegistered() {
		return _upstreamChannelHistory.getUpChannelCmRegistered();
	}

	/**
	* Sets the up channel cm registered of this upstream channel history.
	*
	* @param upChannelCmRegistered the up channel cm registered of this upstream channel history
	*/
	@Override
	public void setUpChannelCmRegistered(int upChannelCmRegistered) {
		_upstreamChannelHistory.setUpChannelCmRegistered(upChannelCmRegistered);
	}

	/**
	* Returns the up channel cm active of this upstream channel history.
	*
	* @return the up channel cm active of this upstream channel history
	*/
	@Override
	public int getUpChannelCmActive() {
		return _upstreamChannelHistory.getUpChannelCmActive();
	}

	/**
	* Sets the up channel cm active of this upstream channel history.
	*
	* @param upChannelCmActive the up channel cm active of this upstream channel history
	*/
	@Override
	public void setUpChannelCmActive(int upChannelCmActive) {
		_upstreamChannelHistory.setUpChannelCmActive(upChannelCmActive);
	}

	/**
	* Returns the up channel mod profile of this upstream channel history.
	*
	* @return the up channel mod profile of this upstream channel history
	*/
	@Override
	public int getUpChannelModProfile() {
		return _upstreamChannelHistory.getUpChannelModProfile();
	}

	/**
	* Sets the up channel mod profile of this upstream channel history.
	*
	* @param upChannelModProfile the up channel mod profile of this upstream channel history
	*/
	@Override
	public void setUpChannelModProfile(int upChannelModProfile) {
		_upstreamChannelHistory.setUpChannelModProfile(upChannelModProfile);
	}

	/**
	* Returns the up channel width of this upstream channel history.
	*
	* @return the up channel width of this upstream channel history
	*/
	@Override
	public long getUpChannelWidth() {
		return _upstreamChannelHistory.getUpChannelWidth();
	}

	/**
	* Sets the up channel width of this upstream channel history.
	*
	* @param upChannelWidth the up channel width of this upstream channel history
	*/
	@Override
	public void setUpChannelWidth(long upChannelWidth) {
		_upstreamChannelHistory.setUpChannelWidth(upChannelWidth);
	}

	/**
	* Returns the up channel frequency of this upstream channel history.
	*
	* @return the up channel frequency of this upstream channel history
	*/
	@Override
	public long getUpChannelFrequency() {
		return _upstreamChannelHistory.getUpChannelFrequency();
	}

	/**
	* Sets the up channel frequency of this upstream channel history.
	*
	* @param upChannelFrequency the up channel frequency of this upstream channel history
	*/
	@Override
	public void setUpChannelFrequency(long upChannelFrequency) {
		_upstreamChannelHistory.setUpChannelFrequency(upChannelFrequency);
	}

	/**
	* Returns the if sig q uncorrectables of this upstream channel history.
	*
	* @return the if sig q uncorrectables of this upstream channel history
	*/
	@Override
	public long getIfSigQUncorrectables() {
		return _upstreamChannelHistory.getIfSigQUncorrectables();
	}

	/**
	* Sets the if sig q uncorrectables of this upstream channel history.
	*
	* @param ifSigQUncorrectables the if sig q uncorrectables of this upstream channel history
	*/
	@Override
	public void setIfSigQUncorrectables(long ifSigQUncorrectables) {
		_upstreamChannelHistory.setIfSigQUncorrectables(ifSigQUncorrectables);
	}

	/**
	* Returns the if sig q correcteds of this upstream channel history.
	*
	* @return the if sig q correcteds of this upstream channel history
	*/
	@Override
	public long getIfSigQCorrecteds() {
		return _upstreamChannelHistory.getIfSigQCorrecteds();
	}

	/**
	* Sets the if sig q correcteds of this upstream channel history.
	*
	* @param ifSigQCorrecteds the if sig q correcteds of this upstream channel history
	*/
	@Override
	public void setIfSigQCorrecteds(long ifSigQCorrecteds) {
		_upstreamChannelHistory.setIfSigQCorrecteds(ifSigQCorrecteds);
	}

	/**
	* Returns the if sig q unerroreds of this upstream channel history.
	*
	* @return the if sig q unerroreds of this upstream channel history
	*/
	@Override
	public long getIfSigQUnerroreds() {
		return _upstreamChannelHistory.getIfSigQUnerroreds();
	}

	/**
	* Sets the if sig q unerroreds of this upstream channel history.
	*
	* @param ifSigQUnerroreds the if sig q unerroreds of this upstream channel history
	*/
	@Override
	public void setIfSigQUnerroreds(long ifSigQUnerroreds) {
		_upstreamChannelHistory.setIfSigQUnerroreds(ifSigQUnerroreds);
	}

	/**
	* Returns the if sig q s n r of this upstream channel history.
	*
	* @return the if sig q s n r of this upstream channel history
	*/
	@Override
	public double getIfSigQSNR() {
		return _upstreamChannelHistory.getIfSigQSNR();
	}

	/**
	* Sets the if sig q s n r of this upstream channel history.
	*
	* @param ifSigQSNR the if sig q s n r of this upstream channel history
	*/
	@Override
	public void setIfSigQSNR(double ifSigQSNR) {
		_upstreamChannelHistory.setIfSigQSNR(ifSigQSNR);
	}

	/**
	* Returns the if alias of this upstream channel history.
	*
	* @return the if alias of this upstream channel history
	*/
	@Override
	public java.lang.String getIfAlias() {
		return _upstreamChannelHistory.getIfAlias();
	}

	/**
	* Sets the if alias of this upstream channel history.
	*
	* @param ifAlias the if alias of this upstream channel history
	*/
	@Override
	public void setIfAlias(java.lang.String ifAlias) {
		_upstreamChannelHistory.setIfAlias(ifAlias);
	}

	/**
	* Returns the if desc of this upstream channel history.
	*
	* @return the if desc of this upstream channel history
	*/
	@Override
	public java.lang.String getIfDesc() {
		return _upstreamChannelHistory.getIfDesc();
	}

	/**
	* Sets the if desc of this upstream channel history.
	*
	* @param ifDesc the if desc of this upstream channel history
	*/
	@Override
	public void setIfDesc(java.lang.String ifDesc) {
		_upstreamChannelHistory.setIfDesc(ifDesc);
	}

	@Override
	public boolean isNew() {
		return _upstreamChannelHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_upstreamChannelHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _upstreamChannelHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_upstreamChannelHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _upstreamChannelHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _upstreamChannelHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_upstreamChannelHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _upstreamChannelHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_upstreamChannelHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_upstreamChannelHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_upstreamChannelHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UpstreamChannelHistoryWrapper((UpstreamChannelHistory)_upstreamChannelHistory.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.UpstreamChannelHistory upstreamChannelHistory) {
		return _upstreamChannelHistory.compareTo(upstreamChannelHistory);
	}

	@Override
	public int hashCode() {
		return _upstreamChannelHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.UpstreamChannelHistory> toCacheModel() {
		return _upstreamChannelHistory.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.UpstreamChannelHistory toEscapedModel() {
		return new UpstreamChannelHistoryWrapper(_upstreamChannelHistory.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.UpstreamChannelHistory toUnescapedModel() {
		return new UpstreamChannelHistoryWrapper(_upstreamChannelHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _upstreamChannelHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _upstreamChannelHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_upstreamChannelHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpstreamChannelHistoryWrapper)) {
			return false;
		}

		UpstreamChannelHistoryWrapper upstreamChannelHistoryWrapper = (UpstreamChannelHistoryWrapper)obj;

		if (Validator.equals(_upstreamChannelHistory,
					upstreamChannelHistoryWrapper._upstreamChannelHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UpstreamChannelHistory getWrappedUpstreamChannelHistory() {
		return _upstreamChannelHistory;
	}

	@Override
	public UpstreamChannelHistory getWrappedModel() {
		return _upstreamChannelHistory;
	}

	@Override
	public void resetOriginalValues() {
		_upstreamChannelHistory.resetOriginalValues();
	}

	private UpstreamChannelHistory _upstreamChannelHistory;
}