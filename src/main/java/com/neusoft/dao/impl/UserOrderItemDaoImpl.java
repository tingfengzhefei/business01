package com.neusoft.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.common.MybatisUtils;
import com.neusoft.dao.UserOrderItemDao;
import com.neusoft.entity.UserOrderItem;

public class UserOrderItemDaoImpl implements UserOrderItemDao {

	@Override
	public int addUserOrderItem(List<UserOrderItem> list) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		
		int len=list.size();
		if(len>0) {
			int r=session.insert("com.neusoft.config.userorderitem.addUserOrderItem",list);
			session.commit();
			session.close();
			return r;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<UserOrderItem> findUserOrderItemsByOrderNo(Long order_no) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		
		List<UserOrderItem> list=session.selectList("com.neusoft.config.userorderitem.findUserOrderItemsByOrderNo",order_no);
		
		session.commit();
		session.close();
		return list;
	}

}
