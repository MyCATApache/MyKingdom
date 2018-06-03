package io.imking.reward.beans.enums;
@SuppressWarnings("all")
/**
 * 
 * @author 天道
 *
 */
public enum CommentTypeEnum {
	ANSWER((byte) 0, "回答评论"), 
	QUESTION((byte) 1, "提问评论"), 
	GENERAL((byte) 2, "普通评论");
	
	private byte code;
	private String desc;

	CommentTypeEnum(byte code, String desc) {
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


	public static CommentTypeEnum match(String name, CommentTypeEnum defaultItem) {
	      if (name != null) {
	          for (CommentTypeEnum item:CommentTypeEnum.values()) {
	        	  System.out.println(item.name());
	               if (item.name().equalsIgnoreCase(name)) {
	                  return item;
	              }
	          }
	      }
	      return defaultItem;
	  }
}
