package com.octopus.vip1.repository;

import com.octopus.vip1.domain.ReplyVisitDataStat;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ReplyVisitDataStat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReplyVisitDataStatRepository extends JpaRepository<ReplyVisitDataStat, Long> {
}
