package cn.wolfcode.web.controller;

import cn.wolfcode.domain.SystemDictionaryItem;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.qo.SystemDictionaryItemQueryObject;
import cn.wolfcode.service.ISystemDictionaryItemService;
import cn.wolfcode.service.ISystemDictionaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/systemDictionaryItem")
public class SystemDictionaryItemController {

    private ISystemDictionaryItemService systemDictionaryItemService;

    @Autowired
    private ISystemDictionaryService systemDictionaryService;

    @Autowired
    public void setSystemDictionaryItemService(ISystemDictionaryItemService systemDictionaryItemService) {
        this.systemDictionaryItemService = systemDictionaryItemService;
    }

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") SystemDictionaryItemQueryObject qo){
        model.addAttribute("pageInfo", systemDictionaryItemService.query(qo));
        //查所有字典目录
        model.addAttribute("dics",systemDictionaryService.listAll() );
        //查询所有字典明细
        model.addAttribute("items",systemDictionaryItemService.listAll());

        return "systemDictionaryItem/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            systemDictionaryItemService.delete(id);
        }
        return "redirect:/systemDictionaryItem/list";
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(SystemDictionaryItem systemDictionaryItem) {
        if (systemDictionaryItem.getId() == null) {
            systemDictionaryItemService.save(systemDictionaryItem);
        } else {
            systemDictionaryItemService.update(systemDictionaryItem);
        }
        return new JsonResult();
    }

    //根据目录id查询明细集合
    @RequestMapping("/selectByTypeId")
    @ResponseBody
    public List<SystemDictionaryItem> selectByTypeId(Long typeId){
        return systemDictionaryItemService.selectByTypeId(typeId);
    }

    //根据目录编码查询明细集合
    @RequestMapping("/selectByTypeSn")
    @ResponseBody
    public List<SystemDictionaryItem> selectByTypeSn(String sn){
        return systemDictionaryItemService.selectByTypeSn(sn);
    }

    @RequestMapping("/selectByParentId")
    @ResponseBody
    public List<SystemDictionaryItem> selectByParentId(Long id){
        return systemDictionaryItemService.selectByParentId(id);
    }

}
