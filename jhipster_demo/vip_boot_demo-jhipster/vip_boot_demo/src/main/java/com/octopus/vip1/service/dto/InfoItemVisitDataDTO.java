package com.octopus.vip1.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import com.octopus.vip1.domain.enumeration.VisitSource;

/**
 * A DTO for the {@link com.octopus.vip1.domain.InfoItemVisitData} entity.
 */
@ApiModel(description = "资讯信息访问记录.\n@author hw")
public class InfoItemVisitDataDTO implements Serializable {
    
    private Long id;

    /**
     * 访问用户
     */
    @ApiModelProperty(value = "访问用户")
    private String userId;

    /**
     * 设备号，对于手机就是IMEI
     */
    @ApiModelProperty(value = "设备号，对于手机就是IMEI")
    private String deviceNo;

    /**
     * 访问时间
     */
    @ApiModelProperty(value = "访问时间")
    private LocalDate date;

    private VisitSource source;

    /**
     * 访问行为，比如滑动，点击，停留
     */
    @ApiModelProperty(value = "访问行为，比如滑动，点击，停留")
    private String action;

    /**
     * 商品信息
     */
    @ApiModelProperty(value = "商品信息")
    private Long goods;

    /**
     * 终端类型
     */
    @ApiModelProperty(value = "终端类型")
    private String termimal;


    private Long streamItemId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public VisitSource getSource() {
        return source;
    }

    public void setSource(VisitSource source) {
        this.source = source;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getGoods() {
        return goods;
    }

    public void setGoods(Long goods) {
        this.goods = goods;
    }

    public String getTermimal() {
        return termimal;
    }

    public void setTermimal(String termimal) {
        this.termimal = termimal;
    }

    public Long getStreamItemId() {
        return streamItemId;
    }

    public void setStreamItemId(Long infoStreamItemId) {
        this.streamItemId = infoStreamItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InfoItemVisitDataDTO infoItemVisitDataDTO = (InfoItemVisitDataDTO) o;
        if (infoItemVisitDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), infoItemVisitDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InfoItemVisitDataDTO{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", deviceNo='" + getDeviceNo() + "'" +
            ", date='" + getDate() + "'" +
            ", source='" + getSource() + "'" +
            ", action='" + getAction() + "'" +
            ", goods=" + getGoods() +
            ", termimal='" + getTermimal() + "'" +
            ", streamItemId=" + getStreamItemId() +
            "}";
    }
}
