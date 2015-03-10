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

import com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException;
import com.cmcti.cmts.domain.model.UpstreamChannelHistory;
import com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryImpl;
import com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the upstream channel history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see UpstreamChannelHistoryPersistence
 * @see UpstreamChannelHistoryUtil
 * @generated
 */
public class UpstreamChannelHistoryPersistenceImpl extends BasePersistenceImpl<UpstreamChannelHistory>
	implements UpstreamChannelHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpstreamChannelHistoryUtil} to access the upstream channel history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpstreamChannelHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryModelImpl.FINDER_CACHE_ENABLED,
			UpstreamChannelHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UpstreamChannelHistoryPersistenceImpl() {
		setModelClass(UpstreamChannelHistory.class);
	}

	/**
	 * Caches the upstream channel history in the entity cache if it is enabled.
	 *
	 * @param upstreamChannelHistory the upstream channel history
	 */
	@Override
	public void cacheResult(UpstreamChannelHistory upstreamChannelHistory) {
		EntityCacheUtil.putResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryImpl.class,
			upstreamChannelHistory.getPrimaryKey(), upstreamChannelHistory);

		upstreamChannelHistory.resetOriginalValues();
	}

	/**
	 * Caches the upstream channel histories in the entity cache if it is enabled.
	 *
	 * @param upstreamChannelHistories the upstream channel histories
	 */
	@Override
	public void cacheResult(
		List<UpstreamChannelHistory> upstreamChannelHistories) {
		for (UpstreamChannelHistory upstreamChannelHistory : upstreamChannelHistories) {
			if (EntityCacheUtil.getResult(
						UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
						UpstreamChannelHistoryImpl.class,
						upstreamChannelHistory.getPrimaryKey()) == null) {
				cacheResult(upstreamChannelHistory);
			}
			else {
				upstreamChannelHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all upstream channel histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UpstreamChannelHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UpstreamChannelHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the upstream channel history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UpstreamChannelHistory upstreamChannelHistory) {
		EntityCacheUtil.removeResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryImpl.class,
			upstreamChannelHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<UpstreamChannelHistory> upstreamChannelHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpstreamChannelHistory upstreamChannelHistory : upstreamChannelHistories) {
			EntityCacheUtil.removeResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
				UpstreamChannelHistoryImpl.class,
				upstreamChannelHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new upstream channel history with the primary key. Does not add the upstream channel history to the database.
	 *
	 * @param upstreamChannelHistoryPK the primary key for the new upstream channel history
	 * @return the new upstream channel history
	 */
	@Override
	public UpstreamChannelHistory create(
		UpstreamChannelHistoryPK upstreamChannelHistoryPK) {
		UpstreamChannelHistory upstreamChannelHistory = new UpstreamChannelHistoryImpl();

		upstreamChannelHistory.setNew(true);
		upstreamChannelHistory.setPrimaryKey(upstreamChannelHistoryPK);

		return upstreamChannelHistory;
	}

	/**
	 * Removes the upstream channel history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param upstreamChannelHistoryPK the primary key of the upstream channel history
	 * @return the upstream channel history that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory remove(
		UpstreamChannelHistoryPK upstreamChannelHistoryPK)
		throws NoSuchUpstreamChannelHistoryException, SystemException {
		return remove((Serializable)upstreamChannelHistoryPK);
	}

	/**
	 * Removes the upstream channel history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upstream channel history
	 * @return the upstream channel history that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory remove(Serializable primaryKey)
		throws NoSuchUpstreamChannelHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UpstreamChannelHistory upstreamChannelHistory = (UpstreamChannelHistory)session.get(UpstreamChannelHistoryImpl.class,
					primaryKey);

			if (upstreamChannelHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpstreamChannelHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(upstreamChannelHistory);
		}
		catch (NoSuchUpstreamChannelHistoryException nsee) {
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
	protected UpstreamChannelHistory removeImpl(
		UpstreamChannelHistory upstreamChannelHistory)
		throws SystemException {
		upstreamChannelHistory = toUnwrappedModel(upstreamChannelHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(upstreamChannelHistory)) {
				upstreamChannelHistory = (UpstreamChannelHistory)session.get(UpstreamChannelHistoryImpl.class,
						upstreamChannelHistory.getPrimaryKeyObj());
			}

			if (upstreamChannelHistory != null) {
				session.delete(upstreamChannelHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (upstreamChannelHistory != null) {
			clearCache(upstreamChannelHistory);
		}

		return upstreamChannelHistory;
	}

	@Override
	public UpstreamChannelHistory updateImpl(
		com.cmcti.cmts.domain.model.UpstreamChannelHistory upstreamChannelHistory)
		throws SystemException {
		upstreamChannelHistory = toUnwrappedModel(upstreamChannelHistory);

		boolean isNew = upstreamChannelHistory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (upstreamChannelHistory.isNew()) {
				session.save(upstreamChannelHistory);

				upstreamChannelHistory.setNew(false);
			}
			else {
				session.merge(upstreamChannelHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
			UpstreamChannelHistoryImpl.class,
			upstreamChannelHistory.getPrimaryKey(), upstreamChannelHistory);

		return upstreamChannelHistory;
	}

	protected UpstreamChannelHistory toUnwrappedModel(
		UpstreamChannelHistory upstreamChannelHistory) {
		if (upstreamChannelHistory instanceof UpstreamChannelHistoryImpl) {
			return upstreamChannelHistory;
		}

		UpstreamChannelHistoryImpl upstreamChannelHistoryImpl = new UpstreamChannelHistoryImpl();

		upstreamChannelHistoryImpl.setNew(upstreamChannelHistory.isNew());
		upstreamChannelHistoryImpl.setPrimaryKey(upstreamChannelHistory.getPrimaryKey());

		upstreamChannelHistoryImpl.setCmtsId(upstreamChannelHistory.getCmtsId());
		upstreamChannelHistoryImpl.setIfIndex(upstreamChannelHistory.getIfIndex());
		upstreamChannelHistoryImpl.setCreateDate(upstreamChannelHistory.getCreateDate());
		upstreamChannelHistoryImpl.setQam(upstreamChannelHistory.getQam());
		upstreamChannelHistoryImpl.setAvgOnlineCmDsPower(upstreamChannelHistory.getAvgOnlineCmDsPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmUsPower(upstreamChannelHistory.getAvgOnlineCmUsPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmMicRef(upstreamChannelHistory.getAvgOnlineCmMicRef());
		upstreamChannelHistoryImpl.setAvgOnlineCmTxPower(upstreamChannelHistory.getAvgOnlineCmTxPower());
		upstreamChannelHistoryImpl.setAvgOnlineCmRxPower(upstreamChannelHistory.getAvgOnlineCmRxPower());
		upstreamChannelHistoryImpl.setFecUncorrectable(upstreamChannelHistory.getFecUncorrectable());
		upstreamChannelHistoryImpl.setFecCorrected(upstreamChannelHistory.getFecCorrected());
		upstreamChannelHistoryImpl.setUpChannelCmTotal(upstreamChannelHistory.getUpChannelCmTotal());
		upstreamChannelHistoryImpl.setUpChannelCmRegistered(upstreamChannelHistory.getUpChannelCmRegistered());
		upstreamChannelHistoryImpl.setUpChannelCmActive(upstreamChannelHistory.getUpChannelCmActive());
		upstreamChannelHistoryImpl.setUpChannelModProfile(upstreamChannelHistory.getUpChannelModProfile());
		upstreamChannelHistoryImpl.setUpChannelWidth(upstreamChannelHistory.getUpChannelWidth());
		upstreamChannelHistoryImpl.setUpChannelFrequency(upstreamChannelHistory.getUpChannelFrequency());
		upstreamChannelHistoryImpl.setIfSigQUncorrectables(upstreamChannelHistory.getIfSigQUncorrectables());
		upstreamChannelHistoryImpl.setIfSigQCorrecteds(upstreamChannelHistory.getIfSigQCorrecteds());
		upstreamChannelHistoryImpl.setIfSigQUnerroreds(upstreamChannelHistory.getIfSigQUnerroreds());
		upstreamChannelHistoryImpl.setIfSigQSNR(upstreamChannelHistory.getIfSigQSNR());
		upstreamChannelHistoryImpl.setIfAlias(upstreamChannelHistory.getIfAlias());
		upstreamChannelHistoryImpl.setIfDesc(upstreamChannelHistory.getIfDesc());

		return upstreamChannelHistoryImpl;
	}

	/**
	 * Returns the upstream channel history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the upstream channel history
	 * @return the upstream channel history
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUpstreamChannelHistoryException, SystemException {
		UpstreamChannelHistory upstreamChannelHistory = fetchByPrimaryKey(primaryKey);

		if (upstreamChannelHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUpstreamChannelHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return upstreamChannelHistory;
	}

	/**
	 * Returns the upstream channel history with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException} if it could not be found.
	 *
	 * @param upstreamChannelHistoryPK the primary key of the upstream channel history
	 * @return the upstream channel history
	 * @throws com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory findByPrimaryKey(
		UpstreamChannelHistoryPK upstreamChannelHistoryPK)
		throws NoSuchUpstreamChannelHistoryException, SystemException {
		return findByPrimaryKey((Serializable)upstreamChannelHistoryPK);
	}

	/**
	 * Returns the upstream channel history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upstream channel history
	 * @return the upstream channel history, or <code>null</code> if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UpstreamChannelHistory upstreamChannelHistory = (UpstreamChannelHistory)EntityCacheUtil.getResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
				UpstreamChannelHistoryImpl.class, primaryKey);

		if (upstreamChannelHistory == _nullUpstreamChannelHistory) {
			return null;
		}

		if (upstreamChannelHistory == null) {
			Session session = null;

			try {
				session = openSession();

				upstreamChannelHistory = (UpstreamChannelHistory)session.get(UpstreamChannelHistoryImpl.class,
						primaryKey);

				if (upstreamChannelHistory != null) {
					cacheResult(upstreamChannelHistory);
				}
				else {
					EntityCacheUtil.putResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
						UpstreamChannelHistoryImpl.class, primaryKey,
						_nullUpstreamChannelHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UpstreamChannelHistoryModelImpl.ENTITY_CACHE_ENABLED,
					UpstreamChannelHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return upstreamChannelHistory;
	}

	/**
	 * Returns the upstream channel history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param upstreamChannelHistoryPK the primary key of the upstream channel history
	 * @return the upstream channel history, or <code>null</code> if a upstream channel history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UpstreamChannelHistory fetchByPrimaryKey(
		UpstreamChannelHistoryPK upstreamChannelHistoryPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)upstreamChannelHistoryPK);
	}

	/**
	 * Returns all the upstream channel histories.
	 *
	 * @return the upstream channel histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannelHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upstream channel histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upstream channel histories
	 * @param end the upper bound of the range of upstream channel histories (not inclusive)
	 * @return the range of upstream channel histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannelHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the upstream channel histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upstream channel histories
	 * @param end the upper bound of the range of upstream channel histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upstream channel histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UpstreamChannelHistory> findAll(int start, int end,
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

		List<UpstreamChannelHistory> list = (List<UpstreamChannelHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPSTREAMCHANNELHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPSTREAMCHANNELHISTORY;

				if (pagination) {
					sql = sql.concat(UpstreamChannelHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UpstreamChannelHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UpstreamChannelHistory>(list);
				}
				else {
					list = (List<UpstreamChannelHistory>)QueryUtil.list(q,
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
	 * Removes all the upstream channel histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UpstreamChannelHistory upstreamChannelHistory : findAll()) {
			remove(upstreamChannelHistory);
		}
	}

	/**
	 * Returns the number of upstream channel histories.
	 *
	 * @return the number of upstream channel histories
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

				Query q = session.createQuery(_SQL_COUNT_UPSTREAMCHANNELHISTORY);

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
	 * Initializes the upstream channel history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.UpstreamChannelHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UpstreamChannelHistory>> listenersList = new ArrayList<ModelListener<UpstreamChannelHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UpstreamChannelHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UpstreamChannelHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UPSTREAMCHANNELHISTORY = "SELECT upstreamChannelHistory FROM UpstreamChannelHistory upstreamChannelHistory";
	private static final String _SQL_COUNT_UPSTREAMCHANNELHISTORY = "SELECT COUNT(upstreamChannelHistory) FROM UpstreamChannelHistory upstreamChannelHistory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "upstreamChannelHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpstreamChannelHistory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UpstreamChannelHistoryPersistenceImpl.class);
	private static UpstreamChannelHistory _nullUpstreamChannelHistory = new UpstreamChannelHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UpstreamChannelHistory> toCacheModel() {
				return _nullUpstreamChannelHistoryCacheModel;
			}
		};

	private static CacheModel<UpstreamChannelHistory> _nullUpstreamChannelHistoryCacheModel =
		new CacheModel<UpstreamChannelHistory>() {
			@Override
			public UpstreamChannelHistory toEntityModel() {
				return _nullUpstreamChannelHistory;
			}
		};
}