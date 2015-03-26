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

import com.cmcti.cmts.domain.model.CustomerMacMapping;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the customer mac mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CustomerMacMappingPersistenceImpl
 * @see CustomerMacMappingUtil
 * @generated
 */
public interface CustomerMacMappingPersistence extends BasePersistence<CustomerMacMapping> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerMacMappingUtil} to access the customer mac mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the customer mac mappings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the customer mac mappings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of customer mac mappings
	* @param end the upper bound of the range of customer mac mappings (not inclusive)
	* @return the range of matching customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the customer mac mappings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of customer mac mappings
	* @param end the upper bound of the range of customer mac mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first customer mac mapping in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching customer mac mapping
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first customer mac mapping in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last customer mac mapping in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching customer mac mapping
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last customer mac mapping in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mappings before and after the current customer mac mapping in the ordered set where userId = &#63;.
	*
	* @param customerMacId the primary key of the current customer mac mapping
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next customer mac mapping
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping[] findByUser_PrevAndNext(
		long customerMacId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the customer mac mappings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer mac mappings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mapping where macAddress = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchCustomerMacMappingException} if it could not be found.
	*
	* @param macAddress the mac address
	* @return the matching customer mac mapping
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping findByMacAddress(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mapping where macAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param macAddress the mac address
	* @return the matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchByMacAddress(
		java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mapping where macAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param macAddress the mac address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchByMacAddress(
		java.lang.String macAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the customer mac mapping where macAddress = &#63; from the database.
	*
	* @param macAddress the mac address
	* @return the customer mac mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping removeByMacAddress(
		java.lang.String macAddress)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer mac mappings where macAddress = &#63;.
	*
	* @param macAddress the mac address
	* @return the number of matching customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countByMacAddress(java.lang.String macAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the customer mac mapping in the entity cache if it is enabled.
	*
	* @param customerMacMapping the customer mac mapping
	*/
	public void cacheResult(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping);

	/**
	* Caches the customer mac mappings in the entity cache if it is enabled.
	*
	* @param customerMacMappings the customer mac mappings
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> customerMacMappings);

	/**
	* Creates a new customer mac mapping with the primary key. Does not add the customer mac mapping to the database.
	*
	* @param customerMacId the primary key for the new customer mac mapping
	* @return the new customer mac mapping
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping create(
		long customerMacId);

	/**
	* Removes the customer mac mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customerMacId the primary key of the customer mac mapping
	* @return the customer mac mapping that was removed
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping remove(
		long customerMacId)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.CustomerMacMapping updateImpl(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mapping with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCustomerMacMappingException} if it could not be found.
	*
	* @param customerMacId the primary key of the customer mac mapping
	* @return the customer mac mapping
	* @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping findByPrimaryKey(
		long customerMacId)
		throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer mac mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customerMacId the primary key of the customer mac mapping
	* @return the customer mac mapping, or <code>null</code> if a customer mac mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.CustomerMacMapping fetchByPrimaryKey(
		long customerMacId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the customer mac mappings.
	*
	* @return the customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the customer mac mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customer mac mappings
	* @param end the upper bound of the range of customer mac mappings (not inclusive)
	* @return the range of customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the customer mac mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customer mac mappings
	* @param end the upper bound of the range of customer mac mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.CustomerMacMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the customer mac mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer mac mappings.
	*
	* @return the number of customer mac mappings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}