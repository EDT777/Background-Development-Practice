package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.Author} entity.
 */
@ApiModel(description = "资讯作者.\n@author A true hipster")
public class AuthorDTO implements Serializable {
    
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String pct;

    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private Boolean valid;

    /**
     * 入驻时间
     */
    @ApiModelProperty(value = "入驻时间")
    private ZonedDateTime createDate;

    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer level;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPct() {
        return pct;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthorDTO authorDTO = (AuthorDTO) o;
        if (authorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), authorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", pct='" + getPct() + "'" +
            ", valid='" + isValid() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", level=" + getLevel() +
            "}";
    }
}
