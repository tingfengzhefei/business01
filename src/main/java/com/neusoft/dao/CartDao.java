package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;

public interface CartDao {

	Cart findCartByUserIdAndProductId(Integer user_id,Integer product_id) ;
		
	
	
	//3.更新购物车种商品的数量
	int updateCartByUserIdAndProductId(Integer user_id,Integer product_id,Integer quantity);
    //2.用户将商品添加到购物车
    int addProductIntoCartByUserIdAndProductId(Integer user_id,Integer product_id,Integer quantity);

     //1.查看购物车商品
    
    PageModel<Cart> findCartByPage(Integer user_id,Integer pageNo, Integer pageSize );
  //4.移除购物车的某个商品
    int deleteCartByProductid(Integer product_id);
    
    
    //购物车选中某个商品
    //购物车取消选中某个商品
    //购物车选中所有
    //购物车取消选中所有
   
    int checkOrUncheck (Integer user_id , Integer product_id ,int checked);
    
    
    //查询产品总数量
    public int selectCountByProductId(Integer user_id);
    
    
    //查询用户购物车中已选择的商品
    List<Cart> findCartListByUserid(Integer user_id);
    
    
    //删除用户选中购物车中的商品
    
    int deleteCheckedProductByUserId(Integer user_id);
    
}







