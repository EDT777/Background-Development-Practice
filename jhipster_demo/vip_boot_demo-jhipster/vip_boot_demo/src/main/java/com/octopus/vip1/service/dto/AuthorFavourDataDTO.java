package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.AuthorFavourData} entity.
 */
@ApiModel(description = "作者关注数据")
public class AuthorFavourDataDTO implements Serializable {
    
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
     * 对作者的关注
     */
    @ApiModelProperty(value = "对作者的关注")

    private Long authorId;
    
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

        AuthorFavourDataDTO authorFavourDataDTO = (AuthorFavourDataDTO) o;
        if (authorFavourDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), authorFavourDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AuthorFavourDataDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", createDate='" + getCreateDate() + "'" +
            ", authorId=" + getAuthorId() +
            "}";
    }
}
