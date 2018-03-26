package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Address;
import com.neusoft.entity.User;
import com.neusoft.service.addressService;
import com.neusoft.service.impl.addressServiceIpml;

/**
 * Servlet implementation class UpdateServlet_address
 */
@WebServlet("/UpdateServlet_address")
public class UpdateServlet_address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet_address() {
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
			
		
	String id =request.getParameter("id");
	  addressService addressservice=new addressServiceIpml();
	  Address address= addressservice.findAll(Integer.parseInt(id));
	  
	  System.out.println(address);
	  request.setAttribute("address", address);
	  request.getRequestDispatcher("view/address/update_address.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	    Address address=new Address();
		
	    
	    String id = request.getParameter("id");
		address.setId(Integer.parseInt(id));
		String user_id = request.getParameter("user_id");
		address.setUser_id(Integer.parseInt(user_id));
		String receiver_name = request.getParameter("receiver_name");
		address.setReceiver_name(receiver_name);
		String receiver_phone = request.getParameter("receiver_phone");
		address.setReceiver_phone(receiver_phone);
		String receiver_moblie= request.getParameter("receiver_moblie");
		address.setReceiver_moblie(receiver_moblie);
		String receiver_provinc = request.getParameter("receiver_provinc");
		address.setReceiver_provinc(receiver_provinc);
		String receiver_city = request.getParameter("receiver_city");
		address.setReceiver_city(receiver_city);
		String receiver_district = request.getParameter("receiver_district");
		address.setReceiver_district(receiver_district);
		String receiver_address = request.getParameter("receiver_address");
		address.setReceiver_address(receiver_address);
		String receiver_zip = request.getParameter("receiver_zip");
		address.setReceiver_zip(receiver_zip);
	
		
		addressService addressservice=new addressServiceIpml();
		int result=addressservice.updateUserAddByUserid(Integer.parseInt(user_id), address);

		if(receiver_name.equals("")||receiver_phone.equals("")||receiver_moblie.equals("")||receiver_provinc.equals("")||receiver_city.equals("")||receiver_district.equals("")||receiver_address.equals("")||receiver_zip.equals("")) {
		
			response.sendRedirect("http://localhost:8080/Business/UpdateServlet_address");
		}else {
			
			if(result>0){
			response.sendRedirect("http://localhost:8080/Business/PageServlet_address?pageNo=1");
			}
		}
		
	}

}
