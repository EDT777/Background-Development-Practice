package com.octopus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.octopus.dao.UserInfoDAO;
import com.octopus.entity.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {
				
	@Override
	public UserInfo findByUserName(String userName) {
//		String sql ="select * from user_info where user_name ='" + userName+"'";
//		System.out.println(sql);
		String sql ="select * from user_info where user_name =?";
		Object[] params = new Object[] {userName};
		ResultSet rs = null;
		UserInfo user = null;
		try {
			rs = DBUtil.executeQuery(sql,params);
			if (rs.next()) {
				user = new UserInfo();
				user.setId(rs.getLong("id"));
				user.setUserBirthday(rs.getDate("user_birthday"));
				user.setUserDelete(rs.getInt("user_delete"));
				user.setUserName(userName);
				user.setUserPoint(rs.getInt("user_point"));
				user.setUserPwd(rs.getString("user_pwd"));
				user.setUserStatus(rs.getInt("user_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				DBUtil.closeResouce(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	public static void main(String[] args) {
		UserInfoDAO dao = new UserInfoDAOImpl();
		UserInfo userInfo= dao.findByUserName("' or 1=1  or ''='");
		System.out.println(userInfo);
	}

}
