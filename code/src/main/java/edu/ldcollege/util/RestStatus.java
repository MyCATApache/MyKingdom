package edu.ldcollege.util;


/**
 * @author Raindrops on 20171018
 */
public enum RestStatus {

	SUCCEED(200,"请求成功"),
	ERROR_SERVER(500,"服务器错误"),
	
	//1XXX 用户错误
	ERROR_USER_DISABLE(2001,"用户被封禁"),
	ERROR_USER_Authorization(2002,"验证失败,检查账号/密码是否正确");
	
	private int code;
	
	private String message;

	private RestStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
