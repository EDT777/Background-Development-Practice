package cn.wolfcode.util;

import cn.wolfcode.domain.Employee;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserContext {

    /**
     * 从session中获取员工
     * @return
     */
    public static Employee getCurrentUser(){
        return null;
    }




}
