package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.InfoItemVisitDataStat;
import com.octopus.vip1.repository.InfoItemVisitDataStatRepository;
import com.octopus.vip1.service.InfoItemVisitDataStatService;
import com.octopus.vip1.service.dto.InfoItemVisitDataStatDTO;
import com.octopus.vip1.service.mapper.InfoItemVisitDataStatMapper;

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
 * Integration tests for the {@link InfoItemVisitDataStatResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class InfoItemVisitDataStatResourceIT {

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
    private InfoItemVisitDataStatRepository infoItemVisitDataStatRepository;

    @Autowired
    private InfoItemVisitDataStatMapper infoItemVisitDataStatMapper;

    @Autowired
    private InfoItemVisitDataStatService infoItemVisitDataStatService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInfoItemVisitDataStatMockMvc;

    private InfoItemVisitDataStat infoItemVisitDataStat;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoItemVisitDataStat createEntity(EntityManager em) {
        InfoItemVisitDataStat infoItemVisitDataStat = new InfoItemVisitDataStat()
            .clickCount(DEFAULT_CLICK_COUNT)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .source(DEFAULT_SOURCE)
            .termimal(DEFAULT_TERMIMAL)
            .replyCount(DEFAULT_REPLY_COUNT)
            .starCount(DEFAULT_STAR_COUNT);
        return infoItemVisitDataStat;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoItemVisitDataStat createUpdatedEntity(EntityManager em) {
        InfoItemVisitDataStat infoItemVisitDataStat = new InfoItemVisitDataStat()
            .clickCount(UPDATED_CLICK_COUNT)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .source(UPDATED_SOURCE)
            .termimal(UPDATED_TERMIMAL)
            .replyCount(UPDATED_REPLY_COUNT)
            .starCount(UPDATED_STAR_COUNT);
        return infoItemVisitDataStat;
    }

    @BeforeEach
    public void initTest() {
        infoItemVisitDataStat = createEntity(em);
    }

    @Test
    @Transactional
    public void createInfoItemVisitDataStat() throws Exception {
        int databaseSizeBeforeCreate = infoItemVisitDataStatRepository.findAll().size();

        // Create the InfoItemVisitDataStat
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO = infoItemVisitDataStatMapper.toDto(infoItemVisitDataStat);
        restInfoItemVisitDataStatMockMvc.perform(post("/api/info-item-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataStatDTO)))
            .andExpect(status().isCreated());

        // Validate the InfoItemVisitDataStat in the database
        List<InfoItemVisitDataStat> infoItemVisitDataStatList = infoItemVisitDataStatRepository.findAll();
        assertThat(infoItemVisitDataStatList).hasSize(databaseSizeBeforeCreate + 1);
        InfoItemVisitDataStat testInfoItemVisitDataStat = infoItemVisitDataStatList.get(infoItemVisitDataStatList.size() - 1);
        assertThat(testInfoItemVisitDataStat.getClickCount()).isEqualTo(DEFAULT_CLICK_COUNT);
        assertThat(testInfoItemVisitDataStat.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testInfoItemVisitDataStat.getEndDate()).isEqualTo(DEFAULT_END_DATE);
        assertThat(testInfoItemVisitDataStat.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testInfoItemVisitDataStat.getTermimal()).isEqualTo(DEFAULT_TERMIMAL);
        assertThat(testInfoItemVisitDataStat.getReplyCount()).isEqualTo(DEFAULT_REPLY_COUNT);
        assertThat(testInfoItemVisitDataStat.getStarCount()).isEqualTo(DEFAULT_STAR_COUNT);
    }

    @Test
    @Transactional
    public void createInfoItemVisitDataStatWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = infoItemVisitDataStatRepository.findAll().size();

        // Create the InfoItemVisitDataStat with an existing ID
        infoItemVisitDataStat.setId(1L);
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO = infoItemVisitDataStatMapper.toDto(infoItemVisitDataStat);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInfoItemVisitDataStatMockMvc.perform(post("/api/info-item-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataStatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoItemVisitDataStat in the database
        List<InfoItemVisitDataStat> infoItemVisitDataStatList = infoItemVisitDataStatRepository.findAll();
        assertThat(infoItemVisitDataStatList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInfoItemVisitDataStats() throws Exception {
        // Initialize the database
        infoItemVisitDataStatRepository.saveAndFlush(infoItemVisitDataStat);

        // Get all the infoItemVisitDataStatList
        restInfoItemVisitDataStatMockMvc.perform(get("/api/info-item-visit-data-stats?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(infoItemVisitDataStat.getId().intValue())))
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
    public void getInfoItemVisitDataStat() throws Exception {
        // Initialize the database
        infoItemVisitDataStatRepository.saveAndFlush(infoItemVisitDataStat);

        // Get the infoItemVisitDataStat
        restInfoItemVisitDataStatMockMvc.perform(get("/api/info-item-visit-data-stats/{id}", infoItemVisitDataStat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(infoItemVisitDataStat.getId().intValue()))
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
    public void getNonExistingInfoItemVisitDataStat() throws Exception {
        // Get the infoItemVisitDataStat
        restInfoItemVisitDataStatMockMvc.perform(get("/api/info-item-visit-data-stats/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInfoItemVisitDataStat() throws Exception {
        // Initialize the database
        infoItemVisitDataStatRepository.saveAndFlush(infoItemVisitDataStat);

        int databaseSizeBeforeUpdate = infoItemVisitDataStatRepository.findAll().size();

        // Update the infoItemVisitDataStat
        InfoItemVisitDataStat updatedInfoItemVisitDataStat = infoItemVisitDataStatRepository.findById(infoItemVisitDataStat.getId()).get();
        // Disconnect from session so that the updates on updatedInfoItemVisitDataStat are not directly saved in db
        em.detach(updatedInfoItemVisitDataStat);
        updatedInfoItemVisitDataStat
            .clickCount(UPDATED_CLICK_COUNT)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .source(UPDATED_SOURCE)
            .termimal(UPDATED_TERMIMAL)
            .replyCount(UPDATED_REPLY_COUNT)
            .starCount(UPDATED_STAR_COUNT);
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO = infoItemVisitDataStatMapper.toDto(updatedInfoItemVisitDataStat);

        restInfoItemVisitDataStatMockMvc.perform(put("/api/info-item-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataStatDTO)))
            .andExpect(status().isOk());

        // Validate the InfoItemVisitDataStat in the database
        List<InfoItemVisitDataStat> infoItemVisitDataStatList = infoItemVisitDataStatRepository.findAll();
        assertThat(infoItemVisitDataStatList).hasSize(databaseSizeBeforeUpdate);
        InfoItemVisitDataStat testInfoItemVisitDataStat = infoItemVisitDataStatList.get(infoItemVisitDataStatList.size() - 1);
        assertThat(testInfoItemVisitDataStat.getClickCount()).isEqualTo(UPDATED_CLICK_COUNT);
        assertThat(testInfoItemVisitDataStat.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testInfoItemVisitDataStat.getEndDate()).isEqualTo(UPDATED_END_DATE);
        assertThat(testInfoItemVisitDataStat.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testInfoItemVisitDataStat.getTermimal()).isEqualTo(UPDATED_TERMIMAL);
        assertThat(testInfoItemVisitDataStat.getReplyCount()).isEqualTo(UPDATED_REPLY_COUNT);
        assertThat(testInfoItemVisitDataStat.getStarCount()).isEqualTo(UPDATED_STAR_COUNT);
    }

    @Test
    @Transactional
    public void updateNonExistingInfoItemVisitDataStat() throws Exception {
        int databaseSizeBeforeUpdate = infoItemVisitDataStatRepository.findAll().size();

        // Create the InfoItemVisitDataStat
        InfoItemVisitDataStatDTO infoItemVisitDataStatDTO = infoItemVisitDataStatMapper.toDto(infoItemVisitDataStat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInfoItemVisitDataStatMockMvc.perform(put("/api/info-item-visit-data-stats").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataStatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoItemVisitDataStat in the database
        List<InfoItemVisitDataStat> infoItemVisitDataStatList = infoItemVisitDataStatRepository.findAll();
        assertThat(infoItemVisitDataStatList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInfoItemVisitDataStat() throws Exception {
        // Initialize the database
        infoItemVisitDataStatRepository.saveAndFlush(infoItemVisitDataStat);

        int databaseSizeBeforeDelete = infoItemVisitDataStatRepository.findAll().size();

        // Delete the infoItemVisitDataStat
        restInfoItemVisitDataStatMockMvc.perform(delete("/api/info-item-visit-data-stats/{id}", infoItemVisitDataStat.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<InfoItemVisitDataStat> infoItemVisitDataStatList = infoItemVisitDataStatRepository.findAll();
        assertThat(infoItemVisitDataStatList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
