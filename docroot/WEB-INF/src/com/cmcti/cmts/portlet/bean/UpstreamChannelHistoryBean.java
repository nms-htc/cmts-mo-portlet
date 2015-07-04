package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.model.UpstreamChannelHistory;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelHistoryUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.search.Searcher;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class UpstreamChannelHistoryBean extends AbstractCRUDBean<UpstreamChannelHistory> implements Serializable {

	private static final long serialVersionUID = 3648540335648027440L;
	private static final Logger logger = LoggerFactory.getLogger(UpstreamChannelHistoryBean.class);
	
	private static final String PARAM_IFINDEX = "ifIndex";
	private static final String PARAM_CMTSID = "cmtsId";
	
	private UpstreamChannel channel;
	private Cmts cmts;
	
	@ManagedProperty("#{upstreamChannelHistorySearcher}")
	private Searcher searcher;
	
	/* Param requets */
	private int ifIndex;
	private Long cmtsId;
	
	@PostConstruct
	public void init() {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		
		ifIndex = liferayFacesContext.getRequestParameterAsInt(PARAM_IFINDEX, 0);
		cmtsId = liferayFacesContext.getRequestParameterAsLong(PARAM_CMTSID, 0);
		
		try {
			cmts = CmtsLocalServiceUtil.getCmts(cmtsId);
			channel = UpstreamChannelLocalServiceUtil.getUpstreamChannel(new UpstreamChannelPK(ifIndex, cmtsId));
		} catch (Exception e) {
			logger.error("Error when load history and cmts", e);
		}
	}
	
	protected DynamicQuery updateQuery(DynamicQuery query) {
		if (ifIndex > 0 && cmtsId > 0) {
			if (query == null) query = UpstreamChannelHistoryLocalServiceUtil.dynamicQuery();
			
			query.add(RestrictionsFactoryUtil.eq("ifIndex", ifIndex));
			query.add(RestrictionsFactoryUtil.eq("cmtsId", cmtsId));
			
			query.addOrder(OrderFactoryUtil.desc("createDate"));
		}
		return query;
	}
	
	@Override
	protected UpstreamChannelHistory initEntity() {
		return UpstreamChannelHistoryUtil.create(0);
	}

	@Override
	protected LazyDataModel<UpstreamChannelHistory> initDataModel() {
		AbstractLazyDataModel<UpstreamChannelHistory> model =  new AbstractLazyDataModel<UpstreamChannelHistory>() {

			private static final long serialVersionUID = 7196907692291004915L;

			@Override
			protected Class<UpstreamChannelHistory> getModelClass() {
				return UpstreamChannelHistory.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return UpstreamChannelHistoryLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<UpstreamChannelHistory> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start > 0 && end > start) {
					return UpstreamChannelHistoryLocalServiceUtil.dynamicQuery(query, start, end);
				}
				return UpstreamChannelHistoryLocalServiceUtil.dynamicQuery(query);
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(UpstreamChannelHistoryLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected UpstreamChannelHistory findById(long id) throws SystemException, PortalException {
				return UpstreamChannelHistoryLocalServiceUtil.getUpstreamChannelHistory(id);
			}
		};
		
		model.setSearcher(searcher);
		
		return model;
	}

	@Override
	protected UpstreamChannelHistory addEntity(UpstreamChannelHistory entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected UpstreamChannelHistory updateEntity(UpstreamChannelHistory entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void removeEntity(UpstreamChannelHistory entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		
	}

	public UpstreamChannel getChannel() {
		return channel;
	}

	public void setChannel(UpstreamChannel channel) {
		this.channel = channel;
	}

	public Cmts getCmts() {
		return cmts;
	}

	public void setCmts(Cmts cmts) {
		this.cmts = cmts;
	}

	public int getIfIndex() {
		return ifIndex;
	}

	public void setIfIndex(int ifIndex) {
		this.ifIndex = ifIndex;
	}

	public Long getCmtsId() {
		return cmtsId;
	}

	public void setCmtsId(Long cmtsId) {
		this.cmtsId = cmtsId;
	}
	
	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
	
}
