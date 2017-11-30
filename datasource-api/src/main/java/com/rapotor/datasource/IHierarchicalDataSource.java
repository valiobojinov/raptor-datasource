package com.rapotor.datasource;

import java.util.List;

import com.raptor.datasource.query.QueryCriteria;

public interface IHierarchicalDataSource<N> extends IDataSource<N> {
	
	List<N> findSiblingEntities(QueryCriteria criteria) throws DataSourceFailureException;
	void createConnection(String fromNodeId, String fromNodeType, String toNodeId, String connectionType) throws DataSourceFailureException, NodeAlreadyExistsException;
	void createSibling(N entity, String fromNodeId, String fromNodeType)
			throws DataSourceFailureException, NodeAlreadyExistsException;
	void delete(String entityId, String type, boolean cascade) throws DataSourceFailureException, NodeNotFoundException;

}
