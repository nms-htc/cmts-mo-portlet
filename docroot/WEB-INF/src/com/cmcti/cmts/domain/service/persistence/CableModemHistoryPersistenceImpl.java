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

import com.cmcti.cmts.domain.NoSuchCableModemHistoryException;
import com.cmcti.cmts.domain.model.CableModemHistory;
import com.cmcti.cmts.domain.model.impl.CableModemHistoryImpl;
import com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl;

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
 * The persistence implementation for the cable modem history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author richard
 * @see CableModemHistoryPersistence
 * @see CableModemHistoryUtil
 * @generated
 */
public class CableModemHistoryPersistenceImpl extends BasePersistenceImpl<CableModemHistory>
	implements CableModemHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CableModemHistoryUtil} to access the cable modem history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CableModemHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryModelImpl.FINDER_CACHE_ENABLED,
			CableModemHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryModelImpl.FINDER_CACHE_ENABLED,
			CableModemHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CableModemHistoryPersistenceImpl() {
		setModelClass(CableModemHistory.class);
	}

	/**
	 * Caches the cable modem history in the entity cache if it is enabled.
	 *
	 * @param cableModemHistory the cable modem history
	 */
	@Override
	public void cacheResult(CableModemHistory cableModemHistory) {
		EntityCacheUtil.putResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryImpl.class, cableModemHistory.getPrimaryKey(),
			cableModemHistory);

		cableModemHistory.resetOriginalValues();
	}

	/**
	 * Caches the cable modem histories in the entity cache if it is enabled.
	 *
	 * @param cableModemHistories the cable modem histories
	 */
	@Override
	public void cacheResult(List<CableModemHistory> cableModemHistories) {
		for (CableModemHistory cableModemHistory : cableModemHistories) {
			if (EntityCacheUtil.getResult(
						CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CableModemHistoryImpl.class,
						cableModemHistory.getPrimaryKey()) == null) {
				cacheResult(cableModemHistory);
			}
			else {
				cableModemHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cable modem histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CableModemHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CableModemHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cable modem history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CableModemHistory cableModemHistory) {
		EntityCacheUtil.removeResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryImpl.class, cableModemHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CableModemHistory> cableModemHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CableModemHistory cableModemHistory : cableModemHistories) {
			EntityCacheUtil.removeResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CableModemHistoryImpl.class, cableModemHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cable modem history with the primary key. Does not add the cable modem history to the database.
	 *
	 * @param cableModemHistoryPK the primary key for the new cable modem history
	 * @return the new cable modem history
	 */
	@Override
	public CableModemHistory create(CableModemHistoryPK cableModemHistoryPK) {
		CableModemHistory cableModemHistory = new CableModemHistoryImpl();

		cableModemHistory.setNew(true);
		cableModemHistory.setPrimaryKey(cableModemHistoryPK);

		return cableModemHistory;
	}

	/**
	 * Removes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cableModemHistoryPK the primary key of the cable modem history
	 * @return the cable modem history that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory remove(CableModemHistoryPK cableModemHistoryPK)
		throws NoSuchCableModemHistoryException, SystemException {
		return remove((Serializable)cableModemHistoryPK);
	}

	/**
	 * Removes the cable modem history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cable modem history
	 * @return the cable modem history that was removed
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory remove(Serializable primaryKey)
		throws NoSuchCableModemHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CableModemHistory cableModemHistory = (CableModemHistory)session.get(CableModemHistoryImpl.class,
					primaryKey);

			if (cableModemHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCableModemHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cableModemHistory);
		}
		catch (NoSuchCableModemHistoryException nsee) {
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
	protected CableModemHistory removeImpl(CableModemHistory cableModemHistory)
		throws SystemException {
		cableModemHistory = toUnwrappedModel(cableModemHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cableModemHistory)) {
				cableModemHistory = (CableModemHistory)session.get(CableModemHistoryImpl.class,
						cableModemHistory.getPrimaryKeyObj());
			}

			if (cableModemHistory != null) {
				session.delete(cableModemHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cableModemHistory != null) {
			clearCache(cableModemHistory);
		}

		return cableModemHistory;
	}

	@Override
	public CableModemHistory updateImpl(
		com.cmcti.cmts.domain.model.CableModemHistory cableModemHistory)
		throws SystemException {
		cableModemHistory = toUnwrappedModel(cableModemHistory);

		boolean isNew = cableModemHistory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cableModemHistory.isNew()) {
				session.save(cableModemHistory);

				cableModemHistory.setNew(false);
			}
			else {
				session.merge(cableModemHistory);
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

		EntityCacheUtil.putResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CableModemHistoryImpl.class, cableModemHistory.getPrimaryKey(),
			cableModemHistory);

		return cableModemHistory;
	}

	protected CableModemHistory toUnwrappedModel(
		CableModemHistory cableModemHistory) {
		if (cableModemHistory instanceof CableModemHistoryImpl) {
			return cableModemHistory;
		}

		CableModemHistoryImpl cableModemHistoryImpl = new CableModemHistoryImpl();

		cableModemHistoryImpl.setNew(cableModemHistory.isNew());
		cableModemHistoryImpl.setPrimaryKey(cableModemHistory.getPrimaryKey());

		cableModemHistoryImpl.setMacAddress(cableModemHistory.getMacAddress());
		cableModemHistoryImpl.setCreateDate(cableModemHistory.getCreateDate());
		cableModemHistoryImpl.setFecUncorrectable(cableModemHistory.getFecUncorrectable());
		cableModemHistoryImpl.setFecCorrected(cableModemHistory.getFecCorrected());
		cableModemHistoryImpl.setMicroRef(cableModemHistory.getMicroRef());
		cableModemHistoryImpl.setRxPower(cableModemHistory.getRxPower());
		cableModemHistoryImpl.setTxPower(cableModemHistory.getTxPower());
		cableModemHistoryImpl.setUsPower(cableModemHistory.getUsPower());
		cableModemHistoryImpl.setDsPower(cableModemHistory.getDsPower());
		cableModemHistoryImpl.setUncorrectables(cableModemHistory.getUncorrectables());
		cableModemHistoryImpl.setCorrecteds(cableModemHistory.getCorrecteds());
		cableModemHistoryImpl.setUnerroreds(cableModemHistory.getUnerroreds());
		cableModemHistoryImpl.setDsSNR(cableModemHistory.getDsSNR());
		cableModemHistoryImpl.setUsSNR(cableModemHistory.getUsSNR());
		cableModemHistoryImpl.setUcIfIndex(cableModemHistory.getUcIfIndex());
		cableModemHistoryImpl.setDcIfIndex(cableModemHistory.getDcIfIndex());
		cableModemHistoryImpl.setCmSubIndex(cableModemHistory.getCmSubIndex());
		cableModemHistoryImpl.setCmtsId(cableModemHistory.getCmtsId());
		cableModemHistoryImpl.setCmIndex(cableModemHistory.getCmIndex());

		return cableModemHistoryImpl;
	}

	/**
	 * Returns the cable modem history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cable modem history
	 * @return the cable modem history
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCableModemHistoryException, SystemException {
		CableModemHistory cableModemHistory = fetchByPrimaryKey(primaryKey);

		if (cableModemHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCableModemHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cableModemHistory;
	}

	/**
	 * Returns the cable modem history with the primary key or throws a {@link com.cmcti.cmts.domain.NoSuchCableModemHistoryException} if it could not be found.
	 *
	 * @param cableModemHistoryPK the primary key of the cable modem history
	 * @return the cable modem history
	 * @throws com.cmcti.cmts.domain.NoSuchCableModemHistoryException if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory findByPrimaryKey(
		CableModemHistoryPK cableModemHistoryPK)
		throws NoSuchCableModemHistoryException, SystemException {
		return findByPrimaryKey((Serializable)cableModemHistoryPK);
	}

	/**
	 * Returns the cable modem history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cable modem history
	 * @return the cable modem history, or <code>null</code> if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CableModemHistory cableModemHistory = (CableModemHistory)EntityCacheUtil.getResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CableModemHistoryImpl.class, primaryKey);

		if (cableModemHistory == _nullCableModemHistory) {
			return null;
		}

		if (cableModemHistory == null) {
			Session session = null;

			try {
				session = openSession();

				cableModemHistory = (CableModemHistory)session.get(CableModemHistoryImpl.class,
						primaryKey);

				if (cableModemHistory != null) {
					cacheResult(cableModemHistory);
				}
				else {
					EntityCacheUtil.putResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CableModemHistoryImpl.class, primaryKey,
						_nullCableModemHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CableModemHistoryModelImpl.ENTITY_CACHE_ENABLED,
					CableModemHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cableModemHistory;
	}

	/**
	 * Returns the cable modem history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cableModemHistoryPK the primary key of the cable modem history
	 * @return the cable modem history, or <code>null</code> if a cable modem history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CableModemHistory fetchByPrimaryKey(
		CableModemHistoryPK cableModemHistoryPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)cableModemHistoryPK);
	}

	/**
	 * Returns all the cable modem histories.
	 *
	 * @return the cable modem histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModemHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cable modem histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cable modem histories
	 * @param end the upper bound of the range of cable modem histories (not inclusive)
	 * @return the range of cable modem histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModemHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cable modem histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cmcti.cmts.domain.model.impl.CableModemHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cable modem histories
	 * @param end the upper bound of the range of cable modem histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cable modem histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CableModemHistory> findAll(int start, int end,
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

		List<CableModemHistory> list = (List<CableModemHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CABLEMODEMHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CABLEMODEMHISTORY;

				if (pagination) {
					sql = sql.concat(CableModemHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CableModemHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CableModemHistory>(list);
				}
				else {
					list = (List<CableModemHistory>)QueryUtil.list(q,
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
	 * Removes all the cable modem histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CableModemHistory cableModemHistory : findAll()) {
			remove(cableModemHistory);
		}
	}

	/**
	 * Returns the number of cable modem histories.
	 *
	 * @return the number of cable modem histories
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

				Query q = session.createQuery(_SQL_COUNT_CABLEMODEMHISTORY);

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
	 * Initializes the cable modem history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmcti.cmts.domain.model.CableModemHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CableModemHistory>> listenersList = new ArrayList<ModelListener<CableModemHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CableModemHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CableModemHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CABLEMODEMHISTORY = "SELECT cableModemHistory FROM CableModemHistory cableModemHistory";
	private static final String _SQL_COUNT_CABLEMODEMHISTORY = "SELECT COUNT(cableModemHistory) FROM CableModemHistory cableModemHistory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cableModemHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CableModemHistory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CableModemHistoryPersistenceImpl.class);
	private static CableModemHistory _nullCableModemHistory = new CableModemHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CableModemHistory> toCacheModel() {
				return _nullCableModemHistoryCacheModel;
			}
		};

	private static CacheModel<CableModemHistory> _nullCableModemHistoryCacheModel =
		new CacheModel<CableModemHistory>() {
			@Override
			public CableModemHistory toEntityModel() {
				return _nullCableModemHistory;
			}
		};
}