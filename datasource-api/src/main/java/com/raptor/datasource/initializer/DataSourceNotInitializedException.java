package com.raptor.datasource.initializer;

public class DataSourceNotInitializedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8684750680519351040L;
	
	public DataSourceNotInitializedException(String message) {
		super(message);
	}
	
	public DataSourceNotInitializedException(String message, Throwable cause) {
		super(message, cause);
	}

}
