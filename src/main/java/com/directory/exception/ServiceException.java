package com.directory.exception;

/**
 * @author R_Legend
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491028348870088493L;
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public ServiceException() {
		super();
	}
}
