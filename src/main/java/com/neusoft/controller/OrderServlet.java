package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.UserOrderItem;
import com.neusoft.entity.vo.OrderVo;
import com.neusoft.service.userOrderService;
import com.neusoft.service.impl.userOrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		User user=null;
		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {//2.不存在，需要登陆
			response.sendRedirect("http://localhost:8080/Business/hello.jsp");
		return;
		}
		userOrderService uos=new userOrderServiceImpl();
		/**
		1. 下单     
		2. 分页获取订单   
		3.按订单编号查询订单（订单详情） 
		4.订单发货,取消订单
		5.
		*/
		String operationtype=request.getParameter("operationtype");
		
	    if(operationtype.equals("1")) {
	    	
	 	  uos.createOrder(user.getId(), request);
	 	/*  PageModel<OrderVo> pageModel=uos.findUserOrder(user.getId(), request);
		  request.setAttribute("pageModel", pageModel);
		  request.getRequestDispatcher("view/order/order.jsp").forward(request,response);*/
		   
	  }else if(operationtype.equals("2")) {
		  
		 PageModel<OrderVo> pageModel=uos.findUserOrder(user.getId(), request);
		 request.setAttribute("pageModel", pageModel);
		 request.getRequestDispatcher("view/order/order.jsp").forward(request,response); 
		 
		 
	  }else if (operationtype.equals("3")) {
		  
		  String order_no=request.getParameter("order_no");
		  if(order_no==null&&order_no.equals("")) {
		  
		  }else {
			  try {
				  System.out.println(order_no);
					UserOrder userOrder= uos.findUserOrderItemByOrderNo(Long.parseLong(order_no));
					System.out.println(userOrder);
					request.setAttribute("userOrder", userOrder);
					request.getRequestDispatcher("view/order/orderitem.jsp").forward(request, response);
					}catch (NumberFormatException e) {
						// TODO: handle exception
							  e.printStackTrace();
					}
		   }
			 
	  }else if(operationtype.equals("4")) {
		  String order_no=request.getParameter("order_no");
		  String status=request.getParameter("status");
		  try {
		  uos.updateOrderStatusByOrderNo(Long.parseLong(order_no), status);
		  System.out.println(status);
		  }catch (NumberFormatException e) {
			// TODO: handle exception
			  e.printStackTrace();
		}
		  PageModel<OrderVo> pageModel=uos.findUserOrder(user.getId(), request);
		  request.setAttribute("pageModel", pageModel);
		  request.getRequestDispatcher("view/order/order.jsp").forward(request,response); 
		  
	}else if(operationtype.equals("5")) {
		
		String order_no=request.getParameter("order_no");
		List<UserOrderItem> userOrderItems=uos.findUserOrderItemsByOrderNo(Long.parseLong(order_no));
		request.setAttribute("userOrderItems", userOrderItems);
		request.getRequestDispatcher("view/order/orderitems.jsp").forward(request, response); 
		
	}
		
		  
		  
		  
		  
		  
	}
	    
		
	
		
	
		
		
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
