package com.octopus.vip1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

import com.octopus.vip1.domain.enumeration.VisitSource;

/**
 * 资讯信息访问记录.\n@author hw
 */
@Entity
@Table(name = "info_item_visit_data")
public class InfoItemVisitData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 访问用户
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 设备号，对于手机就是IMEI
     */
    @Column(name = "device_no")
    private String deviceNo;

    /**
     * 访问时间
     */
    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private VisitSource source;

    /**
     * 访问行为，比如滑动，点击，停留
     */
    @Column(name = "action")
    private String action;

    /**
     * 商品信息
     */
    @Column(name = "goods")
    private Long goods;

    /**
     * 终端类型
     */
    @Column(name = "termimal")
    private String termimal;

    @ManyToOne
    @JsonIgnoreProperties("infoItemVisitData")
    private InfoStreamItem streamItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public InfoItemVisitData userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public InfoItemVisitData deviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
        return this;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public InfoItemVisitData date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public VisitSource getSource() {
        return source;
    }

    public InfoItemVisitData source(VisitSource source) {
        this.source = source;
        return this;
    }

    public void setSource(VisitSource source) {
        this.source = source;
    }

    public String getAction() {
        return action;
    }

    public InfoItemVisitData action(String action) {
        this.action = action;
        return this;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getGoods() {
        return goods;
    }

    public InfoItemVisitData goods(Long goods) {
        this.goods = goods;
        return this;
    }

    public void setGoods(Long goods) {
        this.goods = goods;
    }

    public String getTermimal() {
        return termimal;
    }

    public InfoItemVisitData termimal(String termimal) {
        this.termimal = termimal;
        return this;
    }

    public void setTermimal(String termimal) {
        this.termimal = termimal;
    }

    public InfoStreamItem getStreamItem() {
        return streamItem;
    }

    public InfoItemVisitData streamItem(InfoStreamItem infoStreamItem) {
        this.streamItem = infoStreamItem;
        return this;
    }

    public void setStreamItem(InfoStreamItem infoStreamItem) {
        this.streamItem = infoStreamItem;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InfoItemVisitData)) {
            return false;
        }
        return id != null && id.equals(((InfoItemVisitData) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "InfoItemVisitData{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", deviceNo='" + getDeviceNo() + "'" +
            ", date='" + getDate() + "'" +
            ", source='" + getSource() + "'" +
            ", action='" + getAction() + "'" +
            ", goods=" + getGoods() +
            ", termimal='" + getTermimal() + "'" +
            "}";
    }
}
