package com.octopus.vip1.service;

import com.octopus.vip1.domain.InfoStreamItem;
import com.octopus.vip1.repository.InfoStreamItemRepository;
import com.octopus.vip1.service.dto.InfoStreamItemDTO;
import com.octopus.vip1.service.mapper.InfoStreamItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link InfoStreamItem}.
 */
@Service
@Transactional
public class InfoStreamItemService {

    private final Logger log = LoggerFactory.getLogger(InfoStreamItemService.class);

    private final InfoStreamItemRepository infoStreamItemRepository;

    private final InfoStreamItemMapper infoStreamItemMapper;

    public InfoStreamItemService(InfoStreamItemRepository infoStreamItemRepository, InfoStreamItemMapper infoStreamItemMapper) {
        this.infoStreamItemRepository = infoStreamItemRepository;
        this.infoStreamItemMapper = infoStreamItemMapper;
    }

    /**
     * Save a infoStreamItem.
     *
     * @param infoStreamItemDTO the entity to save.
     * @return the persisted entity.
     */
    public InfoStreamItemDTO save(InfoStreamItemDTO infoStreamItemDTO) {
        log.debug("Request to save InfoStreamItem : {}", infoStreamItemDTO);
        InfoStreamItem infoStreamItem = infoStreamItemMapper.toEntity(infoStreamItemDTO);
        infoStreamItem = infoStreamItemRepository.save(infoStreamItem);
        return infoStreamItemMapper.toDto(infoStreamItem);
    }

    /**
     * Get all the infoStreamItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<InfoStreamItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all InfoStreamItems");
        return infoStreamItemRepository.findAll(pageable)
            .map(infoStreamItemMapper::toDto);
    }

    /**
     * Get one infoStreamItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<InfoStreamItemDTO> findOne(Long id) {
        log.debug("Request to get InfoStreamItem : {}", id);
        return infoStreamItemRepository.findById(id)
            .map(infoStreamItemMapper::toDto);
    }

    /**
     * Delete the infoStreamItem by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete InfoStreamItem : {}", id);
        infoStreamItemRepository.deleteById(id);
    }
}
