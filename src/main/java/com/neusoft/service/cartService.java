package com.neusoft.service;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;

public interface cartService {

	
	//购物车添加商品
	
	int  addProductToCart(Integer user_id,HttpServletRequest request);

    
	//查询购物车
	PageModel<Cart> findCartByPage(Integer user_id,HttpServletRequest request );
	
	
	 int deleteCartByProductid(Integer product_id);

	
	 int checkOrUncheck (Integer user_id , Integer product_id ,int checked);
	
	
	
	 int selectCountByProductId(Integer user_id);
	 
}
