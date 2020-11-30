package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class AuthorFavourDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthorFavourData.class);
        AuthorFavourData authorFavourData1 = new AuthorFavourData();
        authorFavourData1.setId(1L);
        AuthorFavourData authorFavourData2 = new AuthorFavourData();
        authorFavourData2.setId(authorFavourData1.getId());
        assertThat(authorFavourData1).isEqualTo(authorFavourData2);
        authorFavourData2.setId(2L);
        assertThat(authorFavourData1).isNotEqualTo(authorFavourData2);
        authorFavourData1.setId(null);
        assertThat(authorFavourData1).isNotEqualTo(authorFavourData2);
    }
}
