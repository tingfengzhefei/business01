package com.neusoft.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import com.neusoft.common.MybatisUtils;
import com.neusoft.dao.UserOrderDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;

public class UserOrderDaoIpml implements UserOrderDao {

	@Override
	public int addOrder(UserOrder userOrder) {
		
		// TODO Auto-generated method stub
		
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		
		int result=session.insert("com.neusoft.config.userorder.addOrder", userOrder);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public PageModel<UserOrder> findUserOrder(Integer user_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		//获取总记录数
		Integer totalCount= session.selectOne("com.neusoft.config.userorder.findTotalCount", user_id);
		
	    //分页查询 
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id",user_id);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<UserOrder> list= session.selectList("com.neusoft.config.userorder.findUserOrder", map);
		int totalpage=(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		pageModel.setTotalpage(totalpage);
		pageModel.setData(list);
		/*List<UserOrder> list2=pageModel.getData();
		for(UserOrder uo:list2) {
			String str=uo.getAddress().getReceiver_address();
			System.out.println(str);
		}*/
		session.commit();
		session.close();
		return pageModel;
	}

	@Override
	public UserOrder findUserOrderItemByOrderNo(Long order_no) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession(false);
		
		UserOrder userOrder=session.selectOne("com.neusoft.config.userorder.findUserOrderItemByOrderNo",order_no);
		
		session.commit();
		session.close();
		return userOrder;
	}

	@Override
	public int updateOrderStatusByOrderNo(Long order_no,String status) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=sessionFactory.openSession(false);
		Map<String, Object>  map=new HashMap<String, Object>();
		map.put("order_no", order_no);
		map.put("status", status);
		
		int result=session.update("com.neusoft.config.userorder.updateOrderStatusByOrderNo", map);
		session.commit();
		session.close();
		return result;
	}

}
