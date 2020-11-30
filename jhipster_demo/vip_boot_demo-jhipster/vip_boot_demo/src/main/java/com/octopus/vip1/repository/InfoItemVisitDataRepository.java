package com.octopus.vip1.repository;

import com.octopus.vip1.domain.InfoItemVisitData;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the InfoItemVisitData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InfoItemVisitDataRepository extends JpaRepository<InfoItemVisitData, Long> {
}
