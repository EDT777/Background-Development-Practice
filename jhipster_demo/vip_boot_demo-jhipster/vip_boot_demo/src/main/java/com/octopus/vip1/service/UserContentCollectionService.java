package com.octopus.vip1.service;

import com.octopus.vip1.domain.UserContentCollection;
import com.octopus.vip1.repository.UserContentCollectionRepository;
import com.octopus.vip1.service.dto.UserContentCollectionDTO;
import com.octopus.vip1.service.mapper.UserContentCollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserContentCollection}.
 */
@Service
@Transactional
public class UserContentCollectionService {

    private final Logger log = LoggerFactory.getLogger(UserContentCollectionService.class);

    private final UserContentCollectionRepository userContentCollectionRepository;

    private final UserContentCollectionMapper userContentCollectionMapper;

    public UserContentCollectionService(UserContentCollectionRepository userContentCollectionRepository, UserContentCollectionMapper userContentCollectionMapper) {
        this.userContentCollectionRepository = userContentCollectionRepository;
        this.userContentCollectionMapper = userContentCollectionMapper;
    }

    /**
     * Save a userContentCollection.
     *
     * @param userContentCollectionDTO the entity to save.
     * @return the persisted entity.
     */
    public UserContentCollectionDTO save(UserContentCollectionDTO userContentCollectionDTO) {
        log.debug("Request to save UserContentCollection : {}", userContentCollectionDTO);
        UserContentCollection userContentCollection = userContentCollectionMapper.toEntity(userContentCollectionDTO);
        userContentCollection = userContentCollectionRepository.save(userContentCollection);
        return userContentCollectionMapper.toDto(userContentCollection);
    }

    /**
     * Get all the userContentCollections.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserContentCollectionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserContentCollections");
        return userContentCollectionRepository.findAll(pageable)
            .map(userContentCollectionMapper::toDto);
    }

    /**
     * Get one userContentCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserContentCollectionDTO> findOne(Long id) {
        log.debug("Request to get UserContentCollection : {}", id);
        return userContentCollectionRepository.findById(id)
            .map(userContentCollectionMapper::toDto);
    }

    /**
     * Delete the userContentCollection by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserContentCollection : {}", id);
        userContentCollectionRepository.deleteById(id);
    }
}
