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

import com.cmcti.cmts.domain.model.CableModemHistory;
import com.cmcti.cmts.domain.service.CableModemHistoryLocalService;
import com.cmcti.cmts.domain.service.persistence.CableModemHistoryPersistence;
import com.cmcti.cmts.domain.service.persistence.CableModemPersistence;
import com.cmcti.cmts.domain.service.persistence.CmtsPersistence;
import com.cmcti.cmts.domain.service.persistence.CustomerMacMappingPersistence;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryPersistence;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the cable modem history local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.cmcti.cmts.domain.service.impl.CableModemHistoryLocalServiceImpl}.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.impl.CableModemHistoryLocalServiceImpl
 * @see com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil
 * @generated
 */
public abstract class CableModemHistoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CableModemHistoryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil} to access the cable modem history local service.
	 */

	/**
	 * Adds the cable modem history to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cableModemHistory the cable modem history
	 * @return the cable modem history that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CableModemHistory addCableModemHistory(
		CableModemHistory cableModemHistory) throws SystemException {
		cableModemHistory.setNew(true);

		return cableModemHistoryPersistence.update(cableModemHistory);
	}

	/**
	 * Creates a new cable modem history with the primary key. Does not add the cable modem history to the database.
	 *
	 * @param cmHisId the primary key for the new cable modem history
	 * @return the new cable modem history
	 */
	@Override
	public CableModemHistory createCableModemHistory(long cmHisId) {
		return cableModemHistoryPersistence.create(cmHisId);
	}

	/**
	 * Deletes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmHisId the primary key of the cable modem history
	 * @return the cable modem history that was removed
	 * @throws PortalException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CableModemHistory deleteCableModemHistory(long cmHisId)
		throws PortalException, SystemException {
		return cableModemHistoryPersistence.remove(cmHisId);
	}

	/**
	 * Deletes the cable modem history from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cableModemHistory the cable modem history
	 * @return the cable modem history that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CableModemHistory deleteCableModemHistory(
		CableModemHistory cableModemHistory) throws SystemException {
		return cableModemHistoryPersistence.remove(cableModemHistory);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CableModemHistory.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return cableModemHistoryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return cableModemHistoryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return cableModemHistoryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return cableModemHistoryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return cableModemHistoryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CableModemHistory fetchCableModemHistory(long cmHisId)
		throws SystemException {
		return cableModemHistoryPersistence.fetchByPrimaryKey(cmHisId);
	}

	/**
	 * Returns the cable modem history with the primary key.
	 *
	 * @param cmHisId the primary key of the cable modem history
	 * @return the cable modem history
	 * @throws PortalException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory getCableModemHistory(long cmHisId)
		throws PortalException, SystemException {
		return cableModemHistoryPersistence.findByPrimaryKey(cmHisId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return cableModemHistoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cable modem histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cable modem histories
	 * @param end the upper bound of the range of cable modem histories (not inclusive)
	 * @return the range of cable modem histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModemHistory> getCableModemHistories(int start, int end)
		throws SystemException {
		return cableModemHistoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cable modem histories.
	 *
	 * @return the number of cable modem histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCableModemHistoriesCount() throws SystemException {
		return cableModemHistoryPersistence.countAll();
	}

	/**
	 * Updates the cable modem history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cableModemHistory the cable modem history
	 * @return the cable modem history that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CableModemHistory updateCableModemHistory(
		CableModemHistory cableModemHistory) throws SystemException {
		return cableModemHistoryPersistence.update(cableModemHistory);
	}

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

		PersistedModelLocalServiceRegistryUtil.register("com.cmcti.cmts.domain.model.CableModemHistory",
			cableModemHistoryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.cmcti.cmts.domain.model.CableModemHistory");
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
		return CableModemHistory.class;
	}

	protected String getModelClassName() {
		return CableModemHistory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cableModemHistoryPersistence.getDataSource();

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
	private CableModemHistoryLocalServiceClpInvoker _clpInvoker = new CableModemHistoryLocalServiceClpInvoker();
}