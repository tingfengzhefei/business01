package com.neusoft.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.User;
import com.neusoft.service.ILoginService;
import com.neusoft.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class loginfilter
 */
@WebFilter("/mng/*")
public class loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginfilter() {
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest request = (HttpServletRequest) _request;
		HttpServletResponse response = (HttpServletResponse) _response;
		HttpSession session = request.getSession();
		
		/*String _username = null;
		String _password = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("username")) {
					_username=c.getValue();
				}
				if(c.getName().equals("password")) {
					_password=c.getValue();
				}
			}
		}*/
		//用户token是否存在
		String token = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("token")) {
					token=c.getValue();
				}
				
			}
		}
		if(token!=null) {
			//调用service层的·findUser
		ILoginService iLoginService=new  LoginServiceImpl();
			User user = iLoginService.findUser(token);
			if(user!=null) {
				session.setAttribute("user", user);
				// pass the request along the filter chain
				chain.doFilter(request, response);
				
			}else {
				response.sendRedirect("http://localhost:8080/Business/hello.jsp");
			}
		}else {
			response.sendRedirect("http://localhost:8080/Business/hello.jsp");
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
