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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.CableModemHistoryServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.CableModemHistoryServiceSoap
 * @generated
 */
public class CableModemHistorySoap implements Serializable {
	public static CableModemHistorySoap toSoapModel(CableModemHistory model) {
		CableModemHistorySoap soapModel = new CableModemHistorySoap();

		soapModel.setCmHisId(model.getCmHisId());
		soapModel.setMacAddress(model.getMacAddress());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setFecUncorrectable(model.getFecUncorrectable());
		soapModel.setFecCorrected(model.getFecCorrected());
		soapModel.setMicroRef(model.getMicroRef());
		soapModel.setRxPower(model.getRxPower());
		soapModel.setTxPower(model.getTxPower());
		soapModel.setUsPower(model.getUsPower());
		soapModel.setDsPower(model.getDsPower());
		soapModel.setUncorrectables(model.getUncorrectables());
		soapModel.setCorrecteds(model.getCorrecteds());
		soapModel.setUnerroreds(model.getUnerroreds());
		soapModel.setDsSNR(model.getDsSNR());
		soapModel.setUsSNR(model.getUsSNR());
		soapModel.setUcIfIndex(model.getUcIfIndex());
		soapModel.setDcIfIndex(model.getDcIfIndex());
		soapModel.setCmSubIndex(model.getCmSubIndex());
		soapModel.setCmtsId(model.getCmtsId());
		soapModel.setCmIndex(model.getCmIndex());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CableModemHistorySoap[] toSoapModels(
		CableModemHistory[] models) {
		CableModemHistorySoap[] soapModels = new CableModemHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CableModemHistorySoap[][] toSoapModels(
		CableModemHistory[][] models) {
		CableModemHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CableModemHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CableModemHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CableModemHistorySoap[] toSoapModels(
		List<CableModemHistory> models) {
		List<CableModemHistorySoap> soapModels = new ArrayList<CableModemHistorySoap>(models.size());

		for (CableModemHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CableModemHistorySoap[soapModels.size()]);
	}

	public CableModemHistorySoap() {
	}

	public long getPrimaryKey() {
		return _cmHisId;
	}

	public void setPrimaryKey(long pk) {
		setCmHisId(pk);
	}

	public long getCmHisId() {
		return _cmHisId;
	}

	public void setCmHisId(long cmHisId) {
		_cmHisId = cmHisId;
	}

	public String getMacAddress() {
		return _macAddress;
	}

	public void setMacAddress(String macAddress) {
		_macAddress = macAddress;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public double getFecUncorrectable() {
		return _fecUncorrectable;
	}

	public void setFecUncorrectable(double fecUncorrectable) {
		_fecUncorrectable = fecUncorrectable;
	}

	public double getFecCorrected() {
		return _fecCorrected;
	}

	public void setFecCorrected(double fecCorrected) {
		_fecCorrected = fecCorrected;
	}

	public long getMicroRef() {
		return _microRef;
	}

	public void setMicroRef(long microRef) {
		_microRef = microRef;
	}

	public int getRxPower() {
		return _rxPower;
	}

	public void setRxPower(int rxPower) {
		_rxPower = rxPower;
	}

	public int getTxPower() {
		return _txPower;
	}

	public void setTxPower(int txPower) {
		_txPower = txPower;
	}

	public int getUsPower() {
		return _usPower;
	}

	public void setUsPower(int usPower) {
		_usPower = usPower;
	}

	public int getDsPower() {
		return _dsPower;
	}

	public void setDsPower(int dsPower) {
		_dsPower = dsPower;
	}

	public long getUncorrectables() {
		return _uncorrectables;
	}

	public void setUncorrectables(long uncorrectables) {
		_uncorrectables = uncorrectables;
	}

	public long getCorrecteds() {
		return _correcteds;
	}

	public void setCorrecteds(long correcteds) {
		_correcteds = correcteds;
	}

	public long getUnerroreds() {
		return _unerroreds;
	}

	public void setUnerroreds(long unerroreds) {
		_unerroreds = unerroreds;
	}

	public int getDsSNR() {
		return _dsSNR;
	}

	public void setDsSNR(int dsSNR) {
		_dsSNR = dsSNR;
	}

	public int getUsSNR() {
		return _usSNR;
	}

	public void setUsSNR(int usSNR) {
		_usSNR = usSNR;
	}

	public int getUcIfIndex() {
		return _ucIfIndex;
	}

	public void setUcIfIndex(int ucIfIndex) {
		_ucIfIndex = ucIfIndex;
	}

	public int getDcIfIndex() {
		return _dcIfIndex;
	}

	public void setDcIfIndex(int dcIfIndex) {
		_dcIfIndex = dcIfIndex;
	}

	public String getCmSubIndex() {
		return _cmSubIndex;
	}

	public void setCmSubIndex(String cmSubIndex) {
		_cmSubIndex = cmSubIndex;
	}

	public long getCmtsId() {
		return _cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;
	}

	public int getCmIndex() {
		return _cmIndex;
	}

	public void setCmIndex(int cmIndex) {
		_cmIndex = cmIndex;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _cmHisId;
	private String _macAddress;
	private Date _createDate;
	private double _fecUncorrectable;
	private double _fecCorrected;
	private long _microRef;
	private int _rxPower;
	private int _txPower;
	private int _usPower;
	private int _dsPower;
	private long _uncorrectables;
	private long _correcteds;
	private long _unerroreds;
	private int _dsSNR;
	private int _usSNR;
	private int _ucIfIndex;
	private int _dcIfIndex;
	private String _cmSubIndex;
	private long _cmtsId;
	private int _cmIndex;
	private int _status;
}