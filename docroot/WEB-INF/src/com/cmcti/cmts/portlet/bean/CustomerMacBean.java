package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CustomerMacMappingUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CustomerMacBean extends AbstractCRUDBean<CustomerMacMapping> implements Serializable{

	// serialVersionUID
	private static final long serialVersionUID = 8049919349164930939L;
	private static final Logger logger = LoggerFactory.getLogger(CustomerMacBean.class);

	private boolean removeAll;
	
	@Override
	protected CustomerMacMapping initEntity() {
		return CustomerMacMappingUtil.create(0);
	}

	@Override
	protected LazyDataModel<CustomerMacMapping> initDataModel() {
		return new AbstractLazyDataModel<CustomerMacMapping>() {

			private static final long serialVersionUID = -1168934263144771706L;

			@Override
			protected Class<CustomerMacMapping> getModelClass() {
				return CustomerMacMapping.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return CustomerMacMappingLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<CustomerMacMapping> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start >= 0 && end >= start) {
					return CustomerMacMappingLocalServiceUtil.dynamicQuery(query, start, end);
				}
				return CustomerMacMappingLocalServiceUtil.dynamicQuery(query);
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(CustomerMacMappingLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected CustomerMacMapping findById(long id) throws SystemException, PortalException {
				return CustomerMacMappingLocalServiceUtil.getCustomerMacMapping(id);
			}
		};
	}

	@Override
	protected CustomerMacMapping addEntity(CustomerMacMapping entity) throws PortalException, SystemException {
		long customerMacId = CounterLocalServiceUtil.increment(CustomerMacMapping.class.getName());
		Date now = new Date();
		
		entity.setCustomerMacId(customerMacId);
		entity.setUserId(LiferayFacesContext.getInstance().getUserId());
		entity.setGroupId(LiferayFacesContext.getInstance().getScopeGroupId());
		entity.setCompanyId(LiferayFacesContext.getInstance().getCompanyId());
		entity.setCreateDate(now);
		entity.setModifiedDate(now);
		
		return CustomerMacMappingLocalServiceUtil.addCustomerMacMapping(entity);
	}

	@Override
	protected CustomerMacMapping updateEntity(CustomerMacMapping entity) throws PortalException, SystemException {
		Date now = new Date();
		entity.setModifiedDate(now);
		return CustomerMacMappingLocalServiceUtil.updateCustomerMacMapping(entity);
	}

	@Override
	protected void removeEntity(CustomerMacMapping entity) throws PortalException, SystemException {
		CustomerMacMappingLocalServiceUtil.deleteCustomerMacMapping(entity);
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		
		String fileName = event.getFile().getFileName();
		
		if (! fileName.endsWith(".xls")) {
			MessageUtil.addGlobalErrorMessage("only-support-xls-file");
			return;
		}
		
		try {
			CustomerMacMappingLocalServiceUtil.importAddressFromXls(event.getFile().getInputstream(), 0, 1, JsfUtil.getServiceContext(), removeAll);
			MessageUtil.addGlobalInfoMessage("import-succesful");
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
		
	}

	public boolean isRemoveAll() {
		return removeAll;
	}

	public void setRemoveAll(boolean removeAll) {
		this.removeAll = removeAll;
	}

}
