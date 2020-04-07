package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysMenuDao;
import com.octopus.project.dao.SysUserDao;
import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysUserDO;
import com.octopus.project.service.SysUserService;



@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysMenuDao menuDao;
 	@Override
	public SysUserDO get(Long userId){
		return sysUserDao.get(userId);
	}
	
	@Override
	public List<SysUserDO> list(Map<String, Object> map){
		return sysUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserDao.count(map);
	}
	
	@Override
	public int save(SysUserDO sysUser){
		return sysUserDao.save(sysUser);
	}
	
	@Override
	public int update(SysUserDO sysUser){
		return sysUserDao.update(sysUser);
	}
	
	@Override
	public int remove(Long userId){
		return sysUserDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return sysUserDao.batchRemove(userIds);
	}

	@Override
	public SysUserDO findByUsername(String name) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", name);
		List<SysUserDO> list= this.sysUserDao.list(map);
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SysMenuDO> findMenusByUser(String username) {
		// TODO Auto-generated method stub
		return menuDao.findByUsername(username);
	}
	
}
