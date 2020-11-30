package com.octopus.vip1.repository;

import com.octopus.vip1.domain.InfoItemVisitDataStat;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the InfoItemVisitDataStat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InfoItemVisitDataStatRepository extends JpaRepository<InfoItemVisitDataStat, Long> {
}
