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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the up channel metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpChannelMetadataPersistenceImpl
 * @see UpChannelMetadataUtil
 * @generated
 */
public interface UpChannelMetadataPersistence extends BasePersistence<UpChannelMetadata> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpChannelMetadataUtil} to access the up channel metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the up channel metadatas where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findByCMTS(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata findByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata findByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmcti.cmts.domain.model.UpChannelMetadata[] findByCMTS_PrevAndNext(
		long metaId, long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the up channel metadatas where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of up channel metadatas where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata findByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchByUpstreamChannel(
		long cmtsId, int ifIndex, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the up channel metadata where cmtsId = &#63; and ifIndex = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the up channel metadata that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata removeByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of up channel metadatas where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the number of matching up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUpstreamChannel(long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the up channel metadata in the entity cache if it is enabled.
	*
	* @param upChannelMetadata the up channel metadata
	*/
	public void cacheResult(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata);

	/**
	* Caches the up channel metadatas in the entity cache if it is enabled.
	*
	* @param upChannelMetadatas the up channel metadatas
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> upChannelMetadatas);

	/**
	* Creates a new up channel metadata with the primary key. Does not add the up channel metadata to the database.
	*
	* @param metaId the primary key for the new up channel metadata
	* @return the new up channel metadata
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata create(long metaId);

	/**
	* Removes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata that was removed
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata remove(long metaId)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.UpChannelMetadata updateImpl(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the up channel metadata with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata
	* @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata findByPrimaryKey(
		long metaId)
		throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the up channel metadata with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metaId the primary key of the up channel metadata
	* @return the up channel metadata, or <code>null</code> if a up channel metadata with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpChannelMetadata fetchByPrimaryKey(
		long metaId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the up channel metadatas.
	*
	* @return the up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.UpChannelMetadata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the up channel metadatas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of up channel metadatas.
	*
	* @return the number of up channel metadatas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}