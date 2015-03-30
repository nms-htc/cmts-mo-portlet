package com.cmcti.cmts.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("upstreamConverter")
public class UpstreamChannelConverter extends AbstractConverter<UpstreamChannel> {

	@Override
	protected UpstreamChannel find(String value) throws SystemException, PortalException {
		String[] strs = value.split("-");
		UpstreamChannelPK pk = new UpstreamChannelPK();
		pk.setCmtsId(Long.parseLong(strs[0]));
		pk.setIfIndex(Integer.parseInt(strs[1]));
		return UpstreamChannelLocalServiceUtil.getUpstreamChannel(pk);
	}

	@Override
	protected Class<UpstreamChannel> getModelClass() {
		return UpstreamChannel.class;
	}

}
