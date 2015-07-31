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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UpChannelMetadata}.
 * </p>
 *
 * @author richard
 * @see UpChannelMetadata
 * @generated
 */
public class UpChannelMetadataWrapper implements UpChannelMetadata,
	ModelWrapper<UpChannelMetadata> {
	public UpChannelMetadataWrapper(UpChannelMetadata upChannelMetadata) {
		_upChannelMetadata = upChannelMetadata;
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

	/**
	* Returns the primary key of this up channel metadata.
	*
	* @return the primary key of this up channel metadata
	*/
	@Override
	public long getPrimaryKey() {
		return _upChannelMetadata.getPrimaryKey();
	}

	/**
	* Sets the primary key of this up channel metadata.
	*
	* @param primaryKey the primary key of this up channel metadata
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_upChannelMetadata.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the meta ID of this up channel metadata.
	*
	* @return the meta ID of this up channel metadata
	*/
	@Override
	public long getMetaId() {
		return _upChannelMetadata.getMetaId();
	}

	/**
	* Sets the meta ID of this up channel metadata.
	*
	* @param metaId the meta ID of this up channel metadata
	*/
	@Override
	public void setMetaId(long metaId) {
		_upChannelMetadata.setMetaId(metaId);
	}

	/**
	* Returns the cmts ID of this up channel metadata.
	*
	* @return the cmts ID of this up channel metadata
	*/
	@Override
	public long getCmtsId() {
		return _upChannelMetadata.getCmtsId();
	}

	/**
	* Sets the cmts ID of this up channel metadata.
	*
	* @param cmtsId the cmts ID of this up channel metadata
	*/
	@Override
	public void setCmtsId(long cmtsId) {
		_upChannelMetadata.setCmtsId(cmtsId);
	}

	/**
	* Returns the if index of this up channel metadata.
	*
	* @return the if index of this up channel metadata
	*/
	@Override
	public int getIfIndex() {
		return _upChannelMetadata.getIfIndex();
	}

	/**
	* Sets the if index of this up channel metadata.
	*
	* @param ifIndex the if index of this up channel metadata
	*/
	@Override
	public void setIfIndex(int ifIndex) {
		_upChannelMetadata.setIfIndex(ifIndex);
	}

	/**
	* Returns the ds frequency of this up channel metadata.
	*
	* @return the ds frequency of this up channel metadata
	*/
	@Override
	public java.lang.String getDsFrequency() {
		return _upChannelMetadata.getDsFrequency();
	}

	/**
	* Sets the ds frequency of this up channel metadata.
	*
	* @param dsFrequency the ds frequency of this up channel metadata
	*/
	@Override
	public void setDsFrequency(java.lang.String dsFrequency) {
		_upChannelMetadata.setDsFrequency(dsFrequency);
	}

	/**
	* Returns the ds qam of this up channel metadata.
	*
	* @return the ds qam of this up channel metadata
	*/
	@Override
	public java.lang.String getDsQam() {
		return _upChannelMetadata.getDsQam();
	}

	/**
	* Sets the ds qam of this up channel metadata.
	*
	* @param dsQam the ds qam of this up channel metadata
	*/
	@Override
	public void setDsQam(java.lang.String dsQam) {
		_upChannelMetadata.setDsQam(dsQam);
	}

	@Override
	public boolean isNew() {
		return _upChannelMetadata.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_upChannelMetadata.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _upChannelMetadata.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_upChannelMetadata.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _upChannelMetadata.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _upChannelMetadata.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_upChannelMetadata.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _upChannelMetadata.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_upChannelMetadata.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_upChannelMetadata.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_upChannelMetadata.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UpChannelMetadataWrapper((UpChannelMetadata)_upChannelMetadata.clone());
	}

	@Override
	public int compareTo(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata) {
		return _upChannelMetadata.compareTo(upChannelMetadata);
	}

	@Override
	public int hashCode() {
		return _upChannelMetadata.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cmcti.cmts.domain.model.UpChannelMetadata> toCacheModel() {
		return _upChannelMetadata.toCacheModel();
	}

	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata toEscapedModel() {
		return new UpChannelMetadataWrapper(_upChannelMetadata.toEscapedModel());
	}

	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata toUnescapedModel() {
		return new UpChannelMetadataWrapper(_upChannelMetadata.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _upChannelMetadata.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _upChannelMetadata.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_upChannelMetadata.persist();
	}

	@Override
	public java.util.List<java.lang.String> getMerchantCodes() {
		return _upChannelMetadata.getMerchantCodes();
	}

	@Override
	public void setMerchantCodes(java.util.List<java.lang.String> merchantCodes) {
		_upChannelMetadata.setMerchantCodes(merchantCodes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpChannelMetadataWrapper)) {
			return false;
		}

		UpChannelMetadataWrapper upChannelMetadataWrapper = (UpChannelMetadataWrapper)obj;

		if (Validator.equals(_upChannelMetadata,
					upChannelMetadataWrapper._upChannelMetadata)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UpChannelMetadata getWrappedUpChannelMetadata() {
		return _upChannelMetadata;
	}

	@Override
	public UpChannelMetadata getWrappedModel() {
		return _upChannelMetadata;
	}

	@Override
	public void resetOriginalValues() {
		_upChannelMetadata.resetOriginalValues();
	}

	private UpChannelMetadata _upChannelMetadata;
}