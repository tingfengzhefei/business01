package com.neusoft.common;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	
		private static Properties ps=new Properties();
		private static Connection conn=null;
		static {
			//���������ļ�·��
			InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		//��������
			try {
				ps.load(is);
				Class.forName(ps.getProperty("driver"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//��ȡ����
		public static Connection getConnection() throws SQLException {
			
			conn=DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));
			return conn;	
		}
	
		//�ر�����
		//���¹رշ���
		public static void Close(Connection conn,Statement pst) throws SQLException {
			conn.close();
			pst.close();
		}
		public static void Close(Connection conn,Statement st,ResultSet rs) throws SQLException {
			conn.close();
			st.close();
			rs.close();
		}
		public static void Close(Connection conn,PreparedStatement pst,ResultSet rs) throws SQLException {
			conn.close();
			pst.close();
			rs.close();
		}
		
}		
