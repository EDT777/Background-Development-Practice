package com.octopus.spring1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.octopus.spring1.entity.UserInfo;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	/* (non-Javadoc)
	 * @see com.octopus.spring1.dao.UserDao#getById(int)
	 */
	@Override
	public UserInfo getById(int i) {
		UserInfo userInfo = this.getJdbcTemplate().queryForObject("select * from user_info where id=" + i,
				new UserMapper());
		return userInfo;
	}
	
	

	/* (non-Javadoc)
	 * @see com.octopus.spring1.dao.UserDao#findByUserName(java.lang.String)
	 */
	@Override
	public UserInfo findByUserName(String userName) {
		try {
			return this.getJdbcTemplate().queryForObject("select * from user_info where user_name =?", new UserMapper(),
					userName);
		} catch (EmptyResultDataAccessException e) {
			throw e;
//			return null;
			
		}

	}

	/* (non-Javadoc)
	 * @see com.octopus.spring1.dao.UserDao#findAll()
	 */
	@Override
	public List<UserInfo> findAll() {
		return this.getJdbcTemplate().query("select * from user_info", new Object[] {}, new UserMapper());
	}

	/* (non-Javadoc)
	 * @see com.octopus.spring1.dao.UserDao#insert(com.octopus.spring1.entity.UserInfo)
	 */
	@Override
	public int insert(UserInfo user) {
		int update = this.getJdbcTemplate().update(
				"insert into user_info (user_birthday,user_delete,user_name,user_point,user_pwd,user_status) values(?,?,?,?,?,?)",
				user.getUserBirthday(), user.getUserDelete(), user.getUserName(), user.getUserPoint(),
				user.getUserPwd(), user.getUserStatus());
		Long id = this.getJdbcTemplate().queryForObject("select last_insert_id()", Long.class);
		user.setId(id);
		return update;
	}

	public static class UserMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo info = new UserInfo();
			info.setId(rs.getLong("id"));
			info.setUserBirthday(rs.getTimestamp("user_birthday"));
			info.setUserDelete(rs.getInt("user_delete"));
			info.setUserName(rs.getString("user_name"));
			info.setUserPoint(rs.getInt("user_point"));
			info.setUserPwd(rs.getString("user_pwd"));
			info.setUserStatus(rs.getInt("user_status"));
			return info;
		}

	}

}
