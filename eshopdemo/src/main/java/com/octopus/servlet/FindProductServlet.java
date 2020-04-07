package com.octopus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octopus.biz.ProductBiz;
import com.octopus.biz.UserBiz;
import com.octopus.biz.impl.ProductBizImpl;
import com.octopus.biz.impl.UserBizImpl;
import com.octopus.entity.Product;
import com.octopus.entity.UserInfo;

@WebServlet("/product/find")
public class FindProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductBiz productBiz = new ProductBizImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取参数
		req.setCharacterEncoding("UTF-8");
		String keyword=req.getParameter("keyword");
		if(keyword==null) {
			keyword="";
		}
		List<Product> list=productBiz.find(keyword, 10, 1);
		//列表有专门的页面显示
		req.setAttribute("list", list);
		req.getRequestDispatcher("/shop.jsp").forward(req, resp);
		System.out.println("数据查询结束"+list);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
