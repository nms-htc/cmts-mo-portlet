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

import com.cmcti.cmts.domain.model.CustomerMacMapping;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomerMacMapping in entity cache.
 *
 * @author richard
 * @see CustomerMacMapping
 * @generated
 */
public class CustomerMacMappingCacheModel implements CacheModel<CustomerMacMapping>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{customerMacId=");
		sb.append(customerMacId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", macAddress=");
		sb.append(macAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomerMacMapping toEntityModel() {
		CustomerMacMappingImpl customerMacMappingImpl = new CustomerMacMappingImpl();

		customerMacMappingImpl.setCustomerMacId(customerMacId);
		customerMacMappingImpl.setGroupId(groupId);
		customerMacMappingImpl.setCompanyId(companyId);
		customerMacMappingImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			customerMacMappingImpl.setCreateDate(null);
		}
		else {
			customerMacMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customerMacMappingImpl.setModifiedDate(null);
		}
		else {
			customerMacMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			customerMacMappingImpl.setTitle(StringPool.BLANK);
		}
		else {
			customerMacMappingImpl.setTitle(title);
		}

		if (macAddress == null) {
			customerMacMappingImpl.setMacAddress(StringPool.BLANK);
		}
		else {
			customerMacMappingImpl.setMacAddress(macAddress);
		}

		customerMacMappingImpl.resetOriginalValues();

		return customerMacMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerMacId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		macAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(customerMacId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (macAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(macAddress);
		}
	}

	public long customerMacId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String macAddress;
}