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

package com.cmcti.cmts.domain.service.messaging;

import com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.CableModemHistoryServiceUtil;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CableModemServiceUtil;
import com.cmcti.cmts.domain.service.ClpSerializer;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.domain.service.CmtsServiceUtil;
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;
import com.cmcti.cmts.domain.service.CustomerMacMappingServiceUtil;
import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;
import com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil;
import com.cmcti.cmts.domain.service.MerchantScopeServiceUtil;
import com.cmcti.cmts.domain.service.MerchantServiceUtil;
import com.cmcti.cmts.domain.service.OptionLocalServiceUtil;
import com.cmcti.cmts.domain.service.OptionServiceUtil;
import com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpChannelMetadataServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelHistoryServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author richard
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CableModemLocalServiceUtil.clearService();

			CableModemServiceUtil.clearService();
			CableModemHistoryLocalServiceUtil.clearService();

			CableModemHistoryServiceUtil.clearService();
			CmtsLocalServiceUtil.clearService();

			CmtsServiceUtil.clearService();
			CustomerMacMappingLocalServiceUtil.clearService();

			CustomerMacMappingServiceUtil.clearService();
			MerchantLocalServiceUtil.clearService();

			MerchantServiceUtil.clearService();
			MerchantScopeLocalServiceUtil.clearService();

			MerchantScopeServiceUtil.clearService();
			OptionLocalServiceUtil.clearService();

			OptionServiceUtil.clearService();
			UpChannelMetadataLocalServiceUtil.clearService();

			UpChannelMetadataServiceUtil.clearService();
			UpstreamChannelLocalServiceUtil.clearService();

			UpstreamChannelServiceUtil.clearService();
			UpstreamChannelHistoryLocalServiceUtil.clearService();

			UpstreamChannelHistoryServiceUtil.clearService();
		}
	}
}