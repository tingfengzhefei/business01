package com.neusoft.dao;

import com.neusoft.entity.User;

//��¼

public interface LoginDao {
 //У���û����Ƿ����
	public int checkUserName(String username); 
	
	//�����û����������ѯ��Ϣ
	public User findUserByUsernameAndPasswrd(String username,String password);
	

	
	//�����û�cookie
	
	public int updateToken(Integer id,String token);
	//����token��ѯ�û���Ϣ
	
	 User  findUser(String token);
	
}
