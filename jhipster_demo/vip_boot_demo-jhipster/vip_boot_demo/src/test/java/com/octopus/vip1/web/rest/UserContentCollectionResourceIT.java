package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.UserContentCollection;
import com.octopus.vip1.repository.UserContentCollectionRepository;
import com.octopus.vip1.service.UserContentCollectionService;
import com.octopus.vip1.service.dto.UserContentCollectionDTO;
import com.octopus.vip1.service.mapper.UserContentCollectionMapper;

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
 * Integration tests for the {@link UserContentCollectionResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class UserContentCollectionResourceIT {

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final String DEFAULT_PLATFORM = "AAAAAAAAAA";
    private static final String UPDATED_PLATFORM = "BBBBBBBBBB";

    private static final String DEFAULT_LINK = "AAAAAAAAAA";
    private static final String UPDATED_LINK = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_PCT_URL = "AAAAAAAAAA";
    private static final String UPDATED_PCT_URL = "BBBBBBBBBB";

    private static final Boolean DEFAULT_VALID = false;
    private static final Boolean UPDATED_VALID = true;

    @Autowired
    private UserContentCollectionRepository userContentCollectionRepository;

    @Autowired
    private UserContentCollectionMapper userContentCollectionMapper;

    @Autowired
    private UserContentCollectionService userContentCollectionService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUserContentCollectionMockMvc;

    private UserContentCollection userContentCollection;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserContentCollection createEntity(EntityManager em) {
        UserContentCollection userContentCollection = new UserContentCollection()
            .userId(DEFAULT_USER_ID)
            .platform(DEFAULT_PLATFORM)
            .link(DEFAULT_LINK)
            .createDate(DEFAULT_CREATE_DATE)
            .pctUrl(DEFAULT_PCT_URL)
            .valid(DEFAULT_VALID);
        return userContentCollection;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserContentCollection createUpdatedEntity(EntityManager em) {
        UserContentCollection userContentCollection = new UserContentCollection()
            .userId(UPDATED_USER_ID)
            .platform(UPDATED_PLATFORM)
            .link(UPDATED_LINK)
            .createDate(UPDATED_CREATE_DATE)
            .pctUrl(UPDATED_PCT_URL)
            .valid(UPDATED_VALID);
        return userContentCollection;
    }

    @BeforeEach
    public void initTest() {
        userContentCollection = createEntity(em);
    }

    @Test
    @Transactional
    public void createUserContentCollection() throws Exception {
        int databaseSizeBeforeCreate = userContentCollectionRepository.findAll().size();

        // Create the UserContentCollection
        UserContentCollectionDTO userContentCollectionDTO = userContentCollectionMapper.toDto(userContentCollection);
        restUserContentCollectionMockMvc.perform(post("/api/user-content-collections").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(userContentCollectionDTO)))
            .andExpect(status().isCreated());

        // Validate the UserContentCollection in the database
        List<UserContentCollection> userContentCollectionList = userContentCollectionRepository.findAll();
        assertThat(userContentCollectionList).hasSize(databaseSizeBeforeCreate + 1);
        UserContentCollection testUserContentCollection = userContentCollectionList.get(userContentCollectionList.size() - 1);
        assertThat(testUserContentCollection.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testUserContentCollection.getPlatform()).isEqualTo(DEFAULT_PLATFORM);
        assertThat(testUserContentCollection.getLink()).isEqualTo(DEFAULT_LINK);
        assertThat(testUserContentCollection.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testUserContentCollection.getPctUrl()).isEqualTo(DEFAULT_PCT_URL);
        assertThat(testUserContentCollection.isValid()).isEqualTo(DEFAULT_VALID);
    }

    @Test
    @Transactional
    public void createUserContentCollectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = userContentCollectionRepository.findAll().size();

        // Create the UserContentCollection with an existing ID
        userContentCollection.setId(1L);
        UserContentCollectionDTO userContentCollectionDTO = userContentCollectionMapper.toDto(userContentCollection);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserContentCollectionMockMvc.perform(post("/api/user-content-collections").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(userContentCollectionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UserContentCollection in the database
        List<UserContentCollection> userContentCollectionList = userContentCollectionRepository.findAll();
        assertThat(userContentCollectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllUserContentCollections() throws Exception {
        // Initialize the database
        userContentCollectionRepository.saveAndFlush(userContentCollection);

        // Get all the userContentCollectionList
        restUserContentCollectionMockMvc.perform(get("/api/user-content-collections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userContentCollection.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].platform").value(hasItem(DEFAULT_PLATFORM)))
            .andExpect(jsonPath("$.[*].link").value(hasItem(DEFAULT_LINK)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].pctUrl").value(hasItem(DEFAULT_PCT_URL)))
            .andExpect(jsonPath("$.[*].valid").value(hasItem(DEFAULT_VALID.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getUserContentCollection() throws Exception {
        // Initialize the database
        userContentCollectionRepository.saveAndFlush(userContentCollection);

        // Get the userContentCollection
        restUserContentCollectionMockMvc.perform(get("/api/user-content-collections/{id}", userContentCollection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(userContentCollection.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.platform").value(DEFAULT_PLATFORM))
            .andExpect(jsonPath("$.link").value(DEFAULT_LINK))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.pctUrl").value(DEFAULT_PCT_URL))
            .andExpect(jsonPath("$.valid").value(DEFAULT_VALID.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingUserContentCollection() throws Exception {
        // Get the userContentCollection
        restUserContentCollectionMockMvc.perform(get("/api/user-content-collections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUserContentCollection() throws Exception {
        // Initialize the database
        userContentCollectionRepository.saveAndFlush(userContentCollection);

        int databaseSizeBeforeUpdate = userContentCollectionRepository.findAll().size();

        // Update the userContentCollection
        UserContentCollection updatedUserContentCollection = userContentCollectionRepository.findById(userContentCollection.getId()).get();
        // Disconnect from session so that the updates on updatedUserContentCollection are not directly saved in db
        em.detach(updatedUserContentCollection);
        updatedUserContentCollection
            .userId(UPDATED_USER_ID)
            .platform(UPDATED_PLATFORM)
            .link(UPDATED_LINK)
            .createDate(UPDATED_CREATE_DATE)
            .pctUrl(UPDATED_PCT_URL)
            .valid(UPDATED_VALID);
        UserContentCollectionDTO userContentCollectionDTO = userContentCollectionMapper.toDto(updatedUserContentCollection);

        restUserContentCollectionMockMvc.perform(put("/api/user-content-collections").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(userContentCollectionDTO)))
            .andExpect(status().isOk());

        // Validate the UserContentCollection in the database
        List<UserContentCollection> userContentCollectionList = userContentCollectionRepository.findAll();
        assertThat(userContentCollectionList).hasSize(databaseSizeBeforeUpdate);
        UserContentCollection testUserContentCollection = userContentCollectionList.get(userContentCollectionList.size() - 1);
        assertThat(testUserContentCollection.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testUserContentCollection.getPlatform()).isEqualTo(UPDATED_PLATFORM);
        assertThat(testUserContentCollection.getLink()).isEqualTo(UPDATED_LINK);
        assertThat(testUserContentCollection.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testUserContentCollection.getPctUrl()).isEqualTo(UPDATED_PCT_URL);
        assertThat(testUserContentCollection.isValid()).isEqualTo(UPDATED_VALID);
    }

    @Test
    @Transactional
    public void updateNonExistingUserContentCollection() throws Exception {
        int databaseSizeBeforeUpdate = userContentCollectionRepository.findAll().size();

        // Create the UserContentCollection
        UserContentCollectionDTO userContentCollectionDTO = userContentCollectionMapper.toDto(userContentCollection);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUserContentCollectionMockMvc.perform(put("/api/user-content-collections").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(userContentCollectionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UserContentCollection in the database
        List<UserContentCollection> userContentCollectionList = userContentCollectionRepository.findAll();
        assertThat(userContentCollectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUserContentCollection() throws Exception {
        // Initialize the database
        userContentCollectionRepository.saveAndFlush(userContentCollection);

        int databaseSizeBeforeDelete = userContentCollectionRepository.findAll().size();

        // Delete the userContentCollection
        restUserContentCollectionMockMvc.perform(delete("/api/user-content-collections/{id}", userContentCollection.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<UserContentCollection> userContentCollectionList = userContentCollectionRepository.findAll();
        assertThat(userContentCollectionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
