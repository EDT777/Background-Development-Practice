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

import com.octopus.project.domain.TbOrderDetailRateDO;
import com.octopus.project.service.TbOrderDetailRateService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 订单详情
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbOrderDetailRate")
public class TbOrderDetailRateController {
	@Autowired
	private TbOrderDetailRateService tbOrderDetailRateService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbOrderDetailRateDO> tbOrderDetailRateList = tbOrderDetailRateService.list(query);
		int total = tbOrderDetailRateService.count(query);
		PageUtils pageUtils = new PageUtils(tbOrderDetailRateList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbOrderDetailRate/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbOrderDetailRate/tbOrderDetailRate";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbOrderDetailRateDO tbOrderDetailRate = tbOrderDetailRateService.get(id);
		model.addAttribute("tbOrderDetailRate", tbOrderDetailRate);
	    return "project/tbOrderDetailRate/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbOrderDetailRateDO tbOrderDetailRate){
		if(tbOrderDetailRateService.save(tbOrderDetailRate)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbOrderDetailRateDO tbOrderDetailRate){
		tbOrderDetailRateService.update(tbOrderDetailRate);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbOrderDetailRateService.remove(id)>0){
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
		tbOrderDetailRateService.batchRemove(ids);
		return R.ok();
	}
	
}
