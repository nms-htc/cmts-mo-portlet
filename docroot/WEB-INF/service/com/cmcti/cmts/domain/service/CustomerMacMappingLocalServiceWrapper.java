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

package com.cmcti.cmts.domain.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomerMacMappingLocalService}.
 *
 * @author richard
 * @see CustomerMacMappingLocalService
 * @generated
 */
public class CustomerMacMappingLocalServiceWrapper
	implements CustomerMacMappingLocalService,
		ServiceWrapper<CustomerMacMappingLocalService> {
	public CustomerMacMappingLocalServiceWrapper(
		CustomerMacMappingLocalService customerMacMappingLocalService) {
		_customerMacMappingLocalService = customerMacMappingLocalService;
	}

	/**
	* Adds the customer mac mapping to the database. Also notifies the appropriate model listeners.
	*
	* @param customerMacMapping the customer mac mapping
	* @return the customer mac mapping that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping addCustomerMacMapping(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.addCustomerMacMapping(customerMacMapping);
	}

	/**
	* Creates a new customer mac mapping with the primary key. Does not add the customer mac mapping to the database.
	*
	* @param customerMacId the primary key for the new customer mac mapping
	* @return the new customer mac mapping
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping createCustomerMacMapping(
		long customerMacId) {
		return _customerMacMappingLocalService.createCustomerMacMapping(customerMacId);
	}

	/**
	* Deletes the customer mac mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customerMacId the primary key of the customer mac mapping
	* @return the customer mac mapping that was removed
	* @throws PortalException if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping deleteCustomerMacMapping(
		long customerMacId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.deleteCustomerMacMapping(customerMacId);
	}

	/**
	* Deletes the customer mac mapping from the database. Also notifies the appropriate model listeners.
	*
	* @param customerMacMapping the customer mac mapping
	* @return the customer mac mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping deleteCustomerMacMapping(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.deleteCustomerMacMapping(customerMacMapping);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerMacMappingLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchCustomerMacMapping(
		long customerMacId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.fetchCustomerMacMapping(customerMacId);
	}

	/**
	* Returns the customer mac mapping with the primary key.
	*
	* @param customerMacId the primary key of the customer mac mapping
	* @return the customer mac mapping
	* @throws PortalException if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping getCustomerMacMapping(
		long customerMacId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.getCustomerMacMapping(customerMacId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the customer mac mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customer mac mappings
	* @param end the upper bound of the range of customer mac mappings (not inclusive)
	* @return the range of customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> getCustomerMacMappings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.getCustomerMacMappings(start, end);
	}

	/**
	* Returns the number of customer mac mappings.
	*
	* @return the number of customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCustomerMacMappingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.getCustomerMacMappingsCount();
	}

	/**
	* Updates the customer mac mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param customerMacMapping the customer mac mapping
	* @return the customer mac mapping that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping updateCustomerMacMapping(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.updateCustomerMacMapping(customerMacMapping);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _customerMacMappingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_customerMacMappingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _customerMacMappingLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.cmcti.cmts.domain.model.CustomerMacMapping getByMacAddress(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerMacMappingLocalService.getByMacAddress(macAddress);
	}

	@Override
	public void importAddressFromXls(java.io.InputStream is, int sheetIdx,
		int startRow, com.liferay.portal.service.ServiceContext serviceContext,
		boolean deleteAll)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_customerMacMappingLocalService.importAddressFromXls(is, sheetIdx,
			startRow, serviceContext, deleteAll);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CustomerMacMappingLocalService getWrappedCustomerMacMappingLocalService() {
		return _customerMacMappingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCustomerMacMappingLocalService(
		CustomerMacMappingLocalService customerMacMappingLocalService) {
		_customerMacMappingLocalService = customerMacMappingLocalService;
	}

	@Override
	public CustomerMacMappingLocalService getWrappedService() {
		return _customerMacMappingLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerMacMappingLocalService customerMacMappingLocalService) {
		_customerMacMappingLocalService = customerMacMappingLocalService;
	}

	private CustomerMacMappingLocalService _customerMacMappingLocalService;
}