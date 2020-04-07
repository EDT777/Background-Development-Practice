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

import com.octopus.project.domain.SysUserDO;
import com.octopus.project.service.SysUserService;
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
@RequestMapping("/project/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysUserDO> sysUserList = sysUserService.list(query);
		int total = sysUserService.count(query);
		PageUtils pageUtils = new PageUtils(sysUserList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysUser/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysUser/sysUser";
	}

	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId,Model model){
		SysUserDO sysUser = sysUserService.get(userId);
		model.addAttribute("sysUser", sysUser);
	    return "project/sysUser/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysUserDO sysUser){
		if(sysUserService.save(sysUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysUserDO sysUser){
		sysUserService.update(sysUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long userId){
		if(sysUserService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] userIds){
		sysUserService.batchRemove(userIds);
		return R.ok();
	}
	
}
