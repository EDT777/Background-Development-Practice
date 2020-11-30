package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class RelativeGoodsItemDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RelativeGoodsItemDTO.class);
        RelativeGoodsItemDTO relativeGoodsItemDTO1 = new RelativeGoodsItemDTO();
        relativeGoodsItemDTO1.setId(1L);
        RelativeGoodsItemDTO relativeGoodsItemDTO2 = new RelativeGoodsItemDTO();
        assertThat(relativeGoodsItemDTO1).isNotEqualTo(relativeGoodsItemDTO2);
        relativeGoodsItemDTO2.setId(relativeGoodsItemDTO1.getId());
        assertThat(relativeGoodsItemDTO1).isEqualTo(relativeGoodsItemDTO2);
        relativeGoodsItemDTO2.setId(2L);
        assertThat(relativeGoodsItemDTO1).isNotEqualTo(relativeGoodsItemDTO2);
        relativeGoodsItemDTO1.setId(null);
        assertThat(relativeGoodsItemDTO1).isNotEqualTo(relativeGoodsItemDTO2);
    }
}
