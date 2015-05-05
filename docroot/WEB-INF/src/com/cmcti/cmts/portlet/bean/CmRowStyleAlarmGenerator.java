package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

@ManagedBean(name = "cmRowStyleAlarmGenerator")
@ViewScoped
public class CmRowStyleAlarmGenerator implements RowStypeAlarmGenerator, Serializable {

	private static final long serialVersionUID = -6016465643390100066L;
	//private static final Logger logger = LoggerFactory.getLogger(CmRowStyleAlarmGenerator.class);

	public static final String dsSNR = "dsSNR";
	public static final String usSNR = "usSNR";
	public static final String fecUncorrectable = "fecUncorrectable";
	public static final String fecCorrected = "fecCorrected";

	private String alarmColorLv1;
	private String alarmColorLv2;
	private String alarmColorLv3;

	private int minDsSNRLv1;
	private int minDsSNRLv2;
	private int minDsSNRLv3;
	private int maxDsSNRLv1;
	private int maxDsSNRLv2;
	private int maxDsSNRLv3;
	private int minUsSNRLv1;	
	private int minUsSNRLv2;
	private int minUsSNRLv3;
	private int maxUsSNRLv1;
	private int maxUsSNRLv2;
	private int maxUsSNRLv3;
	private double minFecUncorrectableLv1;
	private double minFecUncorrectableLv2;
	private double minFecUncorrectableLv3;
	private double maxFecUncorrectableLv1;
	private double maxFecUncorrectableLv2;
	private double maxFecUncorrectableLv3;
	private double minFecCorrectedLv1;
	private double minFecCorrectedLv2;
	private double minFecCorrectedLv3;
	private double maxFecCorrectedLv1;
	private double maxFecCorrectedLv2;
	private double maxFecCorrectedLv3;

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
		PortletPreferences portletPreferences = portletRequest.getPreferences();

		alarmColorLv1 = portletPreferences.getValue("alarmColorLv1", "#ff9900");
		alarmColorLv2 = portletPreferences.getValue("alarmColorLv2", "#ff00ff");
		alarmColorLv3 = portletPreferences.getValue("alarmColorLv3", "#ff0000");

		minDsSNRLv1 = parseInt(portletPreferences.getValue("minDsSNRLv1", "30")) * 10;
		minDsSNRLv2 = parseInt(portletPreferences.getValue("minDsSNRLv2", "28")) * 10;
		minDsSNRLv3 = parseInt(portletPreferences.getValue("minDsSNRLv3", "22")) * 10;
		maxDsSNRLv1 = parseInt(portletPreferences.getValue("maxDsSNRLv1", "33")) * 10;
		maxDsSNRLv2 = parseInt(portletPreferences.getValue("maxDsSNRLv2", "30")) * 10;
		maxDsSNRLv3 = parseInt(portletPreferences.getValue("maxDsSNRLv3", "28")) * 10;
		minUsSNRLv1 = parseInt(portletPreferences.getValue("minUsSNRLv1", "20")) * 10;
		minUsSNRLv2 = parseInt(portletPreferences.getValue("minUsSNRLv2", "16")) * 10;
		minUsSNRLv3 = parseInt(portletPreferences.getValue("minUsSNRLv3", "10")) * 10;
		maxUsSNRLv1 = parseInt(portletPreferences.getValue("maxUsSNRLv1", "24")) * 10;
		maxUsSNRLv2 = parseInt(portletPreferences.getValue("maxUsSNRLv2", "20")) * 10;
		maxUsSNRLv3 = parseInt(portletPreferences.getValue("maxUsSNRLv3", "16")) * 10;
		minFecUncorrectableLv1 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv1", "0"));
		minFecUncorrectableLv2 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv2", "2"));
		minFecUncorrectableLv3 = parseDouble(portletPreferences.getValue("minFecUncorrectableLv3", "5"));
		maxFecUncorrectableLv1 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv1", "2"));
		maxFecUncorrectableLv2 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv2", "5"));
		maxFecUncorrectableLv3 = parseDouble(portletPreferences.getValue("maxFecUncorrectableLv3", "100"));
		minFecCorrectedLv1 = parseDouble(portletPreferences.getValue("minFecCorrectedLv1", "0"));
		minFecCorrectedLv2 = parseDouble(portletPreferences.getValue("minFecCorrectedLv2", "5"));
		minFecCorrectedLv3 = parseDouble(portletPreferences.getValue("minFecCorrectedLv3", "10"));
		maxFecCorrectedLv1 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv1", "5"));
		maxFecCorrectedLv2 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv2", "10"));
		maxFecCorrectedLv3 = parseDouble(portletPreferences.getValue("maxFecCorrectedLv3", "100"));
	}

	public CmRowStyleAlarmGenerator() {
	}

	@Override
	public String getRowDataCss(Object value, String dataType) {
		String cssStyle = "";

		switch (dataType) {

		case dsSNR: {
			double checkValue = (int) value;

			if (checkValue >= minDsSNRLv1 && checkValue <= maxDsSNRLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minDsSNRLv2 && checkValue <= maxDsSNRLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minDsSNRLv3 && checkValue <= maxDsSNRLv3) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv3 + ";";
			}
			break;
		}

		case usSNR: {
			double checkValue = (int) value;

			if (checkValue >= minUsSNRLv1 && checkValue <= maxUsSNRLv1) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv1 + ";";
			} else if (checkValue > minUsSNRLv2 && checkValue <= maxUsSNRLv2) {
				cssStyle = "font-weight: bold; color: #" + alarmColorLv2 + ";";
			} else if (checkValue > minUsSNRLv3 && checkValue <= maxUsSNRLv3) {
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

	private int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}

	/* Getters and Setters */

	public String getAlarmColorLv1() {
		return alarmColorLv1;
	}

	public void setAlarmColorLv1(String alarmColorLv1) {
		this.alarmColorLv1 = alarmColorLv1;
	}

	public String getAlarmColorLv2() {
		return alarmColorLv2;
	}

	public void setAlarmColorLv2(String alarmColorLv2) {
		this.alarmColorLv2 = alarmColorLv2;
	}

	public String getAlarmColorLv3() {
		return alarmColorLv3;
	}

	public void setAlarmColorLv3(String alarmColorLv3) {
		this.alarmColorLv3 = alarmColorLv3;
	}

	public int getMinDsSNRLv1() {
		return minDsSNRLv1;
	}

	public void setMinDsSNRLv1(int minDsSNRLv1) {
		this.minDsSNRLv1 = minDsSNRLv1;
	}

	public int getMinDsSNRLv2() {
		return minDsSNRLv2;
	}

	public void setMinDsSNRLv2(int minDsSNRLv2) {
		this.minDsSNRLv2 = minDsSNRLv2;
	}

	public int getMinDsSNRLv3() {
		return minDsSNRLv3;
	}

	public void setMinDsSNRLv3(int minDsSNRLv3) {
		this.minDsSNRLv3 = minDsSNRLv3;
	}

	public int getMaxDsSNRLv1() {
		return maxDsSNRLv1;
	}

	public void setMaxDsSNRLv1(int maxDsSNRLv1) {
		this.maxDsSNRLv1 = maxDsSNRLv1;
	}

	public int getMaxDsSNRLv2() {
		return maxDsSNRLv2;
	}

	public void setMaxDsSNRLv2(int maxDsSNRLv2) {
		this.maxDsSNRLv2 = maxDsSNRLv2;
	}

	public int getMaxDsSNRLv3() {
		return maxDsSNRLv3;
	}

	public void setMaxDsSNRLv3(int maxDsSNRLv3) {
		this.maxDsSNRLv3 = maxDsSNRLv3;
	}

	public int getMinUsSNRLv1() {
		return minUsSNRLv1;
	}

	public void setMinUsSNRLv1(int minUsSNRLv1) {
		this.minUsSNRLv1 = minUsSNRLv1;
	}

	public int getMinUsSNRLv2() {
		return minUsSNRLv2;
	}

	public void setMinUsSNRLv2(int minUsSNRLv2) {
		this.minUsSNRLv2 = minUsSNRLv2;
	}

	public int getMinUsSNRLv3() {
		return minUsSNRLv3;
	}

	public void setMinUsSNRLv3(int minUsSNRLv3) {
		this.minUsSNRLv3 = minUsSNRLv3;
	}

	public int getMaxUsSNRLv1() {
		return maxUsSNRLv1;
	}

	public void setMaxUsSNRLv1(int maxUsSNRLv1) {
		this.maxUsSNRLv1 = maxUsSNRLv1;
	}

	public int getMaxUsSNRLv2() {
		return maxUsSNRLv2;
	}

	public void setMaxUsSNRLv2(int maxUsSNRLv2) {
		this.maxUsSNRLv2 = maxUsSNRLv2;
	}

	public int getMaxUsSNRLv3() {
		return maxUsSNRLv3;
	}

	public void setMaxUsSNRLv3(int maxUsSNRLv3) {
		this.maxUsSNRLv3 = maxUsSNRLv3;
	}

	public double getMinFecUncorrectableLv1() {
		return minFecUncorrectableLv1;
	}

	public void setMinFecUncorrectableLv1(double minFecUncorrectableLv1) {
		this.minFecUncorrectableLv1 = minFecUncorrectableLv1;
	}

	public double getMinFecUncorrectableLv2() {
		return minFecUncorrectableLv2;
	}

	public void setMinFecUncorrectableLv2(double minFecUncorrectableLv2) {
		this.minFecUncorrectableLv2 = minFecUncorrectableLv2;
	}

	public double getMinFecUncorrectableLv3() {
		return minFecUncorrectableLv3;
	}

	public void setMinFecUncorrectableLv3(double minFecUncorrectableLv3) {
		this.minFecUncorrectableLv3 = minFecUncorrectableLv3;
	}

	public double getMaxFecUncorrectableLv1() {
		return maxFecUncorrectableLv1;
	}

	public void setMaxFecUncorrectableLv1(double maxFecUncorrectableLv1) {
		this.maxFecUncorrectableLv1 = maxFecUncorrectableLv1;
	}

	public double getMaxFecUncorrectableLv2() {
		return maxFecUncorrectableLv2;
	}

	public void setMaxFecUncorrectableLv2(double maxFecUncorrectableLv2) {
		this.maxFecUncorrectableLv2 = maxFecUncorrectableLv2;
	}

	public double getMaxFecUncorrectableLv3() {
		return maxFecUncorrectableLv3;
	}

	public void setMaxFecUncorrectableLv3(double maxFecUncorrectableLv3) {
		this.maxFecUncorrectableLv3 = maxFecUncorrectableLv3;
	}

	public double getMinFecCorrectedLv1() {
		return minFecCorrectedLv1;
	}

	public void setMinFecCorrectedLv1(double minFecCorrectedLv1) {
		this.minFecCorrectedLv1 = minFecCorrectedLv1;
	}

	public double getMinFecCorrectedLv2() {
		return minFecCorrectedLv2;
	}

	public void setMinFecCorrectedLv2(double minFecCorrectedLv2) {
		this.minFecCorrectedLv2 = minFecCorrectedLv2;
	}

	public double getMinFecCorrectedLv3() {
		return minFecCorrectedLv3;
	}

	public void setMinFecCorrectedLv3(double minFecCorrectedLv3) {
		this.minFecCorrectedLv3 = minFecCorrectedLv3;
	}

	public double getMaxFecCorrectedLv1() {
		return maxFecCorrectedLv1;
	}

	public void setMaxFecCorrectedLv1(double maxFecCorrectedLv1) {
		this.maxFecCorrectedLv1 = maxFecCorrectedLv1;
	}

	public double getMaxFecCorrectedLv2() {
		return maxFecCorrectedLv2;
	}

	public void setMaxFecCorrectedLv2(double maxFecCorrectedLv2) {
		this.maxFecCorrectedLv2 = maxFecCorrectedLv2;
	}

	public double getMaxFecCorrectedLv3() {
		return maxFecCorrectedLv3;
	}

	public void setMaxFecCorrectedLv3(double maxFecCorrectedLv3) {
		this.maxFecCorrectedLv3 = maxFecCorrectedLv3;
	}

	public static String getDssnr() {
		return dsSNR;
	}

	public static String getUssnr() {
		return usSNR;
	}

	public static String getFecuncorrectable() {
		return fecUncorrectable;
	}

	public static String getFeccorrected() {
		return fecCorrected;
	}

}
