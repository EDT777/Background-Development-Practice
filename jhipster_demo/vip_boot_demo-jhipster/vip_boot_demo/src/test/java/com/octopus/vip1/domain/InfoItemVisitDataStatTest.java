package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoItemVisitDataStatTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoItemVisitDataStat.class);
        InfoItemVisitDataStat infoItemVisitDataStat1 = new InfoItemVisitDataStat();
        infoItemVisitDataStat1.setId(1L);
        InfoItemVisitDataStat infoItemVisitDataStat2 = new InfoItemVisitDataStat();
        infoItemVisitDataStat2.setId(infoItemVisitDataStat1.getId());
        assertThat(infoItemVisitDataStat1).isEqualTo(infoItemVisitDataStat2);
        infoItemVisitDataStat2.setId(2L);
        assertThat(infoItemVisitDataStat1).isNotEqualTo(infoItemVisitDataStat2);
        infoItemVisitDataStat1.setId(null);
        assertThat(infoItemVisitDataStat1).isNotEqualTo(infoItemVisitDataStat2);
    }
}
