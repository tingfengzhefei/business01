package com.neusoft.controller;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.neusoft.entity.Product;
import com.neusoft.service.productService;

import com.neusoft.service.impl.productServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/Add.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
      
		productService productservice=productServiceImpl.getIstance();
		List<Category>   categories=productservice.findcategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("mng/product/add.jsp").forward(request, response);
		
	}
		
		
		
	
		
		
		
		
	
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
	
		
		Product  product=new Product();
		
		
		
		
		try {
			
		
			String category_id= request.getParameter("id");
			System.out.println(category_id);
			product.setCategory_id(Integer.parseInt(category_id));
			String name= request.getParameter("name");
			product.setName(name);
			String main_image= request.getParameter("main_image");
			product.setMain_image(main_image);
			String sub_images= request.getParameter("sub_images");
			product.setSub_images(sub_images);
			String detail= request.getParameter("detail");
			product.setDetail(detail);
			
			String price= request.getParameter("price");
			BigDecimal bd=new BigDecimal(price);
			product.setPrice(bd);
			
			String stock= request.getParameter("stock");
			product.setStock(Integer.parseInt(stock));
			
			String status= request.getParameter("status");
			product.setStatus(Integer.parseInt(status));	
			
			
			
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		
		
		String create_time= request.getParameter("create_time");
		
		String update_time= request.getParameter("update_time");
	
		//将字符串转java.util.Date
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date ct=format.parse(create_time);
			product.setCreate_time(ct);
			Date ut=format.parse(update_time);
			product.setUpdate_time(ut);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//emp.setHiredate(hiredate);
		
		
	    productService productservice=productServiceImpl.getIstance();
		int result=productservice.addproduct(product);
		
		
		if(result>0) {//添加成功,跳转到列表页面
			request.getRequestDispatcher("Page.do?pageNo=1").forward(request, response);
		}else {//添加失败
			doGet(request,response);
		}
			
			
		
		
	}

}
