package com.neusoft.entity;

import java.io.Serializable;
import java.sql.Date;

public class Cart implements Serializable {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -6580500903528388301L;
   private  int id;
   private  User user;
   private  Integer product_id;
   private  Integer quantity;
   private  Integer checked;
   private  Date create_time;
   private  Date update_time;
   
   
   
public Cart() {
	super();
}






public Cart(int id, User user, Integer product_id, Integer quantity, Integer checked, Date create_time,
		Date update_time) {
	super();
	this.id = id;
	this.user = user;
	this.product_id = product_id;
	this.quantity = quantity;
	this.checked = checked;
	this.create_time = create_time;
	this.update_time = update_time;
}






public int getId() {
	return id;
}






public void setId(int id) {
	this.id = id;
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






public Integer getQuantity() {
	return quantity;
}






public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}






public Integer getChecked() {
	return checked;
}






public void setChecked(Integer checked) {
	this.checked = checked;
}






public Date getCreate_time() {
	return create_time;
}






public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}






public Date getUpdate_time() {
	return update_time;
}






public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}






public static long getSerialversionuid() {
	return serialVersionUID;
}






@Override
public String toString() {
	return "Cart [id=" + id + ", user=" + user + ", product_id=" + product_id + ", quantity=" + quantity + ", checked="
			+ checked + ", create_time=" + create_time + ", update_time=" + update_time + "]";
}








   
   
   
}
