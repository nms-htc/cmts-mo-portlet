package com.cmcti.cmts.portlet.search;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;

public interface Searcher {
	public DynamicQuery getSearchQuery();
}
