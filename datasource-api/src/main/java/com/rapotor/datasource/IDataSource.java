package com.rapotor.datasource;

import java.util.Optional;

import com.raptor.datasource.initializer.DataSourceNotInitializedException;
import com.raptor.datasource.query.QueryCriteria;

public interface IDataSource<N> {
	Optional<N> find(QueryCriteria criteria) throws DataSourceFailureException;
	void create(N policy) throws DataSourceFailureException, NodeAlreadyExistsException;
	void delete(String nodeId, String type) throws DataSourceFailureException, NodeNotFoundException;
	void init() throws DataSourceNotInitializedException;
	void reset() throws DataSourceNotInitializedException;
	void close();
	boolean ready();
}
