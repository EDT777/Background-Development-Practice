package com.octopus.vip1.repository;

import com.octopus.vip1.domain.InfoStreamItem;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the InfoStreamItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InfoStreamItemRepository extends JpaRepository<InfoStreamItem, Long> {
}
