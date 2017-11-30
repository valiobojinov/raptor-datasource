package com.raptor.datasource.neo4j;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;

import com.raptor.datasource.AbstractDataSource;
import com.raptor.datasource.initializer.DataSourceNotInitializedException;
import com.raptor.datasource.statement.StatementFailedException;
import com.raptor.datasource.statement.neo4j.AbstractExecutableCypherStatement;

 

public abstract class Neo4JDataSource<N> extends AbstractDataSource<Neo4JDataSourceInitializer, N>{

	private Driver driver;
	
	public Neo4JDataSource(Neo4JDataSourceInitializer initializer) {
		super(initializer);
	}
	

	@Override
	public synchronized void reset() throws DataSourceNotInitializedException {
		close();
		init();
	}

	@Override
	public synchronized void close() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

	@Override
	public boolean ready() {
		return driver != null;
	}

	
	@Override
	public synchronized void init() throws DataSourceNotInitializedException {
		driver = getDataSourceInitializer().getDriver();	
		createUniqueConstraints();
	}
	
	
	@Override
	protected Neo4JDataSourceInitializer getDataSourceInitializer() {		
		return (Neo4JDataSourceInitializer) super.getDataSourceInitializer();
	}	
	
	public Session newSession() {
		return driver.session();	
	}
	
	protected abstract void createUniqueConstraints();

	
	protected void execute (AbstractExecutableCypherStatement<String> statement, String id) throws StatementFailedException {
		statement.execute(id);
	}
	
	protected void execute (AbstractExecutableCypherStatement<N> statement, N entity) throws StatementFailedException {
		statement.execute(entity);
	}
	

	protected boolean isConflict(StatementFailedException e) {
		return Neo4JErrorCodes.CONSTRAINT_VALIDATION.equals(e.getCode());
	}
	
	protected boolean isEntityNotFound(StatementFailedException e) {
		return Neo4JErrorCodes.ENITY_NOT_FOUND.equals(e.getCode());
	}
}
