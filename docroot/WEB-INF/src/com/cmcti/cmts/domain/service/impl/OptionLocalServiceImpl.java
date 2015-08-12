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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmcti.cmts.domain.model.Option;
import com.cmcti.cmts.domain.service.base.OptionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the option local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmcti.cmts.domain.service.OptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.OptionLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.OptionLocalServiceUtil
 */
public class OptionLocalServiceImpl extends OptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmcti.cmts.domain.service.OptionLocalServiceUtil} to access the
	 * option local service.
	 */

	public Option updateOption(String optionKey, String optionType, String optionValue, String description, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Option option = null;

		if (Validator.isNull(optionKey) || Validator.isNull(optionValue)) {
			throw new PortalException("option-key-and-option-value-and-option-type-can-not-be-null-or-empty");
		}

		try {
			option = optionPersistence.fetchByT_K(optionType, optionKey);
		} catch (SystemException e) {
			// nothing to catch
		}

		if (option == null) {
			long optionId = counterLocalService.increment(Option.class.getName());
			option = optionPersistence.create(optionId);

			option.setUserId(serviceContext.getUserId());
			option.setGroupId(serviceContext.getScopeGroupId());
			option.setCompanyId(serviceContext.getCompanyId());
			option.setCreateDate(serviceContext.getCreateDate());
			option.setModifiedDate(serviceContext.getModifiedDate());

		} else {
			option.setModifiedDate(serviceContext.getModifiedDate());
		}

		option.setOptionType(optionType);
		option.setOptionKey(optionKey);
		option.setOptionValue(optionValue);
		option.setDescription(description);

		return optionPersistence.update(option);
	}

	public void updateAlarmConfigs(Map<String, String> map, ServiceContext serviceContext) throws PortalException, SystemException {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String optionKey = entry.getKey();
			String optionValue = entry.getValue();
			if (Validator.isNotNull(optionKey) && Validator.isNotNull(optionValue))
				optionLocalService.updateOption(optionKey, "alarmConfigs", optionValue, null, serviceContext);
		}
	}
	
	public Map<String, String> fetchAlarmsConfig() throws SystemException {
		Map<String, String> map = new HashMap<String, String>();
		
		List<Option> options = optionPersistence.findByType("alarmConfigs");
		
		for (Option option : options) {
			map.put(option.getOptionKey(), option.getOptionValue());
		}
		
		return map;
	}
}