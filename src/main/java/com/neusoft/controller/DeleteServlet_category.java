package com.neusoft.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Category;
import com.neusoft.service.categoryService;
import com.neusoft.service.impl.categoryServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.do")
public class DeleteServlet_category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet_category() {
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
		categoryService categoryservice=categoryServiceImpl.getIstance();
		
		try {
		categoryservice.deletecategory(Integer.parseInt(id));
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
       List<Category> category=categoryservice.findAll();
		
		
		request.setAttribute("category", category);
		
		
		
	 request.getRequestDispatcher("page.do?pageNo=1").forward(request, response);
		
		
		
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
