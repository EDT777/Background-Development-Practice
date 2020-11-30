package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoItemVisitDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoItemVisitData.class);
        InfoItemVisitData infoItemVisitData1 = new InfoItemVisitData();
        infoItemVisitData1.setId(1L);
        InfoItemVisitData infoItemVisitData2 = new InfoItemVisitData();
        infoItemVisitData2.setId(infoItemVisitData1.getId());
        assertThat(infoItemVisitData1).isEqualTo(infoItemVisitData2);
        infoItemVisitData2.setId(2L);
        assertThat(infoItemVisitData1).isNotEqualTo(infoItemVisitData2);
        infoItemVisitData1.setId(null);
        assertThat(infoItemVisitData1).isNotEqualTo(infoItemVisitData2);
    }
}
