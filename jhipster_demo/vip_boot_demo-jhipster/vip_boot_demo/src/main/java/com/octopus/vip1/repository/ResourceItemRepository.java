package com.octopus.vip1.repository;

import com.octopus.vip1.domain.ResourceItem;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ResourceItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResourceItemRepository extends JpaRepository<ResourceItem, Long> {
}
