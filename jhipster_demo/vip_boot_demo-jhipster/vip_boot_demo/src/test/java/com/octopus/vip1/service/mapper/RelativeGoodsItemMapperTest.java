package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RelativeGoodsItemMapperTest {

    private RelativeGoodsItemMapper relativeGoodsItemMapper;

    @BeforeEach
    public void setUp() {
        relativeGoodsItemMapper = new RelativeGoodsItemMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(relativeGoodsItemMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(relativeGoodsItemMapper.fromId(null)).isNull();
    }
}
