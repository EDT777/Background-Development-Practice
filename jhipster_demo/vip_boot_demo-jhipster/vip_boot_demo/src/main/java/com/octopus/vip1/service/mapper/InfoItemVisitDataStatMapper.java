package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.InfoItemVisitDataStatDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link InfoItemVisitDataStat} and its DTO {@link InfoItemVisitDataStatDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface InfoItemVisitDataStatMapper extends EntityMapper<InfoItemVisitDataStatDTO, InfoItemVisitDataStat> {



    default InfoItemVisitDataStat fromId(Long id) {
        if (id == null) {
            return null;
        }
        InfoItemVisitDataStat infoItemVisitDataStat = new InfoItemVisitDataStat();
        infoItemVisitDataStat.setId(id);
        return infoItemVisitDataStat;
    }
}
