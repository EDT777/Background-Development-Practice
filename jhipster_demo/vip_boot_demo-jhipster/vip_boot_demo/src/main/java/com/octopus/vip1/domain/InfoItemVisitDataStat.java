package com.octopus.vip1.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

import com.octopus.vip1.domain.enumeration.VisitSource;

/**
 * 信息流项目访问的统计信息.\n@author hw
 */
@Entity
@Table(name = "info_item_visit_data_stat")
public class InfoItemVisitDataStat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 点击次数次数
     */
    @Column(name = "click_count")
    private Long clickCount;

    /**
     * 开始统计时间
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * 终止统计时间
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * 访问方式
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private VisitSource source;

    /**
     * 终端类型
     */
    @Column(name = "termimal")
    private String termimal;

    /**
     * 评论数
     */
    @Column(name = "reply_count")
    private Integer replyCount;

    /**
     * 点赞数量
     */
    @Column(name = "star_count")
    private Integer starCount;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public InfoItemVisitDataStat clickCount(Long clickCount) {
        this.clickCount = clickCount;
        return this;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public InfoItemVisitDataStat startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public InfoItemVisitDataStat endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public VisitSource getSource() {
        return source;
    }

    public InfoItemVisitDataStat source(VisitSource source) {
        this.source = source;
        return this;
    }

    public void setSource(VisitSource source) {
        this.source = source;
    }

    public String getTermimal() {
        return termimal;
    }

    public InfoItemVisitDataStat termimal(String termimal) {
        this.termimal = termimal;
        return this;
    }

    public void setTermimal(String termimal) {
        this.termimal = termimal;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public InfoItemVisitDataStat replyCount(Integer replyCount) {
        this.replyCount = replyCount;
        return this;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public InfoItemVisitDataStat starCount(Integer starCount) {
        this.starCount = starCount;
        return this;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoItemVisitDataStat)) {
            return false;
        }
        return id != null && id.equals(((InfoItemVisitDataStat) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "InfoItemVisitDataStat{" +
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
