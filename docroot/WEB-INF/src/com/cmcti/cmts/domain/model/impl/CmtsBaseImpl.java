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
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Cmts service. Represents a row in the &quot;CMTS_Cmts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CmtsImpl}.
 * </p>
 *
 * @author richard
 * @see CmtsImpl
 * @see com.cmcti.cmts.domain.model.Cmts
 * @generated
 */
public abstract class CmtsBaseImpl extends CmtsModelImpl implements Cmts {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cmts model instance should use the {@link Cmts} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CmtsLocalServiceUtil.addCmts(this);
		}
		else {
			CmtsLocalServiceUtil.updateCmts(this);
		}
	}
}