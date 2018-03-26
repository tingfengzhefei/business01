package com.neusoft.service.impl;

import com.neusoft.dao.UserAddressDao;
import com.neusoft.dao.impl.UserAddressDaoImpl;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.service.addressService;

public class addressServiceIpml implements addressService {

	UserAddressDao userAddressDao=new UserAddressDaoImpl();
	
	@Override
	public int addAddress(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		return userAddressDao.addAddress(user_id, address);
		
		
	}

	@Override
	public int deleteAddressByUserid(Integer id, Integer user_id) {
		// TODO Auto-generated method stub
		return userAddressDao.deleteAddressByUserid(id,user_id);
	}

	@Override
	public int updateUserAddByUserid(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		return userAddressDao.updateUserAddByUserid(user_id,address);
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		return userAddressDao.findUserAddress(pageNo, pageSize, user_id);
	}

	@Override
	public Address findAll(Integer id) {
		// TODO Auto-generated method stub
		return userAddressDao.findAll(id);
	}

}
