package com.cmcti.cmts.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("cmtsConverter")
public class CmtsConverter extends AbstractConverter<Cmts> {

	@Override
	protected Cmts find(String value) throws SystemException, PortalException {
		return CmtsLocalServiceUtil.getCmts(Long.parseLong(value));
	}

	@Override
	protected Class<Cmts> getModelClass() {
		return Cmts.class;
	}
	
}
