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

import com.liferay.portal.service.persistence.BasePersistence;

import org.politaktiv.map.infrastructure.model.DbPicture;

/**
 * The persistence interface for the db picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see DbPicturePersistenceImpl
 * @see DbPictureUtil
 * @generated
 */
public interface DbPicturePersistence extends BasePersistence<DbPicture> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DbPictureUtil} to access the db picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the db picture in the entity cache if it is enabled.
	*
	* @param dbPicture the db picture
	*/
	public void cacheResult(
		org.politaktiv.map.infrastructure.model.DbPicture dbPicture);

	/**
	* Caches the db pictures in the entity cache if it is enabled.
	*
	* @param dbPictures the db pictures
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.DbPicture> dbPictures);

	/**
	* Creates a new db picture with the primary key. Does not add the db picture to the database.
	*
	* @param pictureId the primary key for the new db picture
	* @return the new db picture
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture create(
		long pictureId);

	/**
	* Removes the db picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the db picture
	* @return the db picture that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture remove(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchDbPictureException;

	public org.politaktiv.map.infrastructure.model.DbPicture updateImpl(
		org.politaktiv.map.infrastructure.model.DbPicture dbPicture,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the db picture with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPictureException} if it could not be found.
	*
	* @param pictureId the primary key of the db picture
	* @return the db picture
	* @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture findByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchDbPictureException;

	/**
	* Returns the db picture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pictureId the primary key of the db picture
	* @return the db picture, or <code>null</code> if a db picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture fetchByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the db picture where pictureId = &#63; or throws a {@link org.politaktiv.map.infrastructure.NoSuchDbPictureException} if it could not be found.
	*
	* @param pictureId the picture ID
	* @return the matching db picture
	* @throws org.politaktiv.map.infrastructure.NoSuchDbPictureException if a matching db picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture findBypictureId(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchDbPictureException;

	/**
	* Returns the db picture where pictureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pictureId the picture ID
	* @return the matching db picture, or <code>null</code> if a matching db picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture fetchBypictureId(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the db picture where pictureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pictureId the picture ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching db picture, or <code>null</code> if a matching db picture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.DbPicture fetchBypictureId(
		long pictureId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the db pictures.
	*
	* @return the db pictures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.DbPicture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.DbPicture> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.DbPicture> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the db picture where pictureId = &#63; from the database.
	*
	* @param pictureId the picture ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypictureId(long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchDbPictureException;

	/**
	* Removes all the db pictures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of db pictures where pictureId = &#63;.
	*
	* @param pictureId the picture ID
	* @return the number of matching db pictures
	* @throws SystemException if a system exception occurred
	*/
	public int countBypictureId(long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of db pictures.
	*
	* @return the number of db pictures
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}