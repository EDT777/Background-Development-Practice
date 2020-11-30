package com.edt.webcrud_good.dao;

import com.edt.webcrud_good.domain.Good;

import java.util.List;

public interface IGoodDao {
    /**
     * 添加一个货品信息
     */
    void insert(Good p);

    /**
     * 根基货品id 删除货品信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据货品Id 修改货品信息
     *
     * @param p
     */
    void update(Good p);

    /**
     * 根据货品id 查询货品信息
     *
     * @param id
     * @return
     */
    Good selectOne(Long id);

    /**
     * 查询货品信息
     */
    List<Good> selectList();
}
