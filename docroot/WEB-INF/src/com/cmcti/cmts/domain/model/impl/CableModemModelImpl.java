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

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.model.CableModemModel;
import com.cmcti.cmts.domain.model.CableModemSoap;

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
 * The base model implementation for the CableModem service. Represents a row in the &quot;CMTS_MONITOR_CableModem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmcti.cmts.domain.model.CableModemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CableModemImpl}.
 * </p>
 *
 * @author richard
 * @see CableModemImpl
 * @see com.cmcti.cmts.domain.model.CableModem
 * @see com.cmcti.cmts.domain.model.CableModemModel
 * @generated
 */
@JSON(strict = true)
public class CableModemModelImpl extends BaseModelImpl<CableModem>
	implements CableModemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cable modem model instance should use the {@link com.cmcti.cmts.domain.model.CableModem} interface instead.
	 */
	public static final String TABLE_NAME = "CMTS_MONITOR_CableModem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "macAddress", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fecUncorrectable", Types.DOUBLE },
			{ "fecCorrected", Types.DOUBLE },
			{ "microRef", Types.BIGINT },
			{ "rxPower", Types.INTEGER },
			{ "txPower", Types.INTEGER },
			{ "usPower", Types.INTEGER },
			{ "dsPower", Types.INTEGER },
			{ "uncorrectables", Types.BIGINT },
			{ "correcteds", Types.BIGINT },
			{ "unerroreds", Types.BIGINT },
			{ "dsSNR", Types.INTEGER },
			{ "usSNR", Types.INTEGER },
			{ "ucIfIndex", Types.INTEGER },
			{ "dcIfIndex", Types.INTEGER },
			{ "cmSubIndex", Types.VARCHAR },
			{ "cmtsId", Types.BIGINT },
			{ "cmIndex", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table CMTS_MONITOR_CableModem (macAddress VARCHAR(75) not null primary key,createDate DATE null,modifiedDate DATE null,fecUncorrectable DOUBLE,fecCorrected DOUBLE,microRef LONG,rxPower INTEGER,txPower INTEGER,usPower INTEGER,dsPower INTEGER,uncorrectables LONG,correcteds LONG,unerroreds LONG,dsSNR INTEGER,usSNR INTEGER,ucIfIndex INTEGER,dcIfIndex INTEGER,cmSubIndex VARCHAR(75) null,cmtsId LONG,cmIndex INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table CMTS_MONITOR_CableModem";
	public static final String ORDER_BY_JPQL = " ORDER BY cableModem.macAddress ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CMTS_MONITOR_CableModem.macAddress ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmcti.cmts.domain.model.CableModem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmcti.cmts.domain.model.CableModem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CableModem toModel(CableModemSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CableModem model = new CableModemImpl();

		model.setMacAddress(soapModel.getMacAddress());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFecUncorrectable(soapModel.getFecUncorrectable());
		model.setFecCorrected(soapModel.getFecCorrected());
		model.setMicroRef(soapModel.getMicroRef());
		model.setRxPower(soapModel.getRxPower());
		model.setTxPower(soapModel.getTxPower());
		model.setUsPower(soapModel.getUsPower());
		model.setDsPower(soapModel.getDsPower());
		model.setUncorrectables(soapModel.getUncorrectables());
		model.setCorrecteds(soapModel.getCorrecteds());
		model.setUnerroreds(soapModel.getUnerroreds());
		model.setDsSNR(soapModel.getDsSNR());
		model.setUsSNR(soapModel.getUsSNR());
		model.setUcIfIndex(soapModel.getUcIfIndex());
		model.setDcIfIndex(soapModel.getDcIfIndex());
		model.setCmSubIndex(soapModel.getCmSubIndex());
		model.setCmtsId(soapModel.getCmtsId());
		model.setCmIndex(soapModel.getCmIndex());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CableModem> toModels(CableModemSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CableModem> models = new ArrayList<CableModem>(soapModels.length);

		for (CableModemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmcti.cmts.domain.model.CableModem"));

	public CableModemModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _macAddress;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setMacAddress(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _macAddress;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	@JSON
	@Override
	public String getMacAddress() {
		if (_macAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _macAddress;
		}
	}

	@Override
	public void setMacAddress(String macAddress) {
		_macAddress = macAddress;
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
	public long getMicroRef() {
		return _microRef;
	}

	@Override
	public void setMicroRef(long microRef) {
		_microRef = microRef;
	}

	@JSON
	@Override
	public int getRxPower() {
		return _rxPower;
	}

	@Override
	public void setRxPower(int rxPower) {
		_rxPower = rxPower;
	}

	@JSON
	@Override
	public int getTxPower() {
		return _txPower;
	}

	@Override
	public void setTxPower(int txPower) {
		_txPower = txPower;
	}

	@JSON
	@Override
	public int getUsPower() {
		return _usPower;
	}

	@Override
	public void setUsPower(int usPower) {
		_usPower = usPower;
	}

	@JSON
	@Override
	public int getDsPower() {
		return _dsPower;
	}

	@Override
	public void setDsPower(int dsPower) {
		_dsPower = dsPower;
	}

	@JSON
	@Override
	public long getUncorrectables() {
		return _uncorrectables;
	}

	@Override
	public void setUncorrectables(long uncorrectables) {
		_uncorrectables = uncorrectables;
	}

	@JSON
	@Override
	public long getCorrecteds() {
		return _correcteds;
	}

	@Override
	public void setCorrecteds(long correcteds) {
		_correcteds = correcteds;
	}

	@JSON
	@Override
	public long getUnerroreds() {
		return _unerroreds;
	}

	@Override
	public void setUnerroreds(long unerroreds) {
		_unerroreds = unerroreds;
	}

	@JSON
	@Override
	public int getDsSNR() {
		return _dsSNR;
	}

	@Override
	public void setDsSNR(int dsSNR) {
		_dsSNR = dsSNR;
	}

	@JSON
	@Override
	public int getUsSNR() {
		return _usSNR;
	}

	@Override
	public void setUsSNR(int usSNR) {
		_usSNR = usSNR;
	}

	@JSON
	@Override
	public int getUcIfIndex() {
		return _ucIfIndex;
	}

	@Override
	public void setUcIfIndex(int ucIfIndex) {
		_ucIfIndex = ucIfIndex;
	}

	@JSON
	@Override
	public int getDcIfIndex() {
		return _dcIfIndex;
	}

	@Override
	public void setDcIfIndex(int dcIfIndex) {
		_dcIfIndex = dcIfIndex;
	}

	@JSON
	@Override
	public String getCmSubIndex() {
		if (_cmSubIndex == null) {
			return StringPool.BLANK;
		}
		else {
			return _cmSubIndex;
		}
	}

	@Override
	public void setCmSubIndex(String cmSubIndex) {
		_cmSubIndex = cmSubIndex;
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
	public int getCmIndex() {
		return _cmIndex;
	}

	@Override
	public void setCmIndex(int cmIndex) {
		_cmIndex = cmIndex;
	}

	@Override
	public CableModem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CableModem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CableModemImpl cableModemImpl = new CableModemImpl();

		cableModemImpl.setMacAddress(getMacAddress());
		cableModemImpl.setCreateDate(getCreateDate());
		cableModemImpl.setModifiedDate(getModifiedDate());
		cableModemImpl.setFecUncorrectable(getFecUncorrectable());
		cableModemImpl.setFecCorrected(getFecCorrected());
		cableModemImpl.setMicroRef(getMicroRef());
		cableModemImpl.setRxPower(getRxPower());
		cableModemImpl.setTxPower(getTxPower());
		cableModemImpl.setUsPower(getUsPower());
		cableModemImpl.setDsPower(getDsPower());
		cableModemImpl.setUncorrectables(getUncorrectables());
		cableModemImpl.setCorrecteds(getCorrecteds());
		cableModemImpl.setUnerroreds(getUnerroreds());
		cableModemImpl.setDsSNR(getDsSNR());
		cableModemImpl.setUsSNR(getUsSNR());
		cableModemImpl.setUcIfIndex(getUcIfIndex());
		cableModemImpl.setDcIfIndex(getDcIfIndex());
		cableModemImpl.setCmSubIndex(getCmSubIndex());
		cableModemImpl.setCmtsId(getCmtsId());
		cableModemImpl.setCmIndex(getCmIndex());

		cableModemImpl.resetOriginalValues();

		return cableModemImpl;
	}

	@Override
	public int compareTo(CableModem cableModem) {
		String primaryKey = cableModem.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CableModem)) {
			return false;
		}

		CableModem cableModem = (CableModem)obj;

		String primaryKey = cableModem.getPrimaryKey();

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
	public CacheModel<CableModem> toCacheModel() {
		CableModemCacheModel cableModemCacheModel = new CableModemCacheModel();

		cableModemCacheModel.macAddress = getMacAddress();

		String macAddress = cableModemCacheModel.macAddress;

		if ((macAddress != null) && (macAddress.length() == 0)) {
			cableModemCacheModel.macAddress = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cableModemCacheModel.createDate = createDate.getTime();
		}
		else {
			cableModemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cableModemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cableModemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cableModemCacheModel.fecUncorrectable = getFecUncorrectable();

		cableModemCacheModel.fecCorrected = getFecCorrected();

		cableModemCacheModel.microRef = getMicroRef();

		cableModemCacheModel.rxPower = getRxPower();

		cableModemCacheModel.txPower = getTxPower();

		cableModemCacheModel.usPower = getUsPower();

		cableModemCacheModel.dsPower = getDsPower();

		cableModemCacheModel.uncorrectables = getUncorrectables();

		cableModemCacheModel.correcteds = getCorrecteds();

		cableModemCacheModel.unerroreds = getUnerroreds();

		cableModemCacheModel.dsSNR = getDsSNR();

		cableModemCacheModel.usSNR = getUsSNR();

		cableModemCacheModel.ucIfIndex = getUcIfIndex();

		cableModemCacheModel.dcIfIndex = getDcIfIndex();

		cableModemCacheModel.cmSubIndex = getCmSubIndex();

		String cmSubIndex = cableModemCacheModel.cmSubIndex;

		if ((cmSubIndex != null) && (cmSubIndex.length() == 0)) {
			cableModemCacheModel.cmSubIndex = null;
		}

		cableModemCacheModel.cmtsId = getCmtsId();

		cableModemCacheModel.cmIndex = getCmIndex();

		return cableModemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{macAddress=");
		sb.append(getMacAddress());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", fecUncorrectable=");
		sb.append(getFecUncorrectable());
		sb.append(", fecCorrected=");
		sb.append(getFecCorrected());
		sb.append(", microRef=");
		sb.append(getMicroRef());
		sb.append(", rxPower=");
		sb.append(getRxPower());
		sb.append(", txPower=");
		sb.append(getTxPower());
		sb.append(", usPower=");
		sb.append(getUsPower());
		sb.append(", dsPower=");
		sb.append(getDsPower());
		sb.append(", uncorrectables=");
		sb.append(getUncorrectables());
		sb.append(", correcteds=");
		sb.append(getCorrecteds());
		sb.append(", unerroreds=");
		sb.append(getUnerroreds());
		sb.append(", dsSNR=");
		sb.append(getDsSNR());
		sb.append(", usSNR=");
		sb.append(getUsSNR());
		sb.append(", ucIfIndex=");
		sb.append(getUcIfIndex());
		sb.append(", dcIfIndex=");
		sb.append(getDcIfIndex());
		sb.append(", cmSubIndex=");
		sb.append(getCmSubIndex());
		sb.append(", cmtsId=");
		sb.append(getCmtsId());
		sb.append(", cmIndex=");
		sb.append(getCmIndex());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.CableModem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>macAddress</column-name><column-value><![CDATA[");
		sb.append(getMacAddress());
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
			"<column><column-name>fecUncorrectable</column-name><column-value><![CDATA[");
		sb.append(getFecUncorrectable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecCorrected</column-name><column-value><![CDATA[");
		sb.append(getFecCorrected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>microRef</column-name><column-value><![CDATA[");
		sb.append(getMicroRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rxPower</column-name><column-value><![CDATA[");
		sb.append(getRxPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>txPower</column-name><column-value><![CDATA[");
		sb.append(getTxPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usPower</column-name><column-value><![CDATA[");
		sb.append(getUsPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dsPower</column-name><column-value><![CDATA[");
		sb.append(getDsPower());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uncorrectables</column-name><column-value><![CDATA[");
		sb.append(getUncorrectables());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>correcteds</column-name><column-value><![CDATA[");
		sb.append(getCorrecteds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unerroreds</column-name><column-value><![CDATA[");
		sb.append(getUnerroreds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dsSNR</column-name><column-value><![CDATA[");
		sb.append(getDsSNR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usSNR</column-name><column-value><![CDATA[");
		sb.append(getUsSNR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ucIfIndex</column-name><column-value><![CDATA[");
		sb.append(getUcIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dcIfIndex</column-name><column-value><![CDATA[");
		sb.append(getDcIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmSubIndex</column-name><column-value><![CDATA[");
		sb.append(getCmSubIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmIndex</column-name><column-value><![CDATA[");
		sb.append(getCmIndex());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CableModem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CableModem.class
		};
	private String _macAddress;
	private Date _createDate;
	private Date _modifiedDate;
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
	private CableModem _escapedModel;
}