package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.CableModemHistory;
import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.service.CableModemHistoryLocalServiceUtil;
import com.cmcti.cmts.domain.service.CableModemLocalServiceUtil;
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CableModemHistoryUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.util.CableModemConstants;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CableModemHistoryBean extends AbstractCRUDBean<CableModemHistory> implements Serializable {

	private static final long serialVersionUID = 8722946106153176757L;
	private static final Logger logger = LoggerFactory.getLogger(CableModemHistoryBean.class);
	private static final String PARAM_MAC_ADDRESS = "macAddress";
	
	private String macAddress;
	
	@PostConstruct
	public void init() {
		macAddress = JsfUtil.getRequestParameter(PARAM_MAC_ADDRESS);
		if (macAddress != null && !macAddress.trim().isEmpty()) {
			
		}
	}
	
	protected DynamicQuery updateQuery(DynamicQuery query) {
		if (this.macAddress != null && !this.macAddress.trim().isEmpty()) {
			if (query == null) query = CableModemLocalServiceUtil.dynamicQuery();
			
			// filter by macAddress
			query.add(RestrictionsFactoryUtil.eq("macAddress", macAddress));
			
			// order by create date
			query.addOrder(OrderFactoryUtil.desc("createDate"));
		}
		
		return query;
	}

	@Override
	protected CableModemHistory initEntity() {
		return CableModemHistoryUtil.create(0);
	}

	@Override
	protected LazyDataModel<CableModemHistory> initDataModel() {
		return new AbstractLazyDataModel<CableModemHistory>() {

			private static final long serialVersionUID = -7865865696816533980L;

			@Override
			protected Class<CableModemHistory> getModelClass() {
				return CableModemHistory.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return CableModemHistoryLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<CableModemHistory> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				// update query - filter by mac
				query = updateQuery(query);
				
				if (start >= 0 && end >= start) {
					return CableModemHistoryLocalServiceUtil.dynamicQuery(query, start, end);
				} else {
					return CableModemHistoryLocalServiceUtil.dynamicQuery(query);
				}
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				// update query - filter by mac
				query = updateQuery(query);
				
				return Long.valueOf(CableModemHistoryLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected CableModemHistory findById(long id) throws SystemException, PortalException {
				return CableModemHistoryLocalServiceUtil.getCableModemHistory(id);
			}
		};
	}

	@Override
	protected CableModemHistory addEntity(CableModemHistory entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CableModemHistory updateEntity(CableModemHistory entity) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void removeEntity(CableModemHistory entity) throws PortalException, SystemException {
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
	
	/* Getters and Setters */
	
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

}
