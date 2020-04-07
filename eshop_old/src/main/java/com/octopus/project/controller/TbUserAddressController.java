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

import com.octopus.project.domain.TbUserAddressDO;
import com.octopus.project.service.TbUserAddressService;
import com.octopus.common.utils.PageUtils;
import com.octopus.common.utils.Query;
import com.octopus.common.utils.R;

/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
 
@Controller
@RequestMapping("/project/tbUserAddress")
public class TbUserAddressController {
	@Autowired
	private TbUserAddressService tbUserAddressService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TbUserAddressDO> tbUserAddressList = tbUserAddressService.list(query);
		int total = tbUserAddressService.count(query);
		PageUtils pageUtils = new PageUtils(tbUserAddressList, total);
		return pageUtils;
	}
	
	@RequestMapping("/add")
	public String add(){
	    return "project/tbUserAddress/add";
	}
	
	@RequestMapping("/toList")
	public String toList(){
	    return "project/tbUserAddress/tbUserAddress";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model){
		TbUserAddressDO tbUserAddress = tbUserAddressService.get(id);
		model.addAttribute("tbUserAddress", tbUserAddress);
	    return "project/tbUserAddress/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	public R save( TbUserAddressDO tbUserAddress){
		if(tbUserAddressService.save(tbUserAddress)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update( TbUserAddressDO tbUserAddress){
		tbUserAddressService.update(tbUserAddress);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(tbUserAddressService.remove(id)>0){
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
		tbUserAddressService.batchRemove(ids);
		return R.ok();
	}
	
}
