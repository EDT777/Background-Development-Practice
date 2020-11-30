package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.RelativeGoodsItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RelativeGoodsItem} and its DTO {@link RelativeGoodsItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {InfoStreamItemMapper.class})
public interface RelativeGoodsItemMapper extends EntityMapper<RelativeGoodsItemDTO, RelativeGoodsItem> {

    @Mapping(source = "streamItem.id", target = "streamItemId")
    @Mapping(source = "infoStreamItem.id", target = "infoStreamItemId")
    RelativeGoodsItemDTO toDto(RelativeGoodsItem relativeGoodsItem);

    @Mapping(source = "streamItemId", target = "streamItem")
    @Mapping(source = "infoStreamItemId", target = "infoStreamItem")
    RelativeGoodsItem toEntity(RelativeGoodsItemDTO relativeGoodsItemDTO);

    default RelativeGoodsItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        RelativeGoodsItem relativeGoodsItem = new RelativeGoodsItem();
        relativeGoodsItem.setId(id);
        return relativeGoodsItem;
    }
}
