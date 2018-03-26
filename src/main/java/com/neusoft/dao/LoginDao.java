package com.neusoft.dao;

import com.neusoft.entity.User;

//登录

public interface LoginDao {
 //校验用户名是否存在
	public int checkUserName(String username); 
	
	//根据用户名和密码查询信息
	public User findUserByUsernameAndPasswrd(String username,String password);
	

	
	//更新用户cookie
	
	public int updateToken(Integer id,String token);
	//根据token查询用户信息
	
	 User  findUser(String token);
	
}
