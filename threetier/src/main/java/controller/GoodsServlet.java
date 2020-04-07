package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.SerialVersionUID;

import com.octopus.biz.GoodsBiz;
import com.octopus.biz.impl.GoodsBizImpl;
import com.octopus.entiy.Goods;

@WebServlet("/goodsList")
public class GoodsServlet extends HttpServlet {
	private static final long SerialVersionUID = 7L;
	private GoodsBiz biz = new GoodsBizImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取参数
		req.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		// 调用业务代码
		List<Goods> list = biz.query(keyword);
		// 将数据转给页面显示
		req.setAttribute("data", list);
		req.getRequestDispatcher("goodsList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
