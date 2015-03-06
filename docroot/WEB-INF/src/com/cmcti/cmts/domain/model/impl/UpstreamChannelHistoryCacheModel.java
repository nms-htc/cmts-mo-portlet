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

import com.cmcti.cmts.domain.model.UpstreamChannelHistory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UpstreamChannelHistory in entity cache.
 *
 * @author richard
 * @see UpstreamChannelHistory
 * @generated
 */
public class UpstreamChannelHistoryCacheModel implements CacheModel<UpstreamChannelHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{cmtsId=");
		sb.append(cmtsId);
		sb.append(", ifIndex=");
		sb.append(ifIndex);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", qam=");
		sb.append(qam);
		sb.append(", avgOnlineCmMicRef=");
		sb.append(avgOnlineCmMicRef);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UpstreamChannelHistory toEntityModel() {
		UpstreamChannelHistoryImpl upstreamChannelHistoryImpl = new UpstreamChannelHistoryImpl();

		upstreamChannelHistoryImpl.setCmtsId(cmtsId);
		upstreamChannelHistoryImpl.setIfIndex(ifIndex);

		if (createDate == Long.MIN_VALUE) {
			upstreamChannelHistoryImpl.setCreateDate(null);
		}
		else {
			upstreamChannelHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (qam == null) {
			upstreamChannelHistoryImpl.setQam(StringPool.BLANK);
		}
		else {
			upstreamChannelHistoryImpl.setQam(qam);
		}

		upstreamChannelHistoryImpl.setAvgOnlineCmMicRef(avgOnlineCmMicRef);
		upstreamChannelHistoryImpl.setAvgOnlineCmTxPower(avgOnlineCmTxPower);
		upstreamChannelHistoryImpl.setAvgOnlineCmRxPower(avgOnlineCmRxPower);
		upstreamChannelHistoryImpl.setFecUncorrectable(fecUncorrectable);
		upstreamChannelHistoryImpl.setFecCorrected(fecCorrected);
		upstreamChannelHistoryImpl.setUpChannelCmTotal(upChannelCmTotal);
		upstreamChannelHistoryImpl.setUpChannelCmRegistered(upChannelCmRegistered);
		upstreamChannelHistoryImpl.setUpChannelCmActive(upChannelCmActive);
		upstreamChannelHistoryImpl.setUpChannelModProfile(upChannelModProfile);
		upstreamChannelHistoryImpl.setUpChannelWidth(upChannelWidth);
		upstreamChannelHistoryImpl.setUpChannelFrequency(upChannelFrequency);
		upstreamChannelHistoryImpl.setIfSigQUncorrectables(ifSigQUncorrectables);
		upstreamChannelHistoryImpl.setIfSigQCorrecteds(ifSigQCorrecteds);
		upstreamChannelHistoryImpl.setIfSigQUnerroreds(ifSigQUnerroreds);
		upstreamChannelHistoryImpl.setIfSigQSNR(ifSigQSNR);

		if (ifAlias == null) {
			upstreamChannelHistoryImpl.setIfAlias(StringPool.BLANK);
		}
		else {
			upstreamChannelHistoryImpl.setIfAlias(ifAlias);
		}

		if (ifDesc == null) {
			upstreamChannelHistoryImpl.setIfDesc(StringPool.BLANK);
		}
		else {
			upstreamChannelHistoryImpl.setIfDesc(ifDesc);
		}

		upstreamChannelHistoryImpl.resetOriginalValues();

		return upstreamChannelHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cmtsId = objectInput.readLong();
		ifIndex = objectInput.readInt();
		createDate = objectInput.readLong();
		qam = objectInput.readUTF();
		avgOnlineCmMicRef = objectInput.readDouble();
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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cmtsId);
		objectOutput.writeInt(ifIndex);
		objectOutput.writeLong(createDate);

		if (qam == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qam);
		}

		objectOutput.writeDouble(avgOnlineCmMicRef);
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
	}

	public long cmtsId;
	public int ifIndex;
	public long createDate;
	public String qam;
	public double avgOnlineCmMicRef;
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
}