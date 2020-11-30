package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceItemMapperTest {

    private ResourceItemMapper resourceItemMapper;

    @BeforeEach
    public void setUp() {
        resourceItemMapper = new ResourceItemMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(resourceItemMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(resourceItemMapper.fromId(null)).isNull();
    }
}
