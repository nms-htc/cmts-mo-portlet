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
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.OptionServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.OptionServiceSoap
 * @generated
 */
public class OptionSoap implements Serializable {
	public static OptionSoap toSoapModel(Option model) {
		OptionSoap soapModel = new OptionSoap();

		soapModel.setOptionId(model.getOptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOptionType(model.getOptionType());
		soapModel.setOptionKey(model.getOptionKey());
		soapModel.setOptionValue(model.getOptionValue());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static OptionSoap[] toSoapModels(Option[] models) {
		OptionSoap[] soapModels = new OptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OptionSoap[][] toSoapModels(Option[][] models) {
		OptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OptionSoap[] toSoapModels(List<Option> models) {
		List<OptionSoap> soapModels = new ArrayList<OptionSoap>(models.size());

		for (Option model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OptionSoap[soapModels.size()]);
	}

	public OptionSoap() {
	}

	public long getPrimaryKey() {
		return _optionId;
	}

	public void setPrimaryKey(long pk) {
		setOptionId(pk);
	}

	public long getOptionId() {
		return _optionId;
	}

	public void setOptionId(long optionId) {
		_optionId = optionId;
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

	public String getOptionType() {
		return _optionType;
	}

	public void setOptionType(String optionType) {
		_optionType = optionType;
	}

	public String getOptionKey() {
		return _optionKey;
	}

	public void setOptionKey(String optionKey) {
		_optionKey = optionKey;
	}

	public String getOptionValue() {
		return _optionValue;
	}

	public void setOptionValue(String optionValue) {
		_optionValue = optionValue;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _optionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _optionType;
	private String _optionKey;
	private String _optionValue;
	private String _description;
}