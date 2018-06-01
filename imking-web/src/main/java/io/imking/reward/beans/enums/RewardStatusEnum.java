package io.imking.reward.beans.enums;


public enum RewardStatusEnum {

	INVALID((byte)-1,"已失效"),
	DARFT((byte)0,"草稿"),
	OPEN((byte)1,"开放中"),
	TENDER((byte)2,"招标中"),
	CROWDFUNDING((byte)3,"众筹中"),
	ANSWER((byte)4,"解答中"),
	ALLOTMENT_OF_MONEY((byte)5,"金额待分配"),
	COMFIRM_THE_AMOUNT((byte)6,"金额待确认"),
	VOTE((byte)7,"投票中"),
	DISPUTE((byte)8,"纠纷中"),
	REWARD((byte)9,"已打赏"),
	CLOSE((byte)10,"已关闭");

	private byte code;

	private String desc;


	RewardStatusEnum(byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}


	public byte getCode() {
		return code;
	}

	public void setCode(byte code) {
		this.code = code;
	}



	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
