package com.octopus.vip1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

import com.octopus.vip1.domain.enumeration.ItemResourceType;

/**
 * 资讯内容，比如视频，文章，图片等
 */
@Entity
@Table(name = "resource_item")
public class ResourceItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ItemResourceType type;

    /**
     * 平台，比如alivod等
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 在平台上的资源id，比如aliyun的点播的videoId，oss的对象id
     */
    @Column(name = "resource_id")
    private String resourceId;

    /**
     * 是否已经完成转码
     */
    @Column(name = "transcode_status")
    private Boolean transcodeStatus;

    /**
     * 是否已经成功上传
     */
    @Column(name = "upload_status")
    private Boolean uploadStatus;

    /**
     * 上传时间
     */
    @Column(name = "update_date")
    private ZonedDateTime updateDate;

    /**
     * 是否通过审核
     */
    @Column(name = "audit_status")
    private Boolean auditStatus;

    /**
     * 最后审核操作时间
     */
    @Column(name = "audit_date")
    private ZonedDateTime auditDate;

    /**
     * 审核信息
     */
    @Column(name = "audit_info")
    private String auditInfo;

    /**
     * 内容大小，字节
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 内容长度，比如时长
     */
    @Column(name = "content_size")
    private Long contentSize;

    /**
     * 来源-平台上传/用户上传
     */
    @Column(name = "source")
    private String source;

    /**
     * 地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 地址过期时间
     */
    @Column(name = "url_expire")
    private Long urlExpire;

    /**
     * 资源参数，比如视频长度，码率等，json格式
     */
    @Column(name = "params")
    private String params;

    /**
     * 审核人
     */
    @Column(name = "audit_user")
    private Long auditUser;

    /**
     * 是否已经删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    @ManyToOne
    @JsonIgnoreProperties("resources")
    private InfoStreamItem infoStreamItem;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemResourceType getType() {
        return type;
    }

    public ResourceItem type(ItemResourceType type) {
        this.type = type;
        return this;
    }

    public void setType(ItemResourceType type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public ResourceItem platform(String platform) {
        this.platform = platform;
        return this;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getResourceId() {
        return resourceId;
    }

    public ResourceItem resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Boolean isTranscodeStatus() {
        return transcodeStatus;
    }

    public ResourceItem transcodeStatus(Boolean transcodeStatus) {
        this.transcodeStatus = transcodeStatus;
        return this;
    }

    public void setTranscodeStatus(Boolean transcodeStatus) {
        this.transcodeStatus = transcodeStatus;
    }

    public Boolean isUploadStatus() {
        return uploadStatus;
    }

    public ResourceItem uploadStatus(Boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
        return this;
    }

    public void setUploadStatus(Boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public ResourceItem updateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean isAuditStatus() {
        return auditStatus;
    }

    public ResourceItem auditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
        return this;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public ZonedDateTime getAuditDate() {
        return auditDate;
    }

    public ResourceItem auditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
        return this;
    }

    public void setAuditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public ResourceItem auditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
        return this;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public ResourceItem fileSize(Long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getContentSize() {
        return contentSize;
    }

    public ResourceItem contentSize(Long contentSize) {
        this.contentSize = contentSize;
        return this;
    }

    public void setContentSize(Long contentSize) {
        this.contentSize = contentSize;
    }

    public String getSource() {
        return source;
    }

    public ResourceItem source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public ResourceItem url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUrlExpire() {
        return urlExpire;
    }

    public ResourceItem urlExpire(Long urlExpire) {
        this.urlExpire = urlExpire;
        return this;
    }

    public void setUrlExpire(Long urlExpire) {
        this.urlExpire = urlExpire;
    }

    public String getParams() {
        return params;
    }

    public ResourceItem params(String params) {
        this.params = params;
        return this;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getAuditUser() {
        return auditUser;
    }

    public ResourceItem auditUser(Long auditUser) {
        this.auditUser = auditUser;
        return this;
    }

    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public ResourceItem delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public InfoStreamItem getInfoStreamItem() {
        return infoStreamItem;
    }

    public ResourceItem infoStreamItem(InfoStreamItem infoStreamItem) {
        this.infoStreamItem = infoStreamItem;
        return this;
    }

    public void setInfoStreamItem(InfoStreamItem infoStreamItem) {
        this.infoStreamItem = infoStreamItem;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResourceItem)) {
            return false;
        }
        return id != null && id.equals(((ResourceItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ResourceItem{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", platform='" + getPlatform() + "'" +
            ", resourceId='" + getResourceId() + "'" +
            ", transcodeStatus='" + isTranscodeStatus() + "'" +
            ", uploadStatus='" + isUploadStatus() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", auditStatus='" + isAuditStatus() + "'" +
            ", auditDate='" + getAuditDate() + "'" +
            ", auditInfo='" + getAuditInfo() + "'" +
            ", fileSize=" + getFileSize() +
            ", contentSize=" + getContentSize() +
            ", source='" + getSource() + "'" +
            ", url='" + getUrl() + "'" +
            ", urlExpire=" + getUrlExpire() +
            ", params='" + getParams() + "'" +
            ", auditUser=" + getAuditUser() +
            ", delFlag='" + isDelFlag() + "'" +
            "}";
    }
}
