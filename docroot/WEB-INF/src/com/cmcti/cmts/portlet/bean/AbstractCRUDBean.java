package com.cmcti.cmts.portlet.bean;

import org.primefaces.model.LazyDataModel;

import com.cmcti.cmts.portlet.util.JsfUtil;
import com.cmcti.cmts.portlet.util.MessageUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractCRUDBean<T extends BaseModel<T>> {
	
	/**
	 * Logger
	 */
	private static final Logger _LOGGER = LoggerFactory.getLogger(AbstractCRUDBean.class);
	
	/**
	 *  Current entity to process
	 */
	protected T current;
	/**
	 * lazyDataModel for primefaces lazy datatable
	 */
	protected LazyDataModel<T> lazyDataModel;
	
	
	// Bussiness method
	
	protected void afterPersist() {}
	
	protected void beforePersist() {}
	
	public void persist() {
		try {
			beforePersist();
			addEntity(current);
			current = null;
			afterPersist();
			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e, MessageUtil.REQUEST_FAIL_MESSAGE);
		}
	}
	
	protected void afterUpdate() {}
	
	protected void beforeUpdate() {}
	
	public void update() {
		try {
			beforeUpdate();
			current = updateEntity(current);
			afterUpdate();
			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e, MessageUtil.REQUEST_FAIL_MESSAGE);
		}
	}
	
	protected void afterRemove(T entity) {}
	
	protected void beforeRemove(T entity) {}
	
	public void remove(T entity) {
		try {
			beforeRemove(entity);
			removeEntity(entity);
			afterRemove(entity);
			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e, MessageUtil.REQUEST_FAIL_MESSAGE);
		}
	}
	
	// Getters and Setters
	
	public T getCurrent() {
		if (current == null) {
			current = initEntity();
		}
		return current;
	}
	
	public void setCurrent(T current) {
		this.current = current;
	}
	
	public LazyDataModel<T> getLazyDataModel() {
		if (lazyDataModel == null) {
			lazyDataModel = initDataModel();
		}
		return lazyDataModel;
	}
	
	public void setLazyDataModel(LazyDataModel<T> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}
	
	protected abstract T initEntity();
	protected abstract LazyDataModel<T> initDataModel();
	protected abstract T addEntity(T entity) throws PortalException, SystemException;
	protected abstract T updateEntity(T entity) throws PortalException, SystemException;
	protected abstract void removeEntity(T entity) throws PortalException, SystemException;
	
}
