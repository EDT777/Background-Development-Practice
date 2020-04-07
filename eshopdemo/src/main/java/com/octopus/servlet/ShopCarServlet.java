package com.octopus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octopus.biz.ProductBiz;
import com.octopus.biz.UserBiz;
import com.octopus.biz.impl.ProductBizImpl;
import com.octopus.biz.impl.UserBizImpl;
import com.octopus.dto.CartItem;
import com.octopus.entity.Product;
import com.octopus.entity.UserInfo;

/**
 * 购物车的实现 实现操作有添加到购物车和显示
 *
 */
@WebServlet("/cart")
public class ShopCarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductBiz productBiz = new ProductBizImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取参数
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");// 这个参数决定了servlet是添加购物车还是显示
		if("add".equals(action)) {
		// 获取要操作的购物车商品id
		Long id =Long.parseLong(req.getParameter("pid"));
		addToCard(req, id);
		}
	}

	private void addToCard(HttpServletRequest req, Long id) {
		//查找对应的商品
		Product p =productBiz.findById(id);
		//查找购物车
		HttpSession session =req.getSession();
		List<CartItem> shopcart =(List<CartItem>) session.getAttribute("SHOPCART");//真正存放购物车对象的容器
	//第一次没有这个容器
		if(shopcart==null) {
			shopcart = new ArrayList<CartItem>(20);
			//保存到session
			session.setAttribute("SHOPCART",shopcart);
		}
		//判断购物车中是否有这个商品
		CartItem ci=null;
		boolean isHasProduct =false;
		for(CartItem item:shopcart) {
			if(item.getProduct().getId().equals(id)) {
				//已经有了
				ci=item;
				isHasProduct = true;
				break;
			}
		}
		if(isHasProduct) {
			//数量+1
			ci.setCount(ci.getCount()+1);
		}else {
			ci=new CartItem();
			ci.setProduct(p);
			ci.setCount(1);
			//加入购物车集合中
			shopcart.add(ci);
		}
		System.out.println("添加到购物车成功:"+shopcart);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
