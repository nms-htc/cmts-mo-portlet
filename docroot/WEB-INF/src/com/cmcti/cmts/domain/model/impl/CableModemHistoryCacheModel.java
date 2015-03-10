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

import com.cmcti.cmts.domain.model.CableModemHistory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CableModemHistory in entity cache.
 *
 * @author richard
 * @see CableModemHistory
 * @generated
 */
public class CableModemHistoryCacheModel implements CacheModel<CableModemHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{macAddress=");
		sb.append(macAddress);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", fecUncorrectable=");
		sb.append(fecUncorrectable);
		sb.append(", fecCorrected=");
		sb.append(fecCorrected);
		sb.append(", microRef=");
		sb.append(microRef);
		sb.append(", rxPower=");
		sb.append(rxPower);
		sb.append(", txPower=");
		sb.append(txPower);
		sb.append(", usPower=");
		sb.append(usPower);
		sb.append(", dsPower=");
		sb.append(dsPower);
		sb.append(", uncorrectables=");
		sb.append(uncorrectables);
		sb.append(", correcteds=");
		sb.append(correcteds);
		sb.append(", unerroreds=");
		sb.append(unerroreds);
		sb.append(", dsSNR=");
		sb.append(dsSNR);
		sb.append(", usSNR=");
		sb.append(usSNR);
		sb.append(", ucIfIndex=");
		sb.append(ucIfIndex);
		sb.append(", dcIfIndex=");
		sb.append(dcIfIndex);
		sb.append(", cmSubIndex=");
		sb.append(cmSubIndex);
		sb.append(", cmtsId=");
		sb.append(cmtsId);
		sb.append(", cmIndex=");
		sb.append(cmIndex);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CableModemHistory toEntityModel() {
		CableModemHistoryImpl cableModemHistoryImpl = new CableModemHistoryImpl();

		if (macAddress == null) {
			cableModemHistoryImpl.setMacAddress(StringPool.BLANK);
		}
		else {
			cableModemHistoryImpl.setMacAddress(macAddress);
		}

		if (createDate == Long.MIN_VALUE) {
			cableModemHistoryImpl.setCreateDate(null);
		}
		else {
			cableModemHistoryImpl.setCreateDate(new Date(createDate));
		}

		cableModemHistoryImpl.setFecUncorrectable(fecUncorrectable);
		cableModemHistoryImpl.setFecCorrected(fecCorrected);
		cableModemHistoryImpl.setMicroRef(microRef);
		cableModemHistoryImpl.setRxPower(rxPower);
		cableModemHistoryImpl.setTxPower(txPower);
		cableModemHistoryImpl.setUsPower(usPower);
		cableModemHistoryImpl.setDsPower(dsPower);
		cableModemHistoryImpl.setUncorrectables(uncorrectables);
		cableModemHistoryImpl.setCorrecteds(correcteds);
		cableModemHistoryImpl.setUnerroreds(unerroreds);
		cableModemHistoryImpl.setDsSNR(dsSNR);
		cableModemHistoryImpl.setUsSNR(usSNR);
		cableModemHistoryImpl.setUcIfIndex(ucIfIndex);
		cableModemHistoryImpl.setDcIfIndex(dcIfIndex);

		if (cmSubIndex == null) {
			cableModemHistoryImpl.setCmSubIndex(StringPool.BLANK);
		}
		else {
			cableModemHistoryImpl.setCmSubIndex(cmSubIndex);
		}

		cableModemHistoryImpl.setCmtsId(cmtsId);
		cableModemHistoryImpl.setCmIndex(cmIndex);
		cableModemHistoryImpl.setStatus(status);

		cableModemHistoryImpl.resetOriginalValues();

		return cableModemHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		macAddress = objectInput.readUTF();
		createDate = objectInput.readLong();
		fecUncorrectable = objectInput.readDouble();
		fecCorrected = objectInput.readDouble();
		microRef = objectInput.readLong();
		rxPower = objectInput.readInt();
		txPower = objectInput.readInt();
		usPower = objectInput.readInt();
		dsPower = objectInput.readInt();
		uncorrectables = objectInput.readLong();
		correcteds = objectInput.readLong();
		unerroreds = objectInput.readLong();
		dsSNR = objectInput.readInt();
		usSNR = objectInput.readInt();
		ucIfIndex = objectInput.readInt();
		dcIfIndex = objectInput.readInt();
		cmSubIndex = objectInput.readUTF();
		cmtsId = objectInput.readLong();
		cmIndex = objectInput.readInt();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (macAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(macAddress);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeDouble(fecUncorrectable);
		objectOutput.writeDouble(fecCorrected);
		objectOutput.writeLong(microRef);
		objectOutput.writeInt(rxPower);
		objectOutput.writeInt(txPower);
		objectOutput.writeInt(usPower);
		objectOutput.writeInt(dsPower);
		objectOutput.writeLong(uncorrectables);
		objectOutput.writeLong(correcteds);
		objectOutput.writeLong(unerroreds);
		objectOutput.writeInt(dsSNR);
		objectOutput.writeInt(usSNR);
		objectOutput.writeInt(ucIfIndex);
		objectOutput.writeInt(dcIfIndex);

		if (cmSubIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cmSubIndex);
		}

		objectOutput.writeLong(cmtsId);
		objectOutput.writeInt(cmIndex);
		objectOutput.writeInt(status);
	}

	public String macAddress;
	public long createDate;
	public double fecUncorrectable;
	public double fecCorrected;
	public long microRef;
	public int rxPower;
	public int txPower;
	public int usPower;
	public int dsPower;
	public long uncorrectables;
	public long correcteds;
	public long unerroreds;
	public int dsSNR;
	public int usSNR;
	public int ucIfIndex;
	public int dcIfIndex;
	public String cmSubIndex;
	public long cmtsId;
	public int cmIndex;
	public int status;
}