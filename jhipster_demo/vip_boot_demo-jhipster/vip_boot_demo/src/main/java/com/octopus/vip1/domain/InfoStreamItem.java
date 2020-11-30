package com.octopus.vip1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import com.octopus.vip1.domain.enumeration.ItemResourceType;

/**
 * 信息流资讯\n@author hw
 */
@Entity
@Table(name = "info_stream_item")
public class InfoStreamItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 简介/摘要
     */
    @Column(name = "digist")
    private String digist;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_date")
    private ZonedDateTime lastUpdateDate;

    /**
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    /**
     * 标签
     */
    @Column(name = "tags")
    private String tags;

    /**
     * 内容类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private ItemResourceType contentType;

    @OneToMany(mappedBy = "infoStreamItem")
    private Set<ResourceItem> resources = new HashSet<>();

    @OneToMany(mappedBy = "infoStreamItem")
    private Set<ResourceItem> covers = new HashSet<>();

    @OneToMany(mappedBy = "infoStreamItem")
    private Set<RelativeGoodsItem> goods = new HashSet<>();

    /**
     * 媒体作者
     */
    @ManyToOne
    @JsonIgnoreProperties("infoStreamItems")
    private Author author;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public InfoStreamItem title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public InfoStreamItem type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDigist() {
        return digist;
    }

    public InfoStreamItem digist(String digist) {
        this.digist = digist;
        return this;
    }

    public void setDigist(String digist) {
        this.digist = digist;
    }

    public String getContent() {
        return content;
    }

    public InfoStreamItem content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public InfoStreamItem createUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public InfoStreamItem lastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public void setLastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public InfoStreamItem updateUser(String updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public InfoStreamItem createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getTags() {
        return tags;
    }

    public InfoStreamItem tags(String tags) {
        this.tags = tags;
        return this;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ItemResourceType getContentType() {
        return contentType;
    }

    public InfoStreamItem contentType(ItemResourceType contentType) {
        this.contentType = contentType;
        return this;
    }

    public void setContentType(ItemResourceType contentType) {
        this.contentType = contentType;
    }

    public Set<ResourceItem> getResources() {
        return resources;
    }

    public InfoStreamItem resources(Set<ResourceItem> resourceItems) {
        this.resources = resourceItems;
        return this;
    }

    public InfoStreamItem addResource(ResourceItem resourceItem) {
        this.resources.add(resourceItem);
        resourceItem.setInfoStreamItem(this);
        return this;
    }

    public InfoStreamItem removeResource(ResourceItem resourceItem) {
        this.resources.remove(resourceItem);
        resourceItem.setInfoStreamItem(null);
        return this;
    }

    public void setResources(Set<ResourceItem> resourceItems) {
        this.resources = resourceItems;
    }

    public Set<ResourceItem> getCovers() {
        return covers;
    }

    public InfoStreamItem covers(Set<ResourceItem> resourceItems) {
        this.covers = resourceItems;
        return this;
    }

    public InfoStreamItem addCover(ResourceItem resourceItem) {
        this.covers.add(resourceItem);
        resourceItem.setInfoStreamItem(this);
        return this;
    }

    public InfoStreamItem removeCover(ResourceItem resourceItem) {
        this.covers.remove(resourceItem);
        resourceItem.setInfoStreamItem(null);
        return this;
    }

    public void setCovers(Set<ResourceItem> resourceItems) {
        this.covers = resourceItems;
    }

    public Set<RelativeGoodsItem> getGoods() {
        return goods;
    }

    public InfoStreamItem goods(Set<RelativeGoodsItem> relativeGoodsItems) {
        this.goods = relativeGoodsItems;
        return this;
    }

    public InfoStreamItem addGoods(RelativeGoodsItem relativeGoodsItem) {
        this.goods.add(relativeGoodsItem);
        relativeGoodsItem.setInfoStreamItem(this);
        return this;
    }

    public InfoStreamItem removeGoods(RelativeGoodsItem relativeGoodsItem) {
        this.goods.remove(relativeGoodsItem);
        relativeGoodsItem.setInfoStreamItem(null);
        return this;
    }

    public void setGoods(Set<RelativeGoodsItem> relativeGoodsItems) {
        this.goods = relativeGoodsItems;
    }

    public Author getAuthor() {
        return author;
    }

    public InfoStreamItem author(Author author) {
        this.author = author;
        return this;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoStreamItem)) {
            return false;
        }
        return id != null && id.equals(((InfoStreamItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "InfoStreamItem{" +
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
            "}";
    }
}
