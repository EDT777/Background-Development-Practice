package com.octopus;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.octopus.project.dao.SysRoleDao;
import com.octopus.project.domain.SysRoleDO;

@SpringBootTest
class TestRoleDao {

	@Autowired
	private SysRoleDao roleDao;
	
	@Test
	public void test1() {
		List<SysRoleDO> list =roleDao.list(null);
		System.out.println(list);
		
	}

}
