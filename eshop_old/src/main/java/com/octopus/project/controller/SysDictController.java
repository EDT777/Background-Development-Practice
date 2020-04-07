package com.octopus.project.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import com.octopus.project.domain.SysDictDO;
import com.octopus.project.service.SysDictService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 字典表
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysDict")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;
	
	//@RequiresPermissions("product:dict:list")
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysDictDO> sysDictList = sysDictService.list(query);
		int total = sysDictService.count(query);
		PageUtils pageUtils = new PageUtils(sysDictList, total);
		return pageUtils;
	}
	
	@RequiresPermissions("porject:dict:add")
	@RequestMapping("/add")
	public String add(){
	    return "project/sysDict/add";
	}
	//@RequiresPermissions("product:dict:toList")
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysDict/sysDict";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		SysDictDO sysDict = sysDictService.get(id);
		model.addAttribute("sysDict", sysDict);
	    return "project/sysDict/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysDictDO sysDict){
		//处理一些对象的默认值
		sysDict.setCreateBy(1);
		sysDict.setDelFlag("0");
		sysDict.setCreateDate(new Date());
		sysDict.setUpdateDate(new Date());
		if(sysDictService.save(sysDict)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysDictDO sysDict){
		sysDictService.update(sysDict);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sysDictService.remove(id)>0){
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
		sysDictService.batchRemove(ids);
		return R.ok();
	}
	
}
