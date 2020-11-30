package com.octopus.vip1.service;

import com.octopus.vip1.domain.Reply;
import com.octopus.vip1.repository.ReplyRepository;
import com.octopus.vip1.service.dto.ReplyDTO;
import com.octopus.vip1.service.mapper.ReplyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Reply}.
 */
@Service
@Transactional
public class ReplyService {

    private final Logger log = LoggerFactory.getLogger(ReplyService.class);

    private final ReplyRepository replyRepository;

    private final ReplyMapper replyMapper;

    public ReplyService(ReplyRepository replyRepository, ReplyMapper replyMapper) {
        this.replyRepository = replyRepository;
        this.replyMapper = replyMapper;
    }

    /**
     * Save a reply.
     *
     * @param replyDTO the entity to save.
     * @return the persisted entity.
     */
    public ReplyDTO save(ReplyDTO replyDTO) {
        log.debug("Request to save Reply : {}", replyDTO);
        Reply reply = replyMapper.toEntity(replyDTO);
        reply = replyRepository.save(reply);
        return replyMapper.toDto(reply);
    }

    /**
     * Get all the replies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ReplyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Replies");
        return replyRepository.findAll(pageable)
            .map(replyMapper::toDto);
    }

    /**
     * Get one reply by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ReplyDTO> findOne(Long id) {
        log.debug("Request to get Reply : {}", id);
        return replyRepository.findById(id)
            .map(replyMapper::toDto);
    }

    /**
     * Delete the reply by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Reply : {}", id);
        replyRepository.deleteById(id);
    }
}
