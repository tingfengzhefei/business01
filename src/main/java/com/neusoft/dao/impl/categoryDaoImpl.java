package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.common.DBUtils;
import com.neusoft.dao.categoryDao;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;


public class categoryDaoImpl implements categoryDao {
	
	private static categoryDaoImpl categorydao=null;
	private categoryDaoImpl() {
		
	}
	public static categoryDaoImpl  getIstance() {
		if(categorydao==null) {
			categorydao=new categoryDaoImpl();
		}
		return categorydao;
	}
	
	
	
	
	

	@Override
	public List<Category> findAll() {
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
	public int deletecategory(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement  pst=null;
	
		
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("delete from category where id=?");
			pst.setInt(1, id);
			int count=pst.executeUpdate();
		if(count>0) {
			return 1;
		}
			
			
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
	public int addcategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("insert into category(parent_id,name,status,sort_order,create_time,update_time) values(?,?,?,?,?,?)");

			
			 pst.setInt(1, category.getParent_id());
			 pst.setString(2, category.getName());
			 pst.setInt(3, category.getStatus());
			 pst.setInt(4, category.getSort_order());
			 pst.setDate(5, new Date(category.getCreate_time().getTime()));
			 pst.setDate(6, new Date(category.getUpdate_time().getTime()));
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
	public Category findcategory(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		
	Category category=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select id,parent_id,name,status,sort_order,create_time,update_time from category where id=?");
			pst.setInt(1, id);
			
			rs=pst.executeQuery();
			
		if (rs.next()) {
				 category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				
				
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
		
		return category;
	}
	@Override
	public List<Category> findparent_id() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		
		List<Category> list=new ArrayList<Category>();
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select distinct p.id id,p.parent_id parent_id,p.name name,p.status status,p.sort_order sort_order,p.create_time create_time,p.update_time update_time from category c left join category p on  c.parent_id=p.id;");
			
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
	public int updatecategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("update category set parent_id=?,name=?,status=?,sort_order=? where id=?");
            
			
			 pst.setInt(1, category.getParent_id());
			 pst.setString(2, category.getName());
			 pst.setInt(3, category.getStatus());
			 pst.setInt(4, category.getSort_order());
			 pst.setInt(5, category.getId());
			
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
	public PageModel<Category> findcategorybypage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		PageModel<Category> pageModel=new PageModel<Category>();
		
		try {
			conn=DBUtils.getConnection();
			
			//查询总记录
			pst=conn.prepareStatement("select count(id) from category");
			rs= pst.executeQuery();
			
			if(rs.next()) {
				
			int totalCount=rs.getInt(1);
			//计算多少页
			int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
			pageModel.setTotalpage(totalpage);
			}
			
			
			
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category limit ?,? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			List<Category> list= new ArrayList<Category>();
			while (rs.next()) {
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(category);
				
				
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
	

}
