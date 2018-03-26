package com.neusoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.UserOrderItem;
import com.neusoft.entity.vo.OrderVo;

public interface userOrderService {

	
	//用户下单        request中获取shipping_id  配送地址
	
	Order  createOrder(Integer user_id, HttpServletRequest request );
	
	
	
	//分页查询订单
	
	PageModel<OrderVo>  findUserOrder(Integer user_id,  HttpServletRequest request);
	
	
	//3.按订单查询   4.订单详情
	UserOrder findUserOrderItemByOrderNo(Long order_no );
	
	
	//5.订单发货  6.取消订单
	 int updateOrderStatusByOrderNo(Long order_no,String status); 
	 
	 //7.获取订单的商品信息
		List<UserOrderItem>  findUserOrderItemsByOrderNo(Long order_no);
	 
		
}
