package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.octopus.vip1.domain.Reply} entity.
 */
@ApiModel(description = "内容评论及回复.")
public class ReplyDTO implements Serializable {
    
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 审核
     */
    @ApiModelProperty(value = "审核")
    private Boolean auditStatus;

    /**
     * 发表时间
     */
    @ApiModelProperty(value = "发表时间")
    private ZonedDateTime createData;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private ZonedDateTime auditDate;

    /**
     * 发表用户
     */
    @ApiModelProperty(value = "发表用户")
    private String createUser;

    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private Long auditUser;

    /**
     * 评论人
     */
    @ApiModelProperty(value = "评论人")
    private Long replyUserId;

    /**
     * 评论人昵称
     */
    @ApiModelProperty(value = "评论人昵称")
    private String replyUserNickName;

    /**
     * 是否已经删除
     */
    @ApiModelProperty(value = "是否已经删除")
    private Boolean delFlag;

    /**
     * 评论目标为另外一个评论
     */
    @ApiModelProperty(value = "评论目标为另外一个评论")

    private Long replyToId;
    /**
     * 评论目标为一个媒体内容
     */
    @ApiModelProperty(value = "评论目标为一个媒体内容")

    private Long itemId;
    
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public ZonedDateTime getCreateData() {
        return createData;
    }

    public void setCreateData(ZonedDateTime createData) {
        this.createData = createData;
    }

    public ZonedDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyUserNickName() {
        return replyUserNickName;
    }

    public void setReplyUserNickName(String replyUserNickName) {
        this.replyUserNickName = replyUserNickName;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Long getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(Long replyId) {
        this.replyToId = replyId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long infoStreamItemId) {
        this.itemId = infoStreamItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReplyDTO replyDTO = (ReplyDTO) o;
        if (replyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), replyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", auditStatus='" + isAuditStatus() + "'" +
            ", createData='" + getCreateData() + "'" +
            ", auditDate='" + getAuditDate() + "'" +
            ", createUser='" + getCreateUser() + "'" +
            ", auditUser=" + getAuditUser() +
            ", replyUserId=" + getReplyUserId() +
            ", replyUserNickName='" + getReplyUserNickName() + "'" +
            ", delFlag='" + isDelFlag() + "'" +
            ", replyToId=" + getReplyToId() +
            ", itemId=" + getItemId() +
            "}";
    }
}
