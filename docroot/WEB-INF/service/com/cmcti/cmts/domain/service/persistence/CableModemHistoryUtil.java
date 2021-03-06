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

import com.cmcti.cmts.domain.model.CableModemHistory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cable modem history service. This utility wraps {@link CableModemHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemHistoryPersistence
 * @see CableModemHistoryPersistenceImpl
 * @generated
 */
public class CableModemHistoryUtil {
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
	public static void clearCache(CableModemHistory cableModemHistory) {
		getPersistence().clearCache(cableModemHistory);
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
	public static List<CableModemHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CableModemHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CableModemHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CableModemHistory update(CableModemHistory cableModemHistory)
		throws SystemException {
		return getPersistence().update(cableModemHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CableModemHistory update(
		CableModemHistory cableModemHistory, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cableModemHistory, serviceContext);
	}

	/**
	* Returns all the cable modem histories where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @return the matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByMacAddress(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMacAddress(macAddress);
	}

	/**
	* Returns a range of all the cable modem histories where macAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param macAddress the mac address
	* @param start the lower bound of the range of cable modem histories
	* @param end the upper bound of the range of cable modem histories (not inclusive)
	* @return the range of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByMacAddress(
		java.lang.String macAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMacAddress(macAddress, start, end);
	}

	/**
	* Returns an ordered range of all the cable modem histories where macAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param macAddress the mac address
	* @param start the lower bound of the range of cable modem histories
	* @param end the upper bound of the range of cable modem histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByMacAddress(
		java.lang.String macAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMacAddress(macAddress, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem history in the ordered set where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory findByMacAddress_First(
		java.lang.String macAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMacAddress_First(macAddress, orderByComparator);
	}

	/**
	* Returns the first cable modem history in the ordered set where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem history, or <code>null</code> if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory fetchByMacAddress_First(
		java.lang.String macAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMacAddress_First(macAddress, orderByComparator);
	}

	/**
	* Returns the last cable modem history in the ordered set where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory findByMacAddress_Last(
		java.lang.String macAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMacAddress_Last(macAddress, orderByComparator);
	}

	/**
	* Returns the last cable modem history in the ordered set where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem history, or <code>null</code> if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory fetchByMacAddress_Last(
		java.lang.String macAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMacAddress_Last(macAddress, orderByComparator);
	}

	/**
	* Returns the cable modem histories before and after the current cable modem history in the ordered set where macAddress = &#63;.
	*
	* @param cmHisId the primary key of the current cable modem history
	* @param macAddress the mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory[] findByMacAddress_PrevAndNext(
		long cmHisId, java.lang.String macAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMacAddress_PrevAndNext(cmHisId, macAddress,
			orderByComparator);
	}

	/**
	* Removes all the cable modem histories where macAddress = &#63; from the database.
	*
	* @param macAddress the mac address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMacAddress(java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMacAddress(macAddress);
	}

	/**
	* Returns the number of cable modem histories where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @return the number of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMacAddress(java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMacAddress(macAddress);
	}

	/**
	* Returns all the cable modem histories where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByCmtsId(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId(cmtsId);
	}

	/**
	* Returns a range of all the cable modem histories where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of cable modem histories
	* @param end the upper bound of the range of cable modem histories (not inclusive)
	* @return the range of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByCmtsId(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId(cmtsId, start, end);
	}

	/**
	* Returns an ordered range of all the cable modem histories where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of cable modem histories
	* @param end the upper bound of the range of cable modem histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findByCmtsId(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCmtsId(cmtsId, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory findByCmtsId_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the first cable modem history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem history, or <code>null</code> if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory fetchByCmtsId_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmtsId_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the last cable modem history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory findByCmtsId_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmtsId_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the last cable modem history in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem history, or <code>null</code> if a matching cable modem history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory fetchByCmtsId_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmtsId_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the cable modem histories before and after the current cable modem history in the ordered set where cmtsId = &#63;.
	*
	* @param cmHisId the primary key of the current cable modem history
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory[] findByCmtsId_PrevAndNext(
		long cmHisId, long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCmtsId_PrevAndNext(cmHisId, cmtsId, orderByComparator);
	}

	/**
	* Removes all the cable modem histories where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCmtsId(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCmtsId(cmtsId);
	}

	/**
	* Returns the number of cable modem histories where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCmtsId(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCmtsId(cmtsId);
	}

	/**
	* Caches the cable modem history in the entity cache if it is enabled.
	*
	* @param cableModemHistory the cable modem history
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory) {
		getPersistence().cacheResult(cableModemHistory);
	}

	/**
	* Caches the cable modem histories in the entity cache if it is enabled.
	*
	* @param cableModemHistories the cable modem histories
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> cableModemHistories) {
		getPersistence().cacheResult(cableModemHistories);
	}

	/**
	* Creates a new cable modem history with the primary key. Does not add the cable modem history to the database.
	*
	* @param cmHisId the primary key for the new cable modem history
	* @return the new cable modem history
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory create(
		long cmHisId) {
		return getPersistence().create(cmHisId);
	}

	/**
	* Removes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cmHisId the primary key of the cable modem history
	* @return the cable modem history that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory remove(
		long cmHisId)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(cmHisId);
	}

	public static com.cmcti.cmts.domain.model.CableModemHistory updateImpl(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cableModemHistory);
	}

	/**
	* Returns the cable modem history with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemHistoryException} if it could not be found.
	*
	* @param cmHisId the primary key of the cable modem history
	* @return the cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory findByPrimaryKey(
		long cmHisId)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(cmHisId);
	}

	/**
	* Returns the cable modem history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cmHisId the primary key of the cable modem history
	* @return the cable modem history, or <code>null</code> if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModemHistory fetchByPrimaryKey(
		long cmHisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cmHisId);
	}

	/**
	* Returns all the cable modem histories.
	*
	* @return the cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cable modem histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cable modem histories
	* @param end the upper bound of the range of cable modem histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cable modem histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cable modem histories.
	*
	* @return the number of cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CableModemHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CableModemHistoryPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					CableModemHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CableModemHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CableModemHistoryPersistence persistence) {
	}

	private static CableModemHistoryPersistence _persistence;
}