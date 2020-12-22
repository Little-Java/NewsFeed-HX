package com.example.hongxing.dto;

public class TopicDto {

    private Integer topicId;            //专题Id

    private String topicName;           //专题名称

    private String LP;                  //首页左边栏目位置。为多个sbIndex，之间用"，"分割

    private String RP;                  //首页右边栏目位置。为多个sbIndex，之间用"，"分割

    private String CP;                  //首页中间栏目位置。为多个sbIndex，之间用"，"分割

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

    public String getLP() {
        return LP;
    }

    public void setLP(String LP) {
        this.LP = LP;
    }

    public String getRP() {
        return RP;
    }

    public void setRP(String RP) {
        this.RP = RP;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }
}
