package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface productService {
	//��ѯ
	public List<Product> findAll();
	//ɾ��
	public int deleteproduct(Integer id);
	//���
	public int addproduct(Product product);
	/**
	 * ����
	 * */
	
	
	//����id��ѯ��Ϣ
	public Product findproduct(Integer id);
	
	//�޸���Ϣ
	
	public int updateproduct(Product product);
	
	
	//��ѯcategory���id
		public List<Category> findcategory();
		
		
	
		
		 public PageModel<Product> findcategorybypage(Integer pageNo,Integer pageSize);	
		
}
