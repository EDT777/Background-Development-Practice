package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.Reply;
import com.octopus.vip1.repository.ReplyRepository;
import com.octopus.vip1.service.ReplyService;
import com.octopus.vip1.service.dto.ReplyDTO;
import com.octopus.vip1.service.mapper.ReplyMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.octopus.vip1.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ReplyResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class ReplyResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT = "BBBBBBBBBB";

    private static final Boolean DEFAULT_AUDIT_STATUS = false;
    private static final Boolean UPDATED_AUDIT_STATUS = true;

    private static final ZonedDateTime DEFAULT_CREATE_DATA = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_AUDIT_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_AUDIT_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_CREATE_USER = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER = "BBBBBBBBBB";

    private static final Long DEFAULT_AUDIT_USER = 1L;
    private static final Long UPDATED_AUDIT_USER = 2L;

    private static final Long DEFAULT_REPLY_USER_ID = 1L;
    private static final Long UPDATED_REPLY_USER_ID = 2L;

    private static final String DEFAULT_REPLY_USER_NICK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REPLY_USER_NICK_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReplyMockMvc;

    private Reply reply;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reply createEntity(EntityManager em) {
        Reply reply = new Reply()
            .title(DEFAULT_TITLE)
            .content(DEFAULT_CONTENT)
            .auditStatus(DEFAULT_AUDIT_STATUS)
            .createData(DEFAULT_CREATE_DATA)
            .auditDate(DEFAULT_AUDIT_DATE)
            .createUser(DEFAULT_CREATE_USER)
            .auditUser(DEFAULT_AUDIT_USER)
            .replyUserId(DEFAULT_REPLY_USER_ID)
            .replyUserNickName(DEFAULT_REPLY_USER_NICK_NAME)
            .delFlag(DEFAULT_DEL_FLAG);
        return reply;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reply createUpdatedEntity(EntityManager em) {
        Reply reply = new Reply()
            .title(UPDATED_TITLE)
            .content(UPDATED_CONTENT)
            .auditStatus(UPDATED_AUDIT_STATUS)
            .createData(UPDATED_CREATE_DATA)
            .auditDate(UPDATED_AUDIT_DATE)
            .createUser(UPDATED_CREATE_USER)
            .auditUser(UPDATED_AUDIT_USER)
            .replyUserId(UPDATED_REPLY_USER_ID)
            .replyUserNickName(UPDATED_REPLY_USER_NICK_NAME)
            .delFlag(UPDATED_DEL_FLAG);
        return reply;
    }

    @BeforeEach
    public void initTest() {
        reply = createEntity(em);
    }

    @Test
    @Transactional
    public void createReply() throws Exception {
        int databaseSizeBeforeCreate = replyRepository.findAll().size();

        // Create the Reply
        ReplyDTO replyDTO = replyMapper.toDto(reply);
        restReplyMockMvc.perform(post("/api/replies").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isCreated());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeCreate + 1);
        Reply testReply = replyList.get(replyList.size() - 1);
        assertThat(testReply.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testReply.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testReply.isAuditStatus()).isEqualTo(DEFAULT_AUDIT_STATUS);
        assertThat(testReply.getCreateData()).isEqualTo(DEFAULT_CREATE_DATA);
        assertThat(testReply.getAuditDate()).isEqualTo(DEFAULT_AUDIT_DATE);
        assertThat(testReply.getCreateUser()).isEqualTo(DEFAULT_CREATE_USER);
        assertThat(testReply.getAuditUser()).isEqualTo(DEFAULT_AUDIT_USER);
        assertThat(testReply.getReplyUserId()).isEqualTo(DEFAULT_REPLY_USER_ID);
        assertThat(testReply.getReplyUserNickName()).isEqualTo(DEFAULT_REPLY_USER_NICK_NAME);
        assertThat(testReply.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
    }

    @Test
    @Transactional
    public void createReplyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = replyRepository.findAll().size();

        // Create the Reply with an existing ID
        reply.setId(1L);
        ReplyDTO replyDTO = replyMapper.toDto(reply);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReplyMockMvc.perform(post("/api/replies").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReplies() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        // Get all the replyList
        restReplyMockMvc.perform(get("/api/replies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reply.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].content").value(hasItem(DEFAULT_CONTENT)))
            .andExpect(jsonPath("$.[*].auditStatus").value(hasItem(DEFAULT_AUDIT_STATUS.booleanValue())))
            .andExpect(jsonPath("$.[*].createData").value(hasItem(sameInstant(DEFAULT_CREATE_DATA))))
            .andExpect(jsonPath("$.[*].auditDate").value(hasItem(sameInstant(DEFAULT_AUDIT_DATE))))
            .andExpect(jsonPath("$.[*].createUser").value(hasItem(DEFAULT_CREATE_USER)))
            .andExpect(jsonPath("$.[*].auditUser").value(hasItem(DEFAULT_AUDIT_USER.intValue())))
            .andExpect(jsonPath("$.[*].replyUserId").value(hasItem(DEFAULT_REPLY_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].replyUserNickName").value(hasItem(DEFAULT_REPLY_USER_NICK_NAME)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        // Get the reply
        restReplyMockMvc.perform(get("/api/replies/{id}", reply.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reply.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.content").value(DEFAULT_CONTENT))
            .andExpect(jsonPath("$.auditStatus").value(DEFAULT_AUDIT_STATUS.booleanValue()))
            .andExpect(jsonPath("$.createData").value(sameInstant(DEFAULT_CREATE_DATA)))
            .andExpect(jsonPath("$.auditDate").value(sameInstant(DEFAULT_AUDIT_DATE)))
            .andExpect(jsonPath("$.createUser").value(DEFAULT_CREATE_USER))
            .andExpect(jsonPath("$.auditUser").value(DEFAULT_AUDIT_USER.intValue()))
            .andExpect(jsonPath("$.replyUserId").value(DEFAULT_REPLY_USER_ID.intValue()))
            .andExpect(jsonPath("$.replyUserNickName").value(DEFAULT_REPLY_USER_NICK_NAME))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReply() throws Exception {
        // Get the reply
        restReplyMockMvc.perform(get("/api/replies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        int databaseSizeBeforeUpdate = replyRepository.findAll().size();

        // Update the reply
        Reply updatedReply = replyRepository.findById(reply.getId()).get();
        // Disconnect from session so that the updates on updatedReply are not directly saved in db
        em.detach(updatedReply);
        updatedReply
            .title(UPDATED_TITLE)
            .content(UPDATED_CONTENT)
            .auditStatus(UPDATED_AUDIT_STATUS)
            .createData(UPDATED_CREATE_DATA)
            .auditDate(UPDATED_AUDIT_DATE)
            .createUser(UPDATED_CREATE_USER)
            .auditUser(UPDATED_AUDIT_USER)
            .replyUserId(UPDATED_REPLY_USER_ID)
            .replyUserNickName(UPDATED_REPLY_USER_NICK_NAME)
            .delFlag(UPDATED_DEL_FLAG);
        ReplyDTO replyDTO = replyMapper.toDto(updatedReply);

        restReplyMockMvc.perform(put("/api/replies").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isOk());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeUpdate);
        Reply testReply = replyList.get(replyList.size() - 1);
        assertThat(testReply.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testReply.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testReply.isAuditStatus()).isEqualTo(UPDATED_AUDIT_STATUS);
        assertThat(testReply.getCreateData()).isEqualTo(UPDATED_CREATE_DATA);
        assertThat(testReply.getAuditDate()).isEqualTo(UPDATED_AUDIT_DATE);
        assertThat(testReply.getCreateUser()).isEqualTo(UPDATED_CREATE_USER);
        assertThat(testReply.getAuditUser()).isEqualTo(UPDATED_AUDIT_USER);
        assertThat(testReply.getReplyUserId()).isEqualTo(UPDATED_REPLY_USER_ID);
        assertThat(testReply.getReplyUserNickName()).isEqualTo(UPDATED_REPLY_USER_NICK_NAME);
        assertThat(testReply.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
    }

    @Test
    @Transactional
    public void updateNonExistingReply() throws Exception {
        int databaseSizeBeforeUpdate = replyRepository.findAll().size();

        // Create the Reply
        ReplyDTO replyDTO = replyMapper.toDto(reply);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReplyMockMvc.perform(put("/api/replies").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reply in the database
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReply() throws Exception {
        // Initialize the database
        replyRepository.saveAndFlush(reply);

        int databaseSizeBeforeDelete = replyRepository.findAll().size();

        // Delete the reply
        restReplyMockMvc.perform(delete("/api/replies/{id}", reply.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Reply> replyList = replyRepository.findAll();
        assertThat(replyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
