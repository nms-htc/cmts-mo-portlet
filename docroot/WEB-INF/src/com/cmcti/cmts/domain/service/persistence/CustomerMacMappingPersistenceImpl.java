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

import com.cmcti.cmts.domain.NoSuchCustomerMacMappingException;
import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.model.impl.CustomerMacMappingImpl;
import com.cmcti.cmts.domain.model.impl.CustomerMacMappingModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the customer mac mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CustomerMacMappingPersistence
 * @see CustomerMacMappingUtil
 * @generated
 */
public class CustomerMacMappingPersistenceImpl extends BasePersistenceImpl<CustomerMacMapping>
	implements CustomerMacMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CustomerMacMappingUtil} to access the customer mac mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CustomerMacMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED,
			CustomerMacMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED,
			CustomerMacMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED,
			CustomerMacMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED,
			CustomerMacMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			CustomerMacMappingModelImpl.USERID_COLUMN_BITMASK |
			CustomerMacMappingModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the customer mac mappings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching customer mac mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerMacMapping> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CustomerMacMapping> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

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
	@Override
	public List<CustomerMacMapping> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<CustomerMacMapping> list = (List<CustomerMacMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CustomerMacMapping customerMacMapping : list) {
				if ((userId != customerMacMapping.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CUSTOMERMACMAPPING_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CustomerMacMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<CustomerMacMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CustomerMacMapping>(list);
				}
				else {
					list = (List<CustomerMacMapping>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first customer mac mapping in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer mac mapping
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = fetchByUser_First(userId,
				orderByComparator);

		if (customerMacMapping != null) {
			return customerMacMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCustomerMacMappingException(msg.toString());
	}

	/**
	 * Returns the first customer mac mapping in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CustomerMacMapping> list = findByUser(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer mac mapping in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer mac mapping
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = fetchByUser_Last(userId,
				orderByComparator);

		if (customerMacMapping != null) {
			return customerMacMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCustomerMacMappingException(msg.toString());
	}

	/**
	 * Returns the last customer mac mapping in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<CustomerMacMapping> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CustomerMacMapping[] findByUser_PrevAndNext(long customerMacId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = findByPrimaryKey(customerMacId);

		Session session = null;

		try {
			session = openSession();

			CustomerMacMapping[] array = new CustomerMacMappingImpl[3];

			array[0] = getByUser_PrevAndNext(session, customerMacMapping,
					userId, orderByComparator, true);

			array[1] = customerMacMapping;

			array[2] = getByUser_PrevAndNext(session, customerMacMapping,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomerMacMapping getByUser_PrevAndNext(Session session,
		CustomerMacMapping customerMacMapping, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CUSTOMERMACMAPPING_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CustomerMacMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(customerMacMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CustomerMacMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer mac mappings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (CustomerMacMapping customerMacMapping : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(customerMacMapping);
		}
	}

	/**
	 * Returns the number of customer mac mappings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching customer mac mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMERMACMAPPING_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 = "customerMacMapping.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MACADDRESS = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED,
			CustomerMacMappingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMacAddress", new String[] { String.class.getName() },
			CustomerMacMappingModelImpl.MACADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MACADDRESS = new FinderPath(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMacAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns the customer mac mapping where macAddress = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchCustomerMacMappingException} if it could not be found.
	 *
	 * @param macAddress the mac address
	 * @return the matching customer mac mapping
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping findByMacAddress(String macAddress)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = fetchByMacAddress(macAddress);

		if (customerMacMapping == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("macAddress=");
			msg.append(macAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCustomerMacMappingException(msg.toString());
		}

		return customerMacMapping;
	}

	/**
	 * Returns the customer mac mapping where macAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param macAddress the mac address
	 * @return the matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByMacAddress(String macAddress)
		throws SystemException {
		return fetchByMacAddress(macAddress, true);
	}

	/**
	 * Returns the customer mac mapping where macAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param macAddress the mac address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching customer mac mapping, or <code>null</code> if a matching customer mac mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByMacAddress(String macAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { macAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MACADDRESS,
					finderArgs, this);
		}

		if (result instanceof CustomerMacMapping) {
			CustomerMacMapping customerMacMapping = (CustomerMacMapping)result;

			if (!Validator.equals(macAddress, customerMacMapping.getMacAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CUSTOMERMACMAPPING_WHERE);

			boolean bindMacAddress = false;

			if (macAddress == null) {
				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_1);
			}
			else if (macAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_3);
			}
			else {
				bindMacAddress = true;

				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMacAddress) {
					qPos.add(macAddress);
				}

				List<CustomerMacMapping> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MACADDRESS,
						finderArgs, list);
				}
				else {
					CustomerMacMapping customerMacMapping = list.get(0);

					result = customerMacMapping;

					cacheResult(customerMacMapping);

					if ((customerMacMapping.getMacAddress() == null) ||
							!customerMacMapping.getMacAddress()
												   .equals(macAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MACADDRESS,
							finderArgs, customerMacMapping);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MACADDRESS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CustomerMacMapping)result;
		}
	}

	/**
	 * Removes the customer mac mapping where macAddress = &#63; from the database.
	 *
	 * @param macAddress the mac address
	 * @return the customer mac mapping that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping removeByMacAddress(String macAddress)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = findByMacAddress(macAddress);

		return remove(customerMacMapping);
	}

	/**
	 * Returns the number of customer mac mappings where macAddress = &#63;.
	 *
	 * @param macAddress the mac address
	 * @return the number of matching customer mac mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMacAddress(String macAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MACADDRESS;

		Object[] finderArgs = new Object[] { macAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMERMACMAPPING_WHERE);

			boolean bindMacAddress = false;

			if (macAddress == null) {
				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_1);
			}
			else if (macAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_3);
			}
			else {
				bindMacAddress = true;

				query.append(_FINDER_COLUMN_MACADDRESS_MACADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMacAddress) {
					qPos.add(macAddress);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MACADDRESS_MACADDRESS_1 = "customerMacMapping.macAddress IS NULL";
	private static final String _FINDER_COLUMN_MACADDRESS_MACADDRESS_2 = "customerMacMapping.macAddress = ?";
	private static final String _FINDER_COLUMN_MACADDRESS_MACADDRESS_3 = "(customerMacMapping.macAddress IS NULL OR customerMacMapping.macAddress = '')";

	public CustomerMacMappingPersistenceImpl() {
		setModelClass(CustomerMacMapping.class);
	}

	/**
	 * Caches the customer mac mapping in the entity cache if it is enabled.
	 *
	 * @param customerMacMapping the customer mac mapping
	 */
	@Override
	public void cacheResult(CustomerMacMapping customerMacMapping) {
		EntityCacheUtil.putResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingImpl.class, customerMacMapping.getPrimaryKey(),
			customerMacMapping);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MACADDRESS,
			new Object[] { customerMacMapping.getMacAddress() },
			customerMacMapping);

		customerMacMapping.resetOriginalValues();
	}

	/**
	 * Caches the customer mac mappings in the entity cache if it is enabled.
	 *
	 * @param customerMacMappings the customer mac mappings
	 */
	@Override
	public void cacheResult(List<CustomerMacMapping> customerMacMappings) {
		for (CustomerMacMapping customerMacMapping : customerMacMappings) {
			if (EntityCacheUtil.getResult(
						CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
						CustomerMacMappingImpl.class,
						customerMacMapping.getPrimaryKey()) == null) {
				cacheResult(customerMacMapping);
			}
			else {
				customerMacMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all customer mac mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CustomerMacMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CustomerMacMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer mac mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomerMacMapping customerMacMapping) {
		EntityCacheUtil.removeResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingImpl.class, customerMacMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(customerMacMapping);
	}

	@Override
	public void clearCache(List<CustomerMacMapping> customerMacMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomerMacMapping customerMacMapping : customerMacMappings) {
			EntityCacheUtil.removeResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
				CustomerMacMappingImpl.class, customerMacMapping.getPrimaryKey());

			clearUniqueFindersCache(customerMacMapping);
		}
	}

	protected void cacheUniqueFindersCache(
		CustomerMacMapping customerMacMapping) {
		if (customerMacMapping.isNew()) {
			Object[] args = new Object[] { customerMacMapping.getMacAddress() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACADDRESS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MACADDRESS, args,
				customerMacMapping);
		}
		else {
			CustomerMacMappingModelImpl customerMacMappingModelImpl = (CustomerMacMappingModelImpl)customerMacMapping;

			if ((customerMacMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MACADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { customerMacMapping.getMacAddress() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MACADDRESS,
					args, customerMacMapping);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CustomerMacMapping customerMacMapping) {
		CustomerMacMappingModelImpl customerMacMappingModelImpl = (CustomerMacMappingModelImpl)customerMacMapping;

		Object[] args = new Object[] { customerMacMapping.getMacAddress() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MACADDRESS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MACADDRESS, args);

		if ((customerMacMappingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MACADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] {
					customerMacMappingModelImpl.getOriginalMacAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MACADDRESS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MACADDRESS, args);
		}
	}

	/**
	 * Creates a new customer mac mapping with the primary key. Does not add the customer mac mapping to the database.
	 *
	 * @param customerMacId the primary key for the new customer mac mapping
	 * @return the new customer mac mapping
	 */
	@Override
	public CustomerMacMapping create(long customerMacId) {
		CustomerMacMapping customerMacMapping = new CustomerMacMappingImpl();

		customerMacMapping.setNew(true);
		customerMacMapping.setPrimaryKey(customerMacId);

		return customerMacMapping;
	}

	/**
	 * Removes the customer mac mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerMacId the primary key of the customer mac mapping
	 * @return the customer mac mapping that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping remove(long customerMacId)
		throws NoSuchCustomerMacMappingException, SystemException {
		return remove((Serializable)customerMacId);
	}

	/**
	 * Removes the customer mac mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer mac mapping
	 * @return the customer mac mapping that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping remove(Serializable primaryKey)
		throws NoSuchCustomerMacMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CustomerMacMapping customerMacMapping = (CustomerMacMapping)session.get(CustomerMacMappingImpl.class,
					primaryKey);

			if (customerMacMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerMacMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customerMacMapping);
		}
		catch (NoSuchCustomerMacMappingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CustomerMacMapping removeImpl(
		CustomerMacMapping customerMacMapping) throws SystemException {
		customerMacMapping = toUnwrappedModel(customerMacMapping);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customerMacMapping)) {
				customerMacMapping = (CustomerMacMapping)session.get(CustomerMacMappingImpl.class,
						customerMacMapping.getPrimaryKeyObj());
			}

			if (customerMacMapping != null) {
				session.delete(customerMacMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (customerMacMapping != null) {
			clearCache(customerMacMapping);
		}

		return customerMacMapping;
	}

	@Override
	public CustomerMacMapping updateImpl(
		com.cmcti.cmts.domain.model.CustomerMacMapping customerMacMapping)
		throws SystemException {
		customerMacMapping = toUnwrappedModel(customerMacMapping);

		boolean isNew = customerMacMapping.isNew();

		CustomerMacMappingModelImpl customerMacMappingModelImpl = (CustomerMacMappingModelImpl)customerMacMapping;

		Session session = null;

		try {
			session = openSession();

			if (customerMacMapping.isNew()) {
				session.save(customerMacMapping);

				customerMacMapping.setNew(false);
			}
			else {
				session.merge(customerMacMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CustomerMacMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((customerMacMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						customerMacMappingModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { customerMacMappingModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
			CustomerMacMappingImpl.class, customerMacMapping.getPrimaryKey(),
			customerMacMapping);

		clearUniqueFindersCache(customerMacMapping);
		cacheUniqueFindersCache(customerMacMapping);

		return customerMacMapping;
	}

	protected CustomerMacMapping toUnwrappedModel(
		CustomerMacMapping customerMacMapping) {
		if (customerMacMapping instanceof CustomerMacMappingImpl) {
			return customerMacMapping;
		}

		CustomerMacMappingImpl customerMacMappingImpl = new CustomerMacMappingImpl();

		customerMacMappingImpl.setNew(customerMacMapping.isNew());
		customerMacMappingImpl.setPrimaryKey(customerMacMapping.getPrimaryKey());

		customerMacMappingImpl.setCustomerMacId(customerMacMapping.getCustomerMacId());
		customerMacMappingImpl.setGroupId(customerMacMapping.getGroupId());
		customerMacMappingImpl.setCompanyId(customerMacMapping.getCompanyId());
		customerMacMappingImpl.setUserId(customerMacMapping.getUserId());
		customerMacMappingImpl.setCreateDate(customerMacMapping.getCreateDate());
		customerMacMappingImpl.setModifiedDate(customerMacMapping.getModifiedDate());
		customerMacMappingImpl.setTitle(customerMacMapping.getTitle());
		customerMacMappingImpl.setMacAddress(customerMacMapping.getMacAddress());

		return customerMacMappingImpl;
	}

	/**
	 * Returns the customer mac mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer mac mapping
	 * @return the customer mac mapping
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerMacMappingException, SystemException {
		CustomerMacMapping customerMacMapping = fetchByPrimaryKey(primaryKey);

		if (customerMacMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerMacMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return customerMacMapping;
	}

	/**
	 * Returns the customer mac mapping with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCustomerMacMappingException} if it could not be found.
	 *
	 * @param customerMacId the primary key of the customer mac mapping
	 * @return the customer mac mapping
	 * @throws com.cmcti.cmts.domain.NoSuchCustomerMacMappingException if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping findByPrimaryKey(long customerMacId)
		throws NoSuchCustomerMacMappingException, SystemException {
		return findByPrimaryKey((Serializable)customerMacId);
	}

	/**
	 * Returns the customer mac mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer mac mapping
	 * @return the customer mac mapping, or <code>null</code> if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CustomerMacMapping customerMacMapping = (CustomerMacMapping)EntityCacheUtil.getResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
				CustomerMacMappingImpl.class, primaryKey);

		if (customerMacMapping == _nullCustomerMacMapping) {
			return null;
		}

		if (customerMacMapping == null) {
			Session session = null;

			try {
				session = openSession();

				customerMacMapping = (CustomerMacMapping)session.get(CustomerMacMappingImpl.class,
						primaryKey);

				if (customerMacMapping != null) {
					cacheResult(customerMacMapping);
				}
				else {
					EntityCacheUtil.putResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
						CustomerMacMappingImpl.class, primaryKey,
						_nullCustomerMacMapping);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CustomerMacMappingModelImpl.ENTITY_CACHE_ENABLED,
					CustomerMacMappingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return customerMacMapping;
	}

	/**
	 * Returns the customer mac mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerMacId the primary key of the customer mac mapping
	 * @return the customer mac mapping, or <code>null</code> if a customer mac mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerMacMapping fetchByPrimaryKey(long customerMacId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)customerMacId);
	}

	/**
	 * Returns all the customer mac mappings.
	 *
	 * @return the customer mac mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerMacMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CustomerMacMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CustomerMacMapping> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CustomerMacMapping> list = (List<CustomerMacMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CUSTOMERMACMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERMACMAPPING;

				if (pagination) {
					sql = sql.concat(CustomerMacMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CustomerMacMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CustomerMacMapping>(list);
				}
				else {
					list = (List<CustomerMacMapping>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the customer mac mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CustomerMacMapping customerMacMapping : findAll()) {
			remove(customerMacMapping);
		}
	}

	/**
	 * Returns the number of customer mac mappings.
	 *
	 * @return the number of customer mac mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMERMACMAPPING);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the customer mac mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.CustomerMacMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CustomerMacMapping>> listenersList = new ArrayList<ModelListener<CustomerMacMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CustomerMacMapping>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CustomerMacMappingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CUSTOMERMACMAPPING = "SELECT customerMacMapping FROM CustomerMacMapping customerMacMapping";
	private static final String _SQL_SELECT_CUSTOMERMACMAPPING_WHERE = "SELECT customerMacMapping FROM CustomerMacMapping customerMacMapping WHERE ";
	private static final String _SQL_COUNT_CUSTOMERMACMAPPING = "SELECT COUNT(customerMacMapping) FROM CustomerMacMapping customerMacMapping";
	private static final String _SQL_COUNT_CUSTOMERMACMAPPING_WHERE = "SELECT COUNT(customerMacMapping) FROM CustomerMacMapping customerMacMapping WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customerMacMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CustomerMacMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CustomerMacMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CustomerMacMappingPersistenceImpl.class);
	private static CustomerMacMapping _nullCustomerMacMapping = new CustomerMacMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CustomerMacMapping> toCacheModel() {
				return _nullCustomerMacMappingCacheModel;
			}
		};

	private static CacheModel<CustomerMacMapping> _nullCustomerMacMappingCacheModel =
		new CacheModel<CustomerMacMapping>() {
			@Override
			public CustomerMacMapping toEntityModel() {
				return _nullCustomerMacMapping;
			}
		};
}