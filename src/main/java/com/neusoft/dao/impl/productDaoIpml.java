package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.common.DBUtils;

import com.neusoft.dao.productDao;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;



public class productDaoIpml implements productDao {

	
	 /**
     * 单例设计模式
     * */
	private static  productDao  productdao=null;
	
	private  productDaoIpml() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized static productDao  getIstance() {
		if (productdao==null) {
			productdao=new productDaoIpml();
			
		}
		return productdao;
		
		
	}
	
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		List<Product> list=new ArrayList<Product>();
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select id,category_id,name,Subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time from product");
			
			rs=pst.executeQuery();
		     while(rs.next()) {
		    	 Product product =new Product(rs.getInt("id"),rs.getInt("category_id"),rs.getString("name"),rs.getString("Subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getInt("status"),rs.getDate("create_time"),rs.getDate("update_time"));
		    	   list.add(product);
		    	   
		       } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	@Override
	public int deleteproduct(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("delete from product where id=?");
			pst.setInt(1,id);
			
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return 0;
	}

	@Override
	public int addproduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("insert into product(category_id,name,Subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time ) values(?,?,?,?,?,?,?,?,?,?,?)");
	
			
			 pst.setInt(1, product.getCategory_id());
			 pst.setString(2, product.getName());
			 pst.setString(3, product.getSubtitle());
			 pst.setString(4, product.getMain_image());
			 pst.setString(5, product.getSub_images());
			 pst.setString(6, product.getDetail());
			 pst.setBigDecimal(7, product.getPrice());
			 pst.setInt(8, product.getStock());
			 pst.setInt(9, product.getStatus());
			 pst.setDate(10, new Date(product.getCreate_time().getTime()));
			 pst.setDate(11, new Date(product.getUpdate_time().getTime()));
	
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	
	}

	@Override
	public Product findproduct(Integer id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		 Product product =null;
		
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select id,category_id,name,Subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time from product where id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
		     if(rs.next()) {
		    	 product =new Product(rs.getInt("id"),rs.getInt("category_id"),rs.getString("name"),rs.getString("Subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getInt("status"),rs.getDate("create_time"),rs.getDate("update_time"));
		    	
		    	   
		       } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		
		
		return product;
	}

	@Override
	public int updateproduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("update product set category_id=?, name=?,subtitle=?,main_image=?,sub_images=?, detail=?,price=?,stock=?,status=?,create_time=?,update_time=? where id=? ");
	
			 pst.setInt(1, product.getCategory_id());
			 pst.setString(2, product.getName());
			 pst.setString(3, product.getSubtitle());
			 pst.setString(4, product.getMain_image());
			 pst.setString(5, product.getSub_images());
			 pst.setString(6, product.getDetail());
			 pst.setBigDecimal(7, product.getPrice());
			 pst.setInt(8, product.getStock());
			 pst.setInt(9, product.getStatus());
			 pst.setDate(10, new Date(product.getCreate_time().getTime()));
			 pst.setDate(11, new Date(product.getUpdate_time().getTime()));
			 pst.setInt(12, product.getId());
	
			return  pst.executeUpdate();
			
			 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	

	@Override
	public List<Category>  findcategory() {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		
		List<Category> list=new ArrayList<Category>();
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select id,parent_id,name,status,sort_order,create_time,update_time from category");
			
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(category);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
		

	}

	@Override
	public PageModel<Product> findcategorybypage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		PageModel<Product> pageModel=new PageModel<Product>();
		
		try {
			conn=DBUtils.getConnection();
			
			//查询总记录
			pst=conn.prepareStatement("select count(id) from product");
			rs= pst.executeQuery();
			
			if(rs.next()) {
				
			int totalCount=rs.getInt(1);
			//计算多少页
			int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
			pageModel.setTotalpage(totalpage);
			}
			
			
			
			String sql="select id,category_id,name,Subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time from product limit ?,? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			List<Product> list= new ArrayList<Product>();
			while (rs.next()) {
				 Product product =new Product(rs.getInt("id"),rs.getInt("category_id"),rs.getString("name"),rs.getString("Subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getInt("status"),rs.getDate("create_time"),rs.getDate("update_time"));
		    	   list.add(product);
				
				
			}
			pageModel.setData(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pageModel;
	}

	@Override
	public Long getStock(Integer id) {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select stock from product where id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
		    if (rs.next()) {
		    	Long s=rs.getLong("stock");
		    	return s;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	
		
		
	
		
	
	}

	@Override
	public int reduceStock(Integer id, Integer quantity) {
	
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		 
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("update product set stock=stock-? where id=?");
			pst.setInt(1,quantity);
			pst.setInt(2, id);
			
	
			return  pst.executeUpdate();
			
			 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
		
		
	}


	

	


}
