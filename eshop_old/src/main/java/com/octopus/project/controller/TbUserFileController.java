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

import com.octopus.project.domain.TbUserFileDO;
import com.octopus.project.service.TbUserFileService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 文件上传
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbUserFile")
public class TbUserFileController {
	@Autowired
	private TbUserFileService tbUserFileService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbUserFileDO> tbUserFileList = tbUserFileService.list(query);
		int total = tbUserFileService.count(query);
		PageUtils pageUtils = new PageUtils(tbUserFileList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbUserFile/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbUserFile/tbUserFile";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbUserFileDO tbUserFile = tbUserFileService.get(id);
		model.addAttribute("tbUserFile", tbUserFile);
	    return "project/tbUserFile/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbUserFileDO tbUserFile){
		if(tbUserFileService.save(tbUserFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbUserFileDO tbUserFile){
		tbUserFileService.update(tbUserFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbUserFileService.remove(id)>0){
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
		tbUserFileService.batchRemove(ids);
		return R.ok();
	}
	
}
