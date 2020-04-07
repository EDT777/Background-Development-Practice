package com.octopus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octopus.dao.UserInfoDAO;
import com.octopus.dao.impl.GoodsDaoImpl;
import com.octopus.dao.impl.UserInfoDAOImpl;
import com.octopus.entity.Goods;
import com.octopus.entity.UserInfo;
@WebServlet("/goodlist")
public class GoodListServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			GoodsDaoImpl dao =new GoodsDaoImpl();
				List<Goods> list = dao.findByWhere("1=1", 1, 10);
				//数据传递可以使用作用域对象 比如req
				req.setAttribute("data", list);
				//数据如何转交给页面呢？：页面跳转
				req.getRequestDispatcher("GoodList.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		}
}
