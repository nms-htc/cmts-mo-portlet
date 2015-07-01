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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the option service. This utility wraps {@link OptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see OptionPersistence
 * @see OptionPersistenceImpl
 * @generated
 */
public class OptionUtil {
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
	public static void clearCache(Option option) {
		getPersistence().clearCache(option);
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
	public static List<Option> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Option> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Option> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Option update(Option option) throws SystemException {
		return getPersistence().update(option);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Option update(Option option, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(option, serviceContext);
	}

	/**
	* Returns all the options where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last option in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.Option[] findByUser_PrevAndNext(
		long optionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(optionId, userId, orderByComparator);
	}

	/**
	* Removes all the options where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of options where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the options where optionType = &#63;.
	*
	* @param optionType the option type
	* @return the matching options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(optionType);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(optionType, start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findByType(
		java.lang.String optionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(optionType, start, end, orderByComparator);
	}

	/**
	* Returns the first option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByType_First(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_First(optionType, orderByComparator);
	}

	/**
	* Returns the first option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByType_First(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(optionType, orderByComparator);
	}

	/**
	* Returns the last option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByType_Last(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_Last(optionType, orderByComparator);
	}

	/**
	* Returns the last option in the ordered set where optionType = &#63;.
	*
	* @param optionType the option type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByType_Last(
		java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(optionType, orderByComparator);
	}

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
	public static com.cmcti.cmts.domain.model.Option[] findByType_PrevAndNext(
		long optionId, java.lang.String optionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(optionId, optionType,
			orderByComparator);
	}

	/**
	* Removes all the options where optionType = &#63; from the database.
	*
	* @param optionType the option type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(optionType);
	}

	/**
	* Returns the number of options where optionType = &#63;.
	*
	* @param optionType the option type
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String optionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(optionType);
	}

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the matching option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_K(optionType, optionKey);
	}

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByT_K(optionType, optionKey);
	}

	/**
	* Returns the option where optionType = &#63; and optionKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching option, or <code>null</code> if a matching option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByT_K(
		java.lang.String optionType, java.lang.String optionKey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_K(optionType, optionKey, retrieveFromCache);
	}

	/**
	* Removes the option where optionType = &#63; and optionKey = &#63; from the database.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option removeByT_K(
		java.lang.String optionType, java.lang.String optionKey)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByT_K(optionType, optionKey);
	}

	/**
	* Returns the number of options where optionType = &#63; and optionKey = &#63;.
	*
	* @param optionType the option type
	* @param optionKey the option key
	* @return the number of matching options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_K(java.lang.String optionType,
		java.lang.String optionKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_K(optionType, optionKey);
	}

	/**
	* Caches the option in the entity cache if it is enabled.
	*
	* @param option the option
	*/
	public static void cacheResult(com.cmcti.cmts.domain.model.Option option) {
		getPersistence().cacheResult(option);
	}

	/**
	* Caches the options in the entity cache if it is enabled.
	*
	* @param options the options
	*/
	public static void cacheResult(
		java.util.List<com.cmcti.cmts.domain.model.Option> options) {
		getPersistence().cacheResult(options);
	}

	/**
	* Creates a new option with the primary key. Does not add the option to the database.
	*
	* @param optionId the primary key for the new option
	* @return the new option
	*/
	public static com.cmcti.cmts.domain.model.Option create(long optionId) {
		return getPersistence().create(optionId);
	}

	/**
	* Removes the option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param optionId the primary key of the option
	* @return the option that was removed
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option remove(long optionId)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(optionId);
	}

	public static com.cmcti.cmts.domain.model.Option updateImpl(
		com.cmcti.cmts.domain.model.Option option)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(option);
	}

	/**
	* Returns the option with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	*
	* @param optionId the primary key of the option
	* @return the option
	* @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option findByPrimaryKey(
		long optionId)
		throws com.cmcti.cmts.domain.NoSuchOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(optionId);
	}

	/**
	* Returns the option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param optionId the primary key of the option
	* @return the option, or <code>null</code> if a option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmcti.cmts.domain.model.Option fetchByPrimaryKey(
		long optionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(optionId);
	}

	/**
	* Returns all the options.
	*
	* @return the options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmcti.cmts.domain.model.Option> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of options.
	*
	* @return the number of options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OptionPersistence)PortletBeanLocatorUtil.locate(com.cmcti.cmts.domain.service.ClpSerializer.getServletContextName(),
					OptionPersistence.class.getName());

			ReferenceRegistry.registerReference(OptionUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OptionPersistence persistence) {
	}

	private static OptionPersistence _persistence;
}