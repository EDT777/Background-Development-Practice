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

import com.octopus.project.domain.SysRoleDO;
import com.octopus.project.service.SysRoleService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 角色
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysRole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysRoleDO> sysRoleList = sysRoleService.list(query);
		int total = sysRoleService.count(query);
		PageUtils pageUtils = new PageUtils(sysRoleList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysRole/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysRole/sysRole";
	}

	@RequestMapping("/edit/{roleId}")
	public String edit(@PathVariable("roleId") Long roleId,Model model){
		SysRoleDO sysRole = sysRoleService.get(roleId);
		model.addAttribute("sysRole", sysRole);
	    return "project/sysRole/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysRoleDO sysRole){
		if(sysRoleService.save(sysRole)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysRoleDO sysRole){
		sysRoleService.update(sysRole);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long roleId){
		if(sysRoleService.remove(roleId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] roleIds){
		sysRoleService.batchRemove(roleIds);
		return R.ok();
	}
	
}
