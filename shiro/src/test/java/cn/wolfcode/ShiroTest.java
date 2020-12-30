package cn.wolfcode;

import cn.wolfcode.shiro.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void testLogin(){
//--------------------shiro环境准备-------------------------
//    构建一个安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//        提供读取ini配置文件的数据源
//        IniRealm ini = new IniRealm("classpath:shiro.ini");
        MyRealm myRealm = new MyRealm();
//        设置使用的数据源
        securityManager.setRealm(myRealm);
//        设置使用的安全管理器
        SecurityUtils.setSecurityManager(securityManager);
//------------------实现认证功能-------------------------------
//subject代表当前访问系统的主体,无论有没有登陆都可以获取到subject对象,要判断是否有登录要看isAuthenticated()返回值
        Subject subject = SecurityUtils.getSubject();
        System.out.println("认证前:"+subject.isAuthenticated());
        System.out.println(subject.getPrincipal());
//        执行认证(传入认证的令牌)
        subject.login(new UsernamePasswordToken("admin","1"));
        System.out.println("认证后:"+subject.isAuthenticated());
        System.out.println(subject.getPrincipal());
//        执行注销
        subject.logout();
        System.out.println("注销后:"+subject.isAuthenticated());
    }
    
    @Test
    public void testMD5(){
//        第一个参数密码
//        第二个参数是盐
//        第三个参数是加密次数
        Md5Hash md5Hash = new Md5Hash("1","asd",2);
        System.out.println(md5Hash);
    }
}
