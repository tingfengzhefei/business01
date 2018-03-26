package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;

import com.google.gson.Gson;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.service.cartService;
import com.neusoft.service.impl.cartServiceImpl;

/**
 * Servlet implementation class PageServlet_cart
 */
@WebServlet("/PageServlet_cart")
public class PageServlet_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet_cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		User user=null;
		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {//2.不存在，需要登陆
			response.sendRedirect("http://localhost:8080/Business/hello.jsp");
		}else {//3.存在用户，说明已经登录
		cartService cartservice=new cartServiceImpl();
		
		PageModel<Cart> carts=cartservice.findCartByPage(user.getId(), request);

		 
				
		Integer sum=cartservice.selectCountByProductId(user.getId());
		request.setAttribute("sum", sum);
		
		request.setAttribute("pageModel", carts);
		
		request.getRequestDispatcher("view/cart/cart.jsp").forward(request, response);
		
		
		  //对象转成json字符串
		Gson gson=new Gson();
		String result=gson.toJson(carts);
		
		PrintWriter printWriter=response.getWriter();
		printWriter.write("data("+result+")");
		
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
