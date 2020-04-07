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

import com.octopus.project.domain.SysDeptDO;
import com.octopus.project.service.SysDeptService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 部门管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysDept")
public class SysDeptController {
	@Autowired
	private SysDeptService sysDeptService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysDeptDO> sysDeptList = sysDeptService.list(query);
		int total = sysDeptService.count(query);
		PageUtils pageUtils = new PageUtils(sysDeptList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysDept/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysDept/sysDept";
	}

	@RequestMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Long deptId,Model model){
		SysDeptDO sysDept = sysDeptService.get(deptId);
		model.addAttribute("sysDept", sysDept);
	    return "project/sysDept/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysDeptDO sysDept){
		if(sysDeptService.save(sysDept)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysDeptDO sysDept){
		sysDeptService.update(sysDept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long deptId){
		if(sysDeptService.remove(deptId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] deptIds){
		sysDeptService.batchRemove(deptIds);
		return R.ok();
	}
	
}
