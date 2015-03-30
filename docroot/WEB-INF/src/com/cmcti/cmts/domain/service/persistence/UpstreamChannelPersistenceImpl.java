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

import com.cmcti.cmts.domain.NoSuchUpstreamChannelException;
import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.model.impl.UpstreamChannelImpl;
import com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl;

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
 * The persistence implementation for the upstream channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpstreamChannelPersistence
 * @see UpstreamChannelUtil
 * @generated
 */
public class UpstreamChannelPersistenceImpl extends BasePersistenceImpl<UpstreamChannel>
	implements UpstreamChannelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpstreamChannelUtil} to access the upstream channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpstreamChannelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FECUNCORRECTABLE =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFecUncorrectable",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFecUncorrectable", new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.FECUNCORRECTABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FECUNCORRECTABLE = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFecUncorrectable", new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecUncorrectable(double fecUncorrectable)
		throws SystemException {
		return findByFecUncorrectable(fecUncorrectable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where fecUncorrectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end) throws SystemException {
		return findByFecUncorrectable(fecUncorrectable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where fecUncorrectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecUncorrectable(
		double fecUncorrectable, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE;
			finderArgs = new Object[] { fecUncorrectable };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FECUNCORRECTABLE;
			finderArgs = new Object[] {
					fecUncorrectable,
					
					start, end, orderByComparator
				};
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((fecUncorrectable != upstreamChannel.getFecUncorrectable())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_FECUNCORRECTABLE_FECUNCORRECTABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecUncorrectable);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByFecUncorrectable_First(
		double fecUncorrectable, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByFecUncorrectable_First(fecUncorrectable,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecUncorrectable=");
		msg.append(fecUncorrectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByFecUncorrectable_First(
		double fecUncorrectable, OrderByComparator orderByComparator)
		throws SystemException {
		List<UpstreamChannel> list = findByFecUncorrectable(fecUncorrectable,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByFecUncorrectable_Last(
		double fecUncorrectable, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByFecUncorrectable_Last(fecUncorrectable,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecUncorrectable=");
		msg.append(fecUncorrectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByFecUncorrectable_Last(
		double fecUncorrectable, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFecUncorrectable(fecUncorrectable);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByFecUncorrectable(fecUncorrectable,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByFecUncorrectable_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double fecUncorrectable,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByFecUncorrectable_PrevAndNext(session,
					upstreamChannel, fecUncorrectable, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByFecUncorrectable_PrevAndNext(session,
					upstreamChannel, fecUncorrectable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByFecUncorrectable_PrevAndNext(
		Session session, UpstreamChannel upstreamChannel,
		double fecUncorrectable, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_FECUNCORRECTABLE_FECUNCORRECTABLE_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fecUncorrectable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where fecUncorrectable = &#63; from the database.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFecUncorrectable(double fecUncorrectable)
		throws SystemException {
		for (UpstreamChannel upstreamChannel : findByFecUncorrectable(
				fecUncorrectable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFecUncorrectable(double fecUncorrectable)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FECUNCORRECTABLE;

		Object[] finderArgs = new Object[] { fecUncorrectable };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_FECUNCORRECTABLE_FECUNCORRECTABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecUncorrectable);

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

	private static final String _FINDER_COLUMN_FECUNCORRECTABLE_FECUNCORRECTABLE_2 =
		"upstreamChannel.fecUncorrectable = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FECCORRECTED =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFecCorrected",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFecCorrected",
			new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.FECCORRECTED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FECCORRECTED = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFecCorrected",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecCorrected(double fecCorrected)
		throws SystemException {
		return findByFecCorrected(fecCorrected, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where fecCorrected = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecCorrected the fec corrected
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecCorrected(double fecCorrected,
		int start, int end) throws SystemException {
		return findByFecCorrected(fecCorrected, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where fecCorrected = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecCorrected the fec corrected
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByFecCorrected(double fecCorrected,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED;
			finderArgs = new Object[] { fecCorrected };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FECCORRECTED;
			finderArgs = new Object[] {
					fecCorrected,
					
					start, end, orderByComparator
				};
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((fecCorrected != upstreamChannel.getFecCorrected())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecCorrected);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByFecCorrected_First(double fecCorrected,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByFecCorrected_First(fecCorrected,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecCorrected=");
		msg.append(fecCorrected);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByFecCorrected_First(double fecCorrected,
		OrderByComparator orderByComparator) throws SystemException {
		List<UpstreamChannel> list = findByFecCorrected(fecCorrected, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByFecCorrected_Last(double fecCorrected,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByFecCorrected_Last(fecCorrected,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecCorrected=");
		msg.append(fecCorrected);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByFecCorrected_Last(double fecCorrected,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFecCorrected(fecCorrected);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByFecCorrected(fecCorrected,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where fecCorrected = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByFecCorrected_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double fecCorrected,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByFecCorrected_PrevAndNext(session, upstreamChannel,
					fecCorrected, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByFecCorrected_PrevAndNext(session, upstreamChannel,
					fecCorrected, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByFecCorrected_PrevAndNext(Session session,
		UpstreamChannel upstreamChannel, double fecCorrected,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fecCorrected);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where fecCorrected = &#63; from the database.
	 *
	 * @param fecCorrected the fec corrected
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFecCorrected(double fecCorrected)
		throws SystemException {
		for (UpstreamChannel upstreamChannel : findByFecCorrected(
				fecCorrected, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFecCorrected(double fecCorrected)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FECCORRECTED;

		Object[] finderArgs = new Object[] { fecCorrected };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecCorrected);

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

	private static final String _FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2 = "upstreamChannel.fecCorrected = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IFSIGQSNR =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIfSigQSNR",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IFSIGQSNR =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIfSigQSNR",
			new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.IFSIGQSNR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IFSIGQSNR = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIfSigQSNR",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByIfSigQSNR(double ifSigQSNR)
		throws SystemException {
		return findByIfSigQSNR(ifSigQSNR, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the upstream channels where ifSigQSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByIfSigQSNR(double ifSigQSNR, int start,
		int end) throws SystemException {
		return findByIfSigQSNR(ifSigQSNR, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where ifSigQSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByIfSigQSNR(double ifSigQSNR, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IFSIGQSNR;
			finderArgs = new Object[] { ifSigQSNR };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IFSIGQSNR;
			finderArgs = new Object[] { ifSigQSNR, start, end, orderByComparator };
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((ifSigQSNR != upstreamChannel.getIfSigQSNR())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_IFSIGQSNR_IFSIGQSNR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ifSigQSNR);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByIfSigQSNR_First(double ifSigQSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByIfSigQSNR_First(ifSigQSNR,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ifSigQSNR=");
		msg.append(ifSigQSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByIfSigQSNR_First(double ifSigQSNR,
		OrderByComparator orderByComparator) throws SystemException {
		List<UpstreamChannel> list = findByIfSigQSNR(ifSigQSNR, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByIfSigQSNR_Last(double ifSigQSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByIfSigQSNR_Last(ifSigQSNR,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ifSigQSNR=");
		msg.append(ifSigQSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByIfSigQSNR_Last(double ifSigQSNR,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIfSigQSNR(ifSigQSNR);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByIfSigQSNR(ifSigQSNR, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where ifSigQSNR = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param ifSigQSNR the if sig q s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByIfSigQSNR_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double ifSigQSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByIfSigQSNR_PrevAndNext(session, upstreamChannel,
					ifSigQSNR, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByIfSigQSNR_PrevAndNext(session, upstreamChannel,
					ifSigQSNR, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByIfSigQSNR_PrevAndNext(Session session,
		UpstreamChannel upstreamChannel, double ifSigQSNR,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_IFSIGQSNR_IFSIGQSNR_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ifSigQSNR);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where ifSigQSNR = &#63; from the database.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIfSigQSNR(double ifSigQSNR) throws SystemException {
		for (UpstreamChannel upstreamChannel : findByIfSigQSNR(ifSigQSNR,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where ifSigQSNR = &#63;.
	 *
	 * @param ifSigQSNR the if sig q s n r
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIfSigQSNR(double ifSigQSNR) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IFSIGQSNR;

		Object[] finderArgs = new Object[] { ifSigQSNR };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_IFSIGQSNR_IFSIGQSNR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ifSigQSNR);

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

	private static final String _FINDER_COLUMN_IFSIGQSNR_IFSIGQSNR_2 = "upstreamChannel.ifSigQSNR = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CMTS = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCmts",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCmts",
			new String[] { Long.class.getName() },
			UpstreamChannelModelImpl.CMTSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CMTS = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCmts",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the upstream channels where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByCmts(long cmtsId)
		throws SystemException {
		return findByCmts(cmtsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where cmtsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cmtsId the cmts ID
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByCmts(long cmtsId, int start, int end)
		throws SystemException {
		return findByCmts(cmtsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where cmtsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cmtsId the cmts ID
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByCmts(long cmtsId, int start, int end,
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

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((cmtsId != upstreamChannel.getCmtsId())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_CMTS_CMTSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByCmts_First(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByCmts_First(cmtsId,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByCmts_First(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UpstreamChannel> list = findByCmts(cmtsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByCmts_Last(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByCmts_Last(cmtsId,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByCmts_Last(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCmts(cmtsId);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByCmts(cmtsId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where cmtsId = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByCmts_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByCmts_PrevAndNext(session, upstreamChannel, cmtsId,
					orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByCmts_PrevAndNext(session, upstreamChannel, cmtsId,
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

	protected UpstreamChannel getByCmts_PrevAndNext(Session session,
		UpstreamChannel upstreamChannel, long cmtsId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cmtsId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where cmtsId = &#63; from the database.
	 *
	 * @param cmtsId the cmts ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCmts(long cmtsId) throws SystemException {
		for (UpstreamChannel upstreamChannel : findByCmts(cmtsId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCmts(long cmtsId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CMTS;

		Object[] finderArgs = new Object[] { cmtsId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

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

	private static final String _FINDER_COLUMN_CMTS_CMTSID_2 = "upstreamChannel.id.cmtsId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINECMTXPOWER =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAvgOnlineCmTxPower",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMTXPOWER =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAvgOnlineCmTxPower",
			new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.AVGONLINECMTXPOWER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AVGONLINECMTXPOWER = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAvgOnlineCmTxPower", new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower) throws SystemException {
		return findByAvgOnlineCmTxPower(avgOnlineCmTxPower, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where avgOnlineCmTxPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end)
		throws SystemException {
		return findByAvgOnlineCmTxPower(avgOnlineCmTxPower, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where avgOnlineCmTxPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmTxPower(
		double avgOnlineCmTxPower, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMTXPOWER;
			finderArgs = new Object[] { avgOnlineCmTxPower };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINECMTXPOWER;
			finderArgs = new Object[] {
					avgOnlineCmTxPower,
					
					start, end, orderByComparator
				};
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((avgOnlineCmTxPower != upstreamChannel.getAvgOnlineCmTxPower())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINECMTXPOWER_AVGONLINECMTXPOWER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmTxPower);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineCmTxPower_First(avgOnlineCmTxPower,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmTxPower=");
		msg.append(avgOnlineCmTxPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineCmTxPower_First(
		double avgOnlineCmTxPower, OrderByComparator orderByComparator)
		throws SystemException {
		List<UpstreamChannel> list = findByAvgOnlineCmTxPower(avgOnlineCmTxPower,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineCmTxPower_Last(avgOnlineCmTxPower,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmTxPower=");
		msg.append(avgOnlineCmTxPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineCmTxPower_Last(
		double avgOnlineCmTxPower, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAvgOnlineCmTxPower(avgOnlineCmTxPower);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByAvgOnlineCmTxPower(avgOnlineCmTxPower,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmTxPower = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByAvgOnlineCmTxPower_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double avgOnlineCmTxPower,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByAvgOnlineCmTxPower_PrevAndNext(session,
					upstreamChannel, avgOnlineCmTxPower, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByAvgOnlineCmTxPower_PrevAndNext(session,
					upstreamChannel, avgOnlineCmTxPower, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByAvgOnlineCmTxPower_PrevAndNext(
		Session session, UpstreamChannel upstreamChannel,
		double avgOnlineCmTxPower, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_AVGONLINECMTXPOWER_AVGONLINECMTXPOWER_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(avgOnlineCmTxPower);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where avgOnlineCmTxPower = &#63; from the database.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws SystemException {
		for (UpstreamChannel upstreamChannel : findByAvgOnlineCmTxPower(
				avgOnlineCmTxPower, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where avgOnlineCmTxPower = &#63;.
	 *
	 * @param avgOnlineCmTxPower the avg online cm tx power
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAvgOnlineCmTxPower(double avgOnlineCmTxPower)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AVGONLINECMTXPOWER;

		Object[] finderArgs = new Object[] { avgOnlineCmTxPower };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINECMTXPOWER_AVGONLINECMTXPOWER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmTxPower);

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

	private static final String _FINDER_COLUMN_AVGONLINECMTXPOWER_AVGONLINECMTXPOWER_2 =
		"upstreamChannel.avgOnlineCmTxPower = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINECMRXPOWER =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAvgOnlineCmRxPower",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMRXPOWER =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAvgOnlineCmRxPower",
			new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.AVGONLINECMRXPOWER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AVGONLINECMRXPOWER = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAvgOnlineCmRxPower", new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower) throws SystemException {
		return findByAvgOnlineCmRxPower(avgOnlineCmRxPower, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where avgOnlineCmRxPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end)
		throws SystemException {
		return findByAvgOnlineCmRxPower(avgOnlineCmRxPower, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where avgOnlineCmRxPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineCmRxPower(
		double avgOnlineCmRxPower, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMRXPOWER;
			finderArgs = new Object[] { avgOnlineCmRxPower };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINECMRXPOWER;
			finderArgs = new Object[] {
					avgOnlineCmRxPower,
					
					start, end, orderByComparator
				};
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((avgOnlineCmRxPower != upstreamChannel.getAvgOnlineCmRxPower())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINECMRXPOWER_AVGONLINECMRXPOWER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmRxPower);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineCmRxPower_First(avgOnlineCmRxPower,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmRxPower=");
		msg.append(avgOnlineCmRxPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineCmRxPower_First(
		double avgOnlineCmRxPower, OrderByComparator orderByComparator)
		throws SystemException {
		List<UpstreamChannel> list = findByAvgOnlineCmRxPower(avgOnlineCmRxPower,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower, OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineCmRxPower_Last(avgOnlineCmRxPower,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmRxPower=");
		msg.append(avgOnlineCmRxPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineCmRxPower_Last(
		double avgOnlineCmRxPower, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAvgOnlineCmRxPower(avgOnlineCmRxPower);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByAvgOnlineCmRxPower(avgOnlineCmRxPower,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmRxPower = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByAvgOnlineCmRxPower_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double avgOnlineCmRxPower,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByAvgOnlineCmRxPower_PrevAndNext(session,
					upstreamChannel, avgOnlineCmRxPower, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByAvgOnlineCmRxPower_PrevAndNext(session,
					upstreamChannel, avgOnlineCmRxPower, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByAvgOnlineCmRxPower_PrevAndNext(
		Session session, UpstreamChannel upstreamChannel,
		double avgOnlineCmRxPower, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_AVGONLINECMRXPOWER_AVGONLINECMRXPOWER_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(avgOnlineCmRxPower);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where avgOnlineCmRxPower = &#63; from the database.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws SystemException {
		for (UpstreamChannel upstreamChannel : findByAvgOnlineCmRxPower(
				avgOnlineCmRxPower, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where avgOnlineCmRxPower = &#63;.
	 *
	 * @param avgOnlineCmRxPower the avg online cm rx power
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAvgOnlineCmRxPower(double avgOnlineCmRxPower)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AVGONLINECMRXPOWER;

		Object[] finderArgs = new Object[] { avgOnlineCmRxPower };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINECMRXPOWER_AVGONLINECMRXPOWER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmRxPower);

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

	private static final String _FINDER_COLUMN_AVGONLINECMRXPOWER_AVGONLINECMRXPOWER_2 =
		"upstreamChannel.avgOnlineCmRxPower = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINEDSSNR =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAvgOnlineDsSNR",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINEDSSNR =
		new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAvgOnlineDsSNR",
			new String[] { Double.class.getName() },
			UpstreamChannelModelImpl.AVGONLINECMDSSNR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AVGONLINEDSSNR = new FinderPath(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAvgOnlineDsSNR",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the upstream channels where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @return the matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws SystemException {
		return findByAvgOnlineDsSNR(avgOnlineCmDsSNR, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels where avgOnlineCmDsSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineDsSNR(double avgOnlineCmDsSNR,
		int start, int end) throws SystemException {
		return findByAvgOnlineDsSNR(avgOnlineCmDsSNR, start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels where avgOnlineCmDsSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findByAvgOnlineDsSNR(double avgOnlineCmDsSNR,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINEDSSNR;
			finderArgs = new Object[] { avgOnlineCmDsSNR };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVGONLINEDSSNR;
			finderArgs = new Object[] {
					avgOnlineCmDsSNR,
					
					start, end, orderByComparator
				};
		}

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpstreamChannel upstreamChannel : list) {
				if ((avgOnlineCmDsSNR != upstreamChannel.getAvgOnlineCmDsSNR())) {
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

			query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINEDSSNR_AVGONLINECMDSSNR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmDsSNR);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineDsSNR_First(double avgOnlineCmDsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineDsSNR_First(avgOnlineCmDsSNR,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmDsSNR=");
		msg.append(avgOnlineCmDsSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the first upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineDsSNR_First(
		double avgOnlineCmDsSNR, OrderByComparator orderByComparator)
		throws SystemException {
		List<UpstreamChannel> list = findByAvgOnlineDsSNR(avgOnlineCmDsSNR, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByAvgOnlineDsSNR_Last(double avgOnlineCmDsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByAvgOnlineDsSNR_Last(avgOnlineCmDsSNR,
				orderByComparator);

		if (upstreamChannel != null) {
			return upstreamChannel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("avgOnlineCmDsSNR=");
		msg.append(avgOnlineCmDsSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpstreamChannelException(msg.toString());
	}

	/**
	 * Returns the last upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upstream channel, or <code>null</code> if a matching upstream channel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByAvgOnlineDsSNR_Last(double avgOnlineCmDsSNR,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAvgOnlineDsSNR(avgOnlineCmDsSNR);

		if (count == 0) {
			return null;
		}

		List<UpstreamChannel> list = findByAvgOnlineDsSNR(avgOnlineCmDsSNR,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the upstream channels before and after the current upstream channel in the ordered set where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param upstreamChannelPK the primary key of the current upstream channel
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel[] findByAvgOnlineDsSNR_PrevAndNext(
		UpstreamChannelPK upstreamChannelPK, double avgOnlineCmDsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = findByPrimaryKey(upstreamChannelPK);

		Session session = null;

		try {
			session = openSession();

			UpstreamChannel[] array = new UpstreamChannelImpl[3];

			array[0] = getByAvgOnlineDsSNR_PrevAndNext(session,
					upstreamChannel, avgOnlineCmDsSNR, orderByComparator, true);

			array[1] = upstreamChannel;

			array[2] = getByAvgOnlineDsSNR_PrevAndNext(session,
					upstreamChannel, avgOnlineCmDsSNR, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpstreamChannel getByAvgOnlineDsSNR_PrevAndNext(Session session,
		UpstreamChannel upstreamChannel, double avgOnlineCmDsSNR,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPSTREAMCHANNEL_WHERE);

		query.append(_FINDER_COLUMN_AVGONLINEDSSNR_AVGONLINECMDSSNR_2);

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
			query.append(UpstreamChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(avgOnlineCmDsSNR);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upstreamChannel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpstreamChannel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the upstream channels where avgOnlineCmDsSNR = &#63; from the database.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws SystemException {
		for (UpstreamChannel upstreamChannel : findByAvgOnlineDsSNR(
				avgOnlineCmDsSNR, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels where avgOnlineCmDsSNR = &#63;.
	 *
	 * @param avgOnlineCmDsSNR the avg online cm ds s n r
	 * @return the number of matching upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAvgOnlineDsSNR(double avgOnlineCmDsSNR)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AVGONLINEDSSNR;

		Object[] finderArgs = new Object[] { avgOnlineCmDsSNR };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPSTREAMCHANNEL_WHERE);

			query.append(_FINDER_COLUMN_AVGONLINEDSSNR_AVGONLINECMDSSNR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(avgOnlineCmDsSNR);

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

	private static final String _FINDER_COLUMN_AVGONLINEDSSNR_AVGONLINECMDSSNR_2 =
		"upstreamChannel.avgOnlineCmDsSNR = ?";

	public UpstreamChannelPersistenceImpl() {
		setModelClass(UpstreamChannel.class);
	}

	/**
	 * Caches the upstream channel in the entity cache if it is enabled.
	 *
	 * @param upstreamChannel the upstream channel
	 */
	@Override
	public void cacheResult(UpstreamChannel upstreamChannel) {
		EntityCacheUtil.putResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelImpl.class, upstreamChannel.getPrimaryKey(),
			upstreamChannel);

		upstreamChannel.resetOriginalValues();
	}

	/**
	 * Caches the upstream channels in the entity cache if it is enabled.
	 *
	 * @param upstreamChannels the upstream channels
	 */
	@Override
	public void cacheResult(List<UpstreamChannel> upstreamChannels) {
		for (UpstreamChannel upstreamChannel : upstreamChannels) {
			if (EntityCacheUtil.getResult(
						UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
						UpstreamChannelImpl.class,
						upstreamChannel.getPrimaryKey()) == null) {
				cacheResult(upstreamChannel);
			}
			else {
				upstreamChannel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all upstream channels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UpstreamChannelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UpstreamChannelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the upstream channel.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UpstreamChannel upstreamChannel) {
		EntityCacheUtil.removeResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelImpl.class, upstreamChannel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UpstreamChannel> upstreamChannels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpstreamChannel upstreamChannel : upstreamChannels) {
			EntityCacheUtil.removeResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
				UpstreamChannelImpl.class, upstreamChannel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new upstream channel with the primary key. Does not add the upstream channel to the database.
	 *
	 * @param upstreamChannelPK the primary key for the new upstream channel
	 * @return the new upstream channel
	 */
	@Override
	public UpstreamChannel create(UpstreamChannelPK upstreamChannelPK) {
		UpstreamChannel upstreamChannel = new UpstreamChannelImpl();

		upstreamChannel.setNew(true);
		upstreamChannel.setPrimaryKey(upstreamChannelPK);

		return upstreamChannel;
	}

	/**
	 * Removes the upstream channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param upstreamChannelPK the primary key of the upstream channel
	 * @return the upstream channel that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel remove(UpstreamChannelPK upstreamChannelPK)
		throws NoSuchUpstreamChannelException, SystemException {
		return remove((Serializable)upstreamChannelPK);
	}

	/**
	 * Removes the upstream channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upstream channel
	 * @return the upstream channel that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel remove(Serializable primaryKey)
		throws NoSuchUpstreamChannelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UpstreamChannel upstreamChannel = (UpstreamChannel)session.get(UpstreamChannelImpl.class,
					primaryKey);

			if (upstreamChannel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpstreamChannelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(upstreamChannel);
		}
		catch (NoSuchUpstreamChannelException nsee) {
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
	protected UpstreamChannel removeImpl(UpstreamChannel upstreamChannel)
		throws SystemException {
		upstreamChannel = toUnwrappedModel(upstreamChannel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(upstreamChannel)) {
				upstreamChannel = (UpstreamChannel)session.get(UpstreamChannelImpl.class,
						upstreamChannel.getPrimaryKeyObj());
			}

			if (upstreamChannel != null) {
				session.delete(upstreamChannel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (upstreamChannel != null) {
			clearCache(upstreamChannel);
		}

		return upstreamChannel;
	}

	@Override
	public UpstreamChannel updateImpl(
		com.cmcti.cmts.domain.model.UpstreamChannel upstreamChannel)
		throws SystemException {
		upstreamChannel = toUnwrappedModel(upstreamChannel);

		boolean isNew = upstreamChannel.isNew();

		UpstreamChannelModelImpl upstreamChannelModelImpl = (UpstreamChannelModelImpl)upstreamChannel;

		Session session = null;

		try {
			session = openSession();

			if (upstreamChannel.isNew()) {
				session.save(upstreamChannel);

				upstreamChannel.setNew(false);
			}
			else {
				session.merge(upstreamChannel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UpstreamChannelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalFecUncorrectable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECUNCORRECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE,
					args);

				args = new Object[] {
						upstreamChannelModelImpl.getFecUncorrectable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECUNCORRECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalFecCorrected()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECCORRECTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED,
					args);

				args = new Object[] { upstreamChannelModelImpl.getFecCorrected() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECCORRECTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IFSIGQSNR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalIfSigQSNR()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IFSIGQSNR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IFSIGQSNR,
					args);

				args = new Object[] { upstreamChannelModelImpl.getIfSigQSNR() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IFSIGQSNR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IFSIGQSNR,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalCmtsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);

				args = new Object[] { upstreamChannelModelImpl.getCmtsId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMTXPOWER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalAvgOnlineCmTxPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINECMTXPOWER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMTXPOWER,
					args);

				args = new Object[] {
						upstreamChannelModelImpl.getAvgOnlineCmTxPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINECMTXPOWER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMTXPOWER,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMRXPOWER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalAvgOnlineCmRxPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINECMRXPOWER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMRXPOWER,
					args);

				args = new Object[] {
						upstreamChannelModelImpl.getAvgOnlineCmRxPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINECMRXPOWER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINECMRXPOWER,
					args);
			}

			if ((upstreamChannelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINEDSSNR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upstreamChannelModelImpl.getOriginalAvgOnlineCmDsSNR()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINEDSSNR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINEDSSNR,
					args);

				args = new Object[] {
						upstreamChannelModelImpl.getAvgOnlineCmDsSNR()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AVGONLINEDSSNR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVGONLINEDSSNR,
					args);
			}
		}

		EntityCacheUtil.putResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelImpl.class, upstreamChannel.getPrimaryKey(),
			upstreamChannel);

		return upstreamChannel;
	}

	protected UpstreamChannel toUnwrappedModel(UpstreamChannel upstreamChannel) {
		if (upstreamChannel instanceof UpstreamChannelImpl) {
			return upstreamChannel;
		}

		UpstreamChannelImpl upstreamChannelImpl = new UpstreamChannelImpl();

		upstreamChannelImpl.setNew(upstreamChannel.isNew());
		upstreamChannelImpl.setPrimaryKey(upstreamChannel.getPrimaryKey());

		upstreamChannelImpl.setIfIndex(upstreamChannel.getIfIndex());
		upstreamChannelImpl.setCmtsId(upstreamChannel.getCmtsId());
		upstreamChannelImpl.setCreateDate(upstreamChannel.getCreateDate());
		upstreamChannelImpl.setModifiedDate(upstreamChannel.getModifiedDate());
		upstreamChannelImpl.setQam(upstreamChannel.getQam());
		upstreamChannelImpl.setAvgOnlineCmDsPower(upstreamChannel.getAvgOnlineCmDsPower());
		upstreamChannelImpl.setAvgOnlineCmUsPower(upstreamChannel.getAvgOnlineCmUsPower());
		upstreamChannelImpl.setAvgOnlineCmMicRef(upstreamChannel.getAvgOnlineCmMicRef());
		upstreamChannelImpl.setAvgOnlineCmDsSNR(upstreamChannel.getAvgOnlineCmDsSNR());
		upstreamChannelImpl.setAvgOnlineCmTxPower(upstreamChannel.getAvgOnlineCmTxPower());
		upstreamChannelImpl.setAvgOnlineCmRxPower(upstreamChannel.getAvgOnlineCmRxPower());
		upstreamChannelImpl.setFecUncorrectable(upstreamChannel.getFecUncorrectable());
		upstreamChannelImpl.setFecCorrected(upstreamChannel.getFecCorrected());
		upstreamChannelImpl.setUpChannelCmTotal(upstreamChannel.getUpChannelCmTotal());
		upstreamChannelImpl.setUpChannelCmRegistered(upstreamChannel.getUpChannelCmRegistered());
		upstreamChannelImpl.setUpChannelCmActive(upstreamChannel.getUpChannelCmActive());
		upstreamChannelImpl.setUpChannelModProfile(upstreamChannel.getUpChannelModProfile());
		upstreamChannelImpl.setUpChannelWidth(upstreamChannel.getUpChannelWidth());
		upstreamChannelImpl.setUpChannelFrequency(upstreamChannel.getUpChannelFrequency());
		upstreamChannelImpl.setIfSigQUncorrectables(upstreamChannel.getIfSigQUncorrectables());
		upstreamChannelImpl.setIfSigQCorrecteds(upstreamChannel.getIfSigQCorrecteds());
		upstreamChannelImpl.setIfSigQUnerroreds(upstreamChannel.getIfSigQUnerroreds());
		upstreamChannelImpl.setIfSigQSNR(upstreamChannel.getIfSigQSNR());
		upstreamChannelImpl.setIfAlias(upstreamChannel.getIfAlias());
		upstreamChannelImpl.setIfDesc(upstreamChannel.getIfDesc());

		return upstreamChannelImpl;
	}

	/**
	 * Returns the upstream channel with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the upstream channel
	 * @return the upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUpstreamChannelException, SystemException {
		UpstreamChannel upstreamChannel = fetchByPrimaryKey(primaryKey);

		if (upstreamChannel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUpstreamChannelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return upstreamChannel;
	}

	/**
	 * Returns the upstream channel with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpstreamChannelException} if it could not be found.
	 *
	 * @param upstreamChannelPK the primary key of the upstream channel
	 * @return the upstream channel
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelException if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel findByPrimaryKey(UpstreamChannelPK upstreamChannelPK)
		throws NoSuchUpstreamChannelException, SystemException {
		return findByPrimaryKey((Serializable)upstreamChannelPK);
	}

	/**
	 * Returns the upstream channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upstream channel
	 * @return the upstream channel, or <code>null</code> if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UpstreamChannel upstreamChannel = (UpstreamChannel)EntityCacheUtil.getResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
				UpstreamChannelImpl.class, primaryKey);

		if (upstreamChannel == _nullUpstreamChannel) {
			return null;
		}

		if (upstreamChannel == null) {
			Session session = null;

			try {
				session = openSession();

				upstreamChannel = (UpstreamChannel)session.get(UpstreamChannelImpl.class,
						primaryKey);

				if (upstreamChannel != null) {
					cacheResult(upstreamChannel);
				}
				else {
					EntityCacheUtil.putResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
						UpstreamChannelImpl.class, primaryKey,
						_nullUpstreamChannel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UpstreamChannelModelImpl.ENTITY_CACHE_ENABLED,
					UpstreamChannelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return upstreamChannel;
	}

	/**
	 * Returns the upstream channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param upstreamChannelPK the primary key of the upstream channel
	 * @return the upstream channel, or <code>null</code> if a upstream channel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannel fetchByPrimaryKey(
		UpstreamChannelPK upstreamChannelPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)upstreamChannelPK);
	}

	/**
	 * Returns all the upstream channels.
	 *
	 * @return the upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @return the range of upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upstream channels
	 * @param end the upper bound of the range of upstream channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upstream channels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannel> findAll(int start, int end,
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

		List<UpstreamChannel> list = (List<UpstreamChannel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPSTREAMCHANNEL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPSTREAMCHANNEL;

				if (pagination) {
					sql = sql.concat(UpstreamChannelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannel>(list);
				}
				else {
					list = (List<UpstreamChannel>)QueryUtil.list(q,
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
	 * Removes all the upstream channels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UpstreamChannel upstreamChannel : findAll()) {
			remove(upstreamChannel);
		}
	}

	/**
	 * Returns the number of upstream channels.
	 *
	 * @return the number of upstream channels
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

				Query q = session.createQuery(_SQL_COUNT_UPSTREAMCHANNEL);

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
	 * Initializes the upstream channel persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.UpstreamChannel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UpstreamChannel>> listenersList = new ArrayList<ModelListener<UpstreamChannel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UpstreamChannel>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UpstreamChannelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UPSTREAMCHANNEL = "SELECT upstreamChannel FROM UpstreamChannel upstreamChannel";
	private static final String _SQL_SELECT_UPSTREAMCHANNEL_WHERE = "SELECT upstreamChannel FROM UpstreamChannel upstreamChannel WHERE ";
	private static final String _SQL_COUNT_UPSTREAMCHANNEL = "SELECT COUNT(upstreamChannel) FROM UpstreamChannel upstreamChannel";
	private static final String _SQL_COUNT_UPSTREAMCHANNEL_WHERE = "SELECT COUNT(upstreamChannel) FROM UpstreamChannel upstreamChannel WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "upstreamChannel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpstreamChannel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UpstreamChannel exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UpstreamChannelPersistenceImpl.class);
	private static UpstreamChannel _nullUpstreamChannel = new UpstreamChannelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UpstreamChannel> toCacheModel() {
				return _nullUpstreamChannelCacheModel;
			}
		};

	private static CacheModel<UpstreamChannel> _nullUpstreamChannelCacheModel = new CacheModel<UpstreamChannel>() {
			@Override
			public UpstreamChannel toEntityModel() {
				return _nullUpstreamChannel;
			}
		};
}