package com.octopus.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.octopus.dao.GoodsDAO;
import com.octopus.entity.Goods;
import com.octopus.entity.GoodsType;

/**
 * 商品数据操作的实现类
 * 
 * @author hw
 *
 */
public class GoodsDaoImpl implements GoodsDAO {

	@Override
	public int insert(Goods goods) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String sql = "insert into goods "
//				+ "(name,price,count,type,up_time,state,source_channel,in_price,promtion_price,type_id)" + "values('"
//				+ goods.getName() + "'," + goods.getPrice() + "," + goods.getCount() + ",'" + goods.getType() + "','"
//				+ sdf.format(new Date()) + "',0,'" + goods.getSourceChannel() + "','" + goods.getInPrice() + "','"
//				+ goods.getPromtionPrice() + "'," + goods.getGoodsType().getId() + ")";
		String sql = "insert into goods "
				+ "(name,price,count,type,up_time,state,source_channel,in_price,promtion_price,type_id)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";// ?是参数占位符
		Object[] params = new Object[] { goods.getName(), goods.getPrice(), goods.getCount(), goods.getType(),
				new Date(), 0, goods.getSourceChannel(), goods.getInPrice(), goods.getPromtionPrice(),
				goods.getGoodsType().getId() };
		return DBUtil.executeUpdate(sql,params);
	}

	@Override
	public int update(Goods goods) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * 拼接SQL注意事项：所有的字符串和日期都要使用''围起来
		 */
		String sql = "update goods " + "set name='" + goods.getName() + "',price='" + goods.getPrice() + "',count="
				+ goods.getCount() + ",type='" + goods.getType() + "',up_time='" + sdf.format(new Date()) + "',state="
				+ goods.getState() + ",source_channel='" + goods.getSourceChannel() + "',in_price=" + goods.getInPrice()
				+ ",promtion_price=" + goods.getPromtionPrice() + ",type_id=" + goods.getGoodsType().getId()
				+ " where id=" + goods.getId();
		System.out.println("更新语句:" + sql);
		return DBUtil.executeUpdate(sql);
	}

	@Override
	public int delete(Long id) {
		String sql = "delete from goods where id=" + id;
		return DBUtil.executeUpdate(sql);
	}

	@Override
	public Goods getById(Long id) {
		String sql = "select name,price,count,type,up_time,state,source_channel,in_price,promtion_price,type_id4"
				+ " from goods where id=" + id;
		ResultSet rs = null;
		try {
			rs = DBUtil.executeQuery(sql);
			if (rs.next()) {
				Goods g = readFromRs(rs);
				return g;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				DBUtil.closeResouce(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Goods readFromRs(ResultSet rs) throws SQLException {
		Goods g = new Goods();
		g.setId(rs.getLong("id"));
		g.setCount(rs.getInt("count"));
		GoodsType goodsType = new GoodsType();
		goodsType.setId(rs.getLong("type_id"));
		g.setGoodsType(goodsType);
		g.setInPrice(rs.getBigDecimal("in_price"));
		g.setPrice(rs.getBigDecimal("price"));
		g.setPromtionPrice(rs.getBigDecimal("promtion_price"));
		g.setSourceChannel(rs.getString("source_channel"));
		g.setName(rs.getString("name"));
		g.setState(rs.getShort("state"));
		g.setType(rs.getString("type"));
		g.setUpTime(rs.getTimestamp("up_time"));
		return g;
	}

	@Override
	public List<Goods> findByWhere(String where, int pageNum, int pageSize) {
		int offset = pageSize * (pageNum - 1);
		String sql = "select * from goods where " + where + " limit " + offset + "," + pageSize;
		List<Goods> goods = new ArrayList<Goods>();
		ResultSet rs = null;
		try {
			rs = DBUtil.executeQuery(sql);
			while (rs.next()) {
				Goods g = readFromRs(rs);
				goods.add(g);
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
		return goods;
	}

	@Override
	public int countByWhere(String where, Object[] params) {
		String sql = "select count(*) from goods where " + where;
		ResultSet rs = null;
		try {
			rs = DBUtil.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);// 统计行数的sql仅有一行数据
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
		return 0;

	}

	public static void main(String[] args) {
		GoodsDaoImpl dao = new GoodsDaoImpl();
		// 测试添加
		GoodsType type = new GoodsType();
		type.setId(1L);
		Goods goods = new Goods(null, "DAO测试", BigDecimal.valueOf(1000.0), 10, "服装", null, (short) 0, "福建",
				BigDecimal.valueOf(100), BigDecimal.valueOf(88.0), type);
		int insert = dao.insert(goods);
		if(insert>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}

		// 测试更新
//		goods.setId(1005L);
//		goods.setName("DAO测试更新");
//		int update = dao.update(goods);
//		if (update > 0) {
//			System.out.println("修改成功");
//		} else {
//			System.out.println("修改失败");
//		}

		// 测试删除
//		int delete = dao.delete(1005L);
//		if (delete > 0) {
//			System.out.println("删除成功");
//		} else {
//			System.out.println("删除失败");
//		}

		// 测试查询
//		String where = "name ='鞋子'";
//		List<Goods> goods1 = dao.findByWhere(where, 1, 10);
//		for (Goods g : goods1) {
//			System.out.println(g);
//		}
	}

}
