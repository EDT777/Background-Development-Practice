package com.octopus.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��ʾ��ν������ݿ������
 * 
 * @author hw
 *
 */
public class CreateDbConnection {
	public static void main(String[] args) {
		Connection conn = getConn();

		// ���岽�����ɹ��ͳ���
		System.out.println(conn);

	}

	public static Connection getConn() {
		Connection conn = null;
		// ��һ�������������

		// �ڶ�����׼�������Ӳ���
		String username = "root";
		String password = "Wobugaosunimima123$";
		// �����������Ǹ���JDBC���������Ҫ��ʵ�������ĸ�
		String driverClassName = "com.mysql.jdbc.Driver";
		// ���ĸ�����������Ŀ��Ļ�����Ϣ�����������ַ���url
		String url = "jdbc:mysql://localhost:3306/shop1905";
		
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
		//�������Ҫ�������Ӹ����������ܹر�
//		 finally {
//			if (conn != null) {
//				// ��������ʹ���������Ҫ�ر�
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return conn;
	}
}
