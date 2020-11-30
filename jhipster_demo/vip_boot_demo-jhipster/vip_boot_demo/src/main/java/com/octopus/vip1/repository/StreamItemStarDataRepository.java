package com.octopus.vip1.repository;

import com.octopus.vip1.domain.StreamItemStarData;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the StreamItemStarData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StreamItemStarDataRepository extends JpaRepository<StreamItemStarData, Long> {
}
