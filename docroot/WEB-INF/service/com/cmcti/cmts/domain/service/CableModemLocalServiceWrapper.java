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
 * Provides a wrapper for {@link CableModemLocalService}.
 *
 * @author richard
 * @see CableModemLocalService
 * @generated
 */
public class CableModemLocalServiceWrapper implements CableModemLocalService,
	ServiceWrapper<CableModemLocalService> {
	public CableModemLocalServiceWrapper(
		CableModemLocalService cableModemLocalService) {
		_cableModemLocalService = cableModemLocalService;
	}

	/**
	* Adds the cable modem to the database. Also notifies the appropriate model listeners.
	*
	* @param cableModem the cable modem
	* @return the cable modem that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem addCableModem(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.addCableModem(cableModem);
	}

	/**
	* Creates a new cable modem with the primary key. Does not add the cable modem to the database.
	*
	* @param macAddress the primary key for the new cable modem
	* @return the new cable modem
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem createCableModem(
		java.lang.String macAddress) {
		return _cableModemLocalService.createCableModem(macAddress);
	}

	/**
	* Deletes the cable modem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem that was removed
	* @throws PortalException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem deleteCableModem(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.deleteCableModem(macAddress);
	}

	/**
	* Deletes the cable modem from the database. Also notifies the appropriate model listeners.
	*
	* @param cableModem the cable modem
	* @return the cable modem that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem deleteCableModem(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.deleteCableModem(cableModem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cableModemLocalService.dynamicQuery();
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
		return _cableModemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cableModemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cableModemLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cableModemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cableModemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModem fetchCableModem(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.fetchCableModem(macAddress);
	}

	/**
	* Returns the cable modem with the primary key.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem
	* @throws PortalException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem getCableModem(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.getCableModem(macAddress);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cable modems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of cable modems
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cmcti.cmts.domain.model.CableModem> getCableModems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.getCableModems(start, end);
	}

	/**
	* Returns the number of cable modems.
	*
	* @return the number of cable modems
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCableModemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.getCableModemsCount();
	}

	/**
	* Updates the cable modem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cableModem the cable modem
	* @return the cable modem that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModem updateCableModem(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.updateCableModem(cableModem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cableModemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cableModemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cableModemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List getAvgValueForUpstream(long cmtsId, int ifIndex,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.getAvgValueForUpstream(cmtsId, ifIndex,
			status);
	}

	@Override
	public java.util.List<com.cmcti.cmts.domain.model.CableModem> findByMacAddress(
		java.lang.String macAddress, int maxResults)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemLocalService.findByMacAddress(macAddress, maxResults);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CableModemLocalService getWrappedCableModemLocalService() {
		return _cableModemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCableModemLocalService(
		CableModemLocalService cableModemLocalService) {
		_cableModemLocalService = cableModemLocalService;
	}

	@Override
	public CableModemLocalService getWrappedService() {
		return _cableModemLocalService;
	}

	@Override
	public void setWrappedService(CableModemLocalService cableModemLocalService) {
		_cableModemLocalService = cableModemLocalService;
	}

	private CableModemLocalService _cableModemLocalService;
}