package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Appointment;
import cn.wolfcode.domain.Consumption;
import cn.wolfcode.domain.ConsumptionItem;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IAppointmentService;
import cn.wolfcode.service.IBusinessService;
import cn.wolfcode.service.IConsumptionItemService;
import cn.wolfcode.service.IConsumptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/consumption")
public class ConsumptionController {

    private IConsumptionService consumptionService;

    @Autowired
    private IConsumptionItemService consumptionItemService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    public void setConsumptionService(IConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", consumptionService.query(qo));
        return "consumption/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            consumptionService.delete(id);
        }
        return "redirect:/consumption/list";
    }

    @RequestMapping("/input")
    public String input(Long id, Model model) {
        model.addAttribute("businesses",businessService.listAll());

        if (id != null) {
            Consumption consumption = consumptionService.get(id);
            //根据结算单的流水号查询结算单明细
            List<ConsumptionItem> items = consumptionItemService.listAll(consumption.getCno());
            model.addAttribute("items", items);
            model.addAttribute("consumption", consumption);
        }
        return "consumption/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Consumption consumption) {
        if (consumption.getId() == null) {
            consumptionService.save(consumption);
        } else {
            consumptionService.update(consumption);
        }
        return "redirect:/consumption/list";
    }

    @RequestMapping("/saveByAppointmentAno")
    @ResponseBody
    public JsonResult saveByAppointmentAno(String ano) { //预约单流水号
        JsonResult jsonResult = new JsonResult();
        if(ano!=null){
            Consumption consumption = consumptionService.saveByAppointmentAno(ano);
            jsonResult.setData(consumption.getId()); //把结算单的id带回前端
        }
        return jsonResult;
    }

}
