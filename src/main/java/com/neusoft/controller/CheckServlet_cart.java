package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.User;
import com.neusoft.service.cartService;
import com.neusoft.service.impl.cartServiceImpl;

/**
 * Servlet implementation class CheckServlet_cart
 */
@WebServlet("/CheckServlet_cart")
public class CheckServlet_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet_cart() {
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
		}else {//3.存在用户，说明已经登录
		    String product_id=request.getParameter("product_id");
		    String checked=request.getParameter("checked");
			cartService cartservice=new cartServiceImpl();
			cartservice.checkOrUncheck(user.getId(),Integer.parseInt(product_id),Integer.parseInt(checked));
			
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
