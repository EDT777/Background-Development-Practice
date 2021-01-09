package cn.wolfcode.web.controller;

import cn.wolfcode.enums.ConsumptionReportGroupTypeEnum;
import cn.wolfcode.enums.ConsumptionStatusEnum;
import cn.wolfcode.qo.ConsumptionReportQueryObject;
import cn.wolfcode.service.IBusinessService;
import cn.wolfcode.service.IConsumptionReportService;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumptionReport")
public class ConsumptionReportController {

    @Autowired
    private IConsumptionReportService consumptionReportService;

    @Autowired
    private IBusinessService businessService;

    @RequestMapping("/list")
    public String list(Model model,@ModelAttribute("qo") ConsumptionReportQueryObject qo){
        model.addAttribute("pageInfo",consumptionReportService.query(qo));
        model.addAttribute("enums", ConsumptionReportGroupTypeEnum.values());
        model.addAttribute("statusEnums", ConsumptionStatusEnum.values());
        model.addAttribute("businesses",businessService.listAll());
        return "consumptionReport/list";
    }

    @RequestMapping("/listBar")
    public String listBar(Model model,@ModelAttribute("qo") ConsumptionReportQueryObject qo){
        //查询分组统计的数据（不分页）
        List<Map> list = consumptionReportService.selectAll(qo);
//        1.定义5个新的集合，用于存放x轴和y轴的数据
        ArrayList<Object> xList = new ArrayList<>(); //分组类型
        ArrayList<Object> numberList = new ArrayList<>(); //总订单数
        ArrayList<Object> totalList = new ArrayList<>(); //总消费金额
        ArrayList<Object> discountList = new ArrayList<>(); //总优惠金额
        ArrayList<Object> payList = new ArrayList<>(); //总实收金额
//        2.遍历list集合获取每一个map
        for (Map map : list) {
            //从map中获取不同的数据，分别放入指定的集合中
            xList.add(map.get("groupType"));
            numberList.add(map.get("number"));
            totalList.add(map.get("total"));
            discountList.add(map.get("discount"));
            payList.add(map.get("pay"));
        }
        //共享到页面
        model.addAttribute("xList", JSON.toJSONString(xList));
        model.addAttribute("numberList",JSON.toJSONString(numberList));
        model.addAttribute("totalList",JSON.toJSONString(totalList));
        model.addAttribute("discountList",JSON.toJSONString(discountList));
        model.addAttribute("payList",JSON.toJSONString(payList));
        return "consumptionReport/listBar";
    }



}
