package com.octopus;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.service.SysUserService;

@SpringBootTest
public class TestUserService {
	@Autowired
	private SysUserService userService;

	@Test 
	public void testFindMenuByUserName() {
		List<SysMenuDO> findMenusByUser = userService.findMenusByUser("admin");
		System.out.println(findMenusByUser);
	}
}
