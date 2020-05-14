package com.octopus.mybatisDemo.dao;

import java.util.List;

import com.octopus.mybatisDemo.entity.GoodsType;


/**
 * ��Ʒ���͵����ݲ�����
 * @author hw
 *
 */
public interface GoodsTypeDao {
	/**
	 * �����Ʒ
	 * @param GoodsType
	 * @return �Ƿ���ӳɹ�
	 */
	public int insert(GoodsType GoodsType);
	
	/**
	 * �޸���Ʒ
	 * @param GoodsType
	 * @return �Ƿ��޸ĳɹ�
	 */
	public int update(GoodsType GoodsType);
	
	/**
	 * ɾ����Ʒ
	 * @param GoodsType
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public int delete(Long id);
	
	
	/**
	 * ����������ֵ��ȡ��������
	 * @param id
	 * @return
	 */
	public GoodsType getById(Long id);
	
	public GoodsType getById1(Long id);
	
	/**
	 * ������������
	 * @param where sql��������
	 * @param params �����ж�Ӧ�Ĳ���
	 * @param pageNum ҳ�룬��1��ʼ
	 * @param pageSize ҳ��С
	 * @return
	 */
	public List<GoodsType> findByWhere(String where,int pageNum,int pageSize);

	
	/**
	 * ��ҳ������������ѯָ�����������ݵ�������
	 * @param where sql��������
	 * @param params �����ж�Ӧ�Ĳ���
	 * @return
	 */
	public int countByWhere(String where,Object[] params);
}
