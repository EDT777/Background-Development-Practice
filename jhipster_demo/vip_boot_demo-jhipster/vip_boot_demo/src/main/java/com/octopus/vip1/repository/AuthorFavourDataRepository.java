package com.octopus.vip1.repository;

import com.octopus.vip1.domain.AuthorFavourData;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AuthorFavourData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorFavourDataRepository extends JpaRepository<AuthorFavourData, Long> {
}
