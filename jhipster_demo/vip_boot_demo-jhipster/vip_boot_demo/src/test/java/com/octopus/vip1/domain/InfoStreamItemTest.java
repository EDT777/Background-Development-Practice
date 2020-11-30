package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class InfoStreamItemTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InfoStreamItem.class);
        InfoStreamItem infoStreamItem1 = new InfoStreamItem();
        infoStreamItem1.setId(1L);
        InfoStreamItem infoStreamItem2 = new InfoStreamItem();
        infoStreamItem2.setId(infoStreamItem1.getId());
        assertThat(infoStreamItem1).isEqualTo(infoStreamItem2);
        infoStreamItem2.setId(2L);
        assertThat(infoStreamItem1).isNotEqualTo(infoStreamItem2);
        infoStreamItem1.setId(null);
        assertThat(infoStreamItem1).isNotEqualTo(infoStreamItem2);
    }
}
