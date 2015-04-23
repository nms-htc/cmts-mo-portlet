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

import com.cmcti.cmts.domain.model.UpstreamChannelHistory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the upstream channel history service. This utility wraps {@link UpstreamChannelHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpstreamChannelHistoryPersistence
 * @see UpstreamChannelHistoryPersistenceImpl
 * @generated
 */
public class UpstreamChannelHistoryUtil {
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
	public static void clearCache(UpstreamChannelHistory upstreamChannelHistory) {
		getPersistence().clearCache(upstreamChannelHistory);
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
	public static List<UpstreamChannelHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpstreamChannelHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpstreamChannelHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UpstreamChannelHistory update(
		UpstreamChannelHistory upstreamChannelHistory)
		throws SystemException {
		return getPersistence().update(upstreamChannelHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UpstreamChannelHistory update(
		UpstreamChannelHistory upstreamChannelHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(upstreamChannelHistory, serviceContext);
	}

	/**
	* Returns all the upstream channel histories where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @return the matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByIfIndex(
		int ifIndex) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfIndex(ifIndex);
	}

	/**
	* Returns a range of all the upstream channel histories where ifIndex = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ifIndex the if index
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @return the range of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByIfIndex(
		int ifIndex, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfIndex(ifIndex, start, end);
	}

	/**
	* Returns an ordered range of all the upstream channel histories where ifIndex = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ifIndex the if index
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByIfIndex(
		int ifIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfIndex(ifIndex, start, end, orderByComparator);
	}

	/**
	* Returns the first upstream channel history in the ordered set where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory findByIfIndex_First(
		int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfIndex_First(ifIndex, orderByComparator);
	}

	/**
	* Returns the first upstream channel history in the ordered set where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel history, or <code>null</code> if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory fetchByIfIndex_First(
		int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIfIndex_First(ifIndex, orderByComparator);
	}

	/**
	* Returns the last upstream channel history in the ordered set where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory findByIfIndex_Last(
		int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfIndex_Last(ifIndex, orderByComparator);
	}

	/**
	* Returns the last upstream channel history in the ordered set where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel history, or <code>null</code> if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory fetchByIfIndex_Last(
		int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIfIndex_Last(ifIndex, orderByComparator);
	}

	/**
	* Returns the upstream channel histories before and after the current upstream channel history in the ordered set where ifIndex = &#63;.
	*
	* @param ucHisId the primary key of the current upstream channel history
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory[] findByIfIndex_PrevAndNext(
		long ucHisId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfIndex_PrevAndNext(ucHisId, ifIndex,
			orderByComparator);
	}

	/**
	* Removes all the upstream channel histories where ifIndex = &#63; from the database.
	*
	* @param ifIndex the if index
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIfIndex(int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIfIndex(ifIndex);
	}

	/**
	* Returns the number of upstream channel histories where ifIndex = &#63;.
	*
	* @param ifIndex the if index
	* @return the number of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIfIndex(int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIfIndex(ifIndex);
	}

	/**
	* Returns all the upstream channel histories where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByCmtsId(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId(cmtsId);
	}

	/**
	* Returns a range of all the upstream channel histories where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @return the range of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByCmtsId(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId(cmtsId, start, end);
	}

	/**
	* Returns an ordered range of all the upstream channel histories where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findByCmtsId(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCmtsId(cmtsId, start, end, orderByComparator);
	}

	/**
	* Returns the first upstream channel history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory findByCmtsId_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the first upstream channel history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel history, or <code>null</code> if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory fetchByCmtsId_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmtsId_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the last upstream channel history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory findByCmtsId_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the last upstream channel history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel history, or <code>null</code> if a matching upstream channel history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory fetchByCmtsId_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmtsId_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the upstream channel histories before and after the current upstream channel history in the ordered set where cmtsId = &#63;.
	*
	* @param ucHisId the primary key of the current upstream channel history
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory[] findByCmtsId_PrevAndNext(
		long ucHisId, long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCmtsId_PrevAndNext(ucHisId, cmtsId, orderByComparator);
	}

	/**
	* Removes all the upstream channel histories where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCmtsId(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCmtsId(cmtsId);
	}

	/**
	* Returns the number of upstream channel histories where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCmtsId(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCmtsId(cmtsId);
	}

	/**
	* Caches the upstream channel history in the entity cache if it is enabled.
	*
	* @param upstreamChannelHistory the upstream channel history
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.UpstreamChannelHistory upstreamChannelHistory) {
		getPersistence().cacheResult(upstreamChannelHistory);
	}

	/**
	* Caches the upstream channel histories in the entity cache if it is enabled.
	*
	* @param upstreamChannelHistories the upstream channel histories
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> upstreamChannelHistories) {
		getPersistence().cacheResult(upstreamChannelHistories);
	}

	/**
	* Creates a new upstream channel history with the primary key. Does not add the upstream channel history to the database.
	*
	* @param ucHisId the primary key for the new upstream channel history
	* @return the new upstream channel history
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory create(
		long ucHisId) {
		return getPersistence().create(ucHisId);
	}

	/**
	* Removes the upstream channel history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ucHisId the primary key of the upstream channel history
	* @return the upstream channel history that was removed
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory remove(
		long ucHisId)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ucHisId);
	}

	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory updateImpl(
		com.cmcti.cmts.domain.model.UpstreamChannelHistory upstreamChannelHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(upstreamChannelHistory);
	}

	/**
	* Returns the upstream channel history with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException} if it could not be found.
	*
	* @param ucHisId the primary key of the upstream channel history
	* @return the upstream channel history
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory findByPrimaryKey(
		long ucHisId)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ucHisId);
	}

	/**
	* Returns the upstream channel history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ucHisId the primary key of the upstream channel history
	* @return the upstream channel history, or <code>null</code> if a upstream channel history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannelHistory fetchByPrimaryKey(
		long ucHisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ucHisId);
	}

	/**
	* Returns all the upstream channel histories.
	*
	* @return the upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the upstream channel histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @return the range of upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the upstream channel histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upstream channel histories
	* @param end the upper bound of the range of upstream channel histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannelHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the upstream channel histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of upstream channel histories.
	*
	* @return the number of upstream channel histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UpstreamChannelHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UpstreamChannelHistoryPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					UpstreamChannelHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(UpstreamChannelHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UpstreamChannelHistoryPersistence persistence) {
	}

	private static UpstreamChannelHistoryPersistence _persistence;
}