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

import com.octopus.project.domain.SysUserPlusDO;
import com.octopus.project.service.SysUserPlusService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysUserPlus")
public class SysUserPlusController {
	@Autowired
	private SysUserPlusService sysUserPlusService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysUserPlusDO> sysUserPlusList = sysUserPlusService.list(query);
		int total = sysUserPlusService.count(query);
		PageUtils pageUtils = new PageUtils(sysUserPlusList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysUserPlus/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysUserPlus/sysUserPlus";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		SysUserPlusDO sysUserPlus = sysUserPlusService.get(id);
		model.addAttribute("sysUserPlus", sysUserPlus);
	    return "project/sysUserPlus/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysUserPlusDO sysUserPlus){
		if(sysUserPlusService.save(sysUserPlus)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysUserPlusDO sysUserPlus){
		sysUserPlusService.update(sysUserPlus);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sysUserPlusService.remove(id)>0){
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
		sysUserPlusService.batchRemove(ids);
		return R.ok();
	}
	
}
