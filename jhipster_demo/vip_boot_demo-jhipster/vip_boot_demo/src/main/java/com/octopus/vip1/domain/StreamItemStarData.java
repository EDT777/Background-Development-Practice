package com.octopus.vip1.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

/**
 * 资讯、评论点赞数据
 */
@Entity
@Table(name = "stream_item_star_data")
public class StreamItemStarData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 关注时间
     */
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    /**
     * 类型，1为资讯，2为评论
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 资讯id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 回复id
     */
    @Column(name = "replay_id")
    private String replayId;

    /**
     * 是否有效
     */
    @Column(name = "valid")
    private Boolean valid;

    /**
     * 动作类型 1表示点赞，-1表示踩
     */
    @Column(name = "star_type")
    private Integer starType;

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

    public StreamItemStarData userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public StreamItemStarData createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public StreamItemStarData type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getItemId() {
        return itemId;
    }

    public StreamItemStarData itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getReplayId() {
        return replayId;
    }

    public StreamItemStarData replayId(String replayId) {
        this.replayId = replayId;
        return this;
    }

    public void setReplayId(String replayId) {
        this.replayId = replayId;
    }

    public Boolean isValid() {
        return valid;
    }

    public StreamItemStarData valid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getStarType() {
        return starType;
    }

    public StreamItemStarData starType(Integer starType) {
        this.starType = starType;
        return this;
    }

    public void setStarType(Integer starType) {
        this.starType = starType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreamItemStarData)) {
            return false;
        }
        return id != null && id.equals(((StreamItemStarData) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StreamItemStarData{" +
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
