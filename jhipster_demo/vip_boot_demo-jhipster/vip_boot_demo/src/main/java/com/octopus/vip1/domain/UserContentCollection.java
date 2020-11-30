package com.octopus.vip1.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

/**
 * 用户内容收藏
 */
@Entity
@Table(name = "user_content_collection")
public class UserContentCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 平台
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 链接
     */
    @Column(name = "link")
    private String link;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    /**
     * 图片地址
     */
    @Column(name = "pct_url")
    private String pctUrl;

    /**
     * 有效
     */
    @Column(name = "valid")
    private Boolean valid;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public UserContentCollection userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public UserContentCollection platform(String platform) {
        this.platform = platform;
        return this;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public UserContentCollection link(String link) {
        this.link = link;
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public UserContentCollection createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPctUrl() {
        return pctUrl;
    }

    public UserContentCollection pctUrl(String pctUrl) {
        this.pctUrl = pctUrl;
        return this;
    }

    public void setPctUrl(String pctUrl) {
        this.pctUrl = pctUrl;
    }

    public Boolean isValid() {
        return valid;
    }

    public UserContentCollection valid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserContentCollection)) {
            return false;
        }
        return id != null && id.equals(((UserContentCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UserContentCollection{" +
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
