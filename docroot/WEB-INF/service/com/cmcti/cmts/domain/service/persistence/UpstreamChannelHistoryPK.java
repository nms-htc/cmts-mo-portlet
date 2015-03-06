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
public class UpstreamChannelHistoryPK implements Comparable<UpstreamChannelHistoryPK>,
	Serializable {
	public long cmtsId;
	public int ifIndex;
	public Date createDate;

	public UpstreamChannelHistoryPK() {
	}

	public UpstreamChannelHistoryPK(long cmtsId, int ifIndex, Date createDate) {
		this.cmtsId = cmtsId;
		this.ifIndex = ifIndex;
		this.createDate = createDate;
	}

	public long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		this.cmtsId = cmtsId;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int compareTo(UpstreamChannelHistoryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (cmtsId < pk.cmtsId) {
			value = -1;
		}
		else if (cmtsId > pk.cmtsId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (ifIndex < pk.ifIndex) {
			value = -1;
		}
		else if (ifIndex > pk.ifIndex) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof UpstreamChannelHistoryPK)) {
			return false;
		}

		UpstreamChannelHistoryPK pk = (UpstreamChannelHistoryPK)obj;

		if ((cmtsId == pk.cmtsId) && (ifIndex == pk.ifIndex) &&
				(createDate.equals(pk.createDate))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(cmtsId) + String.valueOf(ifIndex) +
		createDate.toString()).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("cmtsId");
		sb.append(StringPool.EQUAL);
		sb.append(cmtsId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("ifIndex");
		sb.append(StringPool.EQUAL);
		sb.append(ifIndex);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("createDate");
		sb.append(StringPool.EQUAL);
		sb.append(createDate);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}