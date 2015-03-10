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

import com.cmcti.cmts.domain.service.ClpSerializer;
import com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class UpstreamChannelHistoryClp extends BaseModelImpl<UpstreamChannelHistory>
	implements UpstreamChannelHistory {
	public UpstreamChannelHistoryClp() {
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

	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_cmtsId = cmtsId;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmtsId", long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, cmtsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIfIndex() {
		return _ifIndex;
	}

	@Override
	public void setIfIndex(int ifIndex) {
		_ifIndex = ifIndex;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfIndex", int.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, ifIndex);
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

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQam() {
		return _qam;
	}

	@Override
	public void setQam(String qam) {
		_qam = qam;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setQam", String.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, qam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAvgOnlineCmDsPower() {
		return _avgOnlineCmDsPower;
	}

	@Override
	public void setAvgOnlineCmDsPower(double avgOnlineCmDsPower) {
		_avgOnlineCmDsPower = avgOnlineCmDsPower;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAvgOnlineCmDsPower",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					avgOnlineCmDsPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAvgOnlineCmUsPower() {
		return _avgOnlineCmUsPower;
	}

	@Override
	public void setAvgOnlineCmUsPower(double avgOnlineCmUsPower) {
		_avgOnlineCmUsPower = avgOnlineCmUsPower;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAvgOnlineCmUsPower",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					avgOnlineCmUsPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAvgOnlineCmMicRef() {
		return _avgOnlineCmMicRef;
	}

	@Override
	public void setAvgOnlineCmMicRef(double avgOnlineCmMicRef) {
		_avgOnlineCmMicRef = avgOnlineCmMicRef;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAvgOnlineCmMicRef",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					avgOnlineCmMicRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAvgOnlineCmTxPower() {
		return _avgOnlineCmTxPower;
	}

	@Override
	public void setAvgOnlineCmTxPower(double avgOnlineCmTxPower) {
		_avgOnlineCmTxPower = avgOnlineCmTxPower;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAvgOnlineCmTxPower",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					avgOnlineCmTxPower);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAvgOnlineCmRxPower() {
		return _avgOnlineCmRxPower;
	}

	@Override
	public void setAvgOnlineCmRxPower(double avgOnlineCmRxPower) {
		_avgOnlineCmRxPower = avgOnlineCmRxPower;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAvgOnlineCmRxPower",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					avgOnlineCmRxPower);
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

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFecUncorrectable",
						double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					fecUncorrectable);
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

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFecCorrected", double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, fecCorrected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUpChannelCmTotal() {
		return _upChannelCmTotal;
	}

	@Override
	public void setUpChannelCmTotal(int upChannelCmTotal) {
		_upChannelCmTotal = upChannelCmTotal;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelCmTotal", int.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					upChannelCmTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUpChannelCmRegistered() {
		return _upChannelCmRegistered;
	}

	@Override
	public void setUpChannelCmRegistered(int upChannelCmRegistered) {
		_upChannelCmRegistered = upChannelCmRegistered;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelCmRegistered",
						int.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					upChannelCmRegistered);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUpChannelCmActive() {
		return _upChannelCmActive;
	}

	@Override
	public void setUpChannelCmActive(int upChannelCmActive) {
		_upChannelCmActive = upChannelCmActive;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelCmActive",
						int.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					upChannelCmActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUpChannelModProfile() {
		return _upChannelModProfile;
	}

	@Override
	public void setUpChannelModProfile(int upChannelModProfile) {
		_upChannelModProfile = upChannelModProfile;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelModProfile",
						int.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					upChannelModProfile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpChannelWidth() {
		return _upChannelWidth;
	}

	@Override
	public void setUpChannelWidth(long upChannelWidth) {
		_upChannelWidth = upChannelWidth;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelWidth", long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, upChannelWidth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpChannelFrequency() {
		return _upChannelFrequency;
	}

	@Override
	public void setUpChannelFrequency(long upChannelFrequency) {
		_upChannelFrequency = upChannelFrequency;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpChannelFrequency",
						long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					upChannelFrequency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIfSigQUncorrectables() {
		return _ifSigQUncorrectables;
	}

	@Override
	public void setIfSigQUncorrectables(long ifSigQUncorrectables) {
		_ifSigQUncorrectables = ifSigQUncorrectables;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfSigQUncorrectables",
						long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					ifSigQUncorrectables);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIfSigQCorrecteds() {
		return _ifSigQCorrecteds;
	}

	@Override
	public void setIfSigQCorrecteds(long ifSigQCorrecteds) {
		_ifSigQCorrecteds = ifSigQCorrecteds;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfSigQCorrecteds",
						long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					ifSigQCorrecteds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIfSigQUnerroreds() {
		return _ifSigQUnerroreds;
	}

	@Override
	public void setIfSigQUnerroreds(long ifSigQUnerroreds) {
		_ifSigQUnerroreds = ifSigQUnerroreds;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfSigQUnerroreds",
						long.class);

				method.invoke(_upstreamChannelHistoryRemoteModel,
					ifSigQUnerroreds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getIfSigQSNR() {
		return _ifSigQSNR;
	}

	@Override
	public void setIfSigQSNR(double ifSigQSNR) {
		_ifSigQSNR = ifSigQSNR;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfSigQSNR", double.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, ifSigQSNR);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIfAlias() {
		return _ifAlias;
	}

	@Override
	public void setIfAlias(String ifAlias) {
		_ifAlias = ifAlias;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfAlias", String.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, ifAlias);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIfDesc() {
		return _ifDesc;
	}

	@Override
	public void setIfDesc(String ifDesc) {
		_ifDesc = ifDesc;

		if (_upstreamChannelHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _upstreamChannelHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setIfDesc", String.class);

				method.invoke(_upstreamChannelHistoryRemoteModel, ifDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUpstreamChannelHistoryRemoteModel() {
		return _upstreamChannelHistoryRemoteModel;
	}

	public void setUpstreamChannelHistoryRemoteModel(
		BaseModel<?> upstreamChannelHistoryRemoteModel) {
		_upstreamChannelHistoryRemoteModel = upstreamChannelHistoryRemoteModel;
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

		Class<?> remoteModelClass = _upstreamChannelHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_upstreamChannelHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UpstreamChannelHistoryLocalServiceUtil.addUpstreamChannelHistory(this);
		}
		else {
			UpstreamChannelHistoryLocalServiceUtil.updateUpstreamChannelHistory(this);
		}
	}

	@Override
	public UpstreamChannelHistory toEscapedModel() {
		return (UpstreamChannelHistory)ProxyUtil.newProxyInstance(UpstreamChannelHistory.class.getClassLoader(),
			new Class[] { UpstreamChannelHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UpstreamChannelHistoryClp clone = new UpstreamChannelHistoryClp();

		clone.setCmtsId(getCmtsId());
		clone.setIfIndex(getIfIndex());
		clone.setCreateDate(getCreateDate());
		clone.setQam(getQam());
		clone.setAvgOnlineCmDsPower(getAvgOnlineCmDsPower());
		clone.setAvgOnlineCmUsPower(getAvgOnlineCmUsPower());
		clone.setAvgOnlineCmMicRef(getAvgOnlineCmMicRef());
		clone.setAvgOnlineCmTxPower(getAvgOnlineCmTxPower());
		clone.setAvgOnlineCmRxPower(getAvgOnlineCmRxPower());
		clone.setFecUncorrectable(getFecUncorrectable());
		clone.setFecCorrected(getFecCorrected());
		clone.setUpChannelCmTotal(getUpChannelCmTotal());
		clone.setUpChannelCmRegistered(getUpChannelCmRegistered());
		clone.setUpChannelCmActive(getUpChannelCmActive());
		clone.setUpChannelModProfile(getUpChannelModProfile());
		clone.setUpChannelWidth(getUpChannelWidth());
		clone.setUpChannelFrequency(getUpChannelFrequency());
		clone.setIfSigQUncorrectables(getIfSigQUncorrectables());
		clone.setIfSigQCorrecteds(getIfSigQCorrecteds());
		clone.setIfSigQUnerroreds(getIfSigQUnerroreds());
		clone.setIfSigQSNR(getIfSigQSNR());
		clone.setIfAlias(getIfAlias());
		clone.setIfDesc(getIfDesc());

		return clone;
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

		if (!(obj instanceof UpstreamChannelHistoryClp)) {
			return false;
		}

		UpstreamChannelHistoryClp upstreamChannelHistory = (UpstreamChannelHistoryClp)obj;

		UpstreamChannelHistoryPK primaryKey = upstreamChannelHistory.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
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
	private BaseModel<?> _upstreamChannelHistoryRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}