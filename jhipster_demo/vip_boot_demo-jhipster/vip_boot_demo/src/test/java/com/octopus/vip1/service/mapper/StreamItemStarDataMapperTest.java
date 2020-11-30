package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamItemStarDataMapperTest {

    private StreamItemStarDataMapper streamItemStarDataMapper;

    @BeforeEach
    public void setUp() {
        streamItemStarDataMapper = new StreamItemStarDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(streamItemStarDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(streamItemStarDataMapper.fromId(null)).isNull();
    }
}
