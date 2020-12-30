package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Role;
import cn.wolfcode.mapper.RoleMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public void save(Role role, Long[] ids) {
        roleMapper.insert(role);
        //关联关系
        if(ids!=null&&ids.length>0){
            for (Long pid : ids) {
                roleMapper.insertRelation(role.getId(),pid);
            }
        }
    }

    @Override
    @Transactional
    public void update(Role role, Long[] ids) {
        roleMapper.updateByPrimaryKey(role);
        //删除关系
        roleMapper.deleteRelation(role.getId());
        //关联关系
        if(ids!=null&&ids.length>0){
            for (Long pid : ids) {
                roleMapper.insertRelation(role.getId(),pid);
            }
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //删除关系
        roleMapper.deleteRelation(id);

        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> listAll() {
        return roleMapper.selectAll();
    }

    @Override
    public PageInfo<Role> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<Role> roles = roleMapper.selectForList(qo);
        return new PageInfo<>(roles);
    }
}
