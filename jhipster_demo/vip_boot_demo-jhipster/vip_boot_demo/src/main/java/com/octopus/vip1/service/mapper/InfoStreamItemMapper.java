package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.InfoStreamItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link InfoStreamItem} and its DTO {@link InfoStreamItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface InfoStreamItemMapper extends EntityMapper<InfoStreamItemDTO, InfoStreamItem> {

    @Mapping(source = "author.id", target = "authorId")
    InfoStreamItemDTO toDto(InfoStreamItem infoStreamItem);

    @Mapping(target = "resources", ignore = true)
    @Mapping(target = "removeResource", ignore = true)
    @Mapping(target = "covers", ignore = true)
    @Mapping(target = "removeCover", ignore = true)
    @Mapping(target = "goods", ignore = true)
    @Mapping(target = "removeGoods", ignore = true)
    @Mapping(source = "authorId", target = "author")
    InfoStreamItem toEntity(InfoStreamItemDTO infoStreamItemDTO);

    default InfoStreamItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        InfoStreamItem infoStreamItem = new InfoStreamItem();
        infoStreamItem.setId(id);
        return infoStreamItem;
    }
}
