package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

@ManagedBean(name = "ucRowStyleAlarmGenerator")
@ViewScoped
public class UcRowStyleAlarmGenerator implements RowStypeAlarmGenerator, Serializable {

	private static final long serialVersionUID = -4481220679566199852L;

	public static final String ifSigQSNR = "ifSigQSNR";
	public static final String fecCorrected = "fecCorrected";
	public static final String fecUncorrectable = "fecUncorrectable";
	public static final String avgOnlineCmDsSNR = "avgOnlineCmDsSNR";

	// perferences
	private String alarmColorLv1;
	private String alarmColorLv2;
	private String alarmColorLv3;

	/* Level 1 */

	private double minFecCorrectedLv1;
	private double maxFecCorrectedLv1;

	private double minFecUncorrectableLv1;
	private double maxFecUncorrectableLv1;

	private double minIfSigQSNRLv1;
	private double maxIfSigQSNRLv1;

	private double minAvgOnlineCmDnSNRLv1;
	private double maxAvgOnlineCmDnSNRLv1;

	/* Level 2 */

	private double minFecCorrectedLv2;
	private double maxFecCorrectedLv2;

	private double minFecUncorrectableLv2;
	private double maxFecUncorrectableLv2;

	private double minIfSigQSNRLv2;
	private double maxIfSigQSNRLv2;

	private double minAvgOnlineCmDnSNRLv2;
	private double maxAvgOnlineCmDnSNRLv2;

	/* Level 3 */

	private double minFecCorrectedLv3;
	private double maxFecCorrectedLv3;

	private double minFecUncorrectableLv3;
	private double maxFecUncorrectableLv3;

	private double minIfSigQSNRLv3;
	private double maxIfSigQSNRLv3;

	private double minAvgOnlineCmDnSNRLv3;
	private double maxAvgOnlineCmDnSNRLv3;

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
		PortletPreferences portletPreferences = portletRequest.getPreferences();

		alarmColorLv1 = portletPreferences.getValue("alarmColorLv1", "#ff9900");
		alarmColorLv2 = portletPreferences.getValue("alarmColorLv2", "#ff00ff");
		alarmColorLv3 = portletPreferences.getValue("alarmColorLv3", "#ff0000");

		minFecCorrectedLv1 = parseDouble(portletPreferences.getValue("minFecCorrectedLv1", "0"));
		maxFecCorrectedLv1 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv1", "5"));
		minFecUncorrectableLv1 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv1", "0"));
		maxFecUncorrectableLv1 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv1", "2"));
		minIfSigQSNRLv1 = parseDouble(portletPreferences.getValue("minIfSigQSNRLv1", "20")) * 10;
		maxIfSigQSNRLv1 = parseDouble(portletPreferences.getValue("maxIfSigQSNRLv1", "24")) * 10;
		minAvgOnlineCmDnSNRLv1 = parseDouble(portletPreferences.getValue("minAvgOnlineCmDnSNRLv1", "30")) * 10;
		maxAvgOnlineCmDnSNRLv1 = parseDouble(portletPreferences.getValue("maxAvgOnlineCmDnSNRLv1", "33")) * 10;

		minFecCorrectedLv2 = parseDouble(portletPreferences.getValue("minFecCorrectedLv2", "5"));
		maxFecCorrectedLv2 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv2", "10"));
		minFecUncorrectableLv2 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv2", "2"));
		maxFecUncorrectableLv2 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv2", "5"));
		minIfSigQSNRLv2 = parseDouble(portletPreferences.getValue("minIfSigQSNRLv2", "16")) * 10;
		maxIfSigQSNRLv2 = parseDouble(portletPreferences.getValue("maxIfSigQSNRLv2", "20")) * 10;
		minAvgOnlineCmDnSNRLv2 = parseDouble(portletPreferences.getValue("minAvgOnlineCmDnSNRLv2", "28")) * 10;
		maxAvgOnlineCmDnSNRLv2 = parseDouble(portletPreferences.getValue("maxAvgOnlineCmDnSNRLv2", "30")) * 10;

		minFecCorrectedLv3 = parseDouble(portletPreferences.getValue("minFecCorrectedLv3", "10"));
		maxFecCorrectedLv3 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv3", "100"));
		minFecUncorrectableLv3 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv3", "5"));
		maxFecUncorrectableLv3 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv3", "100"));
		minIfSigQSNRLv3 = parseDouble(portletPreferences.getValue("minIfSigQSNRLv3", "10")) * 10;
		maxIfSigQSNRLv3 = parseDouble(portletPreferences.getValue("maxIfSigQSNRLv3", "16")) * 10;
		minAvgOnlineCmDnSNRLv3 = parseDouble(portletPreferences.getValue("minAvgOnlineCmDnSNRLv3", "22")) * 10;
		maxAvgOnlineCmDnSNRLv3 = parseDouble(portletPreferences.getValue("maxAvgOnlineCmDnSNRLv3", "28")) * 10;

	}

	@Override
	public String getRowDataCss(Object value, String dataType) {
		String cssStyle = "";
		if (value == null) return null;

		switch (dataType) {

		case ifSigQSNR: {
			double checkValue = (double) value;

			if (checkValue >= minIfSigQSNRLv1 && checkValue <= maxIfSigQSNRLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minIfSigQSNRLv2 && checkValue <= maxIfSigQSNRLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minIfSigQSNRLv3 && checkValue <= maxIfSigQSNRLv3) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv3 + ";";
			}
			break;
		}

		case fecCorrected: {
			double checkValue = (double) value;

			if (checkValue > minFecCorrectedLv1 && checkValue <= maxFecCorrectedLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minFecCorrectedLv2 && checkValue <= maxFecCorrectedLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minFecCorrectedLv3) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv3 + ";";
			}
			break;
		}

		case fecUncorrectable: {
			double checkValue = (double) value;

			if (checkValue > minFecUncorrectableLv1 && checkValue <= maxFecUncorrectableLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minFecUncorrectableLv2 && checkValue <= maxFecUncorrectableLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minFecUncorrectableLv3) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv3 + ";";
			}
			break;
		}

		case avgOnlineCmDsSNR: {
			double checkValue = (double) value;

			if (checkValue >= minAvgOnlineCmDnSNRLv1 && checkValue <= maxAvgOnlineCmDnSNRLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minAvgOnlineCmDnSNRLv2 && checkValue <= maxAvgOnlineCmDnSNRLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minAvgOnlineCmDnSNRLv3 && checkValue <= maxAvgOnlineCmDnSNRLv3) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv3 + ";";
			}

			break;
		}
		}

		return cssStyle;
	}

	private double parseDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return 0L;
		}
	}

	/* Getters and Setters */

	public double getMinFecCorrectedLv1() {
		return minFecCorrectedLv1;
	}

	public void setMinFecCorrectedLv1(double minFecCorrectedLv1) {
		this.minFecCorrectedLv1 = minFecCorrectedLv1;
	}

	public double getMaxFecCorrectedLv1() {
		return maxFecCorrectedLv1;
	}

	public void setMaxFecCorrectedLv1(double maxFecCorrectedLv1) {
		this.maxFecCorrectedLv1 = maxFecCorrectedLv1;
	}

	public double getMinFecUncorrectableLv1() {
		return minFecUncorrectableLv1;
	}

	public void setMinFecUncorrectableLv1(double minFecUncorrectableLv1) {
		this.minFecUncorrectableLv1 = minFecUncorrectableLv1;
	}

	public double getMaxFecUncorrectableLv1() {
		return maxFecUncorrectableLv1;
	}

	public void setMaxFecUncorrectableLv1(double maxFecUncorrectableLv1) {
		this.maxFecUncorrectableLv1 = maxFecUncorrectableLv1;
	}

	public double getMinIfSigQSNRLv1() {
		return minIfSigQSNRLv1;
	}

	public void setMinIfSigQSNRLv1(double minIfSigQSNRLv1) {
		this.minIfSigQSNRLv1 = minIfSigQSNRLv1;
	}

	public double getMaxIfSigQSNRLv1() {
		return maxIfSigQSNRLv1;
	}

	public void setMaxIfSigQSNRLv1(double maxIfSigQSNRLv1) {
		this.maxIfSigQSNRLv1 = maxIfSigQSNRLv1;
	}

	public double getMinAvgOnlineCmDnSNRLv1() {
		return minAvgOnlineCmDnSNRLv1;
	}

	public void setMinAvgOnlineCmDnSNRLv1(double minAvgOnlineCmDnSNRLv1) {
		this.minAvgOnlineCmDnSNRLv1 = minAvgOnlineCmDnSNRLv1;
	}

	public double getMaxAvgOnlineCmDnSNRLv1() {
		return maxAvgOnlineCmDnSNRLv1;
	}

	public void setMaxAvgOnlineCmDnSNRLv1(double maxAvgOnlineCmDnSNRLv1) {
		this.maxAvgOnlineCmDnSNRLv1 = maxAvgOnlineCmDnSNRLv1;
	}

	public double getMinFecCorrectedLv2() {
		return minFecCorrectedLv2;
	}

	public void setMinFecCorrectedLv2(double minFecCorrectedLv2) {
		this.minFecCorrectedLv2 = minFecCorrectedLv2;
	}

	public double getMaxFecCorrectedLv2() {
		return maxFecCorrectedLv2;
	}

	public void setMaxFecCorrectedLv2(double maxFecCorrectedLv2) {
		this.maxFecCorrectedLv2 = maxFecCorrectedLv2;
	}

	public double getMinFecUncorrectableLv2() {
		return minFecUncorrectableLv2;
	}

	public void setMinFecUncorrectableLv2(double minFecUncorrectableLv2) {
		this.minFecUncorrectableLv2 = minFecUncorrectableLv2;
	}

	public double getMaxFecUncorrectableLv2() {
		return maxFecUncorrectableLv2;
	}

	public void setMaxFecUncorrectableLv2(double maxFecUncorrectableLv2) {
		this.maxFecUncorrectableLv2 = maxFecUncorrectableLv2;
	}

	public double getMinIfSigQSNRLv2() {
		return minIfSigQSNRLv2;
	}

	public void setMinIfSigQSNRLv2(double minIfSigQSNRLv2) {
		this.minIfSigQSNRLv2 = minIfSigQSNRLv2;
	}

	public double getMaxIfSigQSNRLv2() {
		return maxIfSigQSNRLv2;
	}

	public void setMaxIfSigQSNRLv2(double maxIfSigQSNRLv2) {
		this.maxIfSigQSNRLv2 = maxIfSigQSNRLv2;
	}

	public double getMinAvgOnlineCmDnSNRLv2() {
		return minAvgOnlineCmDnSNRLv2;
	}

	public void setMinAvgOnlineCmDnSNRLv2(double minAvgOnlineCmDnSNRLv2) {
		this.minAvgOnlineCmDnSNRLv2 = minAvgOnlineCmDnSNRLv2;
	}

	public double getMaxAvgOnlineCmDnSNRLv2() {
		return maxAvgOnlineCmDnSNRLv2;
	}

	public void setMaxAvgOnlineCmDnSNRLv2(double maxAvgOnlineCmDnSNRLv2) {
		this.maxAvgOnlineCmDnSNRLv2 = maxAvgOnlineCmDnSNRLv2;
	}

	public double getMinFecCorrectedLv3() {
		return minFecCorrectedLv3;
	}

	public void setMinFecCorrectedLv3(double minFecCorrectedLv3) {
		this.minFecCorrectedLv3 = minFecCorrectedLv3;
	}

	public double getMaxFecCorrectedLv3() {
		return maxFecCorrectedLv3;
	}

	public void setMaxFecCorrectedLv3(double maxFecCorrectedLv3) {
		this.maxFecCorrectedLv3 = maxFecCorrectedLv3;
	}

	public double getMinFecUncorrectableLv3() {
		return minFecUncorrectableLv3;
	}

	public void setMinFecUncorrectableLv3(double minFecUncorrectableLv3) {
		this.minFecUncorrectableLv3 = minFecUncorrectableLv3;
	}

	public double getMaxFecUncorrectableLv3() {
		return maxFecUncorrectableLv3;
	}

	public void setMaxFecUncorrectableLv3(double maxFecUncorrectableLv3) {
		this.maxFecUncorrectableLv3 = maxFecUncorrectableLv3;
	}

	public double getMinIfSigQSNRLv3() {
		return minIfSigQSNRLv3;
	}

	public void setMinIfSigQSNRLv3(double minIfSigQSNRLv3) {
		this.minIfSigQSNRLv3 = minIfSigQSNRLv3;
	}

	public double getMaxIfSigQSNRLv3() {
		return maxIfSigQSNRLv3;
	}

	public void setMaxIfSigQSNRLv3(double maxIfSigQSNRLv3) {
		this.maxIfSigQSNRLv3 = maxIfSigQSNRLv3;
	}

	public double getMinAvgOnlineCmDnSNRLv3() {
		return minAvgOnlineCmDnSNRLv3;
	}

	public void setMinAvgOnlineCmDnSNRLv3(double minAvgOnlineCmDnSNRLv3) {
		this.minAvgOnlineCmDnSNRLv3 = minAvgOnlineCmDnSNRLv3;
	}

	public double getMaxAvgOnlineCmDnSNRLv3() {
		return maxAvgOnlineCmDnSNRLv3;
	}

	public void setMaxAvgOnlineCmDnSNRLv3(double maxAvgOnlineCmDnSNRLv3) {
		this.maxAvgOnlineCmDnSNRLv3 = maxAvgOnlineCmDnSNRLv3;
	}

}
