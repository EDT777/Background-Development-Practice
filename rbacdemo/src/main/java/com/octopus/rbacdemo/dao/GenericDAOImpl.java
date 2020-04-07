package com.octopus.rbacdemo.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octopus.rbacdemo.entity.SysPrivilege;
import com.octopus.rbacdemo.entity.SysRole;
import com.octopus.rbacdemo.entity.SysUser;


/**
 * 泛型化的通用JDBC DAO 注意命名规范，数据库必须采用xxx_yyy格式命名，对应java必须采用xxxYyy命名
 * 
 * @author hw
 *
 * @param <T> 实体类类�?
 */
public class GenericDAOImpl<T> extends GenericDAO<T> {
	@SuppressWarnings("rawtypes")
	private Class clz;//

	public GenericDAOImpl(Class<T> clz) {
		this.clz = clz;
	}

	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanxian?characterEncoding=UTF8&userSSL=false", "root", "19980220");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void closeAll(Connection c, Statement s, ResultSet r) {
		if (r != null) {
			try {
				r.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (s != null) {
			try {
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据id获取对象
	 */
	@Override
	public T getById(int id) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from " + camelNameToDbName(this.clz.getSimpleName()) + " where id=" + id;
		try {
			conn = this.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				return this.getValuesFromResultSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, rs);
		}
		return null;
	}

	/**
	 * 读取结果集并封装到实体类�?
	 * 
	 * @param rs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private T getValuesFromResultSet(ResultSet rs) {
		T t = null;
		try {
			t = (T) this.clz.getConstructor().newInstance();

			Field[] fields = this.clz.getDeclaredFields();
			for (Field f : fields) {
				//跳过被标记为不处理的属�??
				if(f.getAnnotation(NoPersistent.class)!=null) {
					continue;
				}
				String fName = f.getName();

				// 通过属�?�名获得setterName
				String setterName = "set" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
				// 获取setter的类�?
				@SuppressWarnings("rawtypes")
				Class typeP = f.getType();
				// 获取方法
				Method getMtd = this.clz.getMethod(setterName, typeP);
				try {
					Object value = rs.getObject(camelNameToDbName(f.getName()));
					getMtd.invoke(t, value);

				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| SecurityException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<T> find(String where, Object[] params, int pageSize, int pageNum) {
		List<T> list = new ArrayList<T>();

		String sql = "select * from " + camelNameToDbName(this.clz.getSimpleName()) + " where (" + where + ") limit "
				+ (pageNum - 1) * pageSize + "," + pageSize;

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = this.getConn();
			st = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(i + 1, params[i]);
				}
			}
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(this.getValuesFromResultSet(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, rs);
		}

		return list;
	}

	/**
	 * 执行数据更新
	 */
	@Override
	public int update(T t) {

		String tableName = camelNameToDbName(t.getClass().getSimpleName());

		List<String> colNames = new ArrayList<String>();
		List<String> colGetterNames = new ArrayList<String>();
		List<Object> colValues = new ArrayList<Object>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field f : fields) {
			//跳过被标记为不处理的属�??
			if(f.getAnnotation(NoPersistent.class)!=null) {
				continue;
			}
			String fName = f.getName();
			if (!fName.equals("id")) {
				String getterName = "get" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
				colNames.add(camelNameToDbName(fName));
				colGetterNames.add(getterName);
				try {
					Object value = t.getClass().getMethod(getterName).invoke(t);
					colValues.add(value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}

		// 执行真正的更�?
		try {
			Object value = t.getClass().getMethod("getId").invoke(t);
			colValues.add(value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}

		StringBuffer colNamesStr = new StringBuffer(" set ");
		for (String s : colNames) {
			colNamesStr.append(s + "=?,");

		}
		colNamesStr.deleteCharAt(colNamesStr.length() - 1);

		colNamesStr.append(" where id=?");

		String sql = "update " + tableName + colNamesStr;
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement st = null;
		try {

			conn = this.getConn();
			st = conn.prepareStatement(sql);
			// 设置参数
			for (int i = 0; i < colValues.size(); i++) {
				st.setObject(i + 1, colValues.get(i));
			}
			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, null);
		}
		return 0;
	}

	@Override
	/**
	 * 根据id删除
	 */
	public int delete(long id) {

		String sql = "delete from " + this.clz.getSimpleName() + " where id=";
		Connection conn = null;
		Statement st = null;
		try {

			sql = sql + id;
			conn = this.getConn();
			st = conn.createStatement();
			return st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, null);
		}
		return 0;
	}

	@Override
	/**
	 * 数据添加
	 */
	public Long insert(T t) {
		// 获取表名
		String tableName = t.getClass().getSimpleName();

		// 反射生成sql语句
		List<String> colNames = new ArrayList<String>();
		List<String> colGetterNames = new ArrayList<String>();
		List<Object> colValues = new ArrayList<Object>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field f : fields) {
			//跳过被标记为不处理的属�??
			if(f.getAnnotation(NoPersistent.class)!=null) {
				continue;
			}
			String fName = f.getName();
			if (!fName.equals("id")) {
				// 拼出getter名称
				String getterName = "get" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
				colNames.add(fName);
				colGetterNames.add(getterName);
				try {
					Object value = t.getClass().getMethod(getterName).invoke(t);
					colValues.add(value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		StringBuffer colNamesStr = new StringBuffer("(");
		StringBuffer questionMarkStr = new StringBuffer("(");
		for (String s : colNames) {
			colNamesStr.append(camelNameToDbName(s) + ",");
			questionMarkStr.append("?,");
		}
		// 去除�?后的,
		colNamesStr.deleteCharAt(colNamesStr.length() - 1);
		questionMarkStr.deleteCharAt(questionMarkStr.length() - 1);

		// 完善sql语句
		colNamesStr.append(")");
		questionMarkStr.append(")");

		String sql = "insert into " + camelNameToDbName(tableName) + " " + colNamesStr + " values" + questionMarkStr;

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			conn = this.getConn();
			st = conn.prepareStatement(sql);
			// 设置参数
			for (int i = 0; i < colValues.size(); i++) {
				st.setObject(i + 1, colValues.get(i));
			}
			st.executeUpdate();
			st.close();
			st = conn.prepareStatement("select last_insert_id()");
			rs = st.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, rs);
		}
		return 0L;
	}

	/**
	 * 将数据库中的名称转成小骆驼java名称
	 * 
	 * @param dbName
	 * @return
	 */
	public static String dbNameToEntityName(String dbName) {
		String[] words = dbName.split("_");
		if (words.length > 1) {
			String name = words[0].toLowerCase();
			for (int i = 1; i < words.length; i++) {
				name += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
			}
			return name;
		} else {
			return dbName;
		}
	}

	/**
	 * java camel命名转为数据库命�?
	 * 
	 * @param dbName
	 * @return
	 */
	public static String camelNameToDbName(String camelName) {
		if (camelName == null || camelName.length() == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		char[] chars = camelName.toCharArray();
		sb.append(Character.toLowerCase(chars[0]));
		for (int i = 1; i < chars.length; i++) {
			if (Character.isUpperCase(chars[i])) {
				sb.append('_');
				sb.append(Character.toLowerCase(chars[i]));
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 获取满足条件的数据条�?
	 */
	@Override
	public int getCount(String where, Object[] params) {
		String sql = "select count(*) from " + camelNameToDbName(this.clz.getSimpleName()) + " where (" + where + ") ";

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = this.getConn();
			st = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					st.setObject(i + 1, params[i]);
				}
			}
			rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, st, rs);
		}
		return 0;
	}

	/**
	 * 基础测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GenericDAOImpl<SysUser> userDao = new GenericDAOImpl<SysUser>(SysUser.class);
		List<SysUser> list = userDao.find("1=1", null, 10, 1);
		System.out.println(list);
		
		GenericDAOImpl<SysPrivilege> privilegeDao = new GenericDAOImpl<SysPrivilege>(SysPrivilege.class);
		List<SysPrivilege> list2 = privilegeDao.find("1=1",null, 10, 1);
		System.out.println(list2);
		
		GenericDAOImpl<SysRole> roleDao = new GenericDAOImpl<SysRole>(SysRole.class);
		List<SysRole> list3 = roleDao.find("1=1",null, 10, 1);
		System.out.println(list3);
	}

}
