package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InfoItemVisitDataMapperTest {

    private InfoItemVisitDataMapper infoItemVisitDataMapper;

    @BeforeEach
    public void setUp() {
        infoItemVisitDataMapper = new InfoItemVisitDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(infoItemVisitDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(infoItemVisitDataMapper.fromId(null)).isNull();
    }
}
