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

package com.cmcti.cmts.domain.service.persistence;

import com.cmcti.cmts.domain.model.UpChannelMetadata;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the up channel metadata service. This utility wraps {@link UpChannelMetadataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpChannelMetadataPersistence
 * @see UpChannelMetadataPersistenceImpl
 * @generated
 */
public class UpChannelMetadataUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UpChannelMetadata upChannelMetadata) {
		getPersistence().clearCache(upChannelMetadata);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UpChannelMetadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpChannelMetadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpChannelMetadata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UpChannelMetadata update(UpChannelMetadata upChannelMetadata)
		throws SystemException {
		return getPersistence().update(upChannelMetadata);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UpChannelMetadata update(
		UpChannelMetadata upChannelMetadata, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(upChannelMetadata, serviceContext);
	}

	/**
	* Returns all the up channel metadatas where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId);
	}

	/**
	* Returns a range of all the up channel metadatas where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of up channel metadatas
	* @param end the upper bound of the range of up channel metadatas (not inclusive)
	* @return the range of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId, start, end);
	}

	/**
	* Returns an ordered range of all the up channel metadatas where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of up channel metadatas
	* @param end the upper bound of the range of up channel metadatas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId, start, end, orderByComparator);
	}

	/**
	* Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata findByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCMTS_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata findByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCMTS_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the up channel metadatas before and after the current up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param metaId the primary key of the current up channel metadata
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata[] findByCMTS_PrevAndNext(
		long metaId, long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCMTS_PrevAndNext(metaId, cmtsId, orderByComparator);
	}

	/**
	* Removes all the up channel metadatas where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCMTS(cmtsId);
	}

	/**
	* Returns the number of up channel metadatas where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCMTS(cmtsId);
	}

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata findByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchByUpstreamChannel(
		long cmtsId, int ifIndex, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUpstreamChannel(cmtsId, ifIndex, retrieveFromCache);
	}

	/**
	* Removes the up channel metadata where cmtsId = &#63; and ifIndex = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the up channel metadata that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata removeByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns the number of up channel metadatas where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the number of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUpstreamChannel(long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Caches the up channel metadata in the entity cache if it is enabled.
	*
	* @param upChannelMetadata the up channel metadata
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata) {
		getPersistence().cacheResult(upChannelMetadata);
	}

	/**
	* Caches the up channel metadatas in the entity cache if it is enabled.
	*
	* @param upChannelMetadatas the up channel metadatas
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> upChannelMetadatas) {
		getPersistence().cacheResult(upChannelMetadatas);
	}

	/**
	* Creates a new up channel metadata with the primary key. Does not add the up channel metadata to the database.
	*
	* @param metaId the primary key for the new up channel metadata
	* @return the new up channel metadata
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata create(
		long metaId) {
		return getPersistence().create(metaId);
	}

	/**
	* Removes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata that was removed
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata remove(
		long metaId)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(metaId);
	}

	public static com.cmcti.cmts.domain.model.UpChannelMetadata updateImpl(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(upChannelMetadata);
	}

	/**
	* Returns the up channel metadata with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata findByPrimaryKey(
		long metaId)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(metaId);
	}

	/**
	* Returns the up channel metadata with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata, or <code>null</code> if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpChannelMetadata fetchByPrimaryKey(
		long metaId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(metaId);
	}

	/**
	* Returns all the up channel metadatas.
	*
	* @return the up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the up channel metadatas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of up channel metadatas
	* @param end the upper bound of the range of up channel metadatas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the up channel metadatas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of up channel metadatas.
	*
	* @return the number of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UpChannelMetadataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UpChannelMetadataPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					UpChannelMetadataPersistence.class.getName());

			ReferenceRegistry.registerReference(UpChannelMetadataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UpChannelMetadataPersistence persistence) {
	}

	private static UpChannelMetadataPersistence _persistence;
}