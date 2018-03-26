package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.User;
import com.neusoft.service.ILoginService;
import com.neusoft.service.impl.LoginServiceImpl;

import co.neusoft.utils.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//创建回话
		HttpSession session=request.getSession();
		String  _username=null;
		String  _password=null;
		
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("username")) {
					_username=c.getValue();
				}
				if(c.getName().equals("password")) {
					_password=c.getValue();
				}
			
				
			}
			
			
		}
		if(_username!=null&&_password!=null) {
			ILoginService loginService=new LoginServiceImpl();
			User user=loginService.login(_username,_password);
			if(user!=null) {//登陆成功
				session.setAttribute("user", user);
				response.sendRedirect("http://localhost:8080/Business/mng/hhh.jsp");
			return;
			}
		}
		
		/*session.setMaxInactiveInterval(5)
		if(session.isNew()) {
			System.out.println("这是一个新的回话");
		}else {
			
			System.out.println("这是一个已存在的回话");
		}
		System.out.println("创建时间="+session.getCreationTime());
		System.out.println("回话id="+session.getId());
		System.out.println("最后一次访问回话的时间="+session.getLastAccessedTime());
		System.out.println("回话超时时间"+session.getMaxInactiveInterval());
		*/
		
		
		
		//获取表单信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(password!=null) {
			password=MD5Utils.GetMD5Code(password);
		}
		
		
		//System.out.println(_username+"  "+_password );
	
		
		//调用service层的login
		ILoginService loginService=new LoginServiceImpl();
		User user=loginService.login(username,password);
		System.out.println(user);
		if(user!=null) {//登陆成功
			
			//令牌
			String  token=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			Cookie token_cookie=new Cookie("token",token);
			token_cookie.setMaxAge(7*24*3600);
			token_cookie.setPath(request.getContextPath());
			response.addCookie(token_cookie);
			loginService.updateToken(user.getId(),token);
			
			//将用户名和密码通过cookie写到客户端
			
		/*Cookie username_cookie=new Cookie("username", user.getUsername());
			Cookie password_cookie=new Cookie("password", user.getPassword());
			username_cookie.setMaxAge(24*3600);
			password_cookie.setMaxAge(24*3600);
			username_cookie.setPath("/Business");
			password_cookie.setPath("/Business");
			response.addCookie(username_cookie);
			response.addCookie(password_cookie);*/
			
			response.sendRedirect("http://localhost:8080/Business/mng/hhh.jsp");
		}else {
			request.getRequestDispatcher("mng/fail.jsp").forward(request, response);
		}
		
		
		
		
		
	
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	

}
