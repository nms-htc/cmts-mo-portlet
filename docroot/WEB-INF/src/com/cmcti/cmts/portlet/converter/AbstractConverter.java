package com.cmcti.cmts.portlet.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.cmcti.cmts.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractConverter<T extends BaseModel<T>> implements Converter {

	private static final Logger _LOGGER = LoggerFactory.getLogger(AbstractConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		if (JsfUtil.isDummySelectItem(component, value)) {
			return null;
		}
		try {
			return find(value);
		} catch (SystemException | PortalException e) {
			_LOGGER.error(e);
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		if (value.getClass().equals(getModelClass())) {
			@SuppressWarnings("unchecked")
			T entity = (T) value;
			return entity.getPrimaryKeyObj().toString();
		} else {
			throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: "
					+ getModelClass().getName());
		}
	}

	protected abstract T find(String value) throws SystemException, PortalException;
	protected abstract Class<T> getModelClass();

}
