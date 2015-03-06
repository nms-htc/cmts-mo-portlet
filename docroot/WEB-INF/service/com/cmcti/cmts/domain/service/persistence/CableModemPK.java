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
public class CableModemPK implements Comparable<CableModemPK>, Serializable {
	public long cmtsId;
	public int cmIndex;

	public CableModemPK() {
	}

	public CableModemPK(long cmtsId, int cmIndex) {
		this.cmtsId = cmtsId;
		this.cmIndex = cmIndex;
	}

	public long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		this.cmtsId = cmtsId;
	}

	public int getCmIndex() {
		return cmIndex;
	}

	public void setCmIndex(int cmIndex) {
		this.cmIndex = cmIndex;
	}

	@Override
	public int compareTo(CableModemPK pk) {
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

		if (cmIndex < pk.cmIndex) {
			value = -1;
		}
		else if (cmIndex > pk.cmIndex) {
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

		if (!(obj instanceof CableModemPK)) {
			return false;
		}

		CableModemPK pk = (CableModemPK)obj;

		if ((cmtsId == pk.cmtsId) && (cmIndex == pk.cmIndex)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(cmtsId) + String.valueOf(cmIndex)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("cmtsId");
		sb.append(StringPool.EQUAL);
		sb.append(cmtsId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("cmIndex");
		sb.append(StringPool.EQUAL);
		sb.append(cmIndex);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}