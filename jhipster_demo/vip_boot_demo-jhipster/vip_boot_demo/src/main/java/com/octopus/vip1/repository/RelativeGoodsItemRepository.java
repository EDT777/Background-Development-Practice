package com.octopus.vip1.repository;

import com.octopus.vip1.domain.RelativeGoodsItem;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RelativeGoodsItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RelativeGoodsItemRepository extends JpaRepository<RelativeGoodsItem, Long> {
}
