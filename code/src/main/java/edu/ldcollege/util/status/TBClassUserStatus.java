package edu.ldcollege.util.status;

/**
 * 状态 0)退班 1)正常 2)欠费
 * @author Raindrops on 2017 10 19
 */
public enum TBClassUserStatus {
	/**
	 * 退班
	 */
	QUIT((byte)0),
	/**
	 * 正常
	 */
	NORMAL((byte)1),
	/**
	 * 欠费
	 */
	ARREAR((byte)2);
	
	private byte value;
	
	private TBClassUserStatus(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}
}
