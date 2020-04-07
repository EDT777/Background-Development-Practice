package com.octopus.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//演示jdbcTemplate的基本使用
public class SpringJdbcTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		// 查询
		String sql = "select * from user_info";
		List<UserInfo> list = template.query(sql, new UserInfoRowMapper());
		System.out.println(list);
		// 执行增删改
		String sql1 = "insert into user_info (user_name,user_pwd,user_point,user_delete,user_status,user_birthday)"
				+ "values(?,?,?,?,?,?)";
		int n = template.update(sql1, "测试用户名", "000000", 0, 0, 0, new Date());
		if (n > 0) {
			String sql2 = "select last_insert_id()";
			Long id = template.queryForObject(sql2, Long.class);
			System.out.println("添加成功,新数据的id为"+id);
		} else {
			System.out.println("添加失败");
		}

	}
	
	public static class UserInfoRowMapper implements RowMapper<UserInfo>{
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo user = new UserInfo();
			user.setId(rs.getLong("id"));
			user.setUserBirthday(rs.getTime("user_birthday"));
			user.setUserDelete(rs.getInt("user_delete"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPoint(rs.getInt("user_point"));
			user.setUserPwd(rs.getString("user_pwd"));
			user.setUserStatus(rs.getInt("user_status"));
			return user;
		}
		
	}
}
