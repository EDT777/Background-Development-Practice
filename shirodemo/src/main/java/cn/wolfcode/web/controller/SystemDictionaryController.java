package cn.wolfcode.web.controller;

import cn.wolfcode.domain.SystemDictionary;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.ISystemDictionaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemDictionary")
public class SystemDictionaryController {

    private ISystemDictionaryService systemDictionaryService;

    @Autowired
    public void setSystemDictionaryService(ISystemDictionaryService systemDictionaryService) {
        this.systemDictionaryService = systemDictionaryService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", systemDictionaryService.query(qo));
        return "systemDictionary/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            systemDictionaryService.delete(id);
        }
        return "redirect:/systemDictionary/list";
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(SystemDictionary systemDictionary) {
        if (systemDictionary.getId() == null) {
            systemDictionaryService.save(systemDictionary);
        } else {
            systemDictionaryService.update(systemDictionary);
        }
        return new JsonResult();
    }

}
