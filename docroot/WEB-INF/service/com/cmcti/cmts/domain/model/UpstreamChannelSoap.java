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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.UpstreamChannelServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.UpstreamChannelServiceSoap
 * @generated
 */
public class UpstreamChannelSoap implements Serializable {
	public static UpstreamChannelSoap toSoapModel(UpstreamChannel model) {
		UpstreamChannelSoap soapModel = new UpstreamChannelSoap();

		soapModel.setIfIndex(model.getIfIndex());
		soapModel.setCmtsId(model.getCmtsId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQam(model.getQam());
		soapModel.setAvgOnlineCmDsPower(model.getAvgOnlineCmDsPower());
		soapModel.setAvgOnlineCmUsPower(model.getAvgOnlineCmUsPower());
		soapModel.setAvgOnlineCmMicRef(model.getAvgOnlineCmMicRef());
		soapModel.setAvgOnlineCmDsSNR(model.getAvgOnlineCmDsSNR());
		soapModel.setAvgOnlineCmTxPower(model.getAvgOnlineCmTxPower());
		soapModel.setAvgOnlineCmRxPower(model.getAvgOnlineCmRxPower());
		soapModel.setFecUncorrectable(model.getFecUncorrectable());
		soapModel.setFecCorrected(model.getFecCorrected());
		soapModel.setUpChannelCmTotal(model.getUpChannelCmTotal());
		soapModel.setUpChannelCmRegistered(model.getUpChannelCmRegistered());
		soapModel.setUpChannelCmActive(model.getUpChannelCmActive());
		soapModel.setUpChannelModProfile(model.getUpChannelModProfile());
		soapModel.setUpChannelWidth(model.getUpChannelWidth());
		soapModel.setUpChannelFrequency(model.getUpChannelFrequency());
		soapModel.setIfSigQUncorrectables(model.getIfSigQUncorrectables());
		soapModel.setIfSigQCorrecteds(model.getIfSigQCorrecteds());
		soapModel.setIfSigQUnerroreds(model.getIfSigQUnerroreds());
		soapModel.setIfSigQSNR(model.getIfSigQSNR());
		soapModel.setIfAlias(model.getIfAlias());
		soapModel.setIfDesc(model.getIfDesc());

		return soapModel;
	}

	public static UpstreamChannelSoap[] toSoapModels(UpstreamChannel[] models) {
		UpstreamChannelSoap[] soapModels = new UpstreamChannelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UpstreamChannelSoap[][] toSoapModels(
		UpstreamChannel[][] models) {
		UpstreamChannelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UpstreamChannelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UpstreamChannelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UpstreamChannelSoap[] toSoapModels(
		List<UpstreamChannel> models) {
		List<UpstreamChannelSoap> soapModels = new ArrayList<UpstreamChannelSoap>(models.size());

		for (UpstreamChannel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UpstreamChannelSoap[soapModels.size()]);
	}

	public UpstreamChannelSoap() {
	}

	public UpstreamChannelPK getPrimaryKey() {
		return new UpstreamChannelPK(_ifIndex, _cmtsId);
	}

	public void setPrimaryKey(UpstreamChannelPK pk) {
		setIfIndex(pk.ifIndex);
		setCmtsId(pk.cmtsId);
	}

	public int getIfIndex() {
		return _ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;
	}

	public long getCmtsId() {
		return _cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getQam() {
		return _qam;
	}

	public void setQam(String qam) {
		_qam = qam;
	}

	public double getAvgOnlineCmDsPower() {
		return _avgOnlineCmDsPower;
	}

	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower) {
		_avgOnlineCmDsPower = avgOnlineCmDsPower;
	}

	public double getAvgOnlineCmUsPower() {
		return _avgOnlineCmUsPower;
	}

	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower) {
		_avgOnlineCmUsPower = avgOnlineCmUsPower;
	}

	public double getAvgOnlineCmMicRef() {
		return _avgOnlineCmMicRef;
	}

	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef) {
		_avgOnlineCmMicRef = avgOnlineCmMicRef;
	}

	public double getAvgOnlineCmDsSNR() {
		return _avgOnlineCmDsSNR;
	}

	public void setAvgOnlineCmDsSNR(double avgOnlineCmDsSNR) {
		_avgOnlineCmDsSNR = avgOnlineCmDsSNR;
	}

	public double getAvgOnlineCmTxPower() {
		return _avgOnlineCmTxPower;
	}

	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_avgOnlineCmTxPower = avgOnlineCmTxPower;
	}

	public double getAvgOnlineCmRxPower() {
		return _avgOnlineCmRxPower;
	}

	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_avgOnlineCmRxPower = avgOnlineCmRxPower;
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

	public int getUpChannelCmTotal() {
		return _upChannelCmTotal;
	}

	public void setUpChannelCmTotal(int upChannelCmTotal) {
		_upChannelCmTotal = upChannelCmTotal;
	}

	public int getUpChannelCmRegistered() {
		return _upChannelCmRegistered;
	}

	public void setUpChannelCmRegistered(int upChannelCmRegistered) {
		_upChannelCmRegistered = upChannelCmRegistered;
	}

	public int getUpChannelCmActive() {
		return _upChannelCmActive;
	}

	public void setUpChannelCmActive(int upChannelCmActive) {
		_upChannelCmActive = upChannelCmActive;
	}

	public int getUpChannelModProfile() {
		return _upChannelModProfile;
	}

	public void setUpChannelModProfile(int upChannelModProfile) {
		_upChannelModProfile = upChannelModProfile;
	}

	public long getUpChannelWidth() {
		return _upChannelWidth;
	}

	public void setUpChannelWidth(long upChannelWidth) {
		_upChannelWidth = upChannelWidth;
	}

	public long getUpChannelFrequency() {
		return _upChannelFrequency;
	}

	public void setUpChannelFrequency(long upChannelFrequency) {
		_upChannelFrequency = upChannelFrequency;
	}

	public long getIfSigQUncorrectables() {
		return _ifSigQUncorrectables;
	}

	public void setIfSigQUncorrectables(long ifSigQUncorrectables) {
		_ifSigQUncorrectables = ifSigQUncorrectables;
	}

	public long getIfSigQCorrecteds() {
		return _ifSigQCorrecteds;
	}

	public void setIfSigQCorrecteds(long ifSigQCorrecteds) {
		_ifSigQCorrecteds = ifSigQCorrecteds;
	}

	public long getIfSigQUnerroreds() {
		return _ifSigQUnerroreds;
	}

	public void setIfSigQUnerroreds(long ifSigQUnerroreds) {
		_ifSigQUnerroreds = ifSigQUnerroreds;
	}

	public double getIfSigQSNR() {
		return _ifSigQSNR;
	}

	public void setIfSigQSNR(double ifSigQSNR) {
		_ifSigQSNR = ifSigQSNR;
	}

	public String getIfAlias() {
		return _ifAlias;
	}

	public void setIfAlias(String ifAlias) {
		_ifAlias = ifAlias;
	}

	public String getIfDesc() {
		return _ifDesc;
	}

	public void setIfDesc(String ifDesc) {
		_ifDesc = ifDesc;
	}

	private int _ifIndex;
	private long _cmtsId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _qam;
	private double _avgOnlineCmDsPower;
	private double _avgOnlineCmUsPower;
	private double _avgOnlineCmMicRef;
	private double _avgOnlineCmDsSNR;
	private double _avgOnlineCmTxPower;
	private double _avgOnlineCmRxPower;
	private double _fecUncorrectable;
	private double _fecCorrected;
	private int _upChannelCmTotal;
	private int _upChannelCmRegistered;
	private int _upChannelCmActive;
	private int _upChannelModProfile;
	private long _upChannelWidth;
	private long _upChannelFrequency;
	private long _ifSigQUncorrectables;
	private long _ifSigQCorrecteds;
	private long _ifSigQUnerroreds;
	private double _ifSigQSNR;
	private String _ifAlias;
	private String _ifDesc;
}