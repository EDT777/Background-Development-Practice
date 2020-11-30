package com.octopus.vip1.service;

import com.octopus.vip1.domain.AuthorFavourData;
import com.octopus.vip1.repository.AuthorFavourDataRepository;
import com.octopus.vip1.service.dto.AuthorFavourDataDTO;
import com.octopus.vip1.service.mapper.AuthorFavourDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AuthorFavourData}.
 */
@Service
@Transactional
public class AuthorFavourDataService {

    private final Logger log = LoggerFactory.getLogger(AuthorFavourDataService.class);

    private final AuthorFavourDataRepository authorFavourDataRepository;

    private final AuthorFavourDataMapper authorFavourDataMapper;

    public AuthorFavourDataService(AuthorFavourDataRepository authorFavourDataRepository, AuthorFavourDataMapper authorFavourDataMapper) {
        this.authorFavourDataRepository = authorFavourDataRepository;
        this.authorFavourDataMapper = authorFavourDataMapper;
    }

    /**
     * Save a authorFavourData.
     *
     * @param authorFavourDataDTO the entity to save.
     * @return the persisted entity.
     */
    public AuthorFavourDataDTO save(AuthorFavourDataDTO authorFavourDataDTO) {
        log.debug("Request to save AuthorFavourData : {}", authorFavourDataDTO);
        AuthorFavourData authorFavourData = authorFavourDataMapper.toEntity(authorFavourDataDTO);
        authorFavourData = authorFavourDataRepository.save(authorFavourData);
        return authorFavourDataMapper.toDto(authorFavourData);
    }

    /**
     * Get all the authorFavourData.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthorFavourDataDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AuthorFavourData");
        return authorFavourDataRepository.findAll(pageable)
            .map(authorFavourDataMapper::toDto);
    }

    /**
     * Get one authorFavourData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AuthorFavourDataDTO> findOne(Long id) {
        log.debug("Request to get AuthorFavourData : {}", id);
        return authorFavourDataRepository.findById(id)
            .map(authorFavourDataMapper::toDto);
    }

    /**
     * Delete the authorFavourData by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AuthorFavourData : {}", id);
        authorFavourDataRepository.deleteById(id);
    }
}
