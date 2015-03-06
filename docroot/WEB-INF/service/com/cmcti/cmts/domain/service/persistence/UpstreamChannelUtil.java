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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the upstream channel service. This utility wraps {@link UpstreamChannelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpstreamChannelPersistence
 * @see UpstreamChannelPersistenceImpl
 * @generated
 */
public class UpstreamChannelUtil {
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
	public static void clearCache(UpstreamChannel upstreamChannel) {
		getPersistence().clearCache(upstreamChannel);
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
	public static List<UpstreamChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpstreamChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpstreamChannel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UpstreamChannel update(UpstreamChannel upstreamChannel)
		throws SystemException {
		return getPersistence().update(upstreamChannel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UpstreamChannel update(UpstreamChannel upstreamChannel,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(upstreamChannel, serviceContext);
	}

	/**
	* Caches the upstream channel in the entity cache if it is enabled.
	*
	* @param upstreamChannel the upstream channel
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel) {
		getPersistence().cacheResult(upstreamChannel);
	}

	/**
	* Caches the upstream channels in the entity cache if it is enabled.
	*
	* @param upstreamChannels the upstream channels
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> upstreamChannels) {
		getPersistence().cacheResult(upstreamChannels);
	}

	/**
	* Creates a new upstream channel with the primary key. Does not add the upstream channel to the database.
	*
	* @param upstreamChannelPK the primary key for the new upstream channel
	* @return the new upstream channel
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel create(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK) {
		return getPersistence().create(upstreamChannelPK);
	}

	/**
	* Removes the upstream channel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel that was removed
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel remove(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(upstreamChannelPK);
	}

	public static com.cmcti.cmts.domain.model.UpstreamChannel updateImpl(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(upstreamChannel);
	}

	/**
	* Returns the upstream channel with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpstreamChannelException} if it could not be found.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(upstreamChannelPK);
	}

	/**
	* Returns the upstream channel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param upstreamChannelPK the primary key of the upstream channel
	* @return the upstream channel, or <code>null</code> if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(upstreamChannelPK);
	}

	/**
	* Returns all the upstream channels.
	*
	* @return the upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the upstream channels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of upstream channels.
	*
	* @return the number of upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UpstreamChannelPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UpstreamChannelPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					UpstreamChannelPersistence.class.getName());

			ReferenceRegistry.registerReference(UpstreamChannelUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UpstreamChannelPersistence persistence) {
	}

	private static UpstreamChannelPersistence _persistence;
}