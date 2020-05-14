package com.octopus.mybatisDemo;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.octopus.mybatisDemo.dao.UserInfoDao;
import com.octopus.mybatisDemo.entity.UserInfo;


/**
 * 2019-11-05测试代码
 * @author hw
 *
 */
public class Test3 {
	public static void main(String[] args) {
		SqlSession session = MySqlSessionFactory.openSession();
		UserInfoDao userInfoDao = session.getMapper(UserInfoDao.class);// 得到了一个由mybatis自动创建的dao接口的实现类
		
//		UserInfo user = userInfoDao.findByUserName("user1");
//		System.out.println(user);
		
		List<UserInfo> list = null;
//		list = userInfoDao.findByUserNameAndStatus("user1",0);
//		System.out.println(list);
		
		//使用实体类查询
		UserInfo userParam = new UserInfo();
		userParam.setUserName("user1");
		userParam.setUserStatus(0);
		list = userInfoDao.findByEntity(userParam);
		System.out.println(list);
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName","user1");
		param.put("userStatus",0);
		param.put("limit", 10);
		param.put("offset", 0);
		param.put("orderby","user_name");
		list = userInfoDao.findByMap(param);
		System.out.println(list);
		
		//删除
		int result = userInfoDao.delete(6L);
		System.out.println("删除返回的影响行数为:" + result);
		
		//更新
//		UserInfo userToUpdate =new UserInfo();
//		userToUpdate.setId(1L);
//		userToUpdate.setUserBirthday(new Date());
//		userToUpdate.setUserStatus(1);
//		userToUpdate.setUserPwd("111111");
//		
//		
//		int updateResult = userInfoDao.update(userToUpdate);
//		System.out.println("更新返回的影响行数为:" + updateResult);
		
		
//		UserInfo userToInsert = new UserInfo();
//		userToInsert.setUserBirthday(new Date());
//		userToInsert.setUserDelete(0);
//		userToInsert.setUserName("mybatis测试数据");
//		userToInsert.setUserPoint(0);
//		userToInsert.setUserPwd("123456");
//		userToInsert.setUserStatus(0);
//		int insertNew = userInfoDao.insertNew(userToInsert);
//		System.out.println("新增返回的影响行数为:" + insertNew);
//		System.out.println("新增加数据的id为:" + userToInsert.getId());
		
		//重新测试根据map的数据查询
		param = new HashMap<String, Object>();
//		param.put("userName","user1");
//		List<UserInfo> list2 = userInfoDao.findByMap(param);
//		System.out.println("改进的根据Map查询得到的结果:"+list2);
		
		
		//根据id批量查询的效果
		List<UserInfo> byIds = userInfoDao.findByIds(new Long[] {1L,2L,3L});
//		System.out.println("根据id批量查询获得的数据:"+ byIds);
		
		byIds = userInfoDao.findByIds1(Arrays.asList(1L,2L,3L));
		System.out.println("根据id批量查询获得的数据:"+ byIds);
		
		session.commit();
		session.close();
	}
}
