package com.neusoft.consts;

//订单状态枚举类型
public enum paymentTypeEnum  {

	

     ONLINE(1,"在线支付"),
	OFFLINE(2,"货到付款");
	private int type;
	private String message;
	private paymentTypeEnum(int type, String message) {
		this.type = type;
		this.message = message;
	}
	private paymentTypeEnum() {
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
