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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.service.BackgroundService;
import org.politaktiv.map.infrastructure.service.persistence.BackgroundPersistence;
import org.politaktiv.map.infrastructure.service.persistence.MarkerPersistence;
import org.politaktiv.map.infrastructure.service.persistence.PicturePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the background remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.politaktiv.map.infrastructure.service.impl.BackgroundServiceImpl}.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.impl.BackgroundServiceImpl
 * @see org.politaktiv.map.infrastructure.service.BackgroundServiceUtil
 * @generated
 */
public abstract class BackgroundServiceBaseImpl extends BaseServiceImpl
	implements BackgroundService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.politaktiv.map.infrastructure.service.BackgroundServiceUtil} to access the background remote service.
	 */

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
	}

	public void destroy() {
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
		return Background.class;
	}

	protected String getModelClassName() {
		return Background.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = backgroundPersistence.getDataSource();

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
	private BackgroundServiceClpInvoker _clpInvoker = new BackgroundServiceClpInvoker();
}