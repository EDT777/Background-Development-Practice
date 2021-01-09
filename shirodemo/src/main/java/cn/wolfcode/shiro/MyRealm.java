package cn.wolfcode.shiro;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.domain.Role;
import cn.wolfcode.mapper.EmployeeMapper;
import cn.wolfcode.mapper.PermissionMapper;
import cn.wolfcode.mapper.RoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//自定义数据源,提供数据给shiro进行判断
@Component
public class MyRealm  extends AuthorizingRealm {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 提供shiro权限相关的数据
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//       该方法返回的对象中带有什么角色或权限,就是代表告诉shiro用户拥有的角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        获取当前登录用户对象
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
//        判断是否为超级管理员
        if (employee.isAdmin()){
            info.addRole("admin");//方便判断是否为管理员
            info.addStringPermission("*:*");//所有权限
        }else {
            //        查询该用户拥有的橘色
            List<Role> roles  =roleMapper.selectByEmpId(employee.getId());
            roles.forEach(role -> {
                info.addRole(role.getSn());
            });
//        查询该用户拥有的权限
            List<String> strings = permissionMapper.selectByEmpId(employee.getId());
            info.addStringPermissions(strings);
        }


        return info;
    }

    /**
     * 提供给shiro认证相关的数据
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//       返回的结果如果为null,代表用户名不存在,shiro就会抛UnknownAccountException异常
//        返回的结果不为null,代表用户名存在,shiro就会去判断密码是否正确(info,taken)

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//        调用mapper查询数据库中用户的相关信息
        Employee employee = employeeMapper.selectByUsername(usernamePasswordToken.getUsername());
        if (employee==null){
            return null;
        }
//       参数一.身份对象:传入的值会自动跟subject绑定,为了后续能获取到employee对象
//       参数二. 传入用户真正的密码
//       参数三.数据源的名字,bean的名字,暂时没有作用(多数据源的时候才有作用)
        return new SimpleAuthenticationInfo(employee,employee.getPassword(),this.getName());
    }
}
