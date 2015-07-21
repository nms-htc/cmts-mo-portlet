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
 * Provides a wrapper for {@link UpChannelMetadataLocalService}.
 *
 * @author richard
 * @see UpChannelMetadataLocalService
 * @generated
 */
public class UpChannelMetadataLocalServiceWrapper
	implements UpChannelMetadataLocalService,
		ServiceWrapper<UpChannelMetadataLocalService> {
	public UpChannelMetadataLocalServiceWrapper(
		UpChannelMetadataLocalService upChannelMetadataLocalService) {
		_upChannelMetadataLocalService = upChannelMetadataLocalService;
	}

	/**
	* Adds the up channel metadata to the database. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata addUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.addUpChannelMetadata(upChannelMetadata);
	}

	/**
	* Creates a new up channel metadata with the primary key. Does not add the up channel metadata to the database.
	*
	* @param metaId the primary key for the new up channel metadata
	* @return the new up channel metadata
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata createUpChannelMetadata(
		long metaId) {
		return _upChannelMetadataLocalService.createUpChannelMetadata(metaId);
	}

	/**
	* Deletes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata that was removed
	* @throws PortalException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata deleteUpChannelMetadata(
		long metaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.deleteUpChannelMetadata(metaId);
	}

	/**
	* Deletes the up channel metadata from the database. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata deleteUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.deleteUpChannelMetadata(upChannelMetadata);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _upChannelMetadataLocalService.dynamicQuery();
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
		return _upChannelMetadataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.dynamicQuery(dynamicQuery, start,
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
		return _upChannelMetadataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _upChannelMetadataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchUpChannelMetadata(
		long metaId) throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.fetchUpChannelMetadata(metaId);
	}

	/**
	* Returns the up channel metadata with the primary key.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata
	* @throws PortalException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata getUpChannelMetadata(
		long metaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.getUpChannelMetadata(metaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> getUpChannelMetadatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.getUpChannelMetadatas(start, end);
	}

	/**
	* Returns the number of up channel metadatas.
	*
	* @return the number of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUpChannelMetadatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.getUpChannelMetadatasCount();
	}

	/**
	* Updates the up channel metadata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param upChannelMetadata the up channel metadata
	* @return the up channel metadata that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata updateUpChannelMetadata(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.updateUpChannelMetadata(upChannelMetadata);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _upChannelMetadataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_upChannelMetadataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _upChannelMetadataLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata update(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.update(upChannelMetadata, context);
	}

	@Override
	public com.cmcti.cmts.domain.model.UpChannelMetadata findByCmtsAndIfIndex(
		long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _upChannelMetadataLocalService.findByCmtsAndIfIndex(cmtsId,
			ifIndex);
	}

	@Override
	public void importAddressFromXls(java.io.InputStream is, int sheetIdx,
		int startRow, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_upChannelMetadataLocalService.importAddressFromXls(is, sheetIdx,
			startRow, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UpChannelMetadataLocalService getWrappedUpChannelMetadataLocalService() {
		return _upChannelMetadataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUpChannelMetadataLocalService(
		UpChannelMetadataLocalService upChannelMetadataLocalService) {
		_upChannelMetadataLocalService = upChannelMetadataLocalService;
	}

	@Override
	public UpChannelMetadataLocalService getWrappedService() {
		return _upChannelMetadataLocalService;
	}

	@Override
	public void setWrappedService(
		UpChannelMetadataLocalService upChannelMetadataLocalService) {
		_upChannelMetadataLocalService = upChannelMetadataLocalService;
	}

	private UpChannelMetadataLocalService _upChannelMetadataLocalService;
}