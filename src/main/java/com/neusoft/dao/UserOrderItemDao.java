package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.UserOrderItem;

public interface UserOrderItemDao {

	
	//�������
	
	int addUserOrderItem(List<UserOrderItem> list);
	
	//7.��ȡ��������Ʒ��Ϣ
	
	
	List<UserOrderItem>  findUserOrderItemsByOrderNo(Long order_no);
	
	
}
