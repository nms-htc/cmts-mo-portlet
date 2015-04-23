package com.cmcti.cmts.portlet.url;

import java.util.Map;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.GetterUtil;

public class MyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String buildPath(LiferayPortletURL liferayPortletURL) {
		String popup = GetterUtil.getString(liferayPortletURL.getParameter("_popup"));

		if (popup != null) {
			liferayPortletURL.addParameterIncludedInPath("p_p_state");

			return "/" + getMapping() + "/popup";
		}

		return null;
	}

	@Override
	public void populateParams(String friendlyURLPath, Map<String, String[]> parameterMap, Map<String, Object> requestContext) {
		String[] s = friendlyURLPath.split("/");

		if (s[2].equals("popup")) {
			parameterMap.put("p_p_state", new String[] { LiferayWindowState.POP_UP.toString() });
		}
	}

}
