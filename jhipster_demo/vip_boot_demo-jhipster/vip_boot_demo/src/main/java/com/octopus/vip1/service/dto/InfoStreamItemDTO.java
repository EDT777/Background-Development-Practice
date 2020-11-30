package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;
import com.octopus.vip1.domain.enumeration.ItemResourceType;

/**
 * A DTO for the {@link com.octopus.vip1.domain.InfoStreamItem} entity.
 */
@ApiModel(description = "信息流资讯\n@author hw")
public class InfoStreamItemDTO implements Serializable {
    
    private Long id;

    /**
     * 商品标题
     */
    @ApiModelProperty(value = "商品标题")
    private String title;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 简介/摘要
     */
    @ApiModelProperty(value = "简介/摘要")
    private String digist;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    private ZonedDateTime lastUpdateDate;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private ZonedDateTime createDate;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String tags;

    /**
     * 内容类型
     */
    @ApiModelProperty(value = "内容类型")
    private ItemResourceType contentType;

    /**
     * 媒体作者
     */
    @ApiModelProperty(value = "媒体作者")

    private Long authorId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDigist() {
        return digist;
    }

    public void setDigist(String digist) {
        this.digist = digist;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ItemResourceType getContentType() {
        return contentType;
    }

    public void setContentType(ItemResourceType contentType) {
        this.contentType = contentType;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InfoStreamItemDTO infoStreamItemDTO = (InfoStreamItemDTO) o;
        if (infoStreamItemDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), infoStreamItemDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InfoStreamItemDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", type='" + getType() + "'" +
            ", digist='" + getDigist() + "'" +
            ", content='" + getContent() + "'" +
            ", createUser='" + getCreateUser() + "'" +
            ", lastUpdateDate='" + getLastUpdateDate() + "'" +
            ", updateUser='" + getUpdateUser() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", tags='" + getTags() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", authorId=" + getAuthorId() +
            "}";
    }
}
