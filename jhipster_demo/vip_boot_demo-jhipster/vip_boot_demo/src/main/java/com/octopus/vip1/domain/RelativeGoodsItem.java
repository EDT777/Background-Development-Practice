package com.octopus.vip1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 资讯关联的商品
 */
@Entity
@Table(name = "relative_goods_item")
public class RelativeGoodsItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 平台
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 原始地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 商品id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 是否已经转链
     */
    @Column(name = "translated")
    private Boolean translated;

    /**
     * 转链后地址
     */
    @Column(name = "translated_url")
    private String translatedUrl;

    /**
     * 主图
     */
    @Column(name = "main_image")
    private String mainImage;

    /**
     * 小图
     */
    @Column(name = "small_images")
    private String smallImages;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 店铺名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 销量
     */
    @Column(name = "sell_count")
    private Integer sellCount;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 折扣价格
     */
    @Column(name = "zk_price")
    private Double zkPrice;

    /**
     * 佣金
     */
    @Column(name = "commssion")
    private Double commssion;

    /**
     * 佣金比例
     */
    @Column(name = "commssion_rate")
    private Double commssionRate;

    /**
     * 推荐语
     */
    @Column(name = "description")
    private String description;

    /**
     * 优惠券
     */
    @Column(name = "coupon")
    private Double coupon;

    @ManyToOne
    @JsonIgnoreProperties("relativeGoodsItems")
    private InfoStreamItem streamItem;

    @ManyToOne
    @JsonIgnoreProperties("goods")
    private InfoStreamItem infoStreamItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public RelativeGoodsItem platform(String platform) {
        this.platform = platform;
        return this;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public RelativeGoodsItem url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItemId() {
        return itemId;
    }

    public RelativeGoodsItem itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Boolean isTranslated() {
        return translated;
    }

    public RelativeGoodsItem translated(Boolean translated) {
        this.translated = translated;
        return this;
    }

    public void setTranslated(Boolean translated) {
        this.translated = translated;
    }

    public String getTranslatedUrl() {
        return translatedUrl;
    }

    public RelativeGoodsItem translatedUrl(String translatedUrl) {
        this.translatedUrl = translatedUrl;
        return this;
    }

    public void setTranslatedUrl(String translatedUrl) {
        this.translatedUrl = translatedUrl;
    }

    public String getMainImage() {
        return mainImage;
    }

    public RelativeGoodsItem mainImage(String mainImage) {
        this.mainImage = mainImage;
        return this;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public RelativeGoodsItem smallImages(String smallImages) {
        this.smallImages = smallImages;
        return this;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    public String getTitle() {
        return title;
    }

    public RelativeGoodsItem title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopName() {
        return shopName;
    }

    public RelativeGoodsItem shopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public RelativeGoodsItem sellCount(Integer sellCount) {
        this.sellCount = sellCount;
        return this;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Double getPrice() {
        return price;
    }

    public RelativeGoodsItem price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getZkPrice() {
        return zkPrice;
    }

    public RelativeGoodsItem zkPrice(Double zkPrice) {
        this.zkPrice = zkPrice;
        return this;
    }

    public void setZkPrice(Double zkPrice) {
        this.zkPrice = zkPrice;
    }

    public Double getCommssion() {
        return commssion;
    }

    public RelativeGoodsItem commssion(Double commssion) {
        this.commssion = commssion;
        return this;
    }

    public void setCommssion(Double commssion) {
        this.commssion = commssion;
    }

    public Double getCommssionRate() {
        return commssionRate;
    }

    public RelativeGoodsItem commssionRate(Double commssionRate) {
        this.commssionRate = commssionRate;
        return this;
    }

    public void setCommssionRate(Double commssionRate) {
        this.commssionRate = commssionRate;
    }

    public String getDescription() {
        return description;
    }

    public RelativeGoodsItem description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoupon() {
        return coupon;
    }

    public RelativeGoodsItem coupon(Double coupon) {
        this.coupon = coupon;
        return this;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public InfoStreamItem getStreamItem() {
        return streamItem;
    }

    public RelativeGoodsItem streamItem(InfoStreamItem infoStreamItem) {
        this.streamItem = infoStreamItem;
        return this;
    }

    public void setStreamItem(InfoStreamItem infoStreamItem) {
        this.streamItem = infoStreamItem;
    }

    public InfoStreamItem getInfoStreamItem() {
        return infoStreamItem;
    }

    public RelativeGoodsItem infoStreamItem(InfoStreamItem infoStreamItem) {
        this.infoStreamItem = infoStreamItem;
        return this;
    }

    public void setInfoStreamItem(InfoStreamItem infoStreamItem) {
        this.infoStreamItem = infoStreamItem;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RelativeGoodsItem)) {
            return false;
        }
        return id != null && id.equals(((RelativeGoodsItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "RelativeGoodsItem{" +
            "id=" + getId() +
            ", platform='" + getPlatform() + "'" +
            ", url='" + getUrl() + "'" +
            ", itemId='" + getItemId() + "'" +
            ", translated='" + isTranslated() + "'" +
            ", translatedUrl='" + getTranslatedUrl() + "'" +
            ", mainImage='" + getMainImage() + "'" +
            ", smallImages='" + getSmallImages() + "'" +
            ", title='" + getTitle() + "'" +
            ", shopName='" + getShopName() + "'" +
            ", sellCount=" + getSellCount() +
            ", price=" + getPrice() +
            ", zkPrice=" + getZkPrice() +
            ", commssion=" + getCommssion() +
            ", commssionRate=" + getCommssionRate() +
            ", description='" + getDescription() + "'" +
            ", coupon=" + getCoupon() +
            "}";
    }
}
