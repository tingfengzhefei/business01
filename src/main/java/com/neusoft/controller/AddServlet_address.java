package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Address;
import com.neusoft.entity.Category;
import com.neusoft.entity.User;
import com.neusoft.service.addressService;
import com.neusoft.service.categoryService;
import com.neusoft.service.impl.addressServiceIpml;
import com.neusoft.service.impl.categoryServiceImpl;

/**
 * Servlet implementation class AddServlet_address
 */
@WebServlet("/AddServlet_address")
public class AddServlet_address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet_address() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getCharacterEncoding();
		
		HttpSession session=request.getSession();
		Object object=session.getAttribute("user");
		User user=null;
		if(object!=null && object instanceof User) {
			user=(User)object;
		}
		if(user==null) {//2.不存在，需要登陆
			response.sendRedirect("http://localhost:8080/Business/hello.jsp");
		}else {
		Address address=new Address();
		
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
		
		if(receiver_name.equals("")||receiver_phone.equals("")||receiver_moblie.equals("")||receiver_provinc.equals("")||receiver_city.equals("")||receiver_district.equals("")||receiver_address.equals("")||receiver_zip.equals("")) {
			response.sendRedirect("http://localhost:8080/Business/view/address/add_address.jsp");
		}else {
			addressService addressservice=new addressServiceIpml();
			addressservice.addAddress(Integer.parseInt(user_id), address);
			
			response.sendRedirect("http://localhost:8080/Business/PageServlet_address?pageNo=1");
		}
			
		}
	
	}
}
