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

import org.politaktiv.map.infrastructure.model.BackgroundClp;
import org.politaktiv.map.infrastructure.model.MarkerClp;
import org.politaktiv.map.infrastructure.model.PictureClp;

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

		if (oldModelClassName.equals(BackgroundClp.class.getName())) {
			return translateInputBackground(oldModel);
		}

		if (oldModelClassName.equals(MarkerClp.class.getName())) {
			return translateInputMarker(oldModel);
		}

		if (oldModelClassName.equals(PictureClp.class.getName())) {
			return translateInputPicture(oldModel);
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

	public static Object translateInputBackground(BaseModel<?> oldModel) {
		BackgroundClp oldCplModel = (BackgroundClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.BackgroundImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setBackgroundId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getBackgroundId());

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

				Method method5 = newModelClass.getMethod("setFileEntryUuid",
						new Class[] { String.class });

				String value5 = oldCplModel.getFileEntryUuid();

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

	public static Object translateInputMarker(BaseModel<?> oldModel) {
		MarkerClp oldCplModel = (MarkerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.MarkerImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setMarkerId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getMarkerId());

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

				Method method7 = newModelClass.getMethod("setBackgroundId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getBackgroundId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setLongitude",
						new Class[] { Double.TYPE });

				Double value8 = new Double(oldCplModel.getLongitude());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setLatitude",
						new Class[] { Double.TYPE });

				Double value9 = new Double(oldCplModel.getLatitude());

				method9.invoke(newModel, value9);

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

	public static Object translateInputPicture(BaseModel<?> oldModel) {
		PictureClp oldCplModel = (PictureClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.politaktiv.map.infrastructure.model.impl.PictureImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPictureId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getPictureId());

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

				Method method7 = newModelClass.getMethod("setBackgroundId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getBackgroundId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setRotation",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getRotation());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setWidth",
						new Class[] { Double.TYPE });

				Double value9 = new Double(oldCplModel.getWidth());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setHeight",
						new Class[] { Double.TYPE });

				Double value10 = new Double(oldCplModel.getHeight());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setResolution",
						new Class[] { Double.TYPE });

				Double value11 = new Double(oldCplModel.getResolution());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setOcupacy",
						new Class[] { Double.TYPE });

				Double value12 = new Double(oldCplModel.getOcupacy());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLongitude",
						new Class[] { Double.TYPE });

				Double value13 = new Double(oldCplModel.getLongitude());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setLatitude",
						new Class[] { Double.TYPE });

				Double value14 = new Double(oldCplModel.getLatitude());

				method14.invoke(newModel, value14);

				Method method15 = newModelClass.getMethod("setFileEntryUuid",
						new Class[] { String.class });

				String value15 = oldCplModel.getFileEntryUuid();

				method15.invoke(newModel, value15);

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
					"org.politaktiv.map.infrastructure.model.impl.BackgroundImpl")) {
			return translateOutputBackground(oldModel);
		}

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.MarkerImpl")) {
			return translateOutputMarker(oldModel);
		}

		if (oldModelClassName.equals(
					"org.politaktiv.map.infrastructure.model.impl.PictureImpl")) {
			return translateOutputPicture(oldModel);
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

	public static Object translateOutputBackground(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				BackgroundClp newModel = new BackgroundClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getBackgroundId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setBackgroundId(value0);

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

				Method method5 = oldModelClass.getMethod("getFileEntryUuid");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setFileEntryUuid(value5);

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

	public static Object translateOutputMarker(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				MarkerClp newModel = new MarkerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getMarkerId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setMarkerId(value0);

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

				Method method7 = oldModelClass.getMethod("getBackgroundId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setBackgroundId(value7);

				Method method8 = oldModelClass.getMethod("getLongitude");

				Double value8 = (Double)method8.invoke(oldModel, (Object[])null);

				newModel.setLongitude(value8);

				Method method9 = oldModelClass.getMethod("getLatitude");

				Double value9 = (Double)method9.invoke(oldModel, (Object[])null);

				newModel.setLatitude(value9);

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

	public static Object translateOutputPicture(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				PictureClp newModel = new PictureClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPictureId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setPictureId(value0);

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

				Method method7 = oldModelClass.getMethod("getBackgroundId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setBackgroundId(value7);

				Method method8 = oldModelClass.getMethod("getRotation");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setRotation(value8);

				Method method9 = oldModelClass.getMethod("getWidth");

				Double value9 = (Double)method9.invoke(oldModel, (Object[])null);

				newModel.setWidth(value9);

				Method method10 = oldModelClass.getMethod("getHeight");

				Double value10 = (Double)method10.invoke(oldModel,
						(Object[])null);

				newModel.setHeight(value10);

				Method method11 = oldModelClass.getMethod("getResolution");

				Double value11 = (Double)method11.invoke(oldModel,
						(Object[])null);

				newModel.setResolution(value11);

				Method method12 = oldModelClass.getMethod("getOcupacy");

				Double value12 = (Double)method12.invoke(oldModel,
						(Object[])null);

				newModel.setOcupacy(value12);

				Method method13 = oldModelClass.getMethod("getLongitude");

				Double value13 = (Double)method13.invoke(oldModel,
						(Object[])null);

				newModel.setLongitude(value13);

				Method method14 = oldModelClass.getMethod("getLatitude");

				Double value14 = (Double)method14.invoke(oldModel,
						(Object[])null);

				newModel.setLatitude(value14);

				Method method15 = oldModelClass.getMethod("getFileEntryUuid");

				String value15 = (String)method15.invoke(oldModel,
						(Object[])null);

				newModel.setFileEntryUuid(value15);

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