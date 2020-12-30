package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.mapper.PermissionMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IPermissionService;
import cn.wolfcode.web.controller.DepartmentController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements IPermissionService {

    private PermissionMapper permissionMapper;

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    @Transactional
    public void save(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    @Transactional
    public void update(Permission permission) {
        permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> listAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public PageInfo<Permission> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<Permission> permissions = permissionMapper.selectForList(qo);
        return new PageInfo<>(permissions);
    }

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Override
    public void reload() {
        //需求：通过程序自动生成权限数据，并保存到数据库
        //查询数据库中所有权限表达式
        List<String> permissions = permissionMapper.selectAllExpression();
        Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();
        //获取所有控制器的方法（@RequestMapping）
        Collection<HandlerMethod> methods = map.values();
        //遍历方法集合，获取到每一个方法HandlerMethod
        for (HandlerMethod method : methods) {
            //判断方法是否有贴自定义的权限注解
           RequiresPermissions requiredPermission = method.getMethodAnnotation(RequiresPermissions.class);
            if(requiredPermission==null){
                //跳过当前循坏，执行下一次循环
                continue;
            }
            //获取注解上的权限表达式
            String expression = requiredPermission.value()[0];
            //判断是否已经存在数据库
            if(!permissions.contains(expression)){
                //不存在就封装为权限对象，并插入到数据
                Permission permission = new Permission();
                permission.setName(requiredPermission.value()[1]);
                permission.setExpression(expression);
                permissionMapper.insert(permission);
            }
        }
    }

    @Override
    public List<String> selectByEmpId(Long id) {
        return permissionMapper.selectByEmpId(id);
    }
}
