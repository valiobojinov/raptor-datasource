package com.rapotor.datasource;

public interface IRelationalDataSource<N, R>  {
	R findRelatedNodes(IDataSource<N> dataSource);
}
