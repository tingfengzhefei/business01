package com.neusoft.service;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public interface addressService {

	
	 //添加收货地址
		int addAddress(Integer user_id,Address address);
		//删除用户信息
		int deleteAddressByUserid(Integer id,Integer user_id);
		//用户修改收货地址
		
		public Address  findAll(Integer id);
		
		
		int updateUserAddByUserid(Integer user_id,Address address);
		//查询用户地址，分页查询
		PageModel<Address>  findUserAddress(Integer pageNo,Integer pageSize,Integer user_id);
		
}
