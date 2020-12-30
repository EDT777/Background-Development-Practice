package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.domain.Role;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.service.IPermissionService;
import cn.wolfcode.service.IRoleService;
import cn.wolfcode.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;
    
    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
    
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo){
        model.addAttribute("pageInfo", roleService.query(qo));
        return "role/list"; // /WEB-INF/views/role/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            roleService.delete(id);
        }
        // localhost/role/list.do
        return "redirect:/role/list";
    }

    @RequestMapping("/input")
    public String input(Long id, Model model) {
        List<Permission> permissions = permissionService.listAll();
        model.addAttribute("permissions",permissions);

        if (id != null) {
            model.addAttribute("role", roleService.get(id));
        }
        return "role/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role,Long[] ids) {
        if (role.getId() == null) {
            roleService.save(role,ids);
        } else {
            roleService.update(role,ids);
        }
        return "redirect:/role/list";
    }

}
