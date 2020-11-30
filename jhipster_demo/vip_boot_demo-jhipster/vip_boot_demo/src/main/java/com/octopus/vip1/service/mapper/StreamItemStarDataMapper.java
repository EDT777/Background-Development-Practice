package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.StreamItemStarDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StreamItemStarData} and its DTO {@link StreamItemStarDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StreamItemStarDataMapper extends EntityMapper<StreamItemStarDataDTO, StreamItemStarData> {



    default StreamItemStarData fromId(Long id) {
        if (id == null) {
            return null;
        }
        StreamItemStarData streamItemStarData = new StreamItemStarData();
        streamItemStarData.setId(id);
        return streamItemStarData;
    }
}
