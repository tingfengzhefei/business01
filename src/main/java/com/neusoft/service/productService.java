package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface productService {
	//查询
	public List<Product> findAll();
	//删除
	public int deleteproduct(Integer id);
	//添加
	public int addproduct(Product product);
	/**
	 * 更新
	 * */
	
	
	//根据id查询信息
	public Product findproduct(Integer id);
	
	//修改信息
	
	public int updateproduct(Product product);
	
	
	//查询category表的id
		public List<Category> findcategory();
		
		
	
		
		 public PageModel<Product> findcategorybypage(Integer pageNo,Integer pageSize);	
		
}
