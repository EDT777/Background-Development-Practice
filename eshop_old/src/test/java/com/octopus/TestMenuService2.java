package com.octopus;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.octopus.project.dao.SysMenuDao;
import com.octopus.project.dao.SysRoleMenuDao;
import com.octopus.project.dao.SysUserRoleDao;
import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysRoleMenuDO;
import com.octopus.project.domain.SysUserRoleDO;
import com.octopus.project.service.SysMenuService;
import com.octopus.project.service.SysUserService;

@SpringBootTest
public class TestMenuService2 {
	
	@Autowired
	private SysMenuService menuService;

	@Autowired
	private SysUserRoleDao userRoleDao;
	@Autowired
	private SysRoleMenuDao roleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Test 
	public void testFindMenuByUserName() {
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("userId", 1);
		//先查询用户角色
		List<SysUserRoleDO> roles= userRoleDao.list(p);
		assertNotNull(roles);
		System.out.println(roles);
		p.clear();
		p.put("roleId", 1);
		//查询每一个role对应的权限
		List<SysRoleMenuDO> listRm = roleMenuDao.list(p);
		assertNotNull(listRm);
		System.out.println(listRm);
		p.clear();
		p.put("menuId", 30);
		List<SysMenuDO> allmenu = sysMenuDao.list(p);
		assertNotNull(allmenu);
		System.out.println(allmenu);
	}
}
