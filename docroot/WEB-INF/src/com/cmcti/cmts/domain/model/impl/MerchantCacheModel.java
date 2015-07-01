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

import com.cmcti.cmts.domain.model.Merchant;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Merchant in entity cache.
 *
 * @author richard
 * @see Merchant
 * @generated
 */
public class MerchantCacheModel implements CacheModel<Merchant>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{merchantId=");
		sb.append(merchantId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", parentCode=");
		sb.append(parentCode);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Merchant toEntityModel() {
		MerchantImpl merchantImpl = new MerchantImpl();

		merchantImpl.setMerchantId(merchantId);
		merchantImpl.setGroupId(groupId);
		merchantImpl.setCompanyId(companyId);
		merchantImpl.setUserId(userId);

		if (userName == null) {
			merchantImpl.setUserName(StringPool.BLANK);
		}
		else {
			merchantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			merchantImpl.setCreateDate(null);
		}
		else {
			merchantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			merchantImpl.setModifiedDate(null);
		}
		else {
			merchantImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			merchantImpl.setTitle(StringPool.BLANK);
		}
		else {
			merchantImpl.setTitle(title);
		}

		if (code == null) {
			merchantImpl.setCode(StringPool.BLANK);
		}
		else {
			merchantImpl.setCode(code);
		}

		merchantImpl.setParentId(parentId);

		if (parentCode == null) {
			merchantImpl.setParentCode(StringPool.BLANK);
		}
		else {
			merchantImpl.setParentCode(parentCode);
		}

		if (description == null) {
			merchantImpl.setDescription(StringPool.BLANK);
		}
		else {
			merchantImpl.setDescription(description);
		}

		merchantImpl.resetOriginalValues();

		return merchantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		merchantId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		code = objectInput.readUTF();
		parentId = objectInput.readLong();
		parentCode = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(merchantId);
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

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(parentId);

		if (parentCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parentCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long merchantId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String code;
	public long parentId;
	public String parentCode;
	public String description;
}