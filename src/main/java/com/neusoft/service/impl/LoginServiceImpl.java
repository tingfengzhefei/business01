package com.neusoft.service.impl;

import com.neusoft.dao.LoginDao;
import com.neusoft.dao.impl.LoginDaoImpl;
import com.neusoft.entity.User;
import com.neusoft.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		//1.�û��Ƿ����
		int count=loginDao.checkUserName(username) ;
		if(count>0) {
			//2.�����û����������ѯ��Ϣ
			
		return loginDao.findUserByUsernameAndPasswrd(username, password);	
			
			
		}else {
			return null;
		}
		

	}

	@Override
	public int updateToken(Integer id, String token) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.updateToken(id, token);
		
		
	}

	@Override
	public User findUser(String token) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.findUser(token);
	}

}
