package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class StreamItemStarDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StreamItemStarDataDTO.class);
        StreamItemStarDataDTO streamItemStarDataDTO1 = new StreamItemStarDataDTO();
        streamItemStarDataDTO1.setId(1L);
        StreamItemStarDataDTO streamItemStarDataDTO2 = new StreamItemStarDataDTO();
        assertThat(streamItemStarDataDTO1).isNotEqualTo(streamItemStarDataDTO2);
        streamItemStarDataDTO2.setId(streamItemStarDataDTO1.getId());
        assertThat(streamItemStarDataDTO1).isEqualTo(streamItemStarDataDTO2);
        streamItemStarDataDTO2.setId(2L);
        assertThat(streamItemStarDataDTO1).isNotEqualTo(streamItemStarDataDTO2);
        streamItemStarDataDTO1.setId(null);
        assertThat(streamItemStarDataDTO1).isNotEqualTo(streamItemStarDataDTO2);
    }
}
