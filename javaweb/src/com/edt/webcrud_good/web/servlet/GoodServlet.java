package com.edt.webcrud_good.web.servlet;

import com.edt.webcrud_product.util.StringUtil;
import com.edt.webcrud_good.dao.IGoodDao;
import com.edt.webcrud_good.dao.impl.GoodDaoImpl;
import com.edt.webcrud_good.domain.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/good")
public class GoodServlet extends HttpServlet {
    private IGoodDao goodDao = new GoodDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("input".equals(cmd)) {
            input(req, resp);
        } else if ("saveOrUpdate".equals(cmd)) {
            saveOrUpdate(req, resp);
        } else {
            list(req, resp);
        }

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.接收请求
//        2.调用方法来处理请求
        List<Good> list = goodDao.selectList();
//        设置共享数据
        req.setAttribute("list", list);
//        3.控制跳转
        req.getRequestDispatcher("/WEB-INF/views/good/list.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.接收请求
        Long id = Long.valueOf(req.getParameter("id"));
        //        2.调用方法来处理请求
        goodDao.delete(id);
        //        3.控制跳转
        resp.sendRedirect("/good");
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      获取id的值,来判断是添加还是修改操作
        String strId = req.getParameter("id");
        //接收请求参数并封装成对象
        Good g = new Good();
        //接收req中的参数,封装到传入Good 对象中
        try {
            req2Good(req, g);
        } catch (ParseException e) {
            System.out.println("传值封装对象发生了错误");
            e.printStackTrace();
        }
        //调用方法来处理请求
        if (StringUtil.hasLength(strId)) {  //有id则做修改操作
            g.setId(Long.valueOf(strId));
            goodDao.update(g);
        } else {//无id则做新增操作
            goodDao.insert(g);
        }

        //控制跳转
        resp.sendRedirect("/good"); //这里必须重定向, 不然会死循环无限增,没有数据共享一律用重定向
    }

    //接收req中的参数,封装到传入Good 对象中
    private void req2Good(HttpServletRequest req, Good g) throws ParseException {
        String GoodName = req.getParameter("name");
        g.setName(GoodName);
        String price = req.getParameter("price");
        if (StringUtil.hasLength(price)) {
            g.setPrice(Float.valueOf(price));
        }
        String detail = req.getParameter("detail");
        g.setDetail(detail);
        String createTime = req.getParameter("createTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =sdf.parse(createTime);
        g.setCreateTime(date);

    }

    protected void input(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的数据id   通过是否有id来判断是添加还是修改操作
        String strId = req.getParameter("id");
        if (StringUtil.hasLength(strId)) {
            Good g = goodDao.selectOne(Long.valueOf(strId));
            //共享给input.jsp
            req.setAttribute("good", g);
        }
        Date d = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);
        req.setAttribute("date", date);
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/views/good/input.jsp").forward(req, resp);
    }
}
