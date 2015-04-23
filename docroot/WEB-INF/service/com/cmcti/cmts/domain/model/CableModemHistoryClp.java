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

import com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author richard
 */
public class CableModemHistoryClp extends BaseModelImpl<CableModemHistory>
	implements CableModemHistory {
	public CableModemHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CableModemHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CableModemHistory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cmHisId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCmHisId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cmHisId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cmHisId", getCmHisId());
		attributes.put("macAddress", getMacAddress());
		attributes.put("createDate", getCreateDate());
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
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cmHisId = (Long)attributes.get("cmHisId");

		if (cmHisId != null) {
			setCmHisId(cmHisId);
		}

		String macAddress = (String)attributes.get("macAddress");

		if (macAddress != null) {
			setMacAddress(macAddress);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getCmHisId() {
		return _cmHisId;
	}

	@Override
	public void setCmHisId(long cmHisId) {
		_cmHisId = cmHisId;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmHisId", long.class);

				method.invoke(_cableModemHistoryRemoteModel, cmHisId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMacAddress() {
		return _macAddress;
	}

	@Override
	public void setMacAddress(String macAddress) {
		_macAddress = macAddress;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setMacAddress", String.class);

				method.invoke(_cableModemHistoryRemoteModel, macAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cableModemHistoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFecUncorrectable() {
		return _fecUncorrectable;
	}

	@Override
	public void setFecUncorrectable(double fecUncorrectable) {
		_fecUncorrectable = fecUncorrectable;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFecUncorrectable",
						double.class);

				method.invoke(_cableModemHistoryRemoteModel, fecUncorrectable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFecCorrected() {
		return _fecCorrected;
	}

	@Override
	public void setFecCorrected(double fecCorrected) {
		_fecCorrected = fecCorrected;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFecCorrected", double.class);

				method.invoke(_cableModemHistoryRemoteModel, fecCorrected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMicroRef() {
		return _microRef;
	}

	@Override
	public void setMicroRef(long microRef) {
		_microRef = microRef;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setMicroRef", long.class);

				method.invoke(_cableModemHistoryRemoteModel, microRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRxPower() {
		return _rxPower;
	}

	@Override
	public void setRxPower(int rxPower) {
		_rxPower = rxPower;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRxPower", int.class);

				method.invoke(_cableModemHistoryRemoteModel, rxPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTxPower() {
		return _txPower;
	}

	@Override
	public void setTxPower(int txPower) {
		_txPower = txPower;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTxPower", int.class);

				method.invoke(_cableModemHistoryRemoteModel, txPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUsPower() {
		return _usPower;
	}

	@Override
	public void setUsPower(int usPower) {
		_usPower = usPower;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUsPower", int.class);

				method.invoke(_cableModemHistoryRemoteModel, usPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDsPower() {
		return _dsPower;
	}

	@Override
	public void setDsPower(int dsPower) {
		_dsPower = dsPower;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDsPower", int.class);

				method.invoke(_cableModemHistoryRemoteModel, dsPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUncorrectables() {
		return _uncorrectables;
	}

	@Override
	public void setUncorrectables(long uncorrectables) {
		_uncorrectables = uncorrectables;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUncorrectables", long.class);

				method.invoke(_cableModemHistoryRemoteModel, uncorrectables);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCorrecteds() {
		return _correcteds;
	}

	@Override
	public void setCorrecteds(long correcteds) {
		_correcteds = correcteds;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCorrecteds", long.class);

				method.invoke(_cableModemHistoryRemoteModel, correcteds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnerroreds() {
		return _unerroreds;
	}

	@Override
	public void setUnerroreds(long unerroreds) {
		_unerroreds = unerroreds;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUnerroreds", long.class);

				method.invoke(_cableModemHistoryRemoteModel, unerroreds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDsSNR() {
		return _dsSNR;
	}

	@Override
	public void setDsSNR(int dsSNR) {
		_dsSNR = dsSNR;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDsSNR", int.class);

				method.invoke(_cableModemHistoryRemoteModel, dsSNR);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUsSNR() {
		return _usSNR;
	}

	@Override
	public void setUsSNR(int usSNR) {
		_usSNR = usSNR;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUsSNR", int.class);

				method.invoke(_cableModemHistoryRemoteModel, usSNR);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUcIfIndex() {
		return _ucIfIndex;
	}

	@Override
	public void setUcIfIndex(int ucIfIndex) {
		_ucIfIndex = ucIfIndex;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUcIfIndex", int.class);

				method.invoke(_cableModemHistoryRemoteModel, ucIfIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDcIfIndex() {
		return _dcIfIndex;
	}

	@Override
	public void setDcIfIndex(int dcIfIndex) {
		_dcIfIndex = dcIfIndex;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDcIfIndex", int.class);

				method.invoke(_cableModemHistoryRemoteModel, dcIfIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCmSubIndex() {
		return _cmSubIndex;
	}

	@Override
	public void setCmSubIndex(String cmSubIndex) {
		_cmSubIndex = cmSubIndex;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmSubIndex", String.class);

				method.invoke(_cableModemHistoryRemoteModel, cmSubIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmtsId", long.class);

				method.invoke(_cableModemHistoryRemoteModel, cmtsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCmIndex() {
		return _cmIndex;
	}

	@Override
	public void setCmIndex(int cmIndex) {
		_cmIndex = cmIndex;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmIndex", int.class);

				method.invoke(_cableModemHistoryRemoteModel, cmIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_cableModemHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _cableModemHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_cableModemHistoryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCableModemHistoryRemoteModel() {
		return _cableModemHistoryRemoteModel;
	}

	public void setCableModemHistoryRemoteModel(
		BaseModel<?> cableModemHistoryRemoteModel) {
		_cableModemHistoryRemoteModel = cableModemHistoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cableModemHistoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cableModemHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CableModemHistoryLocalServiceUtil.addCableModemHistory(this);
		}
		else {
			CableModemHistoryLocalServiceUtil.updateCableModemHistory(this);
		}
	}

	@Override
	public CableModemHistory toEscapedModel() {
		return (CableModemHistory)ProxyUtil.newProxyInstance(CableModemHistory.class.getClassLoader(),
			new Class[] { CableModemHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CableModemHistoryClp clone = new CableModemHistoryClp();

		clone.setCmHisId(getCmHisId());
		clone.setMacAddress(getMacAddress());
		clone.setCreateDate(getCreateDate());
		clone.setFecUncorrectable(getFecUncorrectable());
		clone.setFecCorrected(getFecCorrected());
		clone.setMicroRef(getMicroRef());
		clone.setRxPower(getRxPower());
		clone.setTxPower(getTxPower());
		clone.setUsPower(getUsPower());
		clone.setDsPower(getDsPower());
		clone.setUncorrectables(getUncorrectables());
		clone.setCorrecteds(getCorrecteds());
		clone.setUnerroreds(getUnerroreds());
		clone.setDsSNR(getDsSNR());
		clone.setUsSNR(getUsSNR());
		clone.setUcIfIndex(getUcIfIndex());
		clone.setDcIfIndex(getDcIfIndex());
		clone.setCmSubIndex(getCmSubIndex());
		clone.setCmtsId(getCmtsId());
		clone.setCmIndex(getCmIndex());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(CableModemHistory cableModemHistory) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				cableModemHistory.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CableModemHistoryClp)) {
			return false;
		}

		CableModemHistoryClp cableModemHistory = (CableModemHistoryClp)obj;

		long primaryKey = cableModemHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{cmHisId=");
		sb.append(getCmHisId());
		sb.append(", macAddress=");
		sb.append(getMacAddress());
		sb.append(", createDate=");
		sb.append(getCreateDate());
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
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.CableModemHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cmHisId</column-name><column-value><![CDATA[");
		sb.append(getCmHisId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>macAddress</column-name><column-value><![CDATA[");
		sb.append(getMacAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
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
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _cableModemHistoryRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}