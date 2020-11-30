package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class UserContentCollectionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserContentCollection.class);
        UserContentCollection userContentCollection1 = new UserContentCollection();
        userContentCollection1.setId(1L);
        UserContentCollection userContentCollection2 = new UserContentCollection();
        userContentCollection2.setId(userContentCollection1.getId());
        assertThat(userContentCollection1).isEqualTo(userContentCollection2);
        userContentCollection2.setId(2L);
        assertThat(userContentCollection1).isNotEqualTo(userContentCollection2);
        userContentCollection1.setId(null);
        assertThat(userContentCollection1).isNotEqualTo(userContentCollection2);
    }
}
