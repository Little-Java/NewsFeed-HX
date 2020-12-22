package com.example.hongxing.dto;

import java.util.Date;

public class ArticleDto {

    private Integer acId;                   //sn_articleID

    private String acPrimaryTitle;          //主标题

    private String acViceTitle;             //副标题

    private Date acIsSueDate;               //发布时间

    private String acTarget;                //打开位置 _self _blank

    private String acText;                  //内容

    private String acAuthor;                //作者

    private String acPicture;               //标题图片，如果要把此文章放至首页，此项不能为空

    private String acLinkUrl;               //如果是文章类型是链接,此处存储文章的连接

    private Integer acDisplay;              //焦点新闻（是否在首页醒目位置显示）0/1  默认：0

    private Integer acOrder;                //文章排队序号 默认：0

    private Integer acType;                 //文章内容类型(0.链接文章 1-发布内容 默认：1

    private Integer acUserId;               //拟稿人

    private Integer acSubIndex;             //所在栏目，对应subject表的SBINDEX字段

    private Integer acOgIndex;              //拟稿人所在机构

    private Date acDraftDate;               //拟稿时间

    private Integer acPublishFlag;          //1-发布；0-未发布

    private Integer acPicNum;               //文章里面图片的数量

    private Integer isTop;                  //是否置顶 0/1  默认：0

    private Integer topicId;                //所属站点ID--为了统计查询加速

    private String usName;                  //拟稿人名字

    private String writer;                  //作者

    private String companyName;             //融媒体需要的所在机构单位名称

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getAcPrimaryTitle() {
        return acPrimaryTitle;
    }

    public void setAcPrimaryTitle(String acPrimaryTitle) {
        this.acPrimaryTitle = acPrimaryTitle;
    }

    public String getAcViceTitle() {
        return acViceTitle;
    }

    public void setAcViceTitle(String acViceTitle) {
        this.acViceTitle = acViceTitle;
    }

    public Date getAcIsSueDate() {
        return acIsSueDate;
    }

    public void setAcIsSueDate(Date acIsSueDate) {
        this.acIsSueDate = acIsSueDate;
    }

    public String getAcTarget() {
        return acTarget;
    }

    public void setAcTarget(String acTarget) {
        this.acTarget = acTarget;
    }

    public String getAcText() {
        return acText;
    }

    public void setAcText(String acText) {
        this.acText = acText;
    }

    public String getAcAuthor() {
        return acAuthor;
    }

    public void setAcAuthor(String acAuthor) {
        this.acAuthor = acAuthor;
    }

    public String getAcPicture() {
        return acPicture;
    }

    public void setAcPicture(String acPicture) {
        this.acPicture = acPicture;
    }

    public String getAcLinkUrl() {
        return acLinkUrl;
    }

    public void setAcLinkUrl(String acLinkUrl) {
        this.acLinkUrl = acLinkUrl;
    }

    public Integer getAcDisplay() {
        return acDisplay;
    }

    public void setAcDisplay(Integer acDisplay) {
        this.acDisplay = acDisplay;
    }

    public Integer getAcOrder() {
        return acOrder;
    }

    public void setAcOrder(Integer acOrder) {
        this.acOrder = acOrder;
    }

    public Integer getAcType() {
        return acType;
    }

    public void setAcType(Integer acType) {
        this.acType = acType;
    }

    public Integer getAcUserId() {
        return acUserId;
    }

    public void setAcUserId(Integer acUserId) {
        this.acUserId = acUserId;
    }

    public Integer getAcSubIndex() {
        return acSubIndex;
    }

    public void setAcSubIndex(Integer acSubIndex) {
        this.acSubIndex = acSubIndex;
    }

    public Integer getAcOgIndex() {
        return acOgIndex;
    }

    public void setAcOgIndex(Integer acOgIndex) {
        this.acOgIndex = acOgIndex;
    }

    public Date getAcDraftDate() {
        return acDraftDate;
    }

    public void setAcDraftDate(Date acDraftDate) {
        this.acDraftDate = acDraftDate;
    }

    public Integer getAcPublishFlag() {
        return acPublishFlag;
    }

    public void setAcPublishFlag(Integer acPublishFlag) {
        this.acPublishFlag = acPublishFlag;
    }

    public Integer getAcPicNum() {
        return acPicNum;
    }

    public void setAcPicNum(Integer acPicNum) {
        this.acPicNum = acPicNum;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
