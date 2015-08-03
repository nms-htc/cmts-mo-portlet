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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Merchant. This utility wraps
 * {@link com.cmcti.cmts.domain.service.impl.MerchantLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author richard
 * @see MerchantLocalService
 * @see com.cmcti.cmts.domain.service.base.MerchantLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.impl.MerchantLocalServiceImpl
 * @generated
 */
public class MerchantLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmcti.cmts.domain.service.impl.MerchantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the merchant to the database. Also notifies the appropriate model listeners.
	*
	* @param merchant the merchant
	* @return the merchant that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Merchant addMerchant(
		com.cmcti.cmts.domain.model.Merchant merchant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMerchant(merchant);
	}

	/**
	* Creates a new merchant with the primary key. Does not add the merchant to the database.
	*
	* @param merchantId the primary key for the new merchant
	* @return the new merchant
	*/
	public static com.cmcti.cmts.domain.model.Merchant createMerchant(
		long merchantId) {
		return getService().createMerchant(merchantId);
	}

	/**
	* Deletes the merchant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param merchantId the primary key of the merchant
	* @return the merchant that was removed
	* @throws PortalException if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Merchant deleteMerchant(
		long merchantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMerchant(merchantId);
	}

	/**
	* Deletes the merchant from the database. Also notifies the appropriate model listeners.
	*
	* @param merchant the merchant
	* @return the merchant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Merchant deleteMerchant(
		com.cmcti.cmts.domain.model.Merchant merchant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMerchant(merchant);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.cmcti.cmts.domain.model.Merchant fetchMerchant(
		long merchantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMerchant(merchantId);
	}

	/**
	* Returns the merchant with the primary key.
	*
	* @param merchantId the primary key of the merchant
	* @return the merchant
	* @throws PortalException if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Merchant getMerchant(
		long merchantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMerchant(merchantId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the merchants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchants
	* @param end the upper bound of the range of merchants (not inclusive)
	* @return the range of merchants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.Merchant> getMerchants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMerchants(start, end);
	}

	/**
	* Returns the number of merchants.
	*
	* @return the number of merchants
	* @throws SystemException if a system exception occurred
	*/
	public static int getMerchantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMerchantsCount();
	}

	/**
	* Updates the merchant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param merchant the merchant
	* @return the merchant that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Merchant updateMerchant(
		com.cmcti.cmts.domain.model.Merchant merchant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMerchant(merchant);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.cmcti.cmts.domain.model.Merchant fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByCode(code);
	}

	public static com.cmcti.cmts.domain.model.Merchant updateMerchant(
		com.cmcti.cmts.domain.model.Merchant merchant,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMerchant(merchant, serviceContext);
	}

	public static void importMerchant(java.io.InputStream is, int sheetIdx,
		int startRowIdx,
		com.liferay.portal.service.ServiceContext serviceContext,
		boolean deleteAll)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.importMerchant(is, sheetIdx, startRowIdx, serviceContext, deleteAll);
	}

	public static void addUpstreamToMerchant(long merchantId,
		java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> upstreams,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUpstreamToMerchant(merchantId, upstreams, serviceContext);
	}

	public static void removeUpstreamFromMerchant(long merchantId,
		java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> upstreams,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.removeUpstreamFromMerchant(merchantId, upstreams, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static MerchantLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MerchantLocalService.class.getName());

			if (invokableLocalService instanceof MerchantLocalService) {
				_service = (MerchantLocalService)invokableLocalService;
			}
			else {
				_service = new MerchantLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MerchantLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MerchantLocalService service) {
	}

	private static MerchantLocalService _service;
}