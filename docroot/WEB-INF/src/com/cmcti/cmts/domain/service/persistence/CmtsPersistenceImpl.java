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

import com.cmcti.cmts.domain.NoSuchCmtsException;
import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.model.impl.CmtsImpl;
import com.cmcti.cmts.domain.model.impl.CmtsModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cmts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CmtsPersistence
 * @see CmtsUtil
 * @generated
 */
public class CmtsPersistenceImpl extends BasePersistenceImpl<Cmts>
	implements CmtsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CmtsUtil} to access the cmts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CmtsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, CmtsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, CmtsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, CmtsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, CmtsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			CmtsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cmtses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cmtses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cmtses
	 * @param end the upper bound of the range of cmtses (not inclusive)
	 * @return the range of matching cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cmtses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cmtses
	 * @param end the upper bound of the range of cmtses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findByUser(long userId, int start, int end,
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

		List<Cmts> list = (List<Cmts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cmts cmts : list) {
				if ((userId != cmts.getUserId())) {
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

			query.append(_SQL_SELECT_CMTS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CmtsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Cmts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cmts>(list);
				}
				else {
					list = (List<Cmts>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cmts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cmts
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a matching cmts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCmtsException, SystemException {
		Cmts cmts = fetchByUser_First(userId, orderByComparator);

		if (cmts != null) {
			return cmts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCmtsException(msg.toString());
	}

	/**
	 * Returns the first cmts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cmts, or <code>null</code> if a matching cmts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cmts> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cmts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cmts
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a matching cmts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts findByUser_Last(long userId, OrderByComparator orderByComparator)
		throws NoSuchCmtsException, SystemException {
		Cmts cmts = fetchByUser_Last(userId, orderByComparator);

		if (cmts != null) {
			return cmts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCmtsException(msg.toString());
	}

	/**
	 * Returns the last cmts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cmts, or <code>null</code> if a matching cmts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<Cmts> list = findByUser(userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cmtses before and after the current cmts in the ordered set where userId = &#63;.
	 *
	 * @param cmtsId the primary key of the current cmts
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cmts
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts[] findByUser_PrevAndNext(long cmtsId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCmtsException, SystemException {
		Cmts cmts = findByPrimaryKey(cmtsId);

		Session session = null;

		try {
			session = openSession();

			Cmts[] array = new CmtsImpl[3];

			array[0] = getByUser_PrevAndNext(session, cmts, userId,
					orderByComparator, true);

			array[1] = cmts;

			array[2] = getByUser_PrevAndNext(session, cmts, userId,
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

	protected Cmts getByUser_PrevAndNext(Session session, Cmts cmts,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CMTS_WHERE);

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
			query.append(CmtsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cmts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cmts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cmtses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (Cmts cmts : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cmts);
		}
	}

	/**
	 * Returns the number of cmtses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cmtses
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

			query.append(_SQL_COUNT_CMTS_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "cmts.userId = ?";

	public CmtsPersistenceImpl() {
		setModelClass(Cmts.class);
	}

	/**
	 * Caches the cmts in the entity cache if it is enabled.
	 *
	 * @param cmts the cmts
	 */
	@Override
	public void cacheResult(Cmts cmts) {
		EntityCacheUtil.putResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsImpl.class, cmts.getPrimaryKey(), cmts);

		cmts.resetOriginalValues();
	}

	/**
	 * Caches the cmtses in the entity cache if it is enabled.
	 *
	 * @param cmtses the cmtses
	 */
	@Override
	public void cacheResult(List<Cmts> cmtses) {
		for (Cmts cmts : cmtses) {
			if (EntityCacheUtil.getResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
						CmtsImpl.class, cmts.getPrimaryKey()) == null) {
				cacheResult(cmts);
			}
			else {
				cmts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cmtses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CmtsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CmtsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cmts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cmts cmts) {
		EntityCacheUtil.removeResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsImpl.class, cmts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Cmts> cmtses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cmts cmts : cmtses) {
			EntityCacheUtil.removeResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
				CmtsImpl.class, cmts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cmts with the primary key. Does not add the cmts to the database.
	 *
	 * @param cmtsId the primary key for the new cmts
	 * @return the new cmts
	 */
	@Override
	public Cmts create(long cmtsId) {
		Cmts cmts = new CmtsImpl();

		cmts.setNew(true);
		cmts.setPrimaryKey(cmtsId);

		return cmts;
	}

	/**
	 * Removes the cmts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmtsId the primary key of the cmts
	 * @return the cmts that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts remove(long cmtsId) throws NoSuchCmtsException, SystemException {
		return remove((Serializable)cmtsId);
	}

	/**
	 * Removes the cmts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cmts
	 * @return the cmts that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts remove(Serializable primaryKey)
		throws NoSuchCmtsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cmts cmts = (Cmts)session.get(CmtsImpl.class, primaryKey);

			if (cmts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCmtsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cmts);
		}
		catch (NoSuchCmtsException nsee) {
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
	protected Cmts removeImpl(Cmts cmts) throws SystemException {
		cmts = toUnwrappedModel(cmts);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cmts)) {
				cmts = (Cmts)session.get(CmtsImpl.class, cmts.getPrimaryKeyObj());
			}

			if (cmts != null) {
				session.delete(cmts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cmts != null) {
			clearCache(cmts);
		}

		return cmts;
	}

	@Override
	public Cmts updateImpl(com.cmcti.cmts.domain.model.Cmts cmts)
		throws SystemException {
		cmts = toUnwrappedModel(cmts);

		boolean isNew = cmts.isNew();

		CmtsModelImpl cmtsModelImpl = (CmtsModelImpl)cmts;

		Session session = null;

		try {
			session = openSession();

			if (cmts.isNew()) {
				session.save(cmts);

				cmts.setNew(false);
			}
			else {
				session.merge(cmts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CmtsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cmtsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cmtsModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { cmtsModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}
		}

		EntityCacheUtil.putResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
			CmtsImpl.class, cmts.getPrimaryKey(), cmts);

		return cmts;
	}

	protected Cmts toUnwrappedModel(Cmts cmts) {
		if (cmts instanceof CmtsImpl) {
			return cmts;
		}

		CmtsImpl cmtsImpl = new CmtsImpl();

		cmtsImpl.setNew(cmts.isNew());
		cmtsImpl.setPrimaryKey(cmts.getPrimaryKey());

		cmtsImpl.setCmtsId(cmts.getCmtsId());
		cmtsImpl.setGroupId(cmts.getGroupId());
		cmtsImpl.setCompanyId(cmts.getCompanyId());
		cmtsImpl.setUserId(cmts.getUserId());
		cmtsImpl.setUserName(cmts.getUserName());
		cmtsImpl.setCreateDate(cmts.getCreateDate());
		cmtsImpl.setModifiedDate(cmts.getModifiedDate());
		cmtsImpl.setEnable(cmts.isEnable());
		cmtsImpl.setTitle(cmts.getTitle());
		cmtsImpl.setHost(cmts.getHost());
		cmtsImpl.setCommunity(cmts.getCommunity());
		cmtsImpl.setDescription(cmts.getDescription());

		return cmtsImpl;
	}

	/**
	 * Returns the cmts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cmts
	 * @return the cmts
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCmtsException, SystemException {
		Cmts cmts = fetchByPrimaryKey(primaryKey);

		if (cmts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCmtsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cmts;
	}

	/**
	 * Returns the cmts with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCmtsException} if it could not be found.
	 *
	 * @param cmtsId the primary key of the cmts
	 * @return the cmts
	 * @throws com.cmcti.cmts.domain.NoSuchCmtsException if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts findByPrimaryKey(long cmtsId)
		throws NoSuchCmtsException, SystemException {
		return findByPrimaryKey((Serializable)cmtsId);
	}

	/**
	 * Returns the cmts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cmts
	 * @return the cmts, or <code>null</code> if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cmts cmts = (Cmts)EntityCacheUtil.getResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
				CmtsImpl.class, primaryKey);

		if (cmts == _nullCmts) {
			return null;
		}

		if (cmts == null) {
			Session session = null;

			try {
				session = openSession();

				cmts = (Cmts)session.get(CmtsImpl.class, primaryKey);

				if (cmts != null) {
					cacheResult(cmts);
				}
				else {
					EntityCacheUtil.putResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
						CmtsImpl.class, primaryKey, _nullCmts);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CmtsModelImpl.ENTITY_CACHE_ENABLED,
					CmtsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cmts;
	}

	/**
	 * Returns the cmts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cmtsId the primary key of the cmts
	 * @return the cmts, or <code>null</code> if a cmts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cmts fetchByPrimaryKey(long cmtsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cmtsId);
	}

	/**
	 * Returns all the cmtses.
	 *
	 * @return the cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cmtses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cmtses
	 * @param end the upper bound of the range of cmtses (not inclusive)
	 * @return the range of cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cmtses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CmtsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cmtses
	 * @param end the upper bound of the range of cmtses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cmtses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cmts> findAll(int start, int end,
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

		List<Cmts> list = (List<Cmts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CMTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CMTS;

				if (pagination) {
					sql = sql.concat(CmtsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cmts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cmts>(list);
				}
				else {
					list = (List<Cmts>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the cmtses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cmts cmts : findAll()) {
			remove(cmts);
		}
	}

	/**
	 * Returns the number of cmtses.
	 *
	 * @return the number of cmtses
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

				Query q = session.createQuery(_SQL_COUNT_CMTS);

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
	 * Initializes the cmts persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.Cmts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cmts>> listenersList = new ArrayList<ModelListener<Cmts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cmts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CmtsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CMTS = "SELECT cmts FROM Cmts cmts";
	private static final String _SQL_SELECT_CMTS_WHERE = "SELECT cmts FROM Cmts cmts WHERE ";
	private static final String _SQL_COUNT_CMTS = "SELECT COUNT(cmts) FROM Cmts cmts";
	private static final String _SQL_COUNT_CMTS_WHERE = "SELECT COUNT(cmts) FROM Cmts cmts WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cmts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cmts exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cmts exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CmtsPersistenceImpl.class);
	private static Cmts _nullCmts = new CmtsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cmts> toCacheModel() {
				return _nullCmtsCacheModel;
			}
		};

	private static CacheModel<Cmts> _nullCmtsCacheModel = new CacheModel<Cmts>() {
			@Override
			public Cmts toEntityModel() {
				return _nullCmts;
			}
		};
}