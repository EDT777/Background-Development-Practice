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

import com.octopus.project.domain.TbProductDetailDO;
import com.octopus.project.service.TbProductDetailService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 商品详情页
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbProductDetail")
public class TbProductDetailController {
	@Autowired
	private TbProductDetailService tbProductDetailService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbProductDetailDO> tbProductDetailList = tbProductDetailService.list(query);
		int total = tbProductDetailService.count(query);
		PageUtils pageUtils = new PageUtils(tbProductDetailList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbProductDetail/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbProductDetail/tbProductDetail";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbProductDetailDO tbProductDetail = tbProductDetailService.get(id);
		model.addAttribute("tbProductDetail", tbProductDetail);
	    return "project/tbProductDetail/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbProductDetailDO tbProductDetail){
		if(tbProductDetailService.save(tbProductDetail)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbProductDetailDO tbProductDetail){
		tbProductDetailService.update(tbProductDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbProductDetailService.remove(id)>0){
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
		tbProductDetailService.batchRemove(ids);
		return R.ok();
	}
	
}
