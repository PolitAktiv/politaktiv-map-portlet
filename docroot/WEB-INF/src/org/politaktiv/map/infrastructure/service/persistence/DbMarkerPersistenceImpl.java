/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.politaktiv.map.infrastructure.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.service.ServiceProps;

import org.politaktiv.map.infrastructure.NoSuchDbMarkerException;
import org.politaktiv.map.infrastructure.model.DbMarker;
import org.politaktiv.map.infrastructure.model.impl.DbMarkerImpl;
import org.politaktiv.map.infrastructure.model.impl.DbMarkerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the db marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMarkerPersistence
 * @see DbMarkerUtil
 * @generated
 */
public class DbMarkerPersistenceImpl extends BasePersistenceImpl<DbMarker>
	implements DbMarkerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DbMarkerUtil} to access the db marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DbMarkerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_MARKERID = new FinderPath(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerModelImpl.FINDER_CACHE_ENABLED, DbMarkerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBymarkerId",
			new String[] { Long.class.getName() },
			DbMarkerModelImpl.MARKERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MARKERID = new FinderPath(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymarkerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerModelImpl.FINDER_CACHE_ENABLED, DbMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerModelImpl.FINDER_CACHE_ENABLED, DbMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the db marker in the entity cache if it is enabled.
	 *
	 * @param dbMarker the db marker
	 */
	public void cacheResult(DbMarker dbMarker) {
		EntityCacheUtil.putResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerImpl.class, dbMarker.getPrimaryKey(), dbMarker);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MARKERID,
			new Object[] { Long.valueOf(dbMarker.getMarkerId()) }, dbMarker);

		dbMarker.resetOriginalValues();
	}

	/**
	 * Caches the db markers in the entity cache if it is enabled.
	 *
	 * @param dbMarkers the db markers
	 */
	public void cacheResult(List<DbMarker> dbMarkers) {
		for (DbMarker dbMarker : dbMarkers) {
			if (EntityCacheUtil.getResult(
						DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
						DbMarkerImpl.class, dbMarker.getPrimaryKey()) == null) {
				cacheResult(dbMarker);
			}
			else {
				dbMarker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all db markers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DbMarkerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DbMarkerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the db marker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DbMarker dbMarker) {
		EntityCacheUtil.removeResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerImpl.class, dbMarker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dbMarker);
	}

	@Override
	public void clearCache(List<DbMarker> dbMarkers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DbMarker dbMarker : dbMarkers) {
			EntityCacheUtil.removeResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
				DbMarkerImpl.class, dbMarker.getPrimaryKey());

			clearUniqueFindersCache(dbMarker);
		}
	}

	protected void clearUniqueFindersCache(DbMarker dbMarker) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MARKERID,
			new Object[] { Long.valueOf(dbMarker.getMarkerId()) });
	}

	/**
	 * Creates a new db marker with the primary key. Does not add the db marker to the database.
	 *
	 * @param markerId the primary key for the new db marker
	 * @return the new db marker
	 */
	public DbMarker create(long markerId) {
		DbMarker dbMarker = new DbMarkerImpl();

		dbMarker.setNew(true);
		dbMarker.setPrimaryKey(markerId);

		return dbMarker;
	}

	/**
	 * Removes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerId the primary key of the db marker
	 * @return the db marker that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker remove(long markerId)
		throws NoSuchDbMarkerException, SystemException {
		return remove(Long.valueOf(markerId));
	}

	/**
	 * Removes the db marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the db marker
	 * @return the db marker that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMarker remove(Serializable primaryKey)
		throws NoSuchDbMarkerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DbMarker dbMarker = (DbMarker)session.get(DbMarkerImpl.class,
					primaryKey);

			if (dbMarker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDbMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dbMarker);
		}
		catch (NoSuchDbMarkerException nsee) {
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
	protected DbMarker removeImpl(DbMarker dbMarker) throws SystemException {
		dbMarker = toUnwrappedModel(dbMarker);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dbMarker);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dbMarker);

		return dbMarker;
	}

	@Override
	public DbMarker updateImpl(DbMarker dbMarker, boolean merge)
		throws SystemException {
		dbMarker = toUnwrappedModel(dbMarker);

		boolean isNew = dbMarker.isNew();

		DbMarkerModelImpl dbMarkerModelImpl = (DbMarkerModelImpl)dbMarker;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dbMarker, merge);

			dbMarker.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DbMarkerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
			DbMarkerImpl.class, dbMarker.getPrimaryKey(), dbMarker);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MARKERID,
				new Object[] { Long.valueOf(dbMarker.getMarkerId()) }, dbMarker);
		}
		else {
			if ((dbMarkerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MARKERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dbMarkerModelImpl.getOriginalMarkerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MARKERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MARKERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MARKERID,
					new Object[] { Long.valueOf(dbMarker.getMarkerId()) },
					dbMarker);
			}
		}

		return dbMarker;
	}

	protected DbMarker toUnwrappedModel(DbMarker dbMarker) {
		if (dbMarker instanceof DbMarkerImpl) {
			return dbMarker;
		}

		DbMarkerImpl dbMarkerImpl = new DbMarkerImpl();

		dbMarkerImpl.setNew(dbMarker.isNew());
		dbMarkerImpl.setPrimaryKey(dbMarker.getPrimaryKey());

		dbMarkerImpl.setMarkerId(dbMarker.getMarkerId());
		dbMarkerImpl.setMarkerImageName(dbMarker.getMarkerImageName());
		dbMarkerImpl.setPointId(dbMarker.getPointId());

		return dbMarkerImpl;
	}

	/**
	 * Returns the db marker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the db marker
	 * @return the db marker
	 * @throws com.liferay.portal.NoSuchModelException if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMarker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db marker with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbMarkerException} if it could not be found.
	 *
	 * @param markerId the primary key of the db marker
	 * @return the db marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker findByPrimaryKey(long markerId)
		throws NoSuchDbMarkerException, SystemException {
		DbMarker dbMarker = fetchByPrimaryKey(markerId);

		if (dbMarker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + markerId);
			}

			throw new NoSuchDbMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				markerId);
		}

		return dbMarker;
	}

	/**
	 * Returns the db marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the db marker
	 * @return the db marker, or <code>null</code> if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMarker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param markerId the primary key of the db marker
	 * @return the db marker, or <code>null</code> if a db marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker fetchByPrimaryKey(long markerId) throws SystemException {
		DbMarker dbMarker = (DbMarker)EntityCacheUtil.getResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
				DbMarkerImpl.class, markerId);

		if (dbMarker == _nullDbMarker) {
			return null;
		}

		if (dbMarker == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dbMarker = (DbMarker)session.get(DbMarkerImpl.class,
						Long.valueOf(markerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dbMarker != null) {
					cacheResult(dbMarker);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DbMarkerModelImpl.ENTITY_CACHE_ENABLED,
						DbMarkerImpl.class, markerId, _nullDbMarker);
				}

				closeSession(session);
			}
		}

		return dbMarker;
	}

	/**
	 * Returns the db marker where markerId = &#63; or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbMarkerException} if it could not be found.
	 *
	 * @param markerId the marker ID
	 * @return the matching db marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMarkerException if a matching db marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker findBymarkerId(long markerId)
		throws NoSuchDbMarkerException, SystemException {
		DbMarker dbMarker = fetchBymarkerId(markerId);

		if (dbMarker == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("markerId=");
			msg.append(markerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDbMarkerException(msg.toString());
		}

		return dbMarker;
	}

	/**
	 * Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param markerId the marker ID
	 * @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker fetchBymarkerId(long markerId) throws SystemException {
		return fetchBymarkerId(markerId, true);
	}

	/**
	 * Returns the db marker where markerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param markerId the marker ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching db marker, or <code>null</code> if a matching db marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMarker fetchBymarkerId(long markerId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { markerId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MARKERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DBMARKER_WHERE);

			query.append(_FINDER_COLUMN_MARKERID_MARKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(markerId);

				List<DbMarker> list = q.list();

				result = list;

				DbMarker dbMarker = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MARKERID,
						finderArgs, list);
				}
				else {
					dbMarker = list.get(0);

					cacheResult(dbMarker);

					if ((dbMarker.getMarkerId() != markerId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MARKERID,
							finderArgs, dbMarker);
					}
				}

				return dbMarker;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MARKERID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (DbMarker)result;
			}
		}
	}

	/**
	 * Returns all the db markers.
	 *
	 * @return the db markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMarker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the db markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db markers
	 * @param end the upper bound of the range of db markers (not inclusive)
	 * @return the range of db markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMarker> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the db markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db markers
	 * @param end the upper bound of the range of db markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of db markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMarker> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DbMarker> list = (List<DbMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DBMARKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DBMARKER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DbMarker>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DbMarker>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the db marker where markerId = &#63; from the database.
	 *
	 * @param markerId the marker ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBymarkerId(long markerId)
		throws NoSuchDbMarkerException, SystemException {
		DbMarker dbMarker = findBymarkerId(markerId);

		remove(dbMarker);
	}

	/**
	 * Removes all the db markers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DbMarker dbMarker : findAll()) {
			remove(dbMarker);
		}
	}

	/**
	 * Returns the number of db markers where markerId = &#63;.
	 *
	 * @param markerId the marker ID
	 * @return the number of matching db markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countBymarkerId(long markerId) throws SystemException {
		Object[] finderArgs = new Object[] { markerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MARKERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DBMARKER_WHERE);

			query.append(_FINDER_COLUMN_MARKERID_MARKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(markerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MARKERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of db markers.
	 *
	 * @return the number of db markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DBMARKER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the db marker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.DbMarker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DbMarker>> listenersList = new ArrayList<ModelListener<DbMarker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DbMarker>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DbMarkerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DbMapObjectPersistence.class)
	protected DbMapObjectPersistence dbMapObjectPersistence;
	@BeanReference(type = DbMarkerPersistence.class)
	protected DbMarkerPersistence dbMarkerPersistence;
	@BeanReference(type = DbPicturePersistence.class)
	protected DbPicturePersistence dbPicturePersistence;
	@BeanReference(type = DbPointPersistence.class)
	protected DbPointPersistence dbPointPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DBMARKER = "SELECT dbMarker FROM DbMarker dbMarker";
	private static final String _SQL_SELECT_DBMARKER_WHERE = "SELECT dbMarker FROM DbMarker dbMarker WHERE ";
	private static final String _SQL_COUNT_DBMARKER = "SELECT COUNT(dbMarker) FROM DbMarker dbMarker";
	private static final String _SQL_COUNT_DBMARKER_WHERE = "SELECT COUNT(dbMarker) FROM DbMarker dbMarker WHERE ";
	private static final String _FINDER_COLUMN_MARKERID_MARKERID_2 = "dbMarker.markerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dbMarker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DbMarker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DbMarker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DbMarkerPersistenceImpl.class);
	private static DbMarker _nullDbMarker = new DbMarkerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DbMarker> toCacheModel() {
				return _nullDbMarkerCacheModel;
			}
		};

	private static CacheModel<DbMarker> _nullDbMarkerCacheModel = new CacheModel<DbMarker>() {
			public DbMarker toEntityModel() {
				return _nullDbMarker;
			}
		};
}