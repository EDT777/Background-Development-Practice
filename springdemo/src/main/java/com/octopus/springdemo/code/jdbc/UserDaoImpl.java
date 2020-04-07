package com.octopus.springdemo.code.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate template;

	@Override
	public UserInfo findById(Long id) {
		String sql = "select * from user_info where id =" + id;
		UserInfo u = template.queryForObject(sql, new UserInfoMapper());

		return u;
	}

	@Override
	public List<UserInfo> findAll() {
		String sql = "select * from user_info";
		List<UserInfo> users = template.query(sql, new UserInfoMapper());

		return users;
	}

	@Override
	public List<UserInfo> findByUsername(String username) {
		String sql = "select * from user_info where name=? and user_delete=?";
		List<UserInfo> users = template.query(sql, new UserInfoMapper(), username, 0);

		return users;
	}

	@Override
	public int insert(UserInfo user) {
		String sql = "insert into user_info (user_birthday,user_delete,user_name,user_point,user_pwd,user_status)"
				+ "values(?,?,?,?,?,?)";
		int n = this.template.update(sql, user.getUserBirthday(), user.getUserDelete(), user.getUserName(),
				user.getUserPoint(), user.getUserPwd(), user.getUserStatus());
		
		if(n>0) {
			Long id = this.template.queryForObject("select  last_insert_id()",Long.class);
			user.setId(id);
		}
		return n;
	}

	@Override
	public int count() {
		String sql = "select * count(*) from user_info";

		return this.template.queryForObject(sql, Integer.class);
	}

	public static class UserInfoMapper implements RowMapper<UserInfo>{

		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		 	UserInfo u = new UserInfo();
		 	u.setId(rs.getLong("id"));
		 	u.setUserBirthday(rs.getTimestamp("user_birthday"));
		 	u.setUserDelete(rs.getInt("user_delete"));
		 	u.setUserName(rs.getString("user_name"));
		 	u.setUserPoint(rs.getInt("user_point"));
		 	u.setUserPwd(rs.getString("user_pwd"));
		 	u.setUserStatus(rs.getInt("user_status"));
			return u;
		}
	}
}
