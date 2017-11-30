package com.raptor.datasource.statement;

public interface IExecuteStatement<E> extends IStatement{
	void execute(E entity) throws StatementFailedException;
}
