package edu.ldcollege.util.status;

/**
 * 用户状态 0)不可用 1)可用
 * @author Raindrops on 20171018
 */
public enum TBUserStatus {
	
	/**
	 * 不可用
	 */
	DISABLT((byte)0),
	
	/**
	 * 可用
	 */
	ENABLE((byte)1);
	
	private byte value;
	
	private TBUserStatus(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}
	
}
