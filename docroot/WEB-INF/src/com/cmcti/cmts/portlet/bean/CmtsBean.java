package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.Cmts;
import com.cmcti.cmts.domain.service.CmtsLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CmtsUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CmtsBean extends AbstractCRUDBean<Cmts> implements Serializable {

	private static final long serialVersionUID = 8227859901233549556L;
	private static final Logger _LOGGER = LoggerFactory.getLogger(CmtsBean.class);
	
	protected SelectItem[] items;

	@Override
	protected Cmts initEntity() {
		return CmtsUtil.create(0);
	}

	@Override
	protected LazyDataModel<Cmts> initDataModel() {
		return new AbstractLazyDataModel<Cmts>() {

			private static final long serialVersionUID = 4676869998192952151L;

			@Override
			protected Class<Cmts> getModelClass() {
				return Cmts.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return CmtsLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<Cmts> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start >= 0 && end >= start) {
					return CmtsLocalServiceUtil.dynamicQuery(query, start, end);
				} else {
					return CmtsLocalServiceUtil.dynamicQuery(query);
				}
				
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(CmtsLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected Cmts findById(long id) throws SystemException, PortalException {
				return CmtsLocalServiceUtil.getCmts(id);
			}


		};
	}

	@Override
	protected Cmts addEntity(Cmts entity) throws PortalException, SystemException {
		long cmtsId = CounterLocalServiceUtil.increment(Cmts.class.getName());
		Date now = new Date();
		
		entity.setCmtsId(cmtsId);
		entity.setUserId(LiferayFacesContext.getInstance().getUserId());
		entity.setUserName(LiferayFacesContext.getInstance().getUser().getScreenName());
		entity.setGroupId(LiferayFacesContext.getInstance().getScopeGroupId());
		entity.setCompanyId(LiferayFacesContext.getInstance().getCompanyId());
		entity.setCreateDate(now);
		entity.setModifiedDate(now);
		
		// persist cmts
		return CmtsLocalServiceUtil.addCmts(entity);
	}

	@Override
	protected Cmts updateEntity(Cmts entity) throws PortalException, SystemException {
		Date now = new Date();
		entity.setModifiedDate(now);
		return CmtsLocalServiceUtil.updateCmts(current);
	}

	@Override
	protected void removeEntity(Cmts entity) throws PortalException, SystemException {
		CmtsLocalServiceUtil.deleteCmts(entity);
		this.current = null;
	}
	
	public SelectItem[] getSelectItems() {
		if (items == null) {
			List<Cmts> cmtses = new ArrayList<>();
			try {
				cmtses = CmtsLocalServiceUtil.getCmtses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				_LOGGER.error(e);
			}
			items = new SelectItem[cmtses.size()];
			
			for (int i = 0; i < cmtses.size(); i++) {
				Cmts cmts = cmtses.get(i);
				items[i] = new SelectItem(cmts.getCmtsId(), cmts.getTitle());
			}
		}
		
		return items;
	}

}
