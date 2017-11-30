package com.raptor.datasource.statement;

import com.raptor.datasource.NodeNotCreatedException;
import com.raptor.datasource.NodeNotFoundException;
import com.raptor.datasource.node.IDataSourceNode;
import com.raptor.datasource.query.QueryCriteria;

public interface IQueryStatement<E extends IDataSourceNode, C extends QueryCriteria> extends IStatement {
	E query(C criteria) throws NodeNotFoundException, NodeNotCreatedException;

}
