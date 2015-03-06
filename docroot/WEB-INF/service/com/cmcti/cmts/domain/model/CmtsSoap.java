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
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.CmtsServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.CmtsServiceSoap
 * @generated
 */
public class CmtsSoap implements Serializable {
	public static CmtsSoap toSoapModel(Cmts model) {
		CmtsSoap soapModel = new CmtsSoap();

		soapModel.setCmtsId(model.getCmtsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEnable(model.getEnable());
		soapModel.setTitle(model.getTitle());
		soapModel.setHost(model.getHost());
		soapModel.setCommunity(model.getCommunity());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static CmtsSoap[] toSoapModels(Cmts[] models) {
		CmtsSoap[] soapModels = new CmtsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CmtsSoap[][] toSoapModels(Cmts[][] models) {
		CmtsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CmtsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CmtsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CmtsSoap[] toSoapModels(List<Cmts> models) {
		List<CmtsSoap> soapModels = new ArrayList<CmtsSoap>(models.size());

		for (Cmts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CmtsSoap[soapModels.size()]);
	}

	public CmtsSoap() {
	}

	public long getPrimaryKey() {
		return _cmtsId;
	}

	public void setPrimaryKey(long pk) {
		setCmtsId(pk);
	}

	public long getCmtsId() {
		return _cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;
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

	public boolean getEnable() {
		return _enable;
	}

	public boolean isEnable() {
		return _enable;
	}

	public void setEnable(boolean enable) {
		_enable = enable;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getHost() {
		return _host;
	}

	public void setHost(String host) {
		_host = host;
	}

	public String getCommunity() {
		return _community;
	}

	public void setCommunity(String community) {
		_community = community;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _cmtsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _enable;
	private String _title;
	private String _host;
	private String _community;
	private String _description;
}