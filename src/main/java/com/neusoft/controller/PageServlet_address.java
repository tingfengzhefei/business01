package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Address;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.service.addressService;
import com.neusoft.service.categoryService;
import com.neusoft.service.impl.addressServiceIpml;
import com.neusoft.service.impl.categoryServiceImpl;

/**
 * Servlet implementation class PageServlet_address
 */
@WebServlet("/PageServlet_address")
public class PageServlet_address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet_address() {
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
		}else {
		 String pageNo=request.getParameter("pageNo");
	   addressService addressservice=new addressServiceIpml();
	   
	    	 PageModel<Address>  pageModel=addressservice.findUserAddress(Integer.parseInt(pageNo), 4, user.getId());
	    		System.out.println(pageModel);
	         request.setAttribute("pageModel", pageModel);
	    	 request.getRequestDispatcher("view/address/address.jsp").forward(request, response);
	    	
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
