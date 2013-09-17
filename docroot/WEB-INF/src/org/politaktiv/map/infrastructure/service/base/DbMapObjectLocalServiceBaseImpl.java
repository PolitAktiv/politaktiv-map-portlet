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

package org.politaktiv.map.infrastructure.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import org.politaktiv.map.infrastructure.model.DbMapObject;
import org.politaktiv.map.infrastructure.service.DbMapObjectLocalService;
import org.politaktiv.map.infrastructure.service.DbMapObjectService;
import org.politaktiv.map.infrastructure.service.DbMarkerLocalService;
import org.politaktiv.map.infrastructure.service.DbMarkerService;
import org.politaktiv.map.infrastructure.service.DbPictureLocalService;
import org.politaktiv.map.infrastructure.service.DbPictureService;
import org.politaktiv.map.infrastructure.service.DbPointLocalService;
import org.politaktiv.map.infrastructure.service.DbPointService;
import org.politaktiv.map.infrastructure.service.persistence.DbMapObjectPersistence;
import org.politaktiv.map.infrastructure.service.persistence.DbMarkerPersistence;
import org.politaktiv.map.infrastructure.service.persistence.DbPicturePersistence;
import org.politaktiv.map.infrastructure.service.persistence.DbPointPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the db map object local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.politaktiv.map.infrastructure.service.impl.DbMapObjectLocalServiceImpl}.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.impl.DbMapObjectLocalServiceImpl
 * @see org.politaktiv.map.infrastructure.service.DbMapObjectLocalServiceUtil
 * @generated
 */
public abstract class DbMapObjectLocalServiceBaseImpl
	implements DbMapObjectLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.politaktiv.map.infrastructure.service.DbMapObjectLocalServiceUtil} to access the db map object local service.
	 */

	/**
	 * Adds the db map object to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dbMapObject the db map object
	 * @return the db map object that was added
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject addDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		dbMapObject.setNew(true);

		dbMapObject = dbMapObjectPersistence.update(dbMapObject, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(dbMapObject);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return dbMapObject;
	}

	/**
	 * Creates a new db map object with the primary key. Does not add the db map object to the database.
	 *
	 * @param mapObjectId the primary key for the new db map object
	 * @return the new db map object
	 */
	public DbMapObject createDbMapObject(long mapObjectId) {
		return dbMapObjectPersistence.create(mapObjectId);
	}

	/**
	 * Deletes the db map object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapObjectId the primary key of the db map object
	 * @throws PortalException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDbMapObject(long mapObjectId)
		throws PortalException, SystemException {
		DbMapObject dbMapObject = dbMapObjectPersistence.remove(mapObjectId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(dbMapObject);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the db map object from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dbMapObject the db map object
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		dbMapObjectPersistence.remove(dbMapObject);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(dbMapObject);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dbMapObjectPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return dbMapObjectPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return dbMapObjectPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return dbMapObjectPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public DbMapObject fetchDbMapObject(long mapObjectId)
		throws SystemException {
		return dbMapObjectPersistence.fetchByPrimaryKey(mapObjectId);
	}

	/**
	 * Returns the db map object with the primary key.
	 *
	 * @param mapObjectId the primary key of the db map object
	 * @return the db map object
	 * @throws PortalException if a db map object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject getDbMapObject(long mapObjectId)
		throws PortalException, SystemException {
		return dbMapObjectPersistence.findByPrimaryKey(mapObjectId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dbMapObjectPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<DbMapObject> getDbMapObjects(int start, int end)
		throws SystemException {
		return dbMapObjectPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of db map objects.
	 *
	 * @return the number of db map objects
	 * @throws SystemException if a system exception occurred
	 */
	public int getDbMapObjectsCount() throws SystemException {
		return dbMapObjectPersistence.countAll();
	}

	/**
	 * Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dbMapObject the db map object
	 * @return the db map object that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject updateDbMapObject(DbMapObject dbMapObject)
		throws SystemException {
		return updateDbMapObject(dbMapObject, true);
	}

	/**
	 * Updates the db map object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dbMapObject the db map object
	 * @param merge whether to merge the db map object with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the db map object that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DbMapObject updateDbMapObject(DbMapObject dbMapObject, boolean merge)
		throws SystemException {
		dbMapObject.setNew(false);

		dbMapObject = dbMapObjectPersistence.update(dbMapObject, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(dbMapObject);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return dbMapObject;
	}

	/**
	 * Returns the db map object local service.
	 *
	 * @return the db map object local service
	 */
	public DbMapObjectLocalService getDbMapObjectLocalService() {
		return dbMapObjectLocalService;
	}

	/**
	 * Sets the db map object local service.
	 *
	 * @param dbMapObjectLocalService the db map object local service
	 */
	public void setDbMapObjectLocalService(
		DbMapObjectLocalService dbMapObjectLocalService) {
		this.dbMapObjectLocalService = dbMapObjectLocalService;
	}

	/**
	 * Returns the db map object remote service.
	 *
	 * @return the db map object remote service
	 */
	public DbMapObjectService getDbMapObjectService() {
		return dbMapObjectService;
	}

	/**
	 * Sets the db map object remote service.
	 *
	 * @param dbMapObjectService the db map object remote service
	 */
	public void setDbMapObjectService(DbMapObjectService dbMapObjectService) {
		this.dbMapObjectService = dbMapObjectService;
	}

	/**
	 * Returns the db map object persistence.
	 *
	 * @return the db map object persistence
	 */
	public DbMapObjectPersistence getDbMapObjectPersistence() {
		return dbMapObjectPersistence;
	}

	/**
	 * Sets the db map object persistence.
	 *
	 * @param dbMapObjectPersistence the db map object persistence
	 */
	public void setDbMapObjectPersistence(
		DbMapObjectPersistence dbMapObjectPersistence) {
		this.dbMapObjectPersistence = dbMapObjectPersistence;
	}

	/**
	 * Returns the db marker local service.
	 *
	 * @return the db marker local service
	 */
	public DbMarkerLocalService getDbMarkerLocalService() {
		return dbMarkerLocalService;
	}

	/**
	 * Sets the db marker local service.
	 *
	 * @param dbMarkerLocalService the db marker local service
	 */
	public void setDbMarkerLocalService(
		DbMarkerLocalService dbMarkerLocalService) {
		this.dbMarkerLocalService = dbMarkerLocalService;
	}

	/**
	 * Returns the db marker remote service.
	 *
	 * @return the db marker remote service
	 */
	public DbMarkerService getDbMarkerService() {
		return dbMarkerService;
	}

	/**
	 * Sets the db marker remote service.
	 *
	 * @param dbMarkerService the db marker remote service
	 */
	public void setDbMarkerService(DbMarkerService dbMarkerService) {
		this.dbMarkerService = dbMarkerService;
	}

	/**
	 * Returns the db marker persistence.
	 *
	 * @return the db marker persistence
	 */
	public DbMarkerPersistence getDbMarkerPersistence() {
		return dbMarkerPersistence;
	}

	/**
	 * Sets the db marker persistence.
	 *
	 * @param dbMarkerPersistence the db marker persistence
	 */
	public void setDbMarkerPersistence(DbMarkerPersistence dbMarkerPersistence) {
		this.dbMarkerPersistence = dbMarkerPersistence;
	}

	/**
	 * Returns the db picture local service.
	 *
	 * @return the db picture local service
	 */
	public DbPictureLocalService getDbPictureLocalService() {
		return dbPictureLocalService;
	}

	/**
	 * Sets the db picture local service.
	 *
	 * @param dbPictureLocalService the db picture local service
	 */
	public void setDbPictureLocalService(
		DbPictureLocalService dbPictureLocalService) {
		this.dbPictureLocalService = dbPictureLocalService;
	}

	/**
	 * Returns the db picture remote service.
	 *
	 * @return the db picture remote service
	 */
	public DbPictureService getDbPictureService() {
		return dbPictureService;
	}

	/**
	 * Sets the db picture remote service.
	 *
	 * @param dbPictureService the db picture remote service
	 */
	public void setDbPictureService(DbPictureService dbPictureService) {
		this.dbPictureService = dbPictureService;
	}

	/**
	 * Returns the db picture persistence.
	 *
	 * @return the db picture persistence
	 */
	public DbPicturePersistence getDbPicturePersistence() {
		return dbPicturePersistence;
	}

	/**
	 * Sets the db picture persistence.
	 *
	 * @param dbPicturePersistence the db picture persistence
	 */
	public void setDbPicturePersistence(
		DbPicturePersistence dbPicturePersistence) {
		this.dbPicturePersistence = dbPicturePersistence;
	}

	/**
	 * Returns the db point local service.
	 *
	 * @return the db point local service
	 */
	public DbPointLocalService getDbPointLocalService() {
		return dbPointLocalService;
	}

	/**
	 * Sets the db point local service.
	 *
	 * @param dbPointLocalService the db point local service
	 */
	public void setDbPointLocalService(DbPointLocalService dbPointLocalService) {
		this.dbPointLocalService = dbPointLocalService;
	}

	/**
	 * Returns the db point remote service.
	 *
	 * @return the db point remote service
	 */
	public DbPointService getDbPointService() {
		return dbPointService;
	}

	/**
	 * Sets the db point remote service.
	 *
	 * @param dbPointService the db point remote service
	 */
	public void setDbPointService(DbPointService dbPointService) {
		this.dbPointService = dbPointService;
	}

	/**
	 * Returns the db point persistence.
	 *
	 * @return the db point persistence
	 */
	public DbPointPersistence getDbPointPersistence() {
		return dbPointPersistence;
	}

	/**
	 * Sets the db point persistence.
	 *
	 * @param dbPointPersistence the db point persistence
	 */
	public void setDbPointPersistence(DbPointPersistence dbPointPersistence) {
		this.dbPointPersistence = dbPointPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
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
		PersistedModelLocalServiceRegistryUtil.register("org.politaktiv.map.infrastructure.model.DbMapObject",
			dbMapObjectLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.politaktiv.map.infrastructure.model.DbMapObject");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return DbMapObject.class;
	}

	protected String getModelClassName() {
		return DbMapObject.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dbMapObjectPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DbMapObjectLocalService.class)
	protected DbMapObjectLocalService dbMapObjectLocalService;
	@BeanReference(type = DbMapObjectService.class)
	protected DbMapObjectService dbMapObjectService;
	@BeanReference(type = DbMapObjectPersistence.class)
	protected DbMapObjectPersistence dbMapObjectPersistence;
	@BeanReference(type = DbMarkerLocalService.class)
	protected DbMarkerLocalService dbMarkerLocalService;
	@BeanReference(type = DbMarkerService.class)
	protected DbMarkerService dbMarkerService;
	@BeanReference(type = DbMarkerPersistence.class)
	protected DbMarkerPersistence dbMarkerPersistence;
	@BeanReference(type = DbPictureLocalService.class)
	protected DbPictureLocalService dbPictureLocalService;
	@BeanReference(type = DbPictureService.class)
	protected DbPictureService dbPictureService;
	@BeanReference(type = DbPicturePersistence.class)
	protected DbPicturePersistence dbPicturePersistence;
	@BeanReference(type = DbPointLocalService.class)
	protected DbPointLocalService dbPointLocalService;
	@BeanReference(type = DbPointService.class)
	protected DbPointService dbPointService;
	@BeanReference(type = DbPointPersistence.class)
	protected DbPointPersistence dbPointPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(DbMapObjectLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}