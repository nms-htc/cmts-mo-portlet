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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CableModemHistory service. Represents a row in the &quot;CMTS_CMHis&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryImpl}.
 * </p>
 *
 * @author richard
 * @see CableModemHistory
 * @see com.cmcti.cmts.domain.model.impl.CableModemHistoryImpl
 * @see com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl
 * @generated
 */
public interface CableModemHistoryModel extends BaseModel<CableModemHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cable modem history model instance should use the {@link CableModemHistory} interface instead.
	 */

	/**
	 * Returns the primary key of this cable modem history.
	 *
	 * @return the primary key of this cable modem history
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cable modem history.
	 *
	 * @param primaryKey the primary key of this cable modem history
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cm his ID of this cable modem history.
	 *
	 * @return the cm his ID of this cable modem history
	 */
	public long getCmHisId();

	/**
	 * Sets the cm his ID of this cable modem history.
	 *
	 * @param cmHisId the cm his ID of this cable modem history
	 */
	public void setCmHisId(long cmHisId);

	/**
	 * Returns the mac address of this cable modem history.
	 *
	 * @return the mac address of this cable modem history
	 */
	@AutoEscape
	public String getMacAddress();

	/**
	 * Sets the mac address of this cable modem history.
	 *
	 * @param macAddress the mac address of this cable modem history
	 */
	public void setMacAddress(String macAddress);

	/**
	 * Returns the create date of this cable modem history.
	 *
	 * @return the create date of this cable modem history
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this cable modem history.
	 *
	 * @param createDate the create date of this cable modem history
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the fec uncorrectable of this cable modem history.
	 *
	 * @return the fec uncorrectable of this cable modem history
	 */
	public double getFecUncorrectable();

	/**
	 * Sets the fec uncorrectable of this cable modem history.
	 *
	 * @param fecUncorrectable the fec uncorrectable of this cable modem history
	 */
	public void setFecUncorrectable(double fecUncorrectable);

	/**
	 * Returns the fec corrected of this cable modem history.
	 *
	 * @return the fec corrected of this cable modem history
	 */
	public double getFecCorrected();

	/**
	 * Sets the fec corrected of this cable modem history.
	 *
	 * @param fecCorrected the fec corrected of this cable modem history
	 */
	public void setFecCorrected(double fecCorrected);

	/**
	 * Returns the micro ref of this cable modem history.
	 *
	 * @return the micro ref of this cable modem history
	 */
	public long getMicroRef();

	/**
	 * Sets the micro ref of this cable modem history.
	 *
	 * @param microRef the micro ref of this cable modem history
	 */
	public void setMicroRef(long microRef);

	/**
	 * Returns the rx power of this cable modem history.
	 *
	 * @return the rx power of this cable modem history
	 */
	public int getRxPower();

	/**
	 * Sets the rx power of this cable modem history.
	 *
	 * @param rxPower the rx power of this cable modem history
	 */
	public void setRxPower(int rxPower);

	/**
	 * Returns the tx power of this cable modem history.
	 *
	 * @return the tx power of this cable modem history
	 */
	public int getTxPower();

	/**
	 * Sets the tx power of this cable modem history.
	 *
	 * @param txPower the tx power of this cable modem history
	 */
	public void setTxPower(int txPower);

	/**
	 * Returns the us power of this cable modem history.
	 *
	 * @return the us power of this cable modem history
	 */
	public int getUsPower();

	/**
	 * Sets the us power of this cable modem history.
	 *
	 * @param usPower the us power of this cable modem history
	 */
	public void setUsPower(int usPower);

	/**
	 * Returns the ds power of this cable modem history.
	 *
	 * @return the ds power of this cable modem history
	 */
	public int getDsPower();

	/**
	 * Sets the ds power of this cable modem history.
	 *
	 * @param dsPower the ds power of this cable modem history
	 */
	public void setDsPower(int dsPower);

	/**
	 * Returns the uncorrectables of this cable modem history.
	 *
	 * @return the uncorrectables of this cable modem history
	 */
	public long getUncorrectables();

	/**
	 * Sets the uncorrectables of this cable modem history.
	 *
	 * @param uncorrectables the uncorrectables of this cable modem history
	 */
	public void setUncorrectables(long uncorrectables);

	/**
	 * Returns the correcteds of this cable modem history.
	 *
	 * @return the correcteds of this cable modem history
	 */
	public long getCorrecteds();

	/**
	 * Sets the correcteds of this cable modem history.
	 *
	 * @param correcteds the correcteds of this cable modem history
	 */
	public void setCorrecteds(long correcteds);

	/**
	 * Returns the unerroreds of this cable modem history.
	 *
	 * @return the unerroreds of this cable modem history
	 */
	public long getUnerroreds();

	/**
	 * Sets the unerroreds of this cable modem history.
	 *
	 * @param unerroreds the unerroreds of this cable modem history
	 */
	public void setUnerroreds(long unerroreds);

	/**
	 * Returns the ds s n r of this cable modem history.
	 *
	 * @return the ds s n r of this cable modem history
	 */
	public int getDsSNR();

	/**
	 * Sets the ds s n r of this cable modem history.
	 *
	 * @param dsSNR the ds s n r of this cable modem history
	 */
	public void setDsSNR(int dsSNR);

	/**
	 * Returns the us s n r of this cable modem history.
	 *
	 * @return the us s n r of this cable modem history
	 */
	public int getUsSNR();

	/**
	 * Sets the us s n r of this cable modem history.
	 *
	 * @param usSNR the us s n r of this cable modem history
	 */
	public void setUsSNR(int usSNR);

	/**
	 * Returns the uc if index of this cable modem history.
	 *
	 * @return the uc if index of this cable modem history
	 */
	public int getUcIfIndex();

	/**
	 * Sets the uc if index of this cable modem history.
	 *
	 * @param ucIfIndex the uc if index of this cable modem history
	 */
	public void setUcIfIndex(int ucIfIndex);

	/**
	 * Returns the dc if index of this cable modem history.
	 *
	 * @return the dc if index of this cable modem history
	 */
	public int getDcIfIndex();

	/**
	 * Sets the dc if index of this cable modem history.
	 *
	 * @param dcIfIndex the dc if index of this cable modem history
	 */
	public void setDcIfIndex(int dcIfIndex);

	/**
	 * Returns the cm sub index of this cable modem history.
	 *
	 * @return the cm sub index of this cable modem history
	 */
	@AutoEscape
	public String getCmSubIndex();

	/**
	 * Sets the cm sub index of this cable modem history.
	 *
	 * @param cmSubIndex the cm sub index of this cable modem history
	 */
	public void setCmSubIndex(String cmSubIndex);

	/**
	 * Returns the cmts ID of this cable modem history.
	 *
	 * @return the cmts ID of this cable modem history
	 */
	public long getCmtsId();

	/**
	 * Sets the cmts ID of this cable modem history.
	 *
	 * @param cmtsId the cmts ID of this cable modem history
	 */
	public void setCmtsId(long cmtsId);

	/**
	 * Returns the cm index of this cable modem history.
	 *
	 * @return the cm index of this cable modem history
	 */
	public int getCmIndex();

	/**
	 * Sets the cm index of this cable modem history.
	 *
	 * @param cmIndex the cm index of this cable modem history
	 */
	public void setCmIndex(int cmIndex);

	/**
	 * Returns the status of this cable modem history.
	 *
	 * @return the status of this cable modem history
	 */
	public int getStatus();

	/**
	 * Sets the status of this cable modem history.
	 *
	 * @param status the status of this cable modem history
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CableModemHistory cableModemHistory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CableModemHistory> toCacheModel();

	@Override
	public CableModemHistory toEscapedModel();

	@Override
	public CableModemHistory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}