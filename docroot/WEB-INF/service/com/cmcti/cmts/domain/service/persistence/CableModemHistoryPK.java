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

package com.cmcti.cmts.domain.service.persistence;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author richard
 * @generated
 */
public class CableModemHistoryPK implements Comparable<CableModemHistoryPK>,
	Serializable {
	public String macAddress;
	public Date createDate;

	public CableModemHistoryPK() {
	}

	public CableModemHistoryPK(String macAddress, Date createDate) {
		this.macAddress = macAddress;
		this.createDate = createDate;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int compareTo(CableModemHistoryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = macAddress.compareTo(pk.macAddress);

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(createDate, pk.createDate);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CableModemHistoryPK)) {
			return false;
		}

		CableModemHistoryPK pk = (CableModemHistoryPK)obj;

		if ((macAddress.equals(pk.macAddress)) &&
				(createDate.equals(pk.createDate))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(macAddress) + createDate.toString()).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("macAddress");
		sb.append(StringPool.EQUAL);
		sb.append(macAddress);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("createDate");
		sb.append(StringPool.EQUAL);
		sb.append(createDate);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}