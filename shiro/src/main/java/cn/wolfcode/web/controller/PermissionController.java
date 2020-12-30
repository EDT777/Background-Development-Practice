package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    private IPermissionService permissionService;

    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", permissionService.query(qo));
        return "permission/list"; // /WEB-INF/views/permission/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            permissionService.delete(id);
        }
        return "redirect:/permission/list";
    }


    @RequestMapping("/reload")
    @ResponseBody
    public JsonResult reload() {
        permissionService.reload();
        return new JsonResult();
    }


}
