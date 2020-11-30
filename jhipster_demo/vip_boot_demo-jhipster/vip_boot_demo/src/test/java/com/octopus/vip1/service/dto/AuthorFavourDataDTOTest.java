package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class AuthorFavourDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthorFavourDataDTO.class);
        AuthorFavourDataDTO authorFavourDataDTO1 = new AuthorFavourDataDTO();
        authorFavourDataDTO1.setId(1L);
        AuthorFavourDataDTO authorFavourDataDTO2 = new AuthorFavourDataDTO();
        assertThat(authorFavourDataDTO1).isNotEqualTo(authorFavourDataDTO2);
        authorFavourDataDTO2.setId(authorFavourDataDTO1.getId());
        assertThat(authorFavourDataDTO1).isEqualTo(authorFavourDataDTO2);
        authorFavourDataDTO2.setId(2L);
        assertThat(authorFavourDataDTO1).isNotEqualTo(authorFavourDataDTO2);
        authorFavourDataDTO1.setId(null);
        assertThat(authorFavourDataDTO1).isNotEqualTo(authorFavourDataDTO2);
    }
}
