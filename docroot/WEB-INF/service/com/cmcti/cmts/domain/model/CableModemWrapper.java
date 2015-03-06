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
 * This class is a wrapper for {@link CableModem}.
 * </p>
 *
 * @author richard
 * @see CableModem
 * @generated
 */
public class CableModemWrapper implements CableModem, ModelWrapper<CableModem> {
	public CableModemWrapper(CableModem cableModem) {
		_cableModem = cableModem;
	}

	@Override
	public Class<?> getModelClass() {
		return CableModem.class;
	}

	@Override
	public String getModelClassName() {
		return CableModem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("macAddress", getMacAddress());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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
	}

	/**
	* Returns the primary key of this cable modem.
	*
	* @return the primary key of this cable modem
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _cableModem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cable modem.
	*
	* @param primaryKey the primary key of this cable modem
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_cableModem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mac address of this cable modem.
	*
	* @return the mac address of this cable modem
	*/
	@Override
	public java.lang.String getMacAddress() {
		return _cableModem.getMacAddress();
	}

	/**
	* Sets the mac address of this cable modem.
	*
	* @param macAddress the mac address of this cable modem
	*/
	@Override
	public void setMacAddress(java.lang.String macAddress) {
		_cableModem.setMacAddress(macAddress);
	}

	/**
	* Returns the create date of this cable modem.
	*
	* @return the create date of this cable modem
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cableModem.getCreateDate();
	}

	/**
	* Sets the create date of this cable modem.
	*
	* @param createDate the create date of this cable modem
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cableModem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this cable modem.
	*
	* @return the modified date of this cable modem
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cableModem.getModifiedDate();
	}

	/**
	* Sets the modified date of this cable modem.
	*
	* @param modifiedDate the modified date of this cable modem
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cableModem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fec uncorrectable of this cable modem.
	*
	* @return the fec uncorrectable of this cable modem
	*/
	@Override
	public double getFecUncorrectable() {
		return _cableModem.getFecUncorrectable();
	}

	/**
	* Sets the fec uncorrectable of this cable modem.
	*
	* @param fecUncorrectable the fec uncorrectable of this cable modem
	*/
	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_cableModem.setFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the fec corrected of this cable modem.
	*
	* @return the fec corrected of this cable modem
	*/
	@Override
	public double getFecCorrected() {
		return _cableModem.getFecCorrected();
	}

	/**
	* Sets the fec corrected of this cable modem.
	*
	* @param fecCorrected the fec corrected of this cable modem
	*/
	@Override
	public void setFecCorrected(double fecCorrected) {
		_cableModem.setFecCorrected(fecCorrected);
	}

	/**
	* Returns the micro ref of this cable modem.
	*
	* @return the micro ref of this cable modem
	*/
	@Override
	public long getMicroRef() {
		return _cableModem.getMicroRef();
	}

	/**
	* Sets the micro ref of this cable modem.
	*
	* @param microRef the micro ref of this cable modem
	*/
	@Override
	public void setMicroRef(long microRef) {
		_cableModem.setMicroRef(microRef);
	}

	/**
	* Returns the rx power of this cable modem.
	*
	* @return the rx power of this cable modem
	*/
	@Override
	public int getRxPower() {
		return _cableModem.getRxPower();
	}

	/**
	* Sets the rx power of this cable modem.
	*
	* @param rxPower the rx power of this cable modem
	*/
	@Override
	public void setRxPower(int rxPower) {
		_cableModem.setRxPower(rxPower);
	}

	/**
	* Returns the tx power of this cable modem.
	*
	* @return the tx power of this cable modem
	*/
	@Override
	public int getTxPower() {
		return _cableModem.getTxPower();
	}

	/**
	* Sets the tx power of this cable modem.
	*
	* @param txPower the tx power of this cable modem
	*/
	@Override
	public void setTxPower(int txPower) {
		_cableModem.setTxPower(txPower);
	}

	/**
	* Returns the us power of this cable modem.
	*
	* @return the us power of this cable modem
	*/
	@Override
	public int getUsPower() {
		return _cableModem.getUsPower();
	}

	/**
	* Sets the us power of this cable modem.
	*
	* @param usPower the us power of this cable modem
	*/
	@Override
	public void setUsPower(int usPower) {
		_cableModem.setUsPower(usPower);
	}

	/**
	* Returns the ds power of this cable modem.
	*
	* @return the ds power of this cable modem
	*/
	@Override
	public int getDsPower() {
		return _cableModem.getDsPower();
	}

	/**
	* Sets the ds power of this cable modem.
	*
	* @param dsPower the ds power of this cable modem
	*/
	@Override
	public void setDsPower(int dsPower) {
		_cableModem.setDsPower(dsPower);
	}

	/**
	* Returns the uncorrectables of this cable modem.
	*
	* @return the uncorrectables of this cable modem
	*/
	@Override
	public long getUncorrectables() {
		return _cableModem.getUncorrectables();
	}

	/**
	* Sets the uncorrectables of this cable modem.
	*
	* @param uncorrectables the uncorrectables of this cable modem
	*/
	@Override
	public void setUncorrectables(long uncorrectables) {
		_cableModem.setUncorrectables(uncorrectables);
	}

	/**
	* Returns the correcteds of this cable modem.
	*
	* @return the correcteds of this cable modem
	*/
	@Override
	public long getCorrecteds() {
		return _cableModem.getCorrecteds();
	}

	/**
	* Sets the correcteds of this cable modem.
	*
	* @param correcteds the correcteds of this cable modem
	*/
	@Override
	public void setCorrecteds(long correcteds) {
		_cableModem.setCorrecteds(correcteds);
	}

	/**
	* Returns the unerroreds of this cable modem.
	*
	* @return the unerroreds of this cable modem
	*/
	@Override
	public long getUnerroreds() {
		return _cableModem.getUnerroreds();
	}

	/**
	* Sets the unerroreds of this cable modem.
	*
	* @param unerroreds the unerroreds of this cable modem
	*/
	@Override
	public void setUnerroreds(long unerroreds) {
		_cableModem.setUnerroreds(unerroreds);
	}

	/**
	* Returns the ds s n r of this cable modem.
	*
	* @return the ds s n r of this cable modem
	*/
	@Override
	public int getDsSNR() {
		return _cableModem.getDsSNR();
	}

	/**
	* Sets the ds s n r of this cable modem.
	*
	* @param dsSNR the ds s n r of this cable modem
	*/
	@Override
	public void setDsSNR(int dsSNR) {
		_cableModem.setDsSNR(dsSNR);
	}

	/**
	* Returns the us s n r of this cable modem.
	*
	* @return the us s n r of this cable modem
	*/
	@Override
	public int getUsSNR() {
		return _cableModem.getUsSNR();
	}

	/**
	* Sets the us s n r of this cable modem.
	*
	* @param usSNR the us s n r of this cable modem
	*/
	@Override
	public void setUsSNR(int usSNR) {
		_cableModem.setUsSNR(usSNR);
	}

	/**
	* Returns the uc if index of this cable modem.
	*
	* @return the uc if index of this cable modem
	*/
	@Override
	public int getUcIfIndex() {
		return _cableModem.getUcIfIndex();
	}

	/**
	* Sets the uc if index of this cable modem.
	*
	* @param ucIfIndex the uc if index of this cable modem
	*/
	@Override
	public void setUcIfIndex(int ucIfIndex) {
		_cableModem.setUcIfIndex(ucIfIndex);
	}

	/**
	* Returns the dc if index of this cable modem.
	*
	* @return the dc if index of this cable modem
	*/
	@Override
	public int getDcIfIndex() {
		return _cableModem.getDcIfIndex();
	}

	/**
	* Sets the dc if index of this cable modem.
	*
	* @param dcIfIndex the dc if index of this cable modem
	*/
	@Override
	public void setDcIfIndex(int dcIfIndex) {
		_cableModem.setDcIfIndex(dcIfIndex);
	}

	/**
	* Returns the cm sub index of this cable modem.
	*
	* @return the cm sub index of this cable modem
	*/
	@Override
	public java.lang.String getCmSubIndex() {
		return _cableModem.getCmSubIndex();
	}

	/**
	* Sets the cm sub index of this cable modem.
	*
	* @param cmSubIndex the cm sub index of this cable modem
	*/
	@Override
	public void setCmSubIndex(java.lang.String cmSubIndex) {
		_cableModem.setCmSubIndex(cmSubIndex);
	}

	/**
	* Returns the cmts ID of this cable modem.
	*
	* @return the cmts ID of this cable modem
	*/
	@Override
	public long getCmtsId() {
		return _cableModem.getCmtsId();
	}

	/**
	* Sets the cmts ID of this cable modem.
	*
	* @param cmtsId the cmts ID of this cable modem
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_cableModem.setCmtsId(cmtsId);
	}

	/**
	* Returns the cm index of this cable modem.
	*
	* @return the cm index of this cable modem
	*/
	@Override
	public int getCmIndex() {
		return _cableModem.getCmIndex();
	}

	/**
	* Sets the cm index of this cable modem.
	*
	* @param cmIndex the cm index of this cable modem
	*/
	@Override
	public void setCmIndex(int cmIndex) {
		_cableModem.setCmIndex(cmIndex);
	}

	@Override
	public boolean isNew() {
		return _cableModem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cableModem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cableModem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cableModem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cableModem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cableModem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cableModem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cableModem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cableModem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cableModem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cableModem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CableModemWrapper((CableModem)_cableModem.clone());
	}

	@Override
	public int compareTo(com.cmcti.cmts.domain.model.CableModem cableModem) {
		return _cableModem.compareTo(cableModem);
	}

	@Override
	public int hashCode() {
		return _cableModem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.CableModem> toCacheModel() {
		return _cableModem.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModem toEscapedModel() {
		return new CableModemWrapper(_cableModem.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModem toUnescapedModel() {
		return new CableModemWrapper(_cableModem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cableModem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cableModem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cableModem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CableModemWrapper)) {
			return false;
		}

		CableModemWrapper cableModemWrapper = (CableModemWrapper)obj;

		if (Validator.equals(_cableModem, cableModemWrapper._cableModem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CableModem getWrappedCableModem() {
		return _cableModem;
	}

	@Override
	public CableModem getWrappedModel() {
		return _cableModem;
	}

	@Override
	public void resetOriginalValues() {
		_cableModem.resetOriginalValues();
	}

	private CableModem _cableModem;
}