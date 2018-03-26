package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Const;

/**
 * Servlet implementation class LoginoutServlet
 */
@WebServlet("/Loginout.do")
public class LoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.需要将登录信息user从会话中移除
		
		HttpSession session=request.getSession();
	
		session.removeAttribute("user");
	   //2.把username和passoword的cookie移除
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("token")) {
				  Cookie c1=new Cookie(c.getName(), c.getValue());
				  c1.setMaxAge(0);
				  c1.setPath("/Business");//
				  response.addCookie(c1);
				}
				
			
				
			}
			
			
		}
	    //3.页面跳转到登录界面
		response.sendRedirect("http://localhost:8080/Business/hello.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
