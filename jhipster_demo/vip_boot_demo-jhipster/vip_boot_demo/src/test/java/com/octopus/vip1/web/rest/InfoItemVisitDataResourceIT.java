package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.InfoItemVisitData;
import com.octopus.vip1.repository.InfoItemVisitDataRepository;
import com.octopus.vip1.service.InfoItemVisitDataService;
import com.octopus.vip1.service.dto.InfoItemVisitDataDTO;
import com.octopus.vip1.service.mapper.InfoItemVisitDataMapper;

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
 * Integration tests for the {@link InfoItemVisitDataResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class InfoItemVisitDataResourceIT {

    private static final String DEFAULT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_USER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DEVICE_NO = "AAAAAAAAAA";
    private static final String UPDATED_DEVICE_NO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final VisitSource DEFAULT_SOURCE = VisitSource.SEARCH;
    private static final VisitSource UPDATED_SOURCE = VisitSource.LIST;

    private static final String DEFAULT_ACTION = "AAAAAAAAAA";
    private static final String UPDATED_ACTION = "BBBBBBBBBB";

    private static final Long DEFAULT_GOODS = 1L;
    private static final Long UPDATED_GOODS = 2L;

    private static final String DEFAULT_TERMIMAL = "AAAAAAAAAA";
    private static final String UPDATED_TERMIMAL = "BBBBBBBBBB";

    @Autowired
    private InfoItemVisitDataRepository infoItemVisitDataRepository;

    @Autowired
    private InfoItemVisitDataMapper infoItemVisitDataMapper;

    @Autowired
    private InfoItemVisitDataService infoItemVisitDataService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInfoItemVisitDataMockMvc;

    private InfoItemVisitData infoItemVisitData;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoItemVisitData createEntity(EntityManager em) {
        InfoItemVisitData infoItemVisitData = new InfoItemVisitData()
            .userId(DEFAULT_USER_ID)
            .deviceNo(DEFAULT_DEVICE_NO)
            .date(DEFAULT_DATE)
            .source(DEFAULT_SOURCE)
            .action(DEFAULT_ACTION)
            .goods(DEFAULT_GOODS)
            .termimal(DEFAULT_TERMIMAL);
        return infoItemVisitData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoItemVisitData createUpdatedEntity(EntityManager em) {
        InfoItemVisitData infoItemVisitData = new InfoItemVisitData()
            .userId(UPDATED_USER_ID)
            .deviceNo(UPDATED_DEVICE_NO)
            .date(UPDATED_DATE)
            .source(UPDATED_SOURCE)
            .action(UPDATED_ACTION)
            .goods(UPDATED_GOODS)
            .termimal(UPDATED_TERMIMAL);
        return infoItemVisitData;
    }

    @BeforeEach
    public void initTest() {
        infoItemVisitData = createEntity(em);
    }

    @Test
    @Transactional
    public void createInfoItemVisitData() throws Exception {
        int databaseSizeBeforeCreate = infoItemVisitDataRepository.findAll().size();

        // Create the InfoItemVisitData
        InfoItemVisitDataDTO infoItemVisitDataDTO = infoItemVisitDataMapper.toDto(infoItemVisitData);
        restInfoItemVisitDataMockMvc.perform(post("/api/info-item-visit-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataDTO)))
            .andExpect(status().isCreated());

        // Validate the InfoItemVisitData in the database
        List<InfoItemVisitData> infoItemVisitDataList = infoItemVisitDataRepository.findAll();
        assertThat(infoItemVisitDataList).hasSize(databaseSizeBeforeCreate + 1);
        InfoItemVisitData testInfoItemVisitData = infoItemVisitDataList.get(infoItemVisitDataList.size() - 1);
        assertThat(testInfoItemVisitData.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testInfoItemVisitData.getDeviceNo()).isEqualTo(DEFAULT_DEVICE_NO);
        assertThat(testInfoItemVisitData.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testInfoItemVisitData.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testInfoItemVisitData.getAction()).isEqualTo(DEFAULT_ACTION);
        assertThat(testInfoItemVisitData.getGoods()).isEqualTo(DEFAULT_GOODS);
        assertThat(testInfoItemVisitData.getTermimal()).isEqualTo(DEFAULT_TERMIMAL);
    }

    @Test
    @Transactional
    public void createInfoItemVisitDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = infoItemVisitDataRepository.findAll().size();

        // Create the InfoItemVisitData with an existing ID
        infoItemVisitData.setId(1L);
        InfoItemVisitDataDTO infoItemVisitDataDTO = infoItemVisitDataMapper.toDto(infoItemVisitData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInfoItemVisitDataMockMvc.perform(post("/api/info-item-visit-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoItemVisitData in the database
        List<InfoItemVisitData> infoItemVisitDataList = infoItemVisitDataRepository.findAll();
        assertThat(infoItemVisitDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInfoItemVisitData() throws Exception {
        // Initialize the database
        infoItemVisitDataRepository.saveAndFlush(infoItemVisitData);

        // Get all the infoItemVisitDataList
        restInfoItemVisitDataMockMvc.perform(get("/api/info-item-visit-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(infoItemVisitData.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID)))
            .andExpect(jsonPath("$.[*].deviceNo").value(hasItem(DEFAULT_DEVICE_NO)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE.toString())))
            .andExpect(jsonPath("$.[*].action").value(hasItem(DEFAULT_ACTION)))
            .andExpect(jsonPath("$.[*].goods").value(hasItem(DEFAULT_GOODS.intValue())))
            .andExpect(jsonPath("$.[*].termimal").value(hasItem(DEFAULT_TERMIMAL)));
    }
    
    @Test
    @Transactional
    public void getInfoItemVisitData() throws Exception {
        // Initialize the database
        infoItemVisitDataRepository.saveAndFlush(infoItemVisitData);

        // Get the infoItemVisitData
        restInfoItemVisitDataMockMvc.perform(get("/api/info-item-visit-data/{id}", infoItemVisitData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(infoItemVisitData.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID))
            .andExpect(jsonPath("$.deviceNo").value(DEFAULT_DEVICE_NO))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE.toString()))
            .andExpect(jsonPath("$.action").value(DEFAULT_ACTION))
            .andExpect(jsonPath("$.goods").value(DEFAULT_GOODS.intValue()))
            .andExpect(jsonPath("$.termimal").value(DEFAULT_TERMIMAL));
    }

    @Test
    @Transactional
    public void getNonExistingInfoItemVisitData() throws Exception {
        // Get the infoItemVisitData
        restInfoItemVisitDataMockMvc.perform(get("/api/info-item-visit-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInfoItemVisitData() throws Exception {
        // Initialize the database
        infoItemVisitDataRepository.saveAndFlush(infoItemVisitData);

        int databaseSizeBeforeUpdate = infoItemVisitDataRepository.findAll().size();

        // Update the infoItemVisitData
        InfoItemVisitData updatedInfoItemVisitData = infoItemVisitDataRepository.findById(infoItemVisitData.getId()).get();
        // Disconnect from session so that the updates on updatedInfoItemVisitData are not directly saved in db
        em.detach(updatedInfoItemVisitData);
        updatedInfoItemVisitData
            .userId(UPDATED_USER_ID)
            .deviceNo(UPDATED_DEVICE_NO)
            .date(UPDATED_DATE)
            .source(UPDATED_SOURCE)
            .action(UPDATED_ACTION)
            .goods(UPDATED_GOODS)
            .termimal(UPDATED_TERMIMAL);
        InfoItemVisitDataDTO infoItemVisitDataDTO = infoItemVisitDataMapper.toDto(updatedInfoItemVisitData);

        restInfoItemVisitDataMockMvc.perform(put("/api/info-item-visit-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataDTO)))
            .andExpect(status().isOk());

        // Validate the InfoItemVisitData in the database
        List<InfoItemVisitData> infoItemVisitDataList = infoItemVisitDataRepository.findAll();
        assertThat(infoItemVisitDataList).hasSize(databaseSizeBeforeUpdate);
        InfoItemVisitData testInfoItemVisitData = infoItemVisitDataList.get(infoItemVisitDataList.size() - 1);
        assertThat(testInfoItemVisitData.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testInfoItemVisitData.getDeviceNo()).isEqualTo(UPDATED_DEVICE_NO);
        assertThat(testInfoItemVisitData.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testInfoItemVisitData.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testInfoItemVisitData.getAction()).isEqualTo(UPDATED_ACTION);
        assertThat(testInfoItemVisitData.getGoods()).isEqualTo(UPDATED_GOODS);
        assertThat(testInfoItemVisitData.getTermimal()).isEqualTo(UPDATED_TERMIMAL);
    }

    @Test
    @Transactional
    public void updateNonExistingInfoItemVisitData() throws Exception {
        int databaseSizeBeforeUpdate = infoItemVisitDataRepository.findAll().size();

        // Create the InfoItemVisitData
        InfoItemVisitDataDTO infoItemVisitDataDTO = infoItemVisitDataMapper.toDto(infoItemVisitData);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInfoItemVisitDataMockMvc.perform(put("/api/info-item-visit-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoItemVisitDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoItemVisitData in the database
        List<InfoItemVisitData> infoItemVisitDataList = infoItemVisitDataRepository.findAll();
        assertThat(infoItemVisitDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInfoItemVisitData() throws Exception {
        // Initialize the database
        infoItemVisitDataRepository.saveAndFlush(infoItemVisitData);

        int databaseSizeBeforeDelete = infoItemVisitDataRepository.findAll().size();

        // Delete the infoItemVisitData
        restInfoItemVisitDataMockMvc.perform(delete("/api/info-item-visit-data/{id}", infoItemVisitData.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<InfoItemVisitData> infoItemVisitDataList = infoItemVisitDataRepository.findAll();
        assertThat(infoItemVisitDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
