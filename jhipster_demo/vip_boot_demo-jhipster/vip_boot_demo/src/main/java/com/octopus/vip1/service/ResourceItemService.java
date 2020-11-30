package com.octopus.vip1.service;

import com.octopus.vip1.domain.ResourceItem;
import com.octopus.vip1.repository.ResourceItemRepository;
import com.octopus.vip1.service.dto.ResourceItemDTO;
import com.octopus.vip1.service.mapper.ResourceItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ResourceItem}.
 */
@Service
@Transactional
public class ResourceItemService {

    private final Logger log = LoggerFactory.getLogger(ResourceItemService.class);

    private final ResourceItemRepository resourceItemRepository;

    private final ResourceItemMapper resourceItemMapper;

    public ResourceItemService(ResourceItemRepository resourceItemRepository, ResourceItemMapper resourceItemMapper) {
        this.resourceItemRepository = resourceItemRepository;
        this.resourceItemMapper = resourceItemMapper;
    }

    /**
     * Save a resourceItem.
     *
     * @param resourceItemDTO the entity to save.
     * @return the persisted entity.
     */
    public ResourceItemDTO save(ResourceItemDTO resourceItemDTO) {
        log.debug("Request to save ResourceItem : {}", resourceItemDTO);
        ResourceItem resourceItem = resourceItemMapper.toEntity(resourceItemDTO);
        resourceItem = resourceItemRepository.save(resourceItem);
        return resourceItemMapper.toDto(resourceItem);
    }

    /**
     * Get all the resourceItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ResourceItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ResourceItems");
        return resourceItemRepository.findAll(pageable)
            .map(resourceItemMapper::toDto);
    }

    /**
     * Get one resourceItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ResourceItemDTO> findOne(Long id) {
        log.debug("Request to get ResourceItem : {}", id);
        return resourceItemRepository.findById(id)
            .map(resourceItemMapper::toDto);
    }

    /**
     * Delete the resourceItem by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ResourceItem : {}", id);
        resourceItemRepository.deleteById(id);
    }
}
