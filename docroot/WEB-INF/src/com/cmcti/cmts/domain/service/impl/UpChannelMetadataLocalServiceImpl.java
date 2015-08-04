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

		List<UpChannelMetadata> mappings = getUpstreamMetas(rowIterator, startRow, serviceContext, deleteAll);

		for (UpChannelMetadata mapping : mappings) {
			merchantScopePersistence.removeByUpstreamChannel(mapping.getCmtsId(), mapping.getIfIndex());
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

	private List<UpChannelMetadata> getUpstreamMetas(Iterator<Row> rowIterator, int startRow, ServiceContext serviceContext, boolean deleteAll)
			throws SystemException {
		List<UpChannelMetadata> list = new ArrayList<UpChannelMetadata>();

		if (startRow > 0) {
			for (int i = 0; i < startRow; i++) {
				if (rowIterator.hasNext())
					rowIterator.next();
			}
		}

		while (rowIterator.hasNext()) {
			
			UpChannelMetadata metadata = null;
			long cmtsId;
			int ifIndex;
			String dsFrequency = null;
			String qam = null;
			List<String> merchants = new ArrayList<String>();
			
			try {
				Row row = rowIterator.next();
				Cell cmtsCell = row.getCell(0);
				cmtsId = GetterUtil.getLong(getStringCellValue(cmtsCell), 0);
				Cell ifIndexCell = row.getCell(1);
				ifIndex = GetterUtil.getInteger(getStringCellValue(ifIndexCell), 0);
				Cell dsFrequencyCell = row.getCell(2);
				dsFrequency = getStringCellValue(dsFrequencyCell);
				Cell dsQamCell = row.getCell(3);
				qam = getStringCellValue(dsQamCell);
				Cell merCell = row.getCell(4);
				String merchantCodes = getStringCellValue(merCell);
				if (Validator.isNotNull(merchantCodes)) {
					merchants = Arrays.asList(merchantCodes.split(","));
				}
				
			} catch (Exception e) {
				logger.error(e);
				continue;
			}
			
			if (Validator.isNull(cmtsId) || Validator.isNull(ifIndex)) continue;
			
			metadata = upChannelMetadataPersistence.fetchByUpstreamChannel(cmtsId, ifIndex);
			
			if (deleteAll || metadata == null) {
				long metaId = counterLocalService.increment(UpChannelMetadata.class.getName());
				metadata = upChannelMetadataPersistence.create(metaId);
			}
			
			metadata.setCmtsId(cmtsId);
			metadata.setIfIndex(ifIndex);
			metadata.setDsFrequency(dsFrequency);
			metadata.setDsQam(qam);
			metadata.setMerchantCodes(merchants);
			
			list.add(metadata);
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