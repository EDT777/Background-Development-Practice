package com.octopus.vip1.service;

import com.octopus.vip1.domain.InfoItemVisitData;
import com.octopus.vip1.repository.InfoItemVisitDataRepository;
import com.octopus.vip1.service.dto.InfoItemVisitDataDTO;
import com.octopus.vip1.service.mapper.InfoItemVisitDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link InfoItemVisitData}.
 */
@Service
@Transactional
public class InfoItemVisitDataService {

    private final Logger log = LoggerFactory.getLogger(InfoItemVisitDataService.class);

    private final InfoItemVisitDataRepository infoItemVisitDataRepository;

    private final InfoItemVisitDataMapper infoItemVisitDataMapper;

    public InfoItemVisitDataService(InfoItemVisitDataRepository infoItemVisitDataRepository, InfoItemVisitDataMapper infoItemVisitDataMapper) {
        this.infoItemVisitDataRepository = infoItemVisitDataRepository;
        this.infoItemVisitDataMapper = infoItemVisitDataMapper;
    }

    /**
     * Save a infoItemVisitData.
     *
     * @param infoItemVisitDataDTO the entity to save.
     * @return the persisted entity.
     */
    public InfoItemVisitDataDTO save(InfoItemVisitDataDTO infoItemVisitDataDTO) {
        log.debug("Request to save InfoItemVisitData : {}", infoItemVisitDataDTO);
        InfoItemVisitData infoItemVisitData = infoItemVisitDataMapper.toEntity(infoItemVisitDataDTO);
        infoItemVisitData = infoItemVisitDataRepository.save(infoItemVisitData);
        return infoItemVisitDataMapper.toDto(infoItemVisitData);
    }

    /**
     * Get all the infoItemVisitData.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<InfoItemVisitDataDTO> findAll(Pageable pageable) {
        log.debug("Request to get all InfoItemVisitData");
        return infoItemVisitDataRepository.findAll(pageable)
            .map(infoItemVisitDataMapper::toDto);
    }

    /**
     * Get one infoItemVisitData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<InfoItemVisitDataDTO> findOne(Long id) {
        log.debug("Request to get InfoItemVisitData : {}", id);
        return infoItemVisitDataRepository.findById(id)
            .map(infoItemVisitDataMapper::toDto);
    }

    /**
     * Delete the infoItemVisitData by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete InfoItemVisitData : {}", id);
        infoItemVisitDataRepository.deleteById(id);
    }
}
