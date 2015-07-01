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

import com.cmcti.cmts.domain.NoSuchCustomerMacMappingException;
import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.service.base.CustomerMacMappingLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the customer mac mapping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmcti.cmts.domain.service.CustomerMacMappingLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.CustomerMacMappingLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil
 */
public class CustomerMacMappingLocalServiceImpl extends CustomerMacMappingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil} to
	 * access the customer mac mapping local service.
	 */
	
	private static final Log logger = LogFactoryUtil.getLog(CustomerMacMappingLocalServiceImpl.class);
	
	public CustomerMacMapping getByMacAddress(String macAddress) throws NoSuchCustomerMacMappingException, SystemException {
		return customerMacMappingPersistence.findByMacAddress(macAddress);
	}

	public void importAddressFromXls(InputStream is, int sheetIdx, int startRow, ServiceContext serviceContext) throws PortalException, SystemException {
		// Remove all data
		customerMacMappingPersistence.removeAll();
		counterLocalService.reset(CustomerMacMapping.class.getName());
		
		Iterator<Row> rowIterator = null;
		try (HSSFWorkbook workbook = new HSSFWorkbook(is)) {
			
			HSSFSheet sheet = workbook.getSheetAt(sheetIdx);
			rowIterator = sheet.iterator();
		} catch (Exception e) {
			logger.error(e);
		}
			
		List<CustomerMacMapping> mappings = getCustomerMacMappings(rowIterator, startRow, serviceContext);
		
		for (CustomerMacMapping mapping : mappings) {
			customerMacMappingPersistence.update(mapping);
		}
	}
	
	private List<CustomerMacMapping> getCustomerMacMappings(Iterator<Row> rowIterator, int startRow, ServiceContext serviceContext) throws SystemException {
		List<CustomerMacMapping> list = new ArrayList<CustomerMacMapping>();
		
		if (startRow > 0) {
			for (int i = 0; i < startRow; i++) {
				if (rowIterator.hasNext()) rowIterator.next();
			}
		}
		
		while (rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			
			long customerMacId = counterLocalService.increment(CustomerMacMapping.class.getName());
			CustomerMacMapping mapping = customerMacMappingPersistence.create(customerMacId);
			
			// Meta data
			mapping.setUserId(serviceContext.getUserId());
			mapping.setGroupId(serviceContext.getScopeGroupId());
			mapping.setCompanyId(serviceContext.getCompanyId());
			mapping.setCreateDate(serviceContext.getCreateDate());
			mapping.setModifiedDate(serviceContext.getModifiedDate());
			
			// Mac address
			Cell macCell = row.getCell(0);
			mapping.setMacAddress(macCell.getStringCellValue());
			// Title
			Cell titleCell = row.getCell(1);
			mapping.setTitle(titleCell.getStringCellValue());
			
			list.add(mapping);
		}
		
		return list;
	}
}