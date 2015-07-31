package com.cmcti.cmts.portlet.search;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.bean.CmRowStyleAlarmGenerator;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

@ManagedBean
@ViewScoped
public class CableModemHistorySearcher implements Searcher, Serializable {

	private static final long serialVersionUID = 8159475618852310593L;
	private static final Logger logger = LoggerFactory.getLogger(CableModemHistorySearcher.class);
	private static final String IFINDEX_PARAM = "ifIndex";
	private static final String CMTSID_PARAM = "cmtsId";
	private static final String MACADDRESS_PARAM = "macAddress";

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

	/**
	 * For display cable model for one upstream...
	 */
	private int ifIndex;
	private long cmtsId;
	private String macAddress;
	private Date startDate;
	private Date endDate;

	private UpstreamChannel upstreamChannel;

	@PostConstruct
	public void init() {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();

		ifIndex = liferayFacesContext.getRequestParameterAsInt(IFINDEX_PARAM, 0);
		cmtsId = liferayFacesContext.getRequestParameterAsLong(CMTSID_PARAM, 0);

		if (cmtsId > 0 && ifIndex > 0) {
			try {
				UpstreamChannelPK upstreamChannelPK = new UpstreamChannelPK(ifIndex, cmtsId);
				upstreamChannel = UpstreamChannelLocalServiceUtil.getUpstreamChannel(upstreamChannelPK);
			} catch (Exception e) {
				logger.warn("Upstream channel is not found with cmtsId = {0} and ifIndex = {1}", cmtsId, ifIndex);
			}
		}

		macAddress = liferayFacesContext.getRequestParameter(MACADDRESS_PARAM);
	}

	@ManagedProperty("#{cmRowStyleAlarmGenerator}")
	private CmRowStyleAlarmGenerator cmRowStyleAlarmGenerator;

	@Override
	public DynamicQuery getSearchQuery() {
		DynamicQuery query = CableModemHistoryLocalServiceUtil.dynamicQuery();

		// Filter upstream channel.
		if (upstreamChannel != null) {
			query.add(RestrictionsFactoryUtil.eq("ucIfIndex", upstreamChannel.getIfIndex()));
			query.add(RestrictionsFactoryUtil.eq("cmtsId", upstreamChannel.getCmtsId()));
		}

		// Filter macAddress
		if (macAddress != null && !macAddress.trim().isEmpty()) {
			query.add(RestrictionsFactoryUtil.eq("macAddress", macAddress.trim()));
		}
		// Filter date time
		if (startDate != null) {
			query.add(RestrictionsFactoryUtil.gt("createDate", startDate));
		}

		if (endDate != null) {
			query.add(RestrictionsFactoryUtil.lt("createDate", endDate));
		}

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
			query.add(RestrictionsFactoryUtil.le("usSNR", (int) (maxUsSNR * 10)));
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
			Junction mainDisjunction = RestrictionsFactoryUtil.disjunction();

			// avgOnlineCmDsSNR check
			Junction dsSNRConjunction = RestrictionsFactoryUtil.conjunction();
			dsSNRConjunction.add(RestrictionsFactoryUtil.ge("dsSNR", cmRowStyleAlarmGenerator.getMinDsSNRLv3()));
			dsSNRConjunction.add(RestrictionsFactoryUtil.le("dsSNR", cmRowStyleAlarmGenerator.getMaxDsSNRLv1()));

			// ifSigQSNR check
			Junction usSNRConjunction = RestrictionsFactoryUtil.conjunction();
			usSNRConjunction.add(RestrictionsFactoryUtil.ge("usSNR", cmRowStyleAlarmGenerator.getMinUsSNRLv3()));
			usSNRConjunction.add(RestrictionsFactoryUtil.le("usSNR", cmRowStyleAlarmGenerator.getMaxUsSNRLv1()));

			// fecCorrected check
			Junction fecCorrectedConjunction = RestrictionsFactoryUtil.conjunction();
			fecCorrectedConjunction.add(RestrictionsFactoryUtil.gt("fecCorrected", cmRowStyleAlarmGenerator.getMinFecCorrectedLv1()));

			// fecUncorrectable check
			Junction fecUncorrectableConjunction = RestrictionsFactoryUtil.conjunction();
			fecUncorrectableConjunction.add(RestrictionsFactoryUtil.gt("fecUncorrectable",
					cmRowStyleAlarmGenerator.getMinFecUncorrectableLv1()));
			// TxPower
			Junction txPowerConjunction = RestrictionsFactoryUtil.conjunction();
			txPowerConjunction.add(RestrictionsFactoryUtil.gt("txPower", cmRowStyleAlarmGenerator.getMinTxPowerLv1()));
			txPowerConjunction.add(RestrictionsFactoryUtil.le("txPower", cmRowStyleAlarmGenerator.getMaxTxPowerLv3()));

			// Build junction
			mainDisjunction.add(dsSNRConjunction);
			mainDisjunction.add(usSNRConjunction);
			mainDisjunction.add(fecCorrectedConjunction);
			mainDisjunction.add(fecUncorrectableConjunction);
			mainDisjunction.add(txPowerConjunction);

			query.add(mainDisjunction);
		}

		// Defautl order
		query.addOrder(OrderFactoryUtil.desc("createDate"));

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

	public CmRowStyleAlarmGenerator getCmRowStyleAlarmGenerator() {
		return cmRowStyleAlarmGenerator;
	}

	public void setCmRowStyleAlarmGenerator(CmRowStyleAlarmGenerator cmRowStyleAlarmGenerator) {
		this.cmRowStyleAlarmGenerator = cmRowStyleAlarmGenerator;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	public long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(long cmtsId) {
		this.cmtsId = cmtsId;
	}

	public UpstreamChannel getUpstreamChannel() {
		return upstreamChannel;
	}

	public void setUpstreamChannel(UpstreamChannel upstreamChannel) {
		this.upstreamChannel = upstreamChannel;
	}

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
