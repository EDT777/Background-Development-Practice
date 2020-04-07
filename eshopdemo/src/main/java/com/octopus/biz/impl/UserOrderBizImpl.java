package com.octopus.biz.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.octopus.biz.UserOrderBiz;
import com.octopus.dao.GenericDAO;
import com.octopus.dao.GenericDAOImpl;
import com.octopus.entity.OrderDetail;
import com.octopus.entity.OrderInfo;

public class UserOrderBizImpl implements UserOrderBiz {
	private GenericDAO<OrderInfo> orderInfoDao = new GenericDAOImpl<OrderInfo>(OrderInfo.class);
	private GenericDAO<OrderDetail> orderDetailDao = new GenericDAOImpl<OrderDetail>(OrderDetail.class);

	/**
	 * 
	 * @param userId  创建订单的用户
	 * @param details 要添加到订单的商品列表
	 * @return
	 */
	@Override
	public Long createOrder(long userId, String address, String contactName, String mobile, List<OrderDetail> details) {
		// 创建订单
		BigDecimal total = BigDecimal.valueOf(0.0);
		for (OrderDetail od : details) {
			total = total.add(od.getPrice());
		}
		OrderInfo order = new OrderInfo();
		order.setAddress(address);
		order.setContactName(contactName);
		order.setMobile(mobile);
		order.setState(UserOrderBiz.CREATED);
		order.setTotalPrice(total);
		order.setMakeDate(new Timestamp(new Date().getTime()));
		order.setUserId(userId);
		Long orderId = this.orderInfoDao.insert(order);

		// 创建订单详情
		for (OrderDetail od : details) {
			od.setOrderId(orderId);
			this.orderDetailDao.insert(od);
		}

		return orderId;
	}

	/**
	 * 
	 * @param keyword  查找关键字，可以为商品名称，收货人或者收货电话
	 * @param fromDate 下单开始日期
	 * @param toDate   下单截止日期
	 * @return
	 */
	@Override
	public List<OrderInfo> findOrders(String keyword, Date fromDate, Date toDate, int pageSize, int pageNum) {
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		String where = " 1=1 and ( id in (" + "	select order_id from order_detail where product_id in ( "
				+ "		select id from product where name like ?) " + "	)" + "or contact_name like ? "
				+ "or mobile like ?)";
		if (fromDate == null) {
			fromDate = new Date(0);// 1970年
		}
		if (toDate == null) {
			toDate = new Date(1000L * 3600L * 24L * 365L * 100L);// 2070年
		}
		where += " and make_date between ? and ?";
		keyword = "%" + keyword + "%";
		Object[] params = new Object[] { keyword, keyword, keyword, fromDate, toDate };
		list = this.orderInfoDao.find(where, params, pageSize, pageNum);
		for (OrderInfo od : list) {
			od.setOrderDetails(orderDetailDao.find("order_id=?", new Object[] { od.getId() }, 100, 1));
		}
		return list;
	}

	/**
	 * 确认收货
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 */
	@Override
	public int checkRecived(int orderId, int userId) {
		throw new RuntimeException("功能尚未实现");
	}

}
