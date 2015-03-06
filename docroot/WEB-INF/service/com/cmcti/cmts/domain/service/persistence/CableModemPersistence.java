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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cable modem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemPersistenceImpl
 * @see CableModemUtil
 * @generated
 */
public interface CableModemPersistence extends BasePersistence<CableModem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CableModemUtil} to access the cable modem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cable modem in the entity cache if it is enabled.
	*
	* @param cableModem the cable modem
	*/
	public void cacheResult(com.cmcti.cmts.domain.model.CableModem cableModem);

	/**
	* Caches the cable modems in the entity cache if it is enabled.
	*
	* @param cableModems the cable modems
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.CableModem> cableModems);

	/**
	* Creates a new cable modem with the primary key. Does not add the cable modem to the database.
	*
	* @param macAddress the primary key for the new cable modem
	* @return the new cable modem
	*/
	public com.cmcti.cmts.domain.model.CableModem create(
		java.lang.String macAddress);

	/**
	* Removes the cable modem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModem remove(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.CableModem updateImpl(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cable modem with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemException} if it could not be found.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModem findByPrimaryKey(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cable modem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param macAddress the primary key of the cable modem
	* @return the cable modem, or <code>null</code> if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModem fetchByPrimaryKey(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cable modems.
	*
	* @return the cable modems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.CableModem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cable modems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cable modems.
	*
	* @return the number of cable modems
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}