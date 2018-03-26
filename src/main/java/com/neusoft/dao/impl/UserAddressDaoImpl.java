package com.neusoft.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.net.SyslogAppender;

import com.neusoft.common.MybatisUtils;
import com.neusoft.dao.UserAddressDao;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public class UserAddressDaoImpl implements UserAddressDao {

	@Override
	public int addAddress(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		//System.out.println(address);
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sessionFactory.openSession(false);
		//address.setUser_id(user_id);
		//System.out.println(address);
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("user_id", address.getUser_id());
		map.put("receiver_name",address.getReceiver_name());
		map.put("receiver_phone",address.getReceiver_phone());
		map.put("receiver_moblie",address.getReceiver_moblie());
		map.put("receiver_provinc",address.getReceiver_provinc());
		map.put("receiver_city",address.getReceiver_city());
		map.put("receiver_district",address.getReceiver_district());
		map.put("receiver_address",address.getReceiver_address());
		map.put("receiver_zip",address.getReceiver_zip());
		
		int result=sqlSession.insert("com.neusoft.config.addAddressDao",map);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return result;
	}

	@Override
	public int deleteAddressByUserid(Integer id, Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sessionFactory.openSession();
		int result=sqlSession.delete("com.neusoft.config.deleteAddressByUserid", id);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return result;
	}

	@Override
	public Address findAll(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sessionFactory.openSession();
		Object object = sqlSession.selectOne("com.neusoft.config.findAll", id);
		if(object instanceof Address) {
			return (Address)object;
		}
		return null;

		
		
		
	}

	
	@Override
	public int updateUserAddByUserid(Integer user_id,Address address) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sessionFactory.openSession();
	Map<String,Object> map=new HashMap<String,Object>();
	    map.put("id", address.getId());
		map.put("user_id", user_id);
		map.put("receiver_name",address.getReceiver_name());
		map.put("receiver_phone",address.getReceiver_phone());
		map.put("receiver_moblie",address.getReceiver_moblie());
		map.put("receiver_provinc",address.getReceiver_provinc());
		map.put("receiver_city",address.getReceiver_city());
		map.put("receiver_district",address.getReceiver_district());
		map.put("receiver_address",address.getReceiver_address());
		map.put("receiver_zip",address.getReceiver_zip());
	    
		
		int result= sqlSession.update("com.neusoft.config.updateUserAddByUserid", map);
		sqlSession.commit();
		MybatisUtils.close(sqlSession);
		return result;
		
		
		
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sessionFactory.openSession();
		
		//1.查询总记录  -> 计算总共多少页
		int totalcount=(Integer)sqlSession.selectOne("com.neusoft.config.findTotalCount");
	    
		//2.查询页数的数据
		  Map<String,Object> map=new HashMap<String,Object>(); 
		  map.put("offset", (pageNo-1)*pageSize);
		  map.put("pageSize", pageSize);
		  map.put("user_id", user_id);
		  List<Address> address =sqlSession.selectList("com.neusoft.config.findUserAddress", map);
		  PageModel<Address> pageModel=new PageModel<Address>();
	      pageModel.setTotalpage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1));
	      pageModel.setData(address);
	      sqlSession.commit();
	      return pageModel;
	      
	}


}
