package cn.wolfcode.web.controller;

import cn.wolfcode.domain.ConsumptionItem;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IConsumptionItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/consumptionItem")
public class ConsumptionItemController {

    private IConsumptionItemService consumptionItemService;

    @Autowired
    public void setConsumptionItemService(IConsumptionItemService consumptionItemService) {
        this.consumptionItemService = consumptionItemService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", consumptionItemService.query(qo));
        return "consumptionItem/list"; // /WEB-INF/views/consumptionItem/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            consumptionItemService.delete(id);
        }
        return "redirect:/consumptionItem/list";
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(ConsumptionItem consumptionItem) {
        if (consumptionItem.getId() == null) {
            consumptionItemService.save(consumptionItem);
        } else {
            consumptionItemService.update(consumptionItem);
        }
        return new JsonResult();
    }

}
