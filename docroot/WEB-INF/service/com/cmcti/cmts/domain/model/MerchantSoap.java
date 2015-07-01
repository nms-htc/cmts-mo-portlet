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
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.MerchantServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.MerchantServiceSoap
 * @generated
 */
public class MerchantSoap implements Serializable {
	public static MerchantSoap toSoapModel(Merchant model) {
		MerchantSoap soapModel = new MerchantSoap();

		soapModel.setMerchantId(model.getMerchantId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setCode(model.getCode());
		soapModel.setParentId(model.getParentId());
		soapModel.setParentCode(model.getParentCode());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static MerchantSoap[] toSoapModels(Merchant[] models) {
		MerchantSoap[] soapModels = new MerchantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MerchantSoap[][] toSoapModels(Merchant[][] models) {
		MerchantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MerchantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MerchantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MerchantSoap[] toSoapModels(List<Merchant> models) {
		List<MerchantSoap> soapModels = new ArrayList<MerchantSoap>(models.size());

		for (Merchant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MerchantSoap[soapModels.size()]);
	}

	public MerchantSoap() {
	}

	public long getPrimaryKey() {
		return _merchantId;
	}

	public void setPrimaryKey(long pk) {
		setMerchantId(pk);
	}

	public long getMerchantId() {
		return _merchantId;
	}

	public void setMerchantId(long merchantId) {
		_merchantId = merchantId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getParentCode() {
		return _parentCode;
	}

	public void setParentCode(String parentCode) {
		_parentCode = parentCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _merchantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _code;
	private long _parentId;
	private String _parentCode;
	private String _description;
}