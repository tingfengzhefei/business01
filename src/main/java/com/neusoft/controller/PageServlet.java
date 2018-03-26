package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.service.productService;

import com.neusoft.service.impl.productServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/Page.do")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     String pageNo=request.getParameter("pageNo");
    productService productservice=productServiceImpl.getIstance();
    try {
    	 PageModel<Product>  pageModel=productservice.findcategorybypage(Integer.parseInt(pageNo),6);	
         request.setAttribute("pageModel", pageModel);
    	 request.getRequestDispatcher("mng/product/product.jsp").forward(request, response);
    	
    }catch(NumberFormatException e) {
    	e.printStackTrace();
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
