package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.ReplyVisitDataStatDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReplyVisitDataStat} and its DTO {@link ReplyVisitDataStatDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReplyVisitDataStatMapper extends EntityMapper<ReplyVisitDataStatDTO, ReplyVisitDataStat> {



    default ReplyVisitDataStat fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReplyVisitDataStat replyVisitDataStat = new ReplyVisitDataStat();
        replyVisitDataStat.setId(id);
        return replyVisitDataStat;
    }
}
