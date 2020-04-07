package com.octopus.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.service.SysMenuService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 菜单管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysMenu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysMenuDO> sysMenuList = sysMenuService.list(query);
		int total = sysMenuService.count(query);
		PageUtils pageUtils = new PageUtils(sysMenuList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysMenu/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysMenu/sysMenu";
	}

	@RequestMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId,Model model){
		SysMenuDO sysMenu = sysMenuService.get(menuId);
		model.addAttribute("sysMenu", sysMenu);
	    return "project/sysMenu/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysMenuDO sysMenu){
		if(sysMenuService.save(sysMenu)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysMenuDO sysMenu){
		sysMenuService.update(sysMenu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long menuId){
		if(sysMenuService.remove(menuId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] menuIds){
		sysMenuService.batchRemove(menuIds);
		return R.ok();
	}
	
}
