package com.neusoft.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.dao.CartDao;
import com.neusoft.dao.categoryDao;
import com.neusoft.dao.impl.cartDaoImpl;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.service.cartService;

public class cartServiceImpl implements cartService {
	CartDao cartDao=new cartDaoImpl();
	public int addProductToCart(Integer user_id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		
		//1.判断product_id非空判断
		
		
		
	String product_id =request.getParameter("product_id");
		if(product_id==null||product_id.equals("")) {
		  System.out.println("商品加入购物车，必须传入商品id");
		 return 0;
		}
		
		
		Integer _product_id=0;
				
		try {		
				
		_product_id=Integer.parseInt(product_id);
		}catch (NumberFormatException e) {
			e.printStackTrace();
			 System.out.println("商品加入购物车，必须传入数字类型字符串参数");
		}
		
		String quantity=request.getParameter("quantity");
		
		Integer _quantity=0;
		
		try {		
				
			_quantity=Integer.parseInt(quantity);
		}catch (NumberFormatException e) {
			e.printStackTrace();
			 System.out.println("商品加入购物车，必须传入数字类型字符串参数");
		}
		
		
		
		//2.商品是否已经存在购物车中
		Cart cart=cartDao.findCartByUserIdAndProductId(user_id, _product_id);
		
		if(cart!=null) {//2-1.存在，更新数量
			int totalQuantity=cart.getQuantity()+_quantity;
			
			if(totalQuantity==0) {
				return cartDao.deleteCartByProductid(_product_id);
			}
			
			return cartDao.updateCartByUserIdAndProductId(user_id, _product_id, totalQuantity);
		}

		
		else {//2-2.不存在，添加
			
			return cartDao.addProductIntoCartByUserIdAndProductId(user_id, _product_id, _quantity);
		}
		
		
	
	}
	
	@Override
	public PageModel<Cart> findCartByPage(Integer user_id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pageNo =request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=0;
		Integer _pageSize=0;
		
		try {
		_pageNo= Integer.parseInt(pageNo);
		_pageSize=Integer.parseInt(pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  return cartDao.findCartByPage(user_id, _pageNo, _pageSize);

	}

	@Override
	public int deleteCartByProductid(Integer product_id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCartByProductid(product_id);
	}

	@Override
	public int checkOrUncheck(Integer user_id, Integer product_id, int checked) {
		// TODO Auto-generated method stub
		return cartDao.checkOrUncheck(user_id, product_id, checked);
	}

	@Override
	public int selectCountByProductId(Integer user_id) {
		// TODO Auto-generated method stub
		return cartDao.selectCountByProductId(user_id);
	}

	

}
