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

import com.cmcti.cmts.domain.NoSuchMerchantException;
import com.cmcti.cmts.domain.model.Merchant;
import com.cmcti.cmts.domain.model.impl.MerchantImpl;
import com.cmcti.cmts.domain.model.impl.MerchantModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the merchant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see MerchantPersistence
 * @see MerchantUtil
 * @generated
 */
public class MerchantPersistenceImpl extends BasePersistenceImpl<Merchant>
	implements MerchantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MerchantUtil} to access the merchant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MerchantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, MerchantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, MerchantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, MerchantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, MerchantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			MerchantModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the merchants where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching merchants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Merchant> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Merchant> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

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
	@Override
	public List<Merchant> findByUser(long userId, int start, int end,
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

		List<Merchant> list = (List<Merchant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Merchant merchant : list) {
				if ((userId != merchant.getUserId())) {
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

			query.append(_SQL_SELECT_MERCHANT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MerchantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Merchant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Merchant>(list);
				}
				else {
					list = (List<Merchant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first merchant in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = fetchByUser_First(userId, orderByComparator);

		if (merchant != null) {
			return merchant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantException(msg.toString());
	}

	/**
	 * Returns the first merchant in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant, or <code>null</code> if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Merchant> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last merchant in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching merchant
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = fetchByUser_Last(userId, orderByComparator);

		if (merchant != null) {
			return merchant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantException(msg.toString());
	}

	/**
	 * Returns the last merchant in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching merchant, or <code>null</code> if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Merchant> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Merchant[] findByUser_PrevAndNext(long merchantId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = findByPrimaryKey(merchantId);

		Session session = null;

		try {
			session = openSession();

			Merchant[] array = new MerchantImpl[3];

			array[0] = getByUser_PrevAndNext(session, merchant, userId,
					orderByComparator, true);

			array[1] = merchant;

			array[2] = getByUser_PrevAndNext(session, merchant, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Merchant getByUser_PrevAndNext(Session session,
		Merchant merchant, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MERCHANT_WHERE);

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
			query.append(MerchantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(merchant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Merchant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the merchants where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Merchant merchant : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(merchant);
		}
	}

	/**
	 * Returns the number of merchants where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching merchants
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

			query.append(_SQL_COUNT_MERCHANT_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "merchant.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, MerchantImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			MerchantModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the merchant where code = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching merchant
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant findByCode(String code)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = fetchByCode(code);

		if (merchant == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMerchantException(msg.toString());
		}

		return merchant;
	}

	/**
	 * Returns the merchant where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching merchant, or <code>null</code> if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the merchant where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching merchant, or <code>null</code> if a matching merchant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof Merchant) {
			Merchant merchant = (Merchant)result;

			if (!Validator.equals(code, merchant.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MERCHANT_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<Merchant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MerchantPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Merchant merchant = list.get(0);

					result = merchant;

					cacheResult(merchant);

					if ((merchant.getCode() == null) ||
							!merchant.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, merchant);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (Merchant)result;
		}
	}

	/**
	 * Removes the merchant where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the merchant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant removeByCode(String code)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = findByCode(code);

		return remove(merchant);
	}

	/**
	 * Returns the number of merchants where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching merchants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MERCHANT_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "merchant.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "merchant.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(merchant.code IS NULL OR merchant.code = '')";

	public MerchantPersistenceImpl() {
		setModelClass(Merchant.class);
	}

	/**
	 * Caches the merchant in the entity cache if it is enabled.
	 *
	 * @param merchant the merchant
	 */
	@Override
	public void cacheResult(Merchant merchant) {
		EntityCacheUtil.putResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantImpl.class, merchant.getPrimaryKey(), merchant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { merchant.getCode() }, merchant);

		merchant.resetOriginalValues();
	}

	/**
	 * Caches the merchants in the entity cache if it is enabled.
	 *
	 * @param merchants the merchants
	 */
	@Override
	public void cacheResult(List<Merchant> merchants) {
		for (Merchant merchant : merchants) {
			if (EntityCacheUtil.getResult(
						MerchantModelImpl.ENTITY_CACHE_ENABLED,
						MerchantImpl.class, merchant.getPrimaryKey()) == null) {
				cacheResult(merchant);
			}
			else {
				merchant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all merchants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MerchantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MerchantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the merchant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Merchant merchant) {
		EntityCacheUtil.removeResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantImpl.class, merchant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(merchant);
	}

	@Override
	public void clearCache(List<Merchant> merchants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Merchant merchant : merchants) {
			EntityCacheUtil.removeResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
				MerchantImpl.class, merchant.getPrimaryKey());

			clearUniqueFindersCache(merchant);
		}
	}

	protected void cacheUniqueFindersCache(Merchant merchant) {
		if (merchant.isNew()) {
			Object[] args = new Object[] { merchant.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args, merchant);
		}
		else {
			MerchantModelImpl merchantModelImpl = (MerchantModelImpl)merchant;

			if ((merchantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { merchant.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					merchant);
			}
		}
	}

	protected void clearUniqueFindersCache(Merchant merchant) {
		MerchantModelImpl merchantModelImpl = (MerchantModelImpl)merchant;

		Object[] args = new Object[] { merchant.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((merchantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { merchantModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new merchant with the primary key. Does not add the merchant to the database.
	 *
	 * @param merchantId the primary key for the new merchant
	 * @return the new merchant
	 */
	@Override
	public Merchant create(long merchantId) {
		Merchant merchant = new MerchantImpl();

		merchant.setNew(true);
		merchant.setPrimaryKey(merchantId);

		return merchant;
	}

	/**
	 * Removes the merchant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param merchantId the primary key of the merchant
	 * @return the merchant that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant remove(long merchantId)
		throws NoSuchMerchantException, SystemException {
		return remove((Serializable)merchantId);
	}

	/**
	 * Removes the merchant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the merchant
	 * @return the merchant that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant remove(Serializable primaryKey)
		throws NoSuchMerchantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Merchant merchant = (Merchant)session.get(MerchantImpl.class,
					primaryKey);

			if (merchant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMerchantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(merchant);
		}
		catch (NoSuchMerchantException nsee) {
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
	protected Merchant removeImpl(Merchant merchant) throws SystemException {
		merchant = toUnwrappedModel(merchant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(merchant)) {
				merchant = (Merchant)session.get(MerchantImpl.class,
						merchant.getPrimaryKeyObj());
			}

			if (merchant != null) {
				session.delete(merchant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (merchant != null) {
			clearCache(merchant);
		}

		return merchant;
	}

	@Override
	public Merchant updateImpl(com.cmcti.cmts.domain.model.Merchant merchant)
		throws SystemException {
		merchant = toUnwrappedModel(merchant);

		boolean isNew = merchant.isNew();

		MerchantModelImpl merchantModelImpl = (MerchantModelImpl)merchant;

		Session session = null;

		try {
			session = openSession();

			if (merchant.isNew()) {
				session.save(merchant);

				merchant.setNew(false);
			}
			else {
				session.merge(merchant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MerchantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((merchantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { merchantModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
			MerchantImpl.class, merchant.getPrimaryKey(), merchant);

		clearUniqueFindersCache(merchant);
		cacheUniqueFindersCache(merchant);

		return merchant;
	}

	protected Merchant toUnwrappedModel(Merchant merchant) {
		if (merchant instanceof MerchantImpl) {
			return merchant;
		}

		MerchantImpl merchantImpl = new MerchantImpl();

		merchantImpl.setNew(merchant.isNew());
		merchantImpl.setPrimaryKey(merchant.getPrimaryKey());

		merchantImpl.setMerchantId(merchant.getMerchantId());
		merchantImpl.setGroupId(merchant.getGroupId());
		merchantImpl.setCompanyId(merchant.getCompanyId());
		merchantImpl.setUserId(merchant.getUserId());
		merchantImpl.setUserName(merchant.getUserName());
		merchantImpl.setCreateDate(merchant.getCreateDate());
		merchantImpl.setModifiedDate(merchant.getModifiedDate());
		merchantImpl.setTitle(merchant.getTitle());
		merchantImpl.setCode(merchant.getCode());
		merchantImpl.setParentId(merchant.getParentId());
		merchantImpl.setParentCode(merchant.getParentCode());
		merchantImpl.setDescription(merchant.getDescription());

		return merchantImpl;
	}

	/**
	 * Returns the merchant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the merchant
	 * @return the merchant
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMerchantException, SystemException {
		Merchant merchant = fetchByPrimaryKey(primaryKey);

		if (merchant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMerchantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return merchant;
	}

	/**
	 * Returns the merchant with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantException} if it could not be found.
	 *
	 * @param merchantId the primary key of the merchant
	 * @return the merchant
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantException if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant findByPrimaryKey(long merchantId)
		throws NoSuchMerchantException, SystemException {
		return findByPrimaryKey((Serializable)merchantId);
	}

	/**
	 * Returns the merchant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the merchant
	 * @return the merchant, or <code>null</code> if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Merchant merchant = (Merchant)EntityCacheUtil.getResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
				MerchantImpl.class, primaryKey);

		if (merchant == _nullMerchant) {
			return null;
		}

		if (merchant == null) {
			Session session = null;

			try {
				session = openSession();

				merchant = (Merchant)session.get(MerchantImpl.class, primaryKey);

				if (merchant != null) {
					cacheResult(merchant);
				}
				else {
					EntityCacheUtil.putResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
						MerchantImpl.class, primaryKey, _nullMerchant);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MerchantModelImpl.ENTITY_CACHE_ENABLED,
					MerchantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return merchant;
	}

	/**
	 * Returns the merchant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param merchantId the primary key of the merchant
	 * @return the merchant, or <code>null</code> if a merchant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Merchant fetchByPrimaryKey(long merchantId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)merchantId);
	}

	/**
	 * Returns all the merchants.
	 *
	 * @return the merchants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Merchant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Merchant> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Merchant> findAll(int start, int end,
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

		List<Merchant> list = (List<Merchant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MERCHANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MERCHANT;

				if (pagination) {
					sql = sql.concat(MerchantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Merchant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Merchant>(list);
				}
				else {
					list = (List<Merchant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the merchants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Merchant merchant : findAll()) {
			remove(merchant);
		}
	}

	/**
	 * Returns the number of merchants.
	 *
	 * @return the number of merchants
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

				Query q = session.createQuery(_SQL_COUNT_MERCHANT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the merchant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.Merchant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Merchant>> listenersList = new ArrayList<ModelListener<Merchant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Merchant>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MerchantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MERCHANT = "SELECT merchant FROM Merchant merchant";
	private static final String _SQL_SELECT_MERCHANT_WHERE = "SELECT merchant FROM Merchant merchant WHERE ";
	private static final String _SQL_COUNT_MERCHANT = "SELECT COUNT(merchant) FROM Merchant merchant";
	private static final String _SQL_COUNT_MERCHANT_WHERE = "SELECT COUNT(merchant) FROM Merchant merchant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "merchant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Merchant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Merchant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MerchantPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static Merchant _nullMerchant = new MerchantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Merchant> toCacheModel() {
				return _nullMerchantCacheModel;
			}
		};

	private static CacheModel<Merchant> _nullMerchantCacheModel = new CacheModel<Merchant>() {
			@Override
			public Merchant toEntityModel() {
				return _nullMerchant;
			}
		};
}