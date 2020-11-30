package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserContentCollectionMapperTest {

    private UserContentCollectionMapper userContentCollectionMapper;

    @BeforeEach
    public void setUp() {
        userContentCollectionMapper = new UserContentCollectionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(userContentCollectionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(userContentCollectionMapper.fromId(null)).isNull();
    }
}
