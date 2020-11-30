package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.StreamItemStarData} entity.
 */
@ApiModel(description = "资讯、评论点赞数据")
public class StreamItemStarDataDTO implements Serializable {
    
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 关注时间
     */
    @ApiModelProperty(value = "关注时间")
    private ZonedDateTime createDate;

    /**
     * 类型，1为资讯，2为评论
     */
    @ApiModelProperty(value = "类型，1为资讯，2为评论")
    private Integer type;

    /**
     * 资讯id
     */
    @ApiModelProperty(value = "资讯id")
    private String itemId;

    /**
     * 回复id
     */
    @ApiModelProperty(value = "回复id")
    private String replayId;

    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private Boolean valid;

    /**
     * 动作类型 1表示点赞，-1表示踩
     */
    @ApiModelProperty(value = "动作类型 1表示点赞，-1表示踩")
    private Integer starType;

    
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

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getReplayId() {
        return replayId;
    }

    public void setReplayId(String replayId) {
        this.replayId = replayId;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getStarType() {
        return starType;
    }

    public void setStarType(Integer starType) {
        this.starType = starType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreamItemStarDataDTO streamItemStarDataDTO = (StreamItemStarDataDTO) o;
        if (streamItemStarDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), streamItemStarDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StreamItemStarDataDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", createDate='" + getCreateDate() + "'" +
            ", type=" + getType() +
            ", itemId='" + getItemId() + "'" +
            ", replayId='" + getReplayId() + "'" +
            ", valid='" + isValid() + "'" +
            ", starType=" + getStarType() +
            "}";
    }
}
