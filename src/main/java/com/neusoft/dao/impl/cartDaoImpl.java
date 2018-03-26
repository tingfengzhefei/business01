package com.neusoft.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.common.MybatisUtils;
import com.neusoft.dao.CartDao;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;

public class cartDaoImpl implements CartDao {

	@Override
	public int updateCartByUserIdAndProductId(Integer user_id, Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Map<String, Integer>  map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);	
		map.put("quantity", quantity);
		int result=sqlSession.update("com.neusoft.config.updateCartByUserIdAndProductId", map);
		sqlSession.close();
		return result;
	}

	@Override
	public int addProductIntoCartByUserIdAndProductId(Integer user_id, Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Map<String, Integer>  map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);	
		map.put("quantity", quantity);
		int result=sqlSession.insert("com.neusoft.config.addProductIntoCartByUserIdAndProductId", map);
		sqlSession.close();
		return result;
	}

	@Override
	public PageModel<Cart> findCartByPage(Integer user_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = MybatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		int totalCount = session.selectOne("com.neusoft.config.findtotalcount");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Cart> list = session.selectList("com.neusoft.config.findCartByPage", map);
		
		PageModel<Cart> pageModel=new PageModel<Cart>();
		int totalPage= (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
		pageModel.setTotalpage(totalPage);
		pageModel.setData(list);
		session.close();
		return pageModel;

		
		

	}

	@Override
	public int deleteCartByProductid( Integer product_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
	
		
	
		int result=sqlSession.delete("com.neusoft.config.deleteCartByProductid", product_id);
		sqlSession.close();
		return result;
	}

	@Override
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Cart cart=new Cart();
		Map<String, Integer>  map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		
		cart=sqlSession.selectOne("com.neusoft.config.findCartByUserIdAndProductId", map);
		sqlSession.close();
		return cart;
	}



	



	@Override
	public int selectCountByProductId(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = MybatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(false);
		
		int result = session.selectOne("com.neusoft.config.selectCountByProductId", user_id);
		session.commit();
		
		return result;

	}

	@Override
	public int checkOrUncheck(Integer user_id, Integer product_id, int checked) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Map<String, Integer>  map=new HashMap<String, Integer>();
		
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		map.put("checked", checked);
		int result=sqlSession.update("com.neusoft.config.checkOrUncheck", map);
		sqlSession.close();
		return result;
	}

	@Override
	public List<Cart> findCartListByUserid(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		 
		List<Cart> list=sqlSession.selectList("com.neusoft.config.findCartListByUserid", user_id);

		sqlSession.close();
		
		
		return list;
	}

	@Override
	public int deleteCheckedProductByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		 
		int r=sqlSession.delete("com.neusoft.config.deleteCheckedProductByUserId", user_id);

		sqlSession.close();
		
		return r;
	}

	

	

	
	
	
	
	
	
	
	
	

}
