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
 * Provides a wrapper for {@link CableModemHistoryLocalService}.
 *
 * @author richard
 * @see CableModemHistoryLocalService
 * @generated
 */
public class CableModemHistoryLocalServiceWrapper
	implements CableModemHistoryLocalService,
		ServiceWrapper<CableModemHistoryLocalService> {
	public CableModemHistoryLocalServiceWrapper(
		CableModemHistoryLocalService cableModemHistoryLocalService) {
		_cableModemHistoryLocalService = cableModemHistoryLocalService;
	}

	/**
	* Adds the cable modem history to the database. Also notifies the appropriate model listeners.
	*
	* @param cableModemHistory the cable modem history
	* @return the cable modem history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory addCableModemHistory(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.addCableModemHistory(cableModemHistory);
	}

	/**
	* Creates a new cable modem history with the primary key. Does not add the cable modem history to the database.
	*
	* @param cmHisId the primary key for the new cable modem history
	* @return the new cable modem history
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory createCableModemHistory(
		long cmHisId) {
		return _cableModemHistoryLocalService.createCableModemHistory(cmHisId);
	}

	/**
	* Deletes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cmHisId the primary key of the cable modem history
	* @return the cable modem history that was removed
	* @throws PortalException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory deleteCableModemHistory(
		long cmHisId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.deleteCableModemHistory(cmHisId);
	}

	/**
	* Deletes the cable modem history from the database. Also notifies the appropriate model listeners.
	*
	* @param cableModemHistory the cable modem history
	* @return the cable modem history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory deleteCableModemHistory(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.deleteCableModemHistory(cableModemHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cableModemHistoryLocalService.dynamicQuery();
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
		return _cableModemHistoryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _cableModemHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cableModemHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory fetchCableModemHistory(
		long cmHisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.fetchCableModemHistory(cmHisId);
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
	public com.cmcti.cmts.domain.model.CableModemHistory getCableModemHistory(
		long cmHisId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.getCableModemHistory(cmHisId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> getCableModemHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.getCableModemHistories(start, end);
	}

	/**
	* Returns the number of cable modem histories.
	*
	* @return the number of cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCableModemHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.getCableModemHistoriesCount();
	}

	/**
	* Updates the cable modem history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cableModemHistory the cable modem history
	* @return the cable modem history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.CableModemHistory updateCableModemHistory(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cableModemHistoryLocalService.updateCableModemHistory(cableModemHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cableModemHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cableModemHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cableModemHistoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CableModemHistoryLocalService getWrappedCableModemHistoryLocalService() {
		return _cableModemHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCableModemHistoryLocalService(
		CableModemHistoryLocalService cableModemHistoryLocalService) {
		_cableModemHistoryLocalService = cableModemHistoryLocalService;
	}

	@Override
	public CableModemHistoryLocalService getWrappedService() {
		return _cableModemHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CableModemHistoryLocalService cableModemHistoryLocalService) {
		_cableModemHistoryLocalService = cableModemHistoryLocalService;
	}

	private CableModemHistoryLocalService _cableModemHistoryLocalService;
}