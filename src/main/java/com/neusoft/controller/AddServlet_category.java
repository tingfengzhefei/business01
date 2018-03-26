package com.neusoft.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class AddServlet
 */
@WebServlet("/add.do")
public class AddServlet_category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet_category() {
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
		categoryService categoryservice=categoryServiceImpl.getIstance();
		List<Category> parent=categoryservice.findparent_id();
		System.out.println(parent);
		request.setAttribute("parent", parent);
		request.getRequestDispatcher("mng/category/add_category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
	
		
		Category  category=new Category();
		
		
		
		
		try {
		
			String parent_id= request.getParameter("parent_id");
			category.setParent_id(Integer.parseInt(parent_id));
			String name= request.getParameter("name");
			category.setName(name);
			String status= request.getParameter("status");
			category.setStatus(Integer.parseInt(status));
			String sort_order= request.getParameter("sort_order");
			category.setSort_order(Integer.parseInt(sort_order));
	
		}catch(NumberFormatException e) {
			
			e.printStackTrace();
			return;
		}
		
		
		String create_time= request.getParameter("create_time");
		//System.out.println("create_time="+create_time);
		String update_time= request.getParameter("update_time");
		//System.out.println("update_time="+update_time);
		
		//½«×Ö·û´®×ªjava.util.Date
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date ct=format.parse(create_time);
			category.setCreate_time(ct);
			Date ut=format.parse(update_time);
			category.setUpdate_time(ut);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//emp.setHiredate(hiredate);
		
		
	    categoryService categoryservice=categoryServiceImpl.getIstance();
	    int result=categoryservice.addcategory(category);
		
		
		
		if(result>0) {
		request.getRequestDispatcher("page.do?pageNo=1").forward(request, response);
		}else {
			
		}
		}

}
