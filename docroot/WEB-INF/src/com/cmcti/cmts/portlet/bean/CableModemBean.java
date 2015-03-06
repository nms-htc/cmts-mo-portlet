package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CableModemUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.search.Searcher;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CableModemBean extends AbstractCRUDBean<CableModem> implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = -8931856153021958206L;
	
	@ManagedProperty("#{cableModemSearcher}")
	private Searcher searcher;
	
	public Searcher getSearcher() {
		return searcher;
	}
	
	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	@Override
	protected CableModem initEntity() {
		return CableModemUtil.create(null);
	}

	@Override
	protected LazyDataModel<CableModem> initDataModel() {
		AbstractLazyDataModel<CableModem> model = new AbstractLazyDataModel<CableModem>() {
			
			private static final long serialVersionUID = -8146468859210811155L;

			@SuppressWarnings("unchecked")
			@Override
			protected List<CableModem> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start >= 0 && end >= start) 
					return CableModemLocalServiceUtil.dynamicQuery(query, start, end);
				return CableModemLocalServiceUtil.dynamicQuery(query);
			}
			
			@Override
			protected Class<CableModem> getModelClass() {
				return CableModem.class;
			}
			
			@Override
			protected DynamicQuery getDynamicQuery() {
				return CableModemLocalServiceUtil.dynamicQuery();
			}
			
			@Override
			protected CableModem findById(long id) throws SystemException, PortalException {
				return null;//CableModemLocalServiceUtil.getCableModem(id);
			}
			
			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(CableModemLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}
		};
		
		// set searcher
		model.setSearcher(searcher);
		
		return model;
	}

	@Override
	protected CableModem addEntity(CableModem entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CableModem updateEntity(CableModem entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void removeEntity(CableModem entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		
	}
}
