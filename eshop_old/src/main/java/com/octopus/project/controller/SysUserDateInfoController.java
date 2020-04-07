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

import com.octopus.project.domain.SysUserDateInfoDO;
import com.octopus.project.service.SysUserDateInfoService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 用户入职和离职时间信息
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysUserDateInfo")
public class SysUserDateInfoController {
	@Autowired
	private SysUserDateInfoService sysUserDateInfoService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysUserDateInfoDO> sysUserDateInfoList = sysUserDateInfoService.list(query);
		int total = sysUserDateInfoService.count(query);
		PageUtils pageUtils = new PageUtils(sysUserDateInfoList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysUserDateInfo/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysUserDateInfo/sysUserDateInfo";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		SysUserDateInfoDO sysUserDateInfo = sysUserDateInfoService.get(id);
		model.addAttribute("sysUserDateInfo", sysUserDateInfo);
	    return "project/sysUserDateInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysUserDateInfoDO sysUserDateInfo){
		if(sysUserDateInfoService.save(sysUserDateInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysUserDateInfoDO sysUserDateInfo){
		sysUserDateInfoService.update(sysUserDateInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sysUserDateInfoService.remove(id)>0){
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
		sysUserDateInfoService.batchRemove(ids);
		return R.ok();
	}
	
}
