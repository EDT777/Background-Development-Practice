package com.octopus.vip1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

/**
 * 内容评论及回复.
 */
@Entity
@Table(name = "reply")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 审核
     */
    @Column(name = "audit_status")
    private Boolean auditStatus;

    /**
     * 发表时间
     */
    @Column(name = "create_data")
    private ZonedDateTime createData;

    /**
     * 审核时间
     */
    @Column(name = "audit_date")
    private ZonedDateTime auditDate;

    /**
     * 发表用户
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 审核人
     */
    @Column(name = "audit_user")
    private Long auditUser;

    /**
     * 评论人
     */
    @Column(name = "reply_user_id")
    private Long replyUserId;

    /**
     * 评论人昵称
     */
    @Column(name = "reply_user_nick_name")
    private String replyUserNickName;

    /**
     * 是否已经删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 评论目标为另外一个评论
     */
    @ManyToOne
    @JsonIgnoreProperties("replies")
    private Reply replyTo;

    /**
     * 评论目标为一个媒体内容
     */
    @ManyToOne
    @JsonIgnoreProperties("replies")
    private InfoStreamItem item;

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

    public Reply title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Reply content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isAuditStatus() {
        return auditStatus;
    }

    public Reply auditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
        return this;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public ZonedDateTime getCreateData() {
        return createData;
    }

    public Reply createData(ZonedDateTime createData) {
        this.createData = createData;
        return this;
    }

    public void setCreateData(ZonedDateTime createData) {
        this.createData = createData;
    }

    public ZonedDateTime getAuditDate() {
        return auditDate;
    }

    public Reply auditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
        return this;
    }

    public void setAuditDate(ZonedDateTime auditDate) {
        this.auditDate = auditDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Reply createUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getAuditUser() {
        return auditUser;
    }

    public Reply auditUser(Long auditUser) {
        this.auditUser = auditUser;
        return this;
    }

    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public Reply replyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
        return this;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyUserNickName() {
        return replyUserNickName;
    }

    public Reply replyUserNickName(String replyUserNickName) {
        this.replyUserNickName = replyUserNickName;
        return this;
    }

    public void setReplyUserNickName(String replyUserNickName) {
        this.replyUserNickName = replyUserNickName;
    }

    public Boolean isDelFlag() {
        return delFlag;
    }

    public Reply delFlag(Boolean delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Reply getReplyTo() {
        return replyTo;
    }

    public Reply replyTo(Reply reply) {
        this.replyTo = reply;
        return this;
    }

    public void setReplyTo(Reply reply) {
        this.replyTo = reply;
    }

    public InfoStreamItem getItem() {
        return item;
    }

    public Reply item(InfoStreamItem infoStreamItem) {
        this.item = infoStreamItem;
        return this;
    }

    public void setItem(InfoStreamItem infoStreamItem) {
        this.item = infoStreamItem;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reply)) {
            return false;
        }
        return id != null && id.equals(((Reply) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Reply{" +
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
            "}";
    }
}
