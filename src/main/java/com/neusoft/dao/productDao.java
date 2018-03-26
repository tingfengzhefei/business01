package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.exception.DaoException;

public interface productDao {
//查询
	public List<Product> findAll();
//删除	
	public int deleteproduct(Integer id);
//添加	
	public int addproduct(Product product); 
/**
 * 
 * 更新
 * */	
	//根据id查询信息
	
	public Product findproduct(Integer id);
	//修改信息
	public int updateproduct(Product product);
	
	//查询category表的id
	public List<Category> findcategory();
	
	 /**
	   * 
	   * 分页获取数据
	   * pageNo获取第几页
	   * pagesize每页多少条数据
	   * */
	  public PageModel<Product> findcategorybypage(Integer pageNo,Integer pageSize);

	
	  
	  
	  
	  
	  
	  //根据商品ID查询商品库存
	  Long getStock(Integer id);
	  
	  
	  
	  //减少商品库存
	  
	  int reduceStock(Integer id,Integer quantity);
	
}
