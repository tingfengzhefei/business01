package com.neusoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.UserOrderItem;
import com.neusoft.entity.vo.OrderVo;

public interface userOrderService {

	
	//�û��µ�        request�л�ȡshipping_id  ���͵�ַ
	
	Order  createOrder(Integer user_id, HttpServletRequest request );
	
	
	
	//��ҳ��ѯ����
	
	PageModel<OrderVo>  findUserOrder(Integer user_id,  HttpServletRequest request);
	
	
	//3.��������ѯ   4.��������
	UserOrder findUserOrderItemByOrderNo(Long order_no );
	
	
	//5.��������  6.ȡ������
	 int updateOrderStatusByOrderNo(Long order_no,String status); 
	 
	 //7.��ȡ��������Ʒ��Ϣ
		List<UserOrderItem>  findUserOrderItemsByOrderNo(Long order_no);
	 
		
}
