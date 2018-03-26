package com.neusoft.entity.vo;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.neusoft.consts.OrderStatus;
import com.neusoft.consts.paymentTypeEnum;
import com.neusoft.entity.Address;
import com.neusoft.entity.User;
import com.neusoft.entity.UserOrder;

public class OrderVo  {

	private Integer  id ;//'订单id'
	private long   order_no ;//'唯一约束 订单号'
	private Integer user_id;
	private User  user;//'用户id'
	private String shipping_id;
	private Address address ;// '地址id'
	private String  payment;//'实际付款金额,单位元,保留两位小数'
	private String payment_type ;//'支付类型 1-在线支付 2-货到付款'
	private Integer postage ;// '运费,单位元'
	private String  status;//'订单状态  0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭'
	private String payment_time ;// '支付时间'
	private String send_time ;//'发货时间'
	private String end_time ;//'交易完成时间'
	private String close_time ;//'交易关闭时间'
	private String create_time;//'创建时间'
	private String  update_time;//'更新时间'
	



	
	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public long getOrder_no() {
		return order_no;
	}





	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}










	public Integer getUser_id() {
		return user_id;
	}





	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}









	public String getShipping_id() {
		return shipping_id;
	}





	public void setShipping_id(String shipping_id) {
		this.shipping_id = shipping_id;
	}





	public Address getAddress() {
		return address;
	}





	public void setAddress(Address address) {
		this.address = address;
	}





	public String getPayment() {
		return payment;
	}





	public void setPayment(String payment) {
		this.payment = payment;
	}





	public String getPayment_type() {
		return payment_type;
	}





	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}





	public Integer getPostage() {
		return postage;
	}





	public void setPostage(Integer postage) {
		this.postage = postage;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public String getPayment_time() {
		return payment_time;
	}





	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}





	public String getSend_time() {
		return send_time;
	}





	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}





	public String getEnd_time() {
		return end_time;
	}





	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}





	public String getClose_time() {
		return close_time;
	}





	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}





	public String getCreate_time() {
		return create_time;
	}





	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}





	public String getUpdate_time() {
		return update_time;
	}





	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}





	//将Userorder--> OrderVo
	public  void convertUserOrderToOrderVo(UserOrder userOrder) {
		this.id=userOrder.getId();
		this.order_no=userOrder.getOrder_no();
		this.payment=userOrder.getPayment().toString();
		
		Integer paymenttype=userOrder.getPayment_type();
		if(paymenttype==paymentTypeEnum.ONLINE.getType()) {
			this.payment_type="在线支付";
		}else if(paymenttype==paymentTypeEnum.OFFLINE.getType()){
			this.payment_type="货到付款";
			
		}
		
		this.postage=userOrder.getPostage();
		Integer status=userOrder.getStatus();
		
		
		if(status==OrderStatus.CANCEL.getStatus()) {
			this.status="已取消";	
		}else if(status==OrderStatus.UNPAY.getStatus()) {
			this.status="未付款";	
		}else if(status==OrderStatus.PAY.getStatus()) {
			this.status="已付款";	
		}else if(status==OrderStatus.SEND.getStatus()) {
			this.status="已发货";	
		}else if(status==OrderStatus.SUCC.getStatus()) {
			this.status="交易成功";	
		}else if(status==OrderStatus.CLOSE.getStatus()) {
			this.status="交易关闭";	
		}
		
		
		Date create_time= userOrder.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		this.create_time=format.format(create_time.getTime());
		this.update_time=format.format(userOrder.getUpdate_time().getTime());
		
		
		this.user=userOrder.getUser();
		
		this.address=userOrder.getAddress();
		
		
		
	}
	
	
	
}
