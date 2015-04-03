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

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.model.UpstreamChannelModel;
import com.cmcti.cmts.domain.model.UpstreamChannelSoap;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;

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
 * The base model implementation for the UpstreamChannel service. Represents a row in the &quot;UpstreamChannel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmcti.cmts.domain.model.UpstreamChannelModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UpstreamChannelImpl}.
 * </p>
 *
 * @author richard
 * @see UpstreamChannelImpl
 * @see com.cmcti.cmts.domain.model.UpstreamChannel
 * @see com.cmcti.cmts.domain.model.UpstreamChannelModel
 * @generated
 */
@JSON(strict = true)
public class UpstreamChannelModelImpl extends BaseModelImpl<UpstreamChannel>
	implements UpstreamChannelModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a upstream channel model instance should use the {@link com.cmcti.cmts.domain.model.UpstreamChannel} interface instead.
	 */
	public static final String TABLE_NAME = "UpstreamChannel";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ifIndex", Types.INTEGER },
			{ "cmtsId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "qam", Types.VARCHAR },
			{ "avgOnlineCmDsPower", Types.DOUBLE },
			{ "avgOnlineCmUsPower", Types.DOUBLE },
			{ "avgOnlineCmMicRef", Types.DOUBLE },
			{ "avgOnlineCmDsSNR", Types.DOUBLE },
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
	public static final String TABLE_SQL_CREATE = "create table UpstreamChannel (ifIndex INTEGER not null,cmtsId LONG not null,createDate DATE null,modifiedDate DATE null,qam VARCHAR(75) null,avgOnlineCmDsPower DOUBLE,avgOnlineCmUsPower DOUBLE,avgOnlineCmMicRef DOUBLE,avgOnlineCmDsSNR DOUBLE,avgOnlineCmTxPower DOUBLE,avgOnlineCmRxPower DOUBLE,fecUncorrectable DOUBLE,fecCorrected DOUBLE,upChannelCmTotal INTEGER,upChannelCmRegistered INTEGER,upChannelCmActive INTEGER,upChannelModProfile INTEGER,upChannelWidth LONG,upChannelFrequency LONG,ifSigQUncorrectables LONG,ifSigQCorrecteds LONG,ifSigQUnerroreds LONG,ifSigQSNR DOUBLE,ifAlias VARCHAR(75) null,ifDesc VARCHAR(75) null,primary key (ifIndex, cmtsId))";
	public static final String TABLE_SQL_DROP = "drop table UpstreamChannel";
	public static final String ORDER_BY_JPQL = " ORDER BY upstreamChannel.id.ifIndex ASC, upstreamChannel.id.cmtsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY UpstreamChannel.ifIndex ASC, UpstreamChannel.cmtsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmcti.cmts.domain.model.UpstreamChannel"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmcti.cmts.domain.model.UpstreamChannel"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cmcti.cmts.domain.model.UpstreamChannel"),
			true);
	public static long AVGONLINECMDSSNR_COLUMN_BITMASK = 1L;
	public static long AVGONLINECMRXPOWER_COLUMN_BITMASK = 2L;
	public static long AVGONLINECMTXPOWER_COLUMN_BITMASK = 4L;
	public static long CMTSID_COLUMN_BITMASK = 8L;
	public static long FECCORRECTED_COLUMN_BITMASK = 16L;
	public static long FECUNCORRECTABLE_COLUMN_BITMASK = 32L;
	public static long IFSIGQSNR_COLUMN_BITMASK = 64L;
	public static long IFINDEX_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UpstreamChannel toModel(UpstreamChannelSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UpstreamChannel model = new UpstreamChannelImpl();

		model.setIfIndex(soapModel.getIfIndex());
		model.setCmtsId(soapModel.getCmtsId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setQam(soapModel.getQam());
		model.setAvgOnlineCmDsPower(soapModel.getAvgOnlineCmDsPower());
		model.setAvgOnlineCmUsPower(soapModel.getAvgOnlineCmUsPower());
		model.setAvgOnlineCmMicRef(soapModel.getAvgOnlineCmMicRef());
		model.setAvgOnlineCmDsSNR(soapModel.getAvgOnlineCmDsSNR());
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
	public static List<UpstreamChannel> toModels(
		UpstreamChannelSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UpstreamChannel> models = new ArrayList<UpstreamChannel>(soapModels.length);

		for (UpstreamChannelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmcti.cmts.domain.model.UpstreamChannel"));

	public UpstreamChannelModelImpl() {
	}

	@Override
	public UpstreamChannelPK getPrimaryKey() {
		return new UpstreamChannelPK(_ifIndex, _cmtsId);
	}

	@Override
	public void setPrimaryKey(UpstreamChannelPK primaryKey) {
		setIfIndex(primaryKey.ifIndex);
		setCmtsId(primaryKey.cmtsId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UpstreamChannelPK(_ifIndex, _cmtsId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UpstreamChannelPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UpstreamChannel.class;
	}

	@Override
	public String getModelClassName() {
		return UpstreamChannel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ifIndex", getIfIndex());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("qam", getQam());
		attributes.put("avgOnlineCmDsPower", getAvgOnlineCmDsPower());
		attributes.put("avgOnlineCmUsPower", getAvgOnlineCmUsPower());
		attributes.put("avgOnlineCmMicRef", getAvgOnlineCmMicRef());
		attributes.put("avgOnlineCmDsSNR", getAvgOnlineCmDsSNR());
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
		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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

		Double avgOnlineCmDsSNR = (Double)attributes.get("avgOnlineCmDsSNR");

		if (avgOnlineCmDsSNR != null) {
			setAvgOnlineCmDsSNR(avgOnlineCmDsSNR);
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
	public int getIfIndex() {
		return _ifIndex;
	}

	@Override
	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;
	}

	@JSON
	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_columnBitmask |= CMTSID_COLUMN_BITMASK;

		if (!_setOriginalCmtsId) {
			_setOriginalCmtsId = true;

			_originalCmtsId = _cmtsId;
		}

		_cmtsId = cmtsId;
	}

	public long getOriginalCmtsId() {
		return _originalCmtsId;
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	public double getAvgOnlineCmDsSNR() {
		return _avgOnlineCmDsSNR;
	}

	@Override
	public void setAvgOnlineCmDsSNR(double avgOnlineCmDsSNR) {
		_columnBitmask |= AVGONLINECMDSSNR_COLUMN_BITMASK;

		if (!_setOriginalAvgOnlineCmDsSNR) {
			_setOriginalAvgOnlineCmDsSNR = true;

			_originalAvgOnlineCmDsSNR = _avgOnlineCmDsSNR;
		}

		_avgOnlineCmDsSNR = avgOnlineCmDsSNR;
	}

	public double getOriginalAvgOnlineCmDsSNR() {
		return _originalAvgOnlineCmDsSNR;
	}

	@JSON
	@Override
	public double getAvgOnlineCmTxPower() {
		return _avgOnlineCmTxPower;
	}

	@Override
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_columnBitmask |= AVGONLINECMTXPOWER_COLUMN_BITMASK;

		if (!_setOriginalAvgOnlineCmTxPower) {
			_setOriginalAvgOnlineCmTxPower = true;

			_originalAvgOnlineCmTxPower = _avgOnlineCmTxPower;
		}

		_avgOnlineCmTxPower = avgOnlineCmTxPower;
	}

	public double getOriginalAvgOnlineCmTxPower() {
		return _originalAvgOnlineCmTxPower;
	}

	@JSON
	@Override
	public double getAvgOnlineCmRxPower() {
		return _avgOnlineCmRxPower;
	}

	@Override
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_columnBitmask |= AVGONLINECMRXPOWER_COLUMN_BITMASK;

		if (!_setOriginalAvgOnlineCmRxPower) {
			_setOriginalAvgOnlineCmRxPower = true;

			_originalAvgOnlineCmRxPower = _avgOnlineCmRxPower;
		}

		_avgOnlineCmRxPower = avgOnlineCmRxPower;
	}

	public double getOriginalAvgOnlineCmRxPower() {
		return _originalAvgOnlineCmRxPower;
	}

	@JSON
	@Override
	public double getFecUncorrectable() {
		return _fecUncorrectable;
	}

	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_columnBitmask |= FECUNCORRECTABLE_COLUMN_BITMASK;

		if (!_setOriginalFecUncorrectable) {
			_setOriginalFecUncorrectable = true;

			_originalFecUncorrectable = _fecUncorrectable;
		}

		_fecUncorrectable = fecUncorrectable;
	}

	public double getOriginalFecUncorrectable() {
		return _originalFecUncorrectable;
	}

	@JSON
	@Override
	public double getFecCorrected() {
		return _fecCorrected;
	}

	@Override
	public void setFecCorrected(double fecCorrected) {
		_columnBitmask |= FECCORRECTED_COLUMN_BITMASK;

		if (!_setOriginalFecCorrected) {
			_setOriginalFecCorrected = true;

			_originalFecCorrected = _fecCorrected;
		}

		_fecCorrected = fecCorrected;
	}

	public double getOriginalFecCorrected() {
		return _originalFecCorrected;
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
		_columnBitmask |= IFSIGQSNR_COLUMN_BITMASK;

		if (!_setOriginalIfSigQSNR) {
			_setOriginalIfSigQSNR = true;

			_originalIfSigQSNR = _ifSigQSNR;
		}

		_ifSigQSNR = ifSigQSNR;
	}

	public double getOriginalIfSigQSNR() {
		return _originalIfSigQSNR;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UpstreamChannel toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UpstreamChannel)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UpstreamChannelImpl upstreamChannelImpl = new UpstreamChannelImpl();

		upstreamChannelImpl.setIfIndex(getIfIndex());
		upstreamChannelImpl.setCmtsId(getCmtsId());
		upstreamChannelImpl.setCreateDate(getCreateDate());
		upstreamChannelImpl.setModifiedDate(getModifiedDate());
		upstreamChannelImpl.setQam(getQam());
		upstreamChannelImpl.setAvgOnlineCmDsPower(getAvgOnlineCmDsPower());
		upstreamChannelImpl.setAvgOnlineCmUsPower(getAvgOnlineCmUsPower());
		upstreamChannelImpl.setAvgOnlineCmMicRef(getAvgOnlineCmMicRef());
		upstreamChannelImpl.setAvgOnlineCmDsSNR(getAvgOnlineCmDsSNR());
		upstreamChannelImpl.setAvgOnlineCmTxPower(getAvgOnlineCmTxPower());
		upstreamChannelImpl.setAvgOnlineCmRxPower(getAvgOnlineCmRxPower());
		upstreamChannelImpl.setFecUncorrectable(getFecUncorrectable());
		upstreamChannelImpl.setFecCorrected(getFecCorrected());
		upstreamChannelImpl.setUpChannelCmTotal(getUpChannelCmTotal());
		upstreamChannelImpl.setUpChannelCmRegistered(getUpChannelCmRegistered());
		upstreamChannelImpl.setUpChannelCmActive(getUpChannelCmActive());
		upstreamChannelImpl.setUpChannelModProfile(getUpChannelModProfile());
		upstreamChannelImpl.setUpChannelWidth(getUpChannelWidth());
		upstreamChannelImpl.setUpChannelFrequency(getUpChannelFrequency());
		upstreamChannelImpl.setIfSigQUncorrectables(getIfSigQUncorrectables());
		upstreamChannelImpl.setIfSigQCorrecteds(getIfSigQCorrecteds());
		upstreamChannelImpl.setIfSigQUnerroreds(getIfSigQUnerroreds());
		upstreamChannelImpl.setIfSigQSNR(getIfSigQSNR());
		upstreamChannelImpl.setIfAlias(getIfAlias());
		upstreamChannelImpl.setIfDesc(getIfDesc());

		upstreamChannelImpl.resetOriginalValues();

		return upstreamChannelImpl;
	}

	@Override
	public int compareTo(UpstreamChannel upstreamChannel) {
		UpstreamChannelPK primaryKey = upstreamChannel.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpstreamChannel)) {
			return false;
		}

		UpstreamChannel upstreamChannel = (UpstreamChannel)obj;

		UpstreamChannelPK primaryKey = upstreamChannel.getPrimaryKey();

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
		UpstreamChannelModelImpl upstreamChannelModelImpl = this;

		upstreamChannelModelImpl._originalCmtsId = upstreamChannelModelImpl._cmtsId;

		upstreamChannelModelImpl._setOriginalCmtsId = false;

		upstreamChannelModelImpl._originalAvgOnlineCmDsSNR = upstreamChannelModelImpl._avgOnlineCmDsSNR;

		upstreamChannelModelImpl._setOriginalAvgOnlineCmDsSNR = false;

		upstreamChannelModelImpl._originalAvgOnlineCmTxPower = upstreamChannelModelImpl._avgOnlineCmTxPower;

		upstreamChannelModelImpl._setOriginalAvgOnlineCmTxPower = false;

		upstreamChannelModelImpl._originalAvgOnlineCmRxPower = upstreamChannelModelImpl._avgOnlineCmRxPower;

		upstreamChannelModelImpl._setOriginalAvgOnlineCmRxPower = false;

		upstreamChannelModelImpl._originalFecUncorrectable = upstreamChannelModelImpl._fecUncorrectable;

		upstreamChannelModelImpl._setOriginalFecUncorrectable = false;

		upstreamChannelModelImpl._originalFecCorrected = upstreamChannelModelImpl._fecCorrected;

		upstreamChannelModelImpl._setOriginalFecCorrected = false;

		upstreamChannelModelImpl._originalIfSigQSNR = upstreamChannelModelImpl._ifSigQSNR;

		upstreamChannelModelImpl._setOriginalIfSigQSNR = false;

		upstreamChannelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UpstreamChannel> toCacheModel() {
		UpstreamChannelCacheModel upstreamChannelCacheModel = new UpstreamChannelCacheModel();

		upstreamChannelCacheModel.ifIndex = getIfIndex();

		upstreamChannelCacheModel.cmtsId = getCmtsId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			upstreamChannelCacheModel.createDate = createDate.getTime();
		}
		else {
			upstreamChannelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			upstreamChannelCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			upstreamChannelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		upstreamChannelCacheModel.qam = getQam();

		String qam = upstreamChannelCacheModel.qam;

		if ((qam != null) && (qam.length() == 0)) {
			upstreamChannelCacheModel.qam = null;
		}

		upstreamChannelCacheModel.avgOnlineCmDsPower = getAvgOnlineCmDsPower();

		upstreamChannelCacheModel.avgOnlineCmUsPower = getAvgOnlineCmUsPower();

		upstreamChannelCacheModel.avgOnlineCmMicRef = getAvgOnlineCmMicRef();

		upstreamChannelCacheModel.avgOnlineCmDsSNR = getAvgOnlineCmDsSNR();

		upstreamChannelCacheModel.avgOnlineCmTxPower = getAvgOnlineCmTxPower();

		upstreamChannelCacheModel.avgOnlineCmRxPower = getAvgOnlineCmRxPower();

		upstreamChannelCacheModel.fecUncorrectable = getFecUncorrectable();

		upstreamChannelCacheModel.fecCorrected = getFecCorrected();

		upstreamChannelCacheModel.upChannelCmTotal = getUpChannelCmTotal();

		upstreamChannelCacheModel.upChannelCmRegistered = getUpChannelCmRegistered();

		upstreamChannelCacheModel.upChannelCmActive = getUpChannelCmActive();

		upstreamChannelCacheModel.upChannelModProfile = getUpChannelModProfile();

		upstreamChannelCacheModel.upChannelWidth = getUpChannelWidth();

		upstreamChannelCacheModel.upChannelFrequency = getUpChannelFrequency();

		upstreamChannelCacheModel.ifSigQUncorrectables = getIfSigQUncorrectables();

		upstreamChannelCacheModel.ifSigQCorrecteds = getIfSigQCorrecteds();

		upstreamChannelCacheModel.ifSigQUnerroreds = getIfSigQUnerroreds();

		upstreamChannelCacheModel.ifSigQSNR = getIfSigQSNR();

		upstreamChannelCacheModel.ifAlias = getIfAlias();

		String ifAlias = upstreamChannelCacheModel.ifAlias;

		if ((ifAlias != null) && (ifAlias.length() == 0)) {
			upstreamChannelCacheModel.ifAlias = null;
		}

		upstreamChannelCacheModel.ifDesc = getIfDesc();

		String ifDesc = upstreamChannelCacheModel.ifDesc;

		if ((ifDesc != null) && (ifDesc.length() == 0)) {
			upstreamChannelCacheModel.ifDesc = null;
		}

		return upstreamChannelCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{ifIndex=");
		sb.append(getIfIndex());
		sb.append(", cmtsId=");
		sb.append(getCmtsId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", qam=");
		sb.append(getQam());
		sb.append(", avgOnlineCmDsPower=");
		sb.append(getAvgOnlineCmDsPower());
		sb.append(", avgOnlineCmUsPower=");
		sb.append(getAvgOnlineCmUsPower());
		sb.append(", avgOnlineCmMicRef=");
		sb.append(getAvgOnlineCmMicRef());
		sb.append(", avgOnlineCmDsSNR=");
		sb.append(getAvgOnlineCmDsSNR());
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
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.UpstreamChannel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ifIndex</column-name><column-value><![CDATA[");
		sb.append(getIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
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
			"<column><column-name>avgOnlineCmDsSNR</column-name><column-value><![CDATA[");
		sb.append(getAvgOnlineCmDsSNR());
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

	private static ClassLoader _classLoader = UpstreamChannel.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UpstreamChannel.class
		};
	private int _ifIndex;
	private long _cmtsId;
	private long _originalCmtsId;
	private boolean _setOriginalCmtsId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _qam;
	private double _avgOnlineCmDsPower;
	private double _avgOnlineCmUsPower;
	private double _avgOnlineCmMicRef;
	private double _avgOnlineCmDsSNR;
	private double _originalAvgOnlineCmDsSNR;
	private boolean _setOriginalAvgOnlineCmDsSNR;
	private double _avgOnlineCmTxPower;
	private double _originalAvgOnlineCmTxPower;
	private boolean _setOriginalAvgOnlineCmTxPower;
	private double _avgOnlineCmRxPower;
	private double _originalAvgOnlineCmRxPower;
	private boolean _setOriginalAvgOnlineCmRxPower;
	private double _fecUncorrectable;
	private double _originalFecUncorrectable;
	private boolean _setOriginalFecUncorrectable;
	private double _fecCorrected;
	private double _originalFecCorrected;
	private boolean _setOriginalFecCorrected;
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
	private double _originalIfSigQSNR;
	private boolean _setOriginalIfSigQSNR;
	private String _ifAlias;
	private String _ifDesc;
	private long _columnBitmask;
	private UpstreamChannel _escapedModel;
}