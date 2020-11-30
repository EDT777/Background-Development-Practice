package com.octopus.vip1.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class ReplyVisitDataStatTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReplyVisitDataStat.class);
        ReplyVisitDataStat replyVisitDataStat1 = new ReplyVisitDataStat();
        replyVisitDataStat1.setId(1L);
        ReplyVisitDataStat replyVisitDataStat2 = new ReplyVisitDataStat();
        replyVisitDataStat2.setId(replyVisitDataStat1.getId());
        assertThat(replyVisitDataStat1).isEqualTo(replyVisitDataStat2);
        replyVisitDataStat2.setId(2L);
        assertThat(replyVisitDataStat1).isNotEqualTo(replyVisitDataStat2);
        replyVisitDataStat1.setId(null);
        assertThat(replyVisitDataStat1).isNotEqualTo(replyVisitDataStat2);
    }
}
