package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("SUBJECT")
@Data
public class SubjectEntity {

    @TableField(value = "SBID")
    private String sbId;                //栏目Id

    @TableField(value = "SBNAME")
    private String sbName;              //栏目名称

    @TableField(value = "SBINDEX")
    private Integer sbIndex;            //栏目标识号 (SN_MAINID)

    /*private String sbLogoUrl;           //logo图片

    private String sbLogoPlace;         //

    private String sbLabelUrl;          //栏 目 图 片(栏目设置在首页时候生效.比如现在电力信息网和政工网的左边栏目)

    private String sbUrl;               //

    private String sbTarget;            //目标窗口(_self；_blank)

    private Integer sbSign;             //1 隐藏0显示

    private String sbRemark;            //

    private String sbPosition;          //现用于：默认为0.如果为1，则表示点击该栏目的父栏目时候默认访问该子栏目

    private Integer sbType;             //0 普通栏目 1链接栏目

    private Integer sbFlowType;         //0即时发布 1一审 2二审

    private Integer sbSiteId;           //站点栏目ID

    private Integer isSigleInfo;        //1-本栏目单条信息;0-普通栏目

    private String sbDrafter;           //本栏目的文章拟稿人员，以逗号分隔

    private String sbAuditionger;       //本栏目的文章一级审核人员，以逗号分隔

    private String sbFinalAuditinger;   //本栏目的文章终极审核人员，以逗号分隔

    private Integer ariFlag;            //运算标志

    private String sbAdminer;           //本栏目管理人员，以逗号分隔

    private Integer visitCount;         //计数--

    private Integer isShowCount;        //是否显示

    private Integer pageCount;          //最多显示多少页

    private Integer isEncrypt;          //是否加密1-加密

    private String password;            //密码

    private Integer isNeedCreate;       //1-需要定时对该栏目下的分页列表静态生成；0-需要定时对该栏目下的分页列表静态生成
                                        // （有文章发布后，定时生成前为1，生成后为0）

    private Integer isZT;               //是否为专题，专题不纳入部门的稿件统计中
    */

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public Integer getSbIndex() {
        return sbIndex;
    }

    public void setSbIndex(Integer sbIndex) {
        this.sbIndex = sbIndex;
    }
}
