package com.neusoft.entity.vo;

import com.neusoft.entity.User;

public class OrderItemVo {

	
	private Integer orderitem_id ;
	private Long order_no ;// '�����ţ�����',
	private Integer user_id ;//'�û�id',
	private User user;
	private Integer product_id  ;//'��Ʒid',
	private String product_name  ;//'��Ʒ����',
	private String product_image ;//'��ƷͼƬ',
	private String current_unit_price ;//'���ɶ���ʱ����Ʒ����λ Ԫ',
	private String payment;//'ʵ��֧�����',
	private Integer quantity ;//'��Ʒ����',
	private String total_price ;//'��Ʒ�ܼ�',
	private String create_time ;
	private String update_time;
	public Integer getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(Integer orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
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
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(String current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
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
	
	
	
}
