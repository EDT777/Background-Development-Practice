package com.octopus.vip1.service;

import com.octopus.vip1.domain.RelativeGoodsItem;
import com.octopus.vip1.repository.RelativeGoodsItemRepository;
import com.octopus.vip1.service.dto.RelativeGoodsItemDTO;
import com.octopus.vip1.service.mapper.RelativeGoodsItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RelativeGoodsItem}.
 */
@Service
@Transactional
public class RelativeGoodsItemService {

    private final Logger log = LoggerFactory.getLogger(RelativeGoodsItemService.class);

    private final RelativeGoodsItemRepository relativeGoodsItemRepository;

    private final RelativeGoodsItemMapper relativeGoodsItemMapper;

    public RelativeGoodsItemService(RelativeGoodsItemRepository relativeGoodsItemRepository, RelativeGoodsItemMapper relativeGoodsItemMapper) {
        this.relativeGoodsItemRepository = relativeGoodsItemRepository;
        this.relativeGoodsItemMapper = relativeGoodsItemMapper;
    }

    /**
     * Save a relativeGoodsItem.
     *
     * @param relativeGoodsItemDTO the entity to save.
     * @return the persisted entity.
     */
    public RelativeGoodsItemDTO save(RelativeGoodsItemDTO relativeGoodsItemDTO) {
        log.debug("Request to save RelativeGoodsItem : {}", relativeGoodsItemDTO);
        RelativeGoodsItem relativeGoodsItem = relativeGoodsItemMapper.toEntity(relativeGoodsItemDTO);
        relativeGoodsItem = relativeGoodsItemRepository.save(relativeGoodsItem);
        return relativeGoodsItemMapper.toDto(relativeGoodsItem);
    }

    /**
     * Get all the relativeGoodsItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RelativeGoodsItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RelativeGoodsItems");
        return relativeGoodsItemRepository.findAll(pageable)
            .map(relativeGoodsItemMapper::toDto);
    }

    /**
     * Get one relativeGoodsItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RelativeGoodsItemDTO> findOne(Long id) {
        log.debug("Request to get RelativeGoodsItem : {}", id);
        return relativeGoodsItemRepository.findById(id)
            .map(relativeGoodsItemMapper::toDto);
    }

    /**
     * Delete the relativeGoodsItem by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RelativeGoodsItem : {}", id);
        relativeGoodsItemRepository.deleteById(id);
    }
}
