package com.cmcti.cmts.portlet.snmp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.OID;

import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.util.CableModemConstants;
import com.cmcti.cmts.portlet.util.OidConstants;
import com.cmcti.cmts.portlet.util.SnmpUtils;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

@ManagedBean(name = "snmpUpstreamChannelService")
@ApplicationScoped
public class SnmpUpstreamChannelServiceImpl implements SnmpUpstreamChannelService, Serializable {

	private static final long serialVersionUID = -6541492211421270156L;
	private static final Logger logger = LoggerFactory.getLogger(SnmpUpstreamChannelServiceImpl.class);

	@Override
	public UpstreamChannel getUpstreamChannel(long cmtsId, int ifIndex) {
		
		UpstreamChannel upstream = null;
		Cmts cmts = null;
		
		if (cmtsId > 0 && ifIndex > 0) {
			// Load cmts
			try {
				cmts = CmtsLocalServiceUtil.fetchCmts(cmtsId);
			} catch (SystemException e) {
				logger.error(e);
			}
			
			if (cmts != null) {
			
				// Prepare OID
				OID[] oids = {
						new OID(OidConstants.Ifalias + "." + ifIndex),
						new OID(OidConstants.Ifdescr + "." + ifIndex),
						new OID(OidConstants.IfSigQSnr + "." + ifIndex), 
						new OID(OidConstants.IfSigQUnerroreds + "." + ifIndex),
						new OID(OidConstants.IfSigQCorrecteds + "." + ifIndex), 
						new OID(OidConstants.IfSigQUncorrectables + "." + ifIndex),
						new OID(OidConstants.UpChannelFrequency + "." + ifIndex),
						new OID(OidConstants.UpChannelWidth + "." + ifIndex), 
						new OID(OidConstants.UpChannelModulationProfile + "." + ifIndex),
						new OID(OidConstants.UpChannelCmActive + "." + ifIndex), 
						new OID(OidConstants.UpChannelCmRegistered + "." + ifIndex), 
						new OID(OidConstants.UpChannelCmTotal + "." + ifIndex)
				};
				
				try {
					ResponseEvent resEvent = SnmpUtils.get("udp:" + cmts.getHost() + "/161", cmts.getCommunity(), oids);
					upstream = UpstreamChannelLocalServiceUtil.createUpstreamChannel(new UpstreamChannelPK(ifIndex, cmtsId));
					upstream.setModifiedDate(new Date());
					upstream.setIfAlias(resEvent.getResponse().get(0).getVariable().toString());
					upstream.setIfDesc(resEvent.getResponse().get(1).getVariable().toString());
					upstream.setIfSigQSNR(GetterUtil.getDouble(resEvent.getResponse().get(2).getVariable().toLong()));
					upstream.setIfSigQUnerroreds(resEvent.getResponse().get(3).getVariable().toLong());
					upstream.setIfSigQCorrecteds(resEvent.getResponse().get(4).getVariable().toLong());
					upstream.setIfSigQUncorrectables(resEvent.getResponse().get(5).getVariable().toLong());
					upstream.setUpChannelFrequency(resEvent.getResponse().get(6).getVariable().toLong());
					upstream.setUpChannelWidth(resEvent.getResponse().get(7).getVariable().toLong());
					upstream.setUpChannelModProfile(resEvent.getResponse().get(8).getVariable().toInt());
					upstream.setUpChannelCmActive(resEvent.getResponse().get(9).getVariable().toInt());
					upstream.setUpChannelCmRegistered(resEvent.getResponse().get(10).getVariable().toInt());
					upstream.setUpChannelCmTotal(resEvent.getResponse().get(11).getVariable().toInt());
	
					@SuppressWarnings("rawtypes")
					List avgRow = CableModemLocalServiceUtil.getAvgValueForUpstream(cmtsId, ifIndex, CableModemConstants.STATUS_REGISTRATION_COMPLETE);
					Object[] avgValues = (Object[]) avgRow.get(0);
					
					upstream.setAvgOnlineCmMicRef(GetterUtil.getDouble(avgValues[0]));
					upstream.setAvgOnlineCmRxPower(GetterUtil.getDouble(avgValues[1]));
					upstream.setAvgOnlineCmTxPower(GetterUtil.getDouble(avgValues[2]));
					upstream.setAvgOnlineCmUsPower(GetterUtil.getDouble(avgValues[3]));
					upstream.setAvgOnlineCmDsPower(GetterUtil.getDouble(avgValues[4]));
					upstream.setAvgOnlineCmDsSNR(GetterUtil.getDouble(avgValues[5]));
					
					// Calculate FEC

					double total = upstream.getIfSigQCorrecteds() + upstream.getIfSigQUncorrectables() + upstream.getIfSigQUnerroreds();

					double fecCorrected = (upstream.getIfSigQCorrecteds() / total) * 100;
					double fecUncorrectable = (upstream.getIfSigQUncorrectables() / total) * 100;

					if (upstream.getIfSigQCorrecteds() == 0)
						fecCorrected = 0;
					if (upstream.getIfSigQUncorrectables() == 0)
						fecUncorrectable = 0;

					// validate doubles
					if (Double.isNaN(fecCorrected) || Double.isInfinite(fecCorrected))
						fecCorrected = 0;
					if (Double.isNaN(fecUncorrectable) || Double.isInfinite(fecUncorrectable))
						fecUncorrectable = 0;

					upstream.setFecCorrected(fecCorrected);
					upstream.setFecUncorrectable(fecUncorrectable);
					
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
		
		return upstream;
	}
	
}
