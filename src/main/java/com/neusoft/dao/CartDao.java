package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;

public interface CartDao {

	Cart findCartByUserIdAndProductId(Integer user_id,Integer product_id) ;
		
	
	
	//3.���¹��ﳵ����Ʒ������
	int updateCartByUserIdAndProductId(Integer user_id,Integer product_id,Integer quantity);
    //2.�û�����Ʒ��ӵ����ﳵ
    int addProductIntoCartByUserIdAndProductId(Integer user_id,Integer product_id,Integer quantity);

     //1.�鿴���ﳵ��Ʒ
    
    PageModel<Cart> findCartByPage(Integer user_id,Integer pageNo, Integer pageSize );
  //4.�Ƴ����ﳵ��ĳ����Ʒ
    int deleteCartByProductid(Integer product_id);
    
    
    //���ﳵѡ��ĳ����Ʒ
    //���ﳵȡ��ѡ��ĳ����Ʒ
    //���ﳵѡ������
    //���ﳵȡ��ѡ������
   
    int checkOrUncheck (Integer user_id , Integer product_id ,int checked);
    
    
    //��ѯ��Ʒ������
    public int selectCountByProductId(Integer user_id);
    
    
    //��ѯ�û����ﳵ����ѡ�����Ʒ
    List<Cart> findCartListByUserid(Integer user_id);
    
    
    //ɾ���û�ѡ�й��ﳵ�е���Ʒ
    
    int deleteCheckedProductByUserId(Integer user_id);
    
}







