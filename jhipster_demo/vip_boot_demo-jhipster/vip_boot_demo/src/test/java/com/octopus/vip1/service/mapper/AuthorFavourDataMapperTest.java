package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorFavourDataMapperTest {

    private AuthorFavourDataMapper authorFavourDataMapper;

    @BeforeEach
    public void setUp() {
        authorFavourDataMapper = new AuthorFavourDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(authorFavourDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(authorFavourDataMapper.fromId(null)).isNull();
    }
}
