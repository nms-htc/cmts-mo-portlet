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

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
	private static final String _SQL_COUNT_UPSTREAMCHANNEL = "SELECT COUNT(upstreamChannel) FROM UpstreamChannel upstreamChannel";
	private static final String _ORDER_BY_ENTITY_ALIAS = "upstreamChannel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpstreamChannel exists with the primary key ";
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