package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.Merchant;
import com.cmcti.cmts.domain.service.MerchantLocalServiceUtil;
import com.cmcti.cmts.domain.service.MerchantScopeLocalServiceUtil;
import com.cmcti.cmts.portlet.pf.AbstractLazyDataModel;
import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

@ManagedBean
@ViewScoped
public class MerchantBean extends AbstractCRUDBean<Merchant> implements Serializable {

	private static final long serialVersionUID = -64802926532356890L;
	private static final Logger logger = LoggerFactory.getLogger(MerchantBean.class);
	
	private SelectItem[] selectItems;
	
	private boolean removeAll;

	@Override
	protected Merchant initEntity() {
		return MerchantLocalServiceUtil.createMerchant(0);
	}

	@Override
	protected LazyDataModel<Merchant> initDataModel() {
		return new AbstractLazyDataModel<Merchant>() {
			private static final long serialVersionUID = -785177562554405313L;

			@Override
			protected Class<Merchant> getModelClass() {
				return Merchant.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return MerchantLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<Merchant> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start > 0 && end >= start) {
					return MerchantLocalServiceUtil.dynamicQuery(query, start, end);
				} else {
					return MerchantLocalServiceUtil.dynamicQuery(query);
				}
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(MerchantLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected Merchant findById(long id) throws SystemException, PortalException {
				return MerchantLocalServiceUtil.getMerchant(id);
			}
		};
	}

	@Override
	protected Merchant addEntity(Merchant entity) throws PortalException, SystemException {
		return MerchantLocalServiceUtil.updateMerchant(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected Merchant updateEntity(Merchant entity) throws PortalException, SystemException {
		return MerchantLocalServiceUtil.updateMerchant(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(Merchant entity) throws PortalException, SystemException {
		MerchantLocalServiceUtil.deleteMerchant(entity);
	}

	public void handleFileUpload(FileUploadEvent event) {

		String fileName = event.getFile().getFileName();

		if (!fileName.endsWith(".xls")) {
			MessageUtil.addGlobalErrorMessage("only-support-xls-file");
			return;
		}

		try {
			MerchantLocalServiceUtil.importMerchant(event.getFile().getInputstream(), 0, 1, JsfUtil.getServiceContext(), removeAll);
			MessageUtil.addGlobalInfoMessage("import-succesful");
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}

	}
	
	public SelectItem[] getSelectItems() {
		if (selectItems == null) {
			try {
				List<Merchant> merchants = MerchantLocalServiceUtil.getMerchants(-1, -1);
				selectItems = new SelectItem[merchants.size()];
				for (int i = 0; i < merchants.size(); i++) {
					selectItems[i] = new SelectItem(merchants.get(i).getCode(), merchants.get(i).getTitle());
				}
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return selectItems;
	}
	
	public String getMerchatTitles(String params) {
		String[] args = params.split("-");
		long cmtsId = GetterUtil.getLong(args[0]);
		int ifIndex = GetterUtil.getInteger(args[1]);
		
		StringBuilder sb = new StringBuilder();
		
		List<Merchant> merchants = new ArrayList<Merchant>();
		try {
			merchants = MerchantScopeLocalServiceUtil.findByUpstream(cmtsId, ifIndex);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < merchants.size(); i++) {
			Merchant merchant = merchants.get(i);
				if (merchant != null) {
				sb.append(merchant.getTitle());
				if (i < merchants.size() - 1) sb.append(", ");
			}
		}
		
		return sb.toString();
	}
	
	public boolean isRemoveAll() {
		return removeAll;
	}


	public void setRemoveAll(boolean removeAll) {
		this.removeAll = removeAll;
	}

}