package com.rapotor.datasource;

public class DataSourceFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8814848368380887499L;
	
	public DataSourceFailureException(String message) {
		super(message);
	}
	
	public DataSourceFailureException(String message, Throwable cause) {
		super(message, cause);
	}

}
