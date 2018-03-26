package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.categoryDao;
import com.neusoft.dao.impl.categoryDaoImpl;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.service.categoryService;

public class categoryServiceImpl implements categoryService {

	 /**
     * 单例设计模式
     * */
	private static  categoryServiceImpl  categoryservice=null;
	
	private   categoryServiceImpl() {
		// TODO Auto-generated constructor stub
	
	}
	
	public synchronized static categoryServiceImpl  getIstance() {
		if (categoryservice==null) {
			categoryservice=new categoryServiceImpl();
			
		}
		return categoryservice;
		
		
	}
	
	
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
		
		return categorydao.findAll();
	}

	@Override
	public int deletecategory(Integer id) {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
		return categorydao.deletecategory(id);
	}

	@Override
	public int addcategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
		return categorydao.addcategory(category);
	}

	@Override
	public Category findcategory(Integer id) {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
	    	
	    return categorydao.findcategory(id);
	}

	@Override
	public List<Category> findparent_id() {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
    	return categorydao.findparent_id();
		
	}

	@Override
	public int updatecategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
		
		return categorydao.updatecategory(category);
	}

	@Override
	public PageModel<Category> findcategorybypage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		categoryDao categorydao=categoryDaoImpl.getIstance();
		
		return categorydao.findcategorybypage(pageNo, pageSize);
	}

}
