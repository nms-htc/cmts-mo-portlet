package com.cmcti.cmts.portlet.search;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;

@ManagedBean
@ViewScoped
public class CableModemSearcher implements Searcher, Serializable{

	// serialVersionUID
	private static final long serialVersionUID = 4662398953120024302L;
	

	@Override
	public DynamicQuery getSearchQuery() {
		return null;
	}

}
