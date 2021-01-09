package cn.wolfcode.service;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IPermissionService {
    void save(Permission permission);
    void update(Permission permission);
    void delete(Long id);
    Permission get(Long id);
    List<Permission> listAll();
    // 分页查询的方法
    PageInfo<Permission> query(QueryObject qo);

    /**
     * 权限加载
     */
    void reload();

    /**
     * 根据员工id查询权限表达式
     * @param id
     * @return
     */
    List<String> selectByEmpId(Long id);
}