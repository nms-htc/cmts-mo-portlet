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

import com.cmcti.cmts.domain.model.UpstreamChannel;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the upstream channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpstreamChannelPersistenceImpl
 * @see UpstreamChannelUtil
 * @generated
 */
public interface UpstreamChannelPersistence extends BasePersistence<UpstreamChannel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpstreamChannelUtil} to access the upstream channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the upstream channel in the entity cache if it is enabled.
	*
	* @param upstreamChannel the upstream channel
	*/
	public void cacheResult(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel);

	/**
	* Caches the upstream channels in the entity cache if it is enabled.
	*
	* @param upstreamChannels the upstream channels
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> upstreamChannels);

	/**
	* Creates a new upstream channel with the primary key. Does not add the upstream channel to the database.
	*
	* @param upstreamChannelPK the primary key for the new upstream channel
	* @return the new upstream channel
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel create(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK);

	/**
	* Removes the upstream channel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel that was removed
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel remove(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.UpstreamChannel updateImpl(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channel with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpstreamChannelException} if it could not be found.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel, or <code>null</code> if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels.
	*
	* @return the upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels.
	*
	* @return the number of upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}