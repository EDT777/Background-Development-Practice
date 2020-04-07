package com.octopus.biz.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octopus.biz.TransferBiz;
import com.octopus.dao.TbAccountDao;
import com.octopus.entity.TbAccountDO;
@Service
public class TransferBizImpl implements TransferBiz{

	@Autowired
	private TbAccountDao dao;
	
//	@Transactional
	public int tranfer(TbAccountDO from, TbAccountDO to, long amount) {
		int r =SUCCESS;
		from.setBalance(from.getBalance()-amount);
		to.setBalance(to.getBalance()+amount);
		dao.update(to);
		dao.update(from);
		return r;
	}

	public TbAccountDO get(Long id) {
		return dao.get(id);
	}

}
