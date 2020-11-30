package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InfoStreamItemMapperTest {

    private InfoStreamItemMapper infoStreamItemMapper;

    @BeforeEach
    public void setUp() {
        infoStreamItemMapper = new InfoStreamItemMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(infoStreamItemMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(infoStreamItemMapper.fromId(null)).isNull();
    }
}
