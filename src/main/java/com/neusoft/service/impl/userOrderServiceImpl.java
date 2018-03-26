package com.neusoft.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neusoft.consts.OrderStatus;
import com.neusoft.dao.CartDao;
import com.neusoft.dao.UserOrderDao;

import com.neusoft.dao.UserOrderItemDao;
import com.neusoft.dao.productDao;
import com.neusoft.dao.impl.UserOrderDaoIpml;
import com.neusoft.dao.impl.UserOrderItemDaoImpl;
import com.neusoft.dao.impl.cartDaoImpl;
import com.neusoft.dao.impl.productDaoIpml;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.UserOrderItem;
import com.neusoft.entity.vo.OrderVo;
import com.neusoft.exception.userOrderException2;
import com.neusoft.exception.userOrderItemException;
import com.neusoft.service.userOrderService;

public class userOrderServiceImpl implements userOrderService {
    CartDao cartDao=new cartDaoImpl();
    productDao productdao=productDaoIpml.getIstance();
    
    UserOrderDao userOrderDao=new UserOrderDaoIpml();
  
    UserOrderItemDao userOrderItemDao=new UserOrderItemDaoImpl();
    
	@Override
	public Order createOrder(Integer user_id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//1.��ȡ��ַid
		 String shipping_id=request.getParameter("shipping_id");
		if(shipping_id==null||shipping_id.equals("") ) {
			System.out.println("�������͵�ַ�������");
			
		}
		  Integer _shipping_id=null;
		  try {
			  _shipping_id=Integer.parseInt(shipping_id);
		  }catch (NumberFormatException e) {
			// TODO: handle exception
			  e.printStackTrace();
			  System.out.println("��ַid���ݲ�׼ȷ������");
		}
		 
		 
		//2.��ѯ�û��µ�����Ʒ���ӹ��ﳵ��ȡ 
		List<Cart> carts=cartDao.findCartListByUserid(user_id);
		//3.��ȡ������Ϣ
		
		List<UserOrderItem>  userOrderItems=convertCartToUserOrderItems(user_id,carts);
		
		//4.���㶩���ܼ�
		BigDecimal totalPriceDecimal=getTotalPrice(userOrderItems);
		//4.��������
		
		UserOrder userOrder=createUserOrder(user_id, _shipping_id, totalPriceDecimal);
		
		if(userOrder!=null) {//�����ɹ��������ݿ�
			//��������ϸ���뵽���ݿ�
			addUserOrderItem(userOrder, userOrderItems);
			
		}
		
	 //5.������Ʒ���
		for(UserOrderItem orderItem: userOrderItems) {
			productdao.reduceStock(orderItem.getProduct_id(), orderItem.getQuantity());
			
			
		}
		//6.��չ��ﳵ
		cartDao.deleteCheckedProductByUserId(user_id);
		return null;
		
		
		
		
		
	}
     
	
	
	/**
	 * ���ﳵcart ת�� ������ϸUserOrderItem
	 * */
	private List<UserOrderItem> convertCartToUserOrderItems(Integer user_id ,List<Cart> carts){
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		for(Cart cart:carts){
			 UserOrderItem orderItem=new UserOrderItem();
			
		Product product=productdao.findproduct(cart.getProduct_id());	
		
		if(product!=null) {
			//������Ʒid��ȡ��Ʒ��Ϣ
			orderItem.setProduct_id(cart.getProduct_id());
			orderItem.setProduct_image(product.getMain_image());
			orderItem.setProduct_name(product.getName());
		    orderItem.setCurrent_unit_price(product.getPrice());
		    
		    //������Ʒ�����ܼ۸�
		   orderItem.setQuantity(cart.getQuantity());
		    //orderItem.setTotal_price(new  BigDecimal(product.getPrice().doubleValue()*cart.getQuantity())  );
		   BigDecimal bigDecimal=new BigDecimal("0");
		   bigDecimal= orderItem.getCurrent_unit_price().multiply(new BigDecimal(cart.getQuantity()));
		   orderItem.setTotal_price(bigDecimal);
		   
		    orderItem.setUser_id(user_id);
		    list.add(orderItem);
		}
		
			 
		}
		
		
		return list;
		}
		
	
	/**
	 * ��������
	 * */
    private UserOrder createUserOrder(Integer user_id, Integer shipping_id,BigDecimal payment) throws userOrderException2  {
    	
    	UserOrder userOrder=new  UserOrder();
    	//������
    	userOrder.setOrder_no(createOrderNo());
    	//�û�ID
    	userOrder.setUser_id(user_id);
    	//�ջ���ַ
    	userOrder.setShipping_id(shipping_id);
    	
    	//�����ܽ��
    	userOrder.setPayment(payment);
    	userOrder.setPayment_type(1);
    	userOrder.setPostage(0);
    	
    	//���ö���״̬
    	
    	userOrder.setStatus(OrderStatus.UNPAY.getStatus());
    	
    	
    	//���������뵽���ݿ�
    	int r=userOrderDao.addOrder(userOrder);
    	if(r>0) {
    		return userOrder;
    		
    	}else {
    		
    		throw new userOrderException2("��������ʧ�ܣ���");
    	}
    	
    	
    	
    
    } 
	
	
	
	/**
	 * ���ɶ������
	 * */
	
	private long createOrderNo(){
		
		return System.currentTimeMillis()+(int)(Math.random()*100);
		
		
	}
	
	/**
	 * �����ܼ۸�
	 * */
	private BigDecimal getTotalPrice(List<UserOrderItem>  userOrderItems) {
		BigDecimal bigDecimal=new BigDecimal("0");
		for (UserOrderItem userOrderItem: userOrderItems) {
			  bigDecimal=bigDecimal.add(userOrderItem.getTotal_price());
		}
		
		return bigDecimal;
		
		
	}
	/**
	 * ������ϸ��ӵ����ݿ�
	 * */
	private int addUserOrderItem(UserOrder order ,List<UserOrderItem>  userOrderItems) {
		//Ϊÿ��������ϸ��Ӷ�����
		for(UserOrderItem userOrderItem: userOrderItems) {
			userOrderItem.setOrder_no(order.getOrder_no());
			
			//�ж���Ʒ��棨stack���Ƿ�ӳ���           ������Ʒ����
			
	   long stock=productdao.getStock(userOrderItem.getProduct_id());
	   
	   if(stock<userOrderItem.getQuantity()) {
		   
		   throw new  userOrderItemException("��治�㣡����");
		   
	   }
	}
		//��������ϸ���뵽���ݿ�
	return	userOrderItemDao.addUserOrderItem(userOrderItems);
	}



	@Override
	public PageModel<OrderVo> findUserOrder(Integer user_id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pageNo =request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=0;
		Integer _pageSize=0;
		
		if(pageNo==null||pageSize==null) {
			
			throw new userOrderException2("��ҳ��ѯ���������봫��pageSize��pageNo");
		}
		
		try {
		_pageNo= Integer.parseInt(pageNo);
		_pageSize=Integer.parseInt(pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new userOrderException2("pageSize��pageNo����");
		}
	PageModel<UserOrder> pageModel=userOrderDao.findUserOrder(user_id, _pageNo, _pageSize);

	return convertUserOrderToOrderVo(pageModel);
	 
	}
	
	
	//��Userorder--> OrderVo
	private  PageModel<OrderVo> convertUserOrderToOrderVo(PageModel<UserOrder> pageModel){
		PageModel<OrderVo>  _pageModel=new PageModel<OrderVo>();
		if(pageModel!=null) {
			List<OrderVo>  list=new ArrayList<OrderVo>();
			List<UserOrder> userOrders=pageModel.getData();
			for(UserOrder order: userOrders) {
				OrderVo orderVo=new OrderVo();
				orderVo.convertUserOrderToOrderVo(order);
				list.add(orderVo);
			}
			_pageModel.setTotalpage(pageModel.getTotalpage());
			_pageModel.setData(list);
		}

		return _pageModel;
	}



	@Override
	public UserOrder findUserOrderItemByOrderNo(Long order_no ) {
		// TODO Auto-generated method stub
	    
	
		UserOrder userOrder= userOrderDao.findUserOrderItemByOrderNo(order_no);
		
		
		return userOrder;
	}



	@Override
	public int updateOrderStatusByOrderNo(Long order_no, String status) {
		// TODO Auto-generated method stub
		
		return userOrderDao.updateOrderStatusByOrderNo(order_no, status);
		
	}



	@Override
	public List<UserOrderItem> findUserOrderItemsByOrderNo(Long order_no) {
		// TODO Auto-generated method stub
		
		return userOrderItemDao.findUserOrderItemsByOrderNo(order_no);
	}
	
	
	
	
}






