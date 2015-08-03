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
 * Provides the local service utility for UpChannelMetadata. This utility wraps
 * {@link com.cmcti.cmts.domain.service.impl.UpChannelMetadataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author richard
 * @see UpChannelMetadataLocalService
 * @see com.cmcti.cmts.domain.service.base.UpChannelMetadataLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.impl.UpChannelMetadataLocalServiceImpl
 * @generated
 */
public class UpChannelMetadataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmcti.cmts.domain.service.impl.UpChannelMetadataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the up channel metadata to the database. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata addUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUpChannelMetadata(upChannelMetadata);
	}

	/**
	* Creates a new up channel metadata with the primary key. Does not add the up channel metadata to the database.
	*
	* @param metaId the primary key for the new up channel metadata
	* @return the new up channel metadata
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata createUpChannelMetadata(
		long metaId) {
		return getService().createUpChannelMetadata(metaId);
	}

	/**
	* Deletes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata that was removed
	* @throws PortalException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata deleteUpChannelMetadata(
		long metaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUpChannelMetadata(metaId);
	}

	/**
	* Deletes the up channel metadata from the database. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata deleteUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUpChannelMetadata(upChannelMetadata);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchUpChannelMetadata(
		long metaId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUpChannelMetadata(metaId);
	}

	/**
	* Returns the up channel metadata with the primary key.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata
	* @throws PortalException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata getUpChannelMetadata(
		long metaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpChannelMetadata(metaId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the up channel metadatas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of up channel metadatas
	* @param end the upper bound of the range of up channel metadatas (not inclusive)
	* @return the range of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> getUpChannelMetadatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpChannelMetadatas(start, end);
	}

	/**
	* Returns the number of up channel metadatas.
	*
	* @return the number of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static int getUpChannelMetadatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpChannelMetadatasCount();
	}

	/**
	* Updates the up channel metadata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata updateUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUpChannelMetadata(upChannelMetadata);
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

	public static com.cmcti.cmts.domain.model.UpChannelMetadata update(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().update(upChannelMetadata, context);
	}

	public static com.cmcti.cmts.domain.model.UpChannelMetadata findByCmtsAndIfIndex(
		long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCmtsAndIfIndex(cmtsId, ifIndex);
	}

	public static void importAddressFromXls(java.io.InputStream is,
		int sheetIdx, int startRow,
		com.liferay.portal.service.ServiceContext serviceContext,
		boolean deleteAll)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.importAddressFromXls(is, sheetIdx, startRow, serviceContext,
			deleteAll);
	}

	public static void clearService() {
		_service = null;
	}

	public static UpChannelMetadataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UpChannelMetadataLocalService.class.getName());

			if (invokableLocalService instanceof UpChannelMetadataLocalService) {
				_service = (UpChannelMetadataLocalService)invokableLocalService;
			}
			else {
				_service = new UpChannelMetadataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UpChannelMetadataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UpChannelMetadataLocalService service) {
	}

	private static UpChannelMetadataLocalService _service;
}