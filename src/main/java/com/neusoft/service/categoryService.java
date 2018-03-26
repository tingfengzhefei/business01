package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;



public interface categoryService {
	
	//查询
	public List<Category> findAll() ;
	//删除
	public int deletecategory(Integer id);
	//添加
	public int addcategory(Category category);
	
	
	 //查询所有父类别id
	  public List<Category> findparent_id();
	/**
	 * 更新
	 * */ 
	
	
	 //根据id查询信息
	 public Category findcategory(Integer id);
	 
	//修改信息
	 public int updatecategory(Category category);
	 
	 //分页查询
	 
	 public PageModel<Category> findcategorybypage(Integer pageNo,Integer pageSize);
	 
}
