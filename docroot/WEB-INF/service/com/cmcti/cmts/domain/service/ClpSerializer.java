/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.cmcti.cmts.domain.service;

import com.cmcti.cmts.domain.model.CableModemClp;
import com.cmcti.cmts.domain.model.CableModemHistoryClp;
import com.cmcti.cmts.domain.model.CmtsClp;
import com.cmcti.cmts.domain.model.CustomerMacMappingClp;
import com.cmcti.cmts.domain.model.UpstreamChannelClp;
import com.cmcti.cmts.domain.model.UpstreamChannelHistoryClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
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
						"cmts-mo-portlet-deployment-context");

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
							"cmts-mo-portlet-deployment-context");

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
				_servletContextName = "cmts-mo-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CableModemClp.class.getName())) {
			return translateInputCableModem(oldModel);
		}

		if (oldModelClassName.equals(CableModemHistoryClp.class.getName())) {
			return translateInputCableModemHistory(oldModel);
		}

		if (oldModelClassName.equals(CmtsClp.class.getName())) {
			return translateInputCmts(oldModel);
		}

		if (oldModelClassName.equals(CustomerMacMappingClp.class.getName())) {
			return translateInputCustomerMacMapping(oldModel);
		}

		if (oldModelClassName.equals(UpstreamChannelClp.class.getName())) {
			return translateInputUpstreamChannel(oldModel);
		}

		if (oldModelClassName.equals(UpstreamChannelHistoryClp.class.getName())) {
			return translateInputUpstreamChannelHistory(oldModel);
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

	public static Object translateInputCableModem(BaseModel<?> oldModel) {
		CableModemClp oldClpModel = (CableModemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCableModemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCableModemHistory(BaseModel<?> oldModel) {
		CableModemHistoryClp oldClpModel = (CableModemHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCableModemHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCmts(BaseModel<?> oldModel) {
		CmtsClp oldClpModel = (CmtsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCmtsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCustomerMacMapping(BaseModel<?> oldModel) {
		CustomerMacMappingClp oldClpModel = (CustomerMacMappingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCustomerMacMappingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUpstreamChannel(BaseModel<?> oldModel) {
		UpstreamChannelClp oldClpModel = (UpstreamChannelClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUpstreamChannelRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUpstreamChannelHistory(
		BaseModel<?> oldModel) {
		UpstreamChannelHistoryClp oldClpModel = (UpstreamChannelHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUpstreamChannelHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
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
					"com.cmcti.cmts.domain.model.impl.CableModemImpl")) {
			return translateOutputCableModem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.cmcti.cmts.domain.model.impl.CableModemHistoryImpl")) {
			return translateOutputCableModemHistory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.cmcti.cmts.domain.model.impl.CmtsImpl")) {
			return translateOutputCmts(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.cmcti.cmts.domain.model.impl.CustomerMacMappingImpl")) {
			return translateOutputCustomerMacMapping(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.cmcti.cmts.domain.model.impl.UpstreamChannelImpl")) {
			return translateOutputUpstreamChannel(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.cmcti.cmts.domain.model.impl.UpstreamChannelHistoryImpl")) {
			return translateOutputUpstreamChannelHistory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
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

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.cmcti.cmts.domain.NoSuchCableModemException")) {
			return new com.cmcti.cmts.domain.NoSuchCableModemException();
		}

		if (className.equals(
					"com.cmcti.cmts.domain.NoSuchCableModemHistoryException")) {
			return new com.cmcti.cmts.domain.NoSuchCableModemHistoryException();
		}

		if (className.equals("com.cmcti.cmts.domain.NoSuchCmtsException")) {
			return new com.cmcti.cmts.domain.NoSuchCmtsException();
		}

		if (className.equals(
					"com.cmcti.cmts.domain.NoSuchCustomerMacMappingException")) {
			return new com.cmcti.cmts.domain.NoSuchCustomerMacMappingException();
		}

		if (className.equals(
					"com.cmcti.cmts.domain.NoSuchUpstreamChannelException")) {
			return new com.cmcti.cmts.domain.NoSuchUpstreamChannelException();
		}

		if (className.equals(
					"com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException")) {
			return new com.cmcti.cmts.domain.NoSuchUpstreamChannelHistoryException();
		}

		return throwable;
	}

	public static Object translateOutputCableModem(BaseModel<?> oldModel) {
		CableModemClp newModel = new CableModemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCableModemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCableModemHistory(BaseModel<?> oldModel) {
		CableModemHistoryClp newModel = new CableModemHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCableModemHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCmts(BaseModel<?> oldModel) {
		CmtsClp newModel = new CmtsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCmtsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCustomerMacMapping(
		BaseModel<?> oldModel) {
		CustomerMacMappingClp newModel = new CustomerMacMappingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCustomerMacMappingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUpstreamChannel(BaseModel<?> oldModel) {
		UpstreamChannelClp newModel = new UpstreamChannelClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUpstreamChannelRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUpstreamChannelHistory(
		BaseModel<?> oldModel) {
		UpstreamChannelHistoryClp newModel = new UpstreamChannelHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUpstreamChannelHistoryRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}