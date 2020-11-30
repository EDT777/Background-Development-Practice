package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class ResourceItemTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResourceItem.class);
        ResourceItem resourceItem1 = new ResourceItem();
        resourceItem1.setId(1L);
        ResourceItem resourceItem2 = new ResourceItem();
        resourceItem2.setId(resourceItem1.getId());
        assertThat(resourceItem1).isEqualTo(resourceItem2);
        resourceItem2.setId(2L);
        assertThat(resourceItem1).isNotEqualTo(resourceItem2);
        resourceItem1.setId(null);
        assertThat(resourceItem1).isNotEqualTo(resourceItem2);
    }
}
