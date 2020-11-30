package com.octopus.vip1.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.octopus.vip1.web.rest.TestUtil;

public class ReplyVisitDataStatDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReplyVisitDataStatDTO.class);
        ReplyVisitDataStatDTO replyVisitDataStatDTO1 = new ReplyVisitDataStatDTO();
        replyVisitDataStatDTO1.setId(1L);
        ReplyVisitDataStatDTO replyVisitDataStatDTO2 = new ReplyVisitDataStatDTO();
        assertThat(replyVisitDataStatDTO1).isNotEqualTo(replyVisitDataStatDTO2);
        replyVisitDataStatDTO2.setId(replyVisitDataStatDTO1.getId());
        assertThat(replyVisitDataStatDTO1).isEqualTo(replyVisitDataStatDTO2);
        replyVisitDataStatDTO2.setId(2L);
        assertThat(replyVisitDataStatDTO1).isNotEqualTo(replyVisitDataStatDTO2);
        replyVisitDataStatDTO1.setId(null);
        assertThat(replyVisitDataStatDTO1).isNotEqualTo(replyVisitDataStatDTO2);
    }
}
