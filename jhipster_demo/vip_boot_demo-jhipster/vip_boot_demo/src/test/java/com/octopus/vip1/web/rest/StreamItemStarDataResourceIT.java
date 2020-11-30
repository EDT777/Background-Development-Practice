package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.StreamItemStarData;
import com.octopus.vip1.repository.StreamItemStarDataRepository;
import com.octopus.vip1.service.StreamItemStarDataService;
import com.octopus.vip1.service.dto.StreamItemStarDataDTO;
import com.octopus.vip1.service.mapper.StreamItemStarDataMapper;

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
 * Integration tests for the {@link StreamItemStarDataResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class StreamItemStarDataResourceIT {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final ZonedDateTime DEFAULT_CREATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Integer DEFAULT_TYPE = 1;
    private static final Integer UPDATED_TYPE = 2;

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_REPLAY_ID = "AAAAAAAAAA";
    private static final String UPDATED_REPLAY_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_VALID = false;
    private static final Boolean UPDATED_VALID = true;

    private static final Integer DEFAULT_STAR_TYPE = 1;
    private static final Integer UPDATED_STAR_TYPE = 2;

    @Autowired
    private StreamItemStarDataRepository streamItemStarDataRepository;

    @Autowired
    private StreamItemStarDataMapper streamItemStarDataMapper;

    @Autowired
    private StreamItemStarDataService streamItemStarDataService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restStreamItemStarDataMockMvc;

    private StreamItemStarData streamItemStarData;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static StreamItemStarData createEntity(EntityManager em) {
        StreamItemStarData streamItemStarData = new StreamItemStarData()
            .userId(DEFAULT_USER_ID)
            .createDate(DEFAULT_CREATE_DATE)
            .type(DEFAULT_TYPE)
            .itemId(DEFAULT_ITEM_ID)
            .replayId(DEFAULT_REPLAY_ID)
            .valid(DEFAULT_VALID)
            .starType(DEFAULT_STAR_TYPE);
        return streamItemStarData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static StreamItemStarData createUpdatedEntity(EntityManager em) {
        StreamItemStarData streamItemStarData = new StreamItemStarData()
            .userId(UPDATED_USER_ID)
            .createDate(UPDATED_CREATE_DATE)
            .type(UPDATED_TYPE)
            .itemId(UPDATED_ITEM_ID)
            .replayId(UPDATED_REPLAY_ID)
            .valid(UPDATED_VALID)
            .starType(UPDATED_STAR_TYPE);
        return streamItemStarData;
    }

    @BeforeEach
    public void initTest() {
        streamItemStarData = createEntity(em);
    }

    @Test
    @Transactional
    public void createStreamItemStarData() throws Exception {
        int databaseSizeBeforeCreate = streamItemStarDataRepository.findAll().size();

        // Create the StreamItemStarData
        StreamItemStarDataDTO streamItemStarDataDTO = streamItemStarDataMapper.toDto(streamItemStarData);
        restStreamItemStarDataMockMvc.perform(post("/api/stream-item-star-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(streamItemStarDataDTO)))
            .andExpect(status().isCreated());

        // Validate the StreamItemStarData in the database
        List<StreamItemStarData> streamItemStarDataList = streamItemStarDataRepository.findAll();
        assertThat(streamItemStarDataList).hasSize(databaseSizeBeforeCreate + 1);
        StreamItemStarData testStreamItemStarData = streamItemStarDataList.get(streamItemStarDataList.size() - 1);
        assertThat(testStreamItemStarData.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testStreamItemStarData.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testStreamItemStarData.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testStreamItemStarData.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testStreamItemStarData.getReplayId()).isEqualTo(DEFAULT_REPLAY_ID);
        assertThat(testStreamItemStarData.isValid()).isEqualTo(DEFAULT_VALID);
        assertThat(testStreamItemStarData.getStarType()).isEqualTo(DEFAULT_STAR_TYPE);
    }

    @Test
    @Transactional
    public void createStreamItemStarDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = streamItemStarDataRepository.findAll().size();

        // Create the StreamItemStarData with an existing ID
        streamItemStarData.setId(1L);
        StreamItemStarDataDTO streamItemStarDataDTO = streamItemStarDataMapper.toDto(streamItemStarData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStreamItemStarDataMockMvc.perform(post("/api/stream-item-star-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(streamItemStarDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StreamItemStarData in the database
        List<StreamItemStarData> streamItemStarDataList = streamItemStarDataRepository.findAll();
        assertThat(streamItemStarDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllStreamItemStarData() throws Exception {
        // Initialize the database
        streamItemStarDataRepository.saveAndFlush(streamItemStarData);

        // Get all the streamItemStarDataList
        restStreamItemStarDataMockMvc.perform(get("/api/stream-item-star-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(streamItemStarData.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].replayId").value(hasItem(DEFAULT_REPLAY_ID)))
            .andExpect(jsonPath("$.[*].valid").value(hasItem(DEFAULT_VALID.booleanValue())))
            .andExpect(jsonPath("$.[*].starType").value(hasItem(DEFAULT_STAR_TYPE)));
    }
    
    @Test
    @Transactional
    public void getStreamItemStarData() throws Exception {
        // Initialize the database
        streamItemStarDataRepository.saveAndFlush(streamItemStarData);

        // Get the streamItemStarData
        restStreamItemStarDataMockMvc.perform(get("/api/stream-item-star-data/{id}", streamItemStarData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(streamItemStarData.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.replayId").value(DEFAULT_REPLAY_ID))
            .andExpect(jsonPath("$.valid").value(DEFAULT_VALID.booleanValue()))
            .andExpect(jsonPath("$.starType").value(DEFAULT_STAR_TYPE));
    }

    @Test
    @Transactional
    public void getNonExistingStreamItemStarData() throws Exception {
        // Get the streamItemStarData
        restStreamItemStarDataMockMvc.perform(get("/api/stream-item-star-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStreamItemStarData() throws Exception {
        // Initialize the database
        streamItemStarDataRepository.saveAndFlush(streamItemStarData);

        int databaseSizeBeforeUpdate = streamItemStarDataRepository.findAll().size();

        // Update the streamItemStarData
        StreamItemStarData updatedStreamItemStarData = streamItemStarDataRepository.findById(streamItemStarData.getId()).get();
        // Disconnect from session so that the updates on updatedStreamItemStarData are not directly saved in db
        em.detach(updatedStreamItemStarData);
        updatedStreamItemStarData
            .userId(UPDATED_USER_ID)
            .createDate(UPDATED_CREATE_DATE)
            .type(UPDATED_TYPE)
            .itemId(UPDATED_ITEM_ID)
            .replayId(UPDATED_REPLAY_ID)
            .valid(UPDATED_VALID)
            .starType(UPDATED_STAR_TYPE);
        StreamItemStarDataDTO streamItemStarDataDTO = streamItemStarDataMapper.toDto(updatedStreamItemStarData);

        restStreamItemStarDataMockMvc.perform(put("/api/stream-item-star-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(streamItemStarDataDTO)))
            .andExpect(status().isOk());

        // Validate the StreamItemStarData in the database
        List<StreamItemStarData> streamItemStarDataList = streamItemStarDataRepository.findAll();
        assertThat(streamItemStarDataList).hasSize(databaseSizeBeforeUpdate);
        StreamItemStarData testStreamItemStarData = streamItemStarDataList.get(streamItemStarDataList.size() - 1);
        assertThat(testStreamItemStarData.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testStreamItemStarData.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testStreamItemStarData.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testStreamItemStarData.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testStreamItemStarData.getReplayId()).isEqualTo(UPDATED_REPLAY_ID);
        assertThat(testStreamItemStarData.isValid()).isEqualTo(UPDATED_VALID);
        assertThat(testStreamItemStarData.getStarType()).isEqualTo(UPDATED_STAR_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingStreamItemStarData() throws Exception {
        int databaseSizeBeforeUpdate = streamItemStarDataRepository.findAll().size();

        // Create the StreamItemStarData
        StreamItemStarDataDTO streamItemStarDataDTO = streamItemStarDataMapper.toDto(streamItemStarData);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStreamItemStarDataMockMvc.perform(put("/api/stream-item-star-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(streamItemStarDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StreamItemStarData in the database
        List<StreamItemStarData> streamItemStarDataList = streamItemStarDataRepository.findAll();
        assertThat(streamItemStarDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteStreamItemStarData() throws Exception {
        // Initialize the database
        streamItemStarDataRepository.saveAndFlush(streamItemStarData);

        int databaseSizeBeforeDelete = streamItemStarDataRepository.findAll().size();

        // Delete the streamItemStarData
        restStreamItemStarDataMockMvc.perform(delete("/api/stream-item-star-data/{id}", streamItemStarData.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<StreamItemStarData> streamItemStarDataList = streamItemStarDataRepository.findAll();
        assertThat(streamItemStarDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
