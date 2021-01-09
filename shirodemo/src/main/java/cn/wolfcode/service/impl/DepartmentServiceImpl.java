package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Department;
import cn.wolfcode.mapper.DepartmentMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private DepartmentMapper departmentMapper;

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    @Transactional
    public void save(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    @Transactional
    public void update(Department department) {
        departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Department get(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> listAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public PageInfo<Department> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<Department> departments = departmentMapper.selectForList(qo);
        return new PageInfo<>(departments);
    }
}
