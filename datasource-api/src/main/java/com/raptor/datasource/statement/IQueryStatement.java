package com.raptor.datasource.statement;

import com.rapotor.datasource.NodeNotCreatedException;
import com.rapotor.datasource.NodeNotFoundException;
import com.raptor.datasource.node.IDataSourceNode;
import com.raptor.datasource.query.QueryCriteria;

public interface IQueryStatement<E extends IDataSourceNode, C extends QueryCriteria> extends IStatement {
	E query(C criteria) throws NodeNotFoundException, NodeNotCreatedException;

}
