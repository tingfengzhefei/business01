package com.neusoft.service;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public interface addressService {

	
	 //����ջ���ַ
		int addAddress(Integer user_id,Address address);
		//ɾ���û���Ϣ
		int deleteAddressByUserid(Integer id,Integer user_id);
		//�û��޸��ջ���ַ
		
		public Address  findAll(Integer id);
		
		
		int updateUserAddByUserid(Integer user_id,Address address);
		//��ѯ�û���ַ����ҳ��ѯ
		PageModel<Address>  findUserAddress(Integer pageNo,Integer pageSize,Integer user_id);
		
}
