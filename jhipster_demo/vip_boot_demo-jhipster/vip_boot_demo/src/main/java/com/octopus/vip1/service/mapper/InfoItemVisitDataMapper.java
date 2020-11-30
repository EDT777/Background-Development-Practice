package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.InfoItemVisitDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link InfoItemVisitData} and its DTO {@link InfoItemVisitDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {InfoStreamItemMapper.class})
public interface InfoItemVisitDataMapper extends EntityMapper<InfoItemVisitDataDTO, InfoItemVisitData> {

    @Mapping(source = "streamItem.id", target = "streamItemId")
    InfoItemVisitDataDTO toDto(InfoItemVisitData infoItemVisitData);

    @Mapping(source = "streamItemId", target = "streamItem")
    InfoItemVisitData toEntity(InfoItemVisitDataDTO infoItemVisitDataDTO);

    default InfoItemVisitData fromId(Long id) {
        if (id == null) {
            return null;
        }
        InfoItemVisitData infoItemVisitData = new InfoItemVisitData();
        infoItemVisitData.setId(id);
        return infoItemVisitData;
    }
}
