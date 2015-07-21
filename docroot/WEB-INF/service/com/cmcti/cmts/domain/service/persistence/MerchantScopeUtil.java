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

import com.cmcti.cmts.domain.model.MerchantScope;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the merchant scope service. This utility wraps {@link MerchantScopePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see MerchantScopePersistence
 * @see MerchantScopePersistenceImpl
 * @generated
 */
public class MerchantScopeUtil {
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
	public static void clearCache(MerchantScope merchantScope) {
		getPersistence().clearCache(merchantScope);
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
	public static List<MerchantScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MerchantScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MerchantScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MerchantScope update(MerchantScope merchantScope)
		throws SystemException {
		return getPersistence().update(merchantScope);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MerchantScope update(MerchantScope merchantScope,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(merchantScope, serviceContext);
	}

	/**
	* Returns all the merchant scopes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the merchant scopes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the merchant scopes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the merchant scopes before and after the current merchant scope in the ordered set where userId = &#63;.
	*
	* @param merchantScopeId the primary key of the current merchant scope
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope[] findByUser_PrevAndNext(
		long merchantScopeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(merchantScopeId, userId,
			orderByComparator);
	}

	/**
	* Removes all the merchant scopes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of merchant scopes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the merchant scopes where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByCMTS(
		long cmtsId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId);
	}

	/**
	* Returns a range of all the merchant scopes where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByCMTS(
		long cmtsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId, start, end);
	}

	/**
	* Returns an ordered range of all the merchant scopes where cmtsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByCMTS(
		long cmtsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS(cmtsId, start, end, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByCMTS_First(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCMTS_First(cmtsId, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCMTS_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByCMTS_Last(
		long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCMTS_Last(cmtsId, orderByComparator);
	}

	/**
	* Returns the merchant scopes before and after the current merchant scope in the ordered set where cmtsId = &#63;.
	*
	* @param merchantScopeId the primary key of the current merchant scope
	* @param cmtsId the cmts ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope[] findByCMTS_PrevAndNext(
		long merchantScopeId, long cmtsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCMTS_PrevAndNext(merchantScopeId, cmtsId,
			orderByComparator);
	}

	/**
	* Removes all the merchant scopes where cmtsId = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCMTS(cmtsId);
	}

	/**
	* Returns the number of merchant scopes where cmtsId = &#63;.
	*
	* @param cmtsId the cmts ID
	* @return the number of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCMTS(long cmtsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCMTS(cmtsId);
	}

	/**
	* Returns all the merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUpstreamChannel(
		long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns a range of all the merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUpstreamChannel(
		long cmtsId, int ifIndex, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUpstreamChannel(cmtsId, ifIndex, start, end);
	}

	/**
	* Returns an ordered range of all the merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByUpstreamChannel(
		long cmtsId, int ifIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUpstreamChannel(cmtsId, ifIndex, start, end,
			orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByUpstreamChannel_First(
		long cmtsId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUpstreamChannel_First(cmtsId, ifIndex,
			orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByUpstreamChannel_First(
		long cmtsId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUpstreamChannel_First(cmtsId, ifIndex,
			orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByUpstreamChannel_Last(
		long cmtsId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUpstreamChannel_Last(cmtsId, ifIndex,
			orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByUpstreamChannel_Last(
		long cmtsId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUpstreamChannel_Last(cmtsId, ifIndex,
			orderByComparator);
	}

	/**
	* Returns the merchant scopes before and after the current merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param merchantScopeId the primary key of the current merchant scope
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope[] findByUpstreamChannel_PrevAndNext(
		long merchantScopeId, long cmtsId, int ifIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUpstreamChannel_PrevAndNext(merchantScopeId, cmtsId,
			ifIndex, orderByComparator);
	}

	/**
	* Removes all the merchant scopes where cmtsId = &#63; and ifIndex = &#63; from the database.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUpstreamChannel(long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns the number of merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the number of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUpstreamChannel(long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUpstreamChannel(cmtsId, ifIndex);
	}

	/**
	* Returns all the merchant scopes where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @return the matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByMerchant(
		java.lang.String merchantCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMerchant(merchantCode);
	}

	/**
	* Returns a range of all the merchant scopes where merchantCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param merchantCode the merchant code
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByMerchant(
		java.lang.String merchantCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMerchant(merchantCode, start, end);
	}

	/**
	* Returns an ordered range of all the merchant scopes where merchantCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param merchantCode the merchant code
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findByMerchant(
		java.lang.String merchantCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMerchant(merchantCode, start, end, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByMerchant_First(
		java.lang.String merchantCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMerchant_First(merchantCode, orderByComparator);
	}

	/**
	* Returns the first merchant scope in the ordered set where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByMerchant_First(
		java.lang.String merchantCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMerchant_First(merchantCode, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByMerchant_Last(
		java.lang.String merchantCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMerchant_Last(merchantCode, orderByComparator);
	}

	/**
	* Returns the last merchant scope in the ordered set where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByMerchant_Last(
		java.lang.String merchantCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMerchant_Last(merchantCode, orderByComparator);
	}

	/**
	* Returns the merchant scopes before and after the current merchant scope in the ordered set where merchantCode = &#63;.
	*
	* @param merchantScopeId the primary key of the current merchant scope
	* @param merchantCode the merchant code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope[] findByMerchant_PrevAndNext(
		long merchantScopeId, java.lang.String merchantCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMerchant_PrevAndNext(merchantScopeId, merchantCode,
			orderByComparator);
	}

	/**
	* Removes all the merchant scopes where merchantCode = &#63; from the database.
	*
	* @param merchantCode the merchant code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMerchant(java.lang.String merchantCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMerchant(merchantCode);
	}

	/**
	* Returns the number of merchant scopes where merchantCode = &#63;.
	*
	* @param merchantCode the merchant code
	* @return the number of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMerchant(java.lang.String merchantCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMerchant(merchantCode);
	}

	/**
	* Returns the merchant scope where merchantCode = &#63; and cmtsId = &#63; and ifIndex = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantScopeException} if it could not be found.
	*
	* @param merchantCode the merchant code
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByC_I_M(
		java.lang.String merchantCode, long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_I_M(merchantCode, cmtsId, ifIndex);
	}

	/**
	* Returns the merchant scope where merchantCode = &#63; and cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param merchantCode the merchant code
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByC_I_M(
		java.lang.String merchantCode, long cmtsId, int ifIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_I_M(merchantCode, cmtsId, ifIndex);
	}

	/**
	* Returns the merchant scope where merchantCode = &#63; and cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param merchantCode the merchant code
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByC_I_M(
		java.lang.String merchantCode, long cmtsId, int ifIndex,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_I_M(merchantCode, cmtsId, ifIndex,
			retrieveFromCache);
	}

	/**
	* Removes the merchant scope where merchantCode = &#63; and cmtsId = &#63; and ifIndex = &#63; from the database.
	*
	* @param merchantCode the merchant code
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the merchant scope that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope removeByC_I_M(
		java.lang.String merchantCode, long cmtsId, int ifIndex)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByC_I_M(merchantCode, cmtsId, ifIndex);
	}

	/**
	* Returns the number of merchant scopes where merchantCode = &#63; and cmtsId = &#63; and ifIndex = &#63;.
	*
	* @param merchantCode the merchant code
	* @param cmtsId the cmts ID
	* @param ifIndex the if index
	* @return the number of matching merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_I_M(java.lang.String merchantCode, long cmtsId,
		int ifIndex) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_I_M(merchantCode, cmtsId, ifIndex);
	}

	/**
	* Caches the merchant scope in the entity cache if it is enabled.
	*
	* @param merchantScope the merchant scope
	*/
	public static void cacheResult(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope) {
		getPersistence().cacheResult(merchantScope);
	}

	/**
	* Caches the merchant scopes in the entity cache if it is enabled.
	*
	* @param merchantScopes the merchant scopes
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.MerchantScope> merchantScopes) {
		getPersistence().cacheResult(merchantScopes);
	}

	/**
	* Creates a new merchant scope with the primary key. Does not add the merchant scope to the database.
	*
	* @param merchantScopeId the primary key for the new merchant scope
	* @return the new merchant scope
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope create(
		long merchantScopeId) {
		return getPersistence().create(merchantScopeId);
	}

	/**
	* Removes the merchant scope with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param merchantScopeId the primary key of the merchant scope
	* @return the merchant scope that was removed
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope remove(
		long merchantScopeId)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(merchantScopeId);
	}

	public static com.cmcti.cmts.domain.model.MerchantScope updateImpl(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(merchantScope);
	}

	/**
	* Returns the merchant scope with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantScopeException} if it could not be found.
	*
	* @param merchantScopeId the primary key of the merchant scope
	* @return the merchant scope
	* @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope findByPrimaryKey(
		long merchantScopeId)
		throws com.cmcti.cmts.domain.NoSuchMerchantScopeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(merchantScopeId);
	}

	/**
	* Returns the merchant scope with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param merchantScopeId the primary key of the merchant scope
	* @return the merchant scope, or <code>null</code> if a merchant scope with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.MerchantScope fetchByPrimaryKey(
		long merchantScopeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(merchantScopeId);
	}

	/**
	* Returns all the merchant scopes.
	*
	* @return the merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the merchant scopes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @return the range of merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the merchant scopes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchant scopes
	* @param end the upper bound of the range of merchant scopes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.MerchantScope> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the merchant scopes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of merchant scopes.
	*
	* @return the number of merchant scopes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MerchantScopePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MerchantScopePersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					MerchantScopePersistence.class.getName());

			ReferenceRegistry.registerReference(MerchantScopeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MerchantScopePersistence persistence) {
	}

	private static MerchantScopePersistence _persistence;
}