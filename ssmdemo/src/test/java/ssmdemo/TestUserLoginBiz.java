package ssmdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octopus.biz.UserLoginBiz;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserLoginBiz {

	@Autowired
	private UserLoginBiz biz;

	@Test
	public void testLogin() {
		String username = "user1";
		String pwd = "111111";
		String result = biz.login(username, pwd);
		assertEquals(UserLoginBiz.LOGIN_SUCCESS, result);
		pwd = String.valueOf(Math.random());
		result = biz.login(username, pwd);
		assertEquals(UserLoginBiz.LOGIN_FAILED, result);
		pwd = null;
		result = biz.login(username, pwd);
		assertEquals(UserLoginBiz.LOGIN_FAILED, result);
	}
}
