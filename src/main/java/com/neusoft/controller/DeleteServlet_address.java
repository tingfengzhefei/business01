package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.User;
import com.neusoft.service.addressService;
import com.neusoft.service.impl.addressServiceIpml;

/**
 * Servlet implementation class DeleteServlet_address
 */
@WebServlet("/DeleteServlet_address")
public class DeleteServlet_address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet_address() {
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
	    String id= request.getParameter("id");
	    //String user_id= request.getParameter("user_id");
		
	    addressService addressService=new addressServiceIpml();
	    int result = addressService.deleteAddressByUserid(Integer.parseInt(id),user.getId() );
	    if(result>0) {
	    	//request.getRequestDispatcher("PageServlet_address?pageNo=1").forward(request, response);
		    response.sendRedirect("http://localhost:8080/Business/PageServlet_address?pageNo=1");
	    }		
		} 
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
