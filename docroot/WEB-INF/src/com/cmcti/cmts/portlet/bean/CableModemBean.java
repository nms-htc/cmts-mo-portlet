package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.CableModem;
import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CableModemUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.search.Searcher;
import com.cmcti.cmts.portlet.util.CableModemConstants;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CableModemBean extends AbstractCRUDBean<CableModem> implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = -8931856153021958206L;
	private static final Logger logger = LoggerFactory.getLogger(CableModemBean.class);

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
				return null;// CableModemLocalServiceUtil.getCableModem(id);
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

	/**
	 * Use to show Subscriber Address on CableModel datatable.
	 * 
	 * @param macAddress
	 * @return
	 */
	public String getCustomerTitle(String macAddress) {
		CustomerMacMapping mapping = null;
		try {
			mapping = CustomerMacMappingLocalServiceUtil.getByMacAddress(macAddress);
		} catch (Exception e) {
			logger.info("Customer mapping not found for mac {0}", macAddress);
		}
		return mapping == null ? null : mapping.getTitle();
	}

	/**
	 * Convert cable modem status to String (resource bundle key)
	 * @param status
	 * @return
	 */
	public String getCableStatus(int status) {
		String statusStr = null;

		switch (status) {
		case CableModemConstants.STATUS_ACCESS_DENIED:
			statusStr = "access-denied";
			break;
			
		case CableModemConstants.STATUS_IP_COMPLETE:
			statusStr = "ip-complete";
			break;
			
		case CableModemConstants.STATUS_OTHER:
			statusStr = "other";
			break;

		case CableModemConstants.STATUS_RANGING:
			statusStr = "ranging";
			break;

		case CableModemConstants.STATUS_RANGING_ABORTED:
			statusStr = "ranging-aborted";
			break;

		case CableModemConstants.STATUS_RANGING_COMPLETE:
			statusStr = "ranging-complete";
			break;

		case CableModemConstants.STATUS_REGISTRATION_COMPLETE:
			statusStr = "registration-complete";
			break;
		}

		return statusStr;
	}
}
