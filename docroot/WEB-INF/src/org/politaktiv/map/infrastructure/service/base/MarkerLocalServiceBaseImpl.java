/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.politaktiv.map.infrastructure.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.service.MarkerLocalService;
import org.politaktiv.map.infrastructure.service.persistence.BackgroundPersistence;
import org.politaktiv.map.infrastructure.service.persistence.MarkerPersistence;
import org.politaktiv.map.infrastructure.service.persistence.PicturePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the marker local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.politaktiv.map.infrastructure.service.impl.MarkerLocalServiceImpl}.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.impl.MarkerLocalServiceImpl
 * @see org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil
 * @generated
 */
public abstract class MarkerLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements MarkerLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.politaktiv.map.infrastructure.service.MarkerLocalServiceUtil} to access the marker local service.
	 */

	/**
	 * Adds the marker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param marker the marker
	 * @return the marker that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Marker addMarker(Marker marker) throws SystemException {
		marker.setNew(true);

		return markerPersistence.update(marker);
	}

	/**
	 * Creates a new marker with the primary key. Does not add the marker to the database.
	 *
	 * @param markerId the primary key for the new marker
	 * @return the new marker
	 */
	@Override
	public Marker createMarker(long markerId) {
		return markerPersistence.create(markerId);
	}

	/**
	 * Deletes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker that was removed
	 * @throws PortalException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Marker deleteMarker(long markerId)
		throws PortalException, SystemException {
		return markerPersistence.remove(markerId);
	}

	/**
	 * Deletes the marker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marker the marker
	 * @return the marker that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Marker deleteMarker(Marker marker) throws SystemException {
		return markerPersistence.remove(marker);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Marker.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return markerPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return markerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return markerPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return markerPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return markerPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Marker fetchMarker(long markerId) throws SystemException {
		return markerPersistence.fetchByPrimaryKey(markerId);
	}

	/**
	 * Returns the marker with the primary key.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker
	 * @throws PortalException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker getMarker(long markerId)
		throws PortalException, SystemException {
		return markerPersistence.findByPrimaryKey(markerId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return markerPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.infrastructure.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @return the range of markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> getMarkers(int start, int end)
		throws SystemException {
		return markerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of markers.
	 *
	 * @return the number of markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getMarkersCount() throws SystemException {
		return markerPersistence.countAll();
	}

	/**
	 * Updates the marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param marker the marker
	 * @return the marker that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Marker updateMarker(Marker marker) throws SystemException {
		return markerPersistence.update(marker);
	}

	/**
	 * Returns the background local service.
	 *
	 * @return the background local service
	 */
	public org.politaktiv.map.infrastructure.service.BackgroundLocalService getBackgroundLocalService() {
		return backgroundLocalService;
	}

	/**
	 * Sets the background local service.
	 *
	 * @param backgroundLocalService the background local service
	 */
	public void setBackgroundLocalService(
		org.politaktiv.map.infrastructure.service.BackgroundLocalService backgroundLocalService) {
		this.backgroundLocalService = backgroundLocalService;
	}

	/**
	 * Returns the background remote service.
	 *
	 * @return the background remote service
	 */
	public org.politaktiv.map.infrastructure.service.BackgroundService getBackgroundService() {
		return backgroundService;
	}

	/**
	 * Sets the background remote service.
	 *
	 * @param backgroundService the background remote service
	 */
	public void setBackgroundService(
		org.politaktiv.map.infrastructure.service.BackgroundService backgroundService) {
		this.backgroundService = backgroundService;
	}

	/**
	 * Returns the background persistence.
	 *
	 * @return the background persistence
	 */
	public BackgroundPersistence getBackgroundPersistence() {
		return backgroundPersistence;
	}

	/**
	 * Sets the background persistence.
	 *
	 * @param backgroundPersistence the background persistence
	 */
	public void setBackgroundPersistence(
		BackgroundPersistence backgroundPersistence) {
		this.backgroundPersistence = backgroundPersistence;
	}

	/**
	 * Returns the marker local service.
	 *
	 * @return the marker local service
	 */
	public org.politaktiv.map.infrastructure.service.MarkerLocalService getMarkerLocalService() {
		return markerLocalService;
	}

	/**
	 * Sets the marker local service.
	 *
	 * @param markerLocalService the marker local service
	 */
	public void setMarkerLocalService(
		org.politaktiv.map.infrastructure.service.MarkerLocalService markerLocalService) {
		this.markerLocalService = markerLocalService;
	}

	/**
	 * Returns the marker remote service.
	 *
	 * @return the marker remote service
	 */
	public org.politaktiv.map.infrastructure.service.MarkerService getMarkerService() {
		return markerService;
	}

	/**
	 * Sets the marker remote service.
	 *
	 * @param markerService the marker remote service
	 */
	public void setMarkerService(
		org.politaktiv.map.infrastructure.service.MarkerService markerService) {
		this.markerService = markerService;
	}

	/**
	 * Returns the marker persistence.
	 *
	 * @return the marker persistence
	 */
	public MarkerPersistence getMarkerPersistence() {
		return markerPersistence;
	}

	/**
	 * Sets the marker persistence.
	 *
	 * @param markerPersistence the marker persistence
	 */
	public void setMarkerPersistence(MarkerPersistence markerPersistence) {
		this.markerPersistence = markerPersistence;
	}

	/**
	 * Returns the picture local service.
	 *
	 * @return the picture local service
	 */
	public org.politaktiv.map.infrastructure.service.PictureLocalService getPictureLocalService() {
		return pictureLocalService;
	}

	/**
	 * Sets the picture local service.
	 *
	 * @param pictureLocalService the picture local service
	 */
	public void setPictureLocalService(
		org.politaktiv.map.infrastructure.service.PictureLocalService pictureLocalService) {
		this.pictureLocalService = pictureLocalService;
	}

	/**
	 * Returns the picture remote service.
	 *
	 * @return the picture remote service
	 */
	public org.politaktiv.map.infrastructure.service.PictureService getPictureService() {
		return pictureService;
	}

	/**
	 * Sets the picture remote service.
	 *
	 * @param pictureService the picture remote service
	 */
	public void setPictureService(
		org.politaktiv.map.infrastructure.service.PictureService pictureService) {
		this.pictureService = pictureService;
	}

	/**
	 * Returns the picture persistence.
	 *
	 * @return the picture persistence
	 */
	public PicturePersistence getPicturePersistence() {
		return picturePersistence;
	}

	/**
	 * Sets the picture persistence.
	 *
	 * @param picturePersistence the picture persistence
	 */
	public void setPicturePersistence(PicturePersistence picturePersistence) {
		this.picturePersistence = picturePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.politaktiv.map.infrastructure.model.Marker",
			markerLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.politaktiv.map.infrastructure.model.Marker");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Marker.class;
	}

	protected String getModelClassName() {
		return Marker.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = markerPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.politaktiv.map.infrastructure.service.BackgroundLocalService.class)
	protected org.politaktiv.map.infrastructure.service.BackgroundLocalService backgroundLocalService;
	@BeanReference(type = org.politaktiv.map.infrastructure.service.BackgroundService.class)
	protected org.politaktiv.map.infrastructure.service.BackgroundService backgroundService;
	@BeanReference(type = BackgroundPersistence.class)
	protected BackgroundPersistence backgroundPersistence;
	@BeanReference(type = org.politaktiv.map.infrastructure.service.MarkerLocalService.class)
	protected org.politaktiv.map.infrastructure.service.MarkerLocalService markerLocalService;
	@BeanReference(type = org.politaktiv.map.infrastructure.service.MarkerService.class)
	protected org.politaktiv.map.infrastructure.service.MarkerService markerService;
	@BeanReference(type = MarkerPersistence.class)
	protected MarkerPersistence markerPersistence;
	@BeanReference(type = org.politaktiv.map.infrastructure.service.PictureLocalService.class)
	protected org.politaktiv.map.infrastructure.service.PictureLocalService pictureLocalService;
	@BeanReference(type = org.politaktiv.map.infrastructure.service.PictureService.class)
	protected org.politaktiv.map.infrastructure.service.PictureService pictureService;
	@BeanReference(type = PicturePersistence.class)
	protected PicturePersistence picturePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private MarkerLocalServiceClpInvoker _clpInvoker = new MarkerLocalServiceClpInvoker();
}