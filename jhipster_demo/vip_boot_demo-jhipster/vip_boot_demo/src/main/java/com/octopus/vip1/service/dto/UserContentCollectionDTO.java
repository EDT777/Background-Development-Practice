package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.UserContentCollection} entity.
 */
@ApiModel(description = "用户内容收藏")
public class UserContentCollectionDTO implements Serializable {
    
    private Long id;

    /**
     * 用户
     */
    @ApiModelProperty(value = "用户")
    private Long userId;

    /**
     * 平台
     */
    @ApiModelProperty(value = "平台")
    private String platform;

    /**
     * 链接
     */
    @ApiModelProperty(value = "链接")
    private String link;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private ZonedDateTime createDate;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String pctUrl;

    /**
     * 有效
     */
    @ApiModelProperty(value = "有效")
    private Boolean valid;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPctUrl() {
        return pctUrl;
    }

    public void setPctUrl(String pctUrl) {
        this.pctUrl = pctUrl;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserContentCollectionDTO userContentCollectionDTO = (UserContentCollectionDTO) o;
        if (userContentCollectionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userContentCollectionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserContentCollectionDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", platform='" + getPlatform() + "'" +
            ", link='" + getLink() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", pctUrl='" + getPctUrl() + "'" +
            ", valid='" + isValid() + "'" +
            "}";
    }
}
