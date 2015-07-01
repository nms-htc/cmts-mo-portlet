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

import com.cmcti.cmts.domain.model.Merchant;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the merchant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see MerchantPersistenceImpl
 * @see MerchantUtil
 * @generated
 */
public interface MerchantPersistence extends BasePersistence<Merchant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MerchantUtil} to access the merchant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the merchants where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the merchants where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of merchants
	* @param end the upper bound of the range of merchants (not inclusive)
	* @return the range of matching merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the merchants where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of merchants
	* @param end the upper bound of the range of merchants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first merchant in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first merchant in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching merchant, or <code>null</code> if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last merchant in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last merchant in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching merchant, or <code>null</code> if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchants before and after the current merchant in the ordered set where userId = &#63;.
	*
	* @param merchantId the primary key of the current merchant
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next merchant
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant[] findByUser_PrevAndNext(
		long merchantId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the merchants where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of merchants where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching merchants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchant where code = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantException} if it could not be found.
	*
	* @param code the code
	* @return the matching merchant
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant findByCode(
		java.lang.String code)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchant where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching merchant, or <code>null</code> if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchant where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching merchant, or <code>null</code> if a matching merchant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the merchant where code = &#63; from the database.
	*
	* @param code the code
	* @return the merchant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant removeByCode(
		java.lang.String code)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of merchants where code = &#63;.
	*
	* @param code the code
	* @return the number of matching merchants
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the merchant in the entity cache if it is enabled.
	*
	* @param merchant the merchant
	*/
	public void cacheResult(com.cmcti.cmts.domain.model.Merchant merchant);

	/**
	* Caches the merchants in the entity cache if it is enabled.
	*
	* @param merchants the merchants
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.Merchant> merchants);

	/**
	* Creates a new merchant with the primary key. Does not add the merchant to the database.
	*
	* @param merchantId the primary key for the new merchant
	* @return the new merchant
	*/
	public com.cmcti.cmts.domain.model.Merchant create(long merchantId);

	/**
	* Removes the merchant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param merchantId the primary key of the merchant
	* @return the merchant that was removed
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant remove(long merchantId)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.Merchant updateImpl(
		com.cmcti.cmts.domain.model.Merchant merchant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchant with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantException} if it could not be found.
	*
	* @param merchantId the primary key of the merchant
	* @return the merchant
	* @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant findByPrimaryKey(
		long merchantId)
		throws com.cmcti.cmts.domain.NoSuchMerchantException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the merchant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param merchantId the primary key of the merchant
	* @return the merchant, or <code>null</code> if a merchant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Merchant fetchByPrimaryKey(
		long merchantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the merchants.
	*
	* @return the merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the merchants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchants
	* @param end the upper bound of the range of merchants (not inclusive)
	* @return the range of merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the merchants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.MerchantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of merchants
	* @param end the upper bound of the range of merchants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of merchants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Merchant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the merchants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of merchants.
	*
	* @return the number of merchants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}