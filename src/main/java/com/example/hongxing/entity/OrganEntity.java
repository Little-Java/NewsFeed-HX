package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class OrganEntity {

    @TableField(value = "ogid")
    private String ogId;

    @TableField(value = "ogname")
    private String ogName;

    @TableField(value = "oglogourl")
    private Integer ogLogoUrl;

    @TableField(value = "ogurl")
    private String ogUrl;

    @TableField(value = "ogsign")
    private Integer ogSign;

    @TableField(value = "ogremark")
    private String ogRemark;

    @TableField(value = "ogindex")
    private Integer ogIndex;

    @TableField(value = "ariflag")
    private Integer ariFlag;

    @TableField(value = "organkind")
    private Integer organKind;

    @TableField(value = "phone")
    private String phone;

    public String getOgId() {
        return ogId;
    }

    public void setOgId(String ogId) {
        this.ogId = ogId;
    }

    public String getOgName() {
        return ogName;
    }

    public void setOgName(String ogName) {
        this.ogName = ogName;
    }

    public Integer getOgLogoUrl() {
        return ogLogoUrl;
    }

    public void setOgLogoUrl(Integer ogLogoUrl) {
        this.ogLogoUrl = ogLogoUrl;
    }

    public String getOgUrl() {
        return ogUrl;
    }

    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    public Integer getOgSign() {
        return ogSign;
    }

    public void setOgSign(Integer ogSign) {
        this.ogSign = ogSign;
    }

    public String getOgRemark() {
        return ogRemark;
    }

    public void setOgRemark(String ogRemark) {
        this.ogRemark = ogRemark;
    }

    public Integer getOgIndex() {
        return ogIndex;
    }

    public void setOgIndex(Integer ogIndex) {
        this.ogIndex = ogIndex;
    }

    public Integer getAriFlag() {
        return ariFlag;
    }

    public void setAriFlag(Integer ariFlag) {
        this.ariFlag = ariFlag;
    }

    public Integer getOrganKind() {
        return organKind;
    }

    public void setOrganKind(Integer organKind) {
        this.organKind = organKind;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
