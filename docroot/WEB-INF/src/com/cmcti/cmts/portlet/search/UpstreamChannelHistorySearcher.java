package com.cmcti.cmts.portlet.search;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalServiceUtil;
import com.cmcti.cmts.portlet.bean.UcRowStyleAlarmGenerator;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

@ManagedBean
@ViewScoped
public class UpstreamChannelHistorySearcher implements Searcher, Serializable {

	private static final long serialVersionUID = -7031043247557781958L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UpstreamChannelHistorySearcher.class);
	private static final String CMTSID_PARAM = "cmtsId";
	private static final String IfINDEX_PARAM = "ifIndex";
	private static final String CREATE_DATE = "createDate";

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

	protected int ifIndex;
	protected Date createDate;
	protected Date startDate;
	protected Date endDate;

	@PostConstruct
	public void init() {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();

		cmtsId = liferayFacesContext.getRequestParameterAsLong(CMTSID_PARAM, 0);
		ifIndex = liferayFacesContext.getRequestParameterAsInt(IfINDEX_PARAM, 0);
		long lCreateDate = liferayFacesContext.getRequestParameterAsLong(CREATE_DATE, 0);
		if (lCreateDate > 0)
			createDate = new Date(lCreateDate);
	}

	@ManagedProperty("#{ucRowStyleAlarmGenerator}")
	private UcRowStyleAlarmGenerator ucRowStyleAlarmGenerator;

	@Override
	public DynamicQuery getSearchQuery() {
		DynamicQuery query = UpstreamChannelHistoryLocalServiceUtil.dynamicQuery();

		if (ifIndex > 0) {
			query.add(RestrictionsFactoryUtil.eq("ifIndex", ifIndex));
		}

		if (startDate != null) {
			query.add(RestrictionsFactoryUtil.gt("createDate", startDate));
		}

		if (endDate != null) {
			query.add(RestrictionsFactoryUtil.lt("createDate", endDate));
		}

		if (cmtsId != null && cmtsId != 0) {
			query.add(PropertyFactoryUtil.forName("cmtsId").eq(cmtsId));
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
			Junction mainDisjunction = RestrictionsFactoryUtil.disjunction();

			// avgOnlineCmDsSNR check
			Junction avgOnlineCmDsSNRConjunction = RestrictionsFactoryUtil.conjunction();
			avgOnlineCmDsSNRConjunction.add(RestrictionsFactoryUtil.ge("avgOnlineCmDsSNR",
					ucRowStyleAlarmGenerator.getMinAvgOnlineCmDnSNRLv3()));
			avgOnlineCmDsSNRConjunction.add(RestrictionsFactoryUtil.le("avgOnlineCmDsSNR",
					ucRowStyleAlarmGenerator.getMaxAvgOnlineCmDnSNRLv1()));

			// fecCorrected check
			Junction fecCorrectedConjunction = RestrictionsFactoryUtil.conjunction();
			fecCorrectedConjunction.add(RestrictionsFactoryUtil.gt("fecCorrected", ucRowStyleAlarmGenerator.getMinFecCorrectedLv1()));
			// fecCorrectedConjunction.add(RestrictionsFactoryUtil.le("fecCorrected",
			// ucRowStyleAlarmGenerator.getMaxFecCorrectedLv3()));

			// fecUncorrectable check
			Junction fecUncorrectableConjunction = RestrictionsFactoryUtil.conjunction();
			fecUncorrectableConjunction.add(RestrictionsFactoryUtil.gt("fecUncorrectable",
					ucRowStyleAlarmGenerator.getMinFecUncorrectableLv1()));
			// fecUncorrectableConjunction.add(RestrictionsFactoryUtil.le("fecUncorrectable",
			// ucRowStyleAlarmGenerator.getMaxFecUncorrectableLv3()));

			// ifSigQSNR check
			Junction ifSigQSNRConjunction = RestrictionsFactoryUtil.conjunction();
			ifSigQSNRConjunction.add(RestrictionsFactoryUtil.ge("ifSigQSNR", ucRowStyleAlarmGenerator.getMinIfSigQSNRLv3()));
			ifSigQSNRConjunction.add(RestrictionsFactoryUtil.le("ifSigQSNR", ucRowStyleAlarmGenerator.getMaxIfSigQSNRLv1()));

			Junction avgOnlineCmTxPowerConjunction = RestrictionsFactoryUtil.conjunction();
			avgOnlineCmTxPowerConjunction.add(RestrictionsFactoryUtil.ge("avgOnlineCmTxPower",
					ucRowStyleAlarmGenerator.getMinAvgOnlineCmTxPowerLv1()));
			avgOnlineCmTxPowerConjunction.add(RestrictionsFactoryUtil.le("avgOnlineCmTxPower",
					ucRowStyleAlarmGenerator.getMaxAvgOnlineCmTxPowerLv3()));

			// Build junction
			mainDisjunction.add(avgOnlineCmDsSNRConjunction);
			mainDisjunction.add(fecCorrectedConjunction);
			mainDisjunction.add(fecUncorrectableConjunction);
			mainDisjunction.add(ifSigQSNRConjunction);
			mainDisjunction.add(avgOnlineCmTxPowerConjunction);

			query.add(mainDisjunction);
		}

		if (createDate != null) {
			query.setLimit(0, 1);
			query.add(RestrictionsFactoryUtil.gt("createDate", createDate));
			query.addOrder(OrderFactoryUtil.asc("createDate"));
		} else
			// Defautl order
			query.addOrder(OrderFactoryUtil.desc("createDate"));

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

	public UcRowStyleAlarmGenerator getUcRowStyleAlarmGenerator() {
		return ucRowStyleAlarmGenerator;
	}

	public void setUcRowStyleAlarmGenerator(UcRowStyleAlarmGenerator ucRowStyleAlarmGenerator) {
		this.ucRowStyleAlarmGenerator = ucRowStyleAlarmGenerator;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
