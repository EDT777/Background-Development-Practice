package com.octopus.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

/**
 * ��׼�����ݿ⹤���࣬�ṩ��������ɾ�Ĳ鷽��
 * 
 * @author hw
 *
 */
public class DBUtil {

	public static String username = "root";
	public static String password = "19980220";
	public static String driverClassName = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/shop1905?characterEncoding=UTF-8";

	/**
	 * ��������
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;

		// ���������跨����ʵ����������ʵ���ࣩ

		try {
			Class.forName(driverClassName);
			// ���Ĳ�����������
			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * ִ����ɾ��
	 * 
	 * @param sql
	 * @return
	 */

	/**
	 * ִ����ɾ��
	 * 
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			// ��ȡ����
			conn = getConn();
			// ����Statement����
			st = conn.prepareStatement(sql);
			// Ϊÿһ��?������ֵ
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(1 + i, params[i]);// ע��ڼ��������Ǵ�1��ʼ��
				}
			}
			// ִ�����
			int count = st.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ִ�в�ѯ
	 * 
	 * @param sql
	 * @return

	/**
	 * Э���ر���Դ
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void closeResouce(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ResultSet executeQuery(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// ��ȡ����
			conn = getConn();
			// ����Statement
			st = conn.prepareStatement(sql);
			// ������ע��statement
			if (params != null && params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(i + 1, params[i]);
				}
			}
			// ִ�в�ѯ
			rs = st.executeQuery();
			// ��������������
			return rs;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
