package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Business;
import cn.wolfcode.domain.SystemDictionaryItem;
import cn.wolfcode.service.IBusinessService;
import cn.wolfcode.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("/index")
    public String index(Model model){
        //查询总店数据并共享到页面
        List<Business> businesses = businessService.selectByMainStore(true);
        model.addAttribute("business",businesses.get(0));
        //查询所有店铺信息
        List<Business> list = businessService.listAll();
        model.addAttribute("list",list);
     /*   //查询业务大类的明细
        List<SystemDictionaryItem> items = systemDictionaryItemService.selectByTypeSn("business");
        model.addAttribute("items",items);*/
        return "index";
    }

}
