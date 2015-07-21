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
import com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richard
 */
public class UpChannelMetadataClp extends BaseModelImpl<UpChannelMetadata>
	implements UpChannelMetadata {
	public UpChannelMetadataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UpChannelMetadata.class;
	}

	@Override
	public String getModelClassName() {
		return UpChannelMetadata.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _metaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metaId", getMetaId());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("ifIndex", getIfIndex());
		attributes.put("dsFrequency", getDsFrequency());
		attributes.put("dsQam", getDsQam());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metaId = (Long)attributes.get("metaId");

		if (metaId != null) {
			setMetaId(metaId);
		}

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		String dsFrequency = (String)attributes.get("dsFrequency");

		if (dsFrequency != null) {
			setDsFrequency(dsFrequency);
		}

		String dsQam = (String)attributes.get("dsQam");

		if (dsQam != null) {
			setDsQam(dsQam);
		}
	}

	@Override
	public long getMetaId() {
		return _metaId;
	}

	@Override
	public void setMetaId(long metaId) {
		_metaId = metaId;

		if (_upChannelMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _upChannelMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setMetaId", long.class);

				method.invoke(_upChannelMetadataRemoteModel, metaId);
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

		if (_upChannelMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _upChannelMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setCmtsId", long.class);

				method.invoke(_upChannelMetadataRemoteModel, cmtsId);
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

		if (_upChannelMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _upChannelMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setIfIndex", int.class);

				method.invoke(_upChannelMetadataRemoteModel, ifIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDsFrequency() {
		return _dsFrequency;
	}

	@Override
	public void setDsFrequency(String dsFrequency) {
		_dsFrequency = dsFrequency;

		if (_upChannelMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _upChannelMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setDsFrequency", String.class);

				method.invoke(_upChannelMetadataRemoteModel, dsFrequency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDsQam() {
		return _dsQam;
	}

	@Override
	public void setDsQam(String dsQam) {
		_dsQam = dsQam;

		if (_upChannelMetadataRemoteModel != null) {
			try {
				Class<?> clazz = _upChannelMetadataRemoteModel.getClass();

				Method method = clazz.getMethod("setDsQam", String.class);

				method.invoke(_upChannelMetadataRemoteModel, dsQam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUpChannelMetadataRemoteModel() {
		return _upChannelMetadataRemoteModel;
	}

	public void setUpChannelMetadataRemoteModel(
		BaseModel<?> upChannelMetadataRemoteModel) {
		_upChannelMetadataRemoteModel = upChannelMetadataRemoteModel;
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

		Class<?> remoteModelClass = _upChannelMetadataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_upChannelMetadataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UpChannelMetadataLocalServiceUtil.addUpChannelMetadata(this);
		}
		else {
			UpChannelMetadataLocalServiceUtil.updateUpChannelMetadata(this);
		}
	}

	@Override
	public UpChannelMetadata toEscapedModel() {
		return (UpChannelMetadata)ProxyUtil.newProxyInstance(UpChannelMetadata.class.getClassLoader(),
			new Class[] { UpChannelMetadata.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UpChannelMetadataClp clone = new UpChannelMetadataClp();

		clone.setMetaId(getMetaId());
		clone.setCmtsId(getCmtsId());
		clone.setIfIndex(getIfIndex());
		clone.setDsFrequency(getDsFrequency());
		clone.setDsQam(getDsQam());

		return clone;
	}

	@Override
	public int compareTo(UpChannelMetadata upChannelMetadata) {
		long primaryKey = upChannelMetadata.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpChannelMetadataClp)) {
			return false;
		}

		UpChannelMetadataClp upChannelMetadata = (UpChannelMetadataClp)obj;

		long primaryKey = upChannelMetadata.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{metaId=");
		sb.append(getMetaId());
		sb.append(", cmtsId=");
		sb.append(getCmtsId());
		sb.append(", ifIndex=");
		sb.append(getIfIndex());
		sb.append(", dsFrequency=");
		sb.append(getDsFrequency());
		sb.append(", dsQam=");
		sb.append(getDsQam());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.UpChannelMetadata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metaId</column-name><column-value><![CDATA[");
		sb.append(getMetaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifIndex</column-name><column-value><![CDATA[");
		sb.append(getIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dsFrequency</column-name><column-value><![CDATA[");
		sb.append(getDsFrequency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dsQam</column-name><column-value><![CDATA[");
		sb.append(getDsQam());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _metaId;
	private long _cmtsId;
	private int _ifIndex;
	private String _dsFrequency;
	private String _dsQam;
	private BaseModel<?> _upChannelMetadataRemoteModel;
	private Class<?> _clpSerializerClass = com.cmcti.cmts.domain.service.ClpSerializer.class;
}