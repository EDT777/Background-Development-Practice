package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.RelativeGoodsItem} entity.
 */
@ApiModel(description = "资讯关联的商品")
public class RelativeGoodsItemDTO implements Serializable {
    
    private Long id;

    /**
     * 平台
     */
    @ApiModelProperty(value = "平台")
    private String platform;

    /**
     * 原始地址
     */
    @ApiModelProperty(value = "原始地址")
    private String url;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String itemId;

    /**
     * 是否已经转链
     */
    @ApiModelProperty(value = "是否已经转链")
    private Boolean translated;

    /**
     * 转链后地址
     */
    @ApiModelProperty(value = "转链后地址")
    private String translatedUrl;

    /**
     * 主图
     */
    @ApiModelProperty(value = "主图")
    private String mainImage;

    /**
     * 小图
     */
    @ApiModelProperty(value = "小图")
    private String smallImages;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量")
    private Integer sellCount;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Double price;

    /**
     * 折扣价格
     */
    @ApiModelProperty(value = "折扣价格")
    private Double zkPrice;

    /**
     * 佣金
     */
    @ApiModelProperty(value = "佣金")
    private Double commssion;

    /**
     * 佣金比例
     */
    @ApiModelProperty(value = "佣金比例")
    private Double commssionRate;

    /**
     * 推荐语
     */
    @ApiModelProperty(value = "推荐语")
    private String description;

    /**
     * 优惠券
     */
    @ApiModelProperty(value = "优惠券")
    private Double coupon;


    private Long streamItemId;

    private Long infoStreamItemId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Boolean isTranslated() {
        return translated;
    }

    public void setTranslated(Boolean translated) {
        this.translated = translated;
    }

    public String getTranslatedUrl() {
        return translatedUrl;
    }

    public void setTranslatedUrl(String translatedUrl) {
        this.translatedUrl = translatedUrl;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getZkPrice() {
        return zkPrice;
    }

    public void setZkPrice(Double zkPrice) {
        this.zkPrice = zkPrice;
    }

    public Double getCommssion() {
        return commssion;
    }

    public void setCommssion(Double commssion) {
        this.commssion = commssion;
    }

    public Double getCommssionRate() {
        return commssionRate;
    }

    public void setCommssionRate(Double commssionRate) {
        this.commssionRate = commssionRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Long getStreamItemId() {
        return streamItemId;
    }

    public void setStreamItemId(Long infoStreamItemId) {
        this.streamItemId = infoStreamItemId;
    }

    public Long getInfoStreamItemId() {
        return infoStreamItemId;
    }

    public void setInfoStreamItemId(Long infoStreamItemId) {
        this.infoStreamItemId = infoStreamItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RelativeGoodsItemDTO relativeGoodsItemDTO = (RelativeGoodsItemDTO) o;
        if (relativeGoodsItemDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), relativeGoodsItemDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RelativeGoodsItemDTO{" +
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
            ", streamItemId=" + getStreamItemId() +
            ", infoStreamItemId=" + getInfoStreamItemId() +
            "}";
    }
}
