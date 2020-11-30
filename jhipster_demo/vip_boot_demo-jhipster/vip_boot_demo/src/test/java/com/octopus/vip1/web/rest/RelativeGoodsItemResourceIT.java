package com.octopus.vip1.web.rest;

import com.octopus.vip1.RedisTestContainerExtension;
import com.octopus.vip1.Vip1App;
import com.octopus.vip1.domain.RelativeGoodsItem;
import com.octopus.vip1.repository.RelativeGoodsItemRepository;
import com.octopus.vip1.service.RelativeGoodsItemService;
import com.octopus.vip1.service.dto.RelativeGoodsItemDTO;
import com.octopus.vip1.service.mapper.RelativeGoodsItemMapper;

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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link RelativeGoodsItemResource} REST controller.
 */
@SpringBootTest(classes = Vip1App.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class RelativeGoodsItemResourceIT {

    private static final String DEFAULT_PLATFORM = "AAAAAAAAAA";
    private static final String UPDATED_PLATFORM = "BBBBBBBBBB";

    private static final String DEFAULT_URL = "AAAAAAAAAA";
    private static final String UPDATED_URL = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_TRANSLATED = false;
    private static final Boolean UPDATED_TRANSLATED = true;

    private static final String DEFAULT_TRANSLATED_URL = "AAAAAAAAAA";
    private static final String UPDATED_TRANSLATED_URL = "BBBBBBBBBB";

    private static final String DEFAULT_MAIN_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_MAIN_IMAGE = "BBBBBBBBBB";

    private static final String DEFAULT_SMALL_IMAGES = "AAAAAAAAAA";
    private static final String UPDATED_SMALL_IMAGES = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_SHOP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SHOP_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_SELL_COUNT = 1;
    private static final Integer UPDATED_SELL_COUNT = 2;

    private static final Double DEFAULT_PRICE = 1D;
    private static final Double UPDATED_PRICE = 2D;

    private static final Double DEFAULT_ZK_PRICE = 1D;
    private static final Double UPDATED_ZK_PRICE = 2D;

    private static final Double DEFAULT_COMMSSION = 1D;
    private static final Double UPDATED_COMMSSION = 2D;

    private static final Double DEFAULT_COMMSSION_RATE = 1D;
    private static final Double UPDATED_COMMSSION_RATE = 2D;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Double DEFAULT_COUPON = 1D;
    private static final Double UPDATED_COUPON = 2D;

    @Autowired
    private RelativeGoodsItemRepository relativeGoodsItemRepository;

    @Autowired
    private RelativeGoodsItemMapper relativeGoodsItemMapper;

    @Autowired
    private RelativeGoodsItemService relativeGoodsItemService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRelativeGoodsItemMockMvc;

    private RelativeGoodsItem relativeGoodsItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RelativeGoodsItem createEntity(EntityManager em) {
        RelativeGoodsItem relativeGoodsItem = new RelativeGoodsItem()
            .platform(DEFAULT_PLATFORM)
            .url(DEFAULT_URL)
            .itemId(DEFAULT_ITEM_ID)
            .translated(DEFAULT_TRANSLATED)
            .translatedUrl(DEFAULT_TRANSLATED_URL)
            .mainImage(DEFAULT_MAIN_IMAGE)
            .smallImages(DEFAULT_SMALL_IMAGES)
            .title(DEFAULT_TITLE)
            .shopName(DEFAULT_SHOP_NAME)
            .sellCount(DEFAULT_SELL_COUNT)
            .price(DEFAULT_PRICE)
            .zkPrice(DEFAULT_ZK_PRICE)
            .commssion(DEFAULT_COMMSSION)
            .commssionRate(DEFAULT_COMMSSION_RATE)
            .description(DEFAULT_DESCRIPTION)
            .coupon(DEFAULT_COUPON);
        return relativeGoodsItem;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RelativeGoodsItem createUpdatedEntity(EntityManager em) {
        RelativeGoodsItem relativeGoodsItem = new RelativeGoodsItem()
            .platform(UPDATED_PLATFORM)
            .url(UPDATED_URL)
            .itemId(UPDATED_ITEM_ID)
            .translated(UPDATED_TRANSLATED)
            .translatedUrl(UPDATED_TRANSLATED_URL)
            .mainImage(UPDATED_MAIN_IMAGE)
            .smallImages(UPDATED_SMALL_IMAGES)
            .title(UPDATED_TITLE)
            .shopName(UPDATED_SHOP_NAME)
            .sellCount(UPDATED_SELL_COUNT)
            .price(UPDATED_PRICE)
            .zkPrice(UPDATED_ZK_PRICE)
            .commssion(UPDATED_COMMSSION)
            .commssionRate(UPDATED_COMMSSION_RATE)
            .description(UPDATED_DESCRIPTION)
            .coupon(UPDATED_COUPON);
        return relativeGoodsItem;
    }

    @BeforeEach
    public void initTest() {
        relativeGoodsItem = createEntity(em);
    }

    @Test
    @Transactional
    public void createRelativeGoodsItem() throws Exception {
        int databaseSizeBeforeCreate = relativeGoodsItemRepository.findAll().size();

        // Create the RelativeGoodsItem
        RelativeGoodsItemDTO relativeGoodsItemDTO = relativeGoodsItemMapper.toDto(relativeGoodsItem);
        restRelativeGoodsItemMockMvc.perform(post("/api/relative-goods-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(relativeGoodsItemDTO)))
            .andExpect(status().isCreated());

        // Validate the RelativeGoodsItem in the database
        List<RelativeGoodsItem> relativeGoodsItemList = relativeGoodsItemRepository.findAll();
        assertThat(relativeGoodsItemList).hasSize(databaseSizeBeforeCreate + 1);
        RelativeGoodsItem testRelativeGoodsItem = relativeGoodsItemList.get(relativeGoodsItemList.size() - 1);
        assertThat(testRelativeGoodsItem.getPlatform()).isEqualTo(DEFAULT_PLATFORM);
        assertThat(testRelativeGoodsItem.getUrl()).isEqualTo(DEFAULT_URL);
        assertThat(testRelativeGoodsItem.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testRelativeGoodsItem.isTranslated()).isEqualTo(DEFAULT_TRANSLATED);
        assertThat(testRelativeGoodsItem.getTranslatedUrl()).isEqualTo(DEFAULT_TRANSLATED_URL);
        assertThat(testRelativeGoodsItem.getMainImage()).isEqualTo(DEFAULT_MAIN_IMAGE);
        assertThat(testRelativeGoodsItem.getSmallImages()).isEqualTo(DEFAULT_SMALL_IMAGES);
        assertThat(testRelativeGoodsItem.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testRelativeGoodsItem.getShopName()).isEqualTo(DEFAULT_SHOP_NAME);
        assertThat(testRelativeGoodsItem.getSellCount()).isEqualTo(DEFAULT_SELL_COUNT);
        assertThat(testRelativeGoodsItem.getPrice()).isEqualTo(DEFAULT_PRICE);
        assertThat(testRelativeGoodsItem.getZkPrice()).isEqualTo(DEFAULT_ZK_PRICE);
        assertThat(testRelativeGoodsItem.getCommssion()).isEqualTo(DEFAULT_COMMSSION);
        assertThat(testRelativeGoodsItem.getCommssionRate()).isEqualTo(DEFAULT_COMMSSION_RATE);
        assertThat(testRelativeGoodsItem.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testRelativeGoodsItem.getCoupon()).isEqualTo(DEFAULT_COUPON);
    }

    @Test
    @Transactional
    public void createRelativeGoodsItemWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = relativeGoodsItemRepository.findAll().size();

        // Create the RelativeGoodsItem with an existing ID
        relativeGoodsItem.setId(1L);
        RelativeGoodsItemDTO relativeGoodsItemDTO = relativeGoodsItemMapper.toDto(relativeGoodsItem);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRelativeGoodsItemMockMvc.perform(post("/api/relative-goods-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(relativeGoodsItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RelativeGoodsItem in the database
        List<RelativeGoodsItem> relativeGoodsItemList = relativeGoodsItemRepository.findAll();
        assertThat(relativeGoodsItemList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRelativeGoodsItems() throws Exception {
        // Initialize the database
        relativeGoodsItemRepository.saveAndFlush(relativeGoodsItem);

        // Get all the relativeGoodsItemList
        restRelativeGoodsItemMockMvc.perform(get("/api/relative-goods-items?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(relativeGoodsItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].platform").value(hasItem(DEFAULT_PLATFORM)))
            .andExpect(jsonPath("$.[*].url").value(hasItem(DEFAULT_URL)))
            .andExpect(jsonPath("$.[*].itemId").value(hasItem(DEFAULT_ITEM_ID)))
            .andExpect(jsonPath("$.[*].translated").value(hasItem(DEFAULT_TRANSLATED.booleanValue())))
            .andExpect(jsonPath("$.[*].translatedUrl").value(hasItem(DEFAULT_TRANSLATED_URL)))
            .andExpect(jsonPath("$.[*].mainImage").value(hasItem(DEFAULT_MAIN_IMAGE)))
            .andExpect(jsonPath("$.[*].smallImages").value(hasItem(DEFAULT_SMALL_IMAGES)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].shopName").value(hasItem(DEFAULT_SHOP_NAME)))
            .andExpect(jsonPath("$.[*].sellCount").value(hasItem(DEFAULT_SELL_COUNT)))
            .andExpect(jsonPath("$.[*].price").value(hasItem(DEFAULT_PRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].zkPrice").value(hasItem(DEFAULT_ZK_PRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].commssion").value(hasItem(DEFAULT_COMMSSION.doubleValue())))
            .andExpect(jsonPath("$.[*].commssionRate").value(hasItem(DEFAULT_COMMSSION_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].coupon").value(hasItem(DEFAULT_COUPON.doubleValue())));
    }
    
    @Test
    @Transactional
    public void getRelativeGoodsItem() throws Exception {
        // Initialize the database
        relativeGoodsItemRepository.saveAndFlush(relativeGoodsItem);

        // Get the relativeGoodsItem
        restRelativeGoodsItemMockMvc.perform(get("/api/relative-goods-items/{id}", relativeGoodsItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(relativeGoodsItem.getId().intValue()))
            .andExpect(jsonPath("$.platform").value(DEFAULT_PLATFORM))
            .andExpect(jsonPath("$.url").value(DEFAULT_URL))
            .andExpect(jsonPath("$.itemId").value(DEFAULT_ITEM_ID))
            .andExpect(jsonPath("$.translated").value(DEFAULT_TRANSLATED.booleanValue()))
            .andExpect(jsonPath("$.translatedUrl").value(DEFAULT_TRANSLATED_URL))
            .andExpect(jsonPath("$.mainImage").value(DEFAULT_MAIN_IMAGE))
            .andExpect(jsonPath("$.smallImages").value(DEFAULT_SMALL_IMAGES))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.shopName").value(DEFAULT_SHOP_NAME))
            .andExpect(jsonPath("$.sellCount").value(DEFAULT_SELL_COUNT))
            .andExpect(jsonPath("$.price").value(DEFAULT_PRICE.doubleValue()))
            .andExpect(jsonPath("$.zkPrice").value(DEFAULT_ZK_PRICE.doubleValue()))
            .andExpect(jsonPath("$.commssion").value(DEFAULT_COMMSSION.doubleValue()))
            .andExpect(jsonPath("$.commssionRate").value(DEFAULT_COMMSSION_RATE.doubleValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.coupon").value(DEFAULT_COUPON.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingRelativeGoodsItem() throws Exception {
        // Get the relativeGoodsItem
        restRelativeGoodsItemMockMvc.perform(get("/api/relative-goods-items/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRelativeGoodsItem() throws Exception {
        // Initialize the database
        relativeGoodsItemRepository.saveAndFlush(relativeGoodsItem);

        int databaseSizeBeforeUpdate = relativeGoodsItemRepository.findAll().size();

        // Update the relativeGoodsItem
        RelativeGoodsItem updatedRelativeGoodsItem = relativeGoodsItemRepository.findById(relativeGoodsItem.getId()).get();
        // Disconnect from session so that the updates on updatedRelativeGoodsItem are not directly saved in db
        em.detach(updatedRelativeGoodsItem);
        updatedRelativeGoodsItem
            .platform(UPDATED_PLATFORM)
            .url(UPDATED_URL)
            .itemId(UPDATED_ITEM_ID)
            .translated(UPDATED_TRANSLATED)
            .translatedUrl(UPDATED_TRANSLATED_URL)
            .mainImage(UPDATED_MAIN_IMAGE)
            .smallImages(UPDATED_SMALL_IMAGES)
            .title(UPDATED_TITLE)
            .shopName(UPDATED_SHOP_NAME)
            .sellCount(UPDATED_SELL_COUNT)
            .price(UPDATED_PRICE)
            .zkPrice(UPDATED_ZK_PRICE)
            .commssion(UPDATED_COMMSSION)
            .commssionRate(UPDATED_COMMSSION_RATE)
            .description(UPDATED_DESCRIPTION)
            .coupon(UPDATED_COUPON);
        RelativeGoodsItemDTO relativeGoodsItemDTO = relativeGoodsItemMapper.toDto(updatedRelativeGoodsItem);

        restRelativeGoodsItemMockMvc.perform(put("/api/relative-goods-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(relativeGoodsItemDTO)))
            .andExpect(status().isOk());

        // Validate the RelativeGoodsItem in the database
        List<RelativeGoodsItem> relativeGoodsItemList = relativeGoodsItemRepository.findAll();
        assertThat(relativeGoodsItemList).hasSize(databaseSizeBeforeUpdate);
        RelativeGoodsItem testRelativeGoodsItem = relativeGoodsItemList.get(relativeGoodsItemList.size() - 1);
        assertThat(testRelativeGoodsItem.getPlatform()).isEqualTo(UPDATED_PLATFORM);
        assertThat(testRelativeGoodsItem.getUrl()).isEqualTo(UPDATED_URL);
        assertThat(testRelativeGoodsItem.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testRelativeGoodsItem.isTranslated()).isEqualTo(UPDATED_TRANSLATED);
        assertThat(testRelativeGoodsItem.getTranslatedUrl()).isEqualTo(UPDATED_TRANSLATED_URL);
        assertThat(testRelativeGoodsItem.getMainImage()).isEqualTo(UPDATED_MAIN_IMAGE);
        assertThat(testRelativeGoodsItem.getSmallImages()).isEqualTo(UPDATED_SMALL_IMAGES);
        assertThat(testRelativeGoodsItem.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testRelativeGoodsItem.getShopName()).isEqualTo(UPDATED_SHOP_NAME);
        assertThat(testRelativeGoodsItem.getSellCount()).isEqualTo(UPDATED_SELL_COUNT);
        assertThat(testRelativeGoodsItem.getPrice()).isEqualTo(UPDATED_PRICE);
        assertThat(testRelativeGoodsItem.getZkPrice()).isEqualTo(UPDATED_ZK_PRICE);
        assertThat(testRelativeGoodsItem.getCommssion()).isEqualTo(UPDATED_COMMSSION);
        assertThat(testRelativeGoodsItem.getCommssionRate()).isEqualTo(UPDATED_COMMSSION_RATE);
        assertThat(testRelativeGoodsItem.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testRelativeGoodsItem.getCoupon()).isEqualTo(UPDATED_COUPON);
    }

    @Test
    @Transactional
    public void updateNonExistingRelativeGoodsItem() throws Exception {
        int databaseSizeBeforeUpdate = relativeGoodsItemRepository.findAll().size();

        // Create the RelativeGoodsItem
        RelativeGoodsItemDTO relativeGoodsItemDTO = relativeGoodsItemMapper.toDto(relativeGoodsItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRelativeGoodsItemMockMvc.perform(put("/api/relative-goods-items").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(relativeGoodsItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RelativeGoodsItem in the database
        List<RelativeGoodsItem> relativeGoodsItemList = relativeGoodsItemRepository.findAll();
        assertThat(relativeGoodsItemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRelativeGoodsItem() throws Exception {
        // Initialize the database
        relativeGoodsItemRepository.saveAndFlush(relativeGoodsItem);

        int databaseSizeBeforeDelete = relativeGoodsItemRepository.findAll().size();

        // Delete the relativeGoodsItem
        restRelativeGoodsItemMockMvc.perform(delete("/api/relative-goods-items/{id}", relativeGoodsItem.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<RelativeGoodsItem> relativeGoodsItemList = relativeGoodsItemRepository.findAll();
        assertThat(relativeGoodsItemList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
