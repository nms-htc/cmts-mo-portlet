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

import com.cmcti.cmts.domain.NoSuchCableModemException;
import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.model.impl.CableModemImpl;
import com.cmcti.cmts.domain.model.impl.CableModemModelImpl;

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
 * The persistence implementation for the cable modem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemPersistence
 * @see CableModemUtil
 * @generated
 */
public class CableModemPersistenceImpl extends BasePersistenceImpl<CableModem>
	implements CableModemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CableModemUtil} to access the cable modem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CableModemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FECUNCORRECTABLE =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFecUncorrectable",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFecUncorrectable", new String[] { Double.class.getName() },
			CableModemModelImpl.FECUNCORRECTABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FECUNCORRECTABLE = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFecUncorrectable", new String[] { Double.class.getName() });

	/**
	 * Returns all the cable modems where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecUncorrectable(double fecUncorrectable)
		throws SystemException {
		return findByFecUncorrectable(fecUncorrectable, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where fecUncorrectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecUncorrectable(double fecUncorrectable,
		int start, int end) throws SystemException {
		return findByFecUncorrectable(fecUncorrectable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where fecUncorrectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecUncorrectable(double fecUncorrectable,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((fecUncorrectable != cableModem.getFecUncorrectable())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_FECUNCORRECTABLE_FECUNCORRECTABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecUncorrectable);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByFecUncorrectable_First(double fecUncorrectable,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByFecUncorrectable_First(fecUncorrectable,
				orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecUncorrectable=");
		msg.append(fecUncorrectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByFecUncorrectable_First(double fecUncorrectable,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByFecUncorrectable(fecUncorrectable, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByFecUncorrectable_Last(double fecUncorrectable,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByFecUncorrectable_Last(fecUncorrectable,
				orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecUncorrectable=");
		msg.append(fecUncorrectable);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByFecUncorrectable_Last(double fecUncorrectable,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFecUncorrectable(fecUncorrectable);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByFecUncorrectable(fecUncorrectable,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where fecUncorrectable = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param fecUncorrectable the fec uncorrectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByFecUncorrectable_PrevAndNext(String macAddress,
		double fecUncorrectable, OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByFecUncorrectable_PrevAndNext(session, cableModem,
					fecUncorrectable, orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByFecUncorrectable_PrevAndNext(session, cableModem,
					fecUncorrectable, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CableModem getByFecUncorrectable_PrevAndNext(Session session,
		CableModem cableModem, double fecUncorrectable,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fecUncorrectable);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where fecUncorrectable = &#63; from the database.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFecUncorrectable(double fecUncorrectable)
		throws SystemException {
		for (CableModem cableModem : findByFecUncorrectable(fecUncorrectable,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where fecUncorrectable = &#63;.
	 *
	 * @param fecUncorrectable the fec uncorrectable
	 * @return the number of matching cable modems
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

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

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
		"cableModem.fecUncorrectable = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FECCORRECTED =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFecCorrected",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFecCorrected",
			new String[] { Double.class.getName() },
			CableModemModelImpl.FECCORRECTED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FECCORRECTED = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFecCorrected",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the cable modems where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecCorrected(double fecCorrected)
		throws SystemException {
		return findByFecCorrected(fecCorrected, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where fecCorrected = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecCorrected the fec corrected
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecCorrected(double fecCorrected, int start,
		int end) throws SystemException {
		return findByFecCorrected(fecCorrected, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where fecCorrected = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fecCorrected the fec corrected
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByFecCorrected(double fecCorrected, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((fecCorrected != cableModem.getFecCorrected())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fecCorrected);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByFecCorrected_First(double fecCorrected,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByFecCorrected_First(fecCorrected,
				orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecCorrected=");
		msg.append(fecCorrected);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByFecCorrected_First(double fecCorrected,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByFecCorrected(fecCorrected, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByFecCorrected_Last(double fecCorrected,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByFecCorrected_Last(fecCorrected,
				orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fecCorrected=");
		msg.append(fecCorrected);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByFecCorrected_Last(double fecCorrected,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFecCorrected(fecCorrected);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByFecCorrected(fecCorrected, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where fecCorrected = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param fecCorrected the fec corrected
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByFecCorrected_PrevAndNext(String macAddress,
		double fecCorrected, OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByFecCorrected_PrevAndNext(session, cableModem,
					fecCorrected, orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByFecCorrected_PrevAndNext(session, cableModem,
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

	protected CableModem getByFecCorrected_PrevAndNext(Session session,
		CableModem cableModem, double fecCorrected,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fecCorrected);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where fecCorrected = &#63; from the database.
	 *
	 * @param fecCorrected the fec corrected
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFecCorrected(double fecCorrected)
		throws SystemException {
		for (CableModem cableModem : findByFecCorrected(fecCorrected,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where fecCorrected = &#63;.
	 *
	 * @param fecCorrected the fec corrected
	 * @return the number of matching cable modems
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

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

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

	private static final String _FINDER_COLUMN_FECCORRECTED_FECCORRECTED_2 = "cableModem.fecCorrected = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUsSNR",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUsSNR",
			new String[] { Integer.class.getName() },
			CableModemModelImpl.USSNR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUsSNR",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the cable modems where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsSNR(int usSNR) throws SystemException {
		return findByUsSNR(usSNR, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where usSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param usSNR the us s n r
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsSNR(int usSNR, int start, int end)
		throws SystemException {
		return findByUsSNR(usSNR, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where usSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param usSNR the us s n r
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsSNR(int usSNR, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USSNR;
			finderArgs = new Object[] { usSNR };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USSNR;
			finderArgs = new Object[] { usSNR, start, end, orderByComparator };
		}

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((usSNR != cableModem.getUsSNR())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_USSNR_USSNR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(usSNR);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByUsSNR_First(int usSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByUsSNR_First(usSNR, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usSNR=");
		msg.append(usSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByUsSNR_First(int usSNR,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByUsSNR(usSNR, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByUsSNR_Last(int usSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByUsSNR_Last(usSNR, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usSNR=");
		msg.append(usSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByUsSNR_Last(int usSNR,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUsSNR(usSNR);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByUsSNR(usSNR, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where usSNR = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param usSNR the us s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByUsSNR_PrevAndNext(String macAddress, int usSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByUsSNR_PrevAndNext(session, cableModem, usSNR,
					orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByUsSNR_PrevAndNext(session, cableModem, usSNR,
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

	protected CableModem getByUsSNR_PrevAndNext(Session session,
		CableModem cableModem, int usSNR, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

		query.append(_FINDER_COLUMN_USSNR_USSNR_2);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(usSNR);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where usSNR = &#63; from the database.
	 *
	 * @param usSNR the us s n r
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUsSNR(int usSNR) throws SystemException {
		for (CableModem cableModem : findByUsSNR(usSNR, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where usSNR = &#63;.
	 *
	 * @param usSNR the us s n r
	 * @return the number of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUsSNR(int usSNR) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USSNR;

		Object[] finderArgs = new Object[] { usSNR };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_USSNR_USSNR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(usSNR);

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

	private static final String _FINDER_COLUMN_USSNR_USSNR_2 = "cableModem.usSNR = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DSSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDsSNR",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDsSNR",
			new String[] { Integer.class.getName() },
			CableModemModelImpl.DSSNR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DSSNR = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDsSNR",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the cable modems where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsSNR(int dsSNR) throws SystemException {
		return findByDsSNR(dsSNR, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where dsSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dsSNR the ds s n r
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsSNR(int dsSNR, int start, int end)
		throws SystemException {
		return findByDsSNR(dsSNR, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where dsSNR = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dsSNR the ds s n r
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsSNR(int dsSNR, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSSNR;
			finderArgs = new Object[] { dsSNR };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DSSNR;
			finderArgs = new Object[] { dsSNR, start, end, orderByComparator };
		}

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((dsSNR != cableModem.getDsSNR())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_DSSNR_DSSNR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dsSNR);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByDsSNR_First(int dsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByDsSNR_First(dsSNR, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dsSNR=");
		msg.append(dsSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByDsSNR_First(int dsSNR,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByDsSNR(dsSNR, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByDsSNR_Last(int dsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByDsSNR_Last(dsSNR, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dsSNR=");
		msg.append(dsSNR);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByDsSNR_Last(int dsSNR,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDsSNR(dsSNR);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByDsSNR(dsSNR, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where dsSNR = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param dsSNR the ds s n r
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByDsSNR_PrevAndNext(String macAddress, int dsSNR,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByDsSNR_PrevAndNext(session, cableModem, dsSNR,
					orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByDsSNR_PrevAndNext(session, cableModem, dsSNR,
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

	protected CableModem getByDsSNR_PrevAndNext(Session session,
		CableModem cableModem, int dsSNR, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

		query.append(_FINDER_COLUMN_DSSNR_DSSNR_2);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dsSNR);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where dsSNR = &#63; from the database.
	 *
	 * @param dsSNR the ds s n r
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDsSNR(int dsSNR) throws SystemException {
		for (CableModem cableModem : findByDsSNR(dsSNR, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where dsSNR = &#63;.
	 *
	 * @param dsSNR the ds s n r
	 * @return the number of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDsSNR(int dsSNR) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DSSNR;

		Object[] finderArgs = new Object[] { dsSNR };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_DSSNR_DSSNR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dsSNR);

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

	private static final String _FINDER_COLUMN_DSSNR_DSSNR_2 = "cableModem.dsSNR = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USPOWER = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUsPower",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USPOWER =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUsPower",
			new String[] { Integer.class.getName() },
			CableModemModelImpl.USPOWER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USPOWER = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUsPower",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the cable modems where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsPower(int usPower)
		throws SystemException {
		return findByUsPower(usPower, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where usPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param usPower the us power
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsPower(int usPower, int start, int end)
		throws SystemException {
		return findByUsPower(usPower, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where usPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param usPower the us power
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByUsPower(int usPower, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USPOWER;
			finderArgs = new Object[] { usPower };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USPOWER;
			finderArgs = new Object[] { usPower, start, end, orderByComparator };
		}

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((usPower != cableModem.getUsPower())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_USPOWER_USPOWER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(usPower);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByUsPower_First(int usPower,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByUsPower_First(usPower, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usPower=");
		msg.append(usPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByUsPower_First(int usPower,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByUsPower(usPower, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByUsPower_Last(int usPower,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByUsPower_Last(usPower, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usPower=");
		msg.append(usPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByUsPower_Last(int usPower,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUsPower(usPower);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByUsPower(usPower, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where usPower = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param usPower the us power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByUsPower_PrevAndNext(String macAddress,
		int usPower, OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByUsPower_PrevAndNext(session, cableModem, usPower,
					orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByUsPower_PrevAndNext(session, cableModem, usPower,
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

	protected CableModem getByUsPower_PrevAndNext(Session session,
		CableModem cableModem, int usPower,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

		query.append(_FINDER_COLUMN_USPOWER_USPOWER_2);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(usPower);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where usPower = &#63; from the database.
	 *
	 * @param usPower the us power
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUsPower(int usPower) throws SystemException {
		for (CableModem cableModem : findByUsPower(usPower, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where usPower = &#63;.
	 *
	 * @param usPower the us power
	 * @return the number of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUsPower(int usPower) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USPOWER;

		Object[] finderArgs = new Object[] { usPower };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_USPOWER_USPOWER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(usPower);

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

	private static final String _FINDER_COLUMN_USPOWER_USPOWER_2 = "cableModem.usPower = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DSPOWER = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDsPower",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSPOWER =
		new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, CableModemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDsPower",
			new String[] { Integer.class.getName() },
			CableModemModelImpl.DSPOWER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DSPOWER = new FinderPath(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDsPower",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the cable modems where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @return the matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsPower(int dsPower)
		throws SystemException {
		return findByDsPower(dsPower, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems where dsPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dsPower the ds power
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsPower(int dsPower, int start, int end)
		throws SystemException {
		return findByDsPower(dsPower, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems where dsPower = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dsPower the ds power
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findByDsPower(int dsPower, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSPOWER;
			finderArgs = new Object[] { dsPower };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DSPOWER;
			finderArgs = new Object[] { dsPower, start, end, orderByComparator };
		}

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CableModem cableModem : list) {
				if ((dsPower != cableModem.getDsPower())) {
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

			query.append(_SQL_SELECT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_DSPOWER_DSPOWER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CableModemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dsPower);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cable modem in the ordered set where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByDsPower_First(int dsPower,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByDsPower_First(dsPower, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dsPower=");
		msg.append(dsPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the first cable modem in the ordered set where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByDsPower_First(int dsPower,
		OrderByComparator orderByComparator) throws SystemException {
		List<CableModem> list = findByDsPower(dsPower, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cable modem in the ordered set where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByDsPower_Last(int dsPower,
		OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByDsPower_Last(dsPower, orderByComparator);

		if (cableModem != null) {
			return cableModem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dsPower=");
		msg.append(dsPower);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCableModemException(msg.toString());
	}

	/**
	 * Returns the last cable modem in the ordered set where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cable modem, or <code>null</code> if a matching cable modem could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByDsPower_Last(int dsPower,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDsPower(dsPower);

		if (count == 0) {
			return null;
		}

		List<CableModem> list = findByDsPower(dsPower, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cable modems before and after the current cable modem in the ordered set where dsPower = &#63;.
	 *
	 * @param macAddress the primary key of the current cable modem
	 * @param dsPower the ds power
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem[] findByDsPower_PrevAndNext(String macAddress,
		int dsPower, OrderByComparator orderByComparator)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = findByPrimaryKey(macAddress);

		Session session = null;

		try {
			session = openSession();

			CableModem[] array = new CableModemImpl[3];

			array[0] = getByDsPower_PrevAndNext(session, cableModem, dsPower,
					orderByComparator, true);

			array[1] = cableModem;

			array[2] = getByDsPower_PrevAndNext(session, cableModem, dsPower,
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

	protected CableModem getByDsPower_PrevAndNext(Session session,
		CableModem cableModem, int dsPower,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CABLEMODEM_WHERE);

		query.append(_FINDER_COLUMN_DSPOWER_DSPOWER_2);

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
			query.append(CableModemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dsPower);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cableModem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CableModem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cable modems where dsPower = &#63; from the database.
	 *
	 * @param dsPower the ds power
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDsPower(int dsPower) throws SystemException {
		for (CableModem cableModem : findByDsPower(dsPower, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems where dsPower = &#63;.
	 *
	 * @param dsPower the ds power
	 * @return the number of matching cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDsPower(int dsPower) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DSPOWER;

		Object[] finderArgs = new Object[] { dsPower };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CABLEMODEM_WHERE);

			query.append(_FINDER_COLUMN_DSPOWER_DSPOWER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dsPower);

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

	private static final String _FINDER_COLUMN_DSPOWER_DSPOWER_2 = "cableModem.dsPower = ?";

	public CableModemPersistenceImpl() {
		setModelClass(CableModem.class);
	}

	/**
	 * Caches the cable modem in the entity cache if it is enabled.
	 *
	 * @param cableModem the cable modem
	 */
	@Override
	public void cacheResult(CableModem cableModem) {
		EntityCacheUtil.putResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemImpl.class, cableModem.getPrimaryKey(), cableModem);

		cableModem.resetOriginalValues();
	}

	/**
	 * Caches the cable modems in the entity cache if it is enabled.
	 *
	 * @param cableModems the cable modems
	 */
	@Override
	public void cacheResult(List<CableModem> cableModems) {
		for (CableModem cableModem : cableModems) {
			if (EntityCacheUtil.getResult(
						CableModemModelImpl.ENTITY_CACHE_ENABLED,
						CableModemImpl.class, cableModem.getPrimaryKey()) == null) {
				cacheResult(cableModem);
			}
			else {
				cableModem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cable modems.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CableModemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CableModemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cable modem.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CableModem cableModem) {
		EntityCacheUtil.removeResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemImpl.class, cableModem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CableModem> cableModems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CableModem cableModem : cableModems) {
			EntityCacheUtil.removeResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
				CableModemImpl.class, cableModem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cable modem with the primary key. Does not add the cable modem to the database.
	 *
	 * @param macAddress the primary key for the new cable modem
	 * @return the new cable modem
	 */
	@Override
	public CableModem create(String macAddress) {
		CableModem cableModem = new CableModemImpl();

		cableModem.setNew(true);
		cableModem.setPrimaryKey(macAddress);

		return cableModem;
	}

	/**
	 * Removes the cable modem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param macAddress the primary key of the cable modem
	 * @return the cable modem that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem remove(String macAddress)
		throws NoSuchCableModemException, SystemException {
		return remove((Serializable)macAddress);
	}

	/**
	 * Removes the cable modem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cable modem
	 * @return the cable modem that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem remove(Serializable primaryKey)
		throws NoSuchCableModemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CableModem cableModem = (CableModem)session.get(CableModemImpl.class,
					primaryKey);

			if (cableModem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCableModemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cableModem);
		}
		catch (NoSuchCableModemException nsee) {
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
	protected CableModem removeImpl(CableModem cableModem)
		throws SystemException {
		cableModem = toUnwrappedModel(cableModem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cableModem)) {
				cableModem = (CableModem)session.get(CableModemImpl.class,
						cableModem.getPrimaryKeyObj());
			}

			if (cableModem != null) {
				session.delete(cableModem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cableModem != null) {
			clearCache(cableModem);
		}

		return cableModem;
	}

	@Override
	public CableModem updateImpl(
		com.cmcti.cmts.domain.model.CableModem cableModem)
		throws SystemException {
		cableModem = toUnwrappedModel(cableModem);

		boolean isNew = cableModem.isNew();

		CableModemModelImpl cableModemModelImpl = (CableModemModelImpl)cableModem;

		Session session = null;

		try {
			session = openSession();

			if (cableModem.isNew()) {
				session.save(cableModem);

				cableModem.setNew(false);
			}
			else {
				session.merge(cableModem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CableModemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalFecUncorrectable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECUNCORRECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE,
					args);

				args = new Object[] { cableModemModelImpl.getFecUncorrectable() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECUNCORRECTABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECUNCORRECTABLE,
					args);
			}

			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalFecCorrected()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECCORRECTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED,
					args);

				args = new Object[] { cableModemModelImpl.getFecCorrected() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FECCORRECTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FECCORRECTED,
					args);
			}

			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USSNR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalUsSNR()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USSNR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USSNR,
					args);

				args = new Object[] { cableModemModelImpl.getUsSNR() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USSNR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USSNR,
					args);
			}

			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSSNR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalDsSNR()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DSSNR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSSNR,
					args);

				args = new Object[] { cableModemModelImpl.getDsSNR() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DSSNR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSSNR,
					args);
			}

			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USPOWER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalUsPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USPOWER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USPOWER,
					args);

				args = new Object[] { cableModemModelImpl.getUsPower() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USPOWER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USPOWER,
					args);
			}

			if ((cableModemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSPOWER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cableModemModelImpl.getOriginalDsPower()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DSPOWER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSPOWER,
					args);

				args = new Object[] { cableModemModelImpl.getDsPower() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DSPOWER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DSPOWER,
					args);
			}
		}

		EntityCacheUtil.putResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
			CableModemImpl.class, cableModem.getPrimaryKey(), cableModem);

		return cableModem;
	}

	protected CableModem toUnwrappedModel(CableModem cableModem) {
		if (cableModem instanceof CableModemImpl) {
			return cableModem;
		}

		CableModemImpl cableModemImpl = new CableModemImpl();

		cableModemImpl.setNew(cableModem.isNew());
		cableModemImpl.setPrimaryKey(cableModem.getPrimaryKey());

		cableModemImpl.setMacAddress(cableModem.getMacAddress());
		cableModemImpl.setCreateDate(cableModem.getCreateDate());
		cableModemImpl.setModifiedDate(cableModem.getModifiedDate());
		cableModemImpl.setFecUncorrectable(cableModem.getFecUncorrectable());
		cableModemImpl.setFecCorrected(cableModem.getFecCorrected());
		cableModemImpl.setMicroRef(cableModem.getMicroRef());
		cableModemImpl.setRxPower(cableModem.getRxPower());
		cableModemImpl.setTxPower(cableModem.getTxPower());
		cableModemImpl.setUsPower(cableModem.getUsPower());
		cableModemImpl.setDsPower(cableModem.getDsPower());
		cableModemImpl.setUncorrectables(cableModem.getUncorrectables());
		cableModemImpl.setCorrecteds(cableModem.getCorrecteds());
		cableModemImpl.setUnerroreds(cableModem.getUnerroreds());
		cableModemImpl.setDsSNR(cableModem.getDsSNR());
		cableModemImpl.setUsSNR(cableModem.getUsSNR());
		cableModemImpl.setUcIfIndex(cableModem.getUcIfIndex());
		cableModemImpl.setDcIfIndex(cableModem.getDcIfIndex());
		cableModemImpl.setCmSubIndex(cableModem.getCmSubIndex());
		cableModemImpl.setCmtsId(cableModem.getCmtsId());
		cableModemImpl.setCmIndex(cableModem.getCmIndex());
		cableModemImpl.setStatus(cableModem.getStatus());
		cableModemImpl.setExist(cableModem.isExist());

		return cableModemImpl;
	}

	/**
	 * Returns the cable modem with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cable modem
	 * @return the cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCableModemException, SystemException {
		CableModem cableModem = fetchByPrimaryKey(primaryKey);

		if (cableModem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCableModemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cableModem;
	}

	/**
	 * Returns the cable modem with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemException} if it could not be found.
	 *
	 * @param macAddress the primary key of the cable modem
	 * @return the cable modem
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemException if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem findByPrimaryKey(String macAddress)
		throws NoSuchCableModemException, SystemException {
		return findByPrimaryKey((Serializable)macAddress);
	}

	/**
	 * Returns the cable modem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cable modem
	 * @return the cable modem, or <code>null</code> if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CableModem cableModem = (CableModem)EntityCacheUtil.getResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
				CableModemImpl.class, primaryKey);

		if (cableModem == _nullCableModem) {
			return null;
		}

		if (cableModem == null) {
			Session session = null;

			try {
				session = openSession();

				cableModem = (CableModem)session.get(CableModemImpl.class,
						primaryKey);

				if (cableModem != null) {
					cacheResult(cableModem);
				}
				else {
					EntityCacheUtil.putResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
						CableModemImpl.class, primaryKey, _nullCableModem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CableModemModelImpl.ENTITY_CACHE_ENABLED,
					CableModemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cableModem;
	}

	/**
	 * Returns the cable modem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param macAddress the primary key of the cable modem
	 * @return the cable modem, or <code>null</code> if a cable modem with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModem fetchByPrimaryKey(String macAddress)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)macAddress);
	}

	/**
	 * Returns all the cable modems.
	 *
	 * @return the cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @return the range of cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cable modems
	 * @param end the upper bound of the range of cable modems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cable modems
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModem> findAll(int start, int end,
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

		List<CableModem> list = (List<CableModem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CABLEMODEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CABLEMODEM;

				if (pagination) {
					sql = sql.concat(CableModemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModem>(list);
				}
				else {
					list = (List<CableModem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cable modems from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CableModem cableModem : findAll()) {
			remove(cableModem);
		}
	}

	/**
	 * Returns the number of cable modems.
	 *
	 * @return the number of cable modems
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

				Query q = session.createQuery(_SQL_COUNT_CABLEMODEM);

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
	 * Initializes the cable modem persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.CableModem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CableModem>> listenersList = new ArrayList<ModelListener<CableModem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CableModem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CableModemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CABLEMODEM = "SELECT cableModem FROM CableModem cableModem";
	private static final String _SQL_SELECT_CABLEMODEM_WHERE = "SELECT cableModem FROM CableModem cableModem WHERE ";
	private static final String _SQL_COUNT_CABLEMODEM = "SELECT COUNT(cableModem) FROM CableModem cableModem";
	private static final String _SQL_COUNT_CABLEMODEM_WHERE = "SELECT COUNT(cableModem) FROM CableModem cableModem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cableModem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CableModem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CableModem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CableModemPersistenceImpl.class);
	private static CableModem _nullCableModem = new CableModemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CableModem> toCacheModel() {
				return _nullCableModemCacheModel;
			}
		};

	private static CacheModel<CableModem> _nullCableModemCacheModel = new CacheModel<CableModem>() {
			@Override
			public CableModem toEntityModel() {
				return _nullCableModem;
			}
		};
}