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

import com.cmcti.cmts.domain.NoSuchUpChannelMetadataException;
import com.cmcti.cmts.domain.model.UpChannelMetadata;
import com.cmcti.cmts.domain.model.impl.UpChannelMetadataImpl;
import com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl;

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
 * The persistence implementation for the up channel metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpChannelMetadataPersistence
 * @see UpChannelMetadataUtil
 * @generated
 */
public class UpChannelMetadataPersistenceImpl extends BasePersistenceImpl<UpChannelMetadata>
	implements UpChannelMetadataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpChannelMetadataUtil} to access the up channel metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpChannelMetadataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED,
			UpChannelMetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED,
			UpChannelMetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CMTS = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED,
			UpChannelMetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCMTS",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED,
			UpChannelMetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCMTS",
			new String[] { Long.class.getName() },
			UpChannelMetadataModelImpl.CMTSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CMTS = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCMTS",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the up channel metadatas where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the matching up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findByCMTS(long cmtsId)
		throws SystemException {
		return findByCMTS(cmtsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the up channel metadatas where cmtsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cmtsId the cmts ID
	 * @param start the lower bound of the range of up channel metadatas
	 * @param end the upper bound of the range of up channel metadatas (not inclusive)
	 * @return the range of matching up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findByCMTS(long cmtsId, int start, int end)
		throws SystemException {
		return findByCMTS(cmtsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the up channel metadatas where cmtsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cmtsId the cmts ID
	 * @param start the lower bound of the range of up channel metadatas
	 * @param end the upper bound of the range of up channel metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findByCMTS(long cmtsId, int start, int end,
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

		List<UpChannelMetadata> list = (List<UpChannelMetadata>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UpChannelMetadata upChannelMetadata : list) {
				if ((cmtsId != upChannelMetadata.getCmtsId())) {
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

			query.append(_SQL_SELECT_UPCHANNELMETADATA_WHERE);

			query.append(_FINDER_COLUMN_CMTS_CMTSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpChannelMetadataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cmtsId);

				if (!pagination) {
					list = (List<UpChannelMetadata>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpChannelMetadata>(list);
				}
				else {
					list = (List<UpChannelMetadata>)QueryUtil.list(q,
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
	 * Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata findByCMTS_First(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = fetchByCMTS_First(cmtsId,
				orderByComparator);

		if (upChannelMetadata != null) {
			return upChannelMetadata;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpChannelMetadataException(msg.toString());
	}

	/**
	 * Returns the first up channel metadata in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByCMTS_First(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UpChannelMetadata> list = findByCMTS(cmtsId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata findByCMTS_Last(long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = fetchByCMTS_Last(cmtsId,
				orderByComparator);

		if (upChannelMetadata != null) {
			return upChannelMetadata;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cmtsId=");
		msg.append(cmtsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUpChannelMetadataException(msg.toString());
	}

	/**
	 * Returns the last up channel metadata in the ordered set where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByCMTS_Last(long cmtsId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCMTS(cmtsId);

		if (count == 0) {
			return null;
		}

		List<UpChannelMetadata> list = findByCMTS(cmtsId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the up channel metadatas before and after the current up channel metadata in the ordered set where cmtsId = &#63;.
	 *
	 * @param metaId the primary key of the current up channel metadata
	 * @param cmtsId the cmts ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata[] findByCMTS_PrevAndNext(long metaId, long cmtsId,
		OrderByComparator orderByComparator)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = findByPrimaryKey(metaId);

		Session session = null;

		try {
			session = openSession();

			UpChannelMetadata[] array = new UpChannelMetadataImpl[3];

			array[0] = getByCMTS_PrevAndNext(session, upChannelMetadata,
					cmtsId, orderByComparator, true);

			array[1] = upChannelMetadata;

			array[2] = getByCMTS_PrevAndNext(session, upChannelMetadata,
					cmtsId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpChannelMetadata getByCMTS_PrevAndNext(Session session,
		UpChannelMetadata upChannelMetadata, long cmtsId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPCHANNELMETADATA_WHERE);

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
			query.append(UpChannelMetadataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cmtsId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upChannelMetadata);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpChannelMetadata> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the up channel metadatas where cmtsId = &#63; from the database.
	 *
	 * @param cmtsId the cmts ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCMTS(long cmtsId) throws SystemException {
		for (UpChannelMetadata upChannelMetadata : findByCMTS(cmtsId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(upChannelMetadata);
		}
	}

	/**
	 * Returns the number of up channel metadatas where cmtsId = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @return the number of matching up channel metadatas
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

			query.append(_SQL_COUNT_UPCHANNELMETADATA_WHERE);

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

	private static final String _FINDER_COLUMN_CMTS_CMTSID_2 = "upChannelMetadata.cmtsId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED,
			UpChannelMetadataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUpstreamChannel",
			new String[] { Long.class.getName(), Integer.class.getName() },
			UpChannelMetadataModelImpl.CMTSID_COLUMN_BITMASK |
			UpChannelMetadataModelImpl.IFINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL = new FinderPath(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUpstreamChannel",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the matching up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata findByUpstreamChannel(long cmtsId, int ifIndex)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = fetchByUpstreamChannel(cmtsId,
				ifIndex);

		if (upChannelMetadata == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cmtsId=");
			msg.append(cmtsId);

			msg.append(", ifIndex=");
			msg.append(ifIndex);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUpChannelMetadataException(msg.toString());
		}

		return upChannelMetadata;
	}

	/**
	 * Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByUpstreamChannel(long cmtsId, int ifIndex)
		throws SystemException {
		return fetchByUpstreamChannel(cmtsId, ifIndex, true);
	}

	/**
	 * Returns the up channel metadata where cmtsId = &#63; and ifIndex = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching up channel metadata, or <code>null</code> if a matching up channel metadata could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByUpstreamChannel(long cmtsId, int ifIndex,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cmtsId, ifIndex };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
					finderArgs, this);
		}

		if (result instanceof UpChannelMetadata) {
			UpChannelMetadata upChannelMetadata = (UpChannelMetadata)result;

			if ((cmtsId != upChannelMetadata.getCmtsId()) ||
					(ifIndex != upChannelMetadata.getIfIndex())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_UPCHANNELMETADATA_WHERE);

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

				List<UpChannelMetadata> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UpChannelMetadataPersistenceImpl.fetchByUpstreamChannel(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UpChannelMetadata upChannelMetadata = list.get(0);

					result = upChannelMetadata;

					cacheResult(upChannelMetadata);

					if ((upChannelMetadata.getCmtsId() != cmtsId) ||
							(upChannelMetadata.getIfIndex() != ifIndex)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
							finderArgs, upChannelMetadata);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
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
			return (UpChannelMetadata)result;
		}
	}

	/**
	 * Removes the up channel metadata where cmtsId = &#63; and ifIndex = &#63; from the database.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the up channel metadata that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata removeByUpstreamChannel(long cmtsId, int ifIndex)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = findByUpstreamChannel(cmtsId,
				ifIndex);

		return remove(upChannelMetadata);
	}

	/**
	 * Returns the number of up channel metadatas where cmtsId = &#63; and ifIndex = &#63;.
	 *
	 * @param cmtsId the cmts ID
	 * @param ifIndex the if index
	 * @return the number of matching up channel metadatas
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

			query.append(_SQL_COUNT_UPCHANNELMETADATA_WHERE);

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

	private static final String _FINDER_COLUMN_UPSTREAMCHANNEL_CMTSID_2 = "upChannelMetadata.cmtsId = ? AND ";
	private static final String _FINDER_COLUMN_UPSTREAMCHANNEL_IFINDEX_2 = "upChannelMetadata.ifIndex = ?";

	public UpChannelMetadataPersistenceImpl() {
		setModelClass(UpChannelMetadata.class);
	}

	/**
	 * Caches the up channel metadata in the entity cache if it is enabled.
	 *
	 * @param upChannelMetadata the up channel metadata
	 */
	@Override
	public void cacheResult(UpChannelMetadata upChannelMetadata) {
		EntityCacheUtil.putResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataImpl.class, upChannelMetadata.getPrimaryKey(),
			upChannelMetadata);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
			new Object[] {
				upChannelMetadata.getCmtsId(), upChannelMetadata.getIfIndex()
			}, upChannelMetadata);

		upChannelMetadata.resetOriginalValues();
	}

	/**
	 * Caches the up channel metadatas in the entity cache if it is enabled.
	 *
	 * @param upChannelMetadatas the up channel metadatas
	 */
	@Override
	public void cacheResult(List<UpChannelMetadata> upChannelMetadatas) {
		for (UpChannelMetadata upChannelMetadata : upChannelMetadatas) {
			if (EntityCacheUtil.getResult(
						UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
						UpChannelMetadataImpl.class,
						upChannelMetadata.getPrimaryKey()) == null) {
				cacheResult(upChannelMetadata);
			}
			else {
				upChannelMetadata.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all up channel metadatas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UpChannelMetadataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UpChannelMetadataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the up channel metadata.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UpChannelMetadata upChannelMetadata) {
		EntityCacheUtil.removeResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataImpl.class, upChannelMetadata.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(upChannelMetadata);
	}

	@Override
	public void clearCache(List<UpChannelMetadata> upChannelMetadatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpChannelMetadata upChannelMetadata : upChannelMetadatas) {
			EntityCacheUtil.removeResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
				UpChannelMetadataImpl.class, upChannelMetadata.getPrimaryKey());

			clearUniqueFindersCache(upChannelMetadata);
		}
	}

	protected void cacheUniqueFindersCache(UpChannelMetadata upChannelMetadata) {
		if (upChannelMetadata.isNew()) {
			Object[] args = new Object[] {
					upChannelMetadata.getCmtsId(),
					upChannelMetadata.getIfIndex()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
				args, upChannelMetadata);
		}
		else {
			UpChannelMetadataModelImpl upChannelMetadataModelImpl = (UpChannelMetadataModelImpl)upChannelMetadata;

			if ((upChannelMetadataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upChannelMetadata.getCmtsId(),
						upChannelMetadata.getIfIndex()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
					args, upChannelMetadata);
			}
		}
	}

	protected void clearUniqueFindersCache(UpChannelMetadata upChannelMetadata) {
		UpChannelMetadataModelImpl upChannelMetadataModelImpl = (UpChannelMetadataModelImpl)upChannelMetadata;

		Object[] args = new Object[] {
				upChannelMetadata.getCmtsId(), upChannelMetadata.getIfIndex()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL, args);

		if ((upChannelMetadataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL.getColumnBitmask()) != 0) {
			args = new Object[] {
					upChannelMetadataModelImpl.getOriginalCmtsId(),
					upChannelMetadataModelImpl.getOriginalIfIndex()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPSTREAMCHANNEL,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPSTREAMCHANNEL,
				args);
		}
	}

	/**
	 * Creates a new up channel metadata with the primary key. Does not add the up channel metadata to the database.
	 *
	 * @param metaId the primary key for the new up channel metadata
	 * @return the new up channel metadata
	 */
	@Override
	public UpChannelMetadata create(long metaId) {
		UpChannelMetadata upChannelMetadata = new UpChannelMetadataImpl();

		upChannelMetadata.setNew(true);
		upChannelMetadata.setPrimaryKey(metaId);

		return upChannelMetadata;
	}

	/**
	 * Removes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metaId the primary key of the up channel metadata
	 * @return the up channel metadata that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata remove(long metaId)
		throws NoSuchUpChannelMetadataException, SystemException {
		return remove((Serializable)metaId);
	}

	/**
	 * Removes the up channel metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the up channel metadata
	 * @return the up channel metadata that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata remove(Serializable primaryKey)
		throws NoSuchUpChannelMetadataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UpChannelMetadata upChannelMetadata = (UpChannelMetadata)session.get(UpChannelMetadataImpl.class,
					primaryKey);

			if (upChannelMetadata == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpChannelMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(upChannelMetadata);
		}
		catch (NoSuchUpChannelMetadataException nsee) {
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
	protected UpChannelMetadata removeImpl(UpChannelMetadata upChannelMetadata)
		throws SystemException {
		upChannelMetadata = toUnwrappedModel(upChannelMetadata);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(upChannelMetadata)) {
				upChannelMetadata = (UpChannelMetadata)session.get(UpChannelMetadataImpl.class,
						upChannelMetadata.getPrimaryKeyObj());
			}

			if (upChannelMetadata != null) {
				session.delete(upChannelMetadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (upChannelMetadata != null) {
			clearCache(upChannelMetadata);
		}

		return upChannelMetadata;
	}

	@Override
	public UpChannelMetadata updateImpl(
		com.cmcti.cmts.domain.model.UpChannelMetadata upChannelMetadata)
		throws SystemException {
		upChannelMetadata = toUnwrappedModel(upChannelMetadata);

		boolean isNew = upChannelMetadata.isNew();

		UpChannelMetadataModelImpl upChannelMetadataModelImpl = (UpChannelMetadataModelImpl)upChannelMetadata;

		Session session = null;

		try {
			session = openSession();

			if (upChannelMetadata.isNew()) {
				session.save(upChannelMetadata);

				upChannelMetadata.setNew(false);
			}
			else {
				session.merge(upChannelMetadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UpChannelMetadataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((upChannelMetadataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						upChannelMetadataModelImpl.getOriginalCmtsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);

				args = new Object[] { upChannelMetadataModelImpl.getCmtsId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CMTS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CMTS,
					args);
			}
		}

		EntityCacheUtil.putResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
			UpChannelMetadataImpl.class, upChannelMetadata.getPrimaryKey(),
			upChannelMetadata);

		clearUniqueFindersCache(upChannelMetadata);
		cacheUniqueFindersCache(upChannelMetadata);

		return upChannelMetadata;
	}

	protected UpChannelMetadata toUnwrappedModel(
		UpChannelMetadata upChannelMetadata) {
		if (upChannelMetadata instanceof UpChannelMetadataImpl) {
			return upChannelMetadata;
		}

		UpChannelMetadataImpl upChannelMetadataImpl = new UpChannelMetadataImpl();

		upChannelMetadataImpl.setNew(upChannelMetadata.isNew());
		upChannelMetadataImpl.setPrimaryKey(upChannelMetadata.getPrimaryKey());

		upChannelMetadataImpl.setMetaId(upChannelMetadata.getMetaId());
		upChannelMetadataImpl.setCmtsId(upChannelMetadata.getCmtsId());
		upChannelMetadataImpl.setIfIndex(upChannelMetadata.getIfIndex());
		upChannelMetadataImpl.setDsFrequency(upChannelMetadata.getDsFrequency());
		upChannelMetadataImpl.setDsQam(upChannelMetadata.getDsQam());

		return upChannelMetadataImpl;
	}

	/**
	 * Returns the up channel metadata with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the up channel metadata
	 * @return the up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUpChannelMetadataException, SystemException {
		UpChannelMetadata upChannelMetadata = fetchByPrimaryKey(primaryKey);

		if (upChannelMetadata == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUpChannelMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return upChannelMetadata;
	}

	/**
	 * Returns the up channel metadata with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpChannelMetadataException} if it could not be found.
	 *
	 * @param metaId the primary key of the up channel metadata
	 * @return the up channel metadata
	 * @throws com.cmcti.cmts.domain.NoSuchUpChannelMetadataException if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata findByPrimaryKey(long metaId)
		throws NoSuchUpChannelMetadataException, SystemException {
		return findByPrimaryKey((Serializable)metaId);
	}

	/**
	 * Returns the up channel metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the up channel metadata
	 * @return the up channel metadata, or <code>null</code> if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UpChannelMetadata upChannelMetadata = (UpChannelMetadata)EntityCacheUtil.getResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
				UpChannelMetadataImpl.class, primaryKey);

		if (upChannelMetadata == _nullUpChannelMetadata) {
			return null;
		}

		if (upChannelMetadata == null) {
			Session session = null;

			try {
				session = openSession();

				upChannelMetadata = (UpChannelMetadata)session.get(UpChannelMetadataImpl.class,
						primaryKey);

				if (upChannelMetadata != null) {
					cacheResult(upChannelMetadata);
				}
				else {
					EntityCacheUtil.putResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
						UpChannelMetadataImpl.class, primaryKey,
						_nullUpChannelMetadata);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UpChannelMetadataModelImpl.ENTITY_CACHE_ENABLED,
					UpChannelMetadataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return upChannelMetadata;
	}

	/**
	 * Returns the up channel metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metaId the primary key of the up channel metadata
	 * @return the up channel metadata, or <code>null</code> if a up channel metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpChannelMetadata fetchByPrimaryKey(long metaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)metaId);
	}

	/**
	 * Returns all the up channel metadatas.
	 *
	 * @return the up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the up channel metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of up channel metadatas
	 * @param end the upper bound of the range of up channel metadatas (not inclusive)
	 * @return the range of up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the up channel metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpChannelMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of up channel metadatas
	 * @param end the upper bound of the range of up channel metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of up channel metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpChannelMetadata> findAll(int start, int end,
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

		List<UpChannelMetadata> list = (List<UpChannelMetadata>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPCHANNELMETADATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPCHANNELMETADATA;

				if (pagination) {
					sql = sql.concat(UpChannelMetadataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UpChannelMetadata>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpChannelMetadata>(list);
				}
				else {
					list = (List<UpChannelMetadata>)QueryUtil.list(q,
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
	 * Removes all the up channel metadatas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UpChannelMetadata upChannelMetadata : findAll()) {
			remove(upChannelMetadata);
		}
	}

	/**
	 * Returns the number of up channel metadatas.
	 *
	 * @return the number of up channel metadatas
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

				Query q = session.createQuery(_SQL_COUNT_UPCHANNELMETADATA);

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
	 * Initializes the up channel metadata persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.UpChannelMetadata")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UpChannelMetadata>> listenersList = new ArrayList<ModelListener<UpChannelMetadata>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UpChannelMetadata>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UpChannelMetadataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UPCHANNELMETADATA = "SELECT upChannelMetadata FROM UpChannelMetadata upChannelMetadata";
	private static final String _SQL_SELECT_UPCHANNELMETADATA_WHERE = "SELECT upChannelMetadata FROM UpChannelMetadata upChannelMetadata WHERE ";
	private static final String _SQL_COUNT_UPCHANNELMETADATA = "SELECT COUNT(upChannelMetadata) FROM UpChannelMetadata upChannelMetadata";
	private static final String _SQL_COUNT_UPCHANNELMETADATA_WHERE = "SELECT COUNT(upChannelMetadata) FROM UpChannelMetadata upChannelMetadata WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "upChannelMetadata.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpChannelMetadata exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UpChannelMetadata exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UpChannelMetadataPersistenceImpl.class);
	private static UpChannelMetadata _nullUpChannelMetadata = new UpChannelMetadataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UpChannelMetadata> toCacheModel() {
				return _nullUpChannelMetadataCacheModel;
			}
		};

	private static CacheModel<UpChannelMetadata> _nullUpChannelMetadataCacheModel =
		new CacheModel<UpChannelMetadata>() {
			@Override
			public UpChannelMetadata toEntityModel() {
				return _nullUpChannelMetadata;
			}
		};
}