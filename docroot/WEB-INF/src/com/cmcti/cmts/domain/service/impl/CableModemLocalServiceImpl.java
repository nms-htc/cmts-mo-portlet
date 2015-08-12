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

package com.cmcti.cmts.domain.service.impl;

import java.util.List;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.service.base.CableModemLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the cable modem local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmcti.cmts.domain.service.CableModemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.CableModemLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.CableModemLocalServiceUtil
 */
public class CableModemLocalServiceImpl extends CableModemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmcti.cmts.domain.service.CableModemLocalServiceUtil} to access the cable modem local service.
	 */
	
	@SuppressWarnings({"rawtypes" })
	public List getAvgValueForUpstream(long cmtsId, int ifIndex, int status) throws SystemException {
		
		DynamicQuery query = dynamicQuery();
		
		// restrictions
		query.add(RestrictionsFactoryUtil.eq("cmtsId", cmtsId));
		query.add(RestrictionsFactoryUtil.eq("ucIfIndex", ifIndex));
		query.add(RestrictionsFactoryUtil.eq("status", status));
		query.add(RestrictionsFactoryUtil.ne("dsSNR", 0));
		query.add(RestrictionsFactoryUtil.ne("usPower", 0));
		query.add(RestrictionsFactoryUtil.ne("dsSNR", 129));
		query.add(RestrictionsFactoryUtil.ne("usPower", 129));
		
		// projection
		query.setProjection(ProjectionFactoryUtil.projectionList()
				.add(ProjectionFactoryUtil.avg("microRef"))
				.add(ProjectionFactoryUtil.avg("rxPower"))
				.add(ProjectionFactoryUtil.avg("txPower"))
				.add(ProjectionFactoryUtil.avg("usPower"))
				.add(ProjectionFactoryUtil.avg("dsPower"))
				.add(ProjectionFactoryUtil.avg("dsSNR")));
		
		query.setLimit(0, 1);
		
		return dynamicQuery(query);
	}
	
	@SuppressWarnings("unchecked")
	public List<CableModem> findByMacAddress(String macAddress, int maxResults) throws SystemException {
		DynamicQuery query = dynamicQuery();
		
		query.add(RestrictionsFactoryUtil.ilike("macAddress", "%" + macAddress + "%"));
		
		query.setLimit(0, maxResults);
		
		return dynamicQuery(query);
	}
	
}