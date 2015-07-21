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

import com.cmcti.cmts.domain.model.MerchantScope;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MerchantScope in entity cache.
 *
 * @author richard
 * @see MerchantScope
 * @generated
 */
public class MerchantScopeCacheModel implements CacheModel<MerchantScope>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{merchantScopeId=");
		sb.append(merchantScopeId);
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
		sb.append(", cmtsId=");
		sb.append(cmtsId);
		sb.append(", ifIndex=");
		sb.append(ifIndex);
		sb.append(", merchantCode=");
		sb.append(merchantCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MerchantScope toEntityModel() {
		MerchantScopeImpl merchantScopeImpl = new MerchantScopeImpl();

		merchantScopeImpl.setMerchantScopeId(merchantScopeId);
		merchantScopeImpl.setGroupId(groupId);
		merchantScopeImpl.setCompanyId(companyId);
		merchantScopeImpl.setUserId(userId);

		if (userName == null) {
			merchantScopeImpl.setUserName(StringPool.BLANK);
		}
		else {
			merchantScopeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			merchantScopeImpl.setCreateDate(null);
		}
		else {
			merchantScopeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			merchantScopeImpl.setModifiedDate(null);
		}
		else {
			merchantScopeImpl.setModifiedDate(new Date(modifiedDate));
		}

		merchantScopeImpl.setCmtsId(cmtsId);
		merchantScopeImpl.setIfIndex(ifIndex);

		if (merchantCode == null) {
			merchantScopeImpl.setMerchantCode(StringPool.BLANK);
		}
		else {
			merchantScopeImpl.setMerchantCode(merchantCode);
		}

		merchantScopeImpl.resetOriginalValues();

		return merchantScopeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		merchantScopeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		cmtsId = objectInput.readLong();
		ifIndex = objectInput.readInt();
		merchantCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(merchantScopeId);
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
		objectOutput.writeLong(cmtsId);
		objectOutput.writeInt(ifIndex);

		if (merchantCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(merchantCode);
		}
	}

	public long merchantScopeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long cmtsId;
	public int ifIndex;
	public String merchantCode;
}