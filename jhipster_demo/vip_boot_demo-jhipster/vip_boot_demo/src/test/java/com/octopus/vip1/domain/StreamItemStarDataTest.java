package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class StreamItemStarDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StreamItemStarData.class);
        StreamItemStarData streamItemStarData1 = new StreamItemStarData();
        streamItemStarData1.setId(1L);
        StreamItemStarData streamItemStarData2 = new StreamItemStarData();
        streamItemStarData2.setId(streamItemStarData1.getId());
        assertThat(streamItemStarData1).isEqualTo(streamItemStarData2);
        streamItemStarData2.setId(2L);
        assertThat(streamItemStarData1).isNotEqualTo(streamItemStarData2);
        streamItemStarData1.setId(null);
        assertThat(streamItemStarData1).isNotEqualTo(streamItemStarData2);
    }
}
