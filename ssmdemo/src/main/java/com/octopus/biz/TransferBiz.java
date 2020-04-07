package com.octopus.biz;

import com.octopus.entity.TbAccountDO;

/**
 * 转账业务
 * @author EDT灬谭泽豪
 *
 */
public interface TransferBiz {
	
	public int SUCCESS=0;
	public int FAIL=1;
	
/**
 * 
 * @param from 转出账户
 * @param to  转入账户
 * @param amount 金额
 * @return 是否成功
 */
	public int tranfer(TbAccountDO from,TbAccountDO to,long amount);

	//根据对象获取数据
	public TbAccountDO get(Long id);
}
