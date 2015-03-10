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
 * This class is a wrapper for {@link CableModemHistory}.
 * </p>
 *
 * @author richard
 * @see CableModemHistory
 * @generated
 */
public class CableModemHistoryWrapper implements CableModemHistory,
	ModelWrapper<CableModemHistory> {
	public CableModemHistoryWrapper(CableModemHistory cableModemHistory) {
		_cableModemHistory = cableModemHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return CableModemHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CableModemHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("macAddress", getMacAddress());
		attributes.put("createDate", getCreateDate());
		attributes.put("fecUncorrectable", getFecUncorrectable());
		attributes.put("fecCorrected", getFecCorrected());
		attributes.put("microRef", getMicroRef());
		attributes.put("rxPower", getRxPower());
		attributes.put("txPower", getTxPower());
		attributes.put("usPower", getUsPower());
		attributes.put("dsPower", getDsPower());
		attributes.put("uncorrectables", getUncorrectables());
		attributes.put("correcteds", getCorrecteds());
		attributes.put("unerroreds", getUnerroreds());
		attributes.put("dsSNR", getDsSNR());
		attributes.put("usSNR", getUsSNR());
		attributes.put("ucIfIndex", getUcIfIndex());
		attributes.put("dcIfIndex", getDcIfIndex());
		attributes.put("cmSubIndex", getCmSubIndex());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("cmIndex", getCmIndex());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String macAddress = (String)attributes.get("macAddress");

		if (macAddress != null) {
			setMacAddress(macAddress);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Double fecUncorrectable = (Double)attributes.get("fecUncorrectable");

		if (fecUncorrectable != null) {
			setFecUncorrectable(fecUncorrectable);
		}

		Double fecCorrected = (Double)attributes.get("fecCorrected");

		if (fecCorrected != null) {
			setFecCorrected(fecCorrected);
		}

		Long microRef = (Long)attributes.get("microRef");

		if (microRef != null) {
			setMicroRef(microRef);
		}

		Integer rxPower = (Integer)attributes.get("rxPower");

		if (rxPower != null) {
			setRxPower(rxPower);
		}

		Integer txPower = (Integer)attributes.get("txPower");

		if (txPower != null) {
			setTxPower(txPower);
		}

		Integer usPower = (Integer)attributes.get("usPower");

		if (usPower != null) {
			setUsPower(usPower);
		}

		Integer dsPower = (Integer)attributes.get("dsPower");

		if (dsPower != null) {
			setDsPower(dsPower);
		}

		Long uncorrectables = (Long)attributes.get("uncorrectables");

		if (uncorrectables != null) {
			setUncorrectables(uncorrectables);
		}

		Long correcteds = (Long)attributes.get("correcteds");

		if (correcteds != null) {
			setCorrecteds(correcteds);
		}

		Long unerroreds = (Long)attributes.get("unerroreds");

		if (unerroreds != null) {
			setUnerroreds(unerroreds);
		}

		Integer dsSNR = (Integer)attributes.get("dsSNR");

		if (dsSNR != null) {
			setDsSNR(dsSNR);
		}

		Integer usSNR = (Integer)attributes.get("usSNR");

		if (usSNR != null) {
			setUsSNR(usSNR);
		}

		Integer ucIfIndex = (Integer)attributes.get("ucIfIndex");

		if (ucIfIndex != null) {
			setUcIfIndex(ucIfIndex);
		}

		Integer dcIfIndex = (Integer)attributes.get("dcIfIndex");

		if (dcIfIndex != null) {
			setDcIfIndex(dcIfIndex);
		}

		String cmSubIndex = (String)attributes.get("cmSubIndex");

		if (cmSubIndex != null) {
			setCmSubIndex(cmSubIndex);
		}

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Integer cmIndex = (Integer)attributes.get("cmIndex");

		if (cmIndex != null) {
			setCmIndex(cmIndex);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this cable modem history.
	*
	* @return the primary key of this cable modem history
	*/
	@Override
	public com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK getPrimaryKey() {
		return _cableModemHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cable modem history.
	*
	* @param primaryKey the primary key of this cable modem history
	*/
	@Override
	public void setPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK primaryKey) {
		_cableModemHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mac address of this cable modem history.
	*
	* @return the mac address of this cable modem history
	*/
	@Override
	public java.lang.String getMacAddress() {
		return _cableModemHistory.getMacAddress();
	}

	/**
	* Sets the mac address of this cable modem history.
	*
	* @param macAddress the mac address of this cable modem history
	*/
	@Override
	public void setMacAddress(java.lang.String macAddress) {
		_cableModemHistory.setMacAddress(macAddress);
	}

	/**
	* Returns the create date of this cable modem history.
	*
	* @return the create date of this cable modem history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cableModemHistory.getCreateDate();
	}

	/**
	* Sets the create date of this cable modem history.
	*
	* @param createDate the create date of this cable modem history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cableModemHistory.setCreateDate(createDate);
	}

	/**
	* Returns the fec uncorrectable of this cable modem history.
	*
	* @return the fec uncorrectable of this cable modem history
	*/
	@Override
	public double getFecUncorrectable() {
		return _cableModemHistory.getFecUncorrectable();
	}

	/**
	* Sets the fec uncorrectable of this cable modem history.
	*
	* @param fecUncorrectable the fec uncorrectable of this cable modem history
	*/
	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_cableModemHistory.setFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the fec corrected of this cable modem history.
	*
	* @return the fec corrected of this cable modem history
	*/
	@Override
	public double getFecCorrected() {
		return _cableModemHistory.getFecCorrected();
	}

	/**
	* Sets the fec corrected of this cable modem history.
	*
	* @param fecCorrected the fec corrected of this cable modem history
	*/
	@Override
	public void setFecCorrected(double fecCorrected) {
		_cableModemHistory.setFecCorrected(fecCorrected);
	}

	/**
	* Returns the micro ref of this cable modem history.
	*
	* @return the micro ref of this cable modem history
	*/
	@Override
	public long getMicroRef() {
		return _cableModemHistory.getMicroRef();
	}

	/**
	* Sets the micro ref of this cable modem history.
	*
	* @param microRef the micro ref of this cable modem history
	*/
	@Override
	public void setMicroRef(long microRef) {
		_cableModemHistory.setMicroRef(microRef);
	}

	/**
	* Returns the rx power of this cable modem history.
	*
	* @return the rx power of this cable modem history
	*/
	@Override
	public int getRxPower() {
		return _cableModemHistory.getRxPower();
	}

	/**
	* Sets the rx power of this cable modem history.
	*
	* @param rxPower the rx power of this cable modem history
	*/
	@Override
	public void setRxPower(int rxPower) {
		_cableModemHistory.setRxPower(rxPower);
	}

	/**
	* Returns the tx power of this cable modem history.
	*
	* @return the tx power of this cable modem history
	*/
	@Override
	public int getTxPower() {
		return _cableModemHistory.getTxPower();
	}

	/**
	* Sets the tx power of this cable modem history.
	*
	* @param txPower the tx power of this cable modem history
	*/
	@Override
	public void setTxPower(int txPower) {
		_cableModemHistory.setTxPower(txPower);
	}

	/**
	* Returns the us power of this cable modem history.
	*
	* @return the us power of this cable modem history
	*/
	@Override
	public int getUsPower() {
		return _cableModemHistory.getUsPower();
	}

	/**
	* Sets the us power of this cable modem history.
	*
	* @param usPower the us power of this cable modem history
	*/
	@Override
	public void setUsPower(int usPower) {
		_cableModemHistory.setUsPower(usPower);
	}

	/**
	* Returns the ds power of this cable modem history.
	*
	* @return the ds power of this cable modem history
	*/
	@Override
	public int getDsPower() {
		return _cableModemHistory.getDsPower();
	}

	/**
	* Sets the ds power of this cable modem history.
	*
	* @param dsPower the ds power of this cable modem history
	*/
	@Override
	public void setDsPower(int dsPower) {
		_cableModemHistory.setDsPower(dsPower);
	}

	/**
	* Returns the uncorrectables of this cable modem history.
	*
	* @return the uncorrectables of this cable modem history
	*/
	@Override
	public long getUncorrectables() {
		return _cableModemHistory.getUncorrectables();
	}

	/**
	* Sets the uncorrectables of this cable modem history.
	*
	* @param uncorrectables the uncorrectables of this cable modem history
	*/
	@Override
	public void setUncorrectables(long uncorrectables) {
		_cableModemHistory.setUncorrectables(uncorrectables);
	}

	/**
	* Returns the correcteds of this cable modem history.
	*
	* @return the correcteds of this cable modem history
	*/
	@Override
	public long getCorrecteds() {
		return _cableModemHistory.getCorrecteds();
	}

	/**
	* Sets the correcteds of this cable modem history.
	*
	* @param correcteds the correcteds of this cable modem history
	*/
	@Override
	public void setCorrecteds(long correcteds) {
		_cableModemHistory.setCorrecteds(correcteds);
	}

	/**
	* Returns the unerroreds of this cable modem history.
	*
	* @return the unerroreds of this cable modem history
	*/
	@Override
	public long getUnerroreds() {
		return _cableModemHistory.getUnerroreds();
	}

	/**
	* Sets the unerroreds of this cable modem history.
	*
	* @param unerroreds the unerroreds of this cable modem history
	*/
	@Override
	public void setUnerroreds(long unerroreds) {
		_cableModemHistory.setUnerroreds(unerroreds);
	}

	/**
	* Returns the ds s n r of this cable modem history.
	*
	* @return the ds s n r of this cable modem history
	*/
	@Override
	public int getDsSNR() {
		return _cableModemHistory.getDsSNR();
	}

	/**
	* Sets the ds s n r of this cable modem history.
	*
	* @param dsSNR the ds s n r of this cable modem history
	*/
	@Override
	public void setDsSNR(int dsSNR) {
		_cableModemHistory.setDsSNR(dsSNR);
	}

	/**
	* Returns the us s n r of this cable modem history.
	*
	* @return the us s n r of this cable modem history
	*/
	@Override
	public int getUsSNR() {
		return _cableModemHistory.getUsSNR();
	}

	/**
	* Sets the us s n r of this cable modem history.
	*
	* @param usSNR the us s n r of this cable modem history
	*/
	@Override
	public void setUsSNR(int usSNR) {
		_cableModemHistory.setUsSNR(usSNR);
	}

	/**
	* Returns the uc if index of this cable modem history.
	*
	* @return the uc if index of this cable modem history
	*/
	@Override
	public int getUcIfIndex() {
		return _cableModemHistory.getUcIfIndex();
	}

	/**
	* Sets the uc if index of this cable modem history.
	*
	* @param ucIfIndex the uc if index of this cable modem history
	*/
	@Override
	public void setUcIfIndex(int ucIfIndex) {
		_cableModemHistory.setUcIfIndex(ucIfIndex);
	}

	/**
	* Returns the dc if index of this cable modem history.
	*
	* @return the dc if index of this cable modem history
	*/
	@Override
	public int getDcIfIndex() {
		return _cableModemHistory.getDcIfIndex();
	}

	/**
	* Sets the dc if index of this cable modem history.
	*
	* @param dcIfIndex the dc if index of this cable modem history
	*/
	@Override
	public void setDcIfIndex(int dcIfIndex) {
		_cableModemHistory.setDcIfIndex(dcIfIndex);
	}

	/**
	* Returns the cm sub index of this cable modem history.
	*
	* @return the cm sub index of this cable modem history
	*/
	@Override
	public java.lang.String getCmSubIndex() {
		return _cableModemHistory.getCmSubIndex();
	}

	/**
	* Sets the cm sub index of this cable modem history.
	*
	* @param cmSubIndex the cm sub index of this cable modem history
	*/
	@Override
	public void setCmSubIndex(java.lang.String cmSubIndex) {
		_cableModemHistory.setCmSubIndex(cmSubIndex);
	}

	/**
	* Returns the cmts ID of this cable modem history.
	*
	* @return the cmts ID of this cable modem history
	*/
	@Override
	public long getCmtsId() {
		return _cableModemHistory.getCmtsId();
	}

	/**
	* Sets the cmts ID of this cable modem history.
	*
	* @param cmtsId the cmts ID of this cable modem history
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_cableModemHistory.setCmtsId(cmtsId);
	}

	/**
	* Returns the cm index of this cable modem history.
	*
	* @return the cm index of this cable modem history
	*/
	@Override
	public int getCmIndex() {
		return _cableModemHistory.getCmIndex();
	}

	/**
	* Sets the cm index of this cable modem history.
	*
	* @param cmIndex the cm index of this cable modem history
	*/
	@Override
	public void setCmIndex(int cmIndex) {
		_cableModemHistory.setCmIndex(cmIndex);
	}

	/**
	* Returns the status of this cable modem history.
	*
	* @return the status of this cable modem history
	*/
	@Override
	public int getStatus() {
		return _cableModemHistory.getStatus();
	}

	/**
	* Sets the status of this cable modem history.
	*
	* @param status the status of this cable modem history
	*/
	@Override
	public void setStatus(int status) {
		_cableModemHistory.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _cableModemHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cableModemHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cableModemHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cableModemHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cableModemHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cableModemHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cableModemHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cableModemHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cableModemHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cableModemHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cableModemHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CableModemHistoryWrapper((CableModemHistory)_cableModemHistory.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory) {
		return _cableModemHistory.compareTo(cableModemHistory);
	}

	@Override
	public int hashCode() {
		return _cableModemHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.CableModemHistory> toCacheModel() {
		return _cableModemHistory.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory toEscapedModel() {
		return new CableModemHistoryWrapper(_cableModemHistory.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory toUnescapedModel() {
		return new CableModemHistoryWrapper(_cableModemHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cableModemHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cableModemHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cableModemHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CableModemHistoryWrapper)) {
			return false;
		}

		CableModemHistoryWrapper cableModemHistoryWrapper = (CableModemHistoryWrapper)obj;

		if (Validator.equals(_cableModemHistory,
					cableModemHistoryWrapper._cableModemHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CableModemHistory getWrappedCableModemHistory() {
		return _cableModemHistory;
	}

	@Override
	public CableModemHistory getWrappedModel() {
		return _cableModemHistory;
	}

	@Override
	public void resetOriginalValues() {
		_cableModemHistory.resetOriginalValues();
	}

	private CableModemHistory _cableModemHistory;
}