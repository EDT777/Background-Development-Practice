package 连接;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//通用操作类
public class DBUtil {
	public static String username = "root";
	public static String password = "19980220";
	public static String url = "jdbc:mysql://localhost:3306/textdb";

	// 创建连接
	public static Connection getConn() {
		Connection conn = null;

		// 加载驱动包
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 建立连接
		try {
			Properties p = new Properties();
			p.setProperty("user", username);
			p.setProperty("password", password);
			p.setProperty("useSSL", "false");
			p.setProperty("characterEncoding", "utf-8");

			conn = DriverManager.getConnection(url, p);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 执行查询
	public static ResultSet executeQuery(String sql) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try { // 获取连接
			conn = getConn();
			// 创建Statement
			st = conn.createStatement();
			// 执行查询
			rs = st.executeQuery(sql);

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 增删改
	public static int executeUpdate(String sql) {

			
			Connection conn =null;
			Statement st = null;
			
			try {
				//获取连接
				conn = getConn();
				st=conn.createStatement();
				int count = st.executeUpdate(sql);
				return count;
			}catch(SQLException e) {
				e.printStackTrace();
				return 0;
			}finally {
				if(st!=null) {
					try {
						st.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn!=null) {
					try {
						st.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			}

	public static void closeResouce(ResultSet rs,Statement st,Connection conn) {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				if(st!=null) {
					try {
						rs.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					if(conn!=null) {
						try {
							rs.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
			}
			
		}

}
}}