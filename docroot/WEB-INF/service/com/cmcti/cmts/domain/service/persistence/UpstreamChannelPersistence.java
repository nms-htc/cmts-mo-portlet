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
	* Returns all the upstream channels where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where fecUncorrectable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where fecUncorrectable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByFecUncorrectable_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where fecUncorrectable = &#63; from the database.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where fecCorrected = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecCorrected the fec corrected
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where fecCorrected = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecCorrected the fec corrected
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByFecCorrected_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where fecCorrected = &#63; from the database.
	*
	* @param fecCorrected the fec corrected
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where ifSigQSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ifSigQSNR the if sig q s n r
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where ifSigQSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ifSigQSNR the if sig q s n r
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByIfSigQSNR_First(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByIfSigQSNR_First(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByIfSigQSNR_Last(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByIfSigQSNR_Last(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByIfSigQSNR_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where ifSigQSNR = &#63; from the database.
	*
	* @param ifSigQSNR the if sig q s n r
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIfSigQSNR(double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByIfSigQSNR(double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByCmts_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByCmts_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByCmts_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByCmts_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByCmts_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCmts(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByCmts(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineCmTxPower_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where avgOnlineCmTxPower = &#63; from the database.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineCmRxPower_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where avgOnlineCmRxPower = &#63; from the database.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @return the range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param start the lower bound of the range of upstream channels
	* @param end the upper bound of the range of upstream channels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineDsSNR_First(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineDsSNR_First(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineDsSNR_Last(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineDsSNR_Last(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param upstreamChannelPK the primary key of the current upstream channel
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineDsSNR_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the upstream channels where avgOnlineCmDsSNR = &#63; from the database.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public int countByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException;

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