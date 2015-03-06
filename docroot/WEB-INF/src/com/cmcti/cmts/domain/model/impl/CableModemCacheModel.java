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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CableModem in entity cache.
 *
 * @author richard
 * @see CableModem
 * @generated
 */
public class CableModemCacheModel implements CacheModel<CableModem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{macAddress=");
		sb.append(macAddress);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CableModem toEntityModel() {
		CableModemImpl cableModemImpl = new CableModemImpl();

		if (macAddress == null) {
			cableModemImpl.setMacAddress(StringPool.BLANK);
		}
		else {
			cableModemImpl.setMacAddress(macAddress);
		}

		if (createDate == Long.MIN_VALUE) {
			cableModemImpl.setCreateDate(null);
		}
		else {
			cableModemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cableModemImpl.setModifiedDate(null);
		}
		else {
			cableModemImpl.setModifiedDate(new Date(modifiedDate));
		}

		cableModemImpl.setFecUncorrectable(fecUncorrectable);
		cableModemImpl.setFecCorrected(fecCorrected);
		cableModemImpl.setMicroRef(microRef);
		cableModemImpl.setRxPower(rxPower);
		cableModemImpl.setTxPower(txPower);
		cableModemImpl.setUsPower(usPower);
		cableModemImpl.setDsPower(dsPower);
		cableModemImpl.setUncorrectables(uncorrectables);
		cableModemImpl.setCorrecteds(correcteds);
		cableModemImpl.setUnerroreds(unerroreds);
		cableModemImpl.setDsSNR(dsSNR);
		cableModemImpl.setUsSNR(usSNR);
		cableModemImpl.setUcIfIndex(ucIfIndex);
		cableModemImpl.setDcIfIndex(dcIfIndex);

		if (cmSubIndex == null) {
			cableModemImpl.setCmSubIndex(StringPool.BLANK);
		}
		else {
			cableModemImpl.setCmSubIndex(cmSubIndex);
		}

		cableModemImpl.setCmtsId(cmtsId);
		cableModemImpl.setCmIndex(cmIndex);

		cableModemImpl.resetOriginalValues();

		return cableModemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		macAddress = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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
		objectOutput.writeLong(modifiedDate);
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
	}

	public String macAddress;
	public long createDate;
	public long modifiedDate;
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
}