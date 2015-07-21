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
 * Provides a wrapper for {@link MerchantScopeLocalService}.
 *
 * @author richard
 * @see MerchantScopeLocalService
 * @generated
 */
public class MerchantScopeLocalServiceWrapper
	implements MerchantScopeLocalService,
		ServiceWrapper<MerchantScopeLocalService> {
	public MerchantScopeLocalServiceWrapper(
		MerchantScopeLocalService merchantScopeLocalService) {
		_merchantScopeLocalService = merchantScopeLocalService;
	}

	/**
	* Adds the merchant scope to the database. Also notifies the appropriate model listeners.
	*
	* @param merchantScope the merchant scope
	* @return the merchant scope that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope addMerchantScope(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.addMerchantScope(merchantScope);
	}

	/**
	* Creates a new merchant scope with the primary key. Does not add the merchant scope to the database.
	*
	* @param merchantScopeId the primary key for the new merchant scope
	* @return the new merchant scope
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope createMerchantScope(
		long merchantScopeId) {
		return _merchantScopeLocalService.createMerchantScope(merchantScopeId);
	}

	/**
	* Deletes the merchant scope with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param merchantScopeId the primary key of the merchant scope
	* @return the merchant scope that was removed
	* @throws PortalException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope deleteMerchantScope(
		long merchantScopeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.deleteMerchantScope(merchantScopeId);
	}

	/**
	* Deletes the merchant scope from the database. Also notifies the appropriate model listeners.
	*
	* @param merchantScope the merchant scope
	* @return the merchant scope that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope deleteMerchantScope(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.deleteMerchantScope(merchantScope);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _merchantScopeLocalService.dynamicQuery();
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
		return _merchantScopeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _merchantScopeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _merchantScopeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _merchantScopeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _merchantScopeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.MerchantScope fetchMerchantScope(
		long merchantScopeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.fetchMerchantScope(merchantScopeId);
	}

	/**
	* Returns the merchant scope with the primary key.
	*
	* @param merchantScopeId the primary key of the merchant scope
	* @return the merchant scope
	* @throws PortalException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope getMerchantScope(
		long merchantScopeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.getMerchantScope(merchantScopeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the merchant scopes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cmcti.cmts.domain.model.MerchantScope> getMerchantScopes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.getMerchantScopes(start, end);
	}

	/**
	* Returns the number of merchant scopes.
	*
	* @return the number of merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMerchantScopesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.getMerchantScopesCount();
	}

	/**
	* Updates the merchant scope in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param merchantScope the merchant scope
	* @return the merchant scope that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.MerchantScope updateMerchantScope(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.updateMerchantScope(merchantScope);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _merchantScopeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_merchantScopeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _merchantScopeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByMerchant(
		java.lang.String merchantCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.findByMerchant(merchantCode);
	}

	@Override
	public void addMerchantScopes(
		java.util.List<com.cmcti.cmts.domain.model.MerchantScope> scopes,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_merchantScopeLocalService.addMerchantScopes(scopes, context);
	}

	@Override
	public void removeMerchantScopes(
		java.util.List<com.cmcti.cmts.domain.model.MerchantScope> scopes,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_merchantScopeLocalService.removeMerchantScopes(scopes, context);
	}

	@Override
	public com.cmcti.cmts.domain.model.MerchantScope updateMerchantScope(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _merchantScopeLocalService.updateMerchantScope(merchantScope,
			context);
	}

	@Override
	public void deleteByMerchant(java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_merchantScopeLocalService.deleteByMerchant(code);
	}

	@Override
	public void importMerchant(java.io.InputStream is, int sheetIdx,
		int startRowIdx,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_merchantScopeLocalService.importMerchant(is, sheetIdx, startRowIdx,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MerchantScopeLocalService getWrappedMerchantScopeLocalService() {
		return _merchantScopeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMerchantScopeLocalService(
		MerchantScopeLocalService merchantScopeLocalService) {
		_merchantScopeLocalService = merchantScopeLocalService;
	}

	@Override
	public MerchantScopeLocalService getWrappedService() {
		return _merchantScopeLocalService;
	}

	@Override
	public void setWrappedService(
		MerchantScopeLocalService merchantScopeLocalService) {
		_merchantScopeLocalService = merchantScopeLocalService;
	}

	private MerchantScopeLocalService _merchantScopeLocalService;
}