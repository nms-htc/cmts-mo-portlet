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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.model.UpChannelMetadata;
import com.cmcti.cmts.domain.service.base.UpChannelMetadataLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the up channel metadata local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmcti.cmts.domain.service.UpChannelMetadataLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author richard
 * @see com.cmcti.cmts.domain.service.base.UpChannelMetadataLocalServiceBaseImpl
 * @see com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil
 */
public class UpChannelMetadataLocalServiceImpl extends UpChannelMetadataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil} to
	 * access the up channel metadata local service.
	 */
	private static final Log logger = LogFactoryUtil.getLog(UpChannelMetadataLocalServiceImpl.class);

	public UpChannelMetadata update(UpChannelMetadata upChannelMetadata, ServiceContext context) throws SystemException {
		if (upChannelMetadata.isNew()) {
			long metaId = counterLocalService.increment(UpChannelMetadata.class.getName());
			upChannelMetadata.setMetaId(metaId);
		}

		return upChannelMetadataPersistence.update(upChannelMetadata);
	}

	public UpChannelMetadata findByCmtsAndIfIndex(long cmtsId, int ifIndex) throws SystemException {
		return upChannelMetadataPersistence.fetchByUpstreamChannel(cmtsId, ifIndex);
	}

	public void importAddressFromXls(InputStream is, int sheetIdx, int startRow, ServiceContext serviceContext, boolean deleteAll)
			throws PortalException, SystemException {
		// Remove all data
		if (deleteAll) {
			upChannelMetadataPersistence.removeAll();
			counterLocalService.reset(UpChannelMetadata.class.getName());
		}

		Iterator<Row> rowIterator = null;
		try (HSSFWorkbook workbook = new HSSFWorkbook(is)) {

			HSSFSheet sheet = workbook.getSheetAt(sheetIdx);
			rowIterator = sheet.iterator();
		} catch (Exception e) {
			logger.error(e);
		}

		List<UpChannelMetadata> mappings = getUpstreamMetas(rowIterator, startRow, serviceContext);

		for (UpChannelMetadata mapping : mappings) {
			// remove all merchant mappping
			merchantScopePersistence.removeByUpstreamChannel(mapping.getCmtsId(), mapping.getIfIndex());
			// create merchant scope mapping
			if (mapping.getMerchantCodes() != null && mapping.getMerchantCodes().size() > 0) {
				for (String merchantCode : mapping.getMerchantCodes()) {
					MerchantScope scope = merchantScopePersistence.create(0);
					scope.setCmtsId(mapping.getCmtsId());
					scope.setIfIndex(mapping.getIfIndex());
					scope.setMerchantCode(merchantCode);
					merchantScopeLocalService.updateMerchantScope(scope, serviceContext);
				}
			}

			upChannelMetadataPersistence.update(mapping);
		}
	}

	private List<UpChannelMetadata> getUpstreamMetas(Iterator<Row> rowIterator, int startRow, ServiceContext serviceContext)
			throws SystemException {
		List<UpChannelMetadata> list = new ArrayList<UpChannelMetadata>();

		if (startRow > 0) {
			for (int i = 0; i < startRow; i++) {
				if (rowIterator.hasNext())
					rowIterator.next();
			}
		}

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			long metaId = counterLocalService.increment(UpChannelMetadata.class.getName());
			UpChannelMetadata metaData = upChannelMetadataPersistence.create(metaId);

			// CmtsId
			Cell cmtsCell = row.getCell(0);
			metaData.setCmtsId(GetterUtil.getLong(getStringCellValue(cmtsCell), 0));
			// If index
			Cell ifIndexCell = row.getCell(1);
			metaData.setIfIndex(GetterUtil.getInteger(getStringCellValue(ifIndexCell), 0));

			// dsFrequency
			Cell dsFrequencyCell = row.getCell(2);
			metaData.setDsFrequency(getStringCellValue(dsFrequencyCell));
			// dsQam
			Cell dsQamCell = row.getCell(3);
			metaData.setDsQam(getStringCellValue(dsQamCell));
			// Merchants Code
			Cell merCell = row.getCell(4);
			String merchantCodes = getStringCellValue(merCell);
			if (Validator.isNotNull(merchantCodes)) {
				metaData.setMerchantCodes(Arrays.asList(merchantCodes.split(",")));
			}

			list.add(metaData);
		}

		return list;
	}

	private String getStringCellValue(Cell cell) {
		String value = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		case Cell.CELL_TYPE_FORMULA:
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			double doubleValue = cell.getNumericCellValue();
			if (doubleValue == (int) doubleValue) {
				value = String.format("%d", (int) doubleValue);
			} else {
				value = String.format("%s", doubleValue);
			}

			break;
		}

		return value;
	}
}