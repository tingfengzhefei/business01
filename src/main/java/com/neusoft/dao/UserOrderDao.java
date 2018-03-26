package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;

public interface UserOrderDao {

	//1.��������ӵ����ݿ�       ��Ӷ���
	
	int  addOrder(UserOrder userOrder);
	
	//2.����list
	
	
	PageModel<UserOrder>  findUserOrder(Integer user_id, Integer pageNo, Integer pageSize);
	
	
	//3.��������ѯ   4.��������
       
	
	UserOrder findUserOrderItemByOrderNo(Long order_no);
	
	
	
	
	
	//5.��������		 6.ȡ������(δ����)	
	
	int updateOrderStatusByOrderNo(Long order_no ,String status);
	
	
	
	//7.��ȡ��������Ʒ��Ϣ��������ϸ��)
	
	
}





