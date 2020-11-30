package com.octopus.vip1.service;

import com.octopus.vip1.domain.ReplyVisitDataStat;
import com.octopus.vip1.repository.ReplyVisitDataStatRepository;
import com.octopus.vip1.service.dto.ReplyVisitDataStatDTO;
import com.octopus.vip1.service.mapper.ReplyVisitDataStatMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ReplyVisitDataStat}.
 */
@Service
@Transactional
public class ReplyVisitDataStatService {

    private final Logger log = LoggerFactory.getLogger(ReplyVisitDataStatService.class);

    private final ReplyVisitDataStatRepository replyVisitDataStatRepository;

    private final ReplyVisitDataStatMapper replyVisitDataStatMapper;

    public ReplyVisitDataStatService(ReplyVisitDataStatRepository replyVisitDataStatRepository, ReplyVisitDataStatMapper replyVisitDataStatMapper) {
        this.replyVisitDataStatRepository = replyVisitDataStatRepository;
        this.replyVisitDataStatMapper = replyVisitDataStatMapper;
    }

    /**
     * Save a replyVisitDataStat.
     *
     * @param replyVisitDataStatDTO the entity to save.
     * @return the persisted entity.
     */
    public ReplyVisitDataStatDTO save(ReplyVisitDataStatDTO replyVisitDataStatDTO) {
        log.debug("Request to save ReplyVisitDataStat : {}", replyVisitDataStatDTO);
        ReplyVisitDataStat replyVisitDataStat = replyVisitDataStatMapper.toEntity(replyVisitDataStatDTO);
        replyVisitDataStat = replyVisitDataStatRepository.save(replyVisitDataStat);
        return replyVisitDataStatMapper.toDto(replyVisitDataStat);
    }

    /**
     * Get all the replyVisitDataStats.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ReplyVisitDataStatDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReplyVisitDataStats");
        return replyVisitDataStatRepository.findAll(pageable)
            .map(replyVisitDataStatMapper::toDto);
    }

    /**
     * Get one replyVisitDataStat by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ReplyVisitDataStatDTO> findOne(Long id) {
        log.debug("Request to get ReplyVisitDataStat : {}", id);
        return replyVisitDataStatRepository.findById(id)
            .map(replyVisitDataStatMapper::toDto);
    }

    /**
     * Delete the replyVisitDataStat by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ReplyVisitDataStat : {}", id);
        replyVisitDataStatRepository.deleteById(id);
    }
}
