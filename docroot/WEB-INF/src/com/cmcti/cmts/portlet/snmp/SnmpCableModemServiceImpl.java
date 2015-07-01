package com.cmcti.cmts.portlet.snmp;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.OID;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.portlet.util.OidConstants;
import com.cmcti.cmts.portlet.util.SnmpUtils;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "snmpCableModemService")
@ApplicationScoped
public class SnmpCableModemServiceImpl implements SnmpCableModemService, Serializable {

	private static final long serialVersionUID = -6049895692552012011L;
	private static final Logger logger = LoggerFactory.getLogger(SnmpCableModemServiceImpl.class);

	@Override
	public CableModem getCableModem(String macAddress) {
		
		CableModem cableModem = null;
		
		// Load CM from database
		try {
			cableModem = CableModemLocalServiceUtil.fetchCableModem(macAddress);
		} catch (SystemException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
		
		if (cableModem != null) {
			int cmIndex = cableModem.getCmIndex();
			long cmtsId = cableModem.getCmtsId();
			String cmSubIndex = cableModem.getCmSubIndex();
			Date modifiedDate = new Date();
			
			// Prepare OIDs
			OID[] oids = { 
				new OID(OidConstants.CmMacAddress + "." + cmIndex), 
				new OID(OidConstants.CmDcIfIndex + "." + cmIndex),
				new OID(OidConstants.CmUcIfIndex + "." + cmIndex), 
				new OID(OidConstants.CmUsSnr + "." + cmIndex), 
				new OID(OidConstants.CmUnerroreds + "." + cmIndex),
				new OID(OidConstants.CmCorrecteds + "." + cmIndex), 
				new OID(OidConstants.CmUncorrectables + "." + cmIndex), 
				new OID(OidConstants.CmIpAddress + "." + cmIndex),
				new OID(OidConstants.CmStatus + "." + cmIndex), 
				new OID(OidConstants.CmRxPower + "." + cmIndex),
				new OID(OidConstants.CmDsPower + "." + cmSubIndex),
				new OID(OidConstants.CmUsPower + "." + cmSubIndex),
				new OID(OidConstants.CmDsSnr + "." + cmSubIndex),
				new OID(OidConstants.CmMicroreflections + "." + cmSubIndex) 
			};
			
			// Fetch data from CMTS
			try {
				Cmts cmts = CmtsLocalServiceUtil.getCmts(cmtsId);
				ResponseEvent resEvent = SnmpUtils.get("udp:" + cmts.getHost() + "/161", cmts.getCommunity(), oids);
				cableModem.setModifiedDate(modifiedDate);
				cableModem.setMacAddress(resEvent.getResponse().get(0).getVariable().toString());
				cableModem.setDcIfIndex(resEvent.getResponse().get(1).getVariable().toInt());
				cableModem.setUcIfIndex(resEvent.getResponse().get(2).getVariable().toInt());
				cableModem.setUsSNR(resEvent.getResponse().get(3).getVariable().toInt());
				cableModem.setUnerroreds(resEvent.getResponse().get(4).getVariable().toInt());
				cableModem.setCorrecteds(resEvent.getResponse().get(5).getVariable().toInt());
				cableModem.setUncorrectables(resEvent.getResponse().get(6).getVariable().toInt());
				//cableModem.setIpAddress(resEvent.getResponse().get(7).getVariable().toString()); // ignore ip address
				cableModem.setStatus(resEvent.getResponse().get(8).getVariable().toInt());
				cableModem.setRxPower(resEvent.getResponse().get(9).getVariable().toInt());
				cableModem.setDsPower(resEvent.getResponse().get(10).getVariable().toInt());
				cableModem.setUsPower(resEvent.getResponse().get(11).getVariable().toInt());
				cableModem.setDsSNR(resEvent.getResponse().get(12).getVariable().toInt());
				cableModem.setMicroRef(resEvent.getResponse().get(13).getVariable().toLong());
				
				// Caculate FECs
				double total = cableModem.getCorrecteds() + cableModem.getUncorrectables() + cableModem.getUnerroreds();
				double fecCorrected = (cableModem.getCorrecteds() / total) * 100;
				double fecUncorrectable = (cableModem.getUncorrectables() / total) * 100;

				// validate double
				if (Double.isNaN(fecCorrected) || Double.isInfinite(fecCorrected))
					fecCorrected = 0;
				if (Double.isNaN(fecUncorrectable) || Double.isInfinite(fecUncorrectable))
					fecUncorrectable = 0;

				cableModem.setFecCorrected(fecCorrected);
				cableModem.setFecUncorrectable(fecUncorrectable);
				
			} catch (Exception e) {
				logger.error(e);
				throw new RuntimeException(e);
			}
		}
		
		return cableModem;
	}

}
