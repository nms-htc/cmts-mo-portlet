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

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
	private static final String _SQL_COUNT_CABLEMODEM = "SELECT COUNT(cableModem) FROM CableModem cableModem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cableModem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CableModem exists with the primary key ";
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