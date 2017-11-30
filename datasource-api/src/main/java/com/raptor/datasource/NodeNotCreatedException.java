package com.raptor.datasource;

public class NodeNotCreatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8006262094748749326L;
	
	public NodeNotCreatedException(String message) {
		super(message);
	}
	
	public NodeNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

}
