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

package com.cmcti.cmts.domain.service.base;

import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.service.CmtsService;
import com.cmcti.cmts.domain.service.persistence.CableModemHistoryPersistence;
import com.cmcti.cmts.domain.service.persistence.CableModemPersistence;
import com.cmcti.cmts.domain.service.persistence.CmtsPersistence;
import com.cmcti.cmts.domain.service.persistence.CustomerMacMappingPersistence;
import com.cmcti.cmts.domain.service.persistence.MerchantPersistence;
import com.cmcti.cmts.domain.service.persistence.MerchantScopePersistence;
import com.cmcti.cmts.domain.service.persistence.OptionPersistence;
import com.cmcti.cmts.domain.service.persistence.UpChannelMetadataPersistence;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPersistence;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the cmts remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.cmcti.cmts.domain.service.impl.CmtsServiceImpl}.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.impl.CmtsServiceImpl
 * @see com.cmcti.cmts.domain.service.CmtsServiceUtil
 * @generated
 */
public abstract class CmtsServiceBaseImpl extends BaseServiceImpl
	implements CmtsService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.cmcti.cmts.domain.service.CmtsServiceUtil} to access the cmts remote service.
	 */

	/**
	 * Returns the cable modem local service.
	 *
	 * @return the cable modem local service
	 */
	public com.cmcti.cmts.domain.service.CableModemLocalService getCableModemLocalService() {
		return cableModemLocalService;
	}

	/**
	 * Sets the cable modem local service.
	 *
	 * @param cableModemLocalService the cable modem local service
	 */
	public void setCableModemLocalService(
		com.cmcti.cmts.domain.service.CableModemLocalService cableModemLocalService) {
		this.cableModemLocalService = cableModemLocalService;
	}

	/**
	 * Returns the cable modem remote service.
	 *
	 * @return the cable modem remote service
	 */
	public com.cmcti.cmts.domain.service.CableModemService getCableModemService() {
		return cableModemService;
	}

	/**
	 * Sets the cable modem remote service.
	 *
	 * @param cableModemService the cable modem remote service
	 */
	public void setCableModemService(
		com.cmcti.cmts.domain.service.CableModemService cableModemService) {
		this.cableModemService = cableModemService;
	}

	/**
	 * Returns the cable modem persistence.
	 *
	 * @return the cable modem persistence
	 */
	public CableModemPersistence getCableModemPersistence() {
		return cableModemPersistence;
	}

	/**
	 * Sets the cable modem persistence.
	 *
	 * @param cableModemPersistence the cable modem persistence
	 */
	public void setCableModemPersistence(
		CableModemPersistence cableModemPersistence) {
		this.cableModemPersistence = cableModemPersistence;
	}

	/**
	 * Returns the cable modem history local service.
	 *
	 * @return the cable modem history local service
	 */
	public com.cmcti.cmts.domain.service.CableModemHistoryLocalService getCableModemHistoryLocalService() {
		return cableModemHistoryLocalService;
	}

	/**
	 * Sets the cable modem history local service.
	 *
	 * @param cableModemHistoryLocalService the cable modem history local service
	 */
	public void setCableModemHistoryLocalService(
		com.cmcti.cmts.domain.service.CableModemHistoryLocalService cableModemHistoryLocalService) {
		this.cableModemHistoryLocalService = cableModemHistoryLocalService;
	}

	/**
	 * Returns the cable modem history remote service.
	 *
	 * @return the cable modem history remote service
	 */
	public com.cmcti.cmts.domain.service.CableModemHistoryService getCableModemHistoryService() {
		return cableModemHistoryService;
	}

	/**
	 * Sets the cable modem history remote service.
	 *
	 * @param cableModemHistoryService the cable modem history remote service
	 */
	public void setCableModemHistoryService(
		com.cmcti.cmts.domain.service.CableModemHistoryService cableModemHistoryService) {
		this.cableModemHistoryService = cableModemHistoryService;
	}

	/**
	 * Returns the cable modem history persistence.
	 *
	 * @return the cable modem history persistence
	 */
	public CableModemHistoryPersistence getCableModemHistoryPersistence() {
		return cableModemHistoryPersistence;
	}

	/**
	 * Sets the cable modem history persistence.
	 *
	 * @param cableModemHistoryPersistence the cable modem history persistence
	 */
	public void setCableModemHistoryPersistence(
		CableModemHistoryPersistence cableModemHistoryPersistence) {
		this.cableModemHistoryPersistence = cableModemHistoryPersistence;
	}

	/**
	 * Returns the cmts local service.
	 *
	 * @return the cmts local service
	 */
	public com.cmcti.cmts.domain.service.CmtsLocalService getCmtsLocalService() {
		return cmtsLocalService;
	}

	/**
	 * Sets the cmts local service.
	 *
	 * @param cmtsLocalService the cmts local service
	 */
	public void setCmtsLocalService(
		com.cmcti.cmts.domain.service.CmtsLocalService cmtsLocalService) {
		this.cmtsLocalService = cmtsLocalService;
	}

	/**
	 * Returns the cmts remote service.
	 *
	 * @return the cmts remote service
	 */
	public com.cmcti.cmts.domain.service.CmtsService getCmtsService() {
		return cmtsService;
	}

	/**
	 * Sets the cmts remote service.
	 *
	 * @param cmtsService the cmts remote service
	 */
	public void setCmtsService(
		com.cmcti.cmts.domain.service.CmtsService cmtsService) {
		this.cmtsService = cmtsService;
	}

	/**
	 * Returns the cmts persistence.
	 *
	 * @return the cmts persistence
	 */
	public CmtsPersistence getCmtsPersistence() {
		return cmtsPersistence;
	}

	/**
	 * Sets the cmts persistence.
	 *
	 * @param cmtsPersistence the cmts persistence
	 */
	public void setCmtsPersistence(CmtsPersistence cmtsPersistence) {
		this.cmtsPersistence = cmtsPersistence;
	}

	/**
	 * Returns the customer mac mapping local service.
	 *
	 * @return the customer mac mapping local service
	 */
	public com.cmcti.cmts.domain.service.CustomerMacMappingLocalService getCustomerMacMappingLocalService() {
		return customerMacMappingLocalService;
	}

	/**
	 * Sets the customer mac mapping local service.
	 *
	 * @param customerMacMappingLocalService the customer mac mapping local service
	 */
	public void setCustomerMacMappingLocalService(
		com.cmcti.cmts.domain.service.CustomerMacMappingLocalService customerMacMappingLocalService) {
		this.customerMacMappingLocalService = customerMacMappingLocalService;
	}

	/**
	 * Returns the customer mac mapping remote service.
	 *
	 * @return the customer mac mapping remote service
	 */
	public com.cmcti.cmts.domain.service.CustomerMacMappingService getCustomerMacMappingService() {
		return customerMacMappingService;
	}

	/**
	 * Sets the customer mac mapping remote service.
	 *
	 * @param customerMacMappingService the customer mac mapping remote service
	 */
	public void setCustomerMacMappingService(
		com.cmcti.cmts.domain.service.CustomerMacMappingService customerMacMappingService) {
		this.customerMacMappingService = customerMacMappingService;
	}

	/**
	 * Returns the customer mac mapping persistence.
	 *
	 * @return the customer mac mapping persistence
	 */
	public CustomerMacMappingPersistence getCustomerMacMappingPersistence() {
		return customerMacMappingPersistence;
	}

	/**
	 * Sets the customer mac mapping persistence.
	 *
	 * @param customerMacMappingPersistence the customer mac mapping persistence
	 */
	public void setCustomerMacMappingPersistence(
		CustomerMacMappingPersistence customerMacMappingPersistence) {
		this.customerMacMappingPersistence = customerMacMappingPersistence;
	}

	/**
	 * Returns the merchant local service.
	 *
	 * @return the merchant local service
	 */
	public com.cmcti.cmts.domain.service.MerchantLocalService getMerchantLocalService() {
		return merchantLocalService;
	}

	/**
	 * Sets the merchant local service.
	 *
	 * @param merchantLocalService the merchant local service
	 */
	public void setMerchantLocalService(
		com.cmcti.cmts.domain.service.MerchantLocalService merchantLocalService) {
		this.merchantLocalService = merchantLocalService;
	}

	/**
	 * Returns the merchant remote service.
	 *
	 * @return the merchant remote service
	 */
	public com.cmcti.cmts.domain.service.MerchantService getMerchantService() {
		return merchantService;
	}

	/**
	 * Sets the merchant remote service.
	 *
	 * @param merchantService the merchant remote service
	 */
	public void setMerchantService(
		com.cmcti.cmts.domain.service.MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	/**
	 * Returns the merchant persistence.
	 *
	 * @return the merchant persistence
	 */
	public MerchantPersistence getMerchantPersistence() {
		return merchantPersistence;
	}

	/**
	 * Sets the merchant persistence.
	 *
	 * @param merchantPersistence the merchant persistence
	 */
	public void setMerchantPersistence(MerchantPersistence merchantPersistence) {
		this.merchantPersistence = merchantPersistence;
	}

	/**
	 * Returns the merchant scope local service.
	 *
	 * @return the merchant scope local service
	 */
	public com.cmcti.cmts.domain.service.MerchantScopeLocalService getMerchantScopeLocalService() {
		return merchantScopeLocalService;
	}

	/**
	 * Sets the merchant scope local service.
	 *
	 * @param merchantScopeLocalService the merchant scope local service
	 */
	public void setMerchantScopeLocalService(
		com.cmcti.cmts.domain.service.MerchantScopeLocalService merchantScopeLocalService) {
		this.merchantScopeLocalService = merchantScopeLocalService;
	}

	/**
	 * Returns the merchant scope remote service.
	 *
	 * @return the merchant scope remote service
	 */
	public com.cmcti.cmts.domain.service.MerchantScopeService getMerchantScopeService() {
		return merchantScopeService;
	}

	/**
	 * Sets the merchant scope remote service.
	 *
	 * @param merchantScopeService the merchant scope remote service
	 */
	public void setMerchantScopeService(
		com.cmcti.cmts.domain.service.MerchantScopeService merchantScopeService) {
		this.merchantScopeService = merchantScopeService;
	}

	/**
	 * Returns the merchant scope persistence.
	 *
	 * @return the merchant scope persistence
	 */
	public MerchantScopePersistence getMerchantScopePersistence() {
		return merchantScopePersistence;
	}

	/**
	 * Sets the merchant scope persistence.
	 *
	 * @param merchantScopePersistence the merchant scope persistence
	 */
	public void setMerchantScopePersistence(
		MerchantScopePersistence merchantScopePersistence) {
		this.merchantScopePersistence = merchantScopePersistence;
	}

	/**
	 * Returns the option local service.
	 *
	 * @return the option local service
	 */
	public com.cmcti.cmts.domain.service.OptionLocalService getOptionLocalService() {
		return optionLocalService;
	}

	/**
	 * Sets the option local service.
	 *
	 * @param optionLocalService the option local service
	 */
	public void setOptionLocalService(
		com.cmcti.cmts.domain.service.OptionLocalService optionLocalService) {
		this.optionLocalService = optionLocalService;
	}

	/**
	 * Returns the option remote service.
	 *
	 * @return the option remote service
	 */
	public com.cmcti.cmts.domain.service.OptionService getOptionService() {
		return optionService;
	}

	/**
	 * Sets the option remote service.
	 *
	 * @param optionService the option remote service
	 */
	public void setOptionService(
		com.cmcti.cmts.domain.service.OptionService optionService) {
		this.optionService = optionService;
	}

	/**
	 * Returns the option persistence.
	 *
	 * @return the option persistence
	 */
	public OptionPersistence getOptionPersistence() {
		return optionPersistence;
	}

	/**
	 * Sets the option persistence.
	 *
	 * @param optionPersistence the option persistence
	 */
	public void setOptionPersistence(OptionPersistence optionPersistence) {
		this.optionPersistence = optionPersistence;
	}

	/**
	 * Returns the up channel metadata local service.
	 *
	 * @return the up channel metadata local service
	 */
	public com.cmcti.cmts.domain.service.UpChannelMetadataLocalService getUpChannelMetadataLocalService() {
		return upChannelMetadataLocalService;
	}

	/**
	 * Sets the up channel metadata local service.
	 *
	 * @param upChannelMetadataLocalService the up channel metadata local service
	 */
	public void setUpChannelMetadataLocalService(
		com.cmcti.cmts.domain.service.UpChannelMetadataLocalService upChannelMetadataLocalService) {
		this.upChannelMetadataLocalService = upChannelMetadataLocalService;
	}

	/**
	 * Returns the up channel metadata remote service.
	 *
	 * @return the up channel metadata remote service
	 */
	public com.cmcti.cmts.domain.service.UpChannelMetadataService getUpChannelMetadataService() {
		return upChannelMetadataService;
	}

	/**
	 * Sets the up channel metadata remote service.
	 *
	 * @param upChannelMetadataService the up channel metadata remote service
	 */
	public void setUpChannelMetadataService(
		com.cmcti.cmts.domain.service.UpChannelMetadataService upChannelMetadataService) {
		this.upChannelMetadataService = upChannelMetadataService;
	}

	/**
	 * Returns the up channel metadata persistence.
	 *
	 * @return the up channel metadata persistence
	 */
	public UpChannelMetadataPersistence getUpChannelMetadataPersistence() {
		return upChannelMetadataPersistence;
	}

	/**
	 * Sets the up channel metadata persistence.
	 *
	 * @param upChannelMetadataPersistence the up channel metadata persistence
	 */
	public void setUpChannelMetadataPersistence(
		UpChannelMetadataPersistence upChannelMetadataPersistence) {
		this.upChannelMetadataPersistence = upChannelMetadataPersistence;
	}

	/**
	 * Returns the upstream channel local service.
	 *
	 * @return the upstream channel local service
	 */
	public com.cmcti.cmts.domain.service.UpstreamChannelLocalService getUpstreamChannelLocalService() {
		return upstreamChannelLocalService;
	}

	/**
	 * Sets the upstream channel local service.
	 *
	 * @param upstreamChannelLocalService the upstream channel local service
	 */
	public void setUpstreamChannelLocalService(
		com.cmcti.cmts.domain.service.UpstreamChannelLocalService upstreamChannelLocalService) {
		this.upstreamChannelLocalService = upstreamChannelLocalService;
	}

	/**
	 * Returns the upstream channel remote service.
	 *
	 * @return the upstream channel remote service
	 */
	public com.cmcti.cmts.domain.service.UpstreamChannelService getUpstreamChannelService() {
		return upstreamChannelService;
	}

	/**
	 * Sets the upstream channel remote service.
	 *
	 * @param upstreamChannelService the upstream channel remote service
	 */
	public void setUpstreamChannelService(
		com.cmcti.cmts.domain.service.UpstreamChannelService upstreamChannelService) {
		this.upstreamChannelService = upstreamChannelService;
	}

	/**
	 * Returns the upstream channel persistence.
	 *
	 * @return the upstream channel persistence
	 */
	public UpstreamChannelPersistence getUpstreamChannelPersistence() {
		return upstreamChannelPersistence;
	}

	/**
	 * Sets the upstream channel persistence.
	 *
	 * @param upstreamChannelPersistence the upstream channel persistence
	 */
	public void setUpstreamChannelPersistence(
		UpstreamChannelPersistence upstreamChannelPersistence) {
		this.upstreamChannelPersistence = upstreamChannelPersistence;
	}

	/**
	 * Returns the upstream channel history local service.
	 *
	 * @return the upstream channel history local service
	 */
	public com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalService getUpstreamChannelHistoryLocalService() {
		return upstreamChannelHistoryLocalService;
	}

	/**
	 * Sets the upstream channel history local service.
	 *
	 * @param upstreamChannelHistoryLocalService the upstream channel history local service
	 */
	public void setUpstreamChannelHistoryLocalService(
		com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalService upstreamChannelHistoryLocalService) {
		this.upstreamChannelHistoryLocalService = upstreamChannelHistoryLocalService;
	}

	/**
	 * Returns the upstream channel history remote service.
	 *
	 * @return the upstream channel history remote service
	 */
	public com.cmcti.cmts.domain.service.UpstreamChannelHistoryService getUpstreamChannelHistoryService() {
		return upstreamChannelHistoryService;
	}

	/**
	 * Sets the upstream channel history remote service.
	 *
	 * @param upstreamChannelHistoryService the upstream channel history remote service
	 */
	public void setUpstreamChannelHistoryService(
		com.cmcti.cmts.domain.service.UpstreamChannelHistoryService upstreamChannelHistoryService) {
		this.upstreamChannelHistoryService = upstreamChannelHistoryService;
	}

	/**
	 * Returns the upstream channel history persistence.
	 *
	 * @return the upstream channel history persistence
	 */
	public UpstreamChannelHistoryPersistence getUpstreamChannelHistoryPersistence() {
		return upstreamChannelHistoryPersistence;
	}

	/**
	 * Sets the upstream channel history persistence.
	 *
	 * @param upstreamChannelHistoryPersistence the upstream channel history persistence
	 */
	public void setUpstreamChannelHistoryPersistence(
		UpstreamChannelHistoryPersistence upstreamChannelHistoryPersistence) {
		this.upstreamChannelHistoryPersistence = upstreamChannelHistoryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Cmts.class;
	}

	protected String getModelClassName() {
		return Cmts.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cmtsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.cmcti.cmts.domain.service.CableModemLocalService.class)
	protected com.cmcti.cmts.domain.service.CableModemLocalService cableModemLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.CableModemService.class)
	protected com.cmcti.cmts.domain.service.CableModemService cableModemService;
	@BeanReference(type = CableModemPersistence.class)
	protected CableModemPersistence cableModemPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.CableModemHistoryLocalService.class)
	protected com.cmcti.cmts.domain.service.CableModemHistoryLocalService cableModemHistoryLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.CableModemHistoryService.class)
	protected com.cmcti.cmts.domain.service.CableModemHistoryService cableModemHistoryService;
	@BeanReference(type = CableModemHistoryPersistence.class)
	protected CableModemHistoryPersistence cableModemHistoryPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.CmtsLocalService.class)
	protected com.cmcti.cmts.domain.service.CmtsLocalService cmtsLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.CmtsService.class)
	protected com.cmcti.cmts.domain.service.CmtsService cmtsService;
	@BeanReference(type = CmtsPersistence.class)
	protected CmtsPersistence cmtsPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.CustomerMacMappingLocalService.class)
	protected com.cmcti.cmts.domain.service.CustomerMacMappingLocalService customerMacMappingLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.CustomerMacMappingService.class)
	protected com.cmcti.cmts.domain.service.CustomerMacMappingService customerMacMappingService;
	@BeanReference(type = CustomerMacMappingPersistence.class)
	protected CustomerMacMappingPersistence customerMacMappingPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.MerchantLocalService.class)
	protected com.cmcti.cmts.domain.service.MerchantLocalService merchantLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.MerchantService.class)
	protected com.cmcti.cmts.domain.service.MerchantService merchantService;
	@BeanReference(type = MerchantPersistence.class)
	protected MerchantPersistence merchantPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.MerchantScopeLocalService.class)
	protected com.cmcti.cmts.domain.service.MerchantScopeLocalService merchantScopeLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.MerchantScopeService.class)
	protected com.cmcti.cmts.domain.service.MerchantScopeService merchantScopeService;
	@BeanReference(type = MerchantScopePersistence.class)
	protected MerchantScopePersistence merchantScopePersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.OptionLocalService.class)
	protected com.cmcti.cmts.domain.service.OptionLocalService optionLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.OptionService.class)
	protected com.cmcti.cmts.domain.service.OptionService optionService;
	@BeanReference(type = OptionPersistence.class)
	protected OptionPersistence optionPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpChannelMetadataLocalService.class)
	protected com.cmcti.cmts.domain.service.UpChannelMetadataLocalService upChannelMetadataLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpChannelMetadataService.class)
	protected com.cmcti.cmts.domain.service.UpChannelMetadataService upChannelMetadataService;
	@BeanReference(type = UpChannelMetadataPersistence.class)
	protected UpChannelMetadataPersistence upChannelMetadataPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpstreamChannelLocalService.class)
	protected com.cmcti.cmts.domain.service.UpstreamChannelLocalService upstreamChannelLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpstreamChannelService.class)
	protected com.cmcti.cmts.domain.service.UpstreamChannelService upstreamChannelService;
	@BeanReference(type = UpstreamChannelPersistence.class)
	protected UpstreamChannelPersistence upstreamChannelPersistence;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalService.class)
	protected com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalService upstreamChannelHistoryLocalService;
	@BeanReference(type = com.cmcti.cmts.domain.service.UpstreamChannelHistoryService.class)
	protected com.cmcti.cmts.domain.service.UpstreamChannelHistoryService upstreamChannelHistoryService;
	@BeanReference(type = UpstreamChannelHistoryPersistence.class)
	protected UpstreamChannelHistoryPersistence upstreamChannelHistoryPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CmtsServiceClpInvoker _clpInvoker = new CmtsServiceClpInvoker();
}