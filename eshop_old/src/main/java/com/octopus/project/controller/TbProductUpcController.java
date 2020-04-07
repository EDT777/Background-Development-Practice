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

import com.octopus.project.domain.TbProductUpcDO;
import com.octopus.project.service.TbProductUpcService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 商品upc
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbProductUpc")
public class TbProductUpcController {
	@Autowired
	private TbProductUpcService tbProductUpcService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbProductUpcDO> tbProductUpcList = tbProductUpcService.list(query);
		int total = tbProductUpcService.count(query);
		PageUtils pageUtils = new PageUtils(tbProductUpcList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbProductUpc/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbProductUpc/tbProductUpc";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbProductUpcDO tbProductUpc = tbProductUpcService.get(id);
		model.addAttribute("tbProductUpc", tbProductUpc);
	    return "project/tbProductUpc/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbProductUpcDO tbProductUpc){
		if(tbProductUpcService.save(tbProductUpc)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbProductUpcDO tbProductUpc){
		tbProductUpcService.update(tbProductUpc);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbProductUpcService.remove(id)>0){
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
		tbProductUpcService.batchRemove(ids);
		return R.ok();
	}
	
}
