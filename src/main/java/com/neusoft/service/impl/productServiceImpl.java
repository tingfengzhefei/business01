package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.productDao;
import com.neusoft.dao.impl.productDaoIpml;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.service.productService;

public class productServiceImpl implements productService {

	 /**
     * 单例设计模式
     * */
	private static  productServiceImpl  productservice=null;
	
	private   productServiceImpl() {
		// TODO Auto-generated constructor stub
	
	}
	
	public synchronized static productServiceImpl  getIstance() {
		if (productservice==null) {
			productservice=new productServiceImpl();
			
		}
		return productservice;
		
		
	}
	
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		return productdao.findAll();
	
	}

	@Override
	public int deleteproduct(Integer id) {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		return productdao.deleteproduct(id);
	
	}

	@Override
	public int addproduct(Product product) {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		return productdao.addproduct(product);
	
	}

	@Override
	public Product findproduct(Integer id) {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		
		return productdao.findproduct(id);
	}

	@Override
	public int updateproduct(Product product) {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		
		return productdao.updateproduct(product);
	}

	@Override
	public List<Category> findcategory() {
		// TODO Auto-generated method stub
		
		productDao productdao=productDaoIpml.getIstance();
	
		return 	productdao.findcategory();
	}

	@Override
	public PageModel<Product> findcategorybypage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		productDao productdao=productDaoIpml.getIstance();
		return  productdao.findcategorybypage(pageNo, pageSize);
		
	}

	

}
