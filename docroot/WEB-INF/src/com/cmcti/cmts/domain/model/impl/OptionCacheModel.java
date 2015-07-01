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

import com.cmcti.cmts.domain.model.Option;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Option in entity cache.
 *
 * @author richard
 * @see Option
 * @generated
 */
public class OptionCacheModel implements CacheModel<Option>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{optionId=");
		sb.append(optionId);
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
		sb.append(", optionType=");
		sb.append(optionType);
		sb.append(", optionKey=");
		sb.append(optionKey);
		sb.append(", optionValue=");
		sb.append(optionValue);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Option toEntityModel() {
		OptionImpl optionImpl = new OptionImpl();

		optionImpl.setOptionId(optionId);
		optionImpl.setGroupId(groupId);
		optionImpl.setCompanyId(companyId);
		optionImpl.setUserId(userId);

		if (userName == null) {
			optionImpl.setUserName(StringPool.BLANK);
		}
		else {
			optionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			optionImpl.setCreateDate(null);
		}
		else {
			optionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			optionImpl.setModifiedDate(null);
		}
		else {
			optionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (optionType == null) {
			optionImpl.setOptionType(StringPool.BLANK);
		}
		else {
			optionImpl.setOptionType(optionType);
		}

		if (optionKey == null) {
			optionImpl.setOptionKey(StringPool.BLANK);
		}
		else {
			optionImpl.setOptionKey(optionKey);
		}

		if (optionValue == null) {
			optionImpl.setOptionValue(StringPool.BLANK);
		}
		else {
			optionImpl.setOptionValue(optionValue);
		}

		if (description == null) {
			optionImpl.setDescription(StringPool.BLANK);
		}
		else {
			optionImpl.setDescription(description);
		}

		optionImpl.resetOriginalValues();

		return optionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		optionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		optionType = objectInput.readUTF();
		optionKey = objectInput.readUTF();
		optionValue = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(optionId);
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

		if (optionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionType);
		}

		if (optionKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionKey);
		}

		if (optionValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionValue);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long optionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String optionType;
	public String optionKey;
	public String optionValue;
	public String description;
}