package com.octopus.mybatisDemo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.octopus.mybatisDemo.entity.Goods;


/**
 * ��Ʒ�����ݲ�����:��ʾʹ��ע��ʵ��mybatis��ѯ
 * @author hw
 *
 */
public interface GoodsDao2 {
	/**
	 * �����Ʒ
	 * @param goods
	 * @return �Ƿ���ӳɹ�
	 */
	public int insert(Goods goods);
	
	/**
	 * �޸���Ʒ
	 * @param goods
	 * @return �Ƿ��޸ĳɹ�
	 */
	public int update(Goods goods);
	
	/**
	 * ɾ����Ʒ
	 * @param goods
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public int delete(Long id);
	
	
	/**
	 * ����������ֵ��ȡ��������
	 * @param id
	 * @return
	 */
	@Select("select * from goods where id=#{id}")
	public Goods getById(Long id);
	
	public Goods getById1(Long id);
	
	/**
	 * ������������
	 * @param where sql��������
	 * @param params �����ж�Ӧ�Ĳ���
	 * @param pageNum ҳ�룬��1��ʼ
	 * @param pageSize ҳ��С
	 * @return
	 */
	@SelectProvider(type = MySqlProvider.class,method = "buildSqlDemo")
	public List<Goods> findByWhere(Map<String,Object> params);

	
	/**
	 * ��ҳ������������ѯָ�����������ݵ�������
	 * @param where sql��������
	 * @param params �����ж�Ӧ�Ĳ���
	 * @return
	 */
	public int countByWhere(String where,Object[] params);
}
