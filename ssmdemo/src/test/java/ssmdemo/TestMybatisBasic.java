package ssmdemo;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.octopus.dao.MySqlSessionFactory;
import com.octopus.dao.UserInfoDao;
import com.octopus.entity.UserInfoDO;

public class TestMybatisBasic {
	
	@Test
	public void test1() {
		SqlSession session = MySqlSessionFactory.openSession();
		UserInfoDao userInfoDao = session.getMapper(UserInfoDao.class);
		UserInfoDO user = userInfoDao.get(1L);
		assertNotNull(user);
	}
}
