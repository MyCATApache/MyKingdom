package edu.ldcollege.util.status;

/**
 * 职位 1)普通 2)学委 3)班长
 * @author Raindrops on 2017 10 19
 */
public enum TBClassUserType {
	/**
	 * 学生
	 */
	NORMAL((byte)1),
	/**
	 * 学委
	 */
	COMMISSARY((byte)2),
	/**
	 * 班长
	 */
	MONITOR((byte)3);
	
	private byte value;
	
	private TBClassUserType(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}
}
