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

package com.cmcti.cmts.domain.service.base;

import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;

import java.util.Arrays;

/**
 * @author richard
 * @generated
 */
public class MerchantLocalServiceClpInvoker {
	public MerchantLocalServiceClpInvoker() {
		_methodName0 = "addMerchant";

		_methodParameterTypes0 = new String[] {
				"com.cmcti.cmts.domain.model.Merchant"
			};

		_methodName1 = "createMerchant";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteMerchant";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteMerchant";

		_methodParameterTypes3 = new String[] {
				"com.cmcti.cmts.domain.model.Merchant"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchMerchant";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getMerchant";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getMerchants";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getMerchantsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateMerchant";

		_methodParameterTypes15 = new String[] {
				"com.cmcti.cmts.domain.model.Merchant"
			};

		_methodName88 = "getBeanIdentifier";

		_methodParameterTypes88 = new String[] {  };

		_methodName89 = "setBeanIdentifier";

		_methodParameterTypes89 = new String[] { "java.lang.String" };

		_methodName94 = "fetchByCode";

		_methodParameterTypes94 = new String[] { "java.lang.String" };

		_methodName95 = "updateMerchant";

		_methodParameterTypes95 = new String[] {
				"com.cmcti.cmts.domain.model.Merchant",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName96 = "importMerchant";

		_methodParameterTypes96 = new String[] {
				"java.io.InputStream", "int", "int",
				"com.liferay.portal.service.ServiceContext", "boolean"
			};

		_methodName98 = "addUpstreamToMerchant";

		_methodParameterTypes98 = new String[] {
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName99 = "removeUpstreamFromMerchant";

		_methodParameterTypes99 = new String[] {
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return MerchantLocalServiceUtil.addMerchant((com.cmcti.cmts.domain.model.Merchant)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return MerchantLocalServiceUtil.createMerchant(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return MerchantLocalServiceUtil.deleteMerchant(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return MerchantLocalServiceUtil.deleteMerchant((com.cmcti.cmts.domain.model.Merchant)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return MerchantLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return MerchantLocalServiceUtil.fetchMerchant(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return MerchantLocalServiceUtil.getMerchant(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return MerchantLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return MerchantLocalServiceUtil.getMerchants(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MerchantLocalServiceUtil.getMerchantsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return MerchantLocalServiceUtil.updateMerchant((com.cmcti.cmts.domain.model.Merchant)arguments[0]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return MerchantLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			MerchantLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return MerchantLocalServiceUtil.fetchByCode((java.lang.String)arguments[0]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return MerchantLocalServiceUtil.updateMerchant((com.cmcti.cmts.domain.model.Merchant)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			MerchantLocalServiceUtil.importMerchant((java.io.InputStream)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3],
				((Boolean)arguments[4]).booleanValue());

			return null;
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			MerchantLocalServiceUtil.addUpstreamToMerchant(((Long)arguments[0]).longValue(),
				(java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel>)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			MerchantLocalServiceUtil.removeUpstreamFromMerchant(((Long)arguments[0]).longValue(),
				(java.util.List<com.cmcti.cmts.domain.model.UpstreamChannel>)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
}