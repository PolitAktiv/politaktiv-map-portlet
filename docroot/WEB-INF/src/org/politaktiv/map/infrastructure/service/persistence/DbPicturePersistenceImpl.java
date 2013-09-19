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

import org.politaktiv.map.infrastructure.NoSuchDbPictureException;
import org.politaktiv.map.infrastructure.model.DbPicture;
import org.politaktiv.map.infrastructure.model.impl.DbPictureImpl;
import org.politaktiv.map.infrastructure.model.impl.DbPictureModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the db picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbPicturePersistence
 * @see DbPictureUtil
 * @generated
 */
public class DbPicturePersistenceImpl extends BasePersistenceImpl<DbPicture>
	implements DbPicturePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DbPictureUtil} to access the db picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DbPictureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PICTUREID = new FinderPath(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureModelImpl.FINDER_CACHE_ENABLED, DbPictureImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBypictureId",
			new String[] { Long.class.getName() },
			DbPictureModelImpl.PICTUREID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PICTUREID = new FinderPath(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypictureId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureModelImpl.FINDER_CACHE_ENABLED, DbPictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureModelImpl.FINDER_CACHE_ENABLED, DbPictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the db picture in the entity cache if it is enabled.
	 *
	 * @param dbPicture the db picture
	 */
	public void cacheResult(DbPicture dbPicture) {
		EntityCacheUtil.putResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureImpl.class, dbPicture.getPrimaryKey(), dbPicture);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PICTUREID,
			new Object[] { Long.valueOf(dbPicture.getPictureId()) }, dbPicture);

		dbPicture.resetOriginalValues();
	}

	/**
	 * Caches the db pictures in the entity cache if it is enabled.
	 *
	 * @param dbPictures the db pictures
	 */
	public void cacheResult(List<DbPicture> dbPictures) {
		for (DbPicture dbPicture : dbPictures) {
			if (EntityCacheUtil.getResult(
						DbPictureModelImpl.ENTITY_CACHE_ENABLED,
						DbPictureImpl.class, dbPicture.getPrimaryKey()) == null) {
				cacheResult(dbPicture);
			}
			else {
				dbPicture.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all db pictures.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DbPictureImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DbPictureImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the db picture.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DbPicture dbPicture) {
		EntityCacheUtil.removeResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureImpl.class, dbPicture.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dbPicture);
	}

	@Override
	public void clearCache(List<DbPicture> dbPictures) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DbPicture dbPicture : dbPictures) {
			EntityCacheUtil.removeResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
				DbPictureImpl.class, dbPicture.getPrimaryKey());

			clearUniqueFindersCache(dbPicture);
		}
	}

	protected void clearUniqueFindersCache(DbPicture dbPicture) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PICTUREID,
			new Object[] { Long.valueOf(dbPicture.getPictureId()) });
	}

	/**
	 * Creates a new db picture with the primary key. Does not add the db picture to the database.
	 *
	 * @param pictureId the primary key for the new db picture
	 * @return the new db picture
	 */
	public DbPicture create(long pictureId) {
		DbPicture dbPicture = new DbPictureImpl();

		dbPicture.setNew(true);
		dbPicture.setPrimaryKey(pictureId);

		return dbPicture;
	}

	/**
	 * Removes the db picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pictureId the primary key of the db picture
	 * @return the db picture that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture remove(long pictureId)
		throws NoSuchDbPictureException, SystemException {
		return remove(Long.valueOf(pictureId));
	}

	/**
	 * Removes the db picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the db picture
	 * @return the db picture that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPicture remove(Serializable primaryKey)
		throws NoSuchDbPictureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DbPicture dbPicture = (DbPicture)session.get(DbPictureImpl.class,
					primaryKey);

			if (dbPicture == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDbPictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dbPicture);
		}
		catch (NoSuchDbPictureException nsee) {
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
	protected DbPicture removeImpl(DbPicture dbPicture)
		throws SystemException {
		dbPicture = toUnwrappedModel(dbPicture);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dbPicture);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dbPicture);

		return dbPicture;
	}

	@Override
	public DbPicture updateImpl(DbPicture dbPicture,boolean merge) 
		throws SystemException {
		dbPicture = toUnwrappedModel(dbPicture);

		boolean isNew = dbPicture.isNew();

		DbPictureModelImpl dbPictureModelImpl = (DbPictureModelImpl)dbPicture;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dbPicture, merge);

			dbPicture.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DbPictureModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
			DbPictureImpl.class, dbPicture.getPrimaryKey(), dbPicture);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PICTUREID,
				new Object[] { Long.valueOf(dbPicture.getPictureId()) },
				dbPicture);
		}
		else {
			if ((dbPictureModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PICTUREID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dbPictureModelImpl.getOriginalPictureId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PICTUREID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PICTUREID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PICTUREID,
					new Object[] { Long.valueOf(dbPicture.getPictureId()) },
					dbPicture);
			}
		}

		return dbPicture;
	}

	protected DbPicture toUnwrappedModel(DbPicture dbPicture) {
		if (dbPicture instanceof DbPictureImpl) {
			return dbPicture;
		}

		DbPictureImpl dbPictureImpl = new DbPictureImpl();

		dbPictureImpl.setNew(dbPicture.isNew());
		dbPictureImpl.setPrimaryKey(dbPicture.getPrimaryKey());

		dbPictureImpl.setPictureId(dbPicture.getPictureId());
		dbPictureImpl.setRotation(dbPicture.getRotation());
		dbPictureImpl.setWidth(dbPicture.getWidth());
		dbPictureImpl.setHeight(dbPicture.getHeight());
		dbPictureImpl.setResolution(dbPicture.getResolution());
		dbPictureImpl.setPointId(dbPicture.getPointId());

		return dbPictureImpl;
	}

	/**
	 * Returns the db picture with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the db picture
	 * @return the db picture
	 * @throws com.liferay.portal.NoSuchModelException if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPicture findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db picture with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPictureException} if it could not be found.
	 *
	 * @param pictureId the primary key of the db picture
	 * @return the db picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture findByPrimaryKey(long pictureId)
		throws NoSuchDbPictureException, SystemException {
		DbPicture dbPicture = fetchByPrimaryKey(pictureId);

		if (dbPicture == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pictureId);
			}

			throw new NoSuchDbPictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pictureId);
		}

		return dbPicture;
	}

	/**
	 * Returns the db picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the db picture
	 * @return the db picture, or <code>null</code> if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbPicture fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pictureId the primary key of the db picture
	 * @return the db picture, or <code>null</code> if a db picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture fetchByPrimaryKey(long pictureId)
		throws SystemException {
		DbPicture dbPicture = (DbPicture)EntityCacheUtil.getResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
				DbPictureImpl.class, pictureId);

		if (dbPicture == _nullDbPicture) {
			return null;
		}

		if (dbPicture == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dbPicture = (DbPicture)session.get(DbPictureImpl.class,
						Long.valueOf(pictureId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dbPicture != null) {
					cacheResult(dbPicture);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DbPictureModelImpl.ENTITY_CACHE_ENABLED,
						DbPictureImpl.class, pictureId, _nullDbPicture);
				}

				closeSession(session);
			}
		}

		return dbPicture;
	}

	/**
	 * Returns the db picture where pictureId = &#63; or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPictureException} if it could not be found.
	 *
	 * @param pictureId the picture ID
	 * @return the matching db picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a matching db picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture findBypictureId(long pictureId)
		throws NoSuchDbPictureException, SystemException {
		DbPicture dbPicture = fetchBypictureId(pictureId);

		if (dbPicture == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pictureId=");
			msg.append(pictureId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDbPictureException(msg.toString());
		}

		return dbPicture;
	}

	/**
	 * Returns the db picture where pictureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pictureId the picture ID
	 * @return the matching db picture, or <code>null</code> if a matching db picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture fetchBypictureId(long pictureId) throws SystemException {
		return fetchBypictureId(pictureId, true);
	}

	/**
	 * Returns the db picture where pictureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pictureId the picture ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching db picture, or <code>null</code> if a matching db picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbPicture fetchBypictureId(long pictureId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { pictureId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PICTUREID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DBPICTURE_WHERE);

			query.append(_FINDER_COLUMN_PICTUREID_PICTUREID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pictureId);

				List<DbPicture> list = q.list();

				result = list;

				DbPicture dbPicture = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PICTUREID,
						finderArgs, list);
				}
				else {
					dbPicture = list.get(0);

					cacheResult(dbPicture);

					if ((dbPicture.getPictureId() != pictureId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PICTUREID,
							finderArgs, dbPicture);
					}
				}

				return dbPicture;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PICTUREID,
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
				return (DbPicture)result;
			}
		}
	}

	/**
	 * Returns all the db pictures.
	 *
	 * @return the db pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPicture> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the db pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db pictures
	 * @param end the upper bound of the range of db pictures (not inclusive)
	 * @return the range of db pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPicture> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the db pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db pictures
	 * @param end the upper bound of the range of db pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of db pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbPicture> findAll(int start, int end,
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

		List<DbPicture> list = (List<DbPicture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DBPICTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DBPICTURE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DbPicture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DbPicture>)QueryUtil.list(q, getDialect(),
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
	 * Removes the db picture where pictureId = &#63; from the database.
	 *
	 * @param pictureId the picture ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBypictureId(long pictureId)
		throws NoSuchDbPictureException, SystemException {
		DbPicture dbPicture = findBypictureId(pictureId);

		remove(dbPicture);
	}

	/**
	 * Removes all the db pictures from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DbPicture dbPicture : findAll()) {
			remove(dbPicture);
		}
	}

	/**
	 * Returns the number of db pictures where pictureId = &#63;.
	 *
	 * @param pictureId the picture ID
	 * @return the number of matching db pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int countBypictureId(long pictureId) throws SystemException {
		Object[] finderArgs = new Object[] { pictureId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PICTUREID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DBPICTURE_WHERE);

			query.append(_FINDER_COLUMN_PICTUREID_PICTUREID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pictureId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PICTUREID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of db pictures.
	 *
	 * @return the number of db pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DBPICTURE);

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
	 * Initializes the db picture persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.DbPicture")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DbPicture>> listenersList = new ArrayList<ModelListener<DbPicture>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DbPicture>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DbPictureImpl.class.getName());
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
	private static final String _SQL_SELECT_DBPICTURE = "SELECT dbPicture FROM DbPicture dbPicture";
	private static final String _SQL_SELECT_DBPICTURE_WHERE = "SELECT dbPicture FROM DbPicture dbPicture WHERE ";
	private static final String _SQL_COUNT_DBPICTURE = "SELECT COUNT(dbPicture) FROM DbPicture dbPicture";
	private static final String _SQL_COUNT_DBPICTURE_WHERE = "SELECT COUNT(dbPicture) FROM DbPicture dbPicture WHERE ";
	private static final String _FINDER_COLUMN_PICTUREID_PICTUREID_2 = "dbPicture.pictureId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dbPicture.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DbPicture exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DbPicture exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DbPicturePersistenceImpl.class);
	private static DbPicture _nullDbPicture = new DbPictureImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DbPicture> toCacheModel() {
				return _nullDbPictureCacheModel;
			}
		};

	private static CacheModel<DbPicture> _nullDbPictureCacheModel = new CacheModel<DbPicture>() {
			public DbPicture toEntityModel() {
				return _nullDbPicture;
			}
		};
}