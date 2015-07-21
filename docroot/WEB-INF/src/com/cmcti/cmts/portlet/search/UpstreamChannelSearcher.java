package com.cmcti.cmts.portlet.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.model.Merchant;
import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;
import com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.bean.UcRowStyleAlarmGenerator;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

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

	protected String merchantCode;

	@ManagedProperty("#{ucRowStyleAlarmGenerator}")
	private UcRowStyleAlarmGenerator ucRowStyleAlarmGenerator;

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

			// Build junction
			mainDisjunction.add(avgOnlineCmDsSNRConjunction);
			mainDisjunction.add(fecCorrectedConjunction);
			mainDisjunction.add(fecUncorrectableConjunction);
			mainDisjunction.add(ifSigQSNRConjunction);

			query.add(mainDisjunction);
		}

		if (merchantCode != null && !merchantCode.trim().isEmpty()) {
			// fint merchant
			try {
				Merchant merchant = MerchantLocalServiceUtil.fetchByCode(merchantCode);
				if (merchant != null) {
					List<MerchantScope> merchantScopes = MerchantScopeLocalServiceUtil.findByMerchant(merchantCode);
					List<UpstreamChannelPK> listPK = new ArrayList<UpstreamChannelPK>();
					for (MerchantScope scope : merchantScopes) {
						listPK.add(new UpstreamChannelPK(scope.getIfIndex(), scope.getCmtsId()));
					}
					// Query
					if (!listPK.isEmpty())
						query.add(PropertyFactoryUtil.forName("primaryKey").in(listPK));
					else 
						query.add(RestrictionsFactoryUtil.sqlRestriction("1=2"));
				}
			} catch (SystemException e) {
				MessageUtil.addGlobalErrorMessage(MessageUtil.REQUEST_FAIL_MESSAGE);
			}

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

	public UcRowStyleAlarmGenerator getUcRowStyleAlarmGenerator() {
		return ucRowStyleAlarmGenerator;
	}

	public void setUcRowStyleAlarmGenerator(UcRowStyleAlarmGenerator ucRowStyleAlarmGenerator) {
		this.ucRowStyleAlarmGenerator = ucRowStyleAlarmGenerator;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

}