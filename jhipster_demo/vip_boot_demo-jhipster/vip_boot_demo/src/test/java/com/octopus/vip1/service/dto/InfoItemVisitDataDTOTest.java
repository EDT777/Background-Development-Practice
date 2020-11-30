package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoItemVisitDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoItemVisitDataDTO.class);
        InfoItemVisitDataDTO infoItemVisitDataDTO1 = new InfoItemVisitDataDTO();
        infoItemVisitDataDTO1.setId(1L);
        InfoItemVisitDataDTO infoItemVisitDataDTO2 = new InfoItemVisitDataDTO();
        assertThat(infoItemVisitDataDTO1).isNotEqualTo(infoItemVisitDataDTO2);
        infoItemVisitDataDTO2.setId(infoItemVisitDataDTO1.getId());
        assertThat(infoItemVisitDataDTO1).isEqualTo(infoItemVisitDataDTO2);
        infoItemVisitDataDTO2.setId(2L);
        assertThat(infoItemVisitDataDTO1).isNotEqualTo(infoItemVisitDataDTO2);
        infoItemVisitDataDTO1.setId(null);
        assertThat(infoItemVisitDataDTO1).isNotEqualTo(infoItemVisitDataDTO2);
    }
}
