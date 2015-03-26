package com.cmcti.cmts.portlet.search;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

@ManagedBean
@ViewScoped
public class CableModemSearcher implements Searcher, Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 4662398953120024302L;

	protected Double minDsSNR;
	protected Double maxDsSNR;
	protected Double minUsSNR;
	protected Double maxUsSNR;
	protected Double minFecCorrected;
	protected Double maxFecCorrected;
	protected Double minFecUncorrectable;
	protected Double maxFecUncorrectable;
	protected Double minUsPower;
	protected Double maxUsPower;
	protected Double minDsPower;
	protected Double maxDsPower;
	protected boolean alarmOnly = false;

	@Override
	public DynamicQuery getSearchQuery() {
		DynamicQuery query = CableModemLocalServiceUtil.dynamicQuery();

		if (minDsSNR != null) {
			query.add(RestrictionsFactoryUtil.ge("dsSNR", (int) (minDsSNR * 10)));
		}

		if (maxDsSNR != null) {
			query.add(RestrictionsFactoryUtil.le("dsSNR", (int) (maxDsSNR * 10)));
		}

		if (minUsSNR != null) {
			query.add(RestrictionsFactoryUtil.ge("usSNR", (int) (minUsSNR * 10)));
		}

		if (maxUsSNR != null) {
			query.add(RestrictionsFactoryUtil.le("usSNR", (int)  (maxUsSNR * 10)));
		}

		if (minFecCorrected != null) {
			query.add(RestrictionsFactoryUtil.ge("fecCorrected", minFecCorrected));
		}

		if (maxFecCorrected != null) {
			query.add(RestrictionsFactoryUtil.le("fecCorrected", maxFecCorrected));
		}

		if (minFecUncorrectable != null) {
			query.add(RestrictionsFactoryUtil.ge("fecUncorrectable", minFecUncorrectable));
		}

		if (maxFecUncorrectable != null) {
			query.add(RestrictionsFactoryUtil.le("fecUncorrectable", maxFecUncorrectable));
		}

		if (minDsPower != null) {
			query.add(RestrictionsFactoryUtil.ge("dsPower", (int) (minDsPower * 10)));
		}

		if (maxDsPower != null) {
			query.add(RestrictionsFactoryUtil.le("dsPower", (int) (maxDsPower * 10)));
		}

		if (minUsPower != null) {
			query.add(RestrictionsFactoryUtil.ge("usPower", (int) (minUsPower * 10)));
		}

		if (maxUsPower != null) {
			query.add(RestrictionsFactoryUtil.le("usPower", (int) (maxUsPower * 10)));
		}
		
		if (alarmOnly) {
			// 
		}

		return query;
	}

	public Double getMinDsSNR() {
		return minDsSNR;
	}

	public void setMinDsSNR(Double minDsSNR) {
		this.minDsSNR = minDsSNR;
	}

	public Double getMaxDsSNR() {
		return maxDsSNR;
	}

	public void setMaxDsSNR(Double maxDsSNR) {
		this.maxDsSNR = maxDsSNR;
	}

	public Double getMinUsSNR() {
		return minUsSNR;
	}

	public void setMinUsSNR(Double minUsSNR) {
		this.minUsSNR = minUsSNR;
	}

	public Double getMaxUsSNR() {
		return maxUsSNR;
	}

	public void setMaxUsSNR(Double maxUsSNR) {
		this.maxUsSNR = maxUsSNR;
	}

	public Double getMinFecCorrected() {
		return minFecCorrected;
	}

	public void setMinFecCorrected(Double minFecCorrected) {
		this.minFecCorrected = minFecCorrected;
	}

	public Double getMaxFecCorrected() {
		return maxFecCorrected;
	}

	public void setMaxFecCorrected(Double maxFecCorrected) {
		this.maxFecCorrected = maxFecCorrected;
	}

	public Double getMinFecUncorrectable() {
		return minFecUncorrectable;
	}

	public void setMinFecUncorrectable(Double minFecUncorrectable) {
		this.minFecUncorrectable = minFecUncorrectable;
	}

	public Double getMaxFecUncorrectable() {
		return maxFecUncorrectable;
	}

	public void setMaxFecUncorrectable(Double maxFecUncorrectable) {
		this.maxFecUncorrectable = maxFecUncorrectable;
	}

	public Double getMinUsPower() {
		return minUsPower;
	}

	public void setMinUsPower(Double minUsPower) {
		this.minUsPower = minUsPower;
	}

	public Double getMaxUsPower() {
		return maxUsPower;
	}

	public void setMaxUsPower(Double maxUsPower) {
		this.maxUsPower = maxUsPower;
	}

	public Double getMinDsPower() {
		return minDsPower;
	}

	public void setMinDsPower(Double minDsPower) {
		this.minDsPower = minDsPower;
	}

	public Double getMaxDsPower() {
		return maxDsPower;
	}

	public void setMaxDsPower(Double maxDsPower) {
		this.maxDsPower = maxDsPower;
	}

	public boolean isAlarmOnly() {
		return alarmOnly;
	}

	public void setAlarmOnly(boolean alarmOnly) {
		this.alarmOnly = alarmOnly;
	}

}
