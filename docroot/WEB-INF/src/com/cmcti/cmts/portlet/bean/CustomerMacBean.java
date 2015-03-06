package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.CustomerMacMapping;
import com.cmcti.cmts.domain.service.CustomerMacMappingLocalServiceUtil;
import com.cmcti.cmts.domain.service.persistence.CustomerMacMappingUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CustomerMacBean extends AbstractCRUDBean<CustomerMacMapping> implements Serializable{

	// serialVersionUID
	private static final long serialVersionUID = 8049919349164930939L;

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

}
