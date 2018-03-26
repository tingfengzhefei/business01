package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.service.cartService;
import com.neusoft.service.impl.cartServiceImpl;

/**
 * Servlet implementation class JS_cart
 */
@WebServlet("/JS_cart")
public class JS_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JS_cart() {
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
		
		
		/*HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		User user=null;
		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {//2.不存在，需要登陆
			response.sendRedirect("http://localhost:8080/xiaoxiong01/hello.jsp");
		}else {*/
		
	
		
		String  choose = request.getParameter("choose");
		cartService cartservice=new cartServiceImpl();
		String callback=request.getParameter("callback");
		if(choose.equals("1")) {
			
			//response.setHeader("Access-Control-Origin", "*");
		
			//String userid = request.getParameter("user_id");
			PageModel<Cart> carts=cartservice.findCartByPage(1, request);
			//System.out.println(carts);
			//对象转成json字符串
			Gson gson=new Gson();
			String result=gson.toJson(carts);
			PrintWriter printWriter=response.getWriter();
			printWriter.write("callback("+result+")");	
			        
					
			
		}else if(choose.equals("2")) {
			Integer sum=cartservice.selectCountByProductId(1);
			Gson gson=new Gson();
			String result= "{\"sum\":"+sum+"}";
			response.getWriter().write(callback+"("+result+")");	
		}
		}
	/*}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
