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

import com.cmcti.cmts.domain.model.CableModem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cable modem service. This utility wraps {@link CableModemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemPersistence
 * @see CableModemPersistenceImpl
 * @generated
 */
public class CableModemUtil {
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
	public static void clearCache(CableModem cableModem) {
		getPersistence().clearCache(cableModem);
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
	public static List<CableModem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CableModem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CableModem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CableModem update(CableModem cableModem)
		throws SystemException {
		return getPersistence().update(cableModem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CableModem update(CableModem cableModem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cableModem, serviceContext);
	}

	/**
	* Caches the cable modem in the entity cache if it is enabled.
	*
	* @param cableModem the cable modem
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.CableModem cableModem) {
		getPersistence().cacheResult(cableModem);
	}

	/**
	* Caches the cable modems in the entity cache if it is enabled.
	*
	* @param cableModems the cable modems
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.CableModem> cableModems) {
		getPersistence().cacheResult(cableModems);
	}

	/**
	* Creates a new cable modem with the primary key. Does not add the cable modem to the database.
	*
	* @param macAddress the primary key for the new cable modem
	* @return the new cable modem
	*/
	public static com.cmcti.cmts.domain.model.CableModem create(
		java.lang.String macAddress) {
		return getPersistence().create(macAddress);
	}

	/**
	* Removes the cable modem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem remove(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(macAddress);
	}

	public static com.cmcti.cmts.domain.model.CableModem updateImpl(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cableModem);
	}

	/**
	* Returns the cable modem with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemException} if it could not be found.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByPrimaryKey(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(macAddress);
	}

	/**
	* Returns the cable modem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem, or <code>null</code> if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByPrimaryKey(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(macAddress);
	}

	/**
	* Returns all the cable modems.
	*
	* @return the cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cable modems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cable modems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cable modems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cable modems.
	*
	* @return the number of cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CableModemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CableModemPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					CableModemPersistence.class.getName());

			ReferenceRegistry.registerReference(CableModemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CableModemPersistence persistence) {
	}

	private static CableModemPersistence _persistence;
}