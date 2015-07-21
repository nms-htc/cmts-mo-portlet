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
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelPK;
import com.cmcti.cmts.domain.service.persistence.UpstreamChannelUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.search.Searcher;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

@ManagedBean
@ViewScoped
public class UpstreamChannelBean extends AbstractCRUDBean<UpstreamChannel> implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = -1060741011405634774L;
	private static final Logger logger = LoggerFactory.getLogger(UpstreamChannelBean.class);

	@ManagedProperty("#{upstreamChannelSearcher}")
	private Searcher searcher;

	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	@Override
	protected UpstreamChannel initEntity() {
		return UpstreamChannelUtil.create(new UpstreamChannelPK());
	}

	@Override
	protected LazyDataModel<UpstreamChannel> initDataModel() {
		AbstractLazyDataModel<UpstreamChannel> model = new AbstractLazyDataModel<UpstreamChannel>() {

			private static final long serialVersionUID = -978688692674807564L;

			@SuppressWarnings("unchecked")
			@Override
			protected List<UpstreamChannel> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start >= 0 && end >= start) {
					return UpstreamChannelLocalServiceUtil.dynamicQuery(query, start, end);
				}
				return UpstreamChannelLocalServiceUtil.dynamicQuery(query);
			}

			@Override
			protected Class<UpstreamChannel> getModelClass() {
				return UpstreamChannel.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return UpstreamChannelLocalServiceUtil.dynamicQuery();
			}

			@Override
			protected UpstreamChannel findById(long id) throws SystemException, PortalException {
				return null;
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(UpstreamChannelLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}
		};

		// set searcher
		model.setSearcher(searcher);
		return model;
	}

	@Override
	protected UpstreamChannel addEntity(UpstreamChannel entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected UpstreamChannel updateEntity(UpstreamChannel entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void removeEntity(UpstreamChannel entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub

	}

	public String calculate(String name) {
		return "Fuck you :" + name;
	}
	
	public String getTitle(String cmtsIfindex) {
		StringBuilder sb = new StringBuilder();
		if (cmtsIfindex != null && ! cmtsIfindex.trim().isEmpty()) {
			String[] ids = cmtsIfindex.split("-");
			try {
				long cmtsId = GetterUtil.getLong(ids[0], 0);
				int ifIndex = GetterUtil.getInteger(ids[1], 0);
				
				if (cmtsId > 0 && ifIndex > 0) {
					Cmts cmts = CmtsLocalServiceUtil.fetchCmts(cmtsId);
					if (cmts != null) sb.append(cmts.getTitle());
					
					UpstreamChannel up = UpstreamChannelLocalServiceUtil.fetchUpstreamChannel(new UpstreamChannelPK(ifIndex, cmtsId));
					if (up != null) {
						sb.append("-").append(up.getIfAlias());
					}
				}
				
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return sb.toString();
	}

}
