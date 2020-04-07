package eshop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.octopus.biz.UserBiz;
import com.octopus.biz.impl.UserBizImpl;

public class TestLoginBiz {
	@Test
	public void testLogin() {
		UserBiz biz = new UserBizImpl();
		//用户名和密码正确
		String login = biz.login("user1", "111111");
		assertEquals(biz.LOGIN_SUCCESS, login);
		//用户名正确 密码不正确
		login =biz.login("user1", "111111");
		assertEquals(UserBiz.LOGIN_SUCCESS, login);
		//用户名不正确，密码有但是不为null
		login = biz.login("user"+Math.random(), "111112");
		assertEquals(UserBiz.LOGIN_FAIL, login);
		//用户名为NULL 密码不位NULL
		login = biz.login(null, "111112");
		assertEquals(UserBiz.LOGIN_FAIL, login);
		//用户名存在，密码为null
		login = biz.login("user1", null);
		assertEquals(UserBiz.LOGIN_FAIL, login);
		//两者均为null
		login = biz.login(null, null);
		assertEquals(UserBiz.LOGIN_FAIL, login);
	
	}
}
