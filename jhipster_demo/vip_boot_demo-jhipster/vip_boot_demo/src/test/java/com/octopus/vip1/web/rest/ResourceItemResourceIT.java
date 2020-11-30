package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.ResourceItem;
import com.octopus.vip1.repository.ResourceItemRepository;
import com.octopus.vip1.service.ResourceItemService;
import com.octopus.vip1.service.dto.ResourceItemDTO;
import com.octopus.vip1.service.mapper.ResourceItemMapper;

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
 * Integration tests for the {@link ResourceItemResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class ResourceItemResourceIT {

    private static final ItemResourceType DEFAULT_TYPE = ItemResourceType.VIDEO;
    private static final ItemResourceType UPDATED_TYPE = ItemResourceType.AUDIO;

    private static final String DEFAULT_PLATFORM = "AAAAAAAAAA";
    private static final String UPDATED_PLATFORM = "BBBBBBBBBB";

    private static final String DEFAULT_RESOURCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_RESOURCE_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_TRANSCODE_STATUS = false;
    private static final Boolean UPDATED_TRANSCODE_STATUS = true;

    private static final Boolean DEFAULT_UPLOAD_STATUS = false;
    private static final Boolean UPDATED_UPLOAD_STATUS = true;

    private static final ZonedDateTime DEFAULT_UPDATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_UPDATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Boolean DEFAULT_AUDIT_STATUS = false;
    private static final Boolean UPDATED_AUDIT_STATUS = true;

    private static final ZonedDateTime DEFAULT_AUDIT_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_AUDIT_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_AUDIT_INFO = "AAAAAAAAAA";
    private static final String UPDATED_AUDIT_INFO = "BBBBBBBBBB";

    private static final Long DEFAULT_FILE_SIZE = 1L;
    private static final Long UPDATED_FILE_SIZE = 2L;

    private static final Long DEFAULT_CONTENT_SIZE = 1L;
    private static final Long UPDATED_CONTENT_SIZE = 2L;

    private static final String DEFAULT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_URL = "AAAAAAAAAA";
    private static final String UPDATED_URL = "BBBBBBBBBB";

    private static final Long DEFAULT_URL_EXPIRE = 1L;
    private static final Long UPDATED_URL_EXPIRE = 2L;

    private static final String DEFAULT_PARAMS = "AAAAAAAAAA";
    private static final String UPDATED_PARAMS = "BBBBBBBBBB";

    private static final Long DEFAULT_AUDIT_USER = 1L;
    private static final Long UPDATED_AUDIT_USER = 2L;

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    @Autowired
    private ResourceItemRepository resourceItemRepository;

    @Autowired
    private ResourceItemMapper resourceItemMapper;

    @Autowired
    private ResourceItemService resourceItemService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restResourceItemMockMvc;

    private ResourceItem resourceItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResourceItem createEntity(EntityManager em) {
        ResourceItem resourceItem = new ResourceItem()
            .type(DEFAULT_TYPE)
            .platform(DEFAULT_PLATFORM)
            .resourceId(DEFAULT_RESOURCE_ID)
            .transcodeStatus(DEFAULT_TRANSCODE_STATUS)
            .uploadStatus(DEFAULT_UPLOAD_STATUS)
            .updateDate(DEFAULT_UPDATE_DATE)
            .auditStatus(DEFAULT_AUDIT_STATUS)
            .auditDate(DEFAULT_AUDIT_DATE)
            .auditInfo(DEFAULT_AUDIT_INFO)
            .fileSize(DEFAULT_FILE_SIZE)
            .contentSize(DEFAULT_CONTENT_SIZE)
            .source(DEFAULT_SOURCE)
            .url(DEFAULT_URL)
            .urlExpire(DEFAULT_URL_EXPIRE)
            .params(DEFAULT_PARAMS)
            .auditUser(DEFAULT_AUDIT_USER)
            .delFlag(DEFAULT_DEL_FLAG);
        return resourceItem;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResourceItem createUpdatedEntity(EntityManager em) {
        ResourceItem resourceItem = new ResourceItem()
            .type(UPDATED_TYPE)
            .platform(UPDATED_PLATFORM)
            .resourceId(UPDATED_RESOURCE_ID)
            .transcodeStatus(UPDATED_TRANSCODE_STATUS)
            .uploadStatus(UPDATED_UPLOAD_STATUS)
            .updateDate(UPDATED_UPDATE_DATE)
            .auditStatus(UPDATED_AUDIT_STATUS)
            .auditDate(UPDATED_AUDIT_DATE)
            .auditInfo(UPDATED_AUDIT_INFO)
            .fileSize(UPDATED_FILE_SIZE)
            .contentSize(UPDATED_CONTENT_SIZE)
            .source(UPDATED_SOURCE)
            .url(UPDATED_URL)
            .urlExpire(UPDATED_URL_EXPIRE)
            .params(UPDATED_PARAMS)
            .auditUser(UPDATED_AUDIT_USER)
            .delFlag(UPDATED_DEL_FLAG);
        return resourceItem;
    }

    @BeforeEach
    public void initTest() {
        resourceItem = createEntity(em);
    }

    @Test
    @Transactional
    public void createResourceItem() throws Exception {
        int databaseSizeBeforeCreate = resourceItemRepository.findAll().size();

        // Create the ResourceItem
        ResourceItemDTO resourceItemDTO = resourceItemMapper.toDto(resourceItem);
        restResourceItemMockMvc.perform(post("/api/resource-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(resourceItemDTO)))
            .andExpect(status().isCreated());

        // Validate the ResourceItem in the database
        List<ResourceItem> resourceItemList = resourceItemRepository.findAll();
        assertThat(resourceItemList).hasSize(databaseSizeBeforeCreate + 1);
        ResourceItem testResourceItem = resourceItemList.get(resourceItemList.size() - 1);
        assertThat(testResourceItem.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testResourceItem.getPlatform()).isEqualTo(DEFAULT_PLATFORM);
        assertThat(testResourceItem.getResourceId()).isEqualTo(DEFAULT_RESOURCE_ID);
        assertThat(testResourceItem.isTranscodeStatus()).isEqualTo(DEFAULT_TRANSCODE_STATUS);
        assertThat(testResourceItem.isUploadStatus()).isEqualTo(DEFAULT_UPLOAD_STATUS);
        assertThat(testResourceItem.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testResourceItem.isAuditStatus()).isEqualTo(DEFAULT_AUDIT_STATUS);
        assertThat(testResourceItem.getAuditDate()).isEqualTo(DEFAULT_AUDIT_DATE);
        assertThat(testResourceItem.getAuditInfo()).isEqualTo(DEFAULT_AUDIT_INFO);
        assertThat(testResourceItem.getFileSize()).isEqualTo(DEFAULT_FILE_SIZE);
        assertThat(testResourceItem.getContentSize()).isEqualTo(DEFAULT_CONTENT_SIZE);
        assertThat(testResourceItem.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testResourceItem.getUrl()).isEqualTo(DEFAULT_URL);
        assertThat(testResourceItem.getUrlExpire()).isEqualTo(DEFAULT_URL_EXPIRE);
        assertThat(testResourceItem.getParams()).isEqualTo(DEFAULT_PARAMS);
        assertThat(testResourceItem.getAuditUser()).isEqualTo(DEFAULT_AUDIT_USER);
        assertThat(testResourceItem.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
    }

    @Test
    @Transactional
    public void createResourceItemWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = resourceItemRepository.findAll().size();

        // Create the ResourceItem with an existing ID
        resourceItem.setId(1L);
        ResourceItemDTO resourceItemDTO = resourceItemMapper.toDto(resourceItem);

        // An entity with an existing ID cannot be created, so this API call must fail
        restResourceItemMockMvc.perform(post("/api/resource-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(resourceItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ResourceItem in the database
        List<ResourceItem> resourceItemList = resourceItemRepository.findAll();
        assertThat(resourceItemList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllResourceItems() throws Exception {
        // Initialize the database
        resourceItemRepository.saveAndFlush(resourceItem);

        // Get all the resourceItemList
        restResourceItemMockMvc.perform(get("/api/resource-items?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resourceItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].platform").value(hasItem(DEFAULT_PLATFORM)))
            .andExpect(jsonPath("$.[*].resourceId").value(hasItem(DEFAULT_RESOURCE_ID)))
            .andExpect(jsonPath("$.[*].transcodeStatus").value(hasItem(DEFAULT_TRANSCODE_STATUS.booleanValue())))
            .andExpect(jsonPath("$.[*].uploadStatus").value(hasItem(DEFAULT_UPLOAD_STATUS.booleanValue())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(sameInstant(DEFAULT_UPDATE_DATE))))
            .andExpect(jsonPath("$.[*].auditStatus").value(hasItem(DEFAULT_AUDIT_STATUS.booleanValue())))
            .andExpect(jsonPath("$.[*].auditDate").value(hasItem(sameInstant(DEFAULT_AUDIT_DATE))))
            .andExpect(jsonPath("$.[*].auditInfo").value(hasItem(DEFAULT_AUDIT_INFO)))
            .andExpect(jsonPath("$.[*].fileSize").value(hasItem(DEFAULT_FILE_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].contentSize").value(hasItem(DEFAULT_CONTENT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE)))
            .andExpect(jsonPath("$.[*].url").value(hasItem(DEFAULT_URL)))
            .andExpect(jsonPath("$.[*].urlExpire").value(hasItem(DEFAULT_URL_EXPIRE.intValue())))
            .andExpect(jsonPath("$.[*].params").value(hasItem(DEFAULT_PARAMS)))
            .andExpect(jsonPath("$.[*].auditUser").value(hasItem(DEFAULT_AUDIT_USER.intValue())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getResourceItem() throws Exception {
        // Initialize the database
        resourceItemRepository.saveAndFlush(resourceItem);

        // Get the resourceItem
        restResourceItemMockMvc.perform(get("/api/resource-items/{id}", resourceItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resourceItem.getId().intValue()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.platform").value(DEFAULT_PLATFORM))
            .andExpect(jsonPath("$.resourceId").value(DEFAULT_RESOURCE_ID))
            .andExpect(jsonPath("$.transcodeStatus").value(DEFAULT_TRANSCODE_STATUS.booleanValue()))
            .andExpect(jsonPath("$.uploadStatus").value(DEFAULT_UPLOAD_STATUS.booleanValue()))
            .andExpect(jsonPath("$.updateDate").value(sameInstant(DEFAULT_UPDATE_DATE)))
            .andExpect(jsonPath("$.auditStatus").value(DEFAULT_AUDIT_STATUS.booleanValue()))
            .andExpect(jsonPath("$.auditDate").value(sameInstant(DEFAULT_AUDIT_DATE)))
            .andExpect(jsonPath("$.auditInfo").value(DEFAULT_AUDIT_INFO))
            .andExpect(jsonPath("$.fileSize").value(DEFAULT_FILE_SIZE.intValue()))
            .andExpect(jsonPath("$.contentSize").value(DEFAULT_CONTENT_SIZE.intValue()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE))
            .andExpect(jsonPath("$.url").value(DEFAULT_URL))
            .andExpect(jsonPath("$.urlExpire").value(DEFAULT_URL_EXPIRE.intValue()))
            .andExpect(jsonPath("$.params").value(DEFAULT_PARAMS))
            .andExpect(jsonPath("$.auditUser").value(DEFAULT_AUDIT_USER.intValue()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingResourceItem() throws Exception {
        // Get the resourceItem
        restResourceItemMockMvc.perform(get("/api/resource-items/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateResourceItem() throws Exception {
        // Initialize the database
        resourceItemRepository.saveAndFlush(resourceItem);

        int databaseSizeBeforeUpdate = resourceItemRepository.findAll().size();

        // Update the resourceItem
        ResourceItem updatedResourceItem = resourceItemRepository.findById(resourceItem.getId()).get();
        // Disconnect from session so that the updates on updatedResourceItem are not directly saved in db
        em.detach(updatedResourceItem);
        updatedResourceItem
            .type(UPDATED_TYPE)
            .platform(UPDATED_PLATFORM)
            .resourceId(UPDATED_RESOURCE_ID)
            .transcodeStatus(UPDATED_TRANSCODE_STATUS)
            .uploadStatus(UPDATED_UPLOAD_STATUS)
            .updateDate(UPDATED_UPDATE_DATE)
            .auditStatus(UPDATED_AUDIT_STATUS)
            .auditDate(UPDATED_AUDIT_DATE)
            .auditInfo(UPDATED_AUDIT_INFO)
            .fileSize(UPDATED_FILE_SIZE)
            .contentSize(UPDATED_CONTENT_SIZE)
            .source(UPDATED_SOURCE)
            .url(UPDATED_URL)
            .urlExpire(UPDATED_URL_EXPIRE)
            .params(UPDATED_PARAMS)
            .auditUser(UPDATED_AUDIT_USER)
            .delFlag(UPDATED_DEL_FLAG);
        ResourceItemDTO resourceItemDTO = resourceItemMapper.toDto(updatedResourceItem);

        restResourceItemMockMvc.perform(put("/api/resource-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(resourceItemDTO)))
            .andExpect(status().isOk());

        // Validate the ResourceItem in the database
        List<ResourceItem> resourceItemList = resourceItemRepository.findAll();
        assertThat(resourceItemList).hasSize(databaseSizeBeforeUpdate);
        ResourceItem testResourceItem = resourceItemList.get(resourceItemList.size() - 1);
        assertThat(testResourceItem.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testResourceItem.getPlatform()).isEqualTo(UPDATED_PLATFORM);
        assertThat(testResourceItem.getResourceId()).isEqualTo(UPDATED_RESOURCE_ID);
        assertThat(testResourceItem.isTranscodeStatus()).isEqualTo(UPDATED_TRANSCODE_STATUS);
        assertThat(testResourceItem.isUploadStatus()).isEqualTo(UPDATED_UPLOAD_STATUS);
        assertThat(testResourceItem.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testResourceItem.isAuditStatus()).isEqualTo(UPDATED_AUDIT_STATUS);
        assertThat(testResourceItem.getAuditDate()).isEqualTo(UPDATED_AUDIT_DATE);
        assertThat(testResourceItem.getAuditInfo()).isEqualTo(UPDATED_AUDIT_INFO);
        assertThat(testResourceItem.getFileSize()).isEqualTo(UPDATED_FILE_SIZE);
        assertThat(testResourceItem.getContentSize()).isEqualTo(UPDATED_CONTENT_SIZE);
        assertThat(testResourceItem.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testResourceItem.getUrl()).isEqualTo(UPDATED_URL);
        assertThat(testResourceItem.getUrlExpire()).isEqualTo(UPDATED_URL_EXPIRE);
        assertThat(testResourceItem.getParams()).isEqualTo(UPDATED_PARAMS);
        assertThat(testResourceItem.getAuditUser()).isEqualTo(UPDATED_AUDIT_USER);
        assertThat(testResourceItem.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
    }

    @Test
    @Transactional
    public void updateNonExistingResourceItem() throws Exception {
        int databaseSizeBeforeUpdate = resourceItemRepository.findAll().size();

        // Create the ResourceItem
        ResourceItemDTO resourceItemDTO = resourceItemMapper.toDto(resourceItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResourceItemMockMvc.perform(put("/api/resource-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(resourceItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ResourceItem in the database
        List<ResourceItem> resourceItemList = resourceItemRepository.findAll();
        assertThat(resourceItemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteResourceItem() throws Exception {
        // Initialize the database
        resourceItemRepository.saveAndFlush(resourceItem);

        int databaseSizeBeforeDelete = resourceItemRepository.findAll().size();

        // Delete the resourceItem
        restResourceItemMockMvc.perform(delete("/api/resource-items/{id}", resourceItem.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ResourceItem> resourceItemList = resourceItemRepository.findAll();
        assertThat(resourceItemList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
