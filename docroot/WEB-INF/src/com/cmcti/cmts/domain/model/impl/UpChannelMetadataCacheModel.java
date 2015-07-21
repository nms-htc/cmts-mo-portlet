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

import com.cmcti.cmts.domain.model.UpChannelMetadata;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UpChannelMetadata in entity cache.
 *
 * @author richard
 * @see UpChannelMetadata
 * @generated
 */
public class UpChannelMetadataCacheModel implements CacheModel<UpChannelMetadata>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{metaId=");
		sb.append(metaId);
		sb.append(", cmtsId=");
		sb.append(cmtsId);
		sb.append(", ifIndex=");
		sb.append(ifIndex);
		sb.append(", dsFrequency=");
		sb.append(dsFrequency);
		sb.append(", dsQam=");
		sb.append(dsQam);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UpChannelMetadata toEntityModel() {
		UpChannelMetadataImpl upChannelMetadataImpl = new UpChannelMetadataImpl();

		upChannelMetadataImpl.setMetaId(metaId);
		upChannelMetadataImpl.setCmtsId(cmtsId);
		upChannelMetadataImpl.setIfIndex(ifIndex);

		if (dsFrequency == null) {
			upChannelMetadataImpl.setDsFrequency(StringPool.BLANK);
		}
		else {
			upChannelMetadataImpl.setDsFrequency(dsFrequency);
		}

		if (dsQam == null) {
			upChannelMetadataImpl.setDsQam(StringPool.BLANK);
		}
		else {
			upChannelMetadataImpl.setDsQam(dsQam);
		}

		upChannelMetadataImpl.resetOriginalValues();

		return upChannelMetadataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		metaId = objectInput.readLong();
		cmtsId = objectInput.readLong();
		ifIndex = objectInput.readInt();
		dsFrequency = objectInput.readUTF();
		dsQam = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(metaId);
		objectOutput.writeLong(cmtsId);
		objectOutput.writeInt(ifIndex);

		if (dsFrequency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dsFrequency);
		}

		if (dsQam == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dsQam);
		}
	}

	public long metaId;
	public long cmtsId;
	public int ifIndex;
	public String dsFrequency;
	public String dsQam;
}