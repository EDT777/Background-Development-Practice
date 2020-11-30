package com.octopus.vip1.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReplyMapperTest {

    private ReplyMapper replyMapper;

    @BeforeEach
    public void setUp() {
        replyMapper = new ReplyMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(replyMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(replyMapper.fromId(null)).isNull();
    }
}
