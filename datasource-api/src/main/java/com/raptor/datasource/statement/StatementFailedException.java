package com.raptor.datasource.statement;

public class StatementFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2973055884038962706L;
	
	private final String code;
	
	public StatementFailedException(String message) {
		super(message);
		
		this.code = "";
	}

	public StatementFailedException(String message, String code) {
		super(message);
		
		this.code = code;
	}
	
	public StatementFailedException(String message, Throwable cause, String code) {
		super(message, cause);
		
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

}
