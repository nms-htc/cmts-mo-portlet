package com.cmcti.cmts.portlet.pf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.cmcti.cmts.portlet.search.Searcher;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractLazyDataModel<T extends BaseModel<T>> extends LazyDataModel<T> {

	// serialVersionUID
	private static final long serialVersionUID = -7706268392392499629L;
	private static final Logger _LOGGER = LoggerFactory.getLogger(AbstractLazyDataModel.class);

	protected Searcher searcher;

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public T getRowData(String rowKey) {
		try {
			return findById(Long.parseLong(rowKey));
		} catch (Exception e) {
			_LOGGER.error(e);
			return null;
		}
	}

	@Override
	public Object getRowKey(T object) {
		return object.getPrimaryKeyObj().toString();
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		DynamicQuery query;

		List<T> result = new ArrayList<T>();
		int count = 0;

		// process search
		if (searcher != null && searcher.getSearchQuery() != null) {
			query = searcher.getSearchQuery();
		} else {
			query = getDynamicQuery();
		}

		// process filter
		if (filters != null) {
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				if (entry.getValue() instanceof String) {
					query.add(RestrictionsFactoryUtil.ilike(entry.getKey(), entry.getValue() + "%"));
				} else {
					query.add(RestrictionsFactoryUtil.eq(entry.getKey(), entry.getValue()));
				}
				
			}
		}

		// process order
		if (sortField != null && !sortField.trim().isEmpty() && sortOrder != null) {
			Order order = null;
			switch (sortOrder) {
			case ASCENDING:
				order = OrderFactoryUtil.asc(sortField);
				break;
			case DESCENDING:
				order = OrderFactoryUtil.desc(sortField);
				break;
			default:
				break;
			}
			
			if (order != null) query.addOrder(order);
		}
		
		// process search
		try {
			result = query(query, first, first + pageSize - 1);
			count = count(query);
		} catch (Exception e) {
			_LOGGER.error(e);
		}

		setRowCount(count);
		return result;
	}

	protected abstract Class<T> getModelClass();
	protected abstract DynamicQuery getDynamicQuery();
	protected abstract List<T> query(DynamicQuery query,int start,int end) throws SystemException, PortalException;
	protected abstract int count(DynamicQuery query) throws SystemException, PortalException;
	protected abstract T findById(long id) throws SystemException, PortalException;
	
}
