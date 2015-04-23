package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.portlet.faces.preference.Preference;

import com.cmcti.cmts.portlet.util.MessageUtil;

@ManagedBean
@RequestScoped
public class PortletPreferencesBackingBean implements Serializable {

	/**
	 * serialVerionUID
	 */
	private static final long serialVersionUID = 3897755387155252973L;

	/**
	 * Resets/restores the values in portetPreferences.xhtlm Facelets
	 * composision with portlet preperence default values.
	 */
	public void reset() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
		PortletPreferences portletPreferences = portletRequest.getPreferences();

		try {
			Enumeration<String> preferenceNames = portletPreferences.getNames();

			// reset all value on portlet preperences.
			while (preferenceNames.hasMoreElements()) {
				String preferenceName = preferenceNames.nextElement();
				portletPreferences.reset(preferenceName);
			}

			// store portlet preferences.
			portletPreferences.store();

			// Switch the porlet mode back to view.
			Object response = externalContext.getResponse();
			if (response instanceof ActionResponse) {
				ActionResponse actionResponse = (ActionResponse) response;
				actionResponse.setPortletMode(PortletMode.VIEW);
				actionResponse.setWindowState(WindowState.NORMAL);
			}

			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);

		} catch (Exception e) {
			MessageUtil.addGlobalErrorMessage(MessageUtil.REQUEST_FAIL_MESSAGE);
		}
	}

	/**
	 * Saves the values in the portletPreferences.xhtml Facelet composition as
	 * portlet preferences.
	 */
	public void submit() {
		/**
		 * The JSR 329 specification defines an EL variable named
		 * mutablePortletPreferencesValues that is being used in the
		 * portletPreperences.xhtml Facelet composition. This object is of type
		 * Map<String, Prefecence> and is designed to be a model managed-bean
		 * (in a sense) that contain preference values. However the only way to
		 * access this from a Java class is to evaluate an EL expression
		 * (effectively self-injecting) the map into the backing bean.
		 */
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String elExpression = "mutablePortletPreferencesValues";
		ELResolver elResolver = facesContext.getApplication().getELResolver();

		@SuppressWarnings("unchecked")
		Map<String, Preference> mutablePerferenceMap = (Map<String, Preference>) elResolver.getValue(facesContext.getELContext(), null,
				elExpression);

		// Get list of portlet prefecence name.
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
		PortletPreferences portletPreferences = portletRequest.getPreferences();
		Enumeration<String> preferenceNames = portletPreferences.getNames();

		try {
			// For each portlet prefecence names:
			while (preferenceNames.hasMoreElements()) {
				String preferenceName = preferenceNames.nextElement();
				String prefecenceValue = mutablePerferenceMap.get(preferenceName).getValue();

				// Prepare to save values.
				if (!portletPreferences.isReadOnly(preferenceName)) {
					portletPreferences.setValue(preferenceName, prefecenceValue);
				}
			}

			// Saves the preference values.
			portletPreferences.store();

			// Switch the portlet back to VIEW.
			// Switch the porlet mode back to view.
			Object response = externalContext.getResponse();
			if (response instanceof ActionResponse) {
				ActionResponse actionResponse = (ActionResponse) response;
				actionResponse.setPortletMode(PortletMode.VIEW);
				actionResponse.setWindowState(WindowState.NORMAL);
			}

			// Report the successful message back to user as feedback.
			MessageUtil.addGlobalInfoMessage(MessageUtil.REQUEST_SUCCESS_MESSAGE);

		} catch (Exception e) {
			MessageUtil.addGlobalErrorMessage(MessageUtil.REQUEST_FAIL_MESSAGE);
		}
	}

}
