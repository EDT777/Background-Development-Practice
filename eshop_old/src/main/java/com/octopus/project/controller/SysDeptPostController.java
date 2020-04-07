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

import com.octopus.project.domain.SysDeptPostDO;
import com.octopus.project.service.SysDeptPostService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 部门与岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysDeptPost")
public class SysDeptPostController {
	@Autowired
	private SysDeptPostService sysDeptPostService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysDeptPostDO> sysDeptPostList = sysDeptPostService.list(query);
		int total = sysDeptPostService.count(query);
		PageUtils pageUtils = new PageUtils(sysDeptPostList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysDeptPost/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysDeptPost/sysDeptPost";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		SysDeptPostDO sysDeptPost = sysDeptPostService.get(id);
		model.addAttribute("sysDeptPost", sysDeptPost);
	    return "project/sysDeptPost/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysDeptPostDO sysDeptPost){
		if(sysDeptPostService.save(sysDeptPost)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysDeptPostDO sysDeptPost){
		sysDeptPostService.update(sysDeptPost);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sysDeptPostService.remove(id)>0){
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
		sysDeptPostService.batchRemove(ids);
		return R.ok();
	}
	
}
