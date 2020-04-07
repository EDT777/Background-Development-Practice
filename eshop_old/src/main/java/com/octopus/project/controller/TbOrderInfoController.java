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

import com.octopus.project.domain.TbOrderInfoDO;
import com.octopus.project.service.TbOrderInfoService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 订单
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbOrderInfo")
public class TbOrderInfoController {
	@Autowired
	private TbOrderInfoService tbOrderInfoService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbOrderInfoDO> tbOrderInfoList = tbOrderInfoService.list(query);
		int total = tbOrderInfoService.count(query);
		PageUtils pageUtils = new PageUtils(tbOrderInfoList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbOrderInfo/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbOrderInfo/tbOrderInfo";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbOrderInfoDO tbOrderInfo = tbOrderInfoService.get(id);
		model.addAttribute("tbOrderInfo", tbOrderInfo);
	    return "project/tbOrderInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbOrderInfoDO tbOrderInfo){
		if(tbOrderInfoService.save(tbOrderInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbOrderInfoDO tbOrderInfo){
		tbOrderInfoService.update(tbOrderInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbOrderInfoService.remove(id)>0){
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
		tbOrderInfoService.batchRemove(ids);
		return R.ok();
	}
	
}
