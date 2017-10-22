package edu.ldcollege.util;

/**
 * 
 * @author Raindrops on 20171018
 *
 */
public class RestResult {
	
	/**
	 * 状态码
	 */
	private int status;
	
	/**
	 * 数据
	 */
	private Object data;
	
	/**
	 * 信息
	 */
	private String message;

	
	public RestResult(RestStatus status, Object data) {
		super();
		this.status = status.getCode();
		this.data = data;
		this.message = status.getMessage();
	}

	public static RestResult success(Object data) {
		return new RestResult(RestStatus.SUCCEED,data);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
