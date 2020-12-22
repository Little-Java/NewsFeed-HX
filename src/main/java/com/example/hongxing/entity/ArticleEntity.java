package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("ARTICLE")
@Data
public class ArticleEntity {

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

    /********************************************************************/

    private String acKey;                   //关键字 默认：0

    private String acPageSize;              //每页显示的字数 默认：0

    private Integer acProviderId;           //摘自..(没有用)------目前把它作为是否套用格式显示的标志 默认：1

    private Integer acSign;                 //0-隐藏 1显示   默认：1

    private Integer acCount;                //访问数 默认：0

    private Integer acAuditing;             //标记 0拟稿 1一审 2二审 3发布 默认：1

    private Integer acRecommend;            //重要更新--原来政工网使用 0/999 默认：0

    private Integer acScroll;               //滚动（原来）-->是否套用标准格式显示。如果套用，则显示标题，日期，作者等，否则只显示录入的内容 默认：0

    private Integer acDeleteFlag;           //1逻辑删除标记 0正常 默认：0

    private Integer acFauditer;             //一审人  ''

    private Integer acSauditer;             //二审人  ''

    private String acPicName;               //文章里面图片的名称

    private String acAttacheName;           //文章附件上传到服务器后的名称

    private String acOldAttAcheName;        //文章附件上传前的名称

    private String acPreTitle;              //引题

    private String fContenId;               //门户内容ID ''/-1  默认''

    private Date deleteDate;                //删除日期 默认''

    private Integer isBz;                   //修改过的数据 ''/2 默认：''
}
