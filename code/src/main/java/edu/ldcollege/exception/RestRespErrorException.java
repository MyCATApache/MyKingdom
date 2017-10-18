package edu.ldcollege.exception;

import edu.ldcollege.util.RestStatus;

/**
 * rest业务错误
 * @author Raindrops on 20171018
 */
public class RestRespErrorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected RestStatus status;

	public RestRespErrorException(RestStatus status) {
		this.status = status;
	}
	
	public RestStatus getRestStatus() {
		return this.status;
	}
	
	public int getStatus() {
		return status.getCode();
	}

	public String getMsg() {
		return status.getMessage();
	}
	
	public void setStatus(RestStatus status) {
		this.status = status;
	}
	
}
