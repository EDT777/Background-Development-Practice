package com.octopus.common.userrealm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.AccountException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.octopus.common.utils.MD5Util;
import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysUserDO;
import com.octopus.project.service.SysUserService;

/**
 * 鉴权和授权处理
 * @author EDT灬谭泽豪
 *
 */
public class MyUserRealm extends AuthorizingRealm{

	private SysUserService userService;
	
	public void setUserService(SysUserService userService) {
		this.userService = userService;
	}
	/**
	 * 告诉shiro哪个subject有哪些访问权限
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	SysUserDO user = (SysUserDO) SecurityUtils.getSubject().getPrincipal();
	List<SysMenuDO> list = userService.findMenusByUser(user.getUsername());
	Set<String> permissions = new HashSet<>();//Shiro的权限表示方式1，即使用一个字符串表示
//	if("admin".equals(username)) {
//		permissions.add("product:dict:list");
//		permissions.add("product:dict:toList");
//	}
	for(SysMenuDO m:list) {
		if(m.getPerms()!=null && !(m.getPerms().equals(""))) {
		permissions.add(m.getPerms());
	}
	}
	System.out.println("用户: "+user.getUsername()+" 的权限有："+permissions);
	SimpleAuthorizationInfo authorInfo = new SimpleAuthorizationInfo();
	authorInfo.setStringPermissions(permissions);
	return authorInfo;
	}
	
	/**
	 * 实际的登陆验证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("在userRealm中得到了spring的支持下，获取了userService: "+userService);
		String username = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		SysUserDO  user = userService.findByUsername(username);
		if(user==null) {
			throw new AuthenticationException("用户错误");
		}
		//启用md5方式判断
		if(MD5Util.validatePwd(password, user.getPassword(),username)){
			return new SimpleAuthenticationInfo(user,password,getName());
		}else {
			throw new AuthenticationException("登陆失败");
		}
		
		
		
		
//		获取用户名和密码
//		String username = (String) token.getPrincipal();
//		String password = new String((char[])token.getCredentials());
//		//连接数据库
//		//简单验证演示
//		if("admin".equals(username) && "123456".equals(password)) {
//			
//			return new SimpleAuthenticationInfo(username,password,getName());
//		}else {
//			throw new AuthenticationException("登陆失败");
//		}
	}

}
