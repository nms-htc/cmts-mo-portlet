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

import com.cmcti.cmts.domain.model.Cmts;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cmts in entity cache.
 *
 * @author richard
 * @see Cmts
 * @generated
 */
public class CmtsCacheModel implements CacheModel<Cmts>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{cmtsId=");
		sb.append(cmtsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", host=");
		sb.append(host);
		sb.append(", community=");
		sb.append(community);
		sb.append(", description=");
		sb.append(description);
		sb.append(", enable=");
		sb.append(enable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cmts toEntityModel() {
		CmtsImpl cmtsImpl = new CmtsImpl();

		cmtsImpl.setCmtsId(cmtsId);
		cmtsImpl.setGroupId(groupId);
		cmtsImpl.setCompanyId(companyId);
		cmtsImpl.setUserId(userId);

		if (userName == null) {
			cmtsImpl.setUserName(StringPool.BLANK);
		}
		else {
			cmtsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cmtsImpl.setCreateDate(null);
		}
		else {
			cmtsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cmtsImpl.setModifiedDate(null);
		}
		else {
			cmtsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			cmtsImpl.setTitle(StringPool.BLANK);
		}
		else {
			cmtsImpl.setTitle(title);
		}

		if (host == null) {
			cmtsImpl.setHost(StringPool.BLANK);
		}
		else {
			cmtsImpl.setHost(host);
		}

		if (community == null) {
			cmtsImpl.setCommunity(StringPool.BLANK);
		}
		else {
			cmtsImpl.setCommunity(community);
		}

		if (description == null) {
			cmtsImpl.setDescription(StringPool.BLANK);
		}
		else {
			cmtsImpl.setDescription(description);
		}

		cmtsImpl.setEnable(enable);

		cmtsImpl.resetOriginalValues();

		return cmtsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cmtsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		host = objectInput.readUTF();
		community = objectInput.readUTF();
		description = objectInput.readUTF();
		enable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cmtsId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (host == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(host);
		}

		if (community == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(community);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(enable);
	}

	public long cmtsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String host;
	public String community;
	public String description;
	public boolean enable;
}