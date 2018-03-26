package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.neusoft.entity.User;
import com.neusoft.service.cartService;
import com.neusoft.service.impl.cartServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/*String operation=request.getParameter("operation");
		
		if(operation.equals("1")) {
		
		}else if(operation.equals("2")) {
			
		}else if(operation.equals("3")) {
			
		}else if(operation.equals("4")) {
			
		}*/
		
		//1.从会话中获取用户信息
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
			cartservice.addProductToCart(user.getId(), request);
			
			
			response.sendRedirect("http://localhost:8080/Business/PageServlet_cart?pageNo=1&pageSize=5");
			
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
