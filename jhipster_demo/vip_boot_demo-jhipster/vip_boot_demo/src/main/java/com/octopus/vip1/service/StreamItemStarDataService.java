package com.octopus.vip1.service;

import com.octopus.vip1.domain.StreamItemStarData;
import com.octopus.vip1.repository.StreamItemStarDataRepository;
import com.octopus.vip1.service.dto.StreamItemStarDataDTO;
import com.octopus.vip1.service.mapper.StreamItemStarDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link StreamItemStarData}.
 */
@Service
@Transactional
public class StreamItemStarDataService {

    private final Logger log = LoggerFactory.getLogger(StreamItemStarDataService.class);

    private final StreamItemStarDataRepository streamItemStarDataRepository;

    private final StreamItemStarDataMapper streamItemStarDataMapper;

    public StreamItemStarDataService(StreamItemStarDataRepository streamItemStarDataRepository, StreamItemStarDataMapper streamItemStarDataMapper) {
        this.streamItemStarDataRepository = streamItemStarDataRepository;
        this.streamItemStarDataMapper = streamItemStarDataMapper;
    }

    /**
     * Save a streamItemStarData.
     *
     * @param streamItemStarDataDTO the entity to save.
     * @return the persisted entity.
     */
    public StreamItemStarDataDTO save(StreamItemStarDataDTO streamItemStarDataDTO) {
        log.debug("Request to save StreamItemStarData : {}", streamItemStarDataDTO);
        StreamItemStarData streamItemStarData = streamItemStarDataMapper.toEntity(streamItemStarDataDTO);
        streamItemStarData = streamItemStarDataRepository.save(streamItemStarData);
        return streamItemStarDataMapper.toDto(streamItemStarData);
    }

    /**
     * Get all the streamItemStarData.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StreamItemStarDataDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StreamItemStarData");
        return streamItemStarDataRepository.findAll(pageable)
            .map(streamItemStarDataMapper::toDto);
    }

    /**
     * Get one streamItemStarData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StreamItemStarDataDTO> findOne(Long id) {
        log.debug("Request to get StreamItemStarData : {}", id);
        return streamItemStarDataRepository.findById(id)
            .map(streamItemStarDataMapper::toDto);
    }

    /**
     * Delete the streamItemStarData by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete StreamItemStarData : {}", id);
        streamItemStarDataRepository.deleteById(id);
    }
}
