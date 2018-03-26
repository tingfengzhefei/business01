package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.UserOrderItem;

public interface UserOrderItemDao {

	
	//批量添加
	
	int addUserOrderItem(List<UserOrderItem> list);
	
	//7.获取订单的商品信息
	
	
	List<UserOrderItem>  findUserOrderItemsByOrderNo(Long order_no);
	
	
}
