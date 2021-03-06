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

package com.cmcti.cmts.domain.model.impl;

import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.model.MerchantScopeModel;
import com.cmcti.cmts.domain.model.MerchantScopeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MerchantScope service. Represents a row in the &quot;CMTS_MerchantScope&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmcti.cmts.domain.model.MerchantScopeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MerchantScopeImpl}.
 * </p>
 *
 * @author richard
 * @see MerchantScopeImpl
 * @see com.cmcti.cmts.domain.model.MerchantScope
 * @see com.cmcti.cmts.domain.model.MerchantScopeModel
 * @generated
 */
@JSON(strict = true)
public class MerchantScopeModelImpl extends BaseModelImpl<MerchantScope>
	implements MerchantScopeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a merchant scope model instance should use the {@link com.cmcti.cmts.domain.model.MerchantScope} interface instead.
	 */
	public static final String TABLE_NAME = "CMTS_MerchantScope";
	public static final Object[][] TABLE_COLUMNS = {
			{ "merchantScopeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "cmtsId", Types.BIGINT },
			{ "ifIndex", Types.INTEGER },
			{ "merchantCode", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CMTS_MerchantScope (merchantScopeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,cmtsId LONG,ifIndex INTEGER,merchantCode VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CMTS_MerchantScope";
	public static final String ORDER_BY_JPQL = " ORDER BY merchantScope.merchantScopeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CMTS_MerchantScope.merchantScopeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmcti.cmts.domain.model.MerchantScope"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmcti.cmts.domain.model.MerchantScope"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cmcti.cmts.domain.model.MerchantScope"),
			true);
	public static long CMTSID_COLUMN_BITMASK = 1L;
	public static long IFINDEX_COLUMN_BITMASK = 2L;
	public static long MERCHANTCODE_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;
	public static long MERCHANTSCOPEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MerchantScope toModel(MerchantScopeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MerchantScope model = new MerchantScopeImpl();

		model.setMerchantScopeId(soapModel.getMerchantScopeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCmtsId(soapModel.getCmtsId());
		model.setIfIndex(soapModel.getIfIndex());
		model.setMerchantCode(soapModel.getMerchantCode());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MerchantScope> toModels(MerchantScopeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MerchantScope> models = new ArrayList<MerchantScope>(soapModels.length);

		for (MerchantScopeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmcti.cmts.domain.model.MerchantScope"));

	public MerchantScopeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _merchantScopeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMerchantScopeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _merchantScopeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MerchantScope.class;
	}

	@Override
	public String getModelClassName() {
		return MerchantScope.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("merchantScopeId", getMerchantScopeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cmtsId", getCmtsId());
		attributes.put("ifIndex", getIfIndex());
		attributes.put("merchantCode", getMerchantCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long merchantScopeId = (Long)attributes.get("merchantScopeId");

		if (merchantScopeId != null) {
			setMerchantScopeId(merchantScopeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long cmtsId = (Long)attributes.get("cmtsId");

		if (cmtsId != null) {
			setCmtsId(cmtsId);
		}

		Integer ifIndex = (Integer)attributes.get("ifIndex");

		if (ifIndex != null) {
			setIfIndex(ifIndex);
		}

		String merchantCode = (String)attributes.get("merchantCode");

		if (merchantCode != null) {
			setMerchantCode(merchantCode);
		}
	}

	@JSON
	@Override
	public long getMerchantScopeId() {
		return _merchantScopeId;
	}

	@Override
	public void setMerchantScopeId(long merchantScopeId) {
		_merchantScopeId = merchantScopeId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCmtsId() {
		return _cmtsId;
	}

	@Override
	public void setCmtsId(long cmtsId) {
		_columnBitmask |= CMTSID_COLUMN_BITMASK;

		if (!_setOriginalCmtsId) {
			_setOriginalCmtsId = true;

			_originalCmtsId = _cmtsId;
		}

		_cmtsId = cmtsId;
	}

	public long getOriginalCmtsId() {
		return _originalCmtsId;
	}

	@JSON
	@Override
	public int getIfIndex() {
		return _ifIndex;
	}

	@Override
	public void setIfIndex(int ifIndex) {
		_columnBitmask |= IFINDEX_COLUMN_BITMASK;

		if (!_setOriginalIfIndex) {
			_setOriginalIfIndex = true;

			_originalIfIndex = _ifIndex;
		}

		_ifIndex = ifIndex;
	}

	public int getOriginalIfIndex() {
		return _originalIfIndex;
	}

	@JSON
	@Override
	public String getMerchantCode() {
		if (_merchantCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _merchantCode;
		}
	}

	@Override
	public void setMerchantCode(String merchantCode) {
		_columnBitmask |= MERCHANTCODE_COLUMN_BITMASK;

		if (_originalMerchantCode == null) {
			_originalMerchantCode = _merchantCode;
		}

		_merchantCode = merchantCode;
	}

	public String getOriginalMerchantCode() {
		return GetterUtil.getString(_originalMerchantCode);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MerchantScope.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MerchantScope toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MerchantScope)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MerchantScopeImpl merchantScopeImpl = new MerchantScopeImpl();

		merchantScopeImpl.setMerchantScopeId(getMerchantScopeId());
		merchantScopeImpl.setGroupId(getGroupId());
		merchantScopeImpl.setCompanyId(getCompanyId());
		merchantScopeImpl.setUserId(getUserId());
		merchantScopeImpl.setUserName(getUserName());
		merchantScopeImpl.setCreateDate(getCreateDate());
		merchantScopeImpl.setModifiedDate(getModifiedDate());
		merchantScopeImpl.setCmtsId(getCmtsId());
		merchantScopeImpl.setIfIndex(getIfIndex());
		merchantScopeImpl.setMerchantCode(getMerchantCode());

		merchantScopeImpl.resetOriginalValues();

		return merchantScopeImpl;
	}

	@Override
	public int compareTo(MerchantScope merchantScope) {
		long primaryKey = merchantScope.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MerchantScope)) {
			return false;
		}

		MerchantScope merchantScope = (MerchantScope)obj;

		long primaryKey = merchantScope.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MerchantScopeModelImpl merchantScopeModelImpl = this;

		merchantScopeModelImpl._originalUserId = merchantScopeModelImpl._userId;

		merchantScopeModelImpl._setOriginalUserId = false;

		merchantScopeModelImpl._originalCmtsId = merchantScopeModelImpl._cmtsId;

		merchantScopeModelImpl._setOriginalCmtsId = false;

		merchantScopeModelImpl._originalIfIndex = merchantScopeModelImpl._ifIndex;

		merchantScopeModelImpl._setOriginalIfIndex = false;

		merchantScopeModelImpl._originalMerchantCode = merchantScopeModelImpl._merchantCode;

		merchantScopeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MerchantScope> toCacheModel() {
		MerchantScopeCacheModel merchantScopeCacheModel = new MerchantScopeCacheModel();

		merchantScopeCacheModel.merchantScopeId = getMerchantScopeId();

		merchantScopeCacheModel.groupId = getGroupId();

		merchantScopeCacheModel.companyId = getCompanyId();

		merchantScopeCacheModel.userId = getUserId();

		merchantScopeCacheModel.userName = getUserName();

		String userName = merchantScopeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			merchantScopeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			merchantScopeCacheModel.createDate = createDate.getTime();
		}
		else {
			merchantScopeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			merchantScopeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			merchantScopeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		merchantScopeCacheModel.cmtsId = getCmtsId();

		merchantScopeCacheModel.ifIndex = getIfIndex();

		merchantScopeCacheModel.merchantCode = getMerchantCode();

		String merchantCode = merchantScopeCacheModel.merchantCode;

		if ((merchantCode != null) && (merchantCode.length() == 0)) {
			merchantScopeCacheModel.merchantCode = null;
		}

		return merchantScopeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{merchantScopeId=");
		sb.append(getMerchantScopeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", cmtsId=");
		sb.append(getCmtsId());
		sb.append(", ifIndex=");
		sb.append(getIfIndex());
		sb.append(", merchantCode=");
		sb.append(getMerchantCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.cmcti.cmts.domain.model.MerchantScope");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>merchantScopeId</column-name><column-value><![CDATA[");
		sb.append(getMerchantScopeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmtsId</column-name><column-value><![CDATA[");
		sb.append(getCmtsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifIndex</column-name><column-value><![CDATA[");
		sb.append(getIfIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>merchantCode</column-name><column-value><![CDATA[");
		sb.append(getMerchantCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MerchantScope.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MerchantScope.class
		};
	private long _merchantScopeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cmtsId;
	private long _originalCmtsId;
	private boolean _setOriginalCmtsId;
	private int _ifIndex;
	private int _originalIfIndex;
	private boolean _setOriginalIfIndex;
	private String _merchantCode;
	private String _originalMerchantCode;
	private long _columnBitmask;
	private MerchantScope _escapedModel;
}