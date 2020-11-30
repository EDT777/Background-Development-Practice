package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.UserContentCollectionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserContentCollection} and its DTO {@link UserContentCollectionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserContentCollectionMapper extends EntityMapper<UserContentCollectionDTO, UserContentCollection> {



    default UserContentCollection fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserContentCollection userContentCollection = new UserContentCollection();
        userContentCollection.setId(id);
        return userContentCollection;
    }
}
