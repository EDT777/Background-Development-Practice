package com.octopus.vip1.repository;

import com.octopus.vip1.domain.UserContentCollection;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserContentCollection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserContentCollectionRepository extends JpaRepository<UserContentCollection, Long> {
}
