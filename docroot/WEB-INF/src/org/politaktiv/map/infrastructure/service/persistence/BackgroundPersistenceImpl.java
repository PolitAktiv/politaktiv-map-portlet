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

import org.politaktiv.map.infrastructure.NoSuchBackgroundException;
import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.model.impl.BackgroundImpl;
import org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the background service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see BackgroundPersistence
 * @see BackgroundUtil
 * @generated
 */
public class BackgroundPersistenceImpl extends BasePersistenceImpl<Background>
	implements BackgroundPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BackgroundUtil} to access the background persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BackgroundImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, BackgroundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycompanyIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID =
		new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, BackgroundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BackgroundModelImpl.COMPANYID_COLUMN_BITMASK |
			BackgroundModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID = new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycompanyIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, BackgroundImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, BackgroundImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the background in the entity cache if it is enabled.
	 *
	 * @param background the background
	 */
	public void cacheResult(Background background) {
		EntityCacheUtil.putResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundImpl.class, background.getPrimaryKey(), background);

		background.resetOriginalValues();
	}

	/**
	 * Caches the backgrounds in the entity cache if it is enabled.
	 *
	 * @param backgrounds the backgrounds
	 */
	public void cacheResult(List<Background> backgrounds) {
		for (Background background : backgrounds) {
			if (EntityCacheUtil.getResult(
						BackgroundModelImpl.ENTITY_CACHE_ENABLED,
						BackgroundImpl.class, background.getPrimaryKey()) == null) {
				cacheResult(background);
			}
			else {
				background.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all backgrounds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BackgroundImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BackgroundImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the background.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Background background) {
		EntityCacheUtil.removeResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundImpl.class, background.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Background> backgrounds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Background background : backgrounds) {
			EntityCacheUtil.removeResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
				BackgroundImpl.class, background.getPrimaryKey());
		}
	}

	/**
	 * Creates a new background with the primary key. Does not add the background to the database.
	 *
	 * @param backgroundId the primary key for the new background
	 * @return the new background
	 */
	public Background create(long backgroundId) {
		Background background = new BackgroundImpl();

		background.setNew(true);
		background.setPrimaryKey(backgroundId);

		return background;
	}

	/**
	 * Removes the background with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param backgroundId the primary key of the background
	 * @return the background that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background remove(long backgroundId)
		throws NoSuchBackgroundException, SystemException {
		return remove(Long.valueOf(backgroundId));
	}

	/**
	 * Removes the background with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the background
	 * @return the background that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Background remove(Serializable primaryKey)
		throws NoSuchBackgroundException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Background background = (Background)session.get(BackgroundImpl.class,
					primaryKey);

			if (background == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBackgroundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(background);
		}
		catch (NoSuchBackgroundException nsee) {
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
	protected Background removeImpl(Background background)
		throws SystemException {
		background = toUnwrappedModel(background);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, background);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(background);

		return background;
	}

	@Override
	public Background updateImpl(
		Background background,
		boolean merge) throws SystemException {
		background = toUnwrappedModel(background);

		boolean isNew = background.isNew();

		BackgroundModelImpl backgroundModelImpl = (BackgroundModelImpl)background;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, background, merge);

			background.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BackgroundModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((backgroundModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(backgroundModelImpl.getOriginalCompanyId()),
						Long.valueOf(backgroundModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);

				args = new Object[] {
						Long.valueOf(backgroundModelImpl.getCompanyId()),
						Long.valueOf(backgroundModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
			BackgroundImpl.class, background.getPrimaryKey(), background);

		return background;
	}

	protected Background toUnwrappedModel(Background background) {
		if (background instanceof BackgroundImpl) {
			return background;
		}

		BackgroundImpl backgroundImpl = new BackgroundImpl();

		backgroundImpl.setNew(background.isNew());
		backgroundImpl.setPrimaryKey(background.getPrimaryKey());

		backgroundImpl.setBackgroundId(background.getBackgroundId());
		backgroundImpl.setCompanyId(background.getCompanyId());
		backgroundImpl.setGroupId(background.getGroupId());
		backgroundImpl.setUserId(background.getUserId());
		backgroundImpl.setName(background.getName());
		backgroundImpl.setFileEntryUuid(background.getFileEntryUuid());

		return backgroundImpl;
	}

	/**
	 * Returns the background with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the background
	 * @return the background
	 * @throws com.liferay.portal.NoSuchModelException if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Background findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the background with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchBackgroundException} if it could not be found.
	 *
	 * @param backgroundId the primary key of the background
	 * @return the background
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background findByPrimaryKey(long backgroundId)
		throws NoSuchBackgroundException, SystemException {
		Background background = fetchByPrimaryKey(backgroundId);

		if (background == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + backgroundId);
			}

			throw new NoSuchBackgroundException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				backgroundId);
		}

		return background;
	}

	/**
	 * Returns the background with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the background
	 * @return the background, or <code>null</code> if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Background fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the background with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param backgroundId the primary key of the background
	 * @return the background, or <code>null</code> if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background fetchByPrimaryKey(long backgroundId)
		throws SystemException {
		Background background = (Background)EntityCacheUtil.getResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
				BackgroundImpl.class, backgroundId);

		if (background == _nullBackground) {
			return null;
		}

		if (background == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				background = (Background)session.get(BackgroundImpl.class,
						Long.valueOf(backgroundId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (background != null) {
					cacheResult(background);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BackgroundModelImpl.ENTITY_CACHE_ENABLED,
						BackgroundImpl.class, backgroundId, _nullBackground);
				}

				closeSession(session);
			}
		}

		return background;
	}

	/**
	 * Returns all the backgrounds where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findBycompanyIdAndGroupId(long companyId,
		long groupId) throws SystemException {
		return findBycompanyIdAndGroupId(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of backgrounds
	 * @param end the upper bound of the range of backgrounds (not inclusive)
	 * @return the range of matching backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findBycompanyIdAndGroupId(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findBycompanyIdAndGroupId(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the backgrounds where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of backgrounds
	 * @param end the upper bound of the range of backgrounds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findBycompanyIdAndGroupId(long companyId,
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

		List<Background> list = (List<Background>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_BACKGROUND_WHERE);

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

				list = (List<Background>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first background in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching background
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a matching background could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background findBycompanyIdAndGroupId_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBackgroundException, SystemException {
		List<Background> list = findBycompanyIdAndGroupId(companyId, groupId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBackgroundException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last background in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching background
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a matching background could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background findBycompanyIdAndGroupId_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBackgroundException, SystemException {
		int count = countBycompanyIdAndGroupId(companyId, groupId);

		List<Background> list = findBycompanyIdAndGroupId(companyId, groupId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBackgroundException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the backgrounds before and after the current background in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the primary key of the current background
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next background
	 * @throws org.politaktiv.map.infrastructure.NoSuchBackgroundException if a background with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Background[] findBycompanyIdAndGroupId_PrevAndNext(
		long backgroundId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBackgroundException, SystemException {
		Background background = findByPrimaryKey(backgroundId);

		Session session = null;

		try {
			session = openSession();

			Background[] array = new BackgroundImpl[3];

			array[0] = getBycompanyIdAndGroupId_PrevAndNext(session,
					background, companyId, groupId, orderByComparator, true);

			array[1] = background;

			array[2] = getBycompanyIdAndGroupId_PrevAndNext(session,
					background, companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Background getBycompanyIdAndGroupId_PrevAndNext(Session session,
		Background background, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BACKGROUND_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(background);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Background> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the backgrounds.
	 *
	 * @return the backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the backgrounds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of backgrounds
	 * @param end the upper bound of the range of backgrounds (not inclusive)
	 * @return the range of backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the backgrounds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of backgrounds
	 * @param end the upper bound of the range of backgrounds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public List<Background> findAll(int start, int end,
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

		List<Background> list = (List<Background>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BACKGROUND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BACKGROUND;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Background>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Background>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the backgrounds where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBycompanyIdAndGroupId(long companyId, long groupId)
		throws SystemException {
		for (Background background : findBycompanyIdAndGroupId(companyId,
				groupId)) {
			remove(background);
		}
	}

	/**
	 * Removes all the backgrounds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Background background : findAll()) {
			remove(background);
		}
	}

	/**
	 * Returns the number of backgrounds where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycompanyIdAndGroupId(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BACKGROUND_WHERE);

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
	 * Returns the number of backgrounds.
	 *
	 * @return the number of backgrounds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BACKGROUND);

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
	 * Initializes the background persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.Background")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Background>> listenersList = new ArrayList<ModelListener<Background>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Background>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BackgroundImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BackgroundPersistence.class)
	protected BackgroundPersistence backgroundPersistence;
	@BeanReference(type = MarkerPersistence.class)
	protected MarkerPersistence markerPersistence;
	@BeanReference(type = PicturePersistence.class)
	protected PicturePersistence picturePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BACKGROUND = "SELECT background FROM Background background";
	private static final String _SQL_SELECT_BACKGROUND_WHERE = "SELECT background FROM Background background WHERE ";
	private static final String _SQL_COUNT_BACKGROUND = "SELECT COUNT(background) FROM Background background";
	private static final String _SQL_COUNT_BACKGROUND_WHERE = "SELECT COUNT(background) FROM Background background WHERE ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_COMPANYID_2 = "background.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGROUPID_GROUPID_2 = "background.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "background.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Background exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Background exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BackgroundPersistenceImpl.class);
	private static Background _nullBackground = new BackgroundImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Background> toCacheModel() {
				return _nullBackgroundCacheModel;
			}
		};

	private static CacheModel<Background> _nullBackgroundCacheModel = new CacheModel<Background>() {
			public Background toEntityModel() {
				return _nullBackground;
			}
		};
}