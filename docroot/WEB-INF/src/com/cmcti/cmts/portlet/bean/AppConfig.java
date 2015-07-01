package com.cmcti.cmts.portlet.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

@ManagedBean
@ApplicationScoped
public class AppConfig implements Serializable {

	private static final long serialVersionUID = -723457091278344374L;
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	private Map<String, String> options;
	
	@PostConstruct
	public void init() {
		options = new HashMap<>();
	}
	
	public void reset() {
		options = null;
		init();
	}
	
	public String getStringConfig(String key) {
		String option = null;
		try {
			option = options.get(key);
		} catch (Exception e) {
			logger.error(e);
		}
		return option;
	}
	
	public String getStringConfig(String key, String defaultValue) {
		String value = getStringConfig(key);
		if (value == null || value.trim().isEmpty()) {
			value = defaultValue;
		}
		return value;
	}
	
	public double getDoubleConfig(String key) {
		double option = 0;
		try {
			option = Double.parseDouble(options.get(key));
		} catch (Exception e) {
			logger.error(e);
		}
		return option;
	}
	
	public double getDoubleConfig(String key, double defaultValue) {
		double value= getDoubleConfig(key);
		if (value == 0) {
			value = defaultValue;
		}
		return value;
	}
	
	public long getLongConfig(String key) {
		long option = 0;
		try {
			option = Long.parseLong(options.get(key));
		} catch (Exception e) {
			logger.error(e);
		}
		return option;
	}
	
	public long getLongConfig(String key, long defaultValue) {
		long value = getLongConfig(key);
		if (value == 0) {
			value = defaultValue;
		}
		return defaultValue;
	}
	
	public int getIntegerConfig(String key) {
		int option = 0;
		try {
			option = Integer.parseInt(options.get(key));
		} catch (Exception e) {
			logger.error(e);
		}
		return option;
	}
	 
	public int getIntegerConfig(String key, int defaultValue) {
		int value = getIntegerConfig(key);
		if (value == 0) {
			value = defaultValue;
		}
		return value;
	}
	
	public Date getDateConfig(String key, String pattern) {
		Date option = null;
		try {
			DateFormat f = new SimpleDateFormat(pattern);
			option = f.parse(options.get(key));
		} catch (Exception e) {
			logger.error(e);
		}
		return option;
	}
	
	public Date getDateConfig(String key, String pattern, Date defaultValue) {
		Date value = getDateConfig(key, pattern);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}
}
