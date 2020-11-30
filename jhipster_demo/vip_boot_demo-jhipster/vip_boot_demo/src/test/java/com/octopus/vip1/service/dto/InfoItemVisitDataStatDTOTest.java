package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoItemVisitDataStatDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoItemVisitDataStatDTO.class);
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO1 = new InfoItemVisitDataStatDTO();
        infoItemVisitDataStatDTO1.setId(1L);
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO2 = new InfoItemVisitDataStatDTO();
        assertThat(infoItemVisitDataStatDTO1).isNotEqualTo(infoItemVisitDataStatDTO2);
        infoItemVisitDataStatDTO2.setId(infoItemVisitDataStatDTO1.getId());
        assertThat(infoItemVisitDataStatDTO1).isEqualTo(infoItemVisitDataStatDTO2);
        infoItemVisitDataStatDTO2.setId(2L);
        assertThat(infoItemVisitDataStatDTO1).isNotEqualTo(infoItemVisitDataStatDTO2);
        infoItemVisitDataStatDTO1.setId(null);
        assertThat(infoItemVisitDataStatDTO1).isNotEqualTo(infoItemVisitDataStatDTO2);
    }
}
