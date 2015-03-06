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

import com.cmcti.cmts.domain.model.Cmts;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cmts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CmtsPersistenceImpl
 * @see CmtsUtil
 * @generated
 */
public interface CmtsPersistence extends BasePersistence<Cmts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CmtsUtil} to access the cmts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cmtses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cmtses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of cmtses
	* @param end the upper bound of the range of cmtses (not inclusive)
	* @return the range of matching cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cmtses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of cmtses
	* @param end the upper bound of the range of cmtses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cmts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cmts
	* @throws com.cmcti.cmts.domain.NoSuchCmtsException if a matching cmts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCmtsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cmts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cmts, or <code>null</code> if a matching cmts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cmts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cmts
	* @throws com.cmcti.cmts.domain.NoSuchCmtsException if a matching cmts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCmtsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cmts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cmts, or <code>null</code> if a matching cmts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cmtses before and after the current cmts in the ordered set where userId = &#63;.
	*
	* @param cmtsId the primary key of the current cmts
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cmts
	* @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts[] findByUser_PrevAndNext(
		long cmtsId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCmtsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cmtses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cmtses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching cmtses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cmts in the entity cache if it is enabled.
	*
	* @param cmts the cmts
	*/
	public void cacheResult(com.cmcti.cmts.domain.model.Cmts cmts);

	/**
	* Caches the cmtses in the entity cache if it is enabled.
	*
	* @param cmtses the cmtses
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.Cmts> cmtses);

	/**
	* Creates a new cmts with the primary key. Does not add the cmts to the database.
	*
	* @param cmtsId the primary key for the new cmts
	* @return the new cmts
	*/
	public com.cmcti.cmts.domain.model.Cmts create(long cmtsId);

	/**
	* Removes the cmts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cmtsId the primary key of the cmts
	* @return the cmts that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts remove(long cmtsId)
		throws com.cmcti.cmts.domain.NoSuchCmtsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.Cmts updateImpl(
		com.cmcti.cmts.domain.model.Cmts cmts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cmts with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCmtsException} if it could not be found.
	*
	* @param cmtsId the primary key of the cmts
	* @return the cmts
	* @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts findByPrimaryKey(long cmtsId)
		throws com.cmcti.cmts.domain.NoSuchCmtsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cmts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cmtsId the primary key of the cmts
	* @return the cmts, or <code>null</code> if a cmts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Cmts fetchByPrimaryKey(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cmtses.
	*
	* @return the cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cmtses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cmtses
	* @param end the upper bound of the range of cmtses (not inclusive)
	* @return the range of cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cmtses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cmtses
	* @param end the upper bound of the range of cmtses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cmtses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Cmts> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cmtses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cmtses.
	*
	* @return the number of cmtses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}