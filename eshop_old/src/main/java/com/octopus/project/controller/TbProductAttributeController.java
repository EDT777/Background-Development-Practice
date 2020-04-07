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

import com.octopus.project.domain.TbProductAttributeDO;
import com.octopus.project.service.TbProductAttributeService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 商品属性表
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbProductAttribute")
public class TbProductAttributeController {
	@Autowired
	private TbProductAttributeService tbProductAttributeService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbProductAttributeDO> tbProductAttributeList = tbProductAttributeService.list(query);
		int total = tbProductAttributeService.count(query);
		PageUtils pageUtils = new PageUtils(tbProductAttributeList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbProductAttribute/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbProductAttribute/tbProductAttribute";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbProductAttributeDO tbProductAttribute = tbProductAttributeService.get(id);
		model.addAttribute("tbProductAttribute", tbProductAttribute);
	    return "project/tbProductAttribute/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbProductAttributeDO tbProductAttribute){
		if(tbProductAttributeService.save(tbProductAttribute)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbProductAttributeDO tbProductAttribute){
		tbProductAttributeService.update(tbProductAttribute);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbProductAttributeService.remove(id)>0){
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
		tbProductAttributeService.batchRemove(ids);
		return R.ok();
	}
	
}
