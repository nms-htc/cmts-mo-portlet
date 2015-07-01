package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.snmp.SnmpUpstreamChannelService;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

@ManagedBean
@ViewScoped
public class UpstreamChannelDetailBean implements Serializable {

	private static final long serialVersionUID = 3688701264010448581L;
	private static final Logger logger = LoggerFactory.getLogger(UpstreamChannelDetailBean.class);
	private static final String CMTSID_PARAM = "cmtsId";
	private static final String IFINDEX_PARAM = "ifIndex";
	
	private UpstreamChannel upstream;
	
	private long cmtsId;
	private int ifIndex;
	private SelectItem[] upstreamSelectItems;
	
	@ManagedProperty("#{snmpUpstreamChannelService}")
	private SnmpUpstreamChannelService snmpUpstreamChannelService;
	
	@PostConstruct
	public void init() {
		// check cmtsId and ifIndex from request
		cmtsId = GetterUtil.getLong(JsfUtil.getRequestParameter(CMTSID_PARAM), 0);
		ifIndex = GetterUtil.getInteger(JsfUtil.getRequestParameter(IFINDEX_PARAM), 0);
		
		// Immediatly refresh all upstream signals!
		if (cmtsId > 0 && ifIndex > 0) {
			refresh();
		}
		
		// Load all upstream available on the cmts
		if (cmtsId > 0) {
			upstreamSelectItems = getUpstreamSelectItems(cmtsId);
		}
	}
	
	public void onChangeCmts(ValueChangeEvent event) {
		long newCmtsId = GetterUtil.getLong(event.getNewValue(), 0);
		if (newCmtsId > 0) {
			upstreamSelectItems = getUpstreamSelectItems(newCmtsId);
		}
	}
	
	public void onChangeUpstream(ValueChangeEvent event) {
		int newIfIndex = GetterUtil.getInteger(event.getNewValue(), 0);
		if (newIfIndex > 0 && this.cmtsId > 0) {
			UpstreamChannelPK pk = new UpstreamChannelPK(newIfIndex, this.cmtsId);
			try {
				upstream = UpstreamChannelLocalServiceUtil.fetchUpstreamChannel(pk);
				System.out.println(upstream);
			} catch (SystemException e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage(e);
			}
			
		}
	}
	
	public void refresh() {
		try {
			upstream = snmpUpstreamChannelService.getUpstreamChannel(this.cmtsId, this.ifIndex);
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
	}
	
	private SelectItem[] getUpstreamSelectItems(long cmtsId) {
		List<UpstreamChannel> upstreams = null;
		SelectItem[] items = null;
		try {
			upstreams = UpstreamChannelLocalServiceUtil.fetchByCmtsId(cmtsId);
		} catch (SystemException e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
		
		if (upstreams != null) {
			items = new SelectItem[upstreams.size()];
			for (int i = 0; i < upstreams.size(); i++) {
				UpstreamChannel up = upstreams.get(i);
				items[i] = new SelectItem(up.getIfIndex(), up.getIfAlias());
			}
		}
		return items;
	}

	/* Getters and Setters */
	
	public UpstreamChannel getUpstream() {
		return upstream;
	}


	public void setUpstream(UpstreamChannel upstream) {
		this.upstream = upstream;
	}


	public long getCmtsId() {
		return cmtsId;
	}


	public void setCmtsId(long cmtsId) {
		this.cmtsId = cmtsId;
	}


	public int getIfIndex() {
		return ifIndex;
	}


	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}


	public SelectItem[] getUpstreamSelectItems() {
		return upstreamSelectItems;
	}


	public void setUpstreamSelectItems(SelectItem[] upstreamSelectItems) {
		this.upstreamSelectItems = upstreamSelectItems;
	}

	public SnmpUpstreamChannelService getSnmpUpstreamChannelService() {
		return snmpUpstreamChannelService;
	}

	public void setSnmpUpstreamChannelService(SnmpUpstreamChannelService snmpUpstreamChannelService) {
		this.snmpUpstreamChannelService = snmpUpstreamChannelService;
	}
	
}
