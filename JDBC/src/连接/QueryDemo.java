package 连接;

import java.sql.*;

public class QueryDemo {
	
	public static void main(String[] args) {
		String sql ="select * from products limit 100";
			//获取连接
		
		try(Connection conn=CreateDbConnection.getConn();
				Statement st =conn.createStatement();//创建statement
				ResultSet rs =st.executeQuery(sql);) //执行查询
		{	
			
			//处理结果集的数据
			while(rs.next()) {
				//处理当前读到的这一行数据
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("name"));//列名取数据
				System.out.println(rs.getDouble("price"));
				System.out.println(rs.getTimestamp("createtime"));
				
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setCreateTime(new Date(rs.getTimestamp("createtime").getTime()));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
