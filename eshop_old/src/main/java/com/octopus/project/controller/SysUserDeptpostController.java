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

import com.octopus.project.domain.SysUserDeptpostDO;
import com.octopus.project.service.SysUserDeptpostService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 用户与部门岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysUserDeptpost")
public class SysUserDeptpostController {
	@Autowired
	private SysUserDeptpostService sysUserDeptpostService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysUserDeptpostDO> sysUserDeptpostList = sysUserDeptpostService.list(query);
		int total = sysUserDeptpostService.count(query);
		PageUtils pageUtils = new PageUtils(sysUserDeptpostList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysUserDeptpost/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysUserDeptpost/sysUserDeptpost";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		SysUserDeptpostDO sysUserDeptpost = sysUserDeptpostService.get(id);
		model.addAttribute("sysUserDeptpost", sysUserDeptpost);
	    return "project/sysUserDeptpost/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysUserDeptpostDO sysUserDeptpost){
		if(sysUserDeptpostService.save(sysUserDeptpost)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysUserDeptpostDO sysUserDeptpost){
		sysUserDeptpostService.update(sysUserDeptpost);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sysUserDeptpostService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] ids){
		sysUserDeptpostService.batchRemove(ids);
		return R.ok();
	}
	
}
