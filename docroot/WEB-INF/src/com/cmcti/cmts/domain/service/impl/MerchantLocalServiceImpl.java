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
import com.cmcti.cmts.domain.service.base.MerchantLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the merchant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmcti.cmts.domain.service.MerchantLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.MerchantLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.MerchantLocalServiceUtil
 */
public class MerchantLocalServiceImpl extends MerchantLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmcti.cmts.domain.service.MerchantLocalServiceUtil} to access the merchant local service.
	 */
	
	private static final Log logger = LogFactoryUtil.getLog(MerchantLocalServiceImpl.class.getName());
	
	public Merchant updateMerchant(Merchant merchant, ServiceContext serviceContext) throws PortalException, SystemException {
		return null;
	}
	
	public void importMerchant(InputStream is, int sheetIdx, int startRowIdx, ServiceContext serviceContext) throws PortalException, SystemException {
		
		merchantPersistence.removeAll();
		counterLocalService.reset(Merchant.class.getName());
		
		Iterator<Row> rowIterator = null;
		try (HSSFWorkbook workbook = new HSSFWorkbook(is)) {
			HSSFSheet sheet = workbook.getSheetAt(sheetIdx);
			rowIterator = sheet.iterator();
		} catch (Exception e) {
			logger.error(e);
		}
		
		List<Merchant> merchants = getMerchants(rowIterator, startRowIdx, serviceContext);
		for (Merchant merchant : merchants) {
			merchantPersistence.update(merchant);
		}
	}
	
	private List<Merchant> getMerchants(Iterator<Row> rowIterator, int startRowIdx, ServiceContext serviceContext) throws PortalException, SystemException {
		
		List<Merchant> merchants = new ArrayList<Merchant>();
		
		if (startRowIdx > 0) {
			for (int i = 0; i < startRowIdx; i++) {
				if (rowIterator.hasNext()) rowIterator.next();
			}
		}
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			long merchantId = counterLocalService.increment(Merchant.class.getName());
			Merchant merchant = merchantPersistence.create(merchantId);
			
			// Meta data
			merchant.setUserId(serviceContext.getUserId());
			merchant.setGroupId(serviceContext.getScopeGroupId());
			merchant.setCompanyId(serviceContext.getCompanyId());
			merchant.setCreateDate(serviceContext.getCreateDate());
			merchant.setModifiedDate(serviceContext.getModifiedDate());
			
			// Title
			Cell titleCell = row.getCell(0);
			merchant.setTitle(titleCell.getStringCellValue());
			
			// Code
			Cell codeCell = row.getCell(1);
			merchant.setCode(codeCell.getStringCellValue());
			
			// Parent Code
			Cell parentCodeCell = row.getCell(2);
			merchant.setParentCode(parentCodeCell.getStringCellValue());
			
			// Description
			Cell descCell = row.getCell(3);
			merchant.setDescription(descCell.getStringCellValue());
			
			merchants.add(merchant);
		}
		
		return merchants;
	}
}