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

import com.octopus.project.domain.SysPostDO;
import com.octopus.project.service.SysPostService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 岗位管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/sysPost")
public class SysPostController {
	@Autowired
	private SysPostService sysPostService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysPostDO> sysPostList = sysPostService.list(query);
		int total = sysPostService.count(query);
		PageUtils pageUtils = new PageUtils(sysPostList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/sysPost/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/sysPost/sysPost";
	}

	@RequestMapping("/edit/{postId}")
	public String edit(@PathVariable("postId") Long postId,Model model){
		SysPostDO sysPost = sysPostService.get(postId);
		model.addAttribute("sysPost", sysPost);
	    return "project/sysPost/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( SysPostDO sysPost){
		if(sysPostService.save(sysPost)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( SysPostDO sysPost){
		sysPostService.update(sysPost);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long postId){
		if(sysPostService.remove(postId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] postIds){
		sysPostService.batchRemove(postIds);
		return R.ok();
	}
	
}
