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
 * Servlet implementation class UpddateServlet
 */
@WebServlet("/Update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		List<Category>   categories=productservice.findcategory();
		request.setAttribute("categories", categories);
		
		
		
	
		try {
			Product  product= productservice.findproduct(Integer.parseInt(id));
			request.setAttribute("product", product);
			     
			  
			request.getRequestDispatcher("mng/product/update.jsp").forward(request, response);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//System.out.println(request);
	
		Product  product=new Product();

		try {
			String id= request.getParameter("id").trim();
			product.setId(Integer.parseInt(id));
			String category_id= request.getParameter("category_id").trim();
			product.setCategory_id(Integer.parseInt(category_id));
			
			String name= request.getParameter("name").trim();
			product.setName(name);
			String subtitle= request.getParameter("subtitle").trim();
			product.setSubtitle(subtitle);
			
			String main_image= request.getParameter("main_image").trim();
			product.setMain_image(main_image);
			
			String sub_images= request.getParameter("sub_images").trim();
			product.setSub_images(sub_images);
			
			String detail= request.getParameter("detail").trim();
			product.setDetail(detail);
			
			String price= request.getParameter("price").trim();
			BigDecimal bd=new BigDecimal(price);
			product.setPrice(bd);
			
			String stock= request.getParameter("stock").trim();
			product.setStock(Integer.parseInt(stock));
			
			String status= request.getParameter("status").trim();
			product.setStatus(Integer.parseInt(status));	
			
			
			
			
		}catch(NumberFormatException e) {
			
			e.printStackTrace();
		}
		
		
		String create_time= request.getParameter("create_time").trim();
		System.out.println("create_time="+create_time);
		String update_time= request.getParameter("update_time").trim();
		System.out.println("update_time="+update_time);
		
		//½«×Ö·û´®×ªjava.util.Date
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
		
		
		//System.out.println();
		
	    productService productservice=productServiceImpl.getIstance();
		productservice.updateproduct(product);
		
		
	
			request.getRequestDispatcher("Page.do?pageNo=1").forward(request, response);
	
		

		
		
		
	}

}
