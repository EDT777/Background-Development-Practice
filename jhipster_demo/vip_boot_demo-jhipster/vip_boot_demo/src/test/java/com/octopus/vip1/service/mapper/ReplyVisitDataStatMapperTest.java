package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReplyVisitDataStatMapperTest {

    private ReplyVisitDataStatMapper replyVisitDataStatMapper;

    @BeforeEach
    public void setUp() {
        replyVisitDataStatMapper = new ReplyVisitDataStatMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(replyVisitDataStatMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(replyVisitDataStatMapper.fromId(null)).isNull();
    }
}
