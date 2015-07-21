package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.domain.model.UpChannelMetadata;
import com.cmcti.cmts.domain.model.UpstreamChannel;
import com.cmcti.cmts.domain.service.UpChannelMetadataLocalServiceUtil;
import com.cmcti.cmts.domain.service.UpstreamChannelLocalServiceUtil;
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
public class UpChannelMetadataBean extends AbstractCRUDBean<UpChannelMetadata> implements Serializable{

	private static final long serialVersionUID = 5928265017319392991L;
	private static final Logger logger = LoggerFactory.getLogger(UpChannelMetadataBean.class);
	
	private SelectItem[] upstreamItems;
	
	public void changeCmts(ValueChangeEvent event) {
		long cmtsId = GetterUtil.getLong(event.getNewValue(), 0);
		upstreamItems = getUpstreamItemFormCmts(cmtsId);
	}
	
	private SelectItem[] getUpstreamItemFormCmts(long cmtsId) {
		try {
			List<UpstreamChannel> ups = UpstreamChannelLocalServiceUtil.fetchByCmtsId(cmtsId);
			if (ups != null && ups.size() > 0) {
				SelectItem[] items = new SelectItem[ups.size()];
				for (int i = 0; i < ups.size(); i++) {
					items[i] = new SelectItem(ups.get(i).getIfIndex(), ups.get(i).getIfDesc() + "-" + ups.get(i).getIfAlias());					
				}
				return items;
			}
			return null;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	protected UpChannelMetadata initEntity() {
		return UpChannelMetadataLocalServiceUtil.createUpChannelMetadata(0);
	}

	@Override
	protected LazyDataModel<UpChannelMetadata> initDataModel() {
		AbstractLazyDataModel<UpChannelMetadata> model = new AbstractLazyDataModel<UpChannelMetadata>() {
			private static final long serialVersionUID = -189994789330616691L;

			@Override
			protected Class<UpChannelMetadata> getModelClass() {
				return UpChannelMetadata.class;
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return UpChannelMetadataLocalServiceUtil.dynamicQuery();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected List<UpChannelMetadata> query(DynamicQuery query, int start, int end) throws SystemException, PortalException {
				if (start >= 0 && end >= start) {
					return UpChannelMetadataLocalServiceUtil.dynamicQuery(query, start, end);
				} else {
					return UpChannelMetadataLocalServiceUtil.dynamicQuery(query);
				}
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException, PortalException {
				return Long.valueOf(UpChannelMetadataLocalServiceUtil.dynamicQueryCount(query)).intValue();
			}

			@Override
			protected UpChannelMetadata findById(long id) throws SystemException, PortalException {
				return UpChannelMetadataLocalServiceUtil.fetchUpChannelMetadata(id);
			}
			
		};
		return model;
	}

	@Override
	protected UpChannelMetadata addEntity(UpChannelMetadata entity) throws PortalException, SystemException {
		return UpChannelMetadataLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected UpChannelMetadata updateEntity(UpChannelMetadata entity) throws PortalException, SystemException {
		return UpChannelMetadataLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(UpChannelMetadata entity) throws PortalException, SystemException {
		UpChannelMetadataLocalServiceUtil.deleteUpChannelMetadata(entity);
	}
	
	public UpChannelMetadata getUpChannelMetadata(String cmtsIfIndex) {
		UpChannelMetadata upMeta = null;
		if (cmtsIfIndex != null && !cmtsIfIndex.trim().isEmpty()) {
			String[] ids = cmtsIfIndex.split("-");
			long cmtsId = GetterUtil.getLong(ids[0], 0);
			int ifIndex = GetterUtil.getInteger(ids[1], 0);
			if (cmtsId > 0 && ifIndex > 0) {
				try {
					upMeta = UpChannelMetadataLocalServiceUtil.findByCmtsAndIfIndex(cmtsId, ifIndex);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return upMeta;
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		String fileName = event.getFile().getFileName();
		
		if (! fileName.endsWith(".xls")) {
			MessageUtil.addGlobalErrorMessage("only-support-xls-file");
			return;
		}
		
		try {
			UpChannelMetadataLocalServiceUtil.importAddressFromXls(event.getFile().getInputstream(), 0, 1, JsfUtil.getServiceContext());
			MessageUtil.addGlobalInfoMessage("import-succesful");
		} catch (Exception e) {
			logger.error(e);
			MessageUtil.addGlobalErrorMessage(e);
		}
	}

	public SelectItem[] getUpstreamItems() {
		if (this.current != null && this.current.getCmtsId() > 0) {
			upstreamItems = getUpstreamItemFormCmts(this.current.getCmtsId());
		}
		return upstreamItems;
	}

	public void setUpstreamItems(SelectItem[] upstreamItems) {
		this.upstreamItems = upstreamItems;
	}
	
	public UpChannelMetadata getByUpstream(UpstreamChannel upstream) {
		UpChannelMetadata meta = null;
		try {
			long cmtsId = upstream.getCmtsId();
			int ifIndex = upstream.getIfIndex();
			meta = UpChannelMetadataLocalServiceUtil.findByCmtsAndIfIndex(cmtsId, ifIndex);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (meta == null) {
				meta = UpChannelMetadataLocalServiceUtil.createUpChannelMetadata(0);
			}
		}
		return meta;
	}

}
