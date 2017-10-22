package edu.ldcollege.domain;

/**
 * 班级用户信息
 * @author Raindrops on 2017 10 19
 */
public class ClassUserInfo {
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 职位 1)普通 2)学委 3)班长
	 */
	private Byte usertype;
	
	/**
	 * 状态 0)退班 1)正常 2)欠费
	 */
	private Byte userstatus;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Byte getUsertype() {
		return usertype;
	}

	public void setUsertype(Byte usertype) {
		this.usertype = usertype;
	}

	public Byte getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(Byte userstatus) {
		this.userstatus = userstatus;
	}
	
	
}
