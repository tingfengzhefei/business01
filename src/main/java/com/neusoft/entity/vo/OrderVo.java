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

	private Integer  id ;//'����id'
	private long   order_no ;//'ΨһԼ�� ������'
	private Integer user_id;
	private User  user;//'�û�id'
	private String shipping_id;
	private Address address ;// '��ַid'
	private String  payment;//'ʵ�ʸ�����,��λԪ,������λС��'
	private String payment_type ;//'֧������ 1-����֧�� 2-��������'
	private Integer postage ;// '�˷�,��λԪ'
	private String  status;//'����״̬  0-��ȡ�� 10-δ���� 20-�Ѹ��� 40-�ѷ��� 50-���׳ɹ� 60-���׹ر�'
	private String payment_time ;// '֧��ʱ��'
	private String send_time ;//'����ʱ��'
	private String end_time ;//'�������ʱ��'
	private String close_time ;//'���׹ر�ʱ��'
	private String create_time;//'����ʱ��'
	private String  update_time;//'����ʱ��'
	



	
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





	//��Userorder--> OrderVo
	public  void convertUserOrderToOrderVo(UserOrder userOrder) {
		this.id=userOrder.getId();
		this.order_no=userOrder.getOrder_no();
		this.payment=userOrder.getPayment().toString();
		
		Integer paymenttype=userOrder.getPayment_type();
		if(paymenttype==paymentTypeEnum.ONLINE.getType()) {
			this.payment_type="����֧��";
		}else if(paymenttype==paymentTypeEnum.OFFLINE.getType()){
			this.payment_type="��������";
			
		}
		
		this.postage=userOrder.getPostage();
		Integer status=userOrder.getStatus();
		
		
		if(status==OrderStatus.CANCEL.getStatus()) {
			this.status="��ȡ��";	
		}else if(status==OrderStatus.UNPAY.getStatus()) {
			this.status="δ����";	
		}else if(status==OrderStatus.PAY.getStatus()) {
			this.status="�Ѹ���";	
		}else if(status==OrderStatus.SEND.getStatus()) {
			this.status="�ѷ���";	
		}else if(status==OrderStatus.SUCC.getStatus()) {
			this.status="���׳ɹ�";	
		}else if(status==OrderStatus.CLOSE.getStatus()) {
			this.status="���׹ر�";	
		}
		
		
		Date create_time= userOrder.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		this.create_time=format.format(create_time.getTime());
		this.update_time=format.format(userOrder.getUpdate_time().getTime());
		
		
		this.user=userOrder.getUser();
		
		this.address=userOrder.getAddress();
		
		
		
	}
	
	
	
}
