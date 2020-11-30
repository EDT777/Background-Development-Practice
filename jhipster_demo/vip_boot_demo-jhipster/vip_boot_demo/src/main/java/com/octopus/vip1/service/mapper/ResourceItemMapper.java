package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.ResourceItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ResourceItem} and its DTO {@link ResourceItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {InfoStreamItemMapper.class})
public interface ResourceItemMapper extends EntityMapper<ResourceItemDTO, ResourceItem> {

    @Mapping(source = "infoStreamItem.id", target = "infoStreamItemId")
    ResourceItemDTO toDto(ResourceItem resourceItem);

    @Mapping(source = "infoStreamItemId", target = "infoStreamItem")
    ResourceItem toEntity(ResourceItemDTO resourceItemDTO);

    default ResourceItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        ResourceItem resourceItem = new ResourceItem();
        resourceItem.setId(id);
        return resourceItem;
    }
}
