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

package com.cmcti.cmts.domain.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.cmcti.cmts.domain.model.Merchant;
import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.service.base.MerchantScopeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the merchant scope local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmcti.cmts.domain.service.MerchantScopeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.MerchantScopeLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil
 */
public class MerchantScopeLocalServiceImpl extends MerchantScopeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil} to access
	 * the merchant scope local service.
	 */

	private static final Log log = LogFactoryUtil.getLog(MerchantScopeLocalServiceImpl.class);

	public List<MerchantScope> findByMerchant(String merchantCode) throws SystemException {
		return merchantScopePersistence.findByMerchant(merchantCode);
	}
	
	public List<Merchant> findByUpstream(long cmtsId, int ifIndex) throws SystemException {
		List<MerchantScope> scopes = merchantScopePersistence.findByUpstreamChannel(cmtsId, ifIndex);
		List<Merchant> merchants = new ArrayList<Merchant>();
		for (MerchantScope scope: scopes) {
			merchants.add(merchantPersistence.fetchByCode(scope.getMerchantCode()));
		}
		return merchants;
	}

	public void addMerchantScopes(List<MerchantScope> scopes, ServiceContext context) throws SystemException, PortalException {
		for (MerchantScope scope: scopes) {
			long cmtsId = scope.getCmtsId();
			int ifIndex = scope.getIfIndex();
			String merchantCode = scope.getMerchantCode();
			MerchantScope checkScope = merchantScopePersistence.fetchByC_I_M(merchantCode, cmtsId, ifIndex);
			if (checkScope == null) {
				long scopeId = counterLocalService.increment(MerchantScope.class.getName());
				checkScope = merchantScopePersistence.create(scopeId);
				checkScope.setUserId(context.getUserId());
				checkScope.setCompanyId(context.getCompanyId());
				checkScope.setGroupId(context.getScopeGroupId());
				checkScope.setCreateDate(context.getCreateDate());
				checkScope.setModifiedDate(context.getModifiedDate());
				checkScope.setCmtsId(cmtsId);
				checkScope.setIfIndex(ifIndex);
				checkScope.setMerchantCode(merchantCode);
				merchantScopePersistence.update(checkScope);
			}
		}
	}

	public void removeMerchantScopes(List<MerchantScope> scopes, ServiceContext context) throws SystemException, PortalException {
		for (MerchantScope scope: scopes) {
			long cmtsId = scope.getCmtsId();
			int ifIndex = scope.getIfIndex();
			String merchantCode = scope.getMerchantCode();
			MerchantScope checkScope = merchantScopePersistence.fetchByC_I_M(merchantCode, cmtsId, ifIndex);
			if (checkScope != null) {
				merchantScopePersistence.remove(checkScope);
			}
		}
	}

	public MerchantScope updateMerchantScope(MerchantScope merchantScope, ServiceContext context) throws PortalException, SystemException {

		if (merchantScope.getMerchantScopeId() == 0) {
			long merchantScopeId = counterLocalService.increment(MerchantScope.class.getName());
			merchantScope.setMerchantScopeId(merchantScopeId);
			merchantScope.setCompanyId(context.getCompanyId());
			merchantScope.setGroupId(context.getScopeGroupId());
			merchantScope.setUserId(context.getUserId());
			merchantScope.setCreateDate(context.getCreateDate());
		}

		merchantScope.setModifiedDate(context.getModifiedDate());

		if (Validator.isNull(merchantScope.getMerchantCode())) {
			throw new PortalException("merchant-is-required");
		}

		return merchantScopePersistence.update(merchantScope);
	}

	public void deleteByMerchant(String code) throws PortalException, SystemException {
		merchantScopePersistence.removeByMerchant(code);
	}

	public void importMerchant(InputStream is, int sheetIdx, int startRowIdx, ServiceContext serviceContext) throws PortalException,
			SystemException {

		merchantScopePersistence.removeAll();
		counterLocalService.reset(MerchantScope.class.getName());

		Iterator<Row> rowIterator = null;
		try (HSSFWorkbook workbook = new HSSFWorkbook(is)) {
			HSSFSheet sheet = workbook.getSheetAt(sheetIdx);
			rowIterator = sheet.iterator();
		} catch (Exception e) {
			log.error(e);
		}

		List<MerchantScope> merchants = getMerchants(rowIterator, startRowIdx, serviceContext);
		for (MerchantScope merchant : merchants) {
			merchantScopePersistence.update(merchant);
		}
	}

	private List<MerchantScope> getMerchants(Iterator<Row> rowIterator, int startRowIdx, ServiceContext serviceContext)
			throws PortalException, SystemException {

		List<MerchantScope> merchants = new ArrayList<MerchantScope>();

		if (startRowIdx > 0) {
			for (int i = 0; i < startRowIdx; i++) {
				if (rowIterator.hasNext())
					rowIterator.next();
			}
		}

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			long merchantScopeId = counterLocalService.increment(MerchantScope.class.getName());
			MerchantScope merchantScope = merchantScopePersistence.create(merchantScopeId);

			// Meta data
			merchantScope.setUserId(serviceContext.getUserId());
			merchantScope.setGroupId(serviceContext.getScopeGroupId());
			merchantScope.setCompanyId(serviceContext.getCompanyId());
			merchantScope.setCreateDate(serviceContext.getCreateDate());
			merchantScope.setModifiedDate(serviceContext.getModifiedDate());

			// CMTSID
			Cell cmtsIdCell = row.getCell(0);
			merchantScope.setCmtsId(GetterUtil.getLong(cmtsIdCell.getStringCellValue()));

			// IfIndex
			Cell ifIndexCell = row.getCell(1);
			merchantScope.setIfIndex(GetterUtil.getInteger(ifIndexCell.getStringCellValue()));

			// Merchat Code
			Cell merchantCodeCell = row.getCell(2);
			merchantScope.setMerchantCode(merchantCodeCell.getStringCellValue());

			merchants.add(merchantScope);
		}

		return merchants;
	}
}