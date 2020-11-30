package com.octopus.vip1.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

/**
 * 资讯作者.\n@author A true hipster
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 头像
     */
    @Column(name = "pct")
    private String pct;

    /**
     * 是否有效
     */
    @Column(name = "valid")
    private Boolean valid;

    /**
     * 入驻时间
     */
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    /**
     * 等级
     */
    @Column(name = "level")
    private Integer level;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Author name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPct() {
        return pct;
    }

    public Author pct(String pct) {
        this.pct = pct;
        return this;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }

    public Boolean isValid() {
        return valid;
    }

    public Author valid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Author createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getLevel() {
        return level;
    }

    public Author level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Author)) {
            return false;
        }
        return id != null && id.equals(((Author) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Author{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", pct='" + getPct() + "'" +
            ", valid='" + isValid() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", level=" + getLevel() +
            "}";
    }
}
