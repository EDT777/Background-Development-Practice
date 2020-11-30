package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import com.octopus.vip1.domain.enumeration.VisitSource;

/**
 * A DTO for the {@link com.octopus.vip1.domain.ReplyVisitDataStat} entity.
 */
@ApiModel(description = "评论或回复访问的统计信息.\n@author hw")
public class ReplyVisitDataStatDTO implements Serializable {
    
    private Long id;

    /**
     * 点击次数次数
     */
    @ApiModelProperty(value = "点击次数次数")
    private Long clickCount;

    /**
     * 开始统计时间
     */
    @ApiModelProperty(value = "开始统计时间")
    private LocalDate startDate;

    /**
     * 终止统计时间
     */
    @ApiModelProperty(value = "终止统计时间")
    private LocalDate endDate;

    /**
     * 访问方式
     */
    @ApiModelProperty(value = "访问方式")
    private VisitSource source;

    /**
     * 终端类型
     */
    @ApiModelProperty(value = "终端类型")
    private String termimal;

    /**
     * 评论数
     */
    @ApiModelProperty(value = "评论数")
    private Integer replyCount;

    /**
     * 点赞数量
     */
    @ApiModelProperty(value = "点赞数量")
    private Integer starCount;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public VisitSource getSource() {
        return source;
    }

    public void setSource(VisitSource source) {
        this.source = source;
    }

    public String getTermimal() {
        return termimal;
    }

    public void setTermimal(String termimal) {
        this.termimal = termimal;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReplyVisitDataStatDTO replyVisitDataStatDTO = (ReplyVisitDataStatDTO) o;
        if (replyVisitDataStatDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), replyVisitDataStatDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReplyVisitDataStatDTO{" +
            "id=" + getId() +
            ", clickCount=" + getClickCount() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", source='" + getSource() + "'" +
            ", termimal='" + getTermimal() + "'" +
            ", replyCount=" + getReplyCount() +
            ", starCount=" + getStarCount() +
            "}";
    }
}
