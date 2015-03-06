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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cable modem history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemHistoryPersistenceImpl
 * @see CableModemHistoryUtil
 * @generated
 */
public interface CableModemHistoryPersistence extends BasePersistence<CableModemHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CableModemHistoryUtil} to access the cable modem history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cable modem history in the entity cache if it is enabled.
	*
	* @param cableModemHistory the cable modem history
	*/
	public void cacheResult(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory);

	/**
	* Caches the cable modem histories in the entity cache if it is enabled.
	*
	* @param cableModemHistories the cable modem histories
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> cableModemHistories);

	/**
	* Creates a new cable modem history with the primary key. Does not add the cable modem history to the database.
	*
	* @param cableModemHistoryPK the primary key for the new cable modem history
	* @return the new cable modem history
	*/
	public com.cmcti.cmts.domain.model.CableModemHistory create(
		com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK cableModemHistoryPK);

	/**
	* Removes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cableModemHistoryPK the primary key of the cable modem history
	* @return the cable modem history that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModemHistory remove(
		com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK cableModemHistoryPK)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.CableModemHistory updateImpl(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cable modem history with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemHistoryException} if it could not be found.
	*
	* @param cableModemHistoryPK the primary key of the cable modem history
	* @return the cable modem history
	* @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModemHistory findByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK cableModemHistoryPK)
		throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cable modem history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cableModemHistoryPK the primary key of the cable modem history
	* @return the cable modem history, or <code>null</code> if a cable modem history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CableModemHistory fetchByPrimaryKey(
		com.cmcti.cmts.domain.service.persistence.CableModemHistoryPK cableModemHistoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cable modem histories.
	*
	* @return the cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmcti.cmts.domain.model.CableModemHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cable modem histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cable modem histories.
	*
	* @return the number of cable modem histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}