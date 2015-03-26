package com.cmcti.cmts.portlet.search;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

@ManagedBean
@ViewScoped
public class UpstreamChannelSearcher implements Searcher, Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 6082040933451578111L;

	protected Long cmtsId;
	protected Double minFecCorrected;
	protected Double maxFecCorrected;
	protected Double minFecUncorrectable;
	protected Double maxFecUncorrectable;
	protected Double minSigQSNR;
	protected Double maxSigQSNR;
	protected boolean alarmOnly = false;
	protected Double minTxPower;
	protected Double maxTxPower;
	protected Double minRxPower;
	protected Double maxRxPower;
	protected Double minMer;
	protected Double maxMer;

	public UpstreamChannelSearcher() {

	}

	@Override
	public DynamicQuery getSearchQuery() {
		DynamicQuery query = UpstreamChannelLocalServiceUtil.dynamicQuery();

		if (cmtsId != null && cmtsId != 0) {
			query.add(PropertyFactoryUtil.forName("primaryKey.cmtsId").eq(cmtsId));
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
		
		if (minSigQSNR != null) {
			query.add(RestrictionsFactoryUtil.ge("ifSigQSNR", minSigQSNR * 10));
		}
		
		if (maxSigQSNR != null) {
			query.add(RestrictionsFactoryUtil.le("ifSigQSNR", maxSigQSNR * 10));
		}
		
		if (minTxPower != null) {
			query.add(RestrictionsFactoryUtil.ge("avgOnlineCmTxPower", minTxPower * 10));
		}
		
		if (maxTxPower != null) {
			query.add(RestrictionsFactoryUtil.le("avgOnlineCmTxPower", maxTxPower * 10));
		}
		
		if (minRxPower != null) {
			query.add(RestrictionsFactoryUtil.ge("avgOnlineCmRxPower", minRxPower * 10));
		}
		
		if (maxRxPower != null) {
			query.add(RestrictionsFactoryUtil.le("avgOnlineCmRxPower", maxRxPower * 10));
		}
		
		if (minMer != null) {
			query.add(RestrictionsFactoryUtil.ge("avgOnlineCmDsSNR", minMer * 10));
		}
		
		if (maxMer != null) {
			query.add(RestrictionsFactoryUtil.le("avgOnlineCmDsSNR", maxMer * 10));
		}
		
		if (alarmOnly) {
			
		}

		return query;
	}

	public Long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(Long cmtsId) {
		this.cmtsId = cmtsId;
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

	public Double getMinSigQSNR() {
		return minSigQSNR;
	}

	public void setMinSigQSNR(Double minSigQSNR) {
		this.minSigQSNR = minSigQSNR;
	}

	public Double getMaxSigQSNR() {
		return maxSigQSNR;
	}

	public void setMaxSigQSNR(Double maxSigQSNR) {
		this.maxSigQSNR = maxSigQSNR;
	}

	public boolean isAlarmOnly() {
		return alarmOnly;
	}

	public void setAlarmOnly(boolean alarmOnly) {
		this.alarmOnly = alarmOnly;
	}

	public Double getMinTxPower() {
		return minTxPower;
	}

	public void setMinTxPower(Double minTxPower) {
		this.minTxPower = minTxPower;
	}

	public Double getMaxTxPower() {
		return maxTxPower;
	}

	public void setMaxTxPower(Double maxTxPower) {
		this.maxTxPower = maxTxPower;
	}

	public Double getMinRxPower() {
		return minRxPower;
	}

	public void setMinRxPower(Double minRxPower) {
		this.minRxPower = minRxPower;
	}

	public Double getMaxRxPower() {
		return maxRxPower;
	}

	public void setMaxRxPower(Double maxRxPower) {
		this.maxRxPower = maxRxPower;
	}

	public Double getMinMer() {
		return minMer;
	}

	public void setMinMer(Double minMer) {
		this.minMer = minMer;
	}

	public Double getMaxMer() {
		return maxMer;
	}

	public void setMaxMer(Double maxMer) {
		this.maxMer = maxMer;
	}

}