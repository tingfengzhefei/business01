package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.service.categoryService;
import com.neusoft.service.impl.categoryServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/page.do")
public class PageServlet_category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet_category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     String pageNo=request.getParameter("pageNo");
     categoryService categoryservice=categoryServiceImpl.getIstance();
    try {
    	 PageModel<Category>  pageModel=categoryservice.findcategorybypage(Integer.parseInt(pageNo),6);
    		
         request.setAttribute("pageModel", pageModel);
    	 request.getRequestDispatcher("mng/category/category.jsp").forward(request, response);
    	
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
