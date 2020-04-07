package com.octopus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.octopus.dao.GoodsDao;
import com.octopus.entiy.Goods;

@Component//spring认识的注解,标记了这个注解的都会被spring扫描为bean的定义
public class GoodsDaoImpl implements GoodsDao{

	@Override
	public Goods get(Long id) {
		if(id==null) {
			return null;
		}
		
		String sql="select * from goods where id="+id;
		ResultSet rs=DBUtil.executeQuery(sql, null);
		try{if(rs.next()) {
			return readFromResultSet(rs);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResouce(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	private Goods readFromResultSet(ResultSet rs) throws SQLException {
		Goods g = new Goods();
		g.setId(rs.getLong("id"));
		g.setInPrice(rs.getBigDecimal("in_price"));
		g.setName(rs.getString("name"));
		g.setPrice(rs.getBigDecimal("price"));
		g.setPromtionPrice(rs.getBigDecimal("promtion_price"));
		g.setSourceChannel(rs.getString("source_channel"));
		g.setState(rs.getInt("state"));
		g.setType(rs.getString("type"));
		g.setTypeId(rs.getLong("type_id"));
		g.setUpTime(rs.getTimestamp("up_time"));
		return g;
	}

	@Override
	public List<Goods> findBymap(Map<String, Object> params, int pageSize, int pageNum) {
		String sql ="select * from goods where 1=1";
		Object[] paramsData = new Object[params.size()];
		int index = 0;
		if(params.containsKey("id")) {
			sql+=" and id=?";
			paramsData[index++] =params.get("id");
		}
		if(params.containsKey("name")) {
			sql+=" and name like ?";
			paramsData[index++] ="%"+params.get("name")+"%";
		}
		//实际得到几个参数，数组的长度就设定为多少
		paramsData = Arrays.copyOf(paramsData, index);
	           	ResultSet rs=DBUtil.executeQuery(sql, paramsData);
		List<Goods> goods = new ArrayList<Goods>();
		try{
			while(rs.next()) {
				goods.add(readFromResultSet(rs));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResouce(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goods;
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int uodate(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) {
		GoodsDaoImpl dao = new GoodsDaoImpl();
		System.out.println(dao.get(1L));
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name","测试");
		System.out.println(dao.findBymap(params, 10, 1));
	}

}
