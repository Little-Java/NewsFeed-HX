package com.example.hongxing.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("TOPIC")
@Data
public class TopicEntity {

    @TableField(value = "TOPICID")
    private Integer topicId;            //专题Id

    @TableField(value = "TOPICNAME")
    private String topicName;           //专题名称

    @TableField(value = "TYPEID")
    private Integer typeId;             //1-站点；2-专题

    @TableField(value = "ROOTSUBJECTINDEX")
    private Integer rootSubjectIndex;   //根栏目，不可与其它站点的根栏目相同

    @TableField(value = "LP")
    private String lp;                  //首页左边栏目位置。为多个sbIndex，之间用"，"分割

    @TableField(value = "RP")
    private String rp;                  //首页右边栏目位置。为多个sbIndex，之间用"，"分割

    @TableField(value = "CP")
    private String cp;                  //首页中间栏目位置。为多个sbIndex，之间用"，"分割

    //============================================================================
    /**
    private String cssPath;             //css路径

    private Integer visitCount;         //访问技术

    private Integer isShow;             //是否显示（对子站无意义）        --已经不需要

    private Integer isShowHomePage;     //是否显示在首页（对子站无意义）--已经不需要

    private Integer showOrder;          //首页显示顺序（对子站无意义）--已经不需要

    private String LP;                  //首页左边栏目位置。为多个sbIndex，之间用"，"分割

    private String RP;                  //首页右边栏目位置。为多个sbIndex，之间用"，"分割

    private String CP;                  //首页中间栏目位置。为多个sbIndex，之间用"，"分割

    private Integer topPic;             //Top图片

    private Integer logoPic;            //首页显示的logo图片

    private Integer isCommonTopic;      //普通专题--当为普通专题是,套用普通专题的模版显示  --已经不需要

    private Integer siteId;             //所属site

    private Integer isFloatPic;         //浮动图片设置

    private Integer floatPic;           //浮动图片

    private String floatPicLink;        //浮动图片链接

    private String mainPath;            //根目录

    private Integer cpCount;            //中间栏目数量--有些站点通过初始化该值来限制设置在首页上的栏目数量，防止首页版式乱

    private String navigationPath;      //模板：导航条模版路径

    private String subject;             //模板：栏目模版路径

    private String articleListPath;     //模板：文章列表模版路径（带分页）

    private String articlePath;         //模板：单篇文章模版路径

    private String includeBottonmPath;  //模板：首页页脚模版路径（政工网）

    private String subMainPath;         //模板：首页路径

    private String positionPath;        //模板：栏目当前位置模版路径

    private String lastUpdateArticlePath;       //模板：最新更新文章列表模版路径（政工网）

    private String navigation2Path;     //模板：网站导航（底部）模版路径（政工网）

    private String focusNewsPath;       //模板：焦点新闻模版路径

    private String noticeListPath;      //模板：最新公告模版路径（政工网右上角）

    private String homepageArticleListSubject;  //模板：首页上表现为文章列表的栏目，用","分隔（作用：当更新了这些栏目下的文章时候，需要重新生成首页）,不要了，直接取cp字段

    private String powerAlertPath;      //模板：电力预警（信息网）

    private String noticePath;          //模板：单篇公告阅读页面（信息网）

    private Integer isBar;              //是否需要设置网站的横条副

    private Integer barPic;             //横条幅图片

    private String barLink;             //横条幅链接地址

    private Integer iShowHotList;       //是否显示热点排行

    private Integer hotRows;            //热点排行条数

    private Integer newsRows1;          //中间新闻条数（第一排栏目）
    private Integer newsRows2;
    private Integer newsRows3;
    private Integer newsRows4;
    private Integer newsRows5;
    private Integer newsRows6;

    private Integer bmgjtjh;            //部门稿件统计显示行数

    private Integer topicType;          //类型：1-省公司站点；2-地市公司/直属单位站点；3-县公司站点；4-其他

    private String attachFilePath;      //该站点对应的附件存放目录

    private Integer isFloatPic2;        //浮动图片2设置

    private Integer FloatPic2;          //浮动图片2

    private String floatPicLink2;       //浮动图片2链接

    private String floatPicLink3;       //浮动图片3链接

    private Integer FloatPic3;          //浮动图片3

    private Integer isFloatPic3;        //浮动图片3设置
     **/

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRootSubjectIndex() {
        return rootSubjectIndex;
    }

    public void setRootSubjectIndex(Integer rootSubjectIndex) {
        this.rootSubjectIndex = rootSubjectIndex;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}
