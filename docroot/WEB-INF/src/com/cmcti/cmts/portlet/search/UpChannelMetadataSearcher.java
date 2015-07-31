package com.cmcti.cmts.portlet.search;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class UpChannelMetadataSearcher implements Searcher {
	
	protected Long cmtsId;
	protected Integer ifIndex;
	
	public SelectItem[] getUpstreamChannelItems() throws SystemException {
		SelectItem[] items = null;
		if (cmtsId != null && cmtsId != 0) {
			List<UpstreamChannel> ups = UpstreamChannelLocalServiceUtil.fetchByCmtsId(cmtsId);
			items = new SelectItem[ups.size()];
			for (int i = 0; i < ups.size(); i++) {
				items[i] = new SelectItem(ups.get(i).getIfIndex(), ups.get(i).getIfDesc() + "-" + ups.get(i).getIfAlias());
			}
		}
		return items;
	}
	

	@Override
	public DynamicQuery getSearchQuery() {
		DynamicQuery query = UpChannelMetadataLocalServiceUtil.dynamicQuery();

		if (cmtsId != null && cmtsId != 0) {
			query.add(PropertyFactoryUtil.forName("cmtsId").eq(cmtsId));
		}
		
		if (ifIndex != null && ifIndex != 0) {
			query.add(RestrictionsFactoryUtil.eq("ifIndex", ifIndex));
		}
		
		return query;
	}

	public Long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(Long cmtsId) {
		this.cmtsId = cmtsId;
	}

	public Integer getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(Integer ifIndex) {
		this.ifIndex = ifIndex;
	}
	
}
