package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;



public interface categoryService {
	
	//��ѯ
	public List<Category> findAll() ;
	//ɾ��
	public int deletecategory(Integer id);
	//���
	public int addcategory(Category category);
	
	
	 //��ѯ���и����id
	  public List<Category> findparent_id();
	/**
	 * ����
	 * */ 
	
	
	 //����id��ѯ��Ϣ
	 public Category findcategory(Integer id);
	 
	//�޸���Ϣ
	 public int updatecategory(Category category);
	 
	 //��ҳ��ѯ
	 
	 public PageModel<Category> findcategorybypage(Integer pageNo,Integer pageSize);
	 
}
