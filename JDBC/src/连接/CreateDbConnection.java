package 连接;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class CreateDbConnection {
	public static void main(String[] args) {
			getConn();
	}
	// 连接字符串

	// 获取数据库连接
	public static Connection getConn() {
		
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/textdb";
		String username = "root";
		String password = "19980220";
		// 加载驱动包
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 建立连接
		try {
			Properties p = new Properties();
			p.setProperty("user", "root");
			p.setProperty("password", "19980220");
			p.setProperty("useSSL", "false");
			p.setProperty("characterEncoding", "utf-8");
			
			 conn = DriverManager.getConnection(url,p);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return conn;
	}
}
