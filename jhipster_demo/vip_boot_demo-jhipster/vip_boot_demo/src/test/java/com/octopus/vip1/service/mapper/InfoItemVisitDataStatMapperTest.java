package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InfoItemVisitDataStatMapperTest {

    private InfoItemVisitDataStatMapper infoItemVisitDataStatMapper;

    @BeforeEach
    public void setUp() {
        infoItemVisitDataStatMapper = new InfoItemVisitDataStatMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(infoItemVisitDataStatMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(infoItemVisitDataStatMapper.fromId(null)).isNull();
    }
}
