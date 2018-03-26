package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.service.productService;
import com.neusoft.service.impl.productServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
	String id=request.getParameter("id");
	productService productservice=productServiceImpl.getIstance();
	try {
		productservice.deleteproduct(Integer.parseInt(id));
		
	}catch (NumberFormatException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		close();
	}
	
	
	
	  List<Product> products=productservice.findAll();
		request.setAttribute("products", products);
	  request.getRequestDispatcher("Page.do?pageNo=1").forward(request, response);
		
		
	}

	private void close() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
