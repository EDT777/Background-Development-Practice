package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class ResourceItemDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResourceItemDTO.class);
        ResourceItemDTO resourceItemDTO1 = new ResourceItemDTO();
        resourceItemDTO1.setId(1L);
        ResourceItemDTO resourceItemDTO2 = new ResourceItemDTO();
        assertThat(resourceItemDTO1).isNotEqualTo(resourceItemDTO2);
        resourceItemDTO2.setId(resourceItemDTO1.getId());
        assertThat(resourceItemDTO1).isEqualTo(resourceItemDTO2);
        resourceItemDTO2.setId(2L);
        assertThat(resourceItemDTO1).isNotEqualTo(resourceItemDTO2);
        resourceItemDTO1.setId(null);
        assertThat(resourceItemDTO1).isNotEqualTo(resourceItemDTO2);
    }
}
