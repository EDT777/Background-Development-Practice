package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysMenuDao;
import com.octopus.project.dao.SysRoleMenuDao;
import com.octopus.project.dao.SysUserRoleDao;
import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysRoleMenuDO;
import com.octopus.project.domain.SysUserRoleDO;
import com.octopus.project.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserRoleDao userRoleDao;
	@Autowired
	private SysRoleMenuDao roleMenuDao;
	@Autowired
	private SysMenuDao menuDao;

	@Override
	public SysMenuDO get(Long menuId) {
		return sysMenuDao.get(menuId);
	}

	@Override
	public List<SysMenuDO> list(Map<String, Object> map) {
		return sysMenuDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return sysMenuDao.count(map);
	}

	@Override
	public int save(SysMenuDO sysMenu) {
		return sysMenuDao.save(sysMenu);
	}

	@Override
	public int update(SysMenuDO sysMenu) {
		return sysMenuDao.update(sysMenu);
	}

	@Override
	public int remove(Long menuId) {
		return sysMenuDao.remove(menuId);
	}

	@Override
	public int batchRemove(Long[] menuIds) {
		return sysMenuDao.batchRemove(menuIds);
	}

	/**
	 * 按照也没组件的特点生成所有对应用户菜单的集合
	 */
	@Override
	public LinkedHashMap<SysMenuDO, List<SysMenuDO>> listAllMenusByUserId(long userId) {
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("userId", userId);
		List<SysMenuDO> allMenus = new ArrayList<SysMenuDO>();
		// 先查询用户角色
		List<SysUserRoleDO> roles = userRoleDao.list(p);
		p.clear();
		for (SysUserRoleDO ur : roles) {
			p.put("roleId", ur.getRoleId());
			// 查询每一个role对应的权限
			List<SysRoleMenuDO> listRm = roleMenuDao.list(p);
			p.clear();
			for (SysRoleMenuDO rm : listRm) {
				SysMenuDO sysMenuDO = menuDao.get(rm.getMenuId());
				if (sysMenuDO != null) {
					allMenus.add(sysMenuDO);
				}
			}
		}
		// 整理结构：按照parentId, order 排序
		allMenus.sort(new Comparator<SysMenuDO>() {

			@Override
			public int compare(SysMenuDO o1, SysMenuDO o2) {
				if (o1 == null) {
					return -1;
				}
				if (o2 == null) {
					return 1;
				}
				if (o1.getParentId().intValue() != o2.getParentId()) {
					if (o1.getParentId() == null) {
						return -1;
					}
					if (o2.getParentId() == null) {
						return 1;
					}
					return (int) (o1.getParentId() - o2.getParentId());
				}
				if (o1.getOrderNum().intValue() != o2.getOrderNum()) {
					if (o1.getOrderNum() == null) {
						return -1;
					}
					if (o2.getOrderNum() == null) {
						return 1;
					}
					return o1.getOrderNum() - o2.getOrderNum();
				} else {
					return (int) (o1.getMenuId() - o2.getMenuId());
				}
			}
		});

		// 整理菜单到总结构中
		LinkedHashMap<SysMenuDO, List<SysMenuDO>> allMenuInOrder = new LinkedHashMap<>();
		Map<Long, SysMenuDO> allParents = new HashMap<>();
		for (SysMenuDO m : allMenus) {
			if (m == null) {
				continue;
			}
			if (m.getParentId() == null || m.getParentId() == 0) {
				allMenuInOrder.put(m, new ArrayList<SysMenuDO>());
				allParents.put(m.getMenuId(), m);
			} else {
				Long parentId = m.getParentId();
				SysMenuDO sysMenuDO = allParents.get(parentId);
				List<SysMenuDO> list = allMenuInOrder.get(sysMenuDO);
				if(list==null) {
					continue;//说明该用户有某个子菜单但是没有父菜单，这不显示是合理的，但是这个用户能执行这个操作
				}
				list.add(m);
			}
		}
		return allMenuInOrder;
	}

}
