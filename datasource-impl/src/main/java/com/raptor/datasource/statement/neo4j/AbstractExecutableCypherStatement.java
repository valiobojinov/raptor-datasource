package com.raptor.datasource.statement.neo4j;

import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

import com.raptor.datasource.statement.IExecuteStatement;
import com.raptor.datasource.statement.StatementFailedException;

public abstract class AbstractExecutableCypherStatement<E> implements IExecuteStatement<E>{
	
	private final Session session;
	
	protected final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
		
	protected AbstractExecutableCypherStatement(Session session) {
		this.session = session;
	}
	
	protected abstract String prepareStatement(E entity);
	protected abstract void checkStatementResult(StatementResult result) throws StatementFailedException;
	
	@Override
	public void execute(E entity) throws StatementFailedException {
		String statement = prepareStatement(entity);
		Transaction tx = session.beginTransaction();
		StatementResult statementResult = tx.run(statement);
		try {
			checkStatementResult(statementResult);
			tx.success();
		} catch (StatementFailedException ex) {
			tx.failure();
			throw ex;
		} finally {
			tx.close();		
		}
	}
	
}
