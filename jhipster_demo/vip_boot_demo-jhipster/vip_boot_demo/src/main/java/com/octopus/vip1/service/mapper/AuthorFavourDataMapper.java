package com.octopus.vip1.service.mapper;


import com.octopus.vip1.domain.*;
import com.octopus.vip1.service.dto.AuthorFavourDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AuthorFavourData} and its DTO {@link AuthorFavourDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface AuthorFavourDataMapper extends EntityMapper<AuthorFavourDataDTO, AuthorFavourData> {

    @Mapping(source = "author.id", target = "authorId")
    AuthorFavourDataDTO toDto(AuthorFavourData authorFavourData);

    @Mapping(source = "authorId", target = "author")
    AuthorFavourData toEntity(AuthorFavourDataDTO authorFavourDataDTO);

    default AuthorFavourData fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuthorFavourData authorFavourData = new AuthorFavourData();
        authorFavourData.setId(id);
        return authorFavourData;
    }
}
