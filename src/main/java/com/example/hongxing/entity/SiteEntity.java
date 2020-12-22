package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("SITE")
public class SiteEntity {

    @TableField(value = "SITEID")
    private Integer siteId;             //站点Id

    @TableField(value = "SITENAME")
    private String siteName;            //站点名称

    @TableField(value = "STMANAGERSTYLE")
    private Integer stManagerStyle;     //样式风格？需要移到topic表

    @TableField(value = "MANAGER")
    private String manager;             //单位站点的管理员，可以多个，Users.USID用 , 分割

    @TableField(value = "DEPT")
    private Integer dept;               //ORGAN.ogrIndex，根组织机构，用于用户管理、栏目赋权时候过滤用 ；如果为0表示未设置，即全部用户

    @TableField(value = "ZONEID")
    private Integer zoneId;             //

    @TableField(value = "MANAGERBAK")
    private String managerBak;          //
}
