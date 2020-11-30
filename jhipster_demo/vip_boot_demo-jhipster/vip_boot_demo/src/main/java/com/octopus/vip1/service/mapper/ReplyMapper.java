package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.ReplyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Reply} and its DTO {@link ReplyDTO}.
 */
@Mapper(componentModel = "spring", uses = {InfoStreamItemMapper.class})
public interface ReplyMapper extends EntityMapper<ReplyDTO, Reply> {

    @Mapping(source = "replyTo.id", target = "replyToId")
    @Mapping(source = "item.id", target = "itemId")
    ReplyDTO toDto(Reply reply);

    @Mapping(source = "replyToId", target = "replyTo")
    @Mapping(source = "itemId", target = "item")
    Reply toEntity(ReplyDTO replyDTO);

    default Reply fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reply reply = new Reply();
        reply.setId(id);
        return reply;
    }
}
