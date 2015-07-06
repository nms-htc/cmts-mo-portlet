package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.portlet.snmp.SnmpCableModemService;
import com.cmcti.cmts.portlet.telnet.AutomatedTelnetClient;
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

	// Addition information about cable modem
	private String cmIpAddress;
	private String numberCpe;
	private List<String[]> cpeInfo;

	// telnet
	private AutomatedTelnetClient telnet;

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

	@PreDestroy
	public void destroy() {
		disconnectTelnet();
	}

	public List<String> complateMac(String text) {
		List<String> result = new ArrayList<String>();
		try {
			List<CableModem> cms = CableModemLocalServiceUtil.findByMacAddress(text, FILTER_MAX_RESUTL);

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
				this.cableModem = snmpCableModemService.getCableModem(macAddress);

			// Disconnect and open new telnet connection
			disconnectTelnet();
			intTelnet();
			checkCmAndCpe();
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage("error-when-refresh-status-of-this-cm");
		}
	}

	private void intTelnet() {
		if (cableModem != null) {
			try {
				Cmts cmts = CmtsLocalServiceUtil.fetchCmts(cableModem.getCmtsId());
				String userPass = cmts.getDescription();
				String[] user_pass = userPass.split("/");
				telnet = new AutomatedTelnetClient(cmts.getHost().trim(), user_pass[0], user_pass[1]);
			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage("can-not-initilize-telnet-connection-to-the-cmts-server");
			}
		}
	}

	private void disconnectTelnet() {
		if (telnet != null) {
			try {
				telnet.disconnect();
				telnet = null;
			} catch (Exception e) {
				logger.warn("Error when disconect telnet client. Error: {0}", e.getMessage());
			}
		}
	}

	public void clear() {
		if (macAddress != null && !macAddress.trim().isEmpty()) {
			try {
				String mac = convertMacToTelnet(macAddress);
				telnet.sendCommand("clear cable modem " + mac + " reset");
				MessageUtil.addGlobalInfoMessage("clear-cm-success");
			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage("error-when-try-clear-this-model");
			}
		}
	}

	public void checkCmAndCpe() {
		if (macAddress != null && !macAddress.trim().isEmpty()) {
			try {
				String mac = convertMacToTelnet(macAddress);
				String commandRet = null;
				this.cpeInfo = new ArrayList<String[]>();

				// show cable modem {mac}
				commandRet = telnet.sendCommand("show cable modem " + mac);
				if (commandRet != null) {
					try (Scanner scanner = new Scanner(commandRet)) {
						int rowNum = 0;
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							rowNum++;

							if (rowNum >= 4) {
								String[] params = line.trim().split("\\s+");
								if (params.length == 9) {
									this.cmIpAddress = params[1];
									this.numberCpe = params[7];
								}
							}
						}
					}
				}
				logger.info(commandRet);
				
				// show cable modem {mac} cpe
				commandRet = telnet.sendCommand("show cable modem " + mac + " cpe");
				if (commandRet != null) {
					try (Scanner scanner = new Scanner(commandRet)) {
						int rowNum = 0;
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							rowNum++;

							if (rowNum >= 3 && ! line.trim().isEmpty()) {
								String[] params = line.trim().split("\\s+");
								if (params.length >= 2) {
									cpeInfo.add(params);
								}
							}
						}
					}
				}
				
				logger.info(commandRet);

			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage("error-when-check-cm-and-cpe-info");
			}
		}
	}

	private String convertMacToTelnet(String macAddress) {
		StringBuffer ret = new StringBuffer();
		String[] blocks = macAddress.split(":");

		for (int i = 0; i < blocks.length; i++) {
			ret.append(blocks[i]);
			if (i % 2 == 1 && i < blocks.length - 1) {
				ret.append(".");
			}
		}

		return ret.toString();
	}

	/* Getters & Setters */

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress
	 *            the macAddress to set
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
	 * @param cableModem
	 *            the cableModem to set
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
	 * @param snmpCableModemService
	 *            the snmpCableModemService to set
	 */
	public void setSnmpCableModemService(SnmpCableModemService snmpCableModemService) {
		this.snmpCableModemService = snmpCableModemService;
	}

	public String getCmIpAddress() {
		return cmIpAddress;
	}

	public void setCmIpAddress(String cmIpAddress) {
		this.cmIpAddress = cmIpAddress;
	}

	public String getNumberCpe() {
		return numberCpe;
	}

	public void setNumberCpe(String numberCpe) {
		this.numberCpe = numberCpe;
	}

	public List<String[]> getCpeInfo() {
		return cpeInfo;
	}

	public void setCpeInfo(List<String[]> cpeInfo) {
		this.cpeInfo = cpeInfo;
	}

}
