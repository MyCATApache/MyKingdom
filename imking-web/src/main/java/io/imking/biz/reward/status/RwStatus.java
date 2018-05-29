package io.imking.biz.reward.status;

public enum RwStatus {
	
	/**
	 * 创建完成
	 */
	ENABLE((byte)1),
	/**
	 * 创建过程中
	 */
	CREATING((byte)2);
	
	private byte status;

	private RwStatus(byte status) {
		this.status = status;
	}

	public byte getStatus() {
		return status;
	}
	
	
}
