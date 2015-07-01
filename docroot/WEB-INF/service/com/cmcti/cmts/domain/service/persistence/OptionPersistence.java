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

import com.cmcti.cmts.domain.model.Option;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see OptionPersistenceImpl
 * @see OptionUtil
 * @generated
 */
public interface OptionPersistence extends BasePersistence<Option> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OptionUtil} to access the option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the options where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the options where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @return the range of matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the options where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the options before and after the current option in the ordered set where userId = &#63;.
	*
	* @param optionId the primary key of the current option
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option[] findByUser_PrevAndNext(
		long optionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the options where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of options where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the options where optionType = &#63;.
	*
	* @param optionType the option type
	* @return the matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the options where optionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optionType the option type
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @return the range of matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the options where optionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optionType the option type
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByType_First(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByType_First(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByType_Last(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByType_Last(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the options before and after the current option in the ordered set where optionType = &#63;.
	*
	* @param optionId the primary key of the current option
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option[] findByType_PrevAndNext(
		long optionId, java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the options where optionType = &#63; from the database.
	*
	* @param optionType the option type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of options where optionType = &#63;.
	*
	* @param optionType the option type
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByT_K(
		java.lang.String optionType, java.lang.String optionKey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the option where optionType = &#63; and optionKey = &#63; from the database.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option removeByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of options where optionType = &#63; and optionKey = &#63;.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_K(java.lang.String optionType,
		java.lang.String optionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the option in the entity cache if it is enabled.
	*
	* @param option the option
	*/
	public void cacheResult(com.cmcti.cmts.domain.model.Option option);

	/**
	* Caches the options in the entity cache if it is enabled.
	*
	* @param options the options
	*/
	public void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.Option> options);

	/**
	* Creates a new option with the primary key. Does not add the option to the database.
	*
	* @param optionId the primary key for the new option
	* @return the new option
	*/
	public com.cmcti.cmts.domain.model.Option create(long optionId);

	/**
	* Removes the option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param optionId the primary key of the option
	* @return the option that was removed
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option remove(long optionId)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmcti.cmts.domain.model.Option updateImpl(
		com.cmcti.cmts.domain.model.Option option)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the option with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	*
	* @param optionId the primary key of the option
	* @return the option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option findByPrimaryKey(long optionId)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param optionId the primary key of the option
	* @return the option, or <code>null</code> if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmcti.cmts.domain.model.Option fetchByPrimaryKey(long optionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the options.
	*
	* @return the options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @return the range of options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.OptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of options
	* @param end the upper bound of the range of options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmcti.cmts.domain.model.Option> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of options.
	*
	* @return the number of options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}