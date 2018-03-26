package com.neusoft.service;

import com.neusoft.entity.User;

public interface ILoginService {

	public User login(String username ,String password);
	
	
	
	public int updateToken(Integer id,String token);



	 User  findUser(String token);
}
