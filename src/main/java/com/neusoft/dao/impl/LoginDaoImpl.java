package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.common.DBUtils;
import com.neusoft.dao.LoginDao;
import com.neusoft.entity.User;

public class LoginDaoImpl implements LoginDao {

	@SuppressWarnings("null")
	@Override
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="select username  from user where username=?";
			st=conn.prepareStatement(sql);
			st.setString(1, username);
			rs=st.executeQuery();
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn,st,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return 0;
	}

	@SuppressWarnings("null")
	@Override
	public User findUserByUsernameAndPasswrd(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password,email,phone,question,answer,role,create_time,update_time from user where username=? and password=?";
			st=conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs=st.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				
				//System.out.println(user);
				
				
				return user;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	
	}

	@Override
	public int updateToken(Integer id, String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=? where id=?";
			st=conn.prepareStatement(sql);
			st.setString(1, token);
			st.setInt(2, id);
			return st.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	
	}

	@Override
	public User findUser(String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password,email,phone,question,answer,role,create_time,update_time from user where token=? ";
			st=conn.prepareStatement(sql);
			st.setString(1, token);
			
			rs=st.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				
				//System.out.println(user);
				
				
				 
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		return user;
	}

	

}
