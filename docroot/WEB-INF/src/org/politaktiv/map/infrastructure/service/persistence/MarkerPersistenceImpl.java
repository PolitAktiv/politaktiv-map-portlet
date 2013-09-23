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

import org.politaktiv.map.infrastructure.NoSuchMarkerException;
import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.impl.MarkerImpl;
import org.politaktiv.map.infrastructure.model.impl.MarkerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see MarkerPersistence
 * @see MarkerUtil
 * @generated
 */
public class MarkerPersistenceImpl extends BasePersistenceImpl<Marker>
	implements MarkerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarkerUtil} to access the marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarkerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKGROUNDID =
		new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybackgroundId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID =
		new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybackgroundId",
			new String[] { Long.class.getName() },
			MarkerModelImpl.BACKGROUNDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BACKGROUNDID = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybackgroundId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the marker in the entity cache if it is enabled.
	 *
	 * @param marker the marker
	 */
	public void cacheResult(Marker marker) {
		EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey(), marker);

		marker.resetOriginalValues();
	}

	/**
	 * Caches the markers in the entity cache if it is enabled.
	 *
	 * @param markers the markers
	 */
	public void cacheResult(List<Marker> markers) {
		for (Marker marker : markers) {
			if (EntityCacheUtil.getResult(
						MarkerModelImpl.ENTITY_CACHE_ENABLED, MarkerImpl.class,
						marker.getPrimaryKey()) == null) {
				cacheResult(marker);
			}
			else {
				marker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all markers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarkerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarkerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Marker marker) {
		EntityCacheUtil.removeResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Marker> markers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Marker marker : markers) {
			EntityCacheUtil.removeResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
				MarkerImpl.class, marker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marker with the primary key. Does not add the marker to the database.
	 *
	 * @param markerId the primary key for the new marker
	 * @return the new marker
	 */
	public Marker create(long markerId) {
		Marker marker = new MarkerImpl();

		marker.setNew(true);
		marker.setPrimaryKey(markerId);

		return marker;
	}

	/**
	 * Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker remove(long markerId)
		throws NoSuchMarkerException, SystemException {
		return remove(Long.valueOf(markerId));
	}

	/**
	 * Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker remove(Serializable primaryKey)
		throws NoSuchMarkerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Marker marker = (Marker)session.get(MarkerImpl.class, primaryKey);

			if (marker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marker);
		}
		catch (NoSuchMarkerException nsee) {
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
	protected Marker removeImpl(Marker marker) throws SystemException {
		marker = toUnwrappedModel(marker);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, marker);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(marker);

		return marker;
	}

	@Override
	public Marker updateImpl(
		Marker marker, boolean merge)
		throws SystemException {
		marker = toUnwrappedModel(marker);

		boolean isNew = marker.isNew();

		MarkerModelImpl markerModelImpl = (MarkerModelImpl)marker;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, marker, merge);

			marker.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarkerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((markerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(markerModelImpl.getOriginalBackgroundId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID,
					args);

				args = new Object[] {
						Long.valueOf(markerModelImpl.getBackgroundId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID,
					args);
			}
		}

		EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey(), marker);

		return marker;
	}

	protected Marker toUnwrappedModel(Marker marker) {
		if (marker instanceof MarkerImpl) {
			return marker;
		}

		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setNew(marker.isNew());
		markerImpl.setPrimaryKey(marker.getPrimaryKey());

		markerImpl.setMarkerId(marker.getMarkerId());
		markerImpl.setCompanyId(marker.getCompanyId());
		markerImpl.setGroupId(marker.getGroupId());
		markerImpl.setUserId(marker.getUserId());
		markerImpl.setName(marker.getName());
		markerImpl.setDescription(marker.getDescription());
		markerImpl.setReferenceUrl(marker.getReferenceUrl());
		markerImpl.setBackgroundId(marker.getBackgroundId());
		markerImpl.setLongitude(marker.getLongitude());
		markerImpl.setLatitude(marker.getLatitude());

		return markerImpl;
	}

	/**
	 * Returns the marker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker
	 * @throws com.liferay.portal.NoSuchModelException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the marker with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchMarkerException} if it could not be found.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker findByPrimaryKey(long markerId)
		throws NoSuchMarkerException, SystemException {
		Marker marker = fetchByPrimaryKey(markerId);

		if (marker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + markerId);
			}

			throw new NoSuchMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				markerId);
		}

		return marker;
	}

	/**
	 * Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker, or <code>null</code> if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker, or <code>null</code> if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker fetchByPrimaryKey(long markerId) throws SystemException {
		Marker marker = (Marker)EntityCacheUtil.getResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
				MarkerImpl.class, markerId);

		if (marker == _nullMarker) {
			return null;
		}

		if (marker == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				marker = (Marker)session.get(MarkerImpl.class,
						Long.valueOf(markerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (marker != null) {
					cacheResult(marker);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
						MarkerImpl.class, markerId, _nullMarker);
				}

				closeSession(session);
			}
		}

		return marker;
	}

	/**
	 * Returns all the markers where backgroundId = &#63;.
	 *
	 * @param backgroundId the background ID
	 * @return the matching markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findBybackgroundId(long backgroundId)
		throws SystemException {
		return findBybackgroundId(backgroundId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the markers where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @return the range of matching markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findBybackgroundId(long backgroundId, int start, int end)
		throws SystemException {
		return findBybackgroundId(backgroundId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the markers where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findBybackgroundId(long backgroundId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID;
			finderArgs = new Object[] { backgroundId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKGROUNDID;
			finderArgs = new Object[] {
					backgroundId,
					
					start, end, orderByComparator
				};
		}

		List<Marker> list = (List<Marker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_MARKER_WHERE);

			query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

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

				qPos.add(backgroundId);

				list = (List<Marker>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first marker in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker findBybackgroundId_First(long backgroundId,
		OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		List<Marker> list = findBybackgroundId(backgroundId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("backgroundId=");
			msg.append(backgroundId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMarkerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last marker in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker findBybackgroundId_Last(long backgroundId,
		OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		int count = countBybackgroundId(backgroundId);

		List<Marker> list = findBybackgroundId(backgroundId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("backgroundId=");
			msg.append(backgroundId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchMarkerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the markers before and after the current marker in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param markerId the primary key of the current marker
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marker
	 * @throws org.politaktiv.map.infrastructure.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Marker[] findBybackgroundId_PrevAndNext(long markerId,
		long backgroundId, OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		Marker marker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			Marker[] array = new MarkerImpl[3];

			array[0] = getBybackgroundId_PrevAndNext(session, marker,
					backgroundId, orderByComparator, true);

			array[1] = marker;

			array[2] = getBybackgroundId_PrevAndNext(session, marker,
					backgroundId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Marker getBybackgroundId_PrevAndNext(Session session,
		Marker marker, long backgroundId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARKER_WHERE);

		query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

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

		qPos.add(backgroundId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Marker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the markers.
	 *
	 * @return the markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @return the range of markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of markers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Marker> findAll(int start, int end,
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

		List<Marker> list = (List<Marker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the markers where backgroundId = &#63; from the database.
	 *
	 * @param backgroundId the background ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBybackgroundId(long backgroundId)
		throws SystemException {
		for (Marker marker : findBybackgroundId(backgroundId)) {
			remove(marker);
		}
	}

	/**
	 * Removes all the markers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Marker marker : findAll()) {
			remove(marker);
		}
	}

	/**
	 * Returns the number of markers where backgroundId = &#63;.
	 *
	 * @param backgroundId the background ID
	 * @return the number of matching markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countBybackgroundId(long backgroundId) throws SystemException {
		Object[] finderArgs = new Object[] { backgroundId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARKER_WHERE);

			query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(backgroundId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of markers.
	 *
	 * @return the number of markers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MARKER);

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
	 * Initializes the marker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.Marker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Marker>> listenersList = new ArrayList<ModelListener<Marker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Marker>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarkerImpl.class.getName());
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
	private static final String _SQL_SELECT_MARKER = "SELECT marker FROM Marker marker";
	private static final String _SQL_SELECT_MARKER_WHERE = "SELECT marker FROM Marker marker WHERE ";
	private static final String _SQL_COUNT_MARKER = "SELECT COUNT(marker) FROM Marker marker";
	private static final String _SQL_COUNT_MARKER_WHERE = "SELECT COUNT(marker) FROM Marker marker WHERE ";
	private static final String _FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2 = "marker.backgroundId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Marker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Marker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarkerPersistenceImpl.class);
	private static Marker _nullMarker = new MarkerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Marker> toCacheModel() {
				return _nullMarkerCacheModel;
			}
		};

	private static CacheModel<Marker> _nullMarkerCacheModel = new CacheModel<Marker>() {
			public Marker toEntityModel() {
				return _nullMarker;
			}
		};
}