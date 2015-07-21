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

import com.cmcti.cmts.domain.NoSuchMerchantScopeException;
import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.model.impl.MerchantScopeImpl;
import com.cmcti.cmts.domain.model.impl.MerchantScopeModelImpl;

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
 * The persistence implementation for the merchant scope service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see MerchantScopePersistence
 * @see MerchantScopeUtil
 * @generated
 */
public class MerchantScopePersistenceImpl extends BasePersistenceImpl<MerchantScope>
	implements MerchantScopePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MerchantScopeUtil} to access the merchant scope persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MerchantScopeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUser", new String[] { Long.class.getName() },
			MerchantScopeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the merchant scopes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MerchantScope> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MerchantScope> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
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
	@Override
	public List<MerchantScope> findByUser(long userId, int start, int end,
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

		List<MerchantScope> list = (List<MerchantScope>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MerchantScope merchantScope : list) {
				if ((userId != merchantScope.getUserId())) {
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

			query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MerchantScope>(list);
				}
				else {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first merchant scope in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByUser_First(userId,
				orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the first merchant scope in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MerchantScope> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByUser_Last(userId, orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the last merchant scope in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<MerchantScope> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope[] findByUser_PrevAndNext(long merchantScopeId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = findByPrimaryKey(merchantScopeId);

		Session session = null;

		try {
			session = openSession();

			MerchantScope[] array = new MerchantScopeImpl[3];

			array[0] = getByUser_PrevAndNext(session, merchantScope, userId,
					orderByComparator, true);

			array[1] = merchantScope;

			array[2] = getByUser_PrevAndNext(session, merchantScope, userId,
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

	protected MerchantScope getByUser_PrevAndNext(Session session,
		MerchantScope merchantScope, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

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
			query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(merchantScope);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MerchantScope> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the merchant scopes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (MerchantScope merchantScope : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(merchantScope);
		}
	}

	/**
	 * Returns the number of merchant scopes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching merchant scopes
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

			query.append(_SQL_COUNT_MERCHANTSCOPE_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "merchantScope.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CMTS = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCMTS",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCMTS", new String[] { Long.class.getName() },
			MerchantScopeModelImpl.CMTSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CMTS = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCMTS",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the merchant scopes where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MerchantScope> findByCMTS(long cmtsId)
		throws SystemException {
		return findByCMTS(cmtsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MerchantScope> findByCMTS(long cmtsId, int start, int end)
		throws SystemException {
		return findByCMTS(cmtsId, start, end, null);
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
	@Override
	public List<MerchantScope> findByCMTS(long cmtsId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS;
			finderArgs = new Object[] { cmtsId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CMTS;
			finderArgs = new Object[] { cmtsId, start, end, orderByComparator };
		}

		List<MerchantScope> list = (List<MerchantScope>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MerchantScope merchantScope : list) {
				if ((cmtsId != merchantScope.getCmtsId())) {
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

			query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

			query.append(_FINDER_COLUMN_CMTS_CMTSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

				if (!pagination) {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MerchantScope>(list);
				}
				else {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first merchant scope in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByCMTS_First(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByCMTS_First(cmtsId,
				orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the first merchant scope in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByCMTS_First(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MerchantScope> list = findByCMTS(cmtsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope findByCMTS_Last(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByCMTS_Last(cmtsId, orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the last merchant scope in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByCMTS_Last(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCMTS(cmtsId);

		if (count == 0) {
			return null;
		}

		List<MerchantScope> list = findByCMTS(cmtsId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope[] findByCMTS_PrevAndNext(long merchantScopeId,
		long cmtsId, OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = findByPrimaryKey(merchantScopeId);

		Session session = null;

		try {
			session = openSession();

			MerchantScope[] array = new MerchantScopeImpl[3];

			array[0] = getByCMTS_PrevAndNext(session, merchantScope, cmtsId,
					orderByComparator, true);

			array[1] = merchantScope;

			array[2] = getByCMTS_PrevAndNext(session, merchantScope, cmtsId,
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

	protected MerchantScope getByCMTS_PrevAndNext(Session session,
		MerchantScope merchantScope, long cmtsId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

		query.append(_FINDER_COLUMN_CMTS_CMTSID_2);

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
			query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cmtsId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(merchantScope);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MerchantScope> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the merchant scopes where cmtsId = &#63; from the database.
	 *
	 * @param cmtsId the cmts ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCMTS(long cmtsId) throws SystemException {
		for (MerchantScope merchantScope : findByCMTS(cmtsId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(merchantScope);
		}
	}

	/**
	 * Returns the number of merchant scopes where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the number of matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCMTS(long cmtsId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CMTS;

		Object[] finderArgs = new Object[] { cmtsId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MERCHANTSCOPE_WHERE);

			query.append(_FINDER_COLUMN_CMTS_CMTSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

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

	private static final String _FINDER_COLUMN_CMTS_CMTSID_2 = "merchantScope.cmtsId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UPSTREAMCHANNEL =
		new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUpstreamChannel",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPSTREAMCHANNEL =
		new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUpstreamChannel",
			new String[] { Long.class.getName(), Integer.class.getName() },
			MerchantScopeModelImpl.CMTSID_COLUMN_BITMASK |
			MerchantScopeModelImpl.IFINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUpstreamChannel",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MerchantScope> findByUpstreamChannel(long cmtsId, int ifIndex)
		throws SystemException {
		return findByUpstreamChannel(cmtsId, ifIndex, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<MerchantScope> findByUpstreamChannel(long cmtsId, int ifIndex,
		int start, int end) throws SystemException {
		return findByUpstreamChannel(cmtsId, ifIndex, start, end, null);
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
	@Override
	public List<MerchantScope> findByUpstreamChannel(long cmtsId, int ifIndex,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPSTREAMCHANNEL;
			finderArgs = new Object[] { cmtsId, ifIndex };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UPSTREAMCHANNEL;
			finderArgs = new Object[] {
					cmtsId, ifIndex,
					
					start, end, orderByComparator
				};
		}

		List<MerchantScope> list = (List<MerchantScope>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MerchantScope merchantScope : list) {
				if ((cmtsId != merchantScope.getCmtsId()) ||
						(ifIndex != merchantScope.getIfIndex())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

			query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_CMTSID_2);

			query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_IFINDEX_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

				qPos.add(ifIndex);

				if (!pagination) {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MerchantScope>(list);
				}
				else {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first merchant scope in the ordered set where cmtsId = &#63; and ifIndex = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByUpstreamChannel_First(long cmtsId, int ifIndex,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByUpstreamChannel_First(cmtsId,
				ifIndex, orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(", ifIndex=");
		msg.append(ifIndex);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
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
	@Override
	public MerchantScope fetchByUpstreamChannel_First(long cmtsId, int ifIndex,
		OrderByComparator orderByComparator) throws SystemException {
		List<MerchantScope> list = findByUpstreamChannel(cmtsId, ifIndex, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope findByUpstreamChannel_Last(long cmtsId, int ifIndex,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByUpstreamChannel_Last(cmtsId,
				ifIndex, orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(", ifIndex=");
		msg.append(ifIndex);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
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
	@Override
	public MerchantScope fetchByUpstreamChannel_Last(long cmtsId, int ifIndex,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUpstreamChannel(cmtsId, ifIndex);

		if (count == 0) {
			return null;
		}

		List<MerchantScope> list = findByUpstreamChannel(cmtsId, ifIndex,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope[] findByUpstreamChannel_PrevAndNext(
		long merchantScopeId, long cmtsId, int ifIndex,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = findByPrimaryKey(merchantScopeId);

		Session session = null;

		try {
			session = openSession();

			MerchantScope[] array = new MerchantScopeImpl[3];

			array[0] = getByUpstreamChannel_PrevAndNext(session, merchantScope,
					cmtsId, ifIndex, orderByComparator, true);

			array[1] = merchantScope;

			array[2] = getByUpstreamChannel_PrevAndNext(session, merchantScope,
					cmtsId, ifIndex, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MerchantScope getByUpstreamChannel_PrevAndNext(Session session,
		MerchantScope merchantScope, long cmtsId, int ifIndex,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

		query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_CMTSID_2);

		query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_IFINDEX_2);

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
			query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cmtsId);

		qPos.add(ifIndex);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(merchantScope);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MerchantScope> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the merchant scopes where cmtsId = &#63; and ifIndex = &#63; from the database.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUpstreamChannel(long cmtsId, int ifIndex)
		throws SystemException {
		for (MerchantScope merchantScope : findByUpstreamChannel(cmtsId,
				ifIndex, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(merchantScope);
		}
	}

	/**
	 * Returns the number of merchant scopes where cmtsId = &#63; and ifIndex = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the number of matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUpstreamChannel(long cmtsId, int ifIndex)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL;

		Object[] finderArgs = new Object[] { cmtsId, ifIndex };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MERCHANTSCOPE_WHERE);

			query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_CMTSID_2);

			query.append(_FINDER_COLUMN_UPSTREAMCHANNEL_IFINDEX_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

				qPos.add(ifIndex);

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

	private static final String _FINDER_COLUMN_UPSTREAMCHANNEL_CMTSID_2 = "merchantScope.cmtsId = ? AND ";
	private static final String _FINDER_COLUMN_UPSTREAMCHANNEL_IFINDEX_2 = "merchantScope.ifIndex = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MERCHANT = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMerchant",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MERCHANT =
		new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMerchant", new String[] { String.class.getName() },
			MerchantScopeModelImpl.MERCHANTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MERCHANT = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMerchant",
			new String[] { String.class.getName() });

	/**
	 * Returns all the merchant scopes where merchantCode = &#63;.
	 *
	 * @param merchantCode the merchant code
	 * @return the matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MerchantScope> findByMerchant(String merchantCode)
		throws SystemException {
		return findByMerchant(merchantCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<MerchantScope> findByMerchant(String merchantCode, int start,
		int end) throws SystemException {
		return findByMerchant(merchantCode, start, end, null);
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
	@Override
	public List<MerchantScope> findByMerchant(String merchantCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MERCHANT;
			finderArgs = new Object[] { merchantCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MERCHANT;
			finderArgs = new Object[] {
					merchantCode,
					
					start, end, orderByComparator
				};
		}

		List<MerchantScope> list = (List<MerchantScope>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MerchantScope merchantScope : list) {
				if (!Validator.equals(merchantCode,
							merchantScope.getMerchantCode())) {
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

			query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

			boolean bindMerchantCode = false;

			if (merchantCode == null) {
				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_1);
			}
			else if (merchantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_3);
			}
			else {
				bindMerchantCode = true;

				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMerchantCode) {
					qPos.add(merchantCode);
				}

				if (!pagination) {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MerchantScope>(list);
				}
				else {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first merchant scope in the ordered set where merchantCode = &#63;.
	 *
	 * @param merchantCode the merchant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByMerchant_First(String merchantCode,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByMerchant_First(merchantCode,
				orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("merchantCode=");
		msg.append(merchantCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the first merchant scope in the ordered set where merchantCode = &#63;.
	 *
	 * @param merchantCode the merchant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByMerchant_First(String merchantCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<MerchantScope> list = findByMerchant(merchantCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope findByMerchant_Last(String merchantCode,
		OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByMerchant_Last(merchantCode,
				orderByComparator);

		if (merchantScope != null) {
			return merchantScope;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("merchantCode=");
		msg.append(merchantCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMerchantScopeException(msg.toString());
	}

	/**
	 * Returns the last merchant scope in the ordered set where merchantCode = &#63;.
	 *
	 * @param merchantCode the merchant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching merchant scope, or <code>null</code> if a matching merchant scope could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByMerchant_Last(String merchantCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMerchant(merchantCode);

		if (count == 0) {
			return null;
		}

		List<MerchantScope> list = findByMerchant(merchantCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MerchantScope[] findByMerchant_PrevAndNext(long merchantScopeId,
		String merchantCode, OrderByComparator orderByComparator)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = findByPrimaryKey(merchantScopeId);

		Session session = null;

		try {
			session = openSession();

			MerchantScope[] array = new MerchantScopeImpl[3];

			array[0] = getByMerchant_PrevAndNext(session, merchantScope,
					merchantCode, orderByComparator, true);

			array[1] = merchantScope;

			array[2] = getByMerchant_PrevAndNext(session, merchantScope,
					merchantCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MerchantScope getByMerchant_PrevAndNext(Session session,
		MerchantScope merchantScope, String merchantCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

		boolean bindMerchantCode = false;

		if (merchantCode == null) {
			query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_1);
		}
		else if (merchantCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_3);
		}
		else {
			bindMerchantCode = true;

			query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_2);
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
			query.append(MerchantScopeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMerchantCode) {
			qPos.add(merchantCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(merchantScope);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MerchantScope> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the merchant scopes where merchantCode = &#63; from the database.
	 *
	 * @param merchantCode the merchant code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMerchant(String merchantCode) throws SystemException {
		for (MerchantScope merchantScope : findByMerchant(merchantCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(merchantScope);
		}
	}

	/**
	 * Returns the number of merchant scopes where merchantCode = &#63;.
	 *
	 * @param merchantCode the merchant code
	 * @return the number of matching merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMerchant(String merchantCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MERCHANT;

		Object[] finderArgs = new Object[] { merchantCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MERCHANTSCOPE_WHERE);

			boolean bindMerchantCode = false;

			if (merchantCode == null) {
				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_1);
			}
			else if (merchantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_3);
			}
			else {
				bindMerchantCode = true;

				query.append(_FINDER_COLUMN_MERCHANT_MERCHANTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMerchantCode) {
					qPos.add(merchantCode);
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

	private static final String _FINDER_COLUMN_MERCHANT_MERCHANTCODE_1 = "merchantScope.merchantCode IS NULL";
	private static final String _FINDER_COLUMN_MERCHANT_MERCHANTCODE_2 = "merchantScope.merchantCode = ?";
	private static final String _FINDER_COLUMN_MERCHANT_MERCHANTCODE_3 = "(merchantScope.merchantCode IS NULL OR merchantScope.merchantCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_I_M = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED,
			MerchantScopeImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByC_I_M",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			MerchantScopeModelImpl.MERCHANTCODE_COLUMN_BITMASK |
			MerchantScopeModelImpl.CMTSID_COLUMN_BITMASK |
			MerchantScopeModelImpl.IFINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_I_M = new FinderPath(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_I_M",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

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
	@Override
	public MerchantScope findByC_I_M(String merchantCode, long cmtsId,
		int ifIndex) throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByC_I_M(merchantCode, cmtsId, ifIndex);

		if (merchantScope == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("merchantCode=");
			msg.append(merchantCode);

			msg.append(", cmtsId=");
			msg.append(cmtsId);

			msg.append(", ifIndex=");
			msg.append(ifIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMerchantScopeException(msg.toString());
		}

		return merchantScope;
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
	@Override
	public MerchantScope fetchByC_I_M(String merchantCode, long cmtsId,
		int ifIndex) throws SystemException {
		return fetchByC_I_M(merchantCode, cmtsId, ifIndex, true);
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
	@Override
	public MerchantScope fetchByC_I_M(String merchantCode, long cmtsId,
		int ifIndex, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { merchantCode, cmtsId, ifIndex };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_I_M,
					finderArgs, this);
		}

		if (result instanceof MerchantScope) {
			MerchantScope merchantScope = (MerchantScope)result;

			if (!Validator.equals(merchantCode, merchantScope.getMerchantCode()) ||
					(cmtsId != merchantScope.getCmtsId()) ||
					(ifIndex != merchantScope.getIfIndex())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_MERCHANTSCOPE_WHERE);

			boolean bindMerchantCode = false;

			if (merchantCode == null) {
				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_1);
			}
			else if (merchantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_3);
			}
			else {
				bindMerchantCode = true;

				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_2);
			}

			query.append(_FINDER_COLUMN_C_I_M_CMTSID_2);

			query.append(_FINDER_COLUMN_C_I_M_IFINDEX_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMerchantCode) {
					qPos.add(merchantCode);
				}

				qPos.add(cmtsId);

				qPos.add(ifIndex);

				List<MerchantScope> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_I_M,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MerchantScopePersistenceImpl.fetchByC_I_M(String, long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MerchantScope merchantScope = list.get(0);

					result = merchantScope;

					cacheResult(merchantScope);

					if ((merchantScope.getMerchantCode() == null) ||
							!merchantScope.getMerchantCode().equals(merchantCode) ||
							(merchantScope.getCmtsId() != cmtsId) ||
							(merchantScope.getIfIndex() != ifIndex)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_I_M,
							finderArgs, merchantScope);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_I_M,
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
			return (MerchantScope)result;
		}
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
	@Override
	public MerchantScope removeByC_I_M(String merchantCode, long cmtsId,
		int ifIndex) throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = findByC_I_M(merchantCode, cmtsId, ifIndex);

		return remove(merchantScope);
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
	@Override
	public int countByC_I_M(String merchantCode, long cmtsId, int ifIndex)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_I_M;

		Object[] finderArgs = new Object[] { merchantCode, cmtsId, ifIndex };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MERCHANTSCOPE_WHERE);

			boolean bindMerchantCode = false;

			if (merchantCode == null) {
				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_1);
			}
			else if (merchantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_3);
			}
			else {
				bindMerchantCode = true;

				query.append(_FINDER_COLUMN_C_I_M_MERCHANTCODE_2);
			}

			query.append(_FINDER_COLUMN_C_I_M_CMTSID_2);

			query.append(_FINDER_COLUMN_C_I_M_IFINDEX_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMerchantCode) {
					qPos.add(merchantCode);
				}

				qPos.add(cmtsId);

				qPos.add(ifIndex);

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

	private static final String _FINDER_COLUMN_C_I_M_MERCHANTCODE_1 = "merchantScope.merchantCode IS NULL AND ";
	private static final String _FINDER_COLUMN_C_I_M_MERCHANTCODE_2 = "merchantScope.merchantCode = ? AND ";
	private static final String _FINDER_COLUMN_C_I_M_MERCHANTCODE_3 = "(merchantScope.merchantCode IS NULL OR merchantScope.merchantCode = '') AND ";
	private static final String _FINDER_COLUMN_C_I_M_CMTSID_2 = "merchantScope.cmtsId = ? AND ";
	private static final String _FINDER_COLUMN_C_I_M_IFINDEX_2 = "merchantScope.ifIndex = ?";

	public MerchantScopePersistenceImpl() {
		setModelClass(MerchantScope.class);
	}

	/**
	 * Caches the merchant scope in the entity cache if it is enabled.
	 *
	 * @param merchantScope the merchant scope
	 */
	@Override
	public void cacheResult(MerchantScope merchantScope) {
		EntityCacheUtil.putResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeImpl.class, merchantScope.getPrimaryKey(),
			merchantScope);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_I_M,
			new Object[] {
				merchantScope.getMerchantCode(), merchantScope.getCmtsId(),
				merchantScope.getIfIndex()
			}, merchantScope);

		merchantScope.resetOriginalValues();
	}

	/**
	 * Caches the merchant scopes in the entity cache if it is enabled.
	 *
	 * @param merchantScopes the merchant scopes
	 */
	@Override
	public void cacheResult(List<MerchantScope> merchantScopes) {
		for (MerchantScope merchantScope : merchantScopes) {
			if (EntityCacheUtil.getResult(
						MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
						MerchantScopeImpl.class, merchantScope.getPrimaryKey()) == null) {
				cacheResult(merchantScope);
			}
			else {
				merchantScope.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all merchant scopes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MerchantScopeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MerchantScopeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the merchant scope.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MerchantScope merchantScope) {
		EntityCacheUtil.removeResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeImpl.class, merchantScope.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(merchantScope);
	}

	@Override
	public void clearCache(List<MerchantScope> merchantScopes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MerchantScope merchantScope : merchantScopes) {
			EntityCacheUtil.removeResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
				MerchantScopeImpl.class, merchantScope.getPrimaryKey());

			clearUniqueFindersCache(merchantScope);
		}
	}

	protected void cacheUniqueFindersCache(MerchantScope merchantScope) {
		if (merchantScope.isNew()) {
			Object[] args = new Object[] {
					merchantScope.getMerchantCode(), merchantScope.getCmtsId(),
					merchantScope.getIfIndex()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_I_M, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_I_M, args,
				merchantScope);
		}
		else {
			MerchantScopeModelImpl merchantScopeModelImpl = (MerchantScopeModelImpl)merchantScope;

			if ((merchantScopeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_I_M.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantScope.getMerchantCode(),
						merchantScope.getCmtsId(), merchantScope.getIfIndex()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_I_M, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_I_M, args,
					merchantScope);
			}
		}
	}

	protected void clearUniqueFindersCache(MerchantScope merchantScope) {
		MerchantScopeModelImpl merchantScopeModelImpl = (MerchantScopeModelImpl)merchantScope;

		Object[] args = new Object[] {
				merchantScope.getMerchantCode(), merchantScope.getCmtsId(),
				merchantScope.getIfIndex()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_I_M, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_I_M, args);

		if ((merchantScopeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_I_M.getColumnBitmask()) != 0) {
			args = new Object[] {
					merchantScopeModelImpl.getOriginalMerchantCode(),
					merchantScopeModelImpl.getOriginalCmtsId(),
					merchantScopeModelImpl.getOriginalIfIndex()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_I_M, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_I_M, args);
		}
	}

	/**
	 * Creates a new merchant scope with the primary key. Does not add the merchant scope to the database.
	 *
	 * @param merchantScopeId the primary key for the new merchant scope
	 * @return the new merchant scope
	 */
	@Override
	public MerchantScope create(long merchantScopeId) {
		MerchantScope merchantScope = new MerchantScopeImpl();

		merchantScope.setNew(true);
		merchantScope.setPrimaryKey(merchantScopeId);

		return merchantScope;
	}

	/**
	 * Removes the merchant scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param merchantScopeId the primary key of the merchant scope
	 * @return the merchant scope that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope remove(long merchantScopeId)
		throws NoSuchMerchantScopeException, SystemException {
		return remove((Serializable)merchantScopeId);
	}

	/**
	 * Removes the merchant scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the merchant scope
	 * @return the merchant scope that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope remove(Serializable primaryKey)
		throws NoSuchMerchantScopeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MerchantScope merchantScope = (MerchantScope)session.get(MerchantScopeImpl.class,
					primaryKey);

			if (merchantScope == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMerchantScopeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(merchantScope);
		}
		catch (NoSuchMerchantScopeException nsee) {
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
	protected MerchantScope removeImpl(MerchantScope merchantScope)
		throws SystemException {
		merchantScope = toUnwrappedModel(merchantScope);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(merchantScope)) {
				merchantScope = (MerchantScope)session.get(MerchantScopeImpl.class,
						merchantScope.getPrimaryKeyObj());
			}

			if (merchantScope != null) {
				session.delete(merchantScope);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (merchantScope != null) {
			clearCache(merchantScope);
		}

		return merchantScope;
	}

	@Override
	public MerchantScope updateImpl(
		com.cmcti.cmts.domain.model.MerchantScope merchantScope)
		throws SystemException {
		merchantScope = toUnwrappedModel(merchantScope);

		boolean isNew = merchantScope.isNew();

		MerchantScopeModelImpl merchantScopeModelImpl = (MerchantScopeModelImpl)merchantScope;

		Session session = null;

		try {
			session = openSession();

			if (merchantScope.isNew()) {
				session.save(merchantScope);

				merchantScope.setNew(false);
			}
			else {
				session.merge(merchantScope);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MerchantScopeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((merchantScopeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantScopeModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { merchantScopeModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((merchantScopeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantScopeModelImpl.getOriginalCmtsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);

				args = new Object[] { merchantScopeModelImpl.getCmtsId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);
			}

			if ((merchantScopeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPSTREAMCHANNEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantScopeModelImpl.getOriginalCmtsId(),
						merchantScopeModelImpl.getOriginalIfIndex()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPSTREAMCHANNEL,
					args);

				args = new Object[] {
						merchantScopeModelImpl.getCmtsId(),
						merchantScopeModelImpl.getIfIndex()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPSTREAMCHANNEL,
					args);
			}

			if ((merchantScopeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MERCHANT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						merchantScopeModelImpl.getOriginalMerchantCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MERCHANT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MERCHANT,
					args);

				args = new Object[] { merchantScopeModelImpl.getMerchantCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MERCHANT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MERCHANT,
					args);
			}
		}

		EntityCacheUtil.putResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
			MerchantScopeImpl.class, merchantScope.getPrimaryKey(),
			merchantScope);

		clearUniqueFindersCache(merchantScope);
		cacheUniqueFindersCache(merchantScope);

		return merchantScope;
	}

	protected MerchantScope toUnwrappedModel(MerchantScope merchantScope) {
		if (merchantScope instanceof MerchantScopeImpl) {
			return merchantScope;
		}

		MerchantScopeImpl merchantScopeImpl = new MerchantScopeImpl();

		merchantScopeImpl.setNew(merchantScope.isNew());
		merchantScopeImpl.setPrimaryKey(merchantScope.getPrimaryKey());

		merchantScopeImpl.setMerchantScopeId(merchantScope.getMerchantScopeId());
		merchantScopeImpl.setGroupId(merchantScope.getGroupId());
		merchantScopeImpl.setCompanyId(merchantScope.getCompanyId());
		merchantScopeImpl.setUserId(merchantScope.getUserId());
		merchantScopeImpl.setUserName(merchantScope.getUserName());
		merchantScopeImpl.setCreateDate(merchantScope.getCreateDate());
		merchantScopeImpl.setModifiedDate(merchantScope.getModifiedDate());
		merchantScopeImpl.setCmtsId(merchantScope.getCmtsId());
		merchantScopeImpl.setIfIndex(merchantScope.getIfIndex());
		merchantScopeImpl.setMerchantCode(merchantScope.getMerchantCode());

		return merchantScopeImpl;
	}

	/**
	 * Returns the merchant scope with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the merchant scope
	 * @return the merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMerchantScopeException, SystemException {
		MerchantScope merchantScope = fetchByPrimaryKey(primaryKey);

		if (merchantScope == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMerchantScopeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return merchantScope;
	}

	/**
	 * Returns the merchant scope with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchMerchantScopeException} if it could not be found.
	 *
	 * @param merchantScopeId the primary key of the merchant scope
	 * @return the merchant scope
	 * @throws com.cmcti.cmts.domain.NoSuchMerchantScopeException if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope findByPrimaryKey(long merchantScopeId)
		throws NoSuchMerchantScopeException, SystemException {
		return findByPrimaryKey((Serializable)merchantScopeId);
	}

	/**
	 * Returns the merchant scope with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the merchant scope
	 * @return the merchant scope, or <code>null</code> if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MerchantScope merchantScope = (MerchantScope)EntityCacheUtil.getResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
				MerchantScopeImpl.class, primaryKey);

		if (merchantScope == _nullMerchantScope) {
			return null;
		}

		if (merchantScope == null) {
			Session session = null;

			try {
				session = openSession();

				merchantScope = (MerchantScope)session.get(MerchantScopeImpl.class,
						primaryKey);

				if (merchantScope != null) {
					cacheResult(merchantScope);
				}
				else {
					EntityCacheUtil.putResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
						MerchantScopeImpl.class, primaryKey, _nullMerchantScope);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MerchantScopeModelImpl.ENTITY_CACHE_ENABLED,
					MerchantScopeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return merchantScope;
	}

	/**
	 * Returns the merchant scope with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param merchantScopeId the primary key of the merchant scope
	 * @return the merchant scope, or <code>null</code> if a merchant scope with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MerchantScope fetchByPrimaryKey(long merchantScopeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)merchantScopeId);
	}

	/**
	 * Returns all the merchant scopes.
	 *
	 * @return the merchant scopes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MerchantScope> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MerchantScope> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<MerchantScope> findAll(int start, int end,
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

		List<MerchantScope> list = (List<MerchantScope>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MERCHANTSCOPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MERCHANTSCOPE;

				if (pagination) {
					sql = sql.concat(MerchantScopeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MerchantScope>(list);
				}
				else {
					list = (List<MerchantScope>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the merchant scopes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MerchantScope merchantScope : findAll()) {
			remove(merchantScope);
		}
	}

	/**
	 * Returns the number of merchant scopes.
	 *
	 * @return the number of merchant scopes
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

				Query q = session.createQuery(_SQL_COUNT_MERCHANTSCOPE);

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
	 * Initializes the merchant scope persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.MerchantScope")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MerchantScope>> listenersList = new ArrayList<ModelListener<MerchantScope>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MerchantScope>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MerchantScopeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MERCHANTSCOPE = "SELECT merchantScope FROM MerchantScope merchantScope";
	private static final String _SQL_SELECT_MERCHANTSCOPE_WHERE = "SELECT merchantScope FROM MerchantScope merchantScope WHERE ";
	private static final String _SQL_COUNT_MERCHANTSCOPE = "SELECT COUNT(merchantScope) FROM MerchantScope merchantScope";
	private static final String _SQL_COUNT_MERCHANTSCOPE_WHERE = "SELECT COUNT(merchantScope) FROM MerchantScope merchantScope WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "merchantScope.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MerchantScope exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MerchantScope exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MerchantScopePersistenceImpl.class);
	private static MerchantScope _nullMerchantScope = new MerchantScopeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MerchantScope> toCacheModel() {
				return _nullMerchantScopeCacheModel;
			}
		};

	private static CacheModel<MerchantScope> _nullMerchantScopeCacheModel = new CacheModel<MerchantScope>() {
			@Override
			public MerchantScope toEntityModel() {
				return _nullMerchantScope;
			}
		};
}