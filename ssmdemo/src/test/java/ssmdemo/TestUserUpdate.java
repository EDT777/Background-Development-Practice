package ssmdemo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octopus.dao.UserInfoDao;
import com.octopus.entity.UserInfoDO;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserUpdate {
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	@Test
	public void testUpdateUser() {
		UserInfoDO user = userInfoDao.get(1L);
		user.setUserBirthday(new Date());
		userInfoDao.update(user);
	}

}
