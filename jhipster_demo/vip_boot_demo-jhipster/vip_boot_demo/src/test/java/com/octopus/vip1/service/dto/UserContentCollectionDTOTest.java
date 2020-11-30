package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class UserContentCollectionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserContentCollectionDTO.class);
        UserContentCollectionDTO userContentCollectionDTO1 = new UserContentCollectionDTO();
        userContentCollectionDTO1.setId(1L);
        UserContentCollectionDTO userContentCollectionDTO2 = new UserContentCollectionDTO();
        assertThat(userContentCollectionDTO1).isNotEqualTo(userContentCollectionDTO2);
        userContentCollectionDTO2.setId(userContentCollectionDTO1.getId());
        assertThat(userContentCollectionDTO1).isEqualTo(userContentCollectionDTO2);
        userContentCollectionDTO2.setId(2L);
        assertThat(userContentCollectionDTO1).isNotEqualTo(userContentCollectionDTO2);
        userContentCollectionDTO1.setId(null);
        assertThat(userContentCollectionDTO1).isNotEqualTo(userContentCollectionDTO2);
    }
}
