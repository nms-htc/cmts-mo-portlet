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

import com.cmcti.cmts.domain.NoSuchOptionException;
import com.cmcti.cmts.domain.model.Option;
import com.cmcti.cmts.domain.model.impl.OptionImpl;
import com.cmcti.cmts.domain.model.impl.OptionModelImpl;

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
 * The persistence implementation for the option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see OptionPersistence
 * @see OptionUtil
 * @generated
 */
public class OptionPersistenceImpl extends BasePersistenceImpl<Option>
	implements OptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OptionUtil} to access the option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			OptionModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the options where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Option> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Option> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<Option> findByUser(long userId, int start, int end,
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

		List<Option> list = (List<Option>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Option option : list) {
				if ((userId != option.getUserId())) {
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

			query.append(_SQL_SELECT_OPTION_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Option>(list);
				}
				else {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first option in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching option
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByUser_First(userId, orderByComparator);

		if (option != null) {
			return option;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOptionException(msg.toString());
	}

	/**
	 * Returns the first option in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching option, or <code>null</code> if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Option> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Option findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByUser_Last(userId, orderByComparator);

		if (option != null) {
			return option;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOptionException(msg.toString());
	}

	/**
	 * Returns the last option in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching option, or <code>null</code> if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Option> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Option[] findByUser_PrevAndNext(long optionId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = findByPrimaryKey(optionId);

		Session session = null;

		try {
			session = openSession();

			Option[] array = new OptionImpl[3];

			array[0] = getByUser_PrevAndNext(session, option, userId,
					orderByComparator, true);

			array[1] = option;

			array[2] = getByUser_PrevAndNext(session, option, userId,
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

	protected Option getByUser_PrevAndNext(Session session, Option option,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OPTION_WHERE);

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
			query.append(OptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(option);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Option> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the options where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Option option : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(option);
		}
	}

	/**
	 * Returns the number of options where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching options
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

			query.append(_SQL_COUNT_OPTION_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "option.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			OptionModelImpl.OPTIONTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the options where optionType = &#63;.
	 *
	 * @param optionType the option type
	 * @return the matching options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Option> findByType(String optionType) throws SystemException {
		return findByType(optionType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Option> findByType(String optionType, int start, int end)
		throws SystemException {
		return findByType(optionType, start, end, null);
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
	@Override
	public List<Option> findByType(String optionType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { optionType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { optionType, start, end, orderByComparator };
		}

		List<Option> list = (List<Option>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Option option : list) {
				if (!Validator.equals(optionType, option.getOptionType())) {
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

			query.append(_SQL_SELECT_OPTION_WHERE);

			boolean bindOptionType = false;

			if (optionType == null) {
				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_1);
			}
			else if (optionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_3);
			}
			else {
				bindOptionType = true;

				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOptionType) {
					qPos.add(optionType);
				}

				if (!pagination) {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Option>(list);
				}
				else {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first option in the ordered set where optionType = &#63;.
	 *
	 * @param optionType the option type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching option
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option findByType_First(String optionType,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByType_First(optionType, orderByComparator);

		if (option != null) {
			return option;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optionType=");
		msg.append(optionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOptionException(msg.toString());
	}

	/**
	 * Returns the first option in the ordered set where optionType = &#63;.
	 *
	 * @param optionType the option type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching option, or <code>null</code> if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByType_First(String optionType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Option> list = findByType(optionType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Option findByType_Last(String optionType,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByType_Last(optionType, orderByComparator);

		if (option != null) {
			return option;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optionType=");
		msg.append(optionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOptionException(msg.toString());
	}

	/**
	 * Returns the last option in the ordered set where optionType = &#63;.
	 *
	 * @param optionType the option type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching option, or <code>null</code> if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByType_Last(String optionType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(optionType);

		if (count == 0) {
			return null;
		}

		List<Option> list = findByType(optionType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Option[] findByType_PrevAndNext(long optionId, String optionType,
		OrderByComparator orderByComparator)
		throws NoSuchOptionException, SystemException {
		Option option = findByPrimaryKey(optionId);

		Session session = null;

		try {
			session = openSession();

			Option[] array = new OptionImpl[3];

			array[0] = getByType_PrevAndNext(session, option, optionType,
					orderByComparator, true);

			array[1] = option;

			array[2] = getByType_PrevAndNext(session, option, optionType,
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

	protected Option getByType_PrevAndNext(Session session, Option option,
		String optionType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OPTION_WHERE);

		boolean bindOptionType = false;

		if (optionType == null) {
			query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_1);
		}
		else if (optionType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_3);
		}
		else {
			bindOptionType = true;

			query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_2);
		}

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
			query.append(OptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOptionType) {
			qPos.add(optionType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(option);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Option> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the options where optionType = &#63; from the database.
	 *
	 * @param optionType the option type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String optionType) throws SystemException {
		for (Option option : findByType(optionType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(option);
		}
	}

	/**
	 * Returns the number of options where optionType = &#63;.
	 *
	 * @param optionType the option type
	 * @return the number of matching options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String optionType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { optionType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OPTION_WHERE);

			boolean bindOptionType = false;

			if (optionType == null) {
				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_1);
			}
			else if (optionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_3);
			}
			else {
				bindOptionType = true;

				query.append(_FINDER_COLUMN_TYPE_OPTIONTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOptionType) {
					qPos.add(optionType);
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

	private static final String _FINDER_COLUMN_TYPE_OPTIONTYPE_1 = "option.optionType IS NULL";
	private static final String _FINDER_COLUMN_TYPE_OPTIONTYPE_2 = "option.optionType = ?";
	private static final String _FINDER_COLUMN_TYPE_OPTIONTYPE_3 = "(option.optionType IS NULL OR option.optionType = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_T_K = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, OptionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByT_K",
			new String[] { String.class.getName(), String.class.getName() },
			OptionModelImpl.OPTIONTYPE_COLUMN_BITMASK |
			OptionModelImpl.OPTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_K = new FinderPath(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_K",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the option where optionType = &#63; and optionKey = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	 *
	 * @param optionType the option type
	 * @param optionKey the option key
	 * @return the matching option
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option findByT_K(String optionType, String optionKey)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByT_K(optionType, optionKey);

		if (option == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("optionType=");
			msg.append(optionType);

			msg.append(", optionKey=");
			msg.append(optionKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOptionException(msg.toString());
		}

		return option;
	}

	/**
	 * Returns the option where optionType = &#63; and optionKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param optionType the option type
	 * @param optionKey the option key
	 * @return the matching option, or <code>null</code> if a matching option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByT_K(String optionType, String optionKey)
		throws SystemException {
		return fetchByT_K(optionType, optionKey, true);
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
	@Override
	public Option fetchByT_K(String optionType, String optionKey,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { optionType, optionKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_T_K,
					finderArgs, this);
		}

		if (result instanceof Option) {
			Option option = (Option)result;

			if (!Validator.equals(optionType, option.getOptionType()) ||
					!Validator.equals(optionKey, option.getOptionKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_OPTION_WHERE);

			boolean bindOptionType = false;

			if (optionType == null) {
				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_1);
			}
			else if (optionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_3);
			}
			else {
				bindOptionType = true;

				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_2);
			}

			boolean bindOptionKey = false;

			if (optionKey == null) {
				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_1);
			}
			else if (optionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_3);
			}
			else {
				bindOptionKey = true;

				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOptionType) {
					qPos.add(optionType);
				}

				if (bindOptionKey) {
					qPos.add(optionKey);
				}

				List<Option> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_K,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"OptionPersistenceImpl.fetchByT_K(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Option option = list.get(0);

					result = option;

					cacheResult(option);

					if ((option.getOptionType() == null) ||
							!option.getOptionType().equals(optionType) ||
							(option.getOptionKey() == null) ||
							!option.getOptionKey().equals(optionKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_K,
							finderArgs, option);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_K,
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
			return (Option)result;
		}
	}

	/**
	 * Removes the option where optionType = &#63; and optionKey = &#63; from the database.
	 *
	 * @param optionType the option type
	 * @param optionKey the option key
	 * @return the option that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option removeByT_K(String optionType, String optionKey)
		throws NoSuchOptionException, SystemException {
		Option option = findByT_K(optionType, optionKey);

		return remove(option);
	}

	/**
	 * Returns the number of options where optionType = &#63; and optionKey = &#63;.
	 *
	 * @param optionType the option type
	 * @param optionKey the option key
	 * @return the number of matching options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_K(String optionType, String optionKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_K;

		Object[] finderArgs = new Object[] { optionType, optionKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OPTION_WHERE);

			boolean bindOptionType = false;

			if (optionType == null) {
				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_1);
			}
			else if (optionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_3);
			}
			else {
				bindOptionType = true;

				query.append(_FINDER_COLUMN_T_K_OPTIONTYPE_2);
			}

			boolean bindOptionKey = false;

			if (optionKey == null) {
				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_1);
			}
			else if (optionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_3);
			}
			else {
				bindOptionKey = true;

				query.append(_FINDER_COLUMN_T_K_OPTIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOptionType) {
					qPos.add(optionType);
				}

				if (bindOptionKey) {
					qPos.add(optionKey);
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

	private static final String _FINDER_COLUMN_T_K_OPTIONTYPE_1 = "option.optionType IS NULL AND ";
	private static final String _FINDER_COLUMN_T_K_OPTIONTYPE_2 = "option.optionType = ? AND ";
	private static final String _FINDER_COLUMN_T_K_OPTIONTYPE_3 = "(option.optionType IS NULL OR option.optionType = '') AND ";
	private static final String _FINDER_COLUMN_T_K_OPTIONKEY_1 = "option.optionKey IS NULL";
	private static final String _FINDER_COLUMN_T_K_OPTIONKEY_2 = "option.optionKey = ?";
	private static final String _FINDER_COLUMN_T_K_OPTIONKEY_3 = "(option.optionKey IS NULL OR option.optionKey = '')";

	public OptionPersistenceImpl() {
		setModelClass(Option.class);
	}

	/**
	 * Caches the option in the entity cache if it is enabled.
	 *
	 * @param option the option
	 */
	@Override
	public void cacheResult(Option option) {
		EntityCacheUtil.putResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionImpl.class, option.getPrimaryKey(), option);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_K,
			new Object[] { option.getOptionType(), option.getOptionKey() },
			option);

		option.resetOriginalValues();
	}

	/**
	 * Caches the options in the entity cache if it is enabled.
	 *
	 * @param options the options
	 */
	@Override
	public void cacheResult(List<Option> options) {
		for (Option option : options) {
			if (EntityCacheUtil.getResult(
						OptionModelImpl.ENTITY_CACHE_ENABLED, OptionImpl.class,
						option.getPrimaryKey()) == null) {
				cacheResult(option);
			}
			else {
				option.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Option option) {
		EntityCacheUtil.removeResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionImpl.class, option.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(option);
	}

	@Override
	public void clearCache(List<Option> options) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Option option : options) {
			EntityCacheUtil.removeResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
				OptionImpl.class, option.getPrimaryKey());

			clearUniqueFindersCache(option);
		}
	}

	protected void cacheUniqueFindersCache(Option option) {
		if (option.isNew()) {
			Object[] args = new Object[] {
					option.getOptionType(), option.getOptionKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_K, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_K, args, option);
		}
		else {
			OptionModelImpl optionModelImpl = (OptionModelImpl)option;

			if ((optionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_T_K.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						option.getOptionType(), option.getOptionKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_K, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_K, args, option);
			}
		}
	}

	protected void clearUniqueFindersCache(Option option) {
		OptionModelImpl optionModelImpl = (OptionModelImpl)option;

		Object[] args = new Object[] {
				option.getOptionType(), option.getOptionKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_K, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_K, args);

		if ((optionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_T_K.getColumnBitmask()) != 0) {
			args = new Object[] {
					optionModelImpl.getOriginalOptionType(),
					optionModelImpl.getOriginalOptionKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_K, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_K, args);
		}
	}

	/**
	 * Creates a new option with the primary key. Does not add the option to the database.
	 *
	 * @param optionId the primary key for the new option
	 * @return the new option
	 */
	@Override
	public Option create(long optionId) {
		Option option = new OptionImpl();

		option.setNew(true);
		option.setPrimaryKey(optionId);

		return option;
	}

	/**
	 * Removes the option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param optionId the primary key of the option
	 * @return the option that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option remove(long optionId)
		throws NoSuchOptionException, SystemException {
		return remove((Serializable)optionId);
	}

	/**
	 * Removes the option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the option
	 * @return the option that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option remove(Serializable primaryKey)
		throws NoSuchOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Option option = (Option)session.get(OptionImpl.class, primaryKey);

			if (option == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(option);
		}
		catch (NoSuchOptionException nsee) {
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
	protected Option removeImpl(Option option) throws SystemException {
		option = toUnwrappedModel(option);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(option)) {
				option = (Option)session.get(OptionImpl.class,
						option.getPrimaryKeyObj());
			}

			if (option != null) {
				session.delete(option);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (option != null) {
			clearCache(option);
		}

		return option;
	}

	@Override
	public Option updateImpl(com.cmcti.cmts.domain.model.Option option)
		throws SystemException {
		option = toUnwrappedModel(option);

		boolean isNew = option.isNew();

		OptionModelImpl optionModelImpl = (OptionModelImpl)option;

		Session session = null;

		try {
			session = openSession();

			if (option.isNew()) {
				session.save(option);

				option.setNew(false);
			}
			else {
				session.merge(option);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((optionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { optionModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { optionModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((optionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						optionModelImpl.getOriginalOptionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { optionModelImpl.getOptionType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
			OptionImpl.class, option.getPrimaryKey(), option);

		clearUniqueFindersCache(option);
		cacheUniqueFindersCache(option);

		return option;
	}

	protected Option toUnwrappedModel(Option option) {
		if (option instanceof OptionImpl) {
			return option;
		}

		OptionImpl optionImpl = new OptionImpl();

		optionImpl.setNew(option.isNew());
		optionImpl.setPrimaryKey(option.getPrimaryKey());

		optionImpl.setOptionId(option.getOptionId());
		optionImpl.setGroupId(option.getGroupId());
		optionImpl.setCompanyId(option.getCompanyId());
		optionImpl.setUserId(option.getUserId());
		optionImpl.setUserName(option.getUserName());
		optionImpl.setCreateDate(option.getCreateDate());
		optionImpl.setModifiedDate(option.getModifiedDate());
		optionImpl.setOptionType(option.getOptionType());
		optionImpl.setOptionKey(option.getOptionKey());
		optionImpl.setOptionValue(option.getOptionValue());
		optionImpl.setDescription(option.getDescription());

		return optionImpl;
	}

	/**
	 * Returns the option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the option
	 * @return the option
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOptionException, SystemException {
		Option option = fetchByPrimaryKey(primaryKey);

		if (option == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return option;
	}

	/**
	 * Returns the option with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchOptionException} if it could not be found.
	 *
	 * @param optionId the primary key of the option
	 * @return the option
	 * @throws com.cmcti.cmts.domain.NoSuchOptionException if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option findByPrimaryKey(long optionId)
		throws NoSuchOptionException, SystemException {
		return findByPrimaryKey((Serializable)optionId);
	}

	/**
	 * Returns the option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the option
	 * @return the option, or <code>null</code> if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Option option = (Option)EntityCacheUtil.getResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
				OptionImpl.class, primaryKey);

		if (option == _nullOption) {
			return null;
		}

		if (option == null) {
			Session session = null;

			try {
				session = openSession();

				option = (Option)session.get(OptionImpl.class, primaryKey);

				if (option != null) {
					cacheResult(option);
				}
				else {
					EntityCacheUtil.putResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
						OptionImpl.class, primaryKey, _nullOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OptionModelImpl.ENTITY_CACHE_ENABLED,
					OptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return option;
	}

	/**
	 * Returns the option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param optionId the primary key of the option
	 * @return the option, or <code>null</code> if a option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Option fetchByPrimaryKey(long optionId) throws SystemException {
		return fetchByPrimaryKey((Serializable)optionId);
	}

	/**
	 * Returns all the options.
	 *
	 * @return the options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Option> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Option> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Option> findAll(int start, int end,
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

		List<Option> list = (List<Option>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OPTION;

				if (pagination) {
					sql = sql.concat(OptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Option>(list);
				}
				else {
					list = (List<Option>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Option option : findAll()) {
			remove(option);
		}
	}

	/**
	 * Returns the number of options.
	 *
	 * @return the number of options
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

				Query q = session.createQuery(_SQL_COUNT_OPTION);

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
	 * Initializes the option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.Option")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Option>> listenersList = new ArrayList<ModelListener<Option>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Option>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OPTION = "SELECT option FROM Option option";
	private static final String _SQL_SELECT_OPTION_WHERE = "SELECT option FROM Option option WHERE ";
	private static final String _SQL_COUNT_OPTION = "SELECT COUNT(option) FROM Option option";
	private static final String _SQL_COUNT_OPTION_WHERE = "SELECT COUNT(option) FROM Option option WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "option.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Option exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Option exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OptionPersistenceImpl.class);
	private static Option _nullOption = new OptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Option> toCacheModel() {
				return _nullOptionCacheModel;
			}
		};

	private static CacheModel<Option> _nullOptionCacheModel = new CacheModel<Option>() {
			@Override
			public Option toEntityModel() {
				return _nullOption;
			}
		};
}