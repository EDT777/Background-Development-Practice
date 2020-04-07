package com.octopus;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.service.SysMenuService;
import com.octopus.project.service.SysUserService;

@SpringBootTest
public class TestMenuService {
	@Autowired
	private SysMenuService menuService;

	@Test 
	public void testFindMenuByUserName() {
		LinkedHashMap<SysMenuDO, List<SysMenuDO>> map = menuService.listAllMenusByUserId(1L);
		assertNotNull(map);
		System.out.println(map);
	}
}
