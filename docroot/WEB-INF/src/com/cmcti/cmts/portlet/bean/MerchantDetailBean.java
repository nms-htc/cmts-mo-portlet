package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.Merchant;
import com.cmcti.cmts.domain.model.MerchantScope;
import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;
import com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

@ManagedBean
@ViewScoped
public class MerchantDetailBean implements Serializable {

	private static final long serialVersionUID = -6191860693935996656L;
	private static final Logger logger = LoggerFactory.getLogger(MerchantDetailBean.class);
	private static final String MERCHANTID_PARAM = "merchantId";

	private Merchant current;
	private List<UpstreamChannel> selecteds = new ArrayList<UpstreamChannel>();
	private List<UpstreamChannel> removeds = new ArrayList<UpstreamChannel>();
	private LazyDataModel<UpstreamChannel> avaiableUpstreams;
	private LazyDataModel<UpstreamChannel> selectedUpstreams;

	@PostConstruct
	public void init() {
		LiferayFacesContext context = LiferayFacesContext.getInstance();
		long merchantId = context.getRequestParameterAsLong(MERCHANTID_PARAM, 0);
		if (merchantId > 0) {
			try {
				this.current = MerchantLocalServiceUtil.fetchMerchant(merchantId);
			} catch (SystemException e) {
				logger.error(e);
			}
		}
	}

	public void addToMerchant() {
		if (selecteds.size() > 0) {
			try {
				MerchantLocalServiceUtil.addUpstreamToMerchant(current.getMerchantId(), selecteds, JsfUtil.getServiceContext());
				selecteds.clear();
				MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);
			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage(e);
			}
		}
	}

	public void removeFromMerchant() {
		if (removeds.size() > 0) {
			try {
				MerchantLocalServiceUtil.removeUpstreamFromMerchant(current.getMerchantId(), removeds, JsfUtil.getServiceContext());
				removeds.clear();
				MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);
			} catch (Exception e) {
				logger.error(e);
				MessageUtil.addGlobalErrorMessage(e);
			}
		}
	}

	public Merchant getCurrent() {
		return current;
	}

	public void setCurrent(Merchant current) {
		this.current = current;
	}

	public List<UpstreamChannel> getSelecteds() {
		return selecteds;
	}

	public void setSelecteds(List<UpstreamChannel> selecteds) {
		this.selecteds = selecteds;
	}

	public LazyDataModel<UpstreamChannel> getAvaiableUpstreams() {
		if (avaiableUpstreams == null) {
			avaiableUpstreams = new AbstractLazyDataModel<UpstreamChannel>() {

				private static final long serialVersionUID = 5706848641321695774L;

				@Override
				public UpstreamChannel getRowData(String rowKey) {
					try {
						String[] params = rowKey.split("-");
						long cmtsId = GetterUtil.getLong(params[0], 0);
						int ifIndex = GetterUtil.getInteger(params[1], 0);
						UpstreamChannelPK pk = new UpstreamChannelPK(ifIndex, cmtsId);
						return UpstreamChannelLocalServiceUtil.fetchUpstreamChannel(pk);
					} catch (Exception e) {
						logger.error(e);
						return null;
					}
				}

				@Override
				public Object getRowKey(UpstreamChannel object) {
					UpstreamChannelPK pk = object.getPrimaryKey();
					long cmtsId = pk.getCmtsId();
					int ifIndex = pk.getIfIndex();
					return cmtsId + "-" + ifIndex;
				}

				@Override
				protected Class<UpstreamChannel> getModelClass() {
					return UpstreamChannel.class;
				}

				@Override
				protected DynamicQuery getDynamicQuery() {
					return UpstreamChannelLocalServiceUtil.dynamicQuery();
				}

				@SuppressWarnings("unchecked")
				@Override
				protected List<UpstreamChannel> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
					query = updateAvaiableQuery(query);
					if (start >= 0 && end >= start) {
						return UpstreamChannelLocalServiceUtil.dynamicQuery(query, start, end);
					}
					return UpstreamChannelLocalServiceUtil.dynamicQuery(query);
				}

				@Override
				protected int count(DynamicQuery query) throws SystemException, PortalException {
					query = updateAvaiableQuery(query);
					return Long.valueOf(UpstreamChannelLocalServiceUtil.dynamicQueryCount(query)).intValue();
				}

				@Override
				protected UpstreamChannel findById(long id) throws SystemException, PortalException {
					return null;
				}
			};
		}
		return avaiableUpstreams;
	}

	public void setAvaiableUpstreams(LazyDataModel<UpstreamChannel> avaiableUpstreams) {
		this.avaiableUpstreams = avaiableUpstreams;
	}

	public LazyDataModel<UpstreamChannel> getSelectedUpstreams() {
		if (selectedUpstreams == null) {
			selectedUpstreams = new AbstractLazyDataModel<UpstreamChannel>() {
				private static final long serialVersionUID = -7349841474674387951L;

				@Override
				public UpstreamChannel getRowData(String rowKey) {
					try {
						String[] params = rowKey.split("-");
						long cmtsId = GetterUtil.getLong(params[0], 0);
						int ifIndex = GetterUtil.getInteger(params[1], 0);
						UpstreamChannelPK pk = new UpstreamChannelPK(ifIndex, cmtsId);
						return UpstreamChannelLocalServiceUtil.fetchUpstreamChannel(pk);
					} catch (Exception e) {
						logger.error(e);
						return null;
					}
				}

				@Override
				public Object getRowKey(UpstreamChannel object) {
					UpstreamChannelPK pk = object.getPrimaryKey();
					long cmtsId = pk.getCmtsId();
					int ifIndex = pk.getIfIndex();
					return cmtsId + "-" + ifIndex;
				}

				@Override
				protected Class<UpstreamChannel> getModelClass() {
					return UpstreamChannel.class;
				}

				@Override
				protected DynamicQuery getDynamicQuery() {
					return UpstreamChannelLocalServiceUtil.dynamicQuery();
				}

				@SuppressWarnings("unchecked")
				@Override
				protected List<UpstreamChannel> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
					query = updateSelectedQuery(query);
					if (start >= 0 && end >= start) {
						return UpstreamChannelLocalServiceUtil.dynamicQuery(query, start, end);
					}
					return UpstreamChannelLocalServiceUtil.dynamicQuery(query);
				}

				@Override
				protected int count(DynamicQuery query) throws SystemException, PortalException {
					query = updateSelectedQuery(query);
					return Long.valueOf(UpstreamChannelLocalServiceUtil.dynamicQueryCount(query)).intValue();
				}

				@Override
				protected UpstreamChannel findById(long id) throws SystemException, PortalException {
					return null;
				}
			};
		}
		return selectedUpstreams;
	}

	public void setSelectedUpstreams(LazyDataModel<UpstreamChannel> selectedUpstreams) {
		this.selectedUpstreams = selectedUpstreams;
	}

	private DynamicQuery updateAvaiableQuery(DynamicQuery dynamicQuery) {
		String merchantCode = current.getCode();
		List<UpstreamChannelPK> pks = new ArrayList<UpstreamChannelPK>();
		try {
			List<MerchantScope> scopes = MerchantScopeLocalServiceUtil.findByMerchant(merchantCode);
			for (MerchantScope scope : scopes) {
				pks.add(new UpstreamChannelPK(scope.getIfIndex(), scope.getCmtsId()));
			}
		} catch (SystemException e) {
			logger.error(e);
		}
		
		if (pks != null && pks.size() > 0)
			dynamicQuery.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("primaryKey").in(pks)));
		
		return dynamicQuery;
	}

	private DynamicQuery updateSelectedQuery(DynamicQuery dynamicQuery) {
		String merchantCode = current.getCode();
		List<UpstreamChannelPK> pks = new ArrayList<UpstreamChannelPK>();
		try {
			List<MerchantScope> scopes = MerchantScopeLocalServiceUtil.findByMerchant(merchantCode);
			for (MerchantScope scope : scopes) {
				pks.add(new UpstreamChannelPK(scope.getIfIndex(), scope.getCmtsId()));
			}
		} catch (SystemException e) {
			logger.error(e);
		}
		
		if (pks != null && pks.size() > 0)
			dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey").in(pks));
			
		else
			dynamicQuery.add(RestrictionsFactoryUtil.sqlRestriction("0=1"));
		return dynamicQuery;
	}

	public List<UpstreamChannel> getRemoveds() {
		return removeds;
	}

	public void setRemoveds(List<UpstreamChannel> removeds) {
		this.removeds = removeds;
	}
}
