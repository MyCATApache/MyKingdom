package edu.ldcollege.exception;

import edu.ldcollege.util.RestStatus;

public class NullParamException extends RestRespErrorException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullParamException(String message) {
		RestStatus status = RestStatus.NULL_PARAM;
		status.setMessage(message + "参数不能为空");
		this.status = status;
	}
	
}
