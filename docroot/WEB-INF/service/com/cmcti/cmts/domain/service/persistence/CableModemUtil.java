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
	* Returns all the cable modems where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecUncorrectable(
		double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns a range of all the cable modems where fecUncorrectable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecUncorrectable(
		double fecUncorrectable, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable(fecUncorrectable, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where fecUncorrectable = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecUncorrectable(
		double fecUncorrectable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable(fecUncorrectable, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_First(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByFecUncorrectable_First(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecUncorrectable_First(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_Last(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByFecUncorrectable_Last(
		double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecUncorrectable_Last(fecUncorrectable,
			orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where fecUncorrectable = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param fecUncorrectable the fec uncorrectable
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByFecUncorrectable_PrevAndNext(
		java.lang.String macAddress, double fecUncorrectable,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecUncorrectable_PrevAndNext(macAddress,
			fecUncorrectable, orderByComparator);
	}

	/**
	* Removes all the cable modems where fecUncorrectable = &#63; from the database.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns the number of cable modems where fecUncorrectable = &#63;.
	*
	* @param fecUncorrectable the fec uncorrectable
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFecUncorrectable(double fecUncorrectable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFecUncorrectable(fecUncorrectable);
	}

	/**
	* Returns all the cable modems where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecCorrected(
		double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecCorrected(fecCorrected);
	}

	/**
	* Returns a range of all the cable modems where fecCorrected = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecCorrected the fec corrected
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecCorrected(
		double fecCorrected, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFecCorrected(fecCorrected, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where fecCorrected = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fecCorrected the fec corrected
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByFecCorrected(
		double fecCorrected, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected(fecCorrected, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_First(fecCorrected, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByFecCorrected_First(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecCorrected_First(fecCorrected, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_Last(fecCorrected, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByFecCorrected_Last(
		double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFecCorrected_Last(fecCorrected, orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where fecCorrected = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param fecCorrected the fec corrected
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByFecCorrected_PrevAndNext(
		java.lang.String macAddress, double fecCorrected,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFecCorrected_PrevAndNext(macAddress, fecCorrected,
			orderByComparator);
	}

	/**
	* Removes all the cable modems where fecCorrected = &#63; from the database.
	*
	* @param fecCorrected the fec corrected
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFecCorrected(fecCorrected);
	}

	/**
	* Returns the number of cable modems where fecCorrected = &#63;.
	*
	* @param fecCorrected the fec corrected
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFecCorrected(double fecCorrected)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFecCorrected(fecCorrected);
	}

	/**
	* Returns all the cable modems where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsSNR(
		int usSNR) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsSNR(usSNR);
	}

	/**
	* Returns a range of all the cable modems where usSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param usSNR the us s n r
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsSNR(
		int usSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsSNR(usSNR, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where usSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param usSNR the us s n r
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsSNR(
		int usSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsSNR(usSNR, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByUsSNR_First(
		int usSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsSNR_First(usSNR, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByUsSNR_First(
		int usSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsSNR_First(usSNR, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByUsSNR_Last(
		int usSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsSNR_Last(usSNR, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByUsSNR_Last(
		int usSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsSNR_Last(usSNR, orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where usSNR = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param usSNR the us s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByUsSNR_PrevAndNext(
		java.lang.String macAddress, int usSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUsSNR_PrevAndNext(macAddress, usSNR, orderByComparator);
	}

	/**
	* Removes all the cable modems where usSNR = &#63; from the database.
	*
	* @param usSNR the us s n r
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUsSNR(int usSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUsSNR(usSNR);
	}

	/**
	* Returns the number of cable modems where usSNR = &#63;.
	*
	* @param usSNR the us s n r
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUsSNR(int usSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUsSNR(usSNR);
	}

	/**
	* Returns all the cable modems where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsSNR(
		int dsSNR) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsSNR(dsSNR);
	}

	/**
	* Returns a range of all the cable modems where dsSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dsSNR the ds s n r
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsSNR(
		int dsSNR, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsSNR(dsSNR, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where dsSNR = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dsSNR the ds s n r
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsSNR(
		int dsSNR, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsSNR(dsSNR, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByDsSNR_First(
		int dsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsSNR_First(dsSNR, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByDsSNR_First(
		int dsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDsSNR_First(dsSNR, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByDsSNR_Last(
		int dsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsSNR_Last(dsSNR, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByDsSNR_Last(
		int dsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDsSNR_Last(dsSNR, orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where dsSNR = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param dsSNR the ds s n r
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByDsSNR_PrevAndNext(
		java.lang.String macAddress, int dsSNR,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDsSNR_PrevAndNext(macAddress, dsSNR, orderByComparator);
	}

	/**
	* Removes all the cable modems where dsSNR = &#63; from the database.
	*
	* @param dsSNR the ds s n r
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDsSNR(int dsSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDsSNR(dsSNR);
	}

	/**
	* Returns the number of cable modems where dsSNR = &#63;.
	*
	* @param dsSNR the ds s n r
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDsSNR(int dsSNR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDsSNR(dsSNR);
	}

	/**
	* Returns all the cable modems where usPower = &#63;.
	*
	* @param usPower the us power
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsPower(
		int usPower) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsPower(usPower);
	}

	/**
	* Returns a range of all the cable modems where usPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param usPower the us power
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsPower(
		int usPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsPower(usPower, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where usPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param usPower the us power
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByUsPower(
		int usPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUsPower(usPower, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where usPower = &#63;.
	*
	* @param usPower the us power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByUsPower_First(
		int usPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsPower_First(usPower, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where usPower = &#63;.
	*
	* @param usPower the us power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByUsPower_First(
		int usPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsPower_First(usPower, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where usPower = &#63;.
	*
	* @param usPower the us power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByUsPower_Last(
		int usPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsPower_Last(usPower, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where usPower = &#63;.
	*
	* @param usPower the us power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByUsPower_Last(
		int usPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsPower_Last(usPower, orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where usPower = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param usPower the us power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByUsPower_PrevAndNext(
		java.lang.String macAddress, int usPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUsPower_PrevAndNext(macAddress, usPower,
			orderByComparator);
	}

	/**
	* Removes all the cable modems where usPower = &#63; from the database.
	*
	* @param usPower the us power
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUsPower(int usPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUsPower(usPower);
	}

	/**
	* Returns the number of cable modems where usPower = &#63;.
	*
	* @param usPower the us power
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUsPower(int usPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUsPower(usPower);
	}

	/**
	* Returns all the cable modems where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @return the matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsPower(
		int dsPower) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsPower(dsPower);
	}

	/**
	* Returns a range of all the cable modems where dsPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dsPower the ds power
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @return the range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsPower(
		int dsPower, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsPower(dsPower, start, end);
	}

	/**
	* Returns an ordered range of all the cable modems where dsPower = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dsPower the ds power
	* @param start the lower bound of the range of cable modems
	* @param end the upper bound of the range of cable modems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.CableModem> findByDsPower(
		int dsPower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDsPower(dsPower, start, end, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByDsPower_First(
		int dsPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsPower_First(dsPower, orderByComparator);
	}

	/**
	* Returns the first cable modem in the ordered set where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByDsPower_First(
		int dsPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDsPower_First(dsPower, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem findByDsPower_Last(
		int dsPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDsPower_Last(dsPower, orderByComparator);
	}

	/**
	* Returns the last cable modem in the ordered set where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem fetchByDsPower_Last(
		int dsPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDsPower_Last(dsPower, orderByComparator);
	}

	/**
	* Returns the cable modems before and after the current cable modem in the ordered set where dsPower = &#63;.
	*
	* @param macAddress the primary key of the current cable modem
	* @param dsPower the ds power
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cable modem
	* @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.CableModem[] findByDsPower_PrevAndNext(
		java.lang.String macAddress, int dsPower,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCableModemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDsPower_PrevAndNext(macAddress, dsPower,
			orderByComparator);
	}

	/**
	* Removes all the cable modems where dsPower = &#63; from the database.
	*
	* @param dsPower the ds power
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDsPower(int dsPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDsPower(dsPower);
	}

	/**
	* Returns the number of cable modems where dsPower = &#63;.
	*
	* @param dsPower the ds power
	* @return the number of matching cable modems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDsPower(int dsPower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDsPower(dsPower);
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