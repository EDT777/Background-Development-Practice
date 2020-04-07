package 连接;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class StatementDemo {
	public static void main(String[] args) {
		//增加数据
		//String sql ="insert into products(name,description,count,price)values('菠萝蜜','好吃',100,12)";
		//更新数据
		//String name="哈密瓜";
		//String sql ="update products set name=? where id=?";
		//删除数据
		//String sql ="delete from products where id=2";
		String sql="insert into products(name,count,price)values(?,?,?)";
		try(Connection conn=CreateDbConnection.getConn();
				PreparedStatement st =conn.prepareStatement(sql)//创建statement
				){ //执行插入
			//关闭自动提交
			conn.setAutoCommit(false);
			Date d1 = new Date();
			for(int i=1;i<=30000;i++) {
				st.setString(1, "新商品"+i);
				st.setInt(2, i);
				st.setDouble(3, Math.random()*100);
				//执行语句
				//st.executeUpdate();
				//添加一个批处理任务
				st.addBatch();
				
			}
			//执行批处理任务
			st.executeBatch();
			//手动提交数据
			conn.commit();
			Date d2 = new Date();
			System.out.println("花费了："+(d2.getTime()-d1.getTime())/1000+"秒");

			int count =st.executeUpdate();
			System.out.println(count);
			if(count>0) {
				System.out.println("操作成功");
			}else {
				System.out.println("操作失败");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
