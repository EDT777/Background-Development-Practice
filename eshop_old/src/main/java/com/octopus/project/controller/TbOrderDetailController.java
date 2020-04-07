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

import com.octopus.project.domain.TbOrderDetailDO;
import com.octopus.project.service.TbOrderDetailService;
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
@RequestMapping("/project/tbOrderDetail")
public class TbOrderDetailController {
	@Autowired
	private TbOrderDetailService tbOrderDetailService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbOrderDetailDO> tbOrderDetailList = tbOrderDetailService.list(query);
		int total = tbOrderDetailService.count(query);
		PageUtils pageUtils = new PageUtils(tbOrderDetailList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbOrderDetail/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbOrderDetail/tbOrderDetail";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbOrderDetailDO tbOrderDetail = tbOrderDetailService.get(id);
		model.addAttribute("tbOrderDetail", tbOrderDetail);
	    return "project/tbOrderDetail/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbOrderDetailDO tbOrderDetail){
		if(tbOrderDetailService.save(tbOrderDetail)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbOrderDetailDO tbOrderDetail){
		tbOrderDetailService.update(tbOrderDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbOrderDetailService.remove(id)>0){
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
		tbOrderDetailService.batchRemove(ids);
		return R.ok();
	}
	
}
