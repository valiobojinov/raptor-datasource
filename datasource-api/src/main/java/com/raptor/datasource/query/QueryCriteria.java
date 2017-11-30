package com.raptor.datasource.query;

import java.util.HashMap;
import java.util.Map;


public class QueryCriteria {
	
	

	public QueryCriteria() {

	}


	private boolean queryForSiblingEntities;

	private final Map<String, String> criteria = new HashMap<String, String>();

	

	public void addCriteria(String attribute, String value) {
		criteria.put(attribute, value);
	}

	public Map<String, String> getCriteria() {
		return criteria;
	}

	public boolean hasCriteria() {
		return criteria.size() > 0;
	}

	public boolean isQuerySiblingEntities() {
		return queryForSiblingEntities;
	}
	
	
	public void setQueryForSiblingEntities(boolean queryForSiblingEntities) {
		this.queryForSiblingEntities = queryForSiblingEntities;
	}
	
	public void setQueryForSiblingEntities() {
		setQueryForSiblingEntities(true);
	}
}
