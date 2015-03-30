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
	* Returns all the upstream channels where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecUncorrectable(fecUncorrectable);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable(fecUncorrectable, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable(fecUncorrectable, start, end,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_First(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecUncorrectable_First(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_Last(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecUncorrectable_Last(fecUncorrectable,
			orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByFecUncorrectable_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_PrevAndNext(upstreamChannelPK,
			fecUncorrectable, orderByComparator);
	}

	/**
	* Removes all the upstream channels where fecUncorrectable = &#63; from the database.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the number of upstream channels where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns all the upstream channels where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecCorrected(fecCorrected);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecCorrected(fecCorrected, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByFecCorrected(
		double fecCorrected, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected(fecCorrected, start, end,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_First(fecCorrected, orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecCorrected_First(fecCorrected, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_Last(fecCorrected, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecCorrected_Last(fecCorrected, orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByFecCorrected_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_PrevAndNext(upstreamChannelPK,
			fecCorrected, orderByComparator);
	}

	/**
	* Removes all the upstream channels where fecCorrected = &#63; from the database.
	*
	* @param fecCorrected the fec corrected
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFecCorrected(fecCorrected);
	}

	/**
	* Returns the number of upstream channels where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFecCorrected(fecCorrected);
	}

	/**
	* Returns all the upstream channels where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfSigQSNR(ifSigQSNR);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIfSigQSNR(ifSigQSNR, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByIfSigQSNR(
		double ifSigQSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfSigQSNR(ifSigQSNR, start, end, orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByIfSigQSNR_First(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfSigQSNR_First(ifSigQSNR, orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByIfSigQSNR_First(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIfSigQSNR_First(ifSigQSNR, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByIfSigQSNR_Last(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfSigQSNR_Last(ifSigQSNR, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByIfSigQSNR_Last(
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIfSigQSNR_Last(ifSigQSNR, orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByIfSigQSNR_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double ifSigQSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIfSigQSNR_PrevAndNext(upstreamChannelPK, ifSigQSNR,
			orderByComparator);
	}

	/**
	* Removes all the upstream channels where ifSigQSNR = &#63; from the database.
	*
	* @param ifSigQSNR the if sig q s n r
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIfSigQSNR(double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIfSigQSNR(ifSigQSNR);
	}

	/**
	* Returns the number of upstream channels where ifSigQSNR = &#63;.
	*
	* @param ifSigQSNR the if sig q s n r
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIfSigQSNR(double ifSigQSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIfSigQSNR(ifSigQSNR);
	}

	/**
	* Returns all the upstream channels where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmts(cmtsId);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmts(cmtsId, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByCmts(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmts(cmtsId, start, end, orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByCmts_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmts_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByCmts_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmts_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByCmts_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCmts_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByCmts_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCmts_Last(cmtsId, orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByCmts_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCmts_PrevAndNext(upstreamChannelPK, cmtsId,
			orderByComparator);
	}

	/**
	* Removes all the upstream channels where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCmts(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCmts(cmtsId);
	}

	/**
	* Returns the number of upstream channels where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCmts(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCmts(cmtsId);
	}

	/**
	* Returns all the upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvgOnlineCmTxPower(avgOnlineCmTxPower);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmTxPower(avgOnlineCmTxPower, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmTxPower(avgOnlineCmTxPower, start, end,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmTxPower_First(avgOnlineCmTxPower,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineCmTxPower_First(avgOnlineCmTxPower,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmTxPower_Last(avgOnlineCmTxPower,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineCmTxPower_Last(avgOnlineCmTxPower,
			orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineCmTxPower_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmTxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmTxPower_PrevAndNext(upstreamChannelPK,
			avgOnlineCmTxPower, orderByComparator);
	}

	/**
	* Removes all the upstream channels where avgOnlineCmTxPower = &#63; from the database.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAvgOnlineCmTxPower(avgOnlineCmTxPower);
	}

	/**
	* Returns the number of upstream channels where avgOnlineCmTxPower = &#63;.
	*
	* @param avgOnlineCmTxPower the avg online cm tx power
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAvgOnlineCmTxPower(avgOnlineCmTxPower);
	}

	/**
	* Returns all the upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvgOnlineCmRxPower(avgOnlineCmRxPower);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmRxPower(avgOnlineCmRxPower, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmRxPower(avgOnlineCmRxPower, start, end,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmRxPower_First(avgOnlineCmRxPower,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineCmRxPower_First(avgOnlineCmRxPower,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmRxPower_Last(avgOnlineCmRxPower,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineCmRxPower_Last(avgOnlineCmRxPower,
			orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineCmRxPower_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmRxPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineCmRxPower_PrevAndNext(upstreamChannelPK,
			avgOnlineCmRxPower, orderByComparator);
	}

	/**
	* Removes all the upstream channels where avgOnlineCmRxPower = &#63; from the database.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAvgOnlineCmRxPower(avgOnlineCmRxPower);
	}

	/**
	* Returns the number of upstream channels where avgOnlineCmRxPower = &#63;.
	*
	* @param avgOnlineCmRxPower the avg online cm rx power
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAvgOnlineCmRxPower(avgOnlineCmRxPower);
	}

	/**
	* Returns all the upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @return the matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvgOnlineDsSNR(avgOnlineCmDsSNR);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineDsSNR(avgOnlineCmDsSNR, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel> findByAvgOnlineDsSNR(
		double avgOnlineCmDsSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineDsSNR(avgOnlineCmDsSNR, start, end,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineDsSNR_First(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineDsSNR_First(avgOnlineCmDsSNR,
			orderByComparator);
	}

	/**
	* Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineDsSNR_First(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineDsSNR_First(avgOnlineCmDsSNR,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel
	* @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel findByAvgOnlineDsSNR_Last(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineDsSNR_Last(avgOnlineCmDsSNR,
			orderByComparator);
	}

	/**
	* Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.UpstreamChannel fetchByAvgOnlineDsSNR_Last(
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAvgOnlineDsSNR_Last(avgOnlineCmDsSNR,
			orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.UpstreamChannel[] findByAvgOnlineDsSNR_PrevAndNext(
		com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK upstreamChannelPK,
		double avgOnlineCmDsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvgOnlineDsSNR_PrevAndNext(upstreamChannelPK,
			avgOnlineCmDsSNR, orderByComparator);
	}

	/**
	* Removes all the upstream channels where avgOnlineCmDsSNR = &#63; from the database.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAvgOnlineDsSNR(avgOnlineCmDsSNR);
	}

	/**
	* Returns the number of upstream channels where avgOnlineCmDsSNR = &#63;.
	*
	* @param avgOnlineCmDsSNR the avg online cm ds s n r
	* @return the number of matching upstream channels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAvgOnlineDsSNR(avgOnlineCmDsSNR);
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