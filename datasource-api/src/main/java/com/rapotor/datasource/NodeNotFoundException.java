package com.rapotor.datasource;

public class NodeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8098152565393740736L;

	public NodeNotFoundException(String message) {
		super(message);
	}
	
	public NodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
