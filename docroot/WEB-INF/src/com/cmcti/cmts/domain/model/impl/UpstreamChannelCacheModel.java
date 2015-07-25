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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UpstreamChannel in entity cache.
 *
 * @author richard
 * @see UpstreamChannel
 * @generated
 */
public class UpstreamChannelCacheModel implements CacheModel<UpstreamChannel>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{ifIndex=");
		sb.append(ifIndex);
		sb.append(", cmtsId=");
		sb.append(cmtsId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", qam=");
		sb.append(qam);
		sb.append(", avgOnlineCmDsPower=");
		sb.append(avgOnlineCmDsPower);
		sb.append(", avgOnlineCmUsPower=");
		sb.append(avgOnlineCmUsPower);
		sb.append(", avgOnlineCmMicRef=");
		sb.append(avgOnlineCmMicRef);
		sb.append(", avgOnlineCmDsSNR=");
		sb.append(avgOnlineCmDsSNR);
		sb.append(", avgOnlineCmTxPower=");
		sb.append(avgOnlineCmTxPower);
		sb.append(", avgOnlineCmRxPower=");
		sb.append(avgOnlineCmRxPower);
		sb.append(", fecUncorrectable=");
		sb.append(fecUncorrectable);
		sb.append(", fecCorrected=");
		sb.append(fecCorrected);
		sb.append(", upChannelCmTotal=");
		sb.append(upChannelCmTotal);
		sb.append(", upChannelCmRegistered=");
		sb.append(upChannelCmRegistered);
		sb.append(", upChannelCmActive=");
		sb.append(upChannelCmActive);
		sb.append(", upChannelModProfile=");
		sb.append(upChannelModProfile);
		sb.append(", upChannelWidth=");
		sb.append(upChannelWidth);
		sb.append(", upChannelFrequency=");
		sb.append(upChannelFrequency);
		sb.append(", ifSigQUncorrectables=");
		sb.append(ifSigQUncorrectables);
		sb.append(", ifSigQCorrecteds=");
		sb.append(ifSigQCorrecteds);
		sb.append(", ifSigQUnerroreds=");
		sb.append(ifSigQUnerroreds);
		sb.append(", ifSigQSNR=");
		sb.append(ifSigQSNR);
		sb.append(", ifAlias=");
		sb.append(ifAlias);
		sb.append(", ifDesc=");
		sb.append(ifDesc);
		sb.append(", exist=");
		sb.append(exist);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UpstreamChannel toEntityModel() {
		UpstreamChannelImpl upstreamChannelImpl = new UpstreamChannelImpl();

		upstreamChannelImpl.setIfIndex(ifIndex);
		upstreamChannelImpl.setCmtsId(cmtsId);

		if (createDate == Long.MIN_VALUE) {
			upstreamChannelImpl.setCreateDate(null);
		}
		else {
			upstreamChannelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			upstreamChannelImpl.setModifiedDate(null);
		}
		else {
			upstreamChannelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (qam == null) {
			upstreamChannelImpl.setQam(StringPool.BLANK);
		}
		else {
			upstreamChannelImpl.setQam(qam);
		}

		upstreamChannelImpl.setAvgOnlineCmDsPower(avgOnlineCmDsPower);
		upstreamChannelImpl.setAvgOnlineCmUsPower(avgOnlineCmUsPower);
		upstreamChannelImpl.setAvgOnlineCmMicRef(avgOnlineCmMicRef);
		upstreamChannelImpl.setAvgOnlineCmDsSNR(avgOnlineCmDsSNR);
		upstreamChannelImpl.setAvgOnlineCmTxPower(avgOnlineCmTxPower);
		upstreamChannelImpl.setAvgOnlineCmRxPower(avgOnlineCmRxPower);
		upstreamChannelImpl.setFecUncorrectable(fecUncorrectable);
		upstreamChannelImpl.setFecCorrected(fecCorrected);
		upstreamChannelImpl.setUpChannelCmTotal(upChannelCmTotal);
		upstreamChannelImpl.setUpChannelCmRegistered(upChannelCmRegistered);
		upstreamChannelImpl.setUpChannelCmActive(upChannelCmActive);
		upstreamChannelImpl.setUpChannelModProfile(upChannelModProfile);
		upstreamChannelImpl.setUpChannelWidth(upChannelWidth);
		upstreamChannelImpl.setUpChannelFrequency(upChannelFrequency);
		upstreamChannelImpl.setIfSigQUncorrectables(ifSigQUncorrectables);
		upstreamChannelImpl.setIfSigQCorrecteds(ifSigQCorrecteds);
		upstreamChannelImpl.setIfSigQUnerroreds(ifSigQUnerroreds);
		upstreamChannelImpl.setIfSigQSNR(ifSigQSNR);

		if (ifAlias == null) {
			upstreamChannelImpl.setIfAlias(StringPool.BLANK);
		}
		else {
			upstreamChannelImpl.setIfAlias(ifAlias);
		}

		if (ifDesc == null) {
			upstreamChannelImpl.setIfDesc(StringPool.BLANK);
		}
		else {
			upstreamChannelImpl.setIfDesc(ifDesc);
		}

		upstreamChannelImpl.setExist(exist);

		upstreamChannelImpl.resetOriginalValues();

		return upstreamChannelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ifIndex = objectInput.readInt();
		cmtsId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		qam = objectInput.readUTF();
		avgOnlineCmDsPower = objectInput.readDouble();
		avgOnlineCmUsPower = objectInput.readDouble();
		avgOnlineCmMicRef = objectInput.readDouble();
		avgOnlineCmDsSNR = objectInput.readDouble();
		avgOnlineCmTxPower = objectInput.readDouble();
		avgOnlineCmRxPower = objectInput.readDouble();
		fecUncorrectable = objectInput.readDouble();
		fecCorrected = objectInput.readDouble();
		upChannelCmTotal = objectInput.readInt();
		upChannelCmRegistered = objectInput.readInt();
		upChannelCmActive = objectInput.readInt();
		upChannelModProfile = objectInput.readInt();
		upChannelWidth = objectInput.readLong();
		upChannelFrequency = objectInput.readLong();
		ifSigQUncorrectables = objectInput.readLong();
		ifSigQCorrecteds = objectInput.readLong();
		ifSigQUnerroreds = objectInput.readLong();
		ifSigQSNR = objectInput.readDouble();
		ifAlias = objectInput.readUTF();
		ifDesc = objectInput.readUTF();
		exist = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ifIndex);
		objectOutput.writeLong(cmtsId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (qam == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qam);
		}

		objectOutput.writeDouble(avgOnlineCmDsPower);
		objectOutput.writeDouble(avgOnlineCmUsPower);
		objectOutput.writeDouble(avgOnlineCmMicRef);
		objectOutput.writeDouble(avgOnlineCmDsSNR);
		objectOutput.writeDouble(avgOnlineCmTxPower);
		objectOutput.writeDouble(avgOnlineCmRxPower);
		objectOutput.writeDouble(fecUncorrectable);
		objectOutput.writeDouble(fecCorrected);
		objectOutput.writeInt(upChannelCmTotal);
		objectOutput.writeInt(upChannelCmRegistered);
		objectOutput.writeInt(upChannelCmActive);
		objectOutput.writeInt(upChannelModProfile);
		objectOutput.writeLong(upChannelWidth);
		objectOutput.writeLong(upChannelFrequency);
		objectOutput.writeLong(ifSigQUncorrectables);
		objectOutput.writeLong(ifSigQCorrecteds);
		objectOutput.writeLong(ifSigQUnerroreds);
		objectOutput.writeDouble(ifSigQSNR);

		if (ifAlias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ifAlias);
		}

		if (ifDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ifDesc);
		}

		objectOutput.writeBoolean(exist);
	}

	public int ifIndex;
	public long cmtsId;
	public long createDate;
	public long modifiedDate;
	public String qam;
	public double avgOnlineCmDsPower;
	public double avgOnlineCmUsPower;
	public double avgOnlineCmMicRef;
	public double avgOnlineCmDsSNR;
	public double avgOnlineCmTxPower;
	public double avgOnlineCmRxPower;
	public double fecUncorrectable;
	public double fecCorrected;
	public int upChannelCmTotal;
	public int upChannelCmRegistered;
	public int upChannelCmActive;
	public int upChannelModProfile;
	public long upChannelWidth;
	public long upChannelFrequency;
	public long ifSigQUncorrectables;
	public long ifSigQCorrecteds;
	public long ifSigQUnerroreds;
	public double ifSigQSNR;
	public String ifAlias;
	public String ifDesc;
	public boolean exist;
}