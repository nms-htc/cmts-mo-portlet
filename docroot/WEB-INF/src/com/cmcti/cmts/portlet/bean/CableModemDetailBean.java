package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.portlet.snmp.SnmpCableModemService;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CableModemDetailBean implements Serializable {

	private static final long serialVersionUID = -6420919102811045860L;
	private static final Logger logger = LoggerFactory.getLogger(CableModemDetailBean.class);
	private static final String MAC_ADDRESS_PARAM = "macAddress";
	private static final int FILTER_MAX_RESUTL = 10;

	private String macAddress;
	private CableModem cableModem;

	@ManagedProperty("#{snmpCableModemService}")
	private SnmpCableModemService snmpCableModemService;
	
	@PostConstruct
	public void init() {
		macAddress = JsfUtil.getRequestParameter(MAC_ADDRESS_PARAM);
		
		if (macAddress != null && !macAddress.trim().isEmpty()) {
			try {
				cableModem = CableModemLocalServiceUtil.fetchCableModem(macAddress);
			} catch (SystemException e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage(e);
			}
			
			refresh();			
		}
	}

	public List<String> complateMac(String text) {
		List<String> result = new ArrayList<String>();
		try {
			List<CableModem> cms = CableModemLocalServiceUtil.findByMacAddress(macAddress, FILTER_MAX_RESUTL); 
			
			for (CableModem cm : cms) {
				result.add(cm.getMacAddress());
			}
			
		} catch (SystemException e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
		return result;
	}

	public void refresh() {
		try {
			if (macAddress != null && !macAddress.trim().isEmpty())
				this.cableModem = snmpCableModemService.getCableModem(macAddress.trim());
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
	}

	public void clear() {
		// TODO: do this throws telnet
		if (macAddress != null && !macAddress.trim().isEmpty()) {

		}
	}

	public void checkIpCmAndCpe() {
		// TODO: do this throws telnet
		if (macAddress != null && !macAddress.trim().isEmpty()) {

		}
	}
	
	/* Getters & Setters */

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * @return the cableModem
	 */
	public CableModem getCableModem() {
		return cableModem;
	}

	/**
	 * @param cableModem the cableModem to set
	 */
	public void setCableModem(CableModem cableModem) {
		this.cableModem = cableModem;
	}

	/**
	 * @return the snmpCableModemService
	 */
	public SnmpCableModemService getSnmpCableModemService() {
		return snmpCableModemService;
	}

	/**
	 * @param snmpCableModemService the snmpCableModemService to set
	 */
	public void setSnmpCableModemService(SnmpCableModemService snmpCableModemService) {
		this.snmpCableModemService = snmpCableModemService;
	}
	
}
