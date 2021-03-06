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
 * Provides a wrapper for {@link OptionLocalService}.
 *
 * @author richard
 * @see OptionLocalService
 * @generated
 */
public class OptionLocalServiceWrapper implements OptionLocalService,
	ServiceWrapper<OptionLocalService> {
	public OptionLocalServiceWrapper(OptionLocalService optionLocalService) {
		_optionLocalService = optionLocalService;
	}

	/**
	* Adds the option to the database. Also notifies the appropriate model listeners.
	*
	* @param option the option
	* @return the option that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option addOption(
		com.cmcti.cmts.domain.model.Option option)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.addOption(option);
	}

	/**
	* Creates a new option with the primary key. Does not add the option to the database.
	*
	* @param optionId the primary key for the new option
	* @return the new option
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option createOption(long optionId) {
		return _optionLocalService.createOption(optionId);
	}

	/**
	* Deletes the option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param optionId the primary key of the option
	* @return the option that was removed
	* @throws PortalException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option deleteOption(long optionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.deleteOption(optionId);
	}

	/**
	* Deletes the option from the database. Also notifies the appropriate model listeners.
	*
	* @param option the option
	* @return the option that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option deleteOption(
		com.cmcti.cmts.domain.model.Option option)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.deleteOption(option);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _optionLocalService.dynamicQuery();
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
		return _optionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _optionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _optionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _optionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _optionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.Option fetchOption(long optionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.fetchOption(optionId);
	}

	/**
	* Returns the option with the primary key.
	*
	* @param optionId the primary key of the option
	* @return the option
	* @throws PortalException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option getOption(long optionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.getOption(optionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @return the range of options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cmcti.cmts.domain.model.Option> getOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.getOptions(start, end);
	}

	/**
	* Returns the number of options.
	*
	* @return the number of options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.getOptionsCount();
	}

	/**
	* Updates the option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param option the option
	* @return the option that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.Option updateOption(
		com.cmcti.cmts.domain.model.Option option)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.updateOption(option);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _optionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_optionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _optionLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.cmcti.cmts.domain.model.Option updateOption(
		java.lang.String optionKey, java.lang.String optionType,
		java.lang.String optionValue, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.updateOption(optionKey, optionType,
			optionValue, description, serviceContext);
	}

	@Override
	public void updateAlarmConfigs(
		java.util.Map<java.lang.String, java.lang.String> map,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_optionLocalService.updateAlarmConfigs(map, serviceContext);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> fetchAlarmsConfig()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _optionLocalService.fetchAlarmsConfig();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OptionLocalService getWrappedOptionLocalService() {
		return _optionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOptionLocalService(
		OptionLocalService optionLocalService) {
		_optionLocalService = optionLocalService;
	}

	@Override
	public OptionLocalService getWrappedService() {
		return _optionLocalService;
	}

	@Override
	public void setWrappedService(OptionLocalService optionLocalService) {
		_optionLocalService = optionLocalService;
	}

	private OptionLocalService _optionLocalService;
}