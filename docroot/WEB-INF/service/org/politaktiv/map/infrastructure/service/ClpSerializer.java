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

package org.politaktiv.map.infrastructure.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.politaktiv.map.infrastructure.model.DbMapObjectClp;
import org.politaktiv.map.infrastructure.model.DbMarkerClp;
import org.politaktiv.map.infrastructure.model.DbPictureClp;
import org.politaktiv.map.infrastructure.model.DbPointClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"politaktiv-map-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"politaktiv-map-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "politaktiv-map-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DbMapObjectClp.class.getName())) {
			return translateInputDbMapObject(oldModel);
		}

		if (oldModelClassName.equals(DbMarkerClp.class.getName())) {
			return translateInputDbMarker(oldModel);
		}

		if (oldModelClassName.equals(DbPictureClp.class.getName())) {
			return translateInputDbPicture(oldModel);
		}

		if (oldModelClassName.equals(DbPointClp.class.getName())) {
			return translateInputDbPoint(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDbMapObject(BaseModel<?> oldModel) {
		DbMapObjectClp oldCplModel = (DbMapObjectClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.DbMapObjectImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setMapObjectId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getMapObjectId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCompanyId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getGroupId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value4 = oldCplModel.getName();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value5 = oldCplModel.getDescription();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setReferenceUrl",
						new Class[] { String.class });

				String value6 = oldCplModel.getReferenceUrl();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setOccupancy",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getOccupancy());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setMapId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getMapId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setType",
						new Class[] { String.class });

				String value9 = oldCplModel.getType();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setGraphicObjectId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getGraphicObjectId());

				method10.invoke(newModel, value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputDbMarker(BaseModel<?> oldModel) {
		DbMarkerClp oldCplModel = (DbMarkerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.DbMarkerImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setMarkerId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getMarkerId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setMarkerImageName",
						new Class[] { String.class });

				String value1 = oldCplModel.getMarkerImageName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setPointId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getPointId());

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputDbPicture(BaseModel<?> oldModel) {
		DbPictureClp oldCplModel = (DbPictureClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.DbPictureImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPictureId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getPictureId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setRotation",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getRotation());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setWidth",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getWidth());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setHeight",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getHeight());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setResolution",
						new Class[] { Double.TYPE });

				Double value4 = new Double(oldCplModel.getResolution());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPointId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getPointId());

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputDbPoint(BaseModel<?> oldModel) {
		DbPointClp oldCplModel = (DbPointClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.DbPointImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPointId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getPointId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setLongitude",
						new Class[] { Double.TYPE });

				Double value1 = new Double(oldCplModel.getLongitude());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLatitude",
						new Class[] { Double.TYPE });

				Double value2 = new Double(oldCplModel.getLatitude());

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.DbMapObjectImpl")) {
			return translateOutputDbMapObject(oldModel);
		}

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.DbMarkerImpl")) {
			return translateOutputDbMarker(oldModel);
		}

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.DbPictureImpl")) {
			return translateOutputDbPicture(oldModel);
		}

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.DbPointImpl")) {
			return translateOutputDbPoint(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputDbMapObject(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DbMapObjectClp newModel = new DbMapObjectClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getMapObjectId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setMapObjectId(value0);

				Method method1 = oldModelClass.getMethod("getCompanyId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value1);

				Method method2 = oldModelClass.getMethod("getGroupId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getName");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setName(value4);

				Method method5 = oldModelClass.getMethod("getDescription");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setDescription(value5);

				Method method6 = oldModelClass.getMethod("getReferenceUrl");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setReferenceUrl(value6);

				Method method7 = oldModelClass.getMethod("getOccupancy");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setOccupancy(value7);

				Method method8 = oldModelClass.getMethod("getMapId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setMapId(value8);

				Method method9 = oldModelClass.getMethod("getType");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setType(value9);

				Method method10 = oldModelClass.getMethod("getGraphicObjectId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setGraphicObjectId(value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputDbMarker(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DbMarkerClp newModel = new DbMarkerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getMarkerId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setMarkerId(value0);

				Method method1 = oldModelClass.getMethod("getMarkerImageName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setMarkerImageName(value1);

				Method method2 = oldModelClass.getMethod("getPointId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setPointId(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputDbPicture(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DbPictureClp newModel = new DbPictureClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPictureId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setPictureId(value0);

				Method method1 = oldModelClass.getMethod("getRotation");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setRotation(value1);

				Method method2 = oldModelClass.getMethod("getWidth");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setWidth(value2);

				Method method3 = oldModelClass.getMethod("getHeight");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setHeight(value3);

				Method method4 = oldModelClass.getMethod("getResolution");

				Double value4 = (Double)method4.invoke(oldModel, (Object[])null);

				newModel.setResolution(value4);

				Method method5 = oldModelClass.getMethod("getPointId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setPointId(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputDbPoint(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DbPointClp newModel = new DbPointClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPointId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setPointId(value0);

				Method method1 = oldModelClass.getMethod("getLongitude");

				Double value1 = (Double)method1.invoke(oldModel, (Object[])null);

				newModel.setLongitude(value1);

				Method method2 = oldModelClass.getMethod("getLatitude");

				Double value2 = (Double)method2.invoke(oldModel, (Object[])null);

				newModel.setLatitude(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}