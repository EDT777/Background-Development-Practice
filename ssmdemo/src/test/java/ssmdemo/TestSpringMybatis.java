package ssmdemo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octopus.dao.UserInfoDao;
import com.octopus.entity.UserInfoDO;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringMybatis {
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Test
	public void testRead() {
		UserInfoDO user = userInfoDao.get(1L);
		assertNotNull(user);
	}
}
