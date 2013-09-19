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

import org.politaktiv.map.infrastructure.NoSuchDbMapObjectException;
import org.politaktiv.map.infrastructure.model.DbMapObject;
import org.politaktiv.map.infrastructure.model.impl.DbMapObjectImpl;
import org.politaktiv.map.infrastructure.model.impl.DbMapObjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the db map object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbMapObjectPersistence
 * @see DbMapObjectUtil
 * @generated
 */
public class DbMapObjectPersistenceImpl extends BasePersistenceImpl<DbMapObject>
	implements DbMapObjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DbMapObjectUtil} to access the db map object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DbMapObjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, DbMapObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycompanyIdAndgroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, DbMapObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycompanyIdAndgroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DbMapObjectModelImpl.COMPANYID_COLUMN_BITMASK |
			DbMapObjectModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycompanyIdAndgroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, DbMapObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, DbMapObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the db map object in the entity cache if it is enabled.
	 *
	 * @param dbMapObject the db map object
	 */
	public void cacheResult(DbMapObject dbMapObject) {
		EntityCacheUtil.putResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectImpl.class, dbMapObject.getPrimaryKey(), dbMapObject);

		dbMapObject.resetOriginalValues();
	}

	/**
	 * Caches the db map objects in the entity cache if it is enabled.
	 *
	 * @param dbMapObjects the db map objects
	 */
	public void cacheResult(List<DbMapObject> dbMapObjects) {
		for (DbMapObject dbMapObject : dbMapObjects) {
			if (EntityCacheUtil.getResult(
						DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
						DbMapObjectImpl.class, dbMapObject.getPrimaryKey()) == null) {
				cacheResult(dbMapObject);
			}
			else {
				dbMapObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all db map objects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DbMapObjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DbMapObjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the db map object.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DbMapObject dbMapObject) {
		EntityCacheUtil.removeResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectImpl.class, dbMapObject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DbMapObject> dbMapObjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DbMapObject dbMapObject : dbMapObjects) {
			EntityCacheUtil.removeResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
				DbMapObjectImpl.class, dbMapObject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new db map object with the primary key. Does not add the db map object to the database.
	 *
	 * @param mapObjectId the primary key for the new db map object
	 * @return the new db map object
	 */
	public DbMapObject create(long mapObjectId) {
		DbMapObject dbMapObject = new DbMapObjectImpl();

		dbMapObject.setNew(true);
		dbMapObject.setPrimaryKey(mapObjectId);

		return dbMapObject;
	}

	/**
	 * Removes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapObjectId the primary key of the db map object
	 * @return the db map object that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject remove(long mapObjectId)
		throws NoSuchDbMapObjectException, SystemException {
		return remove(Long.valueOf(mapObjectId));
	}

	/**
	 * Removes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the db map object
	 * @return the db map object that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMapObject remove(Serializable primaryKey)
		throws NoSuchDbMapObjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DbMapObject dbMapObject = (DbMapObject)session.get(DbMapObjectImpl.class,
					primaryKey);

			if (dbMapObject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDbMapObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dbMapObject);
		}
		catch (NoSuchDbMapObjectException nsee) {
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
	protected DbMapObject removeImpl(DbMapObject dbMapObject)
		throws SystemException {
		dbMapObject = toUnwrappedModel(dbMapObject);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dbMapObject);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dbMapObject);

		return dbMapObject;
	}

	@Override
	public DbMapObject updateImpl(
		DbMapObject dbMapObject,
		boolean merge) throws SystemException {
		dbMapObject = toUnwrappedModel(dbMapObject);

		boolean isNew = dbMapObject.isNew();

		DbMapObjectModelImpl dbMapObjectModelImpl = (DbMapObjectModelImpl)dbMapObject;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dbMapObject, merge);

			dbMapObject.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DbMapObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dbMapObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(dbMapObjectModelImpl.getOriginalCompanyId()),
						Long.valueOf(dbMapObjectModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);

				args = new Object[] {
						Long.valueOf(dbMapObjectModelImpl.getCompanyId()),
						Long.valueOf(dbMapObjectModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
			DbMapObjectImpl.class, dbMapObject.getPrimaryKey(), dbMapObject);

		return dbMapObject;
	}

	protected DbMapObject toUnwrappedModel(DbMapObject dbMapObject) {
		if (dbMapObject instanceof DbMapObjectImpl) {
			return dbMapObject;
		}

		DbMapObjectImpl dbMapObjectImpl = new DbMapObjectImpl();

		dbMapObjectImpl.setNew(dbMapObject.isNew());
		dbMapObjectImpl.setPrimaryKey(dbMapObject.getPrimaryKey());

		dbMapObjectImpl.setMapObjectId(dbMapObject.getMapObjectId());
		dbMapObjectImpl.setCompanyId(dbMapObject.getCompanyId());
		dbMapObjectImpl.setGroupId(dbMapObject.getGroupId());
		dbMapObjectImpl.setUserId(dbMapObject.getUserId());
		dbMapObjectImpl.setName(dbMapObject.getName());
		dbMapObjectImpl.setDescription(dbMapObject.getDescription());
		dbMapObjectImpl.setReferenceUrl(dbMapObject.getReferenceUrl());
		dbMapObjectImpl.setOccupancy(dbMapObject.getOccupancy());
		dbMapObjectImpl.setMapId(dbMapObject.getMapId());
		dbMapObjectImpl.setType(dbMapObject.getType());
		dbMapObjectImpl.setGraphicObjectId(dbMapObject.getGraphicObjectId());

		return dbMapObjectImpl;
	}

	/**
	 * Returns the db map object with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the db map object
	 * @return the db map object
	 * @throws com.liferay.portal.NoSuchModelException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMapObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db map object with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbMapObjectException} if it could not be found.
	 *
	 * @param mapObjectId the primary key of the db map object
	 * @return the db map object
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject findByPrimaryKey(long mapObjectId)
		throws NoSuchDbMapObjectException, SystemException {
		DbMapObject dbMapObject = fetchByPrimaryKey(mapObjectId);

		if (dbMapObject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + mapObjectId);
			}

			throw new NoSuchDbMapObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				mapObjectId);
		}

		return dbMapObject;
	}

	/**
	 * Returns the db map object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the db map object
	 * @return the db map object, or <code>null</code> if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DbMapObject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the db map object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapObjectId the primary key of the db map object
	 * @return the db map object, or <code>null</code> if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject fetchByPrimaryKey(long mapObjectId)
		throws SystemException {
		DbMapObject dbMapObject = (DbMapObject)EntityCacheUtil.getResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
				DbMapObjectImpl.class, mapObjectId);

		if (dbMapObject == _nullDbMapObject) {
			return null;
		}

		if (dbMapObject == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dbMapObject = (DbMapObject)session.get(DbMapObjectImpl.class,
						Long.valueOf(mapObjectId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dbMapObject != null) {
					cacheResult(dbMapObject);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DbMapObjectModelImpl.ENTITY_CACHE_ENABLED,
						DbMapObjectImpl.class, mapObjectId, _nullDbMapObject);
				}

				closeSession(session);
			}
		}

		return dbMapObject;
	}

	/**
	 * Returns all the db map objects where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findBycompanyIdAndgroupId(long companyId,
		long groupId) throws SystemException {
		return findBycompanyIdAndgroupId(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the db map objects where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of db map objects
	 * @param end the upper bound of the range of db map objects (not inclusive)
	 * @return the range of matching db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findBycompanyIdAndgroupId(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findBycompanyIdAndgroupId(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the db map objects where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of db map objects
	 * @param end the upper bound of the range of db map objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findBycompanyIdAndgroupId(long companyId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<DbMapObject> list = (List<DbMapObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DBMAPOBJECT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<DbMapObject>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching db map object
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a matching db map object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject findBycompanyIdAndgroupId_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDbMapObjectException, SystemException {
		List<DbMapObject> list = findBycompanyIdAndgroupId(companyId, groupId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDbMapObjectException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching db map object
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a matching db map object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject findBycompanyIdAndgroupId_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDbMapObjectException, SystemException {
		int count = countBycompanyIdAndgroupId(companyId, groupId);

		List<DbMapObject> list = findBycompanyIdAndgroupId(companyId, groupId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDbMapObjectException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the db map objects before and after the current db map object in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param mapObjectId the primary key of the current db map object
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next db map object
	 * @throws org.politaktiv.map.infrastructure.NoSuchDbMapObjectException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject[] findBycompanyIdAndgroupId_PrevAndNext(
		long mapObjectId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDbMapObjectException, SystemException {
		DbMapObject dbMapObject = findByPrimaryKey(mapObjectId);

		Session session = null;

		try {
			session = openSession();

			DbMapObject[] array = new DbMapObjectImpl[3];

			array[0] = getBycompanyIdAndgroupId_PrevAndNext(session,
					dbMapObject, companyId, groupId, orderByComparator, true);

			array[1] = dbMapObject;

			array[2] = getBycompanyIdAndgroupId_PrevAndNext(session,
					dbMapObject, companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DbMapObject getBycompanyIdAndgroupId_PrevAndNext(
		Session session, DbMapObject dbMapObject, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DBMAPOBJECT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dbMapObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DbMapObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the db map objects.
	 *
	 * @return the db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the db map objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db map objects
	 * @param end the upper bound of the range of db map objects (not inclusive)
	 * @return the range of db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the db map objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of db map objects
	 * @param end the upper bound of the range of db map objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public List<DbMapObject> findAll(int start, int end,
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

		List<DbMapObject> list = (List<DbMapObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DBMAPOBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DBMAPOBJECT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DbMapObject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DbMapObject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the db map objects where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException {
		for (DbMapObject dbMapObject : findBycompanyIdAndgroupId(companyId,
				groupId)) {
			remove(dbMapObject);
		}
	}

	/**
	 * Removes all the db map objects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DbMapObject dbMapObject : findAll()) {
			remove(dbMapObject);
		}
	}

	/**
	 * Returns the number of db map objects where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycompanyIdAndgroupId(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DBMAPOBJECT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of db map objects.
	 *
	 * @return the number of db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DBMAPOBJECT);

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
	 * Initializes the db map object persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.DbMapObject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DbMapObject>> listenersList = new ArrayList<ModelListener<DbMapObject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DbMapObject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DbMapObjectImpl.class.getName());
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
	private static final String _SQL_SELECT_DBMAPOBJECT = "SELECT dbMapObject FROM DbMapObject dbMapObject";
	private static final String _SQL_SELECT_DBMAPOBJECT_WHERE = "SELECT dbMapObject FROM DbMapObject dbMapObject WHERE ";
	private static final String _SQL_COUNT_DBMAPOBJECT = "SELECT COUNT(dbMapObject) FROM DbMapObject dbMapObject";
	private static final String _SQL_COUNT_DBMAPOBJECT_WHERE = "SELECT COUNT(dbMapObject) FROM DbMapObject dbMapObject WHERE ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "dbMapObject.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "dbMapObject.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dbMapObject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DbMapObject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DbMapObject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DbMapObjectPersistenceImpl.class);
	private static DbMapObject _nullDbMapObject = new DbMapObjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DbMapObject> toCacheModel() {
				return _nullDbMapObjectCacheModel;
			}
		};

	private static CacheModel<DbMapObject> _nullDbMapObjectCacheModel = new CacheModel<DbMapObject>() {
			public DbMapObject toEntityModel() {
				return _nullDbMapObject;
			}
		};
}