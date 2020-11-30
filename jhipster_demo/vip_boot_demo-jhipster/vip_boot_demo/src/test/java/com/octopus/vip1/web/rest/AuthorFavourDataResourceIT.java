package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.AuthorFavourData;
import com.octopus.vip1.repository.AuthorFavourDataRepository;
import com.octopus.vip1.service.AuthorFavourDataService;
import com.octopus.vip1.service.dto.AuthorFavourDataDTO;
import com.octopus.vip1.service.mapper.AuthorFavourDataMapper;

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
 * Integration tests for the {@link AuthorFavourDataResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class AuthorFavourDataResourceIT {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final ZonedDateTime DEFAULT_CREATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private AuthorFavourDataRepository authorFavourDataRepository;

    @Autowired
    private AuthorFavourDataMapper authorFavourDataMapper;

    @Autowired
    private AuthorFavourDataService authorFavourDataService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAuthorFavourDataMockMvc;

    private AuthorFavourData authorFavourData;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthorFavourData createEntity(EntityManager em) {
        AuthorFavourData authorFavourData = new AuthorFavourData()
            .userId(DEFAULT_USER_ID)
            .createDate(DEFAULT_CREATE_DATE);
        return authorFavourData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthorFavourData createUpdatedEntity(EntityManager em) {
        AuthorFavourData authorFavourData = new AuthorFavourData()
            .userId(UPDATED_USER_ID)
            .createDate(UPDATED_CREATE_DATE);
        return authorFavourData;
    }

    @BeforeEach
    public void initTest() {
        authorFavourData = createEntity(em);
    }

    @Test
    @Transactional
    public void createAuthorFavourData() throws Exception {
        int databaseSizeBeforeCreate = authorFavourDataRepository.findAll().size();

        // Create the AuthorFavourData
        AuthorFavourDataDTO authorFavourDataDTO = authorFavourDataMapper.toDto(authorFavourData);
        restAuthorFavourDataMockMvc.perform(post("/api/author-favour-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authorFavourDataDTO)))
            .andExpect(status().isCreated());

        // Validate the AuthorFavourData in the database
        List<AuthorFavourData> authorFavourDataList = authorFavourDataRepository.findAll();
        assertThat(authorFavourDataList).hasSize(databaseSizeBeforeCreate + 1);
        AuthorFavourData testAuthorFavourData = authorFavourDataList.get(authorFavourDataList.size() - 1);
        assertThat(testAuthorFavourData.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testAuthorFavourData.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void createAuthorFavourDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = authorFavourDataRepository.findAll().size();

        // Create the AuthorFavourData with an existing ID
        authorFavourData.setId(1L);
        AuthorFavourDataDTO authorFavourDataDTO = authorFavourDataMapper.toDto(authorFavourData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAuthorFavourDataMockMvc.perform(post("/api/author-favour-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authorFavourDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthorFavourData in the database
        List<AuthorFavourData> authorFavourDataList = authorFavourDataRepository.findAll();
        assertThat(authorFavourDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAuthorFavourData() throws Exception {
        // Initialize the database
        authorFavourDataRepository.saveAndFlush(authorFavourData);

        // Get all the authorFavourDataList
        restAuthorFavourDataMockMvc.perform(get("/api/author-favour-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(authorFavourData.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))));
    }
    
    @Test
    @Transactional
    public void getAuthorFavourData() throws Exception {
        // Initialize the database
        authorFavourDataRepository.saveAndFlush(authorFavourData);

        // Get the authorFavourData
        restAuthorFavourDataMockMvc.perform(get("/api/author-favour-data/{id}", authorFavourData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(authorFavourData.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)));
    }

    @Test
    @Transactional
    public void getNonExistingAuthorFavourData() throws Exception {
        // Get the authorFavourData
        restAuthorFavourDataMockMvc.perform(get("/api/author-favour-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAuthorFavourData() throws Exception {
        // Initialize the database
        authorFavourDataRepository.saveAndFlush(authorFavourData);

        int databaseSizeBeforeUpdate = authorFavourDataRepository.findAll().size();

        // Update the authorFavourData
        AuthorFavourData updatedAuthorFavourData = authorFavourDataRepository.findById(authorFavourData.getId()).get();
        // Disconnect from session so that the updates on updatedAuthorFavourData are not directly saved in db
        em.detach(updatedAuthorFavourData);
        updatedAuthorFavourData
            .userId(UPDATED_USER_ID)
            .createDate(UPDATED_CREATE_DATE);
        AuthorFavourDataDTO authorFavourDataDTO = authorFavourDataMapper.toDto(updatedAuthorFavourData);

        restAuthorFavourDataMockMvc.perform(put("/api/author-favour-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authorFavourDataDTO)))
            .andExpect(status().isOk());

        // Validate the AuthorFavourData in the database
        List<AuthorFavourData> authorFavourDataList = authorFavourDataRepository.findAll();
        assertThat(authorFavourDataList).hasSize(databaseSizeBeforeUpdate);
        AuthorFavourData testAuthorFavourData = authorFavourDataList.get(authorFavourDataList.size() - 1);
        assertThat(testAuthorFavourData.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testAuthorFavourData.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingAuthorFavourData() throws Exception {
        int databaseSizeBeforeUpdate = authorFavourDataRepository.findAll().size();

        // Create the AuthorFavourData
        AuthorFavourDataDTO authorFavourDataDTO = authorFavourDataMapper.toDto(authorFavourData);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAuthorFavourDataMockMvc.perform(put("/api/author-favour-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authorFavourDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthorFavourData in the database
        List<AuthorFavourData> authorFavourDataList = authorFavourDataRepository.findAll();
        assertThat(authorFavourDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAuthorFavourData() throws Exception {
        // Initialize the database
        authorFavourDataRepository.saveAndFlush(authorFavourData);

        int databaseSizeBeforeDelete = authorFavourDataRepository.findAll().size();

        // Delete the authorFavourData
        restAuthorFavourDataMockMvc.perform(delete("/api/author-favour-data/{id}", authorFavourData.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AuthorFavourData> authorFavourDataList = authorFavourDataRepository.findAll();
        assertThat(authorFavourDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
