package com.octopus.biz;

import java.util.Date;
import java.util.List;

import com.octopus.entity.OrderDetail;
import com.octopus.entity.OrderInfo;

public interface UserOrderBiz {

	/**
	 * 订单状态：已下单
	 */
	short CREATED = 0;

	/**
	 * 订单状态：表示已付款
	 */
	short PAIED = 1;

	/**
	 * 订单状态：表示申请退款中
	 */
	short REQUEST_REFOUND = 2;

	/**
	 * 订单状态：表示表示已经退款
	 */
	short REFOUND_FINISH = 3;

	/**
	 * 
	 * @param userId  创建订单的用户
	 * @param details 要添加到订单的商品列表
	 * @return
	 */
	Long createOrder(long userId, String address, String contactName, String mobile, List<OrderDetail> details);

	/**
	 * 
	 * @param keyword  查找关键字，可以为商品名称
	 * @param fromDate 开始日期
	 * @param toDate   截止日期
	 * @return
	 */
	List<OrderInfo> findOrders(String keyword, Date fromDate, Date toDate, int pageSize, int pageNum);

	/**
	 * 确认收货
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 */
	int checkRecived(int orderId, int userId);

}