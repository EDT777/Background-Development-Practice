package com.octopus.vip1.service;

import com.octopus.vip1.domain.InfoItemVisitDataStat;
import com.octopus.vip1.repository.InfoItemVisitDataStatRepository;
import com.octopus.vip1.service.dto.InfoItemVisitDataStatDTO;
import com.octopus.vip1.service.mapper.InfoItemVisitDataStatMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link InfoItemVisitDataStat}.
 */
@Service
@Transactional
public class InfoItemVisitDataStatService {

    private final Logger log = LoggerFactory.getLogger(InfoItemVisitDataStatService.class);

    private final InfoItemVisitDataStatRepository infoItemVisitDataStatRepository;

    private final InfoItemVisitDataStatMapper infoItemVisitDataStatMapper;

    public InfoItemVisitDataStatService(InfoItemVisitDataStatRepository infoItemVisitDataStatRepository, InfoItemVisitDataStatMapper infoItemVisitDataStatMapper) {
        this.infoItemVisitDataStatRepository = infoItemVisitDataStatRepository;
        this.infoItemVisitDataStatMapper = infoItemVisitDataStatMapper;
    }

    /**
     * Save a infoItemVisitDataStat.
     *
     * @param infoItemVisitDataStatDTO the entity to save.
     * @return the persisted entity.
     */
    public InfoItemVisitDataStatDTO save(InfoItemVisitDataStatDTO infoItemVisitDataStatDTO) {
        log.debug("Request to save InfoItemVisitDataStat : {}", infoItemVisitDataStatDTO);
        InfoItemVisitDataStat infoItemVisitDataStat = infoItemVisitDataStatMapper.toEntity(infoItemVisitDataStatDTO);
        infoItemVisitDataStat = infoItemVisitDataStatRepository.save(infoItemVisitDataStat);
        return infoItemVisitDataStatMapper.toDto(infoItemVisitDataStat);
    }

    /**
     * Get all the infoItemVisitDataStats.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<InfoItemVisitDataStatDTO> findAll(Pageable pageable) {
        log.debug("Request to get all InfoItemVisitDataStats");
        return infoItemVisitDataStatRepository.findAll(pageable)
            .map(infoItemVisitDataStatMapper::toDto);
    }

    /**
     * Get one infoItemVisitDataStat by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<InfoItemVisitDataStatDTO> findOne(Long id) {
        log.debug("Request to get InfoItemVisitDataStat : {}", id);
        return infoItemVisitDataStatRepository.findById(id)
            .map(infoItemVisitDataStatMapper::toDto);
    }

    /**
     * Delete the infoItemVisitDataStat by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete InfoItemVisitDataStat : {}", id);
        infoItemVisitDataStatRepository.deleteById(id);
    }
}
