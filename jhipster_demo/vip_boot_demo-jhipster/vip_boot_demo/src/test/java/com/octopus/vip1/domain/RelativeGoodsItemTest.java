package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class RelativeGoodsItemTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RelativeGoodsItem.class);
        RelativeGoodsItem relativeGoodsItem1 = new RelativeGoodsItem();
        relativeGoodsItem1.setId(1L);
        RelativeGoodsItem relativeGoodsItem2 = new RelativeGoodsItem();
        relativeGoodsItem2.setId(relativeGoodsItem1.getId());
        assertThat(relativeGoodsItem1).isEqualTo(relativeGoodsItem2);
        relativeGoodsItem2.setId(2L);
        assertThat(relativeGoodsItem1).isNotEqualTo(relativeGoodsItem2);
        relativeGoodsItem1.setId(null);
        assertThat(relativeGoodsItem1).isNotEqualTo(relativeGoodsItem2);
    }
}
