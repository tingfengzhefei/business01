package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;

public interface UserOrderDao {

	//1.将订单添加到数据库       添加订单
	
	int  addOrder(UserOrder userOrder);
	
	//2.订单list
	
	
	PageModel<UserOrder>  findUserOrder(Integer user_id, Integer pageNo, Integer pageSize);
	
	
	//3.按订单查询   4.订单详情
       
	
	UserOrder findUserOrderItemByOrderNo(Long order_no);
	
	
	
	
	
	//5.订单发货		 6.取消订单(未付款)	
	
	int updateOrderStatusByOrderNo(Long order_no ,String status);
	
	
	
	//7.获取订单的商品信息（订单明细中)
	
	
}





