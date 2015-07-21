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
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.MerchantScopeServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.MerchantScopeServiceSoap
 * @generated
 */
public class MerchantScopeSoap implements Serializable {
	public static MerchantScopeSoap toSoapModel(MerchantScope model) {
		MerchantScopeSoap soapModel = new MerchantScopeSoap();

		soapModel.setMerchantScopeId(model.getMerchantScopeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCmtsId(model.getCmtsId());
		soapModel.setIfIndex(model.getIfIndex());
		soapModel.setMerchantCode(model.getMerchantCode());

		return soapModel;
	}

	public static MerchantScopeSoap[] toSoapModels(MerchantScope[] models) {
		MerchantScopeSoap[] soapModels = new MerchantScopeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MerchantScopeSoap[][] toSoapModels(MerchantScope[][] models) {
		MerchantScopeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MerchantScopeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MerchantScopeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MerchantScopeSoap[] toSoapModels(List<MerchantScope> models) {
		List<MerchantScopeSoap> soapModels = new ArrayList<MerchantScopeSoap>(models.size());

		for (MerchantScope model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MerchantScopeSoap[soapModels.size()]);
	}

	public MerchantScopeSoap() {
	}

	public long getPrimaryKey() {
		return _merchantScopeId;
	}

	public void setPrimaryKey(long pk) {
		setMerchantScopeId(pk);
	}

	public long getMerchantScopeId() {
		return _merchantScopeId;
	}

	public void setMerchantScopeId(long merchantScopeId) {
		_merchantScopeId = merchantScopeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getCmtsId() {
		return _cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;
	}

	public int getIfIndex() {
		return _ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;
	}

	public String getMerchantCode() {
		return _merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		_merchantCode = merchantCode;
	}

	private long _merchantScopeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cmtsId;
	private int _ifIndex;
	private String _merchantCode;
}