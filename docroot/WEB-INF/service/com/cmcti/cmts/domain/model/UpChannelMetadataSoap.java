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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cmcti.cmts.domain.service.http.UpChannelMetadataServiceSoap}.
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.http.UpChannelMetadataServiceSoap
 * @generated
 */
public class UpChannelMetadataSoap implements Serializable {
	public static UpChannelMetadataSoap toSoapModel(UpChannelMetadata model) {
		UpChannelMetadataSoap soapModel = new UpChannelMetadataSoap();

		soapModel.setMetaId(model.getMetaId());
		soapModel.setCmtsId(model.getCmtsId());
		soapModel.setIfIndex(model.getIfIndex());
		soapModel.setDsFrequency(model.getDsFrequency());
		soapModel.setDsQam(model.getDsQam());

		return soapModel;
	}

	public static UpChannelMetadataSoap[] toSoapModels(
		UpChannelMetadata[] models) {
		UpChannelMetadataSoap[] soapModels = new UpChannelMetadataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UpChannelMetadataSoap[][] toSoapModels(
		UpChannelMetadata[][] models) {
		UpChannelMetadataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UpChannelMetadataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UpChannelMetadataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UpChannelMetadataSoap[] toSoapModels(
		List<UpChannelMetadata> models) {
		List<UpChannelMetadataSoap> soapModels = new ArrayList<UpChannelMetadataSoap>(models.size());

		for (UpChannelMetadata model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UpChannelMetadataSoap[soapModels.size()]);
	}

	public UpChannelMetadataSoap() {
	}

	public long getPrimaryKey() {
		return _metaId;
	}

	public void setPrimaryKey(long pk) {
		setMetaId(pk);
	}

	public long getMetaId() {
		return _metaId;
	}

	public void setMetaId(long metaId) {
		_metaId = metaId;
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

	public String getDsFrequency() {
		return _dsFrequency;
	}

	public void setDsFrequency(String dsFrequency) {
		_dsFrequency = dsFrequency;
	}

	public String getDsQam() {
		return _dsQam;
	}

	public void setDsQam(String dsQam) {
		_dsQam = dsQam;
	}

	private long _metaId;
	private long _cmtsId;
	private int _ifIndex;
	private String _dsFrequency;
	private String _dsQam;
}