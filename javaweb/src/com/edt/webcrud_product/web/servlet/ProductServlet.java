package com.edt.webcrud_product.web.servlet;

import com.edt.webcrud_product.dao.IProductDao;
import com.edt.webcrud_product.dao.impl.ProductDaoImpl;
import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.PageResult;
import com.edt.webcrud_product.qo.ProductQueryObject;
import com.edt.webcrud_product.qo.QueryObject;
import com.edt.webcrud_product.service.IProductService;
import com.edt.webcrud_product.service.impl.ProductServiceImpl;
import com.edt.webcrud_product.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
     private IProductDao productDao = new ProductDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("USER_IN_SESSION")==null){
           req.setAttribute("errorMsg","您没有登录");
           req.getRequestDispatcher("/login.jsp").forward(req,resp);
           return;
        }
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)){
            delete(req, resp);
        }else if ("input".equals(cmd)){
            input(req, resp);
        }else if("saveOrUpdate".equals(cmd)){
            saveOrUpdate(req, resp);
        }else {
            list(req, resp);
        }

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.接收请求
//        2.调用方法来处理请求
        ProductQueryObject qb = new ProductQueryObject();
        String strCurrentPage = req.getParameter("currentPage");
        if (StringUtil.hasLength(strCurrentPage)){
            Integer currentPage = Integer.valueOf(strCurrentPage);
            qb.setCurrentPage(currentPage);
        }
        String strPageSize = req.getParameter("pageSize");
        if (StringUtil.hasLength(strPageSize)){
            Integer pageSize = Integer.valueOf(strPageSize);
            qb.setPageSize(pageSize);
        }
        String strProductName = req.getParameter("productName");
        if (StringUtil.hasLength(strProductName)){
            qb.setProductName(strProductName);
        }
        String minSalePrice = req.getParameter("minSalePrice");
        if (StringUtil.hasLength(minSalePrice)){
            qb.setMinSalePrice(new BigDecimal(minSalePrice));
        }
        String maxSalePrice = req.getParameter("maxSalePrice");
        if (StringUtil.hasLength(maxSalePrice)){
            qb.setMaxSalePrice(new BigDecimal(maxSalePrice));
        }
        PageResult result = productService.query(qb);

//        设置共享数据
        req.setAttribute("pageResult",result);
        req.setAttribute("qb",qb);
//        3.控制跳转
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.接收请求
       Long id = Long.valueOf(req.getParameter("id"));
        //        2.调用方法来处理请求
       productDao.delete(id);
        //        3.控制跳转
       resp.sendRedirect("/product");
    }
    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      获取id的值,来判断是添加还是修改操作
        String strId = req.getParameter("id");
       //接收请求参数并封装成对象
        Product p = new Product();
        //接收req中的参数,封装到传入Product 对象中
        req2product(req,p);
        //调用方法来处理请求
        if (StringUtil.hasLength(strId)){  //有id则做修改操作
            p.setId(Long.valueOf(strId));
            productDao.update(p);
        }else {//无id则做新增操作
            productDao.insert(p);
        }

        //控制跳转
        resp.sendRedirect("/product"); //这里必须重定向, 不然会死循环无限增,没有数据共享一律用重定向
    }
    //接收req中的参数,封装到传入Product 对象中
    private void req2product(HttpServletRequest req, Product p) {
                String productName = req.getParameter("productName");
                p.setProductName(productName);
                String strDirId = req.getParameter("dir_id");
                if (StringUtil.hasLength(strDirId)){
                    p.setDir_id(Long.valueOf(strDirId));
                }
                String strSalePrice =req.getParameter("salePrice");
                if (StringUtil.hasLength(strSalePrice)){
                    p.setSalePrice(new BigDecimal(strSalePrice));
                }
                String supplier =req.getParameter("supplier");
                p.setSupplier(supplier);
                String brand =req.getParameter("brand");
                p.setBrand(brand);
                String strCutoff = req.getParameter("cutoff");
                if (StringUtil.hasLength(strCutoff)){
                    p.setCutoff(new BigDecimal(strCutoff));
                }
                String strCostPrice = req.getParameter("costPrice");
                if (StringUtil.hasLength(strCostPrice)){
                    p.setCostPrice(new BigDecimal(strCostPrice));
                }

    }

    protected void input(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的数据id   通过是否有id来判断是添加还是修改操作
        String strId = req.getParameter("id");
        if (StringUtil.hasLength(strId)){
           Product p = productDao.selectOne(Long.valueOf(strId));
            //共享给input.jsp
            req.setAttribute("product",p);
        }
        //跳转页面
        req.getRequestDispatcher("/WEB-INF/views/product/input.jsp").forward(req,resp);
    }
}
