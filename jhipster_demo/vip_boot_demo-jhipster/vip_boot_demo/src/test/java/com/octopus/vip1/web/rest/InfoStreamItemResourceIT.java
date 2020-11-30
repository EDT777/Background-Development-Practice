package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.InfoStreamItem;
import com.octopus.vip1.repository.InfoStreamItemRepository;
import com.octopus.vip1.service.InfoStreamItemService;
import com.octopus.vip1.service.dto.InfoStreamItemDTO;
import com.octopus.vip1.service.mapper.InfoStreamItemMapper;

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

import com.octopus.vip1.domain.enumeration.ItemResourceType;
/**
 * Integration tests for the {@link InfoStreamItemResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class InfoStreamItemResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DIGIST = "AAAAAAAAAA";
    private static final String UPDATED_DIGIST = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_USER = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_LAST_UPDATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_LAST_UPDATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_UPDATE_USER = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_USER = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_TAGS = "AAAAAAAAAA";
    private static final String UPDATED_TAGS = "BBBBBBBBBB";

    private static final ItemResourceType DEFAULT_CONTENT_TYPE = ItemResourceType.VIDEO;
    private static final ItemResourceType UPDATED_CONTENT_TYPE = ItemResourceType.AUDIO;

    @Autowired
    private InfoStreamItemRepository infoStreamItemRepository;

    @Autowired
    private InfoStreamItemMapper infoStreamItemMapper;

    @Autowired
    private InfoStreamItemService infoStreamItemService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInfoStreamItemMockMvc;

    private InfoStreamItem infoStreamItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoStreamItem createEntity(EntityManager em) {
        InfoStreamItem infoStreamItem = new InfoStreamItem()
            .title(DEFAULT_TITLE)
            .type(DEFAULT_TYPE)
            .digist(DEFAULT_DIGIST)
            .content(DEFAULT_CONTENT)
            .createUser(DEFAULT_CREATE_USER)
            .lastUpdateDate(DEFAULT_LAST_UPDATE_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .createDate(DEFAULT_CREATE_DATE)
            .tags(DEFAULT_TAGS)
            .contentType(DEFAULT_CONTENT_TYPE);
        return infoStreamItem;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InfoStreamItem createUpdatedEntity(EntityManager em) {
        InfoStreamItem infoStreamItem = new InfoStreamItem()
            .title(UPDATED_TITLE)
            .type(UPDATED_TYPE)
            .digist(UPDATED_DIGIST)
            .content(UPDATED_CONTENT)
            .createUser(UPDATED_CREATE_USER)
            .lastUpdateDate(UPDATED_LAST_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .createDate(UPDATED_CREATE_DATE)
            .tags(UPDATED_TAGS)
            .contentType(UPDATED_CONTENT_TYPE);
        return infoStreamItem;
    }

    @BeforeEach
    public void initTest() {
        infoStreamItem = createEntity(em);
    }

    @Test
    @Transactional
    public void createInfoStreamItem() throws Exception {
        int databaseSizeBeforeCreate = infoStreamItemRepository.findAll().size();

        // Create the InfoStreamItem
        InfoStreamItemDTO infoStreamItemDTO = infoStreamItemMapper.toDto(infoStreamItem);
        restInfoStreamItemMockMvc.perform(post("/api/info-stream-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoStreamItemDTO)))
            .andExpect(status().isCreated());

        // Validate the InfoStreamItem in the database
        List<InfoStreamItem> infoStreamItemList = infoStreamItemRepository.findAll();
        assertThat(infoStreamItemList).hasSize(databaseSizeBeforeCreate + 1);
        InfoStreamItem testInfoStreamItem = infoStreamItemList.get(infoStreamItemList.size() - 1);
        assertThat(testInfoStreamItem.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testInfoStreamItem.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testInfoStreamItem.getDigist()).isEqualTo(DEFAULT_DIGIST);
        assertThat(testInfoStreamItem.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testInfoStreamItem.getCreateUser()).isEqualTo(DEFAULT_CREATE_USER);
        assertThat(testInfoStreamItem.getLastUpdateDate()).isEqualTo(DEFAULT_LAST_UPDATE_DATE);
        assertThat(testInfoStreamItem.getUpdateUser()).isEqualTo(DEFAULT_UPDATE_USER);
        assertThat(testInfoStreamItem.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testInfoStreamItem.getTags()).isEqualTo(DEFAULT_TAGS);
        assertThat(testInfoStreamItem.getContentType()).isEqualTo(DEFAULT_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createInfoStreamItemWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = infoStreamItemRepository.findAll().size();

        // Create the InfoStreamItem with an existing ID
        infoStreamItem.setId(1L);
        InfoStreamItemDTO infoStreamItemDTO = infoStreamItemMapper.toDto(infoStreamItem);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInfoStreamItemMockMvc.perform(post("/api/info-stream-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoStreamItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoStreamItem in the database
        List<InfoStreamItem> infoStreamItemList = infoStreamItemRepository.findAll();
        assertThat(infoStreamItemList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInfoStreamItems() throws Exception {
        // Initialize the database
        infoStreamItemRepository.saveAndFlush(infoStreamItem);

        // Get all the infoStreamItemList
        restInfoStreamItemMockMvc.perform(get("/api/info-stream-items?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(infoStreamItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].digist").value(hasItem(DEFAULT_DIGIST)))
            .andExpect(jsonPath("$.[*].content").value(hasItem(DEFAULT_CONTENT)))
            .andExpect(jsonPath("$.[*].createUser").value(hasItem(DEFAULT_CREATE_USER)))
            .andExpect(jsonPath("$.[*].lastUpdateDate").value(hasItem(sameInstant(DEFAULT_LAST_UPDATE_DATE))))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].tags").value(hasItem(DEFAULT_TAGS)))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE.toString())));
    }
    
    @Test
    @Transactional
    public void getInfoStreamItem() throws Exception {
        // Initialize the database
        infoStreamItemRepository.saveAndFlush(infoStreamItem);

        // Get the infoStreamItem
        restInfoStreamItemMockMvc.perform(get("/api/info-stream-items/{id}", infoStreamItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(infoStreamItem.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.digist").value(DEFAULT_DIGIST))
            .andExpect(jsonPath("$.content").value(DEFAULT_CONTENT))
            .andExpect(jsonPath("$.createUser").value(DEFAULT_CREATE_USER))
            .andExpect(jsonPath("$.lastUpdateDate").value(sameInstant(DEFAULT_LAST_UPDATE_DATE)))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.tags").value(DEFAULT_TAGS))
            .andExpect(jsonPath("$.contentType").value(DEFAULT_CONTENT_TYPE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingInfoStreamItem() throws Exception {
        // Get the infoStreamItem
        restInfoStreamItemMockMvc.perform(get("/api/info-stream-items/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInfoStreamItem() throws Exception {
        // Initialize the database
        infoStreamItemRepository.saveAndFlush(infoStreamItem);

        int databaseSizeBeforeUpdate = infoStreamItemRepository.findAll().size();

        // Update the infoStreamItem
        InfoStreamItem updatedInfoStreamItem = infoStreamItemRepository.findById(infoStreamItem.getId()).get();
        // Disconnect from session so that the updates on updatedInfoStreamItem are not directly saved in db
        em.detach(updatedInfoStreamItem);
        updatedInfoStreamItem
            .title(UPDATED_TITLE)
            .type(UPDATED_TYPE)
            .digist(UPDATED_DIGIST)
            .content(UPDATED_CONTENT)
            .createUser(UPDATED_CREATE_USER)
            .lastUpdateDate(UPDATED_LAST_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .createDate(UPDATED_CREATE_DATE)
            .tags(UPDATED_TAGS)
            .contentType(UPDATED_CONTENT_TYPE);
        InfoStreamItemDTO infoStreamItemDTO = infoStreamItemMapper.toDto(updatedInfoStreamItem);

        restInfoStreamItemMockMvc.perform(put("/api/info-stream-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoStreamItemDTO)))
            .andExpect(status().isOk());

        // Validate the InfoStreamItem in the database
        List<InfoStreamItem> infoStreamItemList = infoStreamItemRepository.findAll();
        assertThat(infoStreamItemList).hasSize(databaseSizeBeforeUpdate);
        InfoStreamItem testInfoStreamItem = infoStreamItemList.get(infoStreamItemList.size() - 1);
        assertThat(testInfoStreamItem.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testInfoStreamItem.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testInfoStreamItem.getDigist()).isEqualTo(UPDATED_DIGIST);
        assertThat(testInfoStreamItem.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testInfoStreamItem.getCreateUser()).isEqualTo(UPDATED_CREATE_USER);
        assertThat(testInfoStreamItem.getLastUpdateDate()).isEqualTo(UPDATED_LAST_UPDATE_DATE);
        assertThat(testInfoStreamItem.getUpdateUser()).isEqualTo(UPDATED_UPDATE_USER);
        assertThat(testInfoStreamItem.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testInfoStreamItem.getTags()).isEqualTo(UPDATED_TAGS);
        assertThat(testInfoStreamItem.getContentType()).isEqualTo(UPDATED_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingInfoStreamItem() throws Exception {
        int databaseSizeBeforeUpdate = infoStreamItemRepository.findAll().size();

        // Create the InfoStreamItem
        InfoStreamItemDTO infoStreamItemDTO = infoStreamItemMapper.toDto(infoStreamItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInfoStreamItemMockMvc.perform(put("/api/info-stream-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(infoStreamItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InfoStreamItem in the database
        List<InfoStreamItem> infoStreamItemList = infoStreamItemRepository.findAll();
        assertThat(infoStreamItemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInfoStreamItem() throws Exception {
        // Initialize the database
        infoStreamItemRepository.saveAndFlush(infoStreamItem);

        int databaseSizeBeforeDelete = infoStreamItemRepository.findAll().size();

        // Delete the infoStreamItem
        restInfoStreamItemMockMvc.perform(delete("/api/info-stream-items/{id}", infoStreamItem.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<InfoStreamItem> infoStreamItemList = infoStreamItemRepository.findAll();
        assertThat(infoStreamItemList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
