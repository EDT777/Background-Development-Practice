package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.ReplyVisitDataStat;
import com.octopus.vip1.repository.ReplyVisitDataStatRepository;
import com.octopus.vip1.service.ReplyVisitDataStatService;
import com.octopus.vip1.service.dto.ReplyVisitDataStatDTO;
import com.octopus.vip1.service.mapper.ReplyVisitDataStatMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.octopus.vip1.domain.enumeration.VisitSource;
/**
 * Integration tests for the {@link ReplyVisitDataStatResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class ReplyVisitDataStatResourceIT {

    private static final Long DEFAULT_CLICK_COUNT = 1L;
    private static final Long UPDATED_CLICK_COUNT = 2L;

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final VisitSource DEFAULT_SOURCE = VisitSource.SEARCH;
    private static final VisitSource UPDATED_SOURCE = VisitSource.LIST;

    private static final String DEFAULT_TERMIMAL = "AAAAAAAAAA";
    private static final String UPDATED_TERMIMAL = "BBBBBBBBBB";

    private static final Integer DEFAULT_REPLY_COUNT = 1;
    private static final Integer UPDATED_REPLY_COUNT = 2;

    private static final Integer DEFAULT_STAR_COUNT = 1;
    private static final Integer UPDATED_STAR_COUNT = 2;

    @Autowired
    private ReplyVisitDataStatRepository replyVisitDataStatRepository;

    @Autowired
    private ReplyVisitDataStatMapper replyVisitDataStatMapper;

    @Autowired
    private ReplyVisitDataStatService replyVisitDataStatService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReplyVisitDataStatMockMvc;

    private ReplyVisitDataStat replyVisitDataStat;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReplyVisitDataStat createEntity(EntityManager em) {
        ReplyVisitDataStat replyVisitDataStat = new ReplyVisitDataStat()
            .clickCount(DEFAULT_CLICK_COUNT)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .source(DEFAULT_SOURCE)
            .termimal(DEFAULT_TERMIMAL)
            .replyCount(DEFAULT_REPLY_COUNT)
            .starCount(DEFAULT_STAR_COUNT);
        return replyVisitDataStat;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReplyVisitDataStat createUpdatedEntity(EntityManager em) {
        ReplyVisitDataStat replyVisitDataStat = new ReplyVisitDataStat()
            .clickCount(UPDATED_CLICK_COUNT)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .source(UPDATED_SOURCE)
            .termimal(UPDATED_TERMIMAL)
            .replyCount(UPDATED_REPLY_COUNT)
            .starCount(UPDATED_STAR_COUNT);
        return replyVisitDataStat;
    }

    @BeforeEach
    public void initTest() {
        replyVisitDataStat = createEntity(em);
    }

    @Test
    @Transactional
    public void createReplyVisitDataStat() throws Exception {
        int databaseSizeBeforeCreate = replyVisitDataStatRepository.findAll().size();

        // Create the ReplyVisitDataStat
        ReplyVisitDataStatDTO replyVisitDataStatDTO = replyVisitDataStatMapper.toDto(replyVisitDataStat);
        restReplyVisitDataStatMockMvc.perform(post("/api/reply-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyVisitDataStatDTO)))
            .andExpect(status().isCreated());

        // Validate the ReplyVisitDataStat in the database
        List<ReplyVisitDataStat> replyVisitDataStatList = replyVisitDataStatRepository.findAll();
        assertThat(replyVisitDataStatList).hasSize(databaseSizeBeforeCreate + 1);
        ReplyVisitDataStat testReplyVisitDataStat = replyVisitDataStatList.get(replyVisitDataStatList.size() - 1);
        assertThat(testReplyVisitDataStat.getClickCount()).isEqualTo(DEFAULT_CLICK_COUNT);
        assertThat(testReplyVisitDataStat.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testReplyVisitDataStat.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testReplyVisitDataStat.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testReplyVisitDataStat.getTermimal()).isEqualTo(DEFAULT_TERMIMAL);
        assertThat(testReplyVisitDataStat.getReplyCount()).isEqualTo(DEFAULT_REPLY_COUNT);
        assertThat(testReplyVisitDataStat.getStarCount()).isEqualTo(DEFAULT_STAR_COUNT);
    }

    @Test
    @Transactional
    public void createReplyVisitDataStatWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = replyVisitDataStatRepository.findAll().size();

        // Create the ReplyVisitDataStat with an existing ID
        replyVisitDataStat.setId(1L);
        ReplyVisitDataStatDTO replyVisitDataStatDTO = replyVisitDataStatMapper.toDto(replyVisitDataStat);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReplyVisitDataStatMockMvc.perform(post("/api/reply-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyVisitDataStatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReplyVisitDataStat in the database
        List<ReplyVisitDataStat> replyVisitDataStatList = replyVisitDataStatRepository.findAll();
        assertThat(replyVisitDataStatList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReplyVisitDataStats() throws Exception {
        // Initialize the database
        replyVisitDataStatRepository.saveAndFlush(replyVisitDataStat);

        // Get all the replyVisitDataStatList
        restReplyVisitDataStatMockMvc.perform(get("/api/reply-visit-data-stats?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(replyVisitDataStat.getId().intValue())))
            .andExpect(jsonPath("$.[*].clickCount").value(hasItem(DEFAULT_CLICK_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE.toString())))
            .andExpect(jsonPath("$.[*].termimal").value(hasItem(DEFAULT_TERMIMAL)))
            .andExpect(jsonPath("$.[*].replyCount").value(hasItem(DEFAULT_REPLY_COUNT)))
            .andExpect(jsonPath("$.[*].starCount").value(hasItem(DEFAULT_STAR_COUNT)));
    }
    
    @Test
    @Transactional
    public void getReplyVisitDataStat() throws Exception {
        // Initialize the database
        replyVisitDataStatRepository.saveAndFlush(replyVisitDataStat);

        // Get the replyVisitDataStat
        restReplyVisitDataStatMockMvc.perform(get("/api/reply-visit-data-stats/{id}", replyVisitDataStat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(replyVisitDataStat.getId().intValue()))
            .andExpect(jsonPath("$.clickCount").value(DEFAULT_CLICK_COUNT.intValue()))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE.toString()))
            .andExpect(jsonPath("$.termimal").value(DEFAULT_TERMIMAL))
            .andExpect(jsonPath("$.replyCount").value(DEFAULT_REPLY_COUNT))
            .andExpect(jsonPath("$.starCount").value(DEFAULT_STAR_COUNT));
    }

    @Test
    @Transactional
    public void getNonExistingReplyVisitDataStat() throws Exception {
        // Get the replyVisitDataStat
        restReplyVisitDataStatMockMvc.perform(get("/api/reply-visit-data-stats/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReplyVisitDataStat() throws Exception {
        // Initialize the database
        replyVisitDataStatRepository.saveAndFlush(replyVisitDataStat);

        int databaseSizeBeforeUpdate = replyVisitDataStatRepository.findAll().size();

        // Update the replyVisitDataStat
        ReplyVisitDataStat updatedReplyVisitDataStat = replyVisitDataStatRepository.findById(replyVisitDataStat.getId()).get();
        // Disconnect from session so that the updates on updatedReplyVisitDataStat are not directly saved in db
        em.detach(updatedReplyVisitDataStat);
        updatedReplyVisitDataStat
            .clickCount(UPDATED_CLICK_COUNT)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .source(UPDATED_SOURCE)
            .termimal(UPDATED_TERMIMAL)
            .replyCount(UPDATED_REPLY_COUNT)
            .starCount(UPDATED_STAR_COUNT);
        ReplyVisitDataStatDTO replyVisitDataStatDTO = replyVisitDataStatMapper.toDto(updatedReplyVisitDataStat);

        restReplyVisitDataStatMockMvc.perform(put("/api/reply-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyVisitDataStatDTO)))
            .andExpect(status().isOk());

        // Validate the ReplyVisitDataStat in the database
        List<ReplyVisitDataStat> replyVisitDataStatList = replyVisitDataStatRepository.findAll();
        assertThat(replyVisitDataStatList).hasSize(databaseSizeBeforeUpdate);
        ReplyVisitDataStat testReplyVisitDataStat = replyVisitDataStatList.get(replyVisitDataStatList.size() - 1);
        assertThat(testReplyVisitDataStat.getClickCount()).isEqualTo(UPDATED_CLICK_COUNT);
        assertThat(testReplyVisitDataStat.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testReplyVisitDataStat.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testReplyVisitDataStat.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testReplyVisitDataStat.getTermimal()).isEqualTo(UPDATED_TERMIMAL);
        assertThat(testReplyVisitDataStat.getReplyCount()).isEqualTo(UPDATED_REPLY_COUNT);
        assertThat(testReplyVisitDataStat.getStarCount()).isEqualTo(UPDATED_STAR_COUNT);
    }

    @Test
    @Transactional
    public void updateNonExistingReplyVisitDataStat() throws Exception {
        int databaseSizeBeforeUpdate = replyVisitDataStatRepository.findAll().size();

        // Create the ReplyVisitDataStat
        ReplyVisitDataStatDTO replyVisitDataStatDTO = replyVisitDataStatMapper.toDto(replyVisitDataStat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReplyVisitDataStatMockMvc.perform(put("/api/reply-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(replyVisitDataStatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReplyVisitDataStat in the database
        List<ReplyVisitDataStat> replyVisitDataStatList = replyVisitDataStatRepository.findAll();
        assertThat(replyVisitDataStatList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReplyVisitDataStat() throws Exception {
        // Initialize the database
        replyVisitDataStatRepository.saveAndFlush(replyVisitDataStat);

        int databaseSizeBeforeDelete = replyVisitDataStatRepository.findAll().size();

        // Delete the replyVisitDataStat
        restReplyVisitDataStatMockMvc.perform(delete("/api/reply-visit-data-stats/{id}", replyVisitDataStat.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ReplyVisitDataStat> replyVisitDataStatList = replyVisitDataStatRepository.findAll();
        assertThat(replyVisitDataStatList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
