package com.rapotor.datasource;

public class NodeAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -717238406158008715L;
	
	public NodeAlreadyExistsException(String message) {
		super(message);
	}
	
	public NodeAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
