package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.cmcti.cmts.domain.service.OptionLocalServiceUtil;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

/**
 * @author richard
 *
 */	
@ManagedBean(name = "cmtsSettingBean")
@ApplicationScoped
public class CmtsSettingBean implements Serializable {

	private static final long serialVersionUID = -57486711776686186L;
	private static final Logger logger = LoggerFactory.getLogger(CmtsSettingBean.class);
	
	public static final String alarmColorLv1 = "alarmColorLv1";
	public static final String alarmColorLv3 = "alarmColorLv2";
	public static final String alarmColorLv2 = "alarmColorLv3";
	
	/**************************************************************
	 * Cable Modem Params
	 * ************************************************************/
	
	public static final String cm_minDsSNRLv1 = "cm.minDsSNRLv1";
	public static final String cm_minDsSNRLv2 = "cm.minDsSNRLv2";
	public static final String cm_minDsSNRLv3 = "cm.minDsSNRLv3";
	public static final String cm_maxDsSNRLv1 = "cm.maxDsSNRLv1";
	public static final String cm_maxDsSNRLv2 = "cm.maxDsSNRLv2";
	public static final String cm_maxDsSNRLv3 = "cm.maxDsSNRLv3";
	
	public static final String cm_minUsSNRLv1 = "cm.minUsSNRLv1";
	public static final String cm_minUsSNRLv2 = "cm.minUsSNRLv2";
	public static final String cm_minUsSNRLv3 = "cm.minUsSNRLv3";
	public static final String cm_maxUsSNRLv1 = "cm.maxUsSNRLv1";
	public static final String cm_maxUsSNRLv2 = "cm.maxUsSNRLv2";
	public static final String cm_maxUsSNRLv3 = "cm.maxUsSNRLv3";
	
	public static final String cm_minFecUncorrectableLv1 = "cm.minFecUncorrectableLv1";
	public static final String cm_minFecUncorrectableLv2 = "cm.minFecUncorrectableLv2";
	public static final String cm_minFecUncorrectableLv3 = "cm.minFecUncorrectableLv3";
	public static final String cm_maxFecUncorrectableLv1 = "cm.maxFecUncorrectableLv1";
	public static final String cm_maxFecUncorrectableLv2 = "cm.maxFecUncorrectableLv2";
	public static final String cm_maxFecUncorrectableLv3 = "cm.maxFecUncorrectableLv3";
	
	public static final String cm_minFecCorrectedLv1 = "cm.minFecCorrectedLv1";
	public static final String cm_minFecCorrectedLv2 = "cm.minFecCorrectedLv2";
	public static final String cm_minFecCorrectedLv3 = "cm.minFecCorrectedLv3";
	public static final String cm_maxFecCorrectedLv1 = "cm.maxFecCorrectedLv1";
	public static final String cm_maxFecCorrectedLv2 = "cm.maxFecCorrectedLv2";
	public static final String cm_maxFecCorrectedLv3 = "cm.maxFecCorrectedLv3";
	
	public static final String cm_minTxPowerLv1 = "cm.minTxPowerLv1";
	public static final String cm_minTxPowerLv2 = "cm.minTxPowerLv2";
	public static final String cm_minTxPowerLv3 = "cm.minTxPowerLv3";
	public static final String cm_maxTxPowerLv1 = "cm.maxTxPowerLv1";
	public static final String cm_maxTxPowerLv2 = "cm.maxTxPowerLv2";
	public static final String cm_maxTxPowerLv3 = "cm.maxTxPowerLv3";
	
	
	/**************************************************************
	 * Upstream Channel Params
	 * ************************************************************/
	
	public static final String uc_minIfSigQSNRLv1 = "uc.minIfSigQSNRLv1";
	public static final String uc_minIfSigQSNRLv2 = "uc.minIfSigQSNRLv2";
	public static final String uc_minIfSigQSNRLv3 = "uc.minIfSigQSNRLv3";
	public static final String uc_maxIfSigQSNRLv1 = "uc.maxIfSigQSNRLv1";
	public static final String uc_maxIfSigQSNRLv2 = "uc.maxIfSigQSNRLv2";
	public static final String uc_maxIfSigQSNRLv3 = "uc.maxIfSigQSNRLv3";
	
	public static final String uc_minFecCorrectedLv1 = "uc.minFecCorrectedLv1";
	public static final String uc_minFecCorrectedLv2 = "uc.minFecCorrectedLv2";
	public static final String uc_minFecCorrectedLv3 = "uc.minFecCorrectedLv3";
	public static final String uc_maxFecCorrectedLv1 = "uc.maxFecCorrectedLv1";
	public static final String uc_maxFecCorrectedLv2 = "uc.maxFecCorrectedLv2";
	public static final String uc_maxFecCorrectedLv3 = "uc.maxFecCorrectedLv3";
	
	public static final String uc_minFecUncorrectableLv1 = "uc.minFecUncorrectableLv1";
	public static final String uc_minFecUncorrectableLv2 = "uc.minFecUncorrectableLv2";
	public static final String uc_minFecUncorrectableLv3 = "uc.minFecUncorrectableLv3";
	public static final String uc_maxFecUncorrectableLv1 = "uc.maxFecUncorrectableLv1";
	public static final String uc_maxFecUncorrectableLv2 = "uc.maxFecUncorrectableLv2";
	public static final String uc_maxFecUncorrectableLv3 = "uc.maxFecUncorrectableLv3";
	
	public static final String uc_minAvgOnlineCmDnSNRLv1 = "uc.minAvgOnlineCmDnSNRLv1";
	public static final String uc_minAvgOnlineCmDnSNRLv2 = "uc.minAvgOnlineCmDnSNRLv2";
	public static final String uc_minAvgOnlineCmDnSNRLv3 = "uc.minAvgOnlineCmDnSNRLv3";
	public static final String uc_maxAvgOnlineCmDnSNRLv1 = "uc.maxAvgOnlineCmDnSNRLv1";
	public static final String uc_maxAvgOnlineCmDnSNRLv2 = "uc.maxAvgOnlineCmDnSNRLv2";
	public static final String uc_maxAvgOnlineCmDnSNRLv3 = "uc.maxAvgOnlineCmDnSNRLv3";
	
	public static final String uc_minAvgOnlineCmTxPowerLv1 = "uc.minAvgOnlineCmTxPowerLv1";
	public static final String uc_minAvgOnlineCmTxPowerLv2 = "uc.minAvgOnlineCmTxPowerLv2";
	public static final String uc_minAvgOnlineCmTxPowerLv3 = "uc.minAvgOnlineCmTxPowerLv3";
	public static final String uc_maxAvgOnlineCmTxPowerLv1 = "uc.maxAvgOnlineCmTxPowerLv1";
	public static final String uc_maxAvgOnlineCmTxPowerLv2 = "uc.maxAvgOnlineCmTxPowerLv2";
	public static final String uc_maxAvgOnlineCmTxPowerLv3 = "uc.maxAvgOnlineCmTxPowerLv3";
	
	
	/*********************************************************************************
	 * Current config 
	 *********************************************************************************/
	protected Map<String, String> currentConfigs = new HashMap<String, String>();
	
	
	public void save() {
		try {
			OptionLocalServiceUtil.updateAlarmConfigs(currentConfigs, JsfUtil.getServiceContext());
			
			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);;
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
	}
	
	public String getConfig(String name) {
		Map<String, String> map = getCurrentConfigs();
		
		if (map != null && map.size() > 0) {
			return map.get(name);
		}
				
		return null;
	}
	
	
	/*********************************************************************************
	 * ************************* GETTERS & SETTERS ***********************************
	 *********************************************************************************/

	public Map<String, String> getCurrentConfigs() {
		
		if (currentConfigs == null || currentConfigs.isEmpty()) {
			try {
				currentConfigs = OptionLocalServiceUtil.fetchAlarmsConfig();
			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage(e);
			}
		}
		
		return currentConfigs;
	}


	public void setCurrentConfigs(Map<String, String> currentConfigs) {
		this.currentConfigs = currentConfigs;
	}

}
