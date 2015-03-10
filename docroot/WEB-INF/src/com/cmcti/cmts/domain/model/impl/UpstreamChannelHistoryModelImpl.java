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

package com.cmcti.cmts.domain.model.impl;

import com.cmcti.cmts.domain.model.UpstreamChannelHistory;
import com.cmcti.cmts.domain.model.UpstreamChannelHistoryModel;
import com.cmcti.cmts.domain.model.UpstreamChannelHistorySoap;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UpstreamChannelHistory service. Represents a row in the &quot;CMTS_MONITOR_UpstreamChannelHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmcti.cmts.domain.model.UpstreamChannelHistoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UpstreamChannelHistoryImpl}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannelHistoryImpl
 * @see com.cmcti.cmts.domain.model.UpstreamChannelHistory
 * @see com.cmcti.cmts.domain.model.UpstreamChannelHistoryModel
 * @generated
 */
@JSON(strict = true)
public class UpstreamChannelHistoryModelImpl extends BaseModelImpl<UpstreamChannelHistory>
	implements UpstreamChannelHistoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a upstream channel history model instance should use the {@link com.cmcti.cmts.domain.model.UpstreamChannelHistory} interface instead.
	 */
	public static final String TABLE_NAME = "CMTS_MONITOR_UpstreamChannelHistory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cmtsId", Types.BIGINT },
			{ "ifIndex", Types.INTEGER },
			{ "createDate", Types.TIMESTAMP },
			{ "qam", Types.VARCHAR },
			{ "avgOnlineCmDsPower", Types.DOUBLE },
			{ "avgOnlineCmUsPower", Types.DOUBLE },
			{ "avgOnlineCmMicRef", Types.DOUBLE },
			{ "avgOnlineCmTxPower", Types.DOUBLE },
			{ "avgOnlineCmRxPower", Types.DOUBLE },
			{ "fecUncorrectable", Types.DOUBLE },
			{ "fecCorrected", Types.DOUBLE },
			{ "upChannelCmTotal", Types.INTEGER },
			{ "upChannelCmRegistered", Types.INTEGER },
			{ "upChannelCmActive", Types.INTEGER },
			{ "upChannelModProfile", Types.INTEGER },
			{ "upChannelWidth", Types.BIGINT },
			{ "upChannelFrequency", Types.BIGINT },
			{ "ifSigQUncorrectables", Types.BIGINT },
			{ "ifSigQCorrecteds", Types.BIGINT },
			{ "ifSigQUnerroreds", Types.BIGINT },
			{ "ifSigQSNR", Types.DOUBLE },
			{ "ifAlias", Types.VARCHAR },
			{ "ifDesc", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CMTS_MONITOR_UpstreamChannelHistory (cmtsId LONG not null,ifIndex INTEGER not null,createDate DATE not null,qam VARCHAR(75) null,avgOnlineCmDsPower DOUBLE,avgOnlineCmUsPower DOUBLE,avgOnlineCmMicRef DOUBLE,avgOnlineCmTxPower DOUBLE,avgOnlineCmRxPower DOUBLE,fecUncorrectable DOUBLE,fecCorrected DOUBLE,upChannelCmTotal INTEGER,upChannelCmRegistered INTEGER,upChannelCmActive INTEGER,upChannelModProfile INTEGER,upChannelWidth LONG,upChannelFrequency LONG,ifSigQUncorrectables LONG,ifSigQCorrecteds LONG,ifSigQUnerroreds LONG,ifSigQSNR DOUBLE,ifAlias VARCHAR(75) null,ifDesc VARCHAR(75) null,primary key (cmtsId, ifIndex, createDate))";
	public static final String TABLE_SQL_DROP = "drop table CMTS_MONITOR_UpstreamChannelHistory";
	public static final String ORDER_BY_JPQL = " ORDER BY upstreamChannelHistory.id.cmtsId ASC, upstreamChannelHistory.id.ifIndex ASC, upstreamChannelHistory.id.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CMTS_MONITOR_UpstreamChannelHistory.cmtsId ASC, CMTS_MONITOR_UpstreamChannelHistory.ifIndex ASC, CMTS_MONITOR_UpstreamChannelHistory.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmcti.cmts.domain.model.UpstreamChannelHistory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmcti.cmts.domain.model.UpstreamChannelHistory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UpstreamChannelHistory toModel(
		UpstreamChannelHistorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UpstreamChannelHistory model = new UpstreamChannelHistoryImpl();

		model.setCmtsId(soapModel.getCmtsId());
		model.setIfIndex(soapModel.getIfIndex());
		model.setCreateDate(soapModel.getCreateDate());
		model.setQam(soapModel.getQam());
		model.setAvgOnlineCmDsPower(soapModel.getAvgOnlineCmDsPower());
		model.setAvgOnlineCmUsPower(soapModel.getAvgOnlineCmUsPower());
		model.setAvgOnlineCmMicRef(soapModel.getAvgOnlineCmMicRef());
		model.setAvgOnlineCmTxPower(soapModel.getAvgOnlineCmTxPower());
		model.setAvgOnlineCmRxPower(soapModel.getAvgOnlineCmRxPower());
		model.setFecUncorrectable(soapModel.getFecUncorrectable());
		model.setFecCorrected(soapModel.getFecCorrected());
		model.setUpChannelCmTotal(soapModel.getUpChannelCmTotal());
		model.setUpChannelCmRegistered(soapModel.getUpChannelCmRegistered());
		model.setUpChannelCmActive(soapModel.getUpChannelCmActive());
		model.setUpChannelModProfile(soapModel.getUpChannelModProfile());
		model.setUpChannelWidth(soapModel.getUpChannelWidth());
		model.setUpChannelFrequency(soapModel.getUpChannelFrequency());
		model.setIfSigQUncorrectables(soapModel.getIfSigQUncorrectables());
		model.setIfSigQCorrecteds(soapModel.getIfSigQCorrecteds());
		model.setIfSigQUnerroreds(soapModel.getIfSigQUnerroreds());
		model.setIfSigQSNR(soapModel.getIfSigQSNR());
		model.setIfAlias(soapModel.getIfAlias());
		model.setIfDesc(soapModel.getIfDesc());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UpstreamChannelHistory> toModels(
		UpstreamChannelHistorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UpstreamChannelHistory> models = new ArrayList<UpstreamChannelHistory>(soapModels.length);

		for (UpstreamChannelHistorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmcti.cmts.domain.model.UpstreamChannelHistory"));

	public UpstreamChannelHistoryModelImpl() {
	}

	@Override
	public UpstreamChannelHistoryPK getPrimaryKey() {
		return new UpstreamChannelHistoryPK(_cmtsId, _ifIndex, _createDate);
	}

	@Override
	public void setPrimaryKey(UpstreamChannelHistoryPK primaryKey) {
		setCmtsId(primaryKey.cmtsId);
		setIfIndex(primaryKey.ifIndex);
		setCreateDate(primaryKey.createDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UpstreamChannelHistoryPK(_cmtsId, _ifIndex, _createDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UpstreamChannelHistoryPK)primaryKeyObj);
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

	@JSON
	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;
	}

	@JSON
	@Override
	public int getIfIndex() {
		return _ifIndex;
	}

	@Override
	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getQam() {
		if (_qam == null) {
			return StringPool.BLANK;
		}
		else {
			return _qam;
		}
	}

	@Override
	public void setQam(String qam) {
		_qam = qam;
	}

	@JSON
	@Override
	public double getAvgOnlineCmDsPower() {
		return _avgOnlineCmDsPower;
	}

	@Override
	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower) {
		_avgOnlineCmDsPower = avgOnlineCmDsPower;
	}

	@JSON
	@Override
	public double getAvgOnlineCmUsPower() {
		return _avgOnlineCmUsPower;
	}

	@Override
	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower) {
		_avgOnlineCmUsPower = avgOnlineCmUsPower;
	}

	@JSON
	@Override
	public double getAvgOnlineCmMicRef() {
		return _avgOnlineCmMicRef;
	}

	@Override
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef) {
		_avgOnlineCmMicRef = avgOnlineCmMicRef;
	}

	@JSON
	@Override
	public double getAvgOnlineCmTxPower() {
		return _avgOnlineCmTxPower;
	}

	@Override
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_avgOnlineCmTxPower = avgOnlineCmTxPower;
	}

	@JSON
	@Override
	public double getAvgOnlineCmRxPower() {
		return _avgOnlineCmRxPower;
	}

	@Override
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_avgOnlineCmRxPower = avgOnlineCmRxPower;
	}

	@JSON
	@Override
	public double getFecUncorrectable() {
		return _fecUncorrectable;
	}

	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_fecUncorrectable = fecUncorrectable;
	}

	@JSON
	@Override
	public double getFecCorrected() {
		return _fecCorrected;
	}

	@Override
	public void setFecCorrected(double fecCorrected) {
		_fecCorrected = fecCorrected;
	}

	@JSON
	@Override
	public int getUpChannelCmTotal() {
		return _upChannelCmTotal;
	}

	@Override
	public void setUpChannelCmTotal(int upChannelCmTotal) {
		_upChannelCmTotal = upChannelCmTotal;
	}

	@JSON
	@Override
	public int getUpChannelCmRegistered() {
		return _upChannelCmRegistered;
	}

	@Override
	public void setUpChannelCmRegistered(int upChannelCmRegistered) {
		_upChannelCmRegistered = upChannelCmRegistered;
	}

	@JSON
	@Override
	public int getUpChannelCmActive() {
		return _upChannelCmActive;
	}

	@Override
	public void setUpChannelCmActive(int upChannelCmActive) {
		_upChannelCmActive = upChannelCmActive;
	}

	@JSON
	@Override
	public int getUpChannelModProfile() {
		return _upChannelModProfile;
	}

	@Override
	public void setUpChannelModProfile(int upChannelModProfile) {
		_upChannelModProfile = upChannelModProfile;
	}

	@JSON
	@Override
	public long getUpChannelWidth() {
		return _upChannelWidth;
	}

	@Override
	public void setUpChannelWidth(long upChannelWidth) {
		_upChannelWidth = upChannelWidth;
	}

	@JSON
	@Override
	public long getUpChannelFrequency() {
		return _upChannelFrequency;
	}

	@Override
	public void setUpChannelFrequency(long upChannelFrequency) {
		_upChannelFrequency = upChannelFrequency;
	}

	@JSON
	@Override
	public long getIfSigQUncorrectables() {
		return _ifSigQUncorrectables;
	}

	@Override
	public void setIfSigQUncorrectables(long ifSigQUncorrectables) {
		_ifSigQUncorrectables = ifSigQUncorrectables;
	}

	@JSON
	@Override
	public long getIfSigQCorrecteds() {
		return _ifSigQCorrecteds;
	}

	@Override
	public void setIfSigQCorrecteds(long ifSigQCorrecteds) {
		_ifSigQCorrecteds = ifSigQCorrecteds;
	}

	@JSON
	@Override
	public long getIfSigQUnerroreds() {
		return _ifSigQUnerroreds;
	}

	@Override
	public void setIfSigQUnerroreds(long ifSigQUnerroreds) {
		_ifSigQUnerroreds = ifSigQUnerroreds;
	}

	@JSON
	@Override
	public double getIfSigQSNR() {
		return _ifSigQSNR;
	}

	@Override
	public void setIfSigQSNR(double ifSigQSNR) {
		_ifSigQSNR = ifSigQSNR;
	}

	@JSON
	@Override
	public String getIfAlias() {
		if (_ifAlias == null) {
			return StringPool.BLANK;
		}
		else {
			return _ifAlias;
		}
	}

	@Override
	public void setIfAlias(String ifAlias) {
		_ifAlias = ifAlias;
	}

	@JSON
	@Override
	public String getIfDesc() {
		if (_ifDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _ifDesc;
		}
	}

	@Override
	public void setIfDesc(String ifDesc) {
		_ifDesc = ifDesc;
	}

	@Override
	public UpstreamChannelHistory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UpstreamChannelHistory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UpstreamChannelHistoryImpl upstreamChannelHistoryImpl = new UpstreamChannelHistoryImpl();

		upstreamChannelHistoryImpl.setCmtsId(getCmtsId());
		upstreamChannelHistoryImpl.setIfIndex(getIfIndex());
		upstreamChannelHistoryImpl.setCreateDate(getCreateDate());
		upstreamChannelHistoryImpl.setQam(getQam());
		upstreamChannelHistoryImpl.setAvgOnlineCmDsPower(getAvgOnlineCmDsPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmUsPower(getAvgOnlineCmUsPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmMicRef(getAvgOnlineCmMicRef());
		upstreamChannelHistoryImpl.setAvgOnlineCmTxPower(getAvgOnlineCmTxPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmRxPower(getAvgOnlineCmRxPower());
		upstreamChannelHistoryImpl.setFecUncorrectable(getFecUncorrectable());
		upstreamChannelHistoryImpl.setFecCorrected(getFecCorrected());
		upstreamChannelHistoryImpl.setUpChannelCmTotal(getUpChannelCmTotal());
		upstreamChannelHistoryImpl.setUpChannelCmRegistered(getUpChannelCmRegistered());
		upstreamChannelHistoryImpl.setUpChannelCmActive(getUpChannelCmActive());
		upstreamChannelHistoryImpl.setUpChannelModProfile(getUpChannelModProfile());
		upstreamChannelHistoryImpl.setUpChannelWidth(getUpChannelWidth());
		upstreamChannelHistoryImpl.setUpChannelFrequency(getUpChannelFrequency());
		upstreamChannelHistoryImpl.setIfSigQUncorrectables(getIfSigQUncorrectables());
		upstreamChannelHistoryImpl.setIfSigQCorrecteds(getIfSigQCorrecteds());
		upstreamChannelHistoryImpl.setIfSigQUnerroreds(getIfSigQUnerroreds());
		upstreamChannelHistoryImpl.setIfSigQSNR(getIfSigQSNR());
		upstreamChannelHistoryImpl.setIfAlias(getIfAlias());
		upstreamChannelHistoryImpl.setIfDesc(getIfDesc());

		upstreamChannelHistoryImpl.resetOriginalValues();

		return upstreamChannelHistoryImpl;
	}

	@Override
	public int compareTo(UpstreamChannelHistory upstreamChannelHistory) {
		UpstreamChannelHistoryPK primaryKey = upstreamChannelHistory.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpstreamChannelHistory)) {
			return false;
		}

		UpstreamChannelHistory upstreamChannelHistory = (UpstreamChannelHistory)obj;

		UpstreamChannelHistoryPK primaryKey = upstreamChannelHistory.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<UpstreamChannelHistory> toCacheModel() {
		UpstreamChannelHistoryCacheModel upstreamChannelHistoryCacheModel = new UpstreamChannelHistoryCacheModel();

		upstreamChannelHistoryCacheModel.cmtsId = getCmtsId();

		upstreamChannelHistoryCacheModel.ifIndex = getIfIndex();

		Date createDate = getCreateDate();

		if (createDate != null) {
			upstreamChannelHistoryCacheModel.createDate = createDate.getTime();
		}
		else {
			upstreamChannelHistoryCacheModel.createDate = Long.MIN_VALUE;
		}

		upstreamChannelHistoryCacheModel.qam = getQam();

		String qam = upstreamChannelHistoryCacheModel.qam;

		if ((qam != null) && (qam.length() == 0)) {
			upstreamChannelHistoryCacheModel.qam = null;
		}

		upstreamChannelHistoryCacheModel.avgOnlineCmDsPower = getAvgOnlineCmDsPower();

		upstreamChannelHistoryCacheModel.avgOnlineCmUsPower = getAvgOnlineCmUsPower();

		upstreamChannelHistoryCacheModel.avgOnlineCmMicRef = getAvgOnlineCmMicRef();

		upstreamChannelHistoryCacheModel.avgOnlineCmTxPower = getAvgOnlineCmTxPower();

		upstreamChannelHistoryCacheModel.avgOnlineCmRxPower = getAvgOnlineCmRxPower();

		upstreamChannelHistoryCacheModel.fecUncorrectable = getFecUncorrectable();

		upstreamChannelHistoryCacheModel.fecCorrected = getFecCorrected();

		upstreamChannelHistoryCacheModel.upChannelCmTotal = getUpChannelCmTotal();

		upstreamChannelHistoryCacheModel.upChannelCmRegistered = getUpChannelCmRegistered();

		upstreamChannelHistoryCacheModel.upChannelCmActive = getUpChannelCmActive();

		upstreamChannelHistoryCacheModel.upChannelModProfile = getUpChannelModProfile();

		upstreamChannelHistoryCacheModel.upChannelWidth = getUpChannelWidth();

		upstreamChannelHistoryCacheModel.upChannelFrequency = getUpChannelFrequency();

		upstreamChannelHistoryCacheModel.ifSigQUncorrectables = getIfSigQUncorrectables();

		upstreamChannelHistoryCacheModel.ifSigQCorrecteds = getIfSigQCorrecteds();

		upstreamChannelHistoryCacheModel.ifSigQUnerroreds = getIfSigQUnerroreds();

		upstreamChannelHistoryCacheModel.ifSigQSNR = getIfSigQSNR();

		upstreamChannelHistoryCacheModel.ifAlias = getIfAlias();

		String ifAlias = upstreamChannelHistoryCacheModel.ifAlias;

		if ((ifAlias != null) && (ifAlias.length() == 0)) {
			upstreamChannelHistoryCacheModel.ifAlias = null;
		}

		upstreamChannelHistoryCacheModel.ifDesc = getIfDesc();

		String ifDesc = upstreamChannelHistoryCacheModel.ifDesc;

		if ((ifDesc != null) && (ifDesc.length() == 0)) {
			upstreamChannelHistoryCacheModel.ifDesc = null;
		}

		return upstreamChannelHistoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{cmtsId=");
		sb.append(getCmtsId());
		sb.append(", ifIndex=");
		sb.append(getIfIndex());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", qam=");
		sb.append(getQam());
		sb.append(", avgOnlineCmDsPower=");
		sb.append(getAvgOnlineCmDsPower());
		sb.append(", avgOnlineCmUsPower=");
		sb.append(getAvgOnlineCmUsPower());
		sb.append(", avgOnlineCmMicRef=");
		sb.append(getAvgOnlineCmMicRef());
		sb.append(", avgOnlineCmTxPower=");
		sb.append(getAvgOnlineCmTxPower());
		sb.append(", avgOnlineCmRxPower=");
		sb.append(getAvgOnlineCmRxPower());
		sb.append(", fecUncorrectable=");
		sb.append(getFecUncorrectable());
		sb.append(", fecCorrected=");
		sb.append(getFecCorrected());
		sb.append(", upChannelCmTotal=");
		sb.append(getUpChannelCmTotal());
		sb.append(", upChannelCmRegistered=");
		sb.append(getUpChannelCmRegistered());
		sb.append(", upChannelCmActive=");
		sb.append(getUpChannelCmActive());
		sb.append(", upChannelModProfile=");
		sb.append(getUpChannelModProfile());
		sb.append(", upChannelWidth=");
		sb.append(getUpChannelWidth());
		sb.append(", upChannelFrequency=");
		sb.append(getUpChannelFrequency());
		sb.append(", ifSigQUncorrectables=");
		sb.append(getIfSigQUncorrectables());
		sb.append(", ifSigQCorrecteds=");
		sb.append(getIfSigQCorrecteds());
		sb.append(", ifSigQUnerroreds=");
		sb.append(getIfSigQUnerroreds());
		sb.append(", ifSigQSNR=");
		sb.append(getIfSigQSNR());
		sb.append(", ifAlias=");
		sb.append(getIfAlias());
		sb.append(", ifDesc=");
		sb.append(getIfDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.UpstreamChannelHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifIndex</column-name><column-value><![CDATA[");
		sb.append(getIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qam</column-name><column-value><![CDATA[");
		sb.append(getQam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avgOnlineCmDsPower</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmDsPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avgOnlineCmUsPower</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmUsPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avgOnlineCmMicRef</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmMicRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avgOnlineCmTxPower</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmTxPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avgOnlineCmRxPower</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmRxPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecUncorrectable</column-name><column-value><![CDATA[");
		sb.append(getFecUncorrectable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecCorrected</column-name><column-value><![CDATA[");
		sb.append(getFecCorrected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelCmTotal</column-name><column-value><![CDATA[");
		sb.append(getUpChannelCmTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelCmRegistered</column-name><column-value><![CDATA[");
		sb.append(getUpChannelCmRegistered());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelCmActive</column-name><column-value><![CDATA[");
		sb.append(getUpChannelCmActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelModProfile</column-name><column-value><![CDATA[");
		sb.append(getUpChannelModProfile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelWidth</column-name><column-value><![CDATA[");
		sb.append(getUpChannelWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>upChannelFrequency</column-name><column-value><![CDATA[");
		sb.append(getUpChannelFrequency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifSigQUncorrectables</column-name><column-value><![CDATA[");
		sb.append(getIfSigQUncorrectables());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifSigQCorrecteds</column-name><column-value><![CDATA[");
		sb.append(getIfSigQCorrecteds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifSigQUnerroreds</column-name><column-value><![CDATA[");
		sb.append(getIfSigQUnerroreds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifSigQSNR</column-name><column-value><![CDATA[");
		sb.append(getIfSigQSNR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifAlias</column-name><column-value><![CDATA[");
		sb.append(getIfAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifDesc</column-name><column-value><![CDATA[");
		sb.append(getIfDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UpstreamChannelHistory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UpstreamChannelHistory.class
		};
	private long _cmtsId;
	private int _ifIndex;
	private Date _createDate;
	private String _qam;
	private double _avgOnlineCmDsPower;
	private double _avgOnlineCmUsPower;
	private double _avgOnlineCmMicRef;
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
	private UpstreamChannelHistory _escapedModel;
}