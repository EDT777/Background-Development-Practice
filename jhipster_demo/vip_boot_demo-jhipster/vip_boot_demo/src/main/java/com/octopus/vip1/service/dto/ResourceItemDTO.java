package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;
import com.octopus.vip1.domain.enumeration.ItemResourceType;

/**
 * A DTO for the {@link com.octopus.vip1.domain.ResourceItem} entity.
 */
@ApiModel(description = "资讯内容，比如视频，文章，图片等")
public class ResourceItemDTO implements Serializable {

    private Long id;

    private ItemResourceType type;

    /**
     * 平台，比如alivod等
     */
    @ApiModelProperty(value = "平台，比如alivod等")
    private String platform;

    /**
     * 在平台上的资源id，比如aliyun的点播的videoId，oss的对象id
     */
    @ApiModelProperty(value = "在平台上的资源id，比如aliyun的点播的videoId，oss的对象id")
    private String resourceId;

    /**
     * 是否已经完成转码
     */
    @ApiModelProperty(value = "是否已经完成转码")
    private Boolean transcodeStatus;

    /**
     * 是否已经成功上传
     */
    @ApiModelProperty(value = "是否已经成功上传")
    private Boolean uploadStatus;

    /**
     * 上传时间
     */
    @ApiModelProperty(value = "上传时间")
    private ZonedDateTime updateDate;

    /**
     * 是否通过审核
     */
    @ApiModelProperty(value = "是否通过审核")
    private Boolean auditStatus;

    /**
     * 最后审核操作时间
     */
    @ApiModelProperty(value = "最后审核操作时间")
    private ZonedDateTime auditDate;

    /**
     * 审核信息
     */
    @ApiModelProperty(value = "审核信息")
    private String auditInfo;

    /**
     * 内容大小，字节
     */
    @ApiModelProperty(value = "内容大小，字节")
    private Long fileSize;

    /**
     * 内容长度，比如时长
     */
    @ApiModelProperty(value = "内容长度，比如时长")
    private Long contentSize;

    /**
     * 来源-平台上传/用户上传
     */
    @ApiModelProperty(value = "来源-平台上传/用户上传")
    private String source;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String url;

    /**
     * 地址过期时间
     */
    @ApiModelProperty(value = "地址过期时间")
    private Long urlExpire;

    /**
     * 资源参数，比如视频长度，码率等，json格式
     */
    @ApiModelProperty(value = "资源参数，比如视频长度，码率等，json格式")
    private String params;

    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private Long auditUser;

    /**
     * 是否已经删除
     */
    @ApiModelProperty(value = "是否已经删除")
    private Boolean delFlag;


    private Long infoStreamItemId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemResourceType getType() {
        return type;
    }

    public void setType(ItemResourceType type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Boolean isTranscodeStatus() {
        return transcodeStatus;
    }

    public void setTranscodeStatus(Boolean transcodeStatus) {
        this.transcodeStatus = transcodeStatus;
    }

    public Boolean isUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Boolean uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean isAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public ZonedDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getContentSize() {
        return contentSize;
    }

    public void setContentSize(Long contentSize) {
        this.contentSize = contentSize;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUrlExpire() {
        return urlExpire;
    }

    public void setUrlExpire(Long urlExpire) {
        this.urlExpire = urlExpire;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }


    public Long getInfoStreamItemId() {
        return infoStreamItemId;
    }

    public void setInfoStreamItemId(Long infoStreamItemId) {
        this.infoStreamItemId = infoStreamItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResourceItemDTO resourceItemDTO = (ResourceItemDTO) o;
        if (resourceItemDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), resourceItemDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ResourceItemDTO{" +
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
            ", infoStreamItemId=" + getInfoStreamItemId() +
            ", infoStreamItemId=" + getInfoStreamItemId() +
            "}";
    }
}
