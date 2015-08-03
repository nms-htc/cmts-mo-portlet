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

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.base.UpstreamChannelLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the upstream channel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmcti.cmts.domain.service.UpstreamChannelLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.UpstreamChannelLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil
 */
public class UpstreamChannelLocalServiceImpl
	extends UpstreamChannelLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil} to access the upstream channel local service.
	 */
	
	public List<UpstreamChannel> fetchByCmtsId(long cmtsId) throws SystemException {
		return upstreamChannelPersistence.findByCmts(cmtsId);
	}
	
	@SuppressWarnings("rawtypes")
	public List getSumCmCounts(DynamicQuery query) throws SystemException {
		// projection
		query.setProjection(ProjectionFactoryUtil.projectionList()
				.add(ProjectionFactoryUtil.sum("upChannelCmTotal"))
				.add(ProjectionFactoryUtil.sum("upChannelCmRegistered"))
				.add(ProjectionFactoryUtil.sum("upChannelCmActive")));
		
		query.setLimit(0, 1);
		return dynamicQuery(query);
	}
}