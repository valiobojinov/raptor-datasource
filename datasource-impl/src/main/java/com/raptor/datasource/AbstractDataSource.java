package com.raptor.datasource;

import com.rapotor.datasource.IDataSource;
import com.raptor.datasource.initializer.IDataSourceInitializer;

public abstract class AbstractDataSource<I extends IDataSourceInitializer, N> implements IDataSource<N> {

	private final I initializer;

	public AbstractDataSource(I initializer) {

		this.initializer = initializer;
	}

	protected I getDataSourceInitializer() {
		return initializer;
	}
}
