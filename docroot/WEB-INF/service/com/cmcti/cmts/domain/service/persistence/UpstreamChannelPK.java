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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author richard
 * @generated
 */
public class UpstreamChannelPK implements Comparable<UpstreamChannelPK>,
	Serializable {
	public int ifIndex;
	public long cmtsId;

	public UpstreamChannelPK() {
	}

	public UpstreamChannelPK(int ifIndex, long cmtsId) {
		this.ifIndex = ifIndex;
		this.cmtsId = cmtsId;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	public long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		this.cmtsId = cmtsId;
	}

	@Override
	public int compareTo(UpstreamChannelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpstreamChannelPK)) {
			return false;
		}

		UpstreamChannelPK pk = (UpstreamChannelPK)obj;

		if ((ifIndex == pk.ifIndex) && (cmtsId == pk.cmtsId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(ifIndex) + String.valueOf(cmtsId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("ifIndex");
		sb.append(StringPool.EQUAL);
		sb.append(ifIndex);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("cmtsId");
		sb.append(StringPool.EQUAL);
		sb.append(cmtsId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}