package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoStreamItemDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoStreamItemDTO.class);
        InfoStreamItemDTO infoStreamItemDTO1 = new InfoStreamItemDTO();
        infoStreamItemDTO1.setId(1L);
        InfoStreamItemDTO infoStreamItemDTO2 = new InfoStreamItemDTO();
        assertThat(infoStreamItemDTO1).isNotEqualTo(infoStreamItemDTO2);
        infoStreamItemDTO2.setId(infoStreamItemDTO1.getId());
        assertThat(infoStreamItemDTO1).isEqualTo(infoStreamItemDTO2);
        infoStreamItemDTO2.setId(2L);
        assertThat(infoStreamItemDTO1).isNotEqualTo(infoStreamItemDTO2);
        infoStreamItemDTO1.setId(null);
        assertThat(infoStreamItemDTO1).isNotEqualTo(infoStreamItemDTO2);
    }
}
