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

import org.politaktiv.map.infrastructure.NoSuchDbPointException;
import org.politaktiv.map.infrastructure.model.DbPoint;
import org.politaktiv.map.infrastructure.model.impl.DbPointImpl;
import org.politaktiv.map.infrastructure.model.impl.DbPointModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the db point service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbPointPersistence
 * @see DbPointUtil
 * @generated
 */
public class DbPointPersistenceImpl extends BasePersistenceImpl<DbPoint>
	implements DbPointPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DbPointUtil} to access the db point persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DbPointImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_POINTID = new FinderPath(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointModelImpl.FINDER_CACHE_ENABLED, DbPointImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBypointId",
			new String[] { Long.class.getName() },
			DbPointModelImpl.POINTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POINTID = new FinderPath(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypointId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointModelImpl.FINDER_CACHE_ENABLED, DbPointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointModelImpl.FINDER_CACHE_ENABLED, DbPointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the db point in the entity cache if it is enabled.
	 *
	 * @param dbPoint the db point
	 */
	public void cacheResult(DbPoint dbPoint) {
		EntityCacheUtil.putResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointImpl.class, dbPoint.getPrimaryKey(), dbPoint);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POINTID,
			new Object[] { Long.valueOf(dbPoint.getPointId()) }, dbPoint);

		dbPoint.resetOriginalValues();
	}

	/**
	 * Caches the db points in the entity cache if it is enabled.
	 *
	 * @param dbPoints the db points
	 */
	public void cacheResult(List<DbPoint> dbPoints) {
		for (DbPoint dbPoint : dbPoints) {
			if (EntityCacheUtil.getResult(
						DbPointModelImpl.ENTITY_CACHE_ENABLED,
						DbPointImpl.class, dbPoint.getPrimaryKey()) == null) {
				cacheResult(dbPoint);
			}
			else {
				dbPoint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all db points.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DbPointImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DbPointImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the db point.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DbPoint dbPoint) {
		EntityCacheUtil.removeResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointImpl.class, dbPoint.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dbPoint);
	}

	@Override
	public void clearCache(List<DbPoint> dbPoints) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DbPoint dbPoint : dbPoints) {
			EntityCacheUtil.removeResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
				DbPointImpl.class, dbPoint.getPrimaryKey());

			clearUniqueFindersCache(dbPoint);
		}
	}

	protected void clearUniqueFindersCache(DbPoint dbPoint) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POINTID,
			new Object[] { Long.valueOf(dbPoint.getPointId()) });
	}

	/**
	 * Creates a new db point with the primary key. Does not add the db point to the database.
	 *
	 * @param pointId the primary key for the new db point
	 * @return the new db point
	 */
	public DbPoint create(long pointId) {
		DbPoint dbPoint = new DbPointImpl();

		dbPoint.setNew(true);
		dbPoint.setPrimaryKey(pointId);

		return dbPoint;
	}

	/**
	 * Removes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pointId the primary key of the db point
	 * @return the db point that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPointException if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint remove(long pointId)
		throws NoSuchDbPointException, SystemException {
		return remove(Long.valueOf(pointId));
	}

	/**
	 * Removes the db point with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the db point
	 * @return the db point that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPointException if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPoint remove(Serializable primaryKey)
		throws NoSuchDbPointException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DbPoint dbPoint = (DbPoint)session.get(DbPointImpl.class, primaryKey);

			if (dbPoint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDbPointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dbPoint);
		}
		catch (NoSuchDbPointException nsee) {
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
	protected DbPoint removeImpl(DbPoint dbPoint) throws SystemException {
		dbPoint = toUnwrappedModel(dbPoint);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dbPoint);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dbPoint);

		return dbPoint;
	}

	@Override
	public DbPoint updateImpl(
		org.politaktiv.map.infrastructure.model.DbPoint dbPoint, boolean merge)
		throws SystemException {
		dbPoint = toUnwrappedModel(dbPoint);

		boolean isNew = dbPoint.isNew();

		DbPointModelImpl dbPointModelImpl = (DbPointModelImpl)dbPoint;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dbPoint, merge);

			dbPoint.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DbPointModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
			DbPointImpl.class, dbPoint.getPrimaryKey(), dbPoint);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POINTID,
				new Object[] { Long.valueOf(dbPoint.getPointId()) }, dbPoint);
		}
		else {
			if ((dbPointModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_POINTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dbPointModelImpl.getOriginalPointId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POINTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POINTID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POINTID,
					new Object[] { Long.valueOf(dbPoint.getPointId()) }, dbPoint);
			}
		}

		return dbPoint;
	}

	protected DbPoint toUnwrappedModel(DbPoint dbPoint) {
		if (dbPoint instanceof DbPointImpl) {
			return dbPoint;
		}

		DbPointImpl dbPointImpl = new DbPointImpl();

		dbPointImpl.setNew(dbPoint.isNew());
		dbPointImpl.setPrimaryKey(dbPoint.getPrimaryKey());

		dbPointImpl.setPointId(dbPoint.getPointId());
		dbPointImpl.setLongitude(dbPoint.getLongitude());
		dbPointImpl.setLatitude(dbPoint.getLatitude());

		return dbPointImpl;
	}

	/**
	 * Returns the db point with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the db point
	 * @return the db point
	 * @throws com.liferay.portal.NoSuchModelException if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPoint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db point with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPointException} if it could not be found.
	 *
	 * @param pointId the primary key of the db point
	 * @return the db point
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPointException if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint findByPrimaryKey(long pointId)
		throws NoSuchDbPointException, SystemException {
		DbPoint dbPoint = fetchByPrimaryKey(pointId);

		if (dbPoint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pointId);
			}

			throw new NoSuchDbPointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pointId);
		}

		return dbPoint;
	}

	/**
	 * Returns the db point with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the db point
	 * @return the db point, or <code>null</code> if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPoint fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db point with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pointId the primary key of the db point
	 * @return the db point, or <code>null</code> if a db point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint fetchByPrimaryKey(long pointId) throws SystemException {
		DbPoint dbPoint = (DbPoint)EntityCacheUtil.getResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
				DbPointImpl.class, pointId);

		if (dbPoint == _nullDbPoint) {
			return null;
		}

		if (dbPoint == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dbPoint = (DbPoint)session.get(DbPointImpl.class,
						Long.valueOf(pointId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dbPoint != null) {
					cacheResult(dbPoint);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DbPointModelImpl.ENTITY_CACHE_ENABLED,
						DbPointImpl.class, pointId, _nullDbPoint);
				}

				closeSession(session);
			}
		}

		return dbPoint;
	}

	/**
	 * Returns the db point where pointId = &#63; or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPointException} if it could not be found.
	 *
	 * @param pointId the point ID
	 * @return the matching db point
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPointException if a matching db point could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint findBypointId(long pointId)
		throws NoSuchDbPointException, SystemException {
		DbPoint dbPoint = fetchBypointId(pointId);

		if (dbPoint == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pointId=");
			msg.append(pointId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDbPointException(msg.toString());
		}

		return dbPoint;
	}

	/**
	 * Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pointId the point ID
	 * @return the matching db point, or <code>null</code> if a matching db point could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint fetchBypointId(long pointId) throws SystemException {
		return fetchBypointId(pointId, true);
	}

	/**
	 * Returns the db point where pointId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pointId the point ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching db point, or <code>null</code> if a matching db point could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPoint fetchBypointId(long pointId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { pointId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_POINTID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DBPOINT_WHERE);

			query.append(_FINDER_COLUMN_POINTID_POINTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pointId);

				List<DbPoint> list = q.list();

				result = list;

				DbPoint dbPoint = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POINTID,
						finderArgs, list);
				}
				else {
					dbPoint = list.get(0);

					cacheResult(dbPoint);

					if ((dbPoint.getPointId() != pointId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POINTID,
							finderArgs, dbPoint);
					}
				}

				return dbPoint;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POINTID,
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
				return (DbPoint)result;
			}
		}
	}

	/**
	 * Returns all the db points.
	 *
	 * @return the db points
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPoint> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the db points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db points
	 * @param end the upper bound of the range of db points (not inclusive)
	 * @return the range of db points
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPoint> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the db points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db points
	 * @param end the upper bound of the range of db points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of db points
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPoint> findAll(int start, int end,
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

		List<DbPoint> list = (List<DbPoint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DBPOINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DBPOINT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DbPoint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DbPoint>)QueryUtil.list(q, getDialect(),
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
	 * Removes the db point where pointId = &#63; from the database.
	 *
	 * @param pointId the point ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBypointId(long pointId)
		throws NoSuchDbPointException, SystemException {
		DbPoint dbPoint = findBypointId(pointId);

		remove(dbPoint);
	}

	/**
	 * Removes all the db points from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DbPoint dbPoint : findAll()) {
			remove(dbPoint);
		}
	}

	/**
	 * Returns the number of db points where pointId = &#63;.
	 *
	 * @param pointId the point ID
	 * @return the number of matching db points
	 * @throws SystemException if a system exception occurred
	 */
	public int countBypointId(long pointId) throws SystemException {
		Object[] finderArgs = new Object[] { pointId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POINTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DBPOINT_WHERE);

			query.append(_FINDER_COLUMN_POINTID_POINTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pointId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POINTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of db points.
	 *
	 * @return the number of db points
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DBPOINT);

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
	 * Initializes the db point persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.DbPoint")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DbPoint>> listenersList = new ArrayList<ModelListener<DbPoint>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DbPoint>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DbPointImpl.class.getName());
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
	private static final String _SQL_SELECT_DBPOINT = "SELECT dbPoint FROM DbPoint dbPoint";
	private static final String _SQL_SELECT_DBPOINT_WHERE = "SELECT dbPoint FROM DbPoint dbPoint WHERE ";
	private static final String _SQL_COUNT_DBPOINT = "SELECT COUNT(dbPoint) FROM DbPoint dbPoint";
	private static final String _SQL_COUNT_DBPOINT_WHERE = "SELECT COUNT(dbPoint) FROM DbPoint dbPoint WHERE ";
	private static final String _FINDER_COLUMN_POINTID_POINTID_2 = "dbPoint.pointId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dbPoint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DbPoint exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DbPoint exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DbPointPersistenceImpl.class);
	private static DbPoint _nullDbPoint = new DbPointImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DbPoint> toCacheModel() {
				return _nullDbPointCacheModel;
			}
		};

	private static CacheModel<DbPoint> _nullDbPointCacheModel = new CacheModel<DbPoint>() {
			public DbPoint toEntityModel() {
				return _nullDbPoint;
			}
		};
}