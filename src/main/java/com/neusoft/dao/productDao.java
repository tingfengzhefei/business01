package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.exception.DaoException;

public interface productDao {
//��ѯ
	public List<Product> findAll();
//ɾ��	
	public int deleteproduct(Integer id);
//���	
	public int addproduct(Product product); 
/**
 * 
 * ����
 * */	
	//����id��ѯ��Ϣ
	
	public Product findproduct(Integer id);
	//�޸���Ϣ
	public int updateproduct(Product product);
	
	//��ѯcategory���id
	public List<Category> findcategory();
	
	 /**
	   * 
	   * ��ҳ��ȡ����
	   * pageNo��ȡ�ڼ�ҳ
	   * pagesizeÿҳ����������
	   * */
	  public PageModel<Product> findcategorybypage(Integer pageNo,Integer pageSize);

	
	  
	  
	  
	  
	  
	  //������ƷID��ѯ��Ʒ���
	  Long getStock(Integer id);
	  
	  
	  
	  //������Ʒ���
	  
	  int reduceStock(Integer id,Integer quantity);
	
}
