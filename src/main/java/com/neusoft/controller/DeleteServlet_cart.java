package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neusoft.service.addressService;
import com.neusoft.service.cartService;
import com.neusoft.service.impl.addressServiceIpml;
import com.neusoft.service.impl.cartServiceImpl;

/**
 * Servlet implementation class DeleteServlet_cart
 */
@WebServlet("/DeleteServlet_cart")
public class DeleteServlet_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet_cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
		    String product_id= request.getParameter("product_id");
		    System.out.println(product_id);
		    cartService cartservice=new cartServiceImpl();
		    int result = cartservice.deleteCartByProductid(Integer.parseInt(product_id) );
		 
			
		  
		    if(result>0) {
		    
		    	
		    	
		    	//request.getRequestDispatcher("PageServlet_address?pageNo=1").forward(request, response);
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
